package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.repositorys.QualificationRepository;
import com.jbs.JobbSokerDig.values.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationService {

    @Autowired
    QualificationRepository qualificationRepository;

    public List<Qualification> getAllQualifications() {

        return (List)qualificationRepository.findAll();
    }
}
