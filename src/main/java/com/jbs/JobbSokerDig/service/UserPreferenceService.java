package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.repositorys.UserPreferenceRepository;
import com.jbs.JobbSokerDig.repositorys.UserQualificationRepository;
import com.jbs.JobbSokerDig.user.UserCandidate;
import com.jbs.JobbSokerDig.user.UserPreference;
import com.jbs.JobbSokerDig.user.UserQualification;
import com.jbs.JobbSokerDig.values.Benefit;
import com.jbs.JobbSokerDig.values.PreferanceLevel;
import com.jbs.JobbSokerDig.viewLogic.UserEditProfileViewLogic;
import com.jbs.JobbSokerDig.viewLogic.ViewLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserPreferenceService {

    @Autowired
    private UserPreferenceRepository userPreferenceRepository;

    @Autowired
    private UserPreferenceService userPreferenceService;

    @Autowired
    private BenefitService benefitService;

    @Autowired
    private UserEditProfileViewLogic userEditProfileViewLogic;

    @Autowired
    private ViewLogic viewLogic;



    public List<UserPreference> getUserPreference(Long userCandidateId){

        List<UserPreference> userPreference = userPreferenceRepository.getUserPreferenceRepo(userCandidateId);

        return userPreference;
    }

    public void saveUserMustHaves(String[] mustHaves, HttpServletRequest request) {

        UserCandidate userCandidate = userEditProfileViewLogic.getCurrentUserCandidate(request);

        List<UserPreference> userPreference = userPreferenceService.getUserPreference(userCandidate.getUserCandidateId());
        List<UserPreference> oldUserMustHaves = userEditProfileViewLogic.checkUserMustHavePreferances(userCandidate, userPreference);

        List<Benefit> newUserBenefitObjectList = benefitService.getAllBenefitsById(mustHaves);

        List<UserPreference> newUserMustHaves = new ArrayList<>();
        for (int i = 0; i < newUserBenefitObjectList.size(); i++) {
            newUserMustHaves.add(new UserPreference(null, newUserBenefitObjectList.get(i), /*new PreferanceLevel(1L,1),*/ userCandidate, true));
        }

        userPreferenceRepository.deleteAll(oldUserMustHaves);
        userPreferenceRepository.saveAll(newUserMustHaves);

    }

    public void saveUserOptionalPreferences(String[] optionalPreferences, HttpServletRequest request) {

        UserCandidate userCandidate = userEditProfileViewLogic.getCurrentUserCandidate(request);

        List<UserPreference> userPreference = userPreferenceService.getUserPreference(userCandidate.getUserCandidateId());
        List<UserPreference> oldNotUserMustHaves = userEditProfileViewLogic.isNotUserMustHavePreferances(userCandidate, userPreference);

        List<Benefit> newUserBenefitObjectList = benefitService.getAllBenefitsById(optionalPreferences);

        List<UserPreference> newUserMustHaves = new ArrayList<>();
        for (int i = 0; i < newUserBenefitObjectList.size(); i++) {
            newUserMustHaves.add(new UserPreference(null, newUserBenefitObjectList.get(i), /*new PreferanceLevel(1L,1),*/ userCandidate, false));
        }

        userPreferenceRepository.deleteAll(oldNotUserMustHaves);
        userPreferenceRepository.saveAll(newUserMustHaves);
    }
}