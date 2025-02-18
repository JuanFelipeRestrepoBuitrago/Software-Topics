package com.dev.testJewelryAuction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import com.dev.testJewelryAuction.models.BidResponse; // Import BidResponse

@Service
public class AuctionService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void placeBid(String auctionId, double bidAmount, String userId) {
        // Logic to validate bid and update auction state
        messagingTemplate.convertAndSend("/topic/auctionUpdates", 
            new BidResponse(auctionId, bidAmount, "New bid placed by user: " + userId));
    }
}