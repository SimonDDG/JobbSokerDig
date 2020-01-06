package com.jbs.JobbSokerDig;

import com.jbs.JobbSokerDig.repositorys.LoginDetails;
import com.jbs.JobbSokerDig.repositorys.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @Autowired
    LoginRepository repo;

    @GetMapping("/test")
    public LoginDetails getIndex(){

        LoginDetails test = new LoginDetails(null, "test", "test");
        repo.save(test);
        return test;
    }

    @GetMapping("/test2")
    public Long test2(){
        Long count = repo.count();
        return count;
    }

}
