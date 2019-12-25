package com.jbs.JobbSokerDig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


    @GetMapping("/")
    public String getIndex() {

        return "index";
    }

    @GetMapping("/login")
    public String getLogin(){

        return "login";
    }

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

    @GetMapping("/companyMain")
    public String getCompanyMain(){

        return "companyMain";
    }

    @GetMapping("/companyProfile")
    public String getCompanyProfile() {

        return  "companyProfile";
    }

    @GetMapping("/companyEditProfile")
    public String getCompanyEditProfile() {

        return "companyEditProfile";
    }

    @GetMapping("/listCandidate")
    public String getListCandidate(){

        return "listCandidate";
    }

}
