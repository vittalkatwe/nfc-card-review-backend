package org.nfccardstart.nfccard.repository;

import org.nfccardstart.nfccard.entity.TapLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TapLogRepository extends JpaRepository<TapLog, Long> {

    @Query("SELECT t FROM TapLog t JOIN FETCH t.card c JOIN FETCH c.business ORDER BY t.timestamp DESC")
    List<TapLog> findAllWithCardAndBusiness();
}