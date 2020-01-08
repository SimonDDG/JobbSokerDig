package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.service.UserCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserViewController {

    @Autowired
    UserCandidateService service;

    @GetMapping("/userMain")
    public String getUserMain(){

        return "userMain";
    }

    @GetMapping("/userProfile")
    public String getUserProfile(HttpServletRequest request, Model model){

        UserCandidate userCandidate = service.getUserCandidate(request);
        model.addAttribute("userCandidate", userCandidate);
        return "userProfile";
    }

    @GetMapping("/userEditProfile")
    public String getEditUserProfile() {

        return "userEditProfile";
    }

    @GetMapping("/userMyOffers")
    public String getUserMyOffers() {

        return "userMyOffers";
    }
}
