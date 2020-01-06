package com.jbs.JobbSokerDig.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    @GetMapping("/userMain")
    public String getUserMain(){

        return "userMain";
    }

    @GetMapping("/userProfile")
    public String getUserProfile(){

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
