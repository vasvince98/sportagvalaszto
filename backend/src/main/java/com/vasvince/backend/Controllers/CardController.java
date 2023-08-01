package com.vasvince.backend.Controllers;


import com.vasvince.backend.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    //    @GetMapping("/cards")
//    public String getCards() {
//        return "test";
//    }

    @PostMapping("/cards")
    public String addCard(@RequestBody String cardName) {
        return cardService.addNewCard(cardName);
    }
//
//    @DeleteMapping("/cards")
//    public String deleteCard() {
//        return "test";
//    }
}
