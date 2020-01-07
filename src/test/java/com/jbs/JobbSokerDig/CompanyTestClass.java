package com.jbs.JobbSokerDig;

import com.jbs.JobbSokerDig.company.Company;
import com.jbs.JobbSokerDig.general.Login;
import com.jbs.JobbSokerDig.repositorys.CompanyRepository;
import com.jbs.JobbSokerDig.repositorys.LoginRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CompanyTestClass {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    LoginRepository loginRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCompanyObject() {
        List<Company> compList = (ArrayList)companyRepository.findAll();

        Assert.assertEquals("name of first company", "JSD testComp", compList.get(0).getName());


    }

    @Test
    public void test() {
        Login login = loginRepository.findByUsername("user");

        Assert.assertEquals("user", login.getUsername().trim());
    }

}
