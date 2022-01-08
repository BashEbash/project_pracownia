package com.pracownia.spring.services;

import com.pracownia.spring.entities.Bidding;

public interface BiddingService {
    Bidding saveBidding(Bidding bidding);
    Bidding findBiddingById(Integer id);
    Iterable<Bidding> getAllBiddings();
    Iterable<Bidding> AllBiddingsPaging(Integer pageNr, Integer howManyOnPage);
    void deleteBidding(Integer id);
}
