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

        //UserQualification userQualification = userQualificationRepository.findByUserCandidateId(userCandidateId);

        return userQualification;
    }

    /*

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
            //System.out.println("Tar bort: " + oldUserQualifications.get(i).getUserQualification().getQualification());
            userQualificationRepository.delete(oldUserQualifications.get(i));
        }

        for (int i = 0; i < newUserQualifications.size(); i++) {
            //System.out.println("Sparar: " + newUserQualifications.get(i).getUserQualification().getQualification());
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
