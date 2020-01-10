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

        UserCandidate userCandidate = userCandidateService.getUserCandidate(request);
        model.addAttribute("userCandidate", userCandidate);

        List<UserQualification> userQualification = userQualificationService.getUserQualification(userCandidate.getUserCandidateId());
        model.addAttribute("userQualification", userQualification);

        List<UserPreference> userPreference = userPreferenceService.getUserPreference(userCandidate.getUserCandidateId());
        model.addAttribute("userPreference", userPreference);

        String test = userPreference.get(0).benefit.getBenefit();

        System.out.println(test);

        return "userProfile";
    }

    @GetMapping("/userEditProfile")
    public String getEditUserProfile(HttpServletRequest request, Model model) {
        UserCandidate userCandidate = userCandidateService.getUserCandidate(request);

        List<UserQualification> userQualification = userQualificationService.getUserQualification(userCandidate.getUserCandidateId());
        model.addAttribute("userQualification", userQualification);

        List<Qualification> qualifications = qualificationService.getAllQualifications();

        List<Qualification> checkedQualificationsList = checkQualificationsAgainstUserCandidateQualifications(request, qualifications);

        List<List<Qualification>> splittedQualifications = viewLogic.splitQualificationList(checkedQualificationsList, 5);

        model.addAttribute("splittedQualifications", splittedQualifications);

        List<Benefit> benefits = benefitService.getAllBenefits();
        List<List<Benefit>> splittedBenefits = viewLogic.splitBenefitList(benefits, 5);
        model.addAttribute("splittedBenefits", splittedBenefits);



        return "userEditProfile";
    }

    private List<Qualification> checkQualificationsAgainstUserCandidateQualifications(HttpServletRequest request, List<Qualification> qualifications) {
        UserCandidate userCandidate = userCandidateService.getUserCandidate(request);

        List<UserQualification> userQualification = userQualificationService.getUserQualification(userCandidate.getUserCandidateId());

        System.out.println("HIT KOMMER VI O SKRIVER UT LISTAN!!" + qualifications);

        List<Qualification> returnList = qualifications;
        System.out.println("DETTA AER RETURNLISTEN!!" + returnList);

        for (UserQualification uq : userQualification) {
            for (Qualification sq : returnList) {
                if (uq.getQualification().getQualification().equals(sq.getQualification())) {
                    returnList.remove(sq);


                }
            }
        }
        System.out.println(returnList);
        return returnList;
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
}
