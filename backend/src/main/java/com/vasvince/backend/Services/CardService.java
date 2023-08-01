package com.vasvince.backend.Services;

import com.vasvince.backend.Entities.Card;
import com.vasvince.backend.Repositories.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    ICardRepository cardRepository;

    @Autowired
    public CardService(ICardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public String addNewCard(String cardName) {
        cardRepository.save(new Card(cardName, cardName));
        return "New card added with name: " + cardName;
    }
}
