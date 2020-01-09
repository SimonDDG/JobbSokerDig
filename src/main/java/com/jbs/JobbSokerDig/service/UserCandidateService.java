package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.repositorys.UserRepository;
import com.jbs.JobbSokerDig.user.UserCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserCandidateService {

    @Autowired
    UserRepository userRepository;

    public UserCandidate getUserCandidate(HttpServletRequest request) {
        String username = request.getRemoteUser();
        return userRepository.getUserCandidateRepo(username);
    }

    public UserCandidate getUserCandidateByUsername(String username) {
        return userRepository.getUserCandidateRepo(username);
    }
}
