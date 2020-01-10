package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.general.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, Long> {

    Login findByUsername(String username);

    @Query(value = "SELECT username FROM Login INNER JOIN UserCandidate ON Login.LoginID = UserCandidate.LoginId WHERE UserCandidate.UserCandidateId = ?1", nativeQuery = true)
    String getUsernameById(Long id);
}

