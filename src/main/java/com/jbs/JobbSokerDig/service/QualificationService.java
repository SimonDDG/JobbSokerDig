package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.repositorys.QualificationRepository;
import com.jbs.JobbSokerDig.values.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QualificationService {

    @Autowired
    QualificationRepository qualificationRepository;

    public List<Qualification> getAllQualifications() {

        return (List)qualificationRepository.findAll();
    }

    public List<Qualification> getQualificationListById(List<Long> newQualificationIds) {
        List<Qualification> qualifications = new ArrayList<>();

        for (int i = 0; i < newQualificationIds.size(); i++) {
            qualifications.add(qualificationRepository.findByQualificationId(newQualificationIds.get(i)));
        }
        return qualifications;
    }
}
