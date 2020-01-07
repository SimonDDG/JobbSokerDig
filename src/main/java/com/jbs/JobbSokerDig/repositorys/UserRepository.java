package com.jbs.JobbSokerDig.repositorys;

import com.jbs.JobbSokerDig.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
