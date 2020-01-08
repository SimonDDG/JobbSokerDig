package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.user.UserCandidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserCandidate, Long> {

    UserCandidate findByFullName(String fullName);

    @Query(
            value = "SELECT dbo.UserCandidate.* " +
                    "FROM dbo.Login INNER JOIN " +
                    "dbo.UserCandidate ON dbo.Login.LoginID = dbo.UserCandidate.LoginId " +
                    "WHERE dbo.Login.username = ?1",
            nativeQuery = true
    )
    UserCandidate getUserCandidateRepo(String username);

}
