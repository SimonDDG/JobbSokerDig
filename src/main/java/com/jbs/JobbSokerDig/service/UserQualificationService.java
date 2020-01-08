package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.repositorys.UserQualificationRepository;
import com.jbs.JobbSokerDig.user.UserQualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQualificationService {

    @Autowired
    UserQualificationRepository userQualificationRepository;

    public List<UserQualification> getUserQualification(Long userCandidateId){
        List<UserQualification> userQualification = userQualificationRepository.getUserQualificationRepo(userCandidateId);

        //UserQualification userQualification = userQualificationRepository.findByUserCandidateId(userCandidateId);

        return userQualification;
    }
}
