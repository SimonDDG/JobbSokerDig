package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.company.SoftOffer;
import com.jbs.JobbSokerDig.repositorys.SoftOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftOfferService {

    @Autowired
    SoftOfferRepository softOfferRepository;

    public List<SoftOffer> getSoftOfferForUser(Long userCandidateId){

        List<SoftOffer> softOffers = softOfferRepository.getSoftOfferFromRepo(userCandidateId);

        return softOffers;
    }
}
