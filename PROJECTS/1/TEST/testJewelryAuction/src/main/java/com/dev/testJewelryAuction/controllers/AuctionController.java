package com.dev.testJewelryAuction.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dev.testJewelryAuction.models.BidRequest; // Import BidRequest
import com.dev.testJewelryAuction.models.BidResponse; // Import BidResponse

@Controller
public class AuctionController {

    @MessageMapping("/placeBid")
    @SendTo("/topic/auctionUpdates")
    public BidResponse placeBid(@Payload BidRequest bidRequest) {
        return new BidResponse(bidRequest.getAuctionId(), bidRequest.getBidAmount(), "New bid placed!");
    }
}