package com.jbs.JobbSokerDig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String getIndex() {

        return "index";
    }

    @GetMapping("/profil")
    public String getProfil(){

        return "profil";
    }
}
