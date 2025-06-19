package org.nfccardstart.nfccard.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @NotBlank(message = "Card ID is required")
    @Column(name = "id")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "business_id", nullable = false)
    @NotNull(message = "Business is required")
    private Business business;

    @Column(name = "assigned_to")
    private String assignedTo;

    // Constructors
    public Card() {}

    public Card(String id, Business business) {
        this.id = id;
        this.business = business;
    }

    public Card(String id, Business business, String assignedTo) {
        this.id = id;
        this.business = business;
        this.assignedTo = assignedTo;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}