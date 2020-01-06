package com.jbs.JobbSokerDig.repositorys;

import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, Long> {

    Login findByUsername(String username);

}

