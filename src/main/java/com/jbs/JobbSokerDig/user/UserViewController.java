package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.company.SoftOffer;
import com.jbs.JobbSokerDig.service.SoftOfferService;
import com.jbs.JobbSokerDig.service.UserCandidateService;
import com.jbs.JobbSokerDig.service.UserPreferenceService;
import com.jbs.JobbSokerDig.service.UserQualificationService;
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



        return "userEditProfile";
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
