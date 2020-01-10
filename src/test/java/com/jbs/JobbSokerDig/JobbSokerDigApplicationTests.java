package com.jbs.JobbSokerDig;

import com.jbs.JobbSokerDig.service.MatchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class JobbSokerDigApplicationTests {

	@Autowired
	MatchService matchService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testarMatchningsArray() {
		ArrayList<Integer> testArray = matchService.howManyQualificationsMatched();
		System.out.println(testArray);
	}

}
