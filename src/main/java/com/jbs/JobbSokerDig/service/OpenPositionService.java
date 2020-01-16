package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.company.CompAndBen;
import com.jbs.JobbSokerDig.company.Company;
import com.jbs.JobbSokerDig.company.OpenPosition;
import com.jbs.JobbSokerDig.company.QualificationNeed;
import com.jbs.JobbSokerDig.repositorys.CompAndBenRepository;
import com.jbs.JobbSokerDig.repositorys.CompanyRepository;
import com.jbs.JobbSokerDig.repositorys.OpenPositionRepository;
import com.jbs.JobbSokerDig.repositorys.QualificationNeedRepository;
import com.jbs.JobbSokerDig.values.Benefit;
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
    QualificationService qualificationService;

    @Autowired
    BenefitService benefitService;

    @Autowired
    QualificationNeedRepository qualificationNeedRepository;

    @Autowired
    CompAndBenRepository compAndBenRepository;

    public Company getCompany(HttpServletRequest request) {
        String username = request.getRemoteUser();
        return companyRepository.getCompanyRepo(username);
    }

    public Company getCompanyByUsername(String username) {
        return companyRepository.getCompanyRepo(username);
    }



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

    public List<CompAndBen> getOpenPositionBenefits(Long openPosition) {
        List<CompAndBen> openPositionBenefits = compAndBenRepository.getAllCompAndBenByOpenPositionId(openPosition);

        return openPositionBenefits;
    }



public void saveNewOpenPosition(HttpServletRequest request, String positionTitle, String description, String[] qualificationIds, String[] benefitIds) {
        Company company = companyRepository.getCompanyRepo(request.getRemoteUser());
        createNewOpenPosition(company, positionTitle, description);

        OpenPosition openPosition = openPositionRepository.getOpenPositionByTitle(positionTitle);

        //GET Qualifications by id
        List<Long> qaIds = covertStringToLong(qualificationIds);
        List<Qualification> qualificationsNeeded = qualificationService.getQualificationListById(qaIds);

        List<QualificationNeed> newQualificationNeeds = new ArrayList<>();
        for (int i = 0; i < qualificationsNeeded.size(); i++) {
            newQualificationNeeds.add(new QualificationNeed(null, qualificationsNeeded.get(i), openPosition));
        }
        qualificationNeedRepository.saveAll(newQualificationNeeds);

        //GET Benefits by id
        List<Benefit> benefitsOffered = benefitService.getAllBenefitsById(benefitIds);

        List<CompAndBen> newCompAndBens = new ArrayList<>();
        for (int i = 0; i < benefitsOffered.size(); i++) {
            newCompAndBens.add(new CompAndBen(null, benefitsOffered.get(i), openPosition));
        }

        compAndBenRepository.saveAll(newCompAndBens);

    }



    private void createNewOpenPosition(Company company, String positionTitle, String description) {
        openPositionRepository.save(new OpenPosition(null, company, positionTitle, description));
    }

    public OpenPosition getCurrentOpenPosition(Long openPositionId) {
        OpenPosition currentOpenPosition = new OpenPosition();
        if (openPositionId > 0) {
            currentOpenPosition = openPositionRepository.getOneOpenPositionsByOpenPositionId(openPositionId);
            return currentOpenPosition;
        } else {
            currentOpenPosition.setOpenPositionName("Choose your position");
            return currentOpenPosition;
        }
    }

    public void updateOpenPositionQualifications(String[] newCompanyOpenPos, String openPosId) {


        List<Qualification> newQualificatios = qualificationService.getQualificationListById(covertStringToLong(newCompanyOpenPos));

        OpenPosition currentOpenPosition = openPositionRepository.getOneOpenPositionsByOpenPositionId(Long.parseLong(openPosId));

        List<QualificationNeed> oldQNeeds = qualificationNeedRepository.getAllQualificationsByOpenPositionId(Long.parseLong(openPosId));

        qualificationNeedRepository.deleteAll(oldQNeeds);

        for (int i = 0; i < newQualificatios.size(); i++) {
            qualificationNeedRepository.save(new QualificationNeed(null, newQualificatios.get(i), currentOpenPosition));
        }

    }
    public void updateOpenPositionBenefits(String[] newCompanyOpenPos, String openPosId) {


        List<Benefit> newBenefits = benefitService.getAllBenefitsById(newCompanyOpenPos);

        OpenPosition currentOpenPosition = openPositionRepository.getOneOpenPositionsByOpenPositionId(Long.parseLong(openPosId));

        List<CompAndBen> oldCAB = compAndBenRepository.getAllCompAndBenByOpenPositionId(Long.parseLong(openPosId));

        compAndBenRepository.deleteAll(oldCAB);

        for (int i = 0; i < newBenefits.size(); i++) {
            compAndBenRepository.save(new CompAndBen(null, newBenefits.get(i), currentOpenPosition));
        }

    }



    private List<Long> covertStringToLong(String[] ids) {
        List<Long> longIds = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            longIds.add(Long.parseLong(ids[i]));
        }
        return longIds;
    }
}
