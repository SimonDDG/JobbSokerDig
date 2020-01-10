package com.jbs.JobbSokerDig.company;

import com.jbs.JobbSokerDig.repositorys.UserRepository;
import com.jbs.JobbSokerDig.service.*;
import com.jbs.JobbSokerDig.user.UserCandidate;
import com.jbs.JobbSokerDig.user.UserPreference;
import com.jbs.JobbSokerDig.user.UserQualification;
import com.jbs.JobbSokerDig.values.Benefit;
import com.jbs.JobbSokerDig.values.Qualification;
import com.jbs.JobbSokerDig.viewLogic.ViewLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    UserCandidateService userCandidateService;

    @Autowired
    UserPreferenceService userPreferenceService;

    @Autowired
    UserQualificationService userQualificationService;

    @Autowired
    UserRepository userRepository;

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
    public String getListCandidate(Model model){

        List<UserCandidate> userObjectList = (List)userRepository.findAll();

        List<String> allUserLoginNames = userCandidateService.getAllUserLoginNames(userObjectList);
        System.out.println("hej" + allUserLoginNames);
        model.addAttribute("allUserObjects", userObjectList);

        return "listCandidate";
    }

    @GetMapping("/userProfile/{username}")
    public String seeUserProfile(@PathVariable String username, Model model){


        UserCandidate userCandidate = userCandidateService.getUserCandidateByUsername(username);
        model.addAttribute("userCandidate", userCandidate);

        List<UserQualification> userQualification = userQualificationService.getUserQualification(userCandidate.getUserCandidateId());
        model.addAttribute("userQualification", userQualification);

        List<UserPreference> userPreference = userPreferenceService.getUserPreference(userCandidate.getUserCandidateId());
        model.addAttribute("userPreference", userPreference);

        return "userProfile";
    }

    private Company getCurrentCompany(HttpServletRequest request) {
        Company company = companyService.getCompany(request);
        return company;
    }
}
