package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.company.CompAndBen;
import com.jbs.JobbSokerDig.company.QualificationNeed;
import com.jbs.JobbSokerDig.repositorys.*;
import com.jbs.JobbSokerDig.user.UserCandidate;
import com.jbs.JobbSokerDig.user.UserPreference;
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

    @Autowired
    OpenPositionRepository openPositionRepository;

    public ArrayList<Double> howManyQualificationsMatched(Long openPositionId/*List<UserQualification> allUserQualifications*/) {

        List<UserCandidate> allUserCandidates = (List) userRepository.findAll();
        int numberOfCandidates = allUserCandidates.size();

        List<QualificationNeed> qualificationNeedsForOnePosition = (List) qualificationNeedRepository.getAllQualificationsByOpenPositionId(openPositionId);
        int numberOfQualificationNeededForOnePosition = qualificationNeedsForOnePosition.size();



        ArrayList<Double> qualificationPercentages = new ArrayList<>();

        for (int i = 0; i < numberOfCandidates; i++) { //itererar genom alla kandidater i databasen, en efter en

            int numberOfQualificationMatched = 0;
            UserCandidate userCandidate = allUserCandidates.get(i);
            List<UserQualification> userCandidateQualifications = userQualificationRepository.getUserQualificationRepo(userCandidate.getUserCandidateId());
            int numberOfQualificationsOneUser = userCandidateQualifications.size();

            for (int j = 0; j < numberOfQualificationNeededForOnePosition; j++) { //itererar genom alla kvalifikationsbehov för en specifik OpenPosition

                Long positionQualificationId = qualificationNeedsForOnePosition.get(j).getQualification().getQualificationId();

                for (int k = 0; k < numberOfQualificationsOneUser; k++) { //itererar genom alla UserQualification för alla users, en efter en
                    Long userQualificationId = userCandidateQualifications.get(k).getUserQualification().getQualificationId();

                    if (positionQualificationId.equals(userQualificationId)) {
                        numberOfQualificationMatched++;
                    }
                }

            }
            Double percentageQualificationMatched = calculateMatchedPercentage(numberOfQualificationMatched, numberOfQualificationNeededForOnePosition);

            qualificationPercentages.add(percentageQualificationMatched);

        }

        return qualificationPercentages;
    }



    public ArrayList<Double> howManyBenefitsMatched(Long openPositionId/*List<UserQualification> allUserQualifications*/) {

        List<UserCandidate> allUserCandidates = (List) userRepository.findAll();
        int numberOfCandidates = allUserCandidates.size();

        List<CompAndBen> compAndBenForOnePosition = (List) compAndBenRepository.getAllCompAndBenByOpenPositionId(openPositionId);
        int numberOfCompAndBenForOnePosition = compAndBenForOnePosition.size();



        ArrayList<Double> matchedCompAndBen = new ArrayList<>();

        for (int i = 0; i < numberOfCandidates; i++) { //itererar genom alla kandidater i databasen, en efter en

            int numberOfCompAndBenMatched = 0;
            UserCandidate userCandidate = allUserCandidates.get(i);
            List<UserPreference> userCandidatePreferences = userPreferenceRepository.getUserPreferenceRepo(userCandidate.getUserCandidateId());
            int numberOfQualificationsOneUser = userCandidatePreferences.size();

            for (int j = 0; j < numberOfCompAndBenForOnePosition; j++) { //itererar genom alla kvalifikationsbehov för en specifik OpenPosition

                Long positionCompAndBenId = compAndBenForOnePosition.get(j).getBenefit().getBenefitId();

                for (int k = 0; k < numberOfQualificationsOneUser; k++) { //itererar genom alla UserQualification för alla users, en efter en
                    Long userPreferenceId = userCandidatePreferences.get(k).getBenefit().getBenefitId();

                    if (positionCompAndBenId.equals(userPreferenceId)) {
                        numberOfCompAndBenMatched++;
                    }
                }

            }
            Double percentageQualificationMatched = calculateMatchedPercentage(numberOfCompAndBenMatched, numberOfCompAndBenForOnePosition);
            matchedCompAndBen.add(percentageQualificationMatched);

        }

        return matchedCompAndBen;
    }

        public double calculateMatchedPercentage ( double matched, double total){
            double percentageMatched = (matched / total) * 100;
            return percentageMatched;
        }

    }
