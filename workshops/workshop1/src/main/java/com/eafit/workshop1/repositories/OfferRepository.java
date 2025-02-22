package com.eafit.workshop1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eafit.workshop1.models.Offer;
import java.util.List;

/**
 * Interface that provides methods to interact with the database and the Offer table
 * through the JPA repository.
 * This interface extends the JpaRepository interface, which provides CRUD operations
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see com.eafit.workshop1.models.Offer
 * @see org.springframework.stereotype.Repository
 * 
 * @author Juan Felipe Restrepo Buitrago
 */
@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
     /**
     * Finds all offers with the specified state.
     *
     * @param state the state of the offers to find.
     * @return a list of offers with the specified state.
     */
    List<Offer> findByState(boolean state);
}