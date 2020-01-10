package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.company.SoftOffer;
import com.jbs.JobbSokerDig.service.*;
import com.jbs.JobbSokerDig.values.Benefit;
import com.jbs.JobbSokerDig.values.Qualification;
import com.jbs.JobbSokerDig.viewLogic.ViewLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserViewController {

    @Autowired
    UserCandidateService userCandidateService;

    @Autowired
    UserQualificationService userQualificationService;

    @Autowired
    UserPreferenceService userPreferenceService;

    @Autowired
    SoftOfferService softOfferService;

    @Autowired
    QualificationService qualificationService;

    @Autowired
    BenefitService benefitService;

    @Autowired
    ViewLogic viewLogic;

    @GetMapping("/userMain")
    public String getUserMain(){

        return "userMain";
    }

    @GetMapping("/userProfile")
    public String getUserProfile(HttpServletRequest request, Model model){

        UserCandidate userCandidate = getCurrentUserCandidate(request);
        model.addAttribute("userCandidate", userCandidate);

        List<UserQualification> userQualification = getCurrentUserCandidateQualifications(userCandidate);
        model.addAttribute("userQualification", userQualification);

        List<UserPreference> userPreference = userPreferenceService.getUserPreference(userCandidate.getUserCandidateId());
        model.addAttribute("userPreference", userPreference);

        String test = userPreference.get(0).benefit.getBenefit();

        System.out.println(test);

        return "userProfile";
    }

    @GetMapping("/userEditProfile")
    public String getEditUserProfile(HttpServletRequest request, Model model) {
        UserCandidate userCandidate = getCurrentUserCandidate(request);

        List<UserQualification> userQualification = getCurrentUserCandidateQualifications(userCandidate);
        model.addAttribute("userQualification", userQualification);

        List<Qualification> qualifications = qualificationService.getAllQualifications();
        List<Qualification> checkedQualificationsList = checkQualificationsAgainstUserCandidateQualifications(userCandidate, qualifications);

        List<List<Qualification>> splittedQualifications = viewLogic.splitQualificationList(checkedQualificationsList, 5);
        model.addAttribute("splittedQualifications", splittedQualifications);

        List<Benefit> benefits = benefitService.getAllBenefits();
        List<List<Benefit>> splittedBenefits = viewLogic.splitBenefitList(benefits, 5);
        model.addAttribute("splittedBenefits", splittedBenefits);



        return "userEditProfile";
    }

    private List<Qualification> checkQualificationsAgainstUserCandidateQualifications(UserCandidate userCandidate, List<Qualification> qualifications) {

        List<UserQualification> userQualification = getCurrentUserCandidateQualifications(userCandidate);
        System.out.println("SKRIVER VI UT USER QAL LISTAN?!" + userQualification);

        List<Qualification> rL = qualifications;



        for (UserQualification uq : userQualification) {
            for (int j = 0; j < qualifications.size(); j++) {
                System.out.println("PRINTAR VARJE UQ " + uq.getUserQualification().getQualification());
                System.out.println("PRINTAR VARJE SQ " + qualifications.get(j).getQualification());
                if (uq.getUserQualification().getQualification().equals(qualifications.get(j).getQualification())) {
                    System.out.println("PRINTAR VARJE UQ2 " + uq.getUserQualification().getQualification());
                    System.out.println("PRINTAR VARJE SQ2 " + qualifications.get(j).getQualification());
                    rL.remove(j);

                }
            }
        }
        System.out.println("DETTA AER RETURNLISTEN!!" + rL);
        return rL;
    }


    @GetMapping("/userMyOffers")
    public String getUserMyOffers(HttpServletRequest request, Model model) {

        List<SoftOffer> softOffers = softOfferService.getSoftOfferForUser(getCurrentUserCandidate(request).getUserCandidateId());
        model.addAttribute("softOffers", softOffers);

        return "userMyOffers";
    }

    private UserCandidate getCurrentUserCandidate(HttpServletRequest request) {
        UserCandidate userCandidate = userCandidateService.getUserCandidate(request);
        return userCandidate;
    }

    private List<UserQualification> getCurrentUserCandidateQualifications(UserCandidate userCandidate) {
        List<UserQualification> userQualification = userQualificationService.getUserQualification(userCandidate.getUserCandidateId());
        return userQualification;
    }
}
