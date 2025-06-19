package org.nfccardstart.nfccard.controller;

import org.nfccardstart.nfccard.dto.BusinessDto;
import org.nfccardstart.nfccard.dto.CardDto;
import org.nfccardstart.nfccard.dto.TapLogDto;
import org.nfccardstart.nfccard.service.BusinessService;
import org.nfccardstart.nfccard.service.CardService;
import org.nfccardstart.nfccard.service.TapLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final BusinessService businessService;
    private final CardService cardService;
    private final TapLogService tapLogService;

    @Autowired
    public AdminController(BusinessService businessService, CardService cardService, TapLogService tapLogService) {
        this.businessService = businessService;
        this.cardService = cardService;
        this.tapLogService = tapLogService;
    }

    @GetMapping("/businesses")
    public ResponseEntity<List<BusinessDto>> getAllBusinesses() {
        List<BusinessDto> businesses = businessService.getAllBusinesses();
        return ResponseEntity.ok(businesses);
    }

    @GetMapping("/cards")
    public ResponseEntity<List<CardDto>> getAllCards() {
        List<CardDto> cards = cardService.getAllCards();
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/taps")
    public ResponseEntity<List<TapLogDto>> getAllTapLogs() {
        List<TapLogDto> tapLogs = tapLogService.getAllTapLogs();
        return ResponseEntity.ok(tapLogs);
    }
}