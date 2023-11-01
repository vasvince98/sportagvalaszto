package com.vasvince.Services;

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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test.application.properties")
class CardServiceTest {

    private static String dummyJson;
    private final CardService cardService;
    private static final Logger logger = LoggerFactory.getLogger(CardServiceTest.class);

    @Autowired
    public CardServiceTest(CardService cardService) {
        this.cardService = cardService;
    }


    @BeforeAll
    public static void setup() {
        dummyJson = """
                [{"id":0,"name":"testname","title":"testtitle"}]""";
    }

    @Test
    public void verifyGetCards() {
        String jsonFromMethod = cardService.getCards();
        Assertions.assertEquals(dummyJson, jsonFromMethod);
    }

}
