package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.company.SoftOffer;
import com.jbs.JobbSokerDig.service.*;
import com.jbs.JobbSokerDig.values.Benefit;
import com.jbs.JobbSokerDig.values.Qualification;
import com.jbs.JobbSokerDig.viewLogic.UserEditProfileViewLogic;
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

    @Autowired
    UserEditProfileViewLogic userEditProfileViewLogic;

    @GetMapping("/userMain")
    public String getUserMain(){

        return "userMain";
    }

    @GetMapping("/userProfile")
    public String getUserProfile(HttpServletRequest request, Model model){

        UserCandidate userCandidate = userEditProfileViewLogic.getCurrentUserCandidate(request);
        model.addAttribute("userCandidate", userCandidate);

        List<UserQualification> userQualification = userEditProfileViewLogic.getCurrentUserCandidateQualifications(userCandidate);
        model.addAttribute("userQualification", userQualification);

        List<UserPreference> userPreference = userPreferenceService.getUserPreference(userCandidate.getUserCandidateId());
        model.addAttribute("userPreference", userPreference);

        return "userProfile";
    }

    @GetMapping("/userEditProfile")
    public String getEditUserProfile(HttpServletRequest request, Model model) {
        UserCandidate userCandidate = userEditProfileViewLogic.getCurrentUserCandidate(request);

        List<UserQualification> userQualification = userEditProfileViewLogic.getCurrentUserCandidateQualifications(userCandidate);
        model.addAttribute("userQualification", userQualification);

        for (int i = 0; i < userQualification.size(); i++) {
            Long UserIdTest = userQualification.get(i).userCandidate.UserCandidateId;
            Long UserQTest = userQualification.get(i).userQualification.getQualificationId();
        }

        List<Qualification> qualifications = qualificationService.getAllQualifications();
        List<Qualification> checkedQualificationsList = userEditProfileViewLogic.checkQualificationsAgainstUserCandidateQualifications(userCandidate, qualifications);

        List<List<Qualification>> splittedQualifications = viewLogic.splitQualificationList(checkedQualificationsList, 5);
        model.addAttribute("splittedQualifications", splittedQualifications);

        List<UserPreference> userPreference = userPreferenceService.getUserPreference(userCandidate.getUserCandidateId());
        //model.addAttribute("userPreference", userPreference); //Old model used to display pref, before the "sort"

        List<Benefit> benefits = benefitService.getAllBenefits();
        List<Benefit> checkedBenefitsList = userEditProfileViewLogic.checkBenefitsAgainstUserCandidateBenefits(userCandidate, benefits);
        List<List<Benefit>> splittedBenefits = viewLogic.splitBenefitList(checkedBenefitsList, 5);
        model.addAttribute("splittedBenefits", splittedBenefits);

        List<UserPreference> userMustHaves = userEditProfileViewLogic.checkUserMustHavePreferances(userCandidate, userPreference);
        model.addAttribute("userMustHaves", userMustHaves);

        List<UserPreference> notUserMustHaves = userEditProfileViewLogic.isNotUserMustHavePreferances(userCandidate, userPreference);
        model.addAttribute("notUserMustHaves", notUserMustHaves);

        return "userEditProfile";
    }




    @GetMapping("/userMyOffers")
    public String getUserMyOffers(HttpServletRequest request, Model model) {

        List<SoftOffer> softOffers = softOfferService.getSoftOfferForUser(userEditProfileViewLogic.getCurrentUserCandidate(request).getUserCandidateId());
        model.addAttribute("softOffers", softOffers);

        return "userMyOffers";
    }


}
