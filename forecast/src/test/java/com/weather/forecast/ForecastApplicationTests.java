package com.weather.forecast;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ForecastControllerTests.class,
    ForecastServiceTests.class
})

@SpringBootTest
class ForecastApplicationTests {

	@Test
	void contextLoads() {
	}

}
