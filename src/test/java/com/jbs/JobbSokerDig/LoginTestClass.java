package com.jbs.JobbSokerDig;


import com.jbs.JobbSokerDig.general.Login;
import com.jbs.JobbSokerDig.repositorys.LoginRepository;
import com.jbs.JobbSokerDig.service.UserCandidateService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTestClass {

    @Autowired
    LoginRepository loginRepository;

//    @Autowired
//    UserCandidateService service;

    @Test
    void contextLoads() {
    }


//    @Test
//    public void LoginTest() {
//        Login login = loginRepository.findByUsername("user");
//
//        Assert.assertEquals("user", login.getUsername().trim());
//    }

//    @Test
//    public void returnUserNameTest() {
//        service.getUserCandidateFullName();
//
//    }
}
