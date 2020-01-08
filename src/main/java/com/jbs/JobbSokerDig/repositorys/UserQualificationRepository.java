package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.user.UserQualification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserQualificationRepository extends CrudRepository<UserQualification, Long> {

    @Query(
            value = "SELECT * FROM UserQualification WHERE UserCandidateId = ?1",
            nativeQuery = true
    )
    List<UserQualification> getUserQualificationRepo(Long userCandidateId);

    //UserQualification findByUserCandidateId(Long userCandidateId);
}
