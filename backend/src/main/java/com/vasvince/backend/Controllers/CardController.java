package com.vasvince.backend.Controllers;


import com.vasvince.backend.RequestObjects.CardRequest;
import com.vasvince.backend.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public String getCards() {
        return cardService.getCards();
    }

    @RequestMapping(value = "/cards", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public String addCard(@RequestBody CardRequest cardRequest) {
        return cardService.addNewCard(cardRequest.getName(), cardRequest.getTitle());
    }
}
