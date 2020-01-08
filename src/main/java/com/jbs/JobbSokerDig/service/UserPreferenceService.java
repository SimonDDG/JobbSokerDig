package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.repositorys.UserPreferenceRepository;
import com.jbs.JobbSokerDig.repositorys.UserQualificationRepository;
import com.jbs.JobbSokerDig.user.UserPreference;
import com.jbs.JobbSokerDig.user.UserQualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPreferenceService {

    @Autowired
    UserPreferenceRepository userPreferenceRepository;

    public List<UserPreference> getUserPreference(Long userCandidateId){

        List<UserPreference> userPreference = userPreferenceRepository.getUserPreferenceRepo(userCandidateId);

        return userPreference;
    }
}
