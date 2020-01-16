package com.jbs.JobbSokerDig;

import com.jbs.JobbSokerDig.repositorys.UserRepository;
import com.jbs.JobbSokerDig.user.UserCandidate;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserCandidateTestClass {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void userTest() {
//        UserCandidate userCandidate = userRepository.findByFullName("JSD User");
//
//        Assert.assertEquals("JSD User", userCandidate.getFullName());
//    }
}
