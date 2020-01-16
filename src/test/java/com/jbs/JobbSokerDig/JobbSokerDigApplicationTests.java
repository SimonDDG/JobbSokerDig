package com.jbs.JobbSokerDig;

import com.jbs.JobbSokerDig.company.OpenPosition;
import com.jbs.JobbSokerDig.company.QualificationNeed;
import com.jbs.JobbSokerDig.repositorys.QualificationNeedRepository;
import com.jbs.JobbSokerDig.service.MatchService;
import com.jbs.JobbSokerDig.service.OpenPositionService;
import com.jbs.JobbSokerDig.service.UserCandidateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class JobbSokerDigApplicationTests {

	@Autowired
	MatchService matchService;

	@Autowired
	UserCandidateService userCandidateService;

	@Autowired
	OpenPositionService openPositionService;

	@Autowired
	QualificationNeedRepository qualificationNeedRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void testarMatchningsArray() {
//		ArrayList<Integer> testArray = matchService.howManyQualificationsMatched();
//		System.out.println(testArray);
//	}

//	@Test
//	public void testAllUserLogins() {
//		List<String> allUserNames = userCandidateService.getAllUserLoginNames(userCandidateService.getAllUserCandidates());
//		System.out.println(allUserNames);
//	}

	//Inte klart
//	@Test
//	public void testAllOpenPositionsForLoggedInCompany() {
//		//List<OpenPosition> allOpenPositionsForCompany = openPositionService.getAllOpenPositionsLoggedInCompany();
//	}
//
//	@Test
//	public void getAllQualificationNeedsFromPosition1() {
//		List<QualificationNeed> qualificationNeedsForOnePosition = (List) qualificationNeedRepository.getAllQualificationsByOpenPositionId((long) 2); //TODO Hårdkodad CompanyId eftersom vi i presentationen endast har ett företag.
//		System.out.println(qualificationNeedsForOnePosition.get(1).getQualification().getQualification());
//	}
//
//	@Test
//	public void getQualificationMatchPercentages() {
//		System.out.println(matchService.howManyQualificationsMatched(2L));
//	}
//
//	@Test
//	public void getBenefitMatchPercentages() {
//		System.out.println(matchService.howManyBenefitsMatched(2L));
//	}
//
//	@Test
//	public void getSortedCandidatesByAverageMatched() {
//		Long openPositionId = 3L;
//		for (int i = 0; i < matchService.getCandidatesByHighestMatched(openPositionId).size(); i++) {
//			String fullName = matchService.getCandidatesByHighestMatched(openPositionId).get(i).getFullName();
//			Integer percentageMatched = matchService.getCandidatesByHighestMatched(openPositionId).get(i).getAveragePercentageMatchedInRelationToOpenPosition();
//			System.out.println("Name " + fullName);
//			System.out.println("Percentage " + percentageMatched);
//
//		}
//
//	}

}
