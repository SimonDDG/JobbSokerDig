package com.jbs.JobbSokerDig.viewLogic;

import com.jbs.JobbSokerDig.service.UserCandidateService;
import com.jbs.JobbSokerDig.service.UserPreferenceService;
import com.jbs.JobbSokerDig.service.UserQualificationService;
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
public class UserEditProfileViewLogic {

    @Autowired
    private UserCandidateService userCandidateService;

    @Autowired
    private UserQualificationService userQualificationService;

    @Autowired
    private UserPreferenceService userPreferenceService;

    public List<Qualification> checkQualificationsAgainstUserCandidateQualifications(UserCandidate userCandidate, List<Qualification> qualifications) {
        List<UserQualification> userQualification = getCurrentUserCandidateQualifications(userCandidate);
        List<Qualification> rL = qualifications;



        for (UserQualification uq : userQualification) {
            for (int j = 0; j < qualifications.size(); j++) {
                if (uq.getUserQualification().getQualification().equals(qualifications.get(j).getQualification())) {
                    rL.remove(j);
                }
            }
        }
        return rL;
    }
    public List<Benefit> checkBenefitsAgainstUserCandidateBenefits(UserCandidate userCandidate, List<Benefit> benefits) {
        List<UserPreference> userBenefits = getCurrentUserCandidatePreference(userCandidate);
        List<Benefit> rL = benefits;

        for (UserPreference ub : userBenefits) {
            for (int j = 0; j < benefits.size(); j++) {
                if (ub.getBenefit().getBenefit().equals(benefits.get(j).getBenefit())) {
                    rL.remove(j);
                }
            }
        }
        return rL;
    }

    public List<UserPreference> checkUserMustHavePreferances (UserCandidate userCandidate, List<UserPreference> userPreferencesList) {
        List<UserPreference> rL = new ArrayList<>();
        for (UserPreference up: userPreferencesList) {
            if (up.getMustHave()) {
                rL.add(up);
            }
        }
        return  rL;
    }

    public List<UserPreference> isNotUserMustHavePreferances (UserCandidate userCandidate, List<UserPreference> userPreferencesList) {
        List<UserPreference> rL = new ArrayList<>();
        for (UserPreference up: userPreferencesList) {
            if (!up.getMustHave()) {
                rL.add(up);
            }
        }
        return  rL;
    }

    public UserCandidate getCurrentUserCandidate(HttpServletRequest request) {
        UserCandidate userCandidate = userCandidateService.getUserCandidate(request);
        return userCandidate;
    }

    public List<UserQualification> getCurrentUserCandidateQualifications(UserCandidate userCandidate) {
        List<UserQualification> userQualification = userQualificationService.getUserQualification(userCandidate.getUserCandidateId());
        return userQualification;
    }
    public List<UserPreference> getCurrentUserCandidatePreference(UserCandidate userCandidate) {
        List<UserPreference> userPreference = userPreferenceService.getUserPreference(userCandidate.getUserCandidateId());
        return userPreference;
    }

}
