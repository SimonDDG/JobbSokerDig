package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.company.Company;
import com.jbs.JobbSokerDig.company.OpenPosition;
import com.jbs.JobbSokerDig.repositorys.CompanyRepository;
import com.jbs.JobbSokerDig.repositorys.OpenPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpenPositionService {

    @Autowired
    OpenPositionRepository openPositionRepository;

    @Autowired
    CompanyRepository companyRepository;

    public Company getCompany(HttpServletRequest request) {
        String username = request.getRemoteUser();
        return companyRepository.getCompanyRepo(username);
    }

    public Company getCompanyByUsername(String username) {
        return companyRepository.getCompanyRepo(username);
    }


    //inte klart
    public List<OpenPosition> getAllOpenPositionsLoggedInCompany(List<OpenPosition> allOpenPositions) {
        List<OpenPosition> openPositionsLoggedInCompany = new ArrayList<>();

        for(int i = 0; i < allOpenPositions.size(); i++) {

        }
        return openPositionsLoggedInCompany;
    }


}
