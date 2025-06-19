package org.nfccardstart.nfccard.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.nfccardstart.nfccard.entity.Business;
import org.nfccardstart.nfccard.entity.Card;
import org.nfccardstart.nfccard.service.BusinessService;
import org.nfccardstart.nfccard.service.CardService;
import jakarta.servlet.http.HttpServletRequest;
import org.nfccardstart.nfccard.service.TapLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/go")
public class CardController {

    private final CardService cardService;
    private final TapLogService tapLogService;

    @Autowired
    public CardController(CardService cardService, TapLogService tapLogService) {
        this.cardService = cardService;
        this.tapLogService = tapLogService;
    }

    @PostMapping("/card/add")
    public ResponseEntity<String> addBusiness(@Validated @RequestBody Card card) {
        cardService.addBusiness(card);
        return ResponseEntity.ok("Card added successfully");
    }


    @GetMapping("/{cardId}")
    public ResponseEntity<Void> redirectToReviewLink(@PathVariable String cardId, HttpServletRequest request) {
        // Find card with business using custom JPQL query
        Card card = cardService.findCardWithBusiness(cardId);

        // Create tap log entry
        tapLogService.createTapLog(card, request);

        // Redirect to business review link
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(card.getBusiness().getReviewLink()))
                .build();
    }
}