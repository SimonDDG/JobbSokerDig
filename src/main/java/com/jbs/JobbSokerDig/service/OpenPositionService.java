package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.company.Company;
import com.jbs.JobbSokerDig.company.OpenPosition;
import com.jbs.JobbSokerDig.company.QualificationNeed;
import com.jbs.JobbSokerDig.repositorys.CompanyRepository;
import com.jbs.JobbSokerDig.repositorys.OpenPositionRepository;
import com.jbs.JobbSokerDig.repositorys.QualificationNeedRepository;
import com.jbs.JobbSokerDig.values.Qualification;
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

    @Autowired
    CompanyService companyService;

    @Autowired
    QualificationNeedRepository qualificationNeedRepository;

    public Company getCompany(HttpServletRequest request) {
        String username = request.getRemoteUser();
        return companyRepository.getCompanyRepo(username);
    }

    public Company getCompanyByUsername(String username) {
        return companyRepository.getCompanyRepo(username);
    }


    //inte klart
    public List<OpenPosition> getOpenPositionsByCompanyId(HttpServletRequest request) {

        Company company = companyRepository.getCompanyRepo(request.getRemoteUser());
        List<OpenPosition> openPositionsLoggedInCompany = openPositionRepository.getAllOpenPositionsByCompanyId(company.getCompanyId());

        company.getCompanyId();
        return openPositionsLoggedInCompany;
    }

    public List<OpenPosition> getAllOpenPositions() {
        return (List)openPositionRepository.findAll();
    }

    public List<QualificationNeed> getOpenPositionQualification(Long openPosition) {
        List<QualificationNeed> openPositionQualifications = qualificationNeedRepository.getAllQualificationsByOpenPositionId(openPosition);

        return openPositionQualifications;
    }
}
