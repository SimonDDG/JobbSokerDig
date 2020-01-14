package com.jbs.JobbSokerDig.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyFunctionController {

    @PostMapping("/saveNewOpenPosition")
    public String saveNewOpenPosition(){

        System.out.println("Metod save kallad");

        return "redirect:/companyOpenPositions";
    }

}
