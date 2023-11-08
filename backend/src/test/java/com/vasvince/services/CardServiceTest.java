package com.vasvince.services;

import com.vasvince.InitDB;
import com.vasvince.repositories.ICardRepository;
import com.vasvince.entities.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.StreamSupport;

import static org.mockito.Mockito.mock;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test.application.properties")
class CardServiceTest {

    private static String dummyJson;
    private final CardService cardService;
    private final ICardRepository cardRepository;
    private static final Logger logger = LoggerFactory.getLogger(CardServiceTest.class);

    @Autowired
    public CardServiceTest(CardService cardService, ICardRepository cardRepository) {
        this.cardService = cardService;
        this.cardRepository = cardRepository;
    }


    @BeforeAll
    public static void setup() {
        dummyJson = """
                [{"id":0,"name":"Steve","title":"Golf"},{"id":1,"name":"John","title":"Tennis"},{"id":2,"name":"Brad","title":"Soccer"},{"id":3,"name":"Mike","title":"Basketball"},{"id":4,"name":"Tom","title":"Baseball"},{"id":5,"name":"Bob","title":"Football"},{"id":6,"name":"Bill","title":"Hockey"},{"id":7,"name":"Dave","title":"Rugby"},{"id":8,"name":"Jim","title":"Cricket"},{"id":9,"name":"Fred","title":"Badminton"}]""";
    }

    @Test
    @Sql(scripts = "classpath:init.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void verifyGetCards() {
        String jsonFromMethod = cardService.getCards();
        Assertions.assertEquals(dummyJson, jsonFromMethod);
    }

    @Test
    void addNewCard() {
        InitDB initDB = new InitDB(cardRepository);
        initDB.init();
        int numberOfCardsBefore = initDB.getNumberOfCards();

        cardService.addNewCard("lastname", "lasttitle");

        cardRepository.findAll().forEach(card -> logger.info(card.toString()));

        Card lastCard = cardRepository.findAll().get(cardRepository.findAll().size() - 1);

        Assertions.assertEquals("lasttitle", lastCard.getTitle());
        Assertions.assertEquals("lastname", lastCard.getName());
        Assertions.assertEquals(numberOfCardsBefore + 1, cardRepository.findAll().size());
    }

    @Test
    @Sql(scripts = "classpath:init.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void verify10cardsInserted() {

        Assertions.assertEquals(10, StreamSupport
                .stream(cardRepository.findAll().spliterator(), false)
                .count());

    }

}
