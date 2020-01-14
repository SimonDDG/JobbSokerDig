package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.company.OpenPosition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OpenPositionRepository extends CrudRepository<OpenPosition, Long> {

    @Query(value = "SELECT * FROM OpenPosition WHERE CompanyId = ?1", nativeQuery = true)
    List<OpenPosition> getAllOpenPositionsByCompanyId(Long companyId);

    @Query(value = "SELECT * FROM OpenPosition WHERE OpenPositionName = ?1", nativeQuery = true)
    OpenPosition getOpenPositionByTitle(String positionTitle);
}
