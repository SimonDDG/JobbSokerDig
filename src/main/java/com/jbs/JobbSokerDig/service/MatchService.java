package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.company.QualificationNeed;
import com.jbs.JobbSokerDig.repositorys.*;
import com.jbs.JobbSokerDig.user.UserCandidate;
import com.jbs.JobbSokerDig.user.UserQualification;
import com.jbs.JobbSokerDig.values.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    @Autowired
    UserQualificationRepository userQualificationRepository;

    @Autowired
    UserPreferenceRepository userPreferenceRepository;

    @Autowired
    QualificationNeedRepository qualificationNeedRepository;

    @Autowired
    CompAndBenRepository compAndBenRepository;

    @Autowired
    UserRepository userRepository;

    public ArrayList<Integer> howManyQualificationsMatched(/*Tar en List<QN> för en specifik OpenPosition, Tar en List<UQ> */) {

        List<QualificationNeed> qualificationNeeds = (List) qualificationNeedRepository.findAll();
        int numberOfQualificationNeeded = qualificationNeeds.size();
        List<UserQualification> userQualifications = (List) userQualificationRepository.findAll();
//        userQualification.get(0).getUserCandidate().getFullName();
        List<UserCandidate> allUserCandidates = (List) userRepository.findAll();

        ArrayList<Integer> matchedQualifications = new ArrayList<>();

        for (int i = 0; i < allUserCandidates.size(); i++) { //itererar genom alla kandidater i databasen, en efter en
            int numberOfQualificationMatched = 0;

            for (int j = 0; j < qualificationNeeds.size(); j++) { //itererar genom alla kvalifikationsbehov för en specifik OpenPosition

                for (int k = 0; k < userQualifications.size(); k++) { //itererar genom alla UserQualification för alla users, en efter en
                    if (allUserCandidates.get(i).getUserCandidateId().equals(userQualifications.get(k).getUserCandidate().getUserCandidateId())) {
                        if (userQualifications.get(k).getQualification().getQualificationId().equals(qualificationNeeds.get(j).getQualification().getQualificationId())) {
                            numberOfQualificationMatched++;

                        }
                    }
                }
                matchedQualifications.add(numberOfQualificationMatched);
            }

        }
        //            int percentageQualificationMatched = calculateMatchedPercentage(numberOfQualificationMatched, numberOfQualificationNeeded);

        return matchedQualifications;
    }


//    public int calculateHowManyBenefitsMatched (/*Tar emot en kandidat och en OpenPosition*/) {
//            int numberOfBenefitsGiven = compAndBenRepository.findAll().toString().length();
//            int numberOfBenefitsMatched = 0;
//            for (/*iterera genom alla kandidater*/) {
//                int userQualificationId = userQualificationRepository.findById(/*någon typ av id för userQualification*/).get().getUserQualificationId();
//                int qualificationNeed = qualificationNeedRepository.findById().get().getQualification();
//                if (userQualificationId == qualificationNeed) {
//                    numberOfBenefitsMatched++;
//                }
//            }
//        }
//
//        public int calculateMatchedPercentage ( int qualificationsMatched, int numberOfQualificationNeeded){
//            int percentageMatched = (qualificationsMatched / numberOfQualificationNeeded) * 100;
//            return percentageMatched;
//        }

    }
