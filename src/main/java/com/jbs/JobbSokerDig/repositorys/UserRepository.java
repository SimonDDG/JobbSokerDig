package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.user.UserCandidate;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserCandidate, Long> {

    UserCandidate findByFullName(String fullName);
}
