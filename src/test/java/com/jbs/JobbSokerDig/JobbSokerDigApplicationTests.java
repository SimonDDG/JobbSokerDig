package com.jbs.JobbSokerDig;

import com.jbs.JobbSokerDig.service.MatchService;
import com.jbs.JobbSokerDig.service.UserCandidateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class JobbSokerDigApplicationTests {

	@Autowired
	MatchService matchService;

	@Autowired
	UserCandidateService userCandidateService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testarMatchningsArray() {
		ArrayList<Integer> testArray = matchService.howManyQualificationsMatched();
		System.out.println(testArray);
	}

	@Test
	public void testAllUserLogins() {
		List<String> allUserNames = userCandidateService.getAllUserLoginNames(userCandidateService.getAllUserCandidates());
		System.out.println(allUserNames);
	}

}
