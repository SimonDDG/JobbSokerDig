package com.jbs.JobbSokerDig.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralViewController {

    @GetMapping("/")
    public String getIndex() {

        return "index";
    }

    @GetMapping("/login")
    public String getLogin(){

        return "login";
    }

    @GetMapping("/aboutUs")
    public String getAboutUs(){

        return "aboutUs";
    }
}
