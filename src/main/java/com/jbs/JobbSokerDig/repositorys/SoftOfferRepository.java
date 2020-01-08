package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.company.SoftOffer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SoftOfferRepository extends CrudRepository<SoftOffer, Long> {

    @Query(
            value = "SELECT * FROM SoftOffer WHERE UserCandidateId = ?1",
            nativeQuery = true
    )
    List<SoftOffer> getSoftOfferFromRepo(Long userCandidateId);
}
