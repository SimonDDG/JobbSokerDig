package com.jbs.JobbSokerDig.company;

import com.jbs.JobbSokerDig.service.OpenPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CompanyFunctionController {

    @Autowired
    OpenPositionService openPositionService;

    @PostMapping("/saveNewOpenPosition")
    public String saveNewOpenPosition(
            HttpServletRequest request,
            @RequestParam(value = "positionTitle", required = false) String positionTitle,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "qualificationId", required = false) String[] qualificationIds,
            @RequestParam(value = "benefitId", required = false) String[] benefitIds
    ){

        openPositionService.saveNewOpenPosition(request, positionTitle, description, qualificationIds, benefitIds);

        System.out.println("Pos title is: " + positionTitle);
        System.out.println("The description is: " + description);

        for (int i = 0; i < qualificationIds.length; i++) {
            System.out.println("Chosen qualification id: " + qualificationIds[i]);
        }

        for (int i = 0; i < benefitIds.length; i++) {
            System.out.println("Chosen benefit id: " + benefitIds[i]);
        }

        return "redirect:/companyOpenPositions";
    }

    @PostMapping("/savePositionQualifications")
    public String savePositionQual(@RequestParam(required = false, defaultValue = "0") String openPosId, @RequestParam(value = "checkboxName", required = false) String[] newCompanyOpenPos) {

        for (int i = 0; i < newCompanyOpenPos.length; i++) {
            System.out.println(newCompanyOpenPos[i]);
        }

        openPositionService.updateOpenPositionQualifications(newCompanyOpenPos, openPosId);

        return "redirect:/companyOpenPositions?openPositionId=" + openPosId;
    }
    @PostMapping("/savePositionBenefits")
    public String savePositionBen(@RequestParam(required = false, defaultValue = "0") String openPosId, @RequestParam(value = "checkboxName", required = false) String[] newCompanyOpenPos) {

        System.out.println("BENEFIT Metoden kallas");

        for (int i = 0; i < newCompanyOpenPos.length; i++) {
            System.out.println(newCompanyOpenPos[i]);
        }

        openPositionService.updateOpenPositionBenefits(newCompanyOpenPos, openPosId);

        return "redirect:/companyOpenPositions?openPositionId=" + openPosId;
    }



}
