package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.company.CompAndBen;
import com.jbs.JobbSokerDig.company.OpenPosition;
import com.jbs.JobbSokerDig.company.QualificationNeed;
import com.jbs.JobbSokerDig.values.Qualification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompAndBenRepository extends CrudRepository<CompAndBen, Long> {

    @Query(value = "SELECT * FROM CompAndBen WHERE OpenPositionId = ?1", nativeQuery = true)
    List<CompAndBen> getAllCompAndBenByOpenPositionId(Long openPositionId);
}
