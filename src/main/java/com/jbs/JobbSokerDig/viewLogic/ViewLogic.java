package com.jbs.JobbSokerDig.viewLogic;


import com.jbs.JobbSokerDig.service.LoginService;
import com.jbs.JobbSokerDig.user.UserCandidate;
import com.jbs.JobbSokerDig.values.Benefit;
import com.jbs.JobbSokerDig.values.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ViewLogic {

    @Autowired
    LoginService loginService;

    public List<List<Qualification>> splitQualificationList(List<Qualification> bigList, int innerSize) {

        int size = bigList.size();
        List<List<Qualification>> parts = new ArrayList<List<Qualification>>();

        for (int i = 0; i < size; i += innerSize) {
            parts.add(new ArrayList<Qualification>(bigList.subList(i, Math.min(size, i + innerSize))));
        }

        return parts;
    }


    public List<List<Benefit>> splitBenefitList(List<Benefit> bigList, int innerSize) {

        int size = bigList.size();
        List<List<Benefit>> parts = new ArrayList<List<Benefit>>();

        for (int i = 0; i < size; i += innerSize) {
            parts.add(new ArrayList<Benefit>(bigList.subList(i, Math.min(size, i + innerSize))));
        }

        return parts;
    }

    public List<String> getAllUsernames(List<UserCandidate> allUsers) {

        List<String> usernames = new ArrayList<>();

        for (int i = 0; i < allUsers.size(); i++) {
            Long id = allUsers.get(i).getUserCandidateId();
            usernames.add(loginService.getUsername(id));
        }
        return null;
    }
}
