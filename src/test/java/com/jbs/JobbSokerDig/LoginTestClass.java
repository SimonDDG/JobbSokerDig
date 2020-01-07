package com.jbs.JobbSokerDig;


import com.jbs.JobbSokerDig.general.Login;
import com.jbs.JobbSokerDig.repositorys.LoginRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTestClass {

    @Autowired
    LoginRepository loginRepository;

    @Test
    void contextLoads() {
    }


    @Test
    public void LoginTest() {
        Login login = loginRepository.findByUsername("user");

        Assert.assertEquals("user", login.getUsername().trim());
    }
}
