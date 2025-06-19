package org.nfccardstart.nfccard.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "businesses")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotBlank(message = "Business name is required")
    @Column(name = "name", nullable = false)
    private String name;

    @Email(message = "Valid email is required")
    @NotBlank(message = "Contact email is required")
    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @NotBlank(message = "Review link is required")
    @Column(name = "review_link", nullable = false)
    private String reviewLink;

    // Constructors
    public Business() {}

    public Business(String name, String contactEmail, String reviewLink) {
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