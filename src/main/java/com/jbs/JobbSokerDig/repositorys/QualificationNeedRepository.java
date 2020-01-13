package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.company.OpenPosition;
import com.jbs.JobbSokerDig.company.QualificationNeed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QualificationNeedRepository extends CrudRepository<QualificationNeed, Long> {

    @Query(value = "SELECT * FROM QualificationNeed WHERE OpenPositionId = ?1", nativeQuery = true)
    List<QualificationNeed> getAllQualificationsByOpenPositionId(Long openPositionId);
}
