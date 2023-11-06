package com.vasvince.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test.application.properties")
class TestServiceTests {

    public final TestService testService;

    private static final Logger logger = LoggerFactory.getLogger(TestServiceTests.class);

    @Autowired
    TestServiceTests(TestService testService) {
        this.testService = testService;
    }

    @BeforeAll
    public static void setup() {
        logger.info("Testing started");
    }

    @Test
    public void test() {
        String result = testService.testMethod();
        Assertions.assertEquals("Hello World!", result);
    }
}
