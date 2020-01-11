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

//    @RequestMapping(value = "/saveUserSettings" , method = RequestMethod. POST)
//    public void editCustomer(@RequestParam(value = "checkboxName", required = false) String checkboxValue)
//    {
//        if(checkboxValue != null)
//        {
//            System.out.println("checkbox is checked");
//        }
//        else
//        {
//            System.out.println("checkbox is not checked");
//        }
//    }
}
