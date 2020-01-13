package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.values.Qualification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QualificationRepository extends CrudRepository<Qualification, Long> {

    @Query("SELECT q FROM Qualification q WHERE q.QualificationId = ?1")
    Qualification findByQualificationId(Long id);

}
