package org.nfccardstart.nfccard.dto;


import org.nfccardstart.nfccard.entity.TapLog;

import java.time.LocalDateTime;

public class TapLogDto {
    private Long id;
    private String cardId;
    private LocalDateTime timestamp;
    private String deviceInfo;
    private String location;

    // Constructors
    public TapLogDto() {}

    public TapLogDto(Long id, String cardId, LocalDateTime timestamp, String deviceInfo, String location) {
        this.id = id;
        this.cardId = cardId;
        this.timestamp = timestamp;
        this.deviceInfo = deviceInfo;
        this.location = location;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}