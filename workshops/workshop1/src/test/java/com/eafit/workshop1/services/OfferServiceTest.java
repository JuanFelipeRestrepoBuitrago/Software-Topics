package com.eafit.workshop1.services;

import com.eafit.workshop1.models.Offer;
import com.eafit.workshop1.repositories.OfferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the OfferService class.
 * This class uses Mockito to mock the OfferRepository dependency.
 */
@ExtendWith(MockitoExtension.class)
public class OfferServiceTest {

    /**
     * The mock repository used to simulate the OfferRepository dependency.
     */
    @Mock
    private OfferRepository offerRepository;

    /**
     * The service to test.
     */
    @InjectMocks
    private OfferService offerService;

    /**
     * The active offers used in the tests.
     */
    private Offer activeOffer;

    /**
     * The new offer used in the tests.
     */
    private Offer newOffer;

    @BeforeEach
    public void setUp() {
        // Initialize test data
        activeOffer = new Offer(new Date(), 100, true, "Auction 1");
        newOffer = new Offer(new Date(), 200, true, "Auction 2");
    }

    /**
     * Test the createOffer method when the offer is created successfully.
     * The method should call the repository to get the active offers and save the new offer.
     */
    @Test
    public void testCreateOffer_Success() {
        // Mock repository behavior
        when(offerRepository.findByState(true))
            .thenReturn(Arrays.asList(activeOffer));
        when(offerRepository.save(any(Offer.class)))
            .thenReturn(newOffer);

        // Call the service method
        try {
            offerService.createOffer(200, "Auction 2");
        } catch (IllegalArgumentException e) {
            fail("The offer should have been created successfully" + e.getMessage());
        }

        // Verify repository interactions
        verify(offerRepository, times(1))
            .findByState(true);
        verify(offerRepository, times(2))
            .save(any(Offer.class));
    }

    @Test
    public void testCreateOffer_InvalidOfferPrice() {
        // Mock repository behavior
        when(offerRepository.findByState(true))
            .thenReturn(Arrays.asList(activeOffer));

        // Call the service method and expect an exception
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            offerService.createOffer(50, "Auction 2");
        });

        // Verify the exception message
        assertEquals("The offer price must be higher than the current offer price $100.0", exception.getMessage());

        // Verify repository interactions
        verify(offerRepository, times(1))
            .findByState(true);
        verify(offerRepository, never())
            .save(any(Offer.class));
    }

    /**
     * Test the createOffer method when the auction name is invalid.
     * The method should throw an exception without calling the repository.
     */
    @Test
    public void testCreateOffer_InvalidAuctionName() {
        // Call the service method and expect an exception
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            offerService.createOffer(200, "");
        });

        // Verify the exception message
        assertEquals("The auction name must not be null or empty", exception.getMessage());

        // Verify repository interactions
        verify(offerRepository, never())
            .findByState(anyBoolean());
        verify(offerRepository, never())
            .save(any(Offer.class));
    }

    /**
     * Test the deleteOffer method when the offer is deleted successfully.
     * The method should call the repository to delete the offer.
     */
    @Test
    public void testDeleteOffer_Success() {
        // Arrange
        Long offerId = 1L;

        // Act
        offerService.deleteOffer(offerId);

        // Assert
        verify(offerRepository, times(1))
            .deleteById(offerId);
    }

    /**
     * Test the deleteOffer method when the repository throws an exception.
     * The method should throw the same exception.
     */
    @Test
    public void testDeleteOffer_RepositoryThrowsException() {
        // Arrange
        Long offerId = 1L;
        doThrow(new IllegalArgumentException("Invalid ID"))
            .when(offerRepository)
            .deleteById(offerId);

        // Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            offerService.deleteOffer(offerId);
        });

        // Verify the exception message
        assertEquals("Invalid ID", exception.getMessage());

        // Verify repository interaction
        verify(offerRepository, times(1)).
            deleteById(offerId);
    }
}