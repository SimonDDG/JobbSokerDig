package com.jbs.JobbSokerDig;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class JobbSokerDigApplicationTests {

	@Autowired
	LoginRepository repo;


	@Test
	void contextLoads() {
	}

	@Test
	public void testAddLogin() {
		long count = repo.count();
		LoginDetails test = new LoginDetails(null, "test", "test");
		repo.save(test);
		long count2 = repo.count();
		Assertions.assertEquals(count +1, count2);

	}


}
