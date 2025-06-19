package org.nfccardstart.nfccard.dto;


import org.nfccardstart.nfccard.entity.Card;
public class CardDto {
    private String id;
    private String assignedTo;
    private BusinessDto business;

    // Constructors
    public CardDto() {}

    public CardDto(String id, String assignedTo, BusinessDto business) {
        this.id = id;
        this.assignedTo = assignedTo;
        this.business = business;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public BusinessDto getBusiness() {
        return business;
    }

    public void setBusiness(BusinessDto business) {
        this.business = business;
    }
}