package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.repositorys.BenefitRepository;
import com.jbs.JobbSokerDig.values.Benefit;
import com.jbs.JobbSokerDig.values.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BenefitService {

    @Autowired
    BenefitRepository benefitRepository;

    public List<Benefit> getAllBenefits() {

        return (List)benefitRepository.findAll();
    }

    public List<Benefit> getAllBenefitsById(String[] mustHaves) {

        List<Benefit> benefits = new ArrayList<>();

        for (int i = 0; i < mustHaves.length; i++) {
            benefits.add(benefitRepository.findByBenefitId(Long.parseLong(mustHaves[i])));
        }
        return benefits;
    }
}
