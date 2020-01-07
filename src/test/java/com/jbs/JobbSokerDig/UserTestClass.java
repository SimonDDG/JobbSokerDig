package com.jbs.JobbSokerDig;

import com.jbs.JobbSokerDig.repositorys.UserRepository;
import com.jbs.JobbSokerDig.user.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserTestClass {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void userTest() {
        User user = userRepository.findByFullName("JSD User");

        Assert.assertEquals("JSD User", user.getFullName());
    }
}
