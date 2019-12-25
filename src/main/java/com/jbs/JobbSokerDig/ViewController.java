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

    @GetMapping("/profil")
    public String getProfil(){

        return "profil";
    }

    @GetMapping("/editProfile")
    public String getEditProfile() {

        return "editProfile";
    }

    @GetMapping("/userMain")
    public String getUserMain(){
        return "userMain";
    }

    @GetMapping("/companyMain")
    public String getCompanyMain(){

        return "companyMain";
    }

    @GetMapping("/listCandidate")
    public String getListCandidate(){
        return "listCandidate";
    }

    @GetMapping("/companyProfile")
    public String getCompanyProfile() {
        return  "companyProfile";
    }

}
