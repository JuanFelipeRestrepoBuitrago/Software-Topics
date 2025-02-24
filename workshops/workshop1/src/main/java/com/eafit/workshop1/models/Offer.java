package com.eafit.workshop1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;


/**
 * Represents an offer made by a user for an auction.
 * This class stores details such as the creation date, auction name, offer price, and state.
 *
 * @author Juan Felipe Restrepo Buitrago
 */
@Entity
@Table(name = "offers")
public class Offer {

    /**
     * The ID of the offer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The date and time when the offer was created.
     */
    private Date createdAt;
    /**
     * The name of the auction for which the offer was made.
     */
    private String auction;
    /**
     * The price offered by the user.
     */
    private double offerPrice;
    /**
     * The state of the offer. True if the offer is active, false otherwise.
     */
    private boolean state;

    /**
     * Default constructor required by JPA.
     */
    public Offer() {}

    /**
     * Creates a new offer with the specified creation date, offer price, state, and auction name.
     *
     * @param createdAt the date and time when the offer was created.
     * @param offerPrice the price offered by the user.
     * @param state the state of the offer.
     * @param auction the name of the auction for which the offer was made.
     */
    public Offer(Date createdAt, double offerPrice, boolean state, String auction) {
        this.auction = auction;
        this.createdAt = createdAt;
        this.offerPrice = offerPrice;
        this.state = state;
    }

    /**
     * Creates a new offer with the specified creation date, offer price, and state.
     *
     * @param createdAt the date and time when the offer was created.
     * @param offerPrice the price offered by the user.
     * @param state the state of the offer.
     */
    public Offer(Date createdAt, double offerPrice, boolean state) {
        this.auction = "Example Auction";
        this.createdAt = createdAt;
        this.offerPrice = offerPrice;
        this.state = state;
    }

    /**
     * Returns the ID of the offer.
     *
     * @return the ID of the offer.
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the date and time when the offer was created.
     *
     * @return the date and time when the offer was created.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Returns the name of the auction for which the offer was made.
     *
     * @return the name of the auction for which the offer was made.
     */
    public String getAuction() {
        return auction;
    }

    /**
     * Returns the price offered by the user.
     *
     * @return the price offered by the user.
     */
    public double getOfferPrice() {
        return offerPrice;
    }

    /**
     * Returns the state of the offer.
     *
     * @return the state of the offer.
     */
    public boolean getState() {
        return state;
    }

    /**
     * Sets the Creation Date of the Offer
     * @param createdAt the date and time when the offer was created.
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Sets the Auction Name of the Offer
     * @param auction the name of the auction for which the offer was made.
     */
    public void setAuction(String auction) {
        this.auction = auction;
    }

    /**
     * Sets the Offer Price of the Offer
     * @param offerPrice the price offered by the user.
     */
    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    /**
     * Sets the state of the Offer
     * @param state the state of the offer.
     */
    public void setState(boolean state) {
        this.state = state;
    }

}
