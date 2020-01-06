package com.jbs.JobbSokerDig.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GeneralFunctionController {

    @GetMapping("/successLogin")
    public String successRedirect(HttpServletRequest request){
        if(request.isUserInRole("ROLE_USER")) {
            return "userMain";
        } else if (request.isUserInRole("ROLE_COMPANY")) {
            return "companyMain";
        } else {
            return "index";
        }
    }
}
