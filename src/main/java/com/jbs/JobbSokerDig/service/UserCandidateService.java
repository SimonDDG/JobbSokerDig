package com.jbs.JobbSokerDig.service;

import com.jbs.JobbSokerDig.repositorys.UserRepository;
import com.jbs.JobbSokerDig.user.UserCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> getAllUserLoginNames(List<UserCandidate> userCandidateObjects) {
        List<String> userNameList = new ArrayList<>();
        for (int i = 0; i < userCandidateObjects.size(); i++) {
            userNameList.add(userCandidateObjects.get(i).getLogin().getUsername());
        }
        return userNameList;
    }

    public List<UserCandidate> getAllUserCandidates() {
        List<UserCandidate> allUserCandidates = (List)userRepository.findAll();
        return allUserCandidates;
    }
}
