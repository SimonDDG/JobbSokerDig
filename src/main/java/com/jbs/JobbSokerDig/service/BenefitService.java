package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.repositorys.BenefitRepository;
import com.jbs.JobbSokerDig.values.Benefit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitService {

    @Autowired
    BenefitRepository benefitRepository;

    public List<Benefit> getAllBenefits() {

        return (List)benefitRepository.findAll();
    }
}
