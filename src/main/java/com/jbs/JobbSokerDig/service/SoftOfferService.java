package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.company.SoftOffer;
import com.jbs.JobbSokerDig.repositorys.SoftOfferRepository;
import com.jbs.JobbSokerDig.user.UserCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SoftOfferService {

    @Autowired
    SoftOfferRepository softOfferRepository;

    @Autowired
    UserCandidateService userCandidateService;

    public List<SoftOffer> getSoftOfferForUser(Long userCandidateId){

        List<SoftOffer> softOffers = softOfferRepository.getSoftOfferFromRepo(userCandidateId);

        return softOffers;
    }

    public void updateUserChoice(String choice, String soId) {

        SoftOffer softOffer = softOfferRepository.findBySoftOfferId(Long.parseLong(soId));
        
        softOffer.setUserStatus(choice);

        softOfferRepository.save(softOffer);

    }

    public List<SoftOffer> getAllSoftOfeers() {
        return (List)softOfferRepository.findAll();
    }
}
