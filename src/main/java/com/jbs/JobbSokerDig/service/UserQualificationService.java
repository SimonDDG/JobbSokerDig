package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.repositorys.UserQualificationRepository;
import com.jbs.JobbSokerDig.user.UserCandidate;
import com.jbs.JobbSokerDig.user.UserQualification;
import com.jbs.JobbSokerDig.values.Qualification;
import com.jbs.JobbSokerDig.values.QualificationLevel;
import com.jbs.JobbSokerDig.viewLogic.UserEditProfileViewLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserQualificationService {

    @Autowired
    UserQualificationRepository userQualificationRepository;

    @Autowired
    UserEditProfileViewLogic profileViewLogic;

    @Autowired
    QualificationService qualificationService;

    public List<UserQualification> getUserQualification(Long userCandidateId){
        List<UserQualification> userQualification = userQualificationRepository.getUserQualificationRepo(userCandidateId);


        return userQualification;
    }

    public void saveUserQualificationChoice(String[] list, HttpServletRequest request) {
        UserCandidate userCandidate = profileViewLogic.getCurrentUserCandidate(request);

        Long currentUserCandidateId = userCandidate.getUserCandidateId();

        List<Long> newQualificationIds = parseStingIdtoLongId(list);
        List<Qualification> newQualifications = qualificationService.getQualificationListById(newQualificationIds);

        List<UserQualification> newUserQualifications = new ArrayList<>();
        for (int i = 0; i < newQualifications.size(); i++) {
            newUserQualifications.add(new UserQualification(null, newQualifications.get(i), new QualificationLevel(1L, 1), userCandidate));
        }

        List<UserQualification> oldUserQualifications = userQualificationRepository.getUserQualificationRepo(currentUserCandidateId);

        for (int i = 0; i < oldUserQualifications.size(); i++) {
            userQualificationRepository.delete(oldUserQualifications.get(i));
        }

        for (int i = 0; i < newUserQualifications.size(); i++) {
            userQualificationRepository.save(newUserQualifications.get(i));
        }

    }

    //Endast hjälpmetod.
    private List<Long> parseStingIdtoLongId(String[] qualificationId) {
        List<Long> qualificationIdList = new ArrayList<>();
        for (int i = 0; i < qualificationId.length; i++) {
            qualificationIdList.add(Long.parseLong(qualificationId[i]));
        }
        return qualificationIdList;
    }
}
