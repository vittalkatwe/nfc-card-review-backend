package org.nfccardstart.nfccard.dto;

import org.nfccardstart.nfccard.entity.Business;

import java.util.UUID;

public class BusinessDto {
    private UUID id;
    private String name;
    private String contactEmail;
    private String reviewLink;

    // Constructors
    public BusinessDto() {}

    public BusinessDto(UUID id, String name, String contactEmail, String reviewLink) {
        this.id = id;
        this.name = name;
        this.contactEmail = contactEmail;
        this.reviewLink = reviewLink;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getReviewLink() {
        return reviewLink;
    }

    public void setReviewLink(String reviewLink) {
        this.reviewLink = reviewLink;
    }
}
