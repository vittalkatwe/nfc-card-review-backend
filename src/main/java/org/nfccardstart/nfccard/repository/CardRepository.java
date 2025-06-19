package org.nfccardstart.nfccard.repository;

import org.nfccardstart.nfccard.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {

    @Query("SELECT c FROM Card c JOIN FETCH c.business WHERE c.id = :cardId")
    Optional<Card> findByIdWithBusiness(@Param("cardId") String cardId);
}
