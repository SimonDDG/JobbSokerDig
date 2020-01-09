package com.jbs.JobbSokerDig.company;

import com.jbs.JobbSokerDig.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CompanyViewController {

    @Autowired
    CompanyService companyService;

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

    @GetMapping("/companyOpenPositions")
    public String getCompanyOpenPositions(HttpServletRequest request, Model model) {



        return "companyOpenPositions";
    }

    @GetMapping("/listCandidate")
    public String getListCandidate(){

        return "listCandidate";
    }

    private Company getCurrentCompany(HttpServletRequest request) {
        Company company = companyService.getCompany(request);
        return company;
    }
}
