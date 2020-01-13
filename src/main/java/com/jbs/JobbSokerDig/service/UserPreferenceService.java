package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.repositorys.UserPreferenceRepository;
import com.jbs.JobbSokerDig.repositorys.UserQualificationRepository;
import com.jbs.JobbSokerDig.user.UserCandidate;
import com.jbs.JobbSokerDig.user.UserPreference;
import com.jbs.JobbSokerDig.user.UserQualification;
import com.jbs.JobbSokerDig.values.Benefit;
import com.jbs.JobbSokerDig.viewLogic.UserEditProfileViewLogic;
import com.jbs.JobbSokerDig.viewLogic.ViewLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserPreferenceService {

    @Autowired
    UserPreferenceRepository userPreferenceRepository;

    @Autowired
    UserPreferenceService userPreferenceService;

    @Autowired
    BenefitService benefitService;

    @Autowired
    UserEditProfileViewLogic userEditProfileViewLogic;

    @Autowired
    ViewLogic viewLogic;



    public List<UserPreference> getUserPreference(Long userCandidateId){

        List<UserPreference> userPreference = userPreferenceRepository.getUserPreferenceRepo(userCandidateId);

        return userPreference;
    }

    public void saveUserMustHaves(String[] mustHaves, HttpServletRequest request) {

        for (int i = 0; i < mustHaves.length; i++) {
            System.out.println("must: " + mustHaves[i]);
        }
        System.out.println("----");

        UserCandidate userCandidate = userEditProfileViewLogic.getCurrentUserCandidate(request);

        List<UserPreference> userPreference = userPreferenceService.getUserPreference(userCandidate.getUserCandidateId());

        List<UserPreference> oldUserMustHaves = userEditProfileViewLogic.checkUserMustHavePreferances(userCandidate, userPreference);


    }

    public void saveUserOptionalPreferences(String[] optionalPreferences, HttpServletRequest request) {

        for (int i = 0; i < optionalPreferences.length; i++) {
            System.out.println("opt: " + optionalPreferences[i]);
        }
        System.out.println("----");

        UserCandidate userCandidate = userEditProfileViewLogic.getCurrentUserCandidate(request);

        List<UserPreference> userPreference = userPreferenceService.getUserPreference(userCandidate.getUserCandidateId());

        List<UserPreference> OldNotUserMustHaves = userEditProfileViewLogic.isNotUserMustHavePreferances(userCandidate, userPreference);

    }
}

/*

Bra att ha kod, ta bort sen.

        List<UserPreference> userPreference = userPreferenceService.getUserPreference(userCandidate.getUserCandidateId());
        List<Benefit> benefits = benefitService.getAllBenefits();
        List<Benefit> checkedBenefitsList = userEditProfileViewLogic.checkBenefitsAgainstUserCandidateBenefits(userCandidate, benefits);
        List<List<Benefit>> splittedBenefits = viewLogic.splitBenefitList(checkedBenefitsList, 5);
        model.addAttribute("splittedBenefits", splittedBenefits);

        List<UserPreference> userMustHaves = userEditProfileViewLogic.checkUserMustHavePreferances(userCandidate, userPreference);
        model.addAttribute("userMustHaves", userMustHaves);

        List<UserPreference> notUserMustHaves = userEditProfileViewLogic.isNotUserMustHavePreferances(userCandidate, userPreference);
        model.addAttribute("notUserMustHaves", notUserMustHaves);
     */