package com.dev.testJewelryAuction.models;

public class BidResponse {
    private String auctionId;
    private double bidAmount;
    private String message;

    // Constructor, getters, and setters
    public BidResponse(String auctionId, double bidAmount, String message) {
        this.auctionId = auctionId;
        this.bidAmount = bidAmount;
        this.message = message;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}