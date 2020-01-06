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

    @GetMapping("/aboutUs")
    public String getAboutUs(){

        return "aboutUs";
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

    @GetMapping("/userMyOffers")
    public String getUserMyOffers() {

        return "userMyOffers";
    }

//    @GetMapping("/companyMain")
//    public String getCompanyMain(){
//
//        return "companyMain";
//    }
//
//    @GetMapping("/companyProfile")
//    public String getCompanyProfile() {
//
//        return  "companyProfile";
//    }
//
//    @GetMapping("/companyEditProfile")
//    public String getCompanyEditProfile() {
//
//        return "companyEditProfile";
//    }
//
//    @GetMapping("/companyCreateOffer")
//    public String getCompanyCreateOffer() {
//
//        return "companyCreateOffer";
//    }
//
//    @GetMapping("/listCandidate")
//    public String getListCandidate(){
//
//        return "listCandidate";
//    }

}
