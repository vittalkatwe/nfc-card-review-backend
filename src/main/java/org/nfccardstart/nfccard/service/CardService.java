package org.nfccardstart.nfccard.service;

import org.nfccardstart.nfccard.dto.BusinessDto;
import org.nfccardstart.nfccard.dto.CardDto;
import org.nfccardstart.nfccard.entity.Card;
import org.nfccardstart.nfccard.entity.TapLog;
import org.nfccardstart.nfccard.exception.CardNotFoundException;
import org.nfccardstart.nfccard.repository.CardRepository;
import org.nfccardstart.nfccard.repository.TapLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Transactional(readOnly = true)
    public Card findCardWithBusiness(String cardId) {
        return cardRepository.findByIdWithBusiness(cardId)
                .orElseThrow(() -> new CardNotFoundException("Card not found with ID: " + cardId));
    }

    @Transactional(readOnly = true)
    public List<CardDto> getAllCards() {
        return cardRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CardDto convertToDto(Card card) {
        BusinessDto businessDto = new BusinessDto(
                card.getBusiness().getId(),
                card.getBusiness().getName(),
                card.getBusiness().getContactEmail(),
                card.getBusiness().getReviewLink()
        );

        return new CardDto(
                card.getId(),
                card.getAssignedTo(),
                businessDto
        );
    }

    public void addBusiness(Card card) {
        cardRepository.save(card);
    }
}