package com.jbs.JobbSokerDig.user;

import com.jbs.JobbSokerDig.service.UserQualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserFunctionController {

    @Autowired
    UserQualificationService userQualificationService;

    @PostMapping("/saveUserSettings")
    public String saveUserProfile(HttpServletRequest request, @RequestParam(value = "checkboxName", required = false) String[] qualificationIds) {

        userQualificationService.saveUserQualificationChoice(qualificationIds, request);

        return "redirect:/userEditProfile";
    }

    @PostMapping("/saveUserMustHave")
    public String saveUserMustHave(HttpServletRequest request, @RequestParam(value = "checkboxName", required = false) String[] mustHaves) {

        for (int i = 0; i < mustHaves.length; i++) {
            System.out.println("must: " + mustHaves[i]);
        }
        System.out.println("----");

        return "redirect:/userEditProfile";
    }

    @PostMapping("/saveUserOptionalPreference")
    public String saveUserOptionalPreference(HttpServletRequest request, @RequestParam(value = "checkboxName", required = false) String[] optionalPreferences) {

        for (int i = 0; i < optionalPreferences.length; i++) {
            System.out.println("opt: " + optionalPreferences[i]);
        }
        System.out.println("----");

        return "redirect:/userEditProfile";
    }
    
}
