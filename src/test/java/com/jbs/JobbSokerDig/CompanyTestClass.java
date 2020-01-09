package com.jbs.JobbSokerDig;

import com.jbs.JobbSokerDig.company.Company;
import com.jbs.JobbSokerDig.company.OpenPosition;
import com.jbs.JobbSokerDig.general.Login;
import com.jbs.JobbSokerDig.repositorys.CompanyRepository;
import com.jbs.JobbSokerDig.repositorys.LoginRepository;
import com.jbs.JobbSokerDig.repositorys.OpenPositionRepository;
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
    OpenPositionRepository openPositionRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCompanyObject() {
        List<Company> compList = (ArrayList)companyRepository.findAll();

        Assert.assertEquals("name of first company", "JSD testComp", compList.get(0).getName());

        List<OpenPosition> openPositionList = (ArrayList)openPositionRepository.findAll();
        Assert.assertEquals("JavaDeveloper", openPositionList.get(0).getOpenPositionName());


    }


}
