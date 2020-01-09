package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.company.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {


    @Query(
            value = "SELECT * FROM Company INNER JOIN Login ON Company.LoginId = Login.LoginID WHERE Login.username = ?1",
            nativeQuery = true
    )
    Company getCompanyRepo(String username);
}
