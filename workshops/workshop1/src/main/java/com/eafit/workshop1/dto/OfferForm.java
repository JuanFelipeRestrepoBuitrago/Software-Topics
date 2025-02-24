package com.eafit.workshop1.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for capturing form input when creating an offer.
 * 
 * @see jakarta.validation.constraints.Positive
 * @see jakarta.validation.constraints.NotNull
 * @see jakarta.validation.constraints.Size
 * 
 * 
 * @author Juan Felipe Restrepo Buitrago
 */
public class OfferForm {

    /**
     * The name of the auction.
     */
    @NotNull(message = "Auction name is required")
    @Size(min = 1, max = 255, message = "Auction name must be between 1 and 255 characters")
    private String auction;

    /**
     * The price of the offer.
     */
    @Positive(message = "Offer price must be a positive number")
    @NotNull(message = "Offer price is required")
    private double offerPrice;

    /**
     * Get the auction name.
     * @return The auction name
     */
    public String getAuction() {
        return auction;
    }

    /**
     * Set the auction name.
     * @param auction The auction name
     */
    public void setAuction(String auction) {
        this.auction = auction;
    }

    /**
     * Get the offer price.
     * @return The offer price
     */
    public double getOfferPrice() {
        return offerPrice;
    }

    /**
     * Set the offer price.
     * @param offerPrice The offer price
     */
    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }
}
