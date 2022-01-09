package com.auction.services;

import com.auction.entities.Bidding;

public interface BiddingService {
    Bidding saveBidding(Bidding bidding);
    Bidding findBiddingById(Integer id);
    Iterable<Bidding> getAllBiddings();
    Iterable<Bidding> AllBiddingsPaging(Integer pageNr, Integer howManyOnPage);
    void deleteBidding(Integer id);
}
