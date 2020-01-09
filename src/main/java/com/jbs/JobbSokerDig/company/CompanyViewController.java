package com.jbs.JobbSokerDig.company;

import com.jbs.JobbSokerDig.service.BenefitService;
import com.jbs.JobbSokerDig.service.CompanyService;
import com.jbs.JobbSokerDig.service.QualificationService;
import com.jbs.JobbSokerDig.values.Benefit;
import com.jbs.JobbSokerDig.values.Qualification;
import com.jbs.JobbSokerDig.viewLogic.ViewLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CompanyViewController {

    @Autowired
    CompanyService companyService;

    @Autowired
    QualificationService qualificationService;

    @Autowired
    BenefitService benefitService;

    @Autowired
    ViewLogic viewLogic;

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

        List<Qualification> qualifications = qualificationService.getAllQualifications();
        List<List<Qualification>> qualificationBigList = viewLogic.splitQualificationList(qualifications, 5);
        model.addAttribute("qualificationBigList", qualificationBigList);

        List<Benefit> benefits = benefitService.getAllBenefits();
        List<List<Benefit>> benefitBigList = viewLogic.splitBenefitList(benefits, 5);
        model.addAttribute("benefitBigList", benefitBigList);

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
