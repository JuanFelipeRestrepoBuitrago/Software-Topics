package com.eafit.workshop1.services;

import com.eafit.workshop1.models.Offer;
import com.eafit.workshop1.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Service class that provides methods to interact with the database and the Offer table.
 * 
 * This class is annotated with @Service, which indicates that it is a service class.
 * 
 * @see org.springframework.stereotype.Service
 * @see com.eafit.workshop1.models.Offer
 * @see com.eafit.workshop1.repositories.OfferRepository
 * @see org.springframework.beans.factory.annotation.Autowired
 * @see java.util.Date
 * 
 * @author
 */
@Service
public class OfferService {

    /**
     * OfferRepository object used to interact with the database and the Offer table.
     */
    private final OfferRepository offerRepository;

    /**
     * Contructor of the OfferService class which automatically initializes the OfferRepository object.
     * 
     * @param offerRepository 
     * object used to interact with the database and the Offer table.
     */
    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    /**
     * Method that creates a new offer with the specified creation date, offer price, and state.
     * 
     * @param offerPrice the price offered by the user.
     * @param auction the name of the auction for which the offer was made.
     * @throws IllegalArgumentException if the offer price is less than 0, the auction name is null or empty or the offer price is lower than the current offer price.
     */
    public void createOffer(int offerPrice, String auction) throws IllegalArgumentException {
        if (offerPrice < 0) {
            throw new IllegalArgumentException("The offer price must be greater than or equal to 0");
        } else if (auction == null || auction.isEmpty()) {
            throw new IllegalArgumentException("The auction name must not be null or empty");
        }

        // Get all the offers which state is active
        List<Offer> activeOffers = offerRepository.findByState(true);
        for (Offer offer : activeOffers) {
            // If the offer price is higher than the current offer price
            if (offerPrice > offer.getOfferPrice()) {
                // Set the state of the current offer to false
                offer.setState(false);
                // Save the current offer
                offerRepository.save(offer);
            } else {
                throw new IllegalArgumentException("The offer price must be higher than the current offer price");
            }
        }
        // Get the current date
        Date createdAt = new Date();
        Offer offer = new Offer(createdAt, offerPrice, true, auction);
        offerRepository.save(offer);
    }

    /**
     * Method that returns the offer with the specified id.
     * 
     * @param id the id of the offer to be returned.
     */
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }
}