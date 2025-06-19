package org.nfccardstart.nfccard.service;

import jakarta.servlet.http.HttpServletRequest;
import org.nfccardstart.nfccard.dto.TapLogDto;
import org.nfccardstart.nfccard.entity.Card;
import org.nfccardstart.nfccard.entity.TapLog;
import org.nfccardstart.nfccard.repository.TapLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TapLogService {

    private final TapLogRepository tapLogRepository;

    @Autowired
    public TapLogService(TapLogRepository tapLogRepository) {
        this.tapLogRepository = tapLogRepository;
    }

    public TapLog createTapLog(Card card, HttpServletRequest request) {
        TapLog tapLog = new TapLog();
        tapLog.setCard(card);
        tapLog.setDeviceInfo(extractDeviceInfo(request));
        tapLog.setLocation(extractLocation(request));

        return tapLogRepository.save(tapLog);
    }

    @Transactional(readOnly = true)
    public List<TapLogDto> getAllTapLogs() {
        return tapLogRepository.findAllWithCardAndBusiness().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private String extractDeviceInfo(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        return userAgent != null ? userAgent : "Unknown";
    }

    private String extractLocation(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String forwardedFor = request.getHeader("X-Forwarded-For");

        if (forwardedFor != null && !forwardedFor.isEmpty()) {
            return forwardedFor.split(",")[0].trim();
        }

        return remoteAddr != null ? remoteAddr : "Unknown";
    }

    private TapLogDto convertToDto(TapLog tapLog) {
        return new TapLogDto(
                tapLog.getId(),
                tapLog.getCard().getId(),
                tapLog.getTimestamp(),
                tapLog.getDeviceInfo(),
                tapLog.getLocation()
        );
    }
}
