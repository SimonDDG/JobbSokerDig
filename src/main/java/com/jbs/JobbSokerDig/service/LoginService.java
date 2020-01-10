package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.repositorys.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public String getUsername(Long id) {

        return loginRepository.getUsernameById(id);
    }
}
