package com.jbs.JobbSokerDig.viewLogic;


import com.jbs.JobbSokerDig.company.CompAndBen;
import com.jbs.JobbSokerDig.company.OpenPosition;
import com.jbs.JobbSokerDig.company.QualificationNeed;
import com.jbs.JobbSokerDig.repositorys.OpenPositionRepository;
import com.jbs.JobbSokerDig.service.OpenPositionService;
import com.jbs.JobbSokerDig.user.UserCandidate;
import com.jbs.JobbSokerDig.user.UserPreference;
import com.jbs.JobbSokerDig.user.UserQualification;
import com.jbs.JobbSokerDig.values.Benefit;
import com.jbs.JobbSokerDig.values.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class ViewLogic {

    @Autowired
    private OpenPositionRepository openPositionRepository;

    @Autowired
    private OpenPositionService openPositionService;

    public List<List<Qualification>> splitQualificationList(List<Qualification> bigList, int innerSize) {

        int size = bigList.size();
        List<List<Qualification>> parts = new ArrayList<List<Qualification>>();

        for (int i = 0; i < size; i += innerSize) {
            parts.add(new ArrayList<Qualification>(bigList.subList(i, Math.min(size, i + innerSize))));
        }

        return parts;
    }


    public List<List<Benefit>> splitBenefitList(List<Benefit> bigList, int innerSize) {

        int size = bigList.size();
        List<List<Benefit>> parts = new ArrayList<List<Benefit>>();

        for (int i = 0; i < size; i += innerSize) {
            parts.add(new ArrayList<Benefit>(bigList.subList(i, Math.min(size, i + innerSize))));
        }

        return parts;
    }

    public List<Qualification> checkQualificationsAgainstOpenPositionQualifications(Long openPositionId, List<Qualification> qualifications) {
        List<QualificationNeed> openPositionQualifications = getCurrentOpenPositionQualifications(openPositionId);

        List<Qualification> rL = qualifications;



        for (QualificationNeed qN : openPositionQualifications) {
            for (int j = 0; j < qualifications.size(); j++) {
                if (qN.getQualification().getQualificationId().equals(qualifications.get(j).getQualificationId())) {
                    rL.remove(j);
                }
            }
        }
        return rL;
    }
    public List<Benefit> checkBenefitsAgainstOpenPositionBenefits(Long openPositionId, List<Benefit> benefits) {
        List<CompAndBen> openPositionBenefits = getCurrentOpenPositionBenefits(openPositionId);
        List<Benefit> rL = benefits;

        for (CompAndBen oB : openPositionBenefits) {
            for (int j = 0; j < benefits.size(); j++) {
                if (oB.getBenefit().getBenefit().equals(benefits.get(j).getBenefit())) {
                    rL.remove(j);
                }
            }
        }
        return rL;
    }

//    public UserCandidate getCurrentUserCandidate(HttpServletRequest request) {
//        UserCandidate userCandidate = userCandidateService.getUserCandidate(request);
//        return userCandidate;
//    }
//
    public List<QualificationNeed> getCurrentOpenPositionQualifications(Long openPositionId) {
        List<QualificationNeed> openPositonQualifications = openPositionService.getOpenPositionQualification(openPositionId);
        return openPositonQualifications;
    }
    public List<CompAndBen> getCurrentOpenPositionBenefits(Long openPositionId) {
        List<CompAndBen> openPositionBenefits = openPositionService.getOpenPositionBenefits(openPositionId);
        return openPositionBenefits;
    }

}
