package com.vasvince.services;

import com.google.gson.Gson;
import com.vasvince.entities.Card;
import com.vasvince.Repositories.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    ICardRepository cardRepository;

    @Autowired
    public CardService(ICardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public String addNewCard(String name, String title) {
        cardRepository.save(new Card(name, title));
        return "New card added with name: " + title;
    }

    public String getCards() {
        List<Card> cards = new ArrayList<>();
        Iterable<Card> iterableCards = cardRepository.findAll();
        iterableCards.forEach(cards::add);

        Gson gson = new Gson();

        return gson.toJson(cards);
    }
}
