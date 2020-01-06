package com.jbs.JobbSokerDig.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyViewController {

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

    @GetMapping("/companyCreateOffer")
    public String getCompanyCreateOffer() {

        return "companyCreateOffer";
    }

    @GetMapping("/listCandidate")
    public String getListCandidate(){

        return "listCandidate";
    }
}