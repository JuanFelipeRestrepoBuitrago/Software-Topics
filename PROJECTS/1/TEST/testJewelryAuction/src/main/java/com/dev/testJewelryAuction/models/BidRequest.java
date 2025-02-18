package com.dev.testJewelryAuction.models;

public class BidRequest {
    private String auctionId;
    private double bidAmount;

    // Getters and setters
    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }
}