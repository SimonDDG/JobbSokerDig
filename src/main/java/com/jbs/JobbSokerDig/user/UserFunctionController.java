package com.jbs.JobbSokerDig.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserFunctionController {

    @PostMapping("/saveUserSettings")
    public String saveUserProfile(@RequestParam(value = "checkboxName", required = false) String[] checkboxValue) {

        System.out.println("testar");

        for (int i = 0; i < checkboxValue.length; i++) {
            System.out.println(checkboxValue[i]);
        }

        if(checkboxValue.length==3)
        {
            System.out.println("checkbox is checked");
        }
        else
        {
            System.out.println("checkbox is not checked");
        }

//        if(checkboxValue != null)
//        {
//            System.out.println("checkbox is checked");
//        }
//        else
//        {
//            System.out.println("checkbox is not checked");
//        }

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
