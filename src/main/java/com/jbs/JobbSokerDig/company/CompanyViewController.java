package com.jbs.JobbSokerDig.company;

import com.jbs.JobbSokerDig.repositorys.OpenPositionRepository;
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
    private CompanyService companyService;

    @Autowired
    private QualificationService qualificationService;

    @Autowired
    private BenefitService benefitService;

    @Autowired
    private ViewLogic viewLogic;

    @Autowired
    private UserCandidateService userCandidateService;

    @Autowired
    private UserPreferenceService userPreferenceService;

    @Autowired
    private UserQualificationService userQualificationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OpenPositionService openPositionService;

    @Autowired
    private MatchService matchService;

    @Autowired
    private OpenPositionRepository openPositionRepository;

    @Autowired
    private SoftOfferService softOfferService;

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
    public String getCompanyOpenPositions(@RequestParam(defaultValue = "0") Long openPositionId, HttpServletRequest request, Model model) {

        List<OpenPosition> allOpenPositionsForLogedInCompany = openPositionService.getOpenPositionsByCompanyId(request);
        model.addAttribute("allOpenPositions", allOpenPositionsForLogedInCompany);

        List<QualificationNeed> openPositionQualifications = viewLogic.getCurrentOpenPositionQualifications(openPositionId);
        model.addAttribute("openPositionQualifications", openPositionQualifications);

        OpenPosition currentOpenPosition = openPositionService.getCurrentOpenPosition(openPositionId);
        model.addAttribute("currentOpenPosition", currentOpenPosition);

        List<Qualification> qualifications = qualificationService.getAllQualifications();
        List<Qualification> checkedQualifications = viewLogic.checkQualificationsAgainstOpenPositionQualifications(openPositionId, qualifications);
        List<List<Qualification>> qualificationBigList = viewLogic.splitQualificationList(checkedQualifications, 5);
        model.addAttribute("qualificationBigList", qualificationBigList);

        List<CompAndBen> openPositionBenefits = viewLogic.getCurrentOpenPositionBenefits(openPositionId);
        model.addAttribute("openPositionBenefits", openPositionBenefits);
        List<Benefit> benefits = benefitService.getAllBenefits();
        List<Benefit> checkedBenefits = viewLogic.checkBenefitsAgainstOpenPositionBenefits(openPositionId, benefits);
        List<List<Benefit>> benefitBigList = viewLogic.splitBenefitList(checkedBenefits, 3);
        model.addAttribute("benefitBigList", benefitBigList);

        List<Qualification> allQualifications = qualificationService.getAllQualifications();
        List<List<Qualification>> allQualificationBigList = viewLogic.splitQualificationList(allQualifications, 5);
        model.addAttribute("allQualificationBigList", allQualificationBigList);

        List<Benefit> allBenefits = benefitService.getAllBenefits();
        List<List<Benefit>> allBenefitBigList = viewLogic.splitBenefitList(checkedBenefits, 3);
        model.addAttribute("allBenefitBigList", allBenefitBigList);

        return "companyOpenPositions";
    }

    @GetMapping("/listCandidate")
    public String getListCandidate(@RequestParam(defaultValue = "0") Long openPositionId, Model model){

        List<UserCandidate> userCandidateByHighestMatched = matchService.getCandidatesByHighestMatched(openPositionId);
        model.addAttribute("userCandidateByHighestMatched", userCandidateByHighestMatched);

        OpenPosition currentOpenPosition = openPositionService.getCurrentOpenPosition(openPositionId);
        model.addAttribute("currentOpenPosition", currentOpenPosition);

        List<OpenPosition> openPositions = openPositionService.getAllOpenPositions();
        model.addAttribute("openPositions", openPositions);

        List<SoftOffer> softOffers = softOfferService.getAllSoftOfeers();
        model.addAttribute("softOffers", softOffers);


        return "listCandidate";
    }

    @GetMapping("/userProfile/{username}")
    public String seeUserProfile(@PathVariable String username, Model model, HttpServletRequest request){

        Boolean userRole = request.isUserInRole("ROLE_COMPANY");
        model.addAttribute("userRole", userRole);

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
