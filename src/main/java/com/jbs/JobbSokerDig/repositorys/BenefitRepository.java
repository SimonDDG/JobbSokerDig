package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.values.Benefit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BenefitRepository extends CrudRepository<Benefit, Long> {

    @Query("SELECT b FROM Benefit b WHERE b.BenefitId = ?1")
    Benefit findByBenefitId(long parseLong);
}
