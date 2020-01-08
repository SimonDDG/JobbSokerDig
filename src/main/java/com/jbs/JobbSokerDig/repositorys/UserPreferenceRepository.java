package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.user.UserPreference;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserPreferenceRepository extends CrudRepository<UserPreference, Long> {

    @Query(
            value = "SELECT * FROM UserPreference WHERE UserCandidateId = ?1",
            nativeQuery = true
    )
    List<UserPreference> getUserPreferenceRepo(Long userCandidateId);
}
