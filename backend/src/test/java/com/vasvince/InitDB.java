package com.vasvince;

import com.vasvince.repositories.ICardRepository;
import com.vasvince.entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDB {

    @Autowired
    ICardRepository cardRepository;

    public InitDB(ICardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public InitDB() {
    }


    public void init() {
        cardRepository.deleteAll();
        cardRepository.save(new Card("Steve", "Golf"));
        cardRepository.save(new Card("John", "Tennis"));
        cardRepository.save(new Card("Bob", "Football"));
        cardRepository.save(new Card("Bill", "Basketball"));
        cardRepository.save(new Card("Jack", "Baseball"));
        cardRepository.save(new Card("Joe", "Rugby"));
        cardRepository.save(new Card("Jim", "Cricket"));
        cardRepository.save(new Card("Jeff", "Hockey"));
        cardRepository.save(new Card("Jill", "Volleyball"));
        cardRepository.save(new Card("Jenny", "Badminton"));
    }

    public int getNumberOfCards() {
        return cardRepository.findAll().size();
    }
}
