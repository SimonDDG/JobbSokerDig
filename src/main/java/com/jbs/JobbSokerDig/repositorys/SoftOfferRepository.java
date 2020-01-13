package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.company.SoftOffer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SoftOfferRepository extends CrudRepository<SoftOffer, Long> {

    @Query(
            value = "SELECT * FROM SoftOffer WHERE UserCandidateId = ?1",
            nativeQuery = true
    )
    List<SoftOffer> getSoftOfferFromRepo(Long userCandidateId);

    @Query("Select so From SoftOffer so Where so.SoftOffer.SoftOfferId = ?1")
    SoftOffer findBySoftOfferId(long parseLong);
}
