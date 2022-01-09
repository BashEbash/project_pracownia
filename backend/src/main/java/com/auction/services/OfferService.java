package com.auction.services;

import com.auction.entities.Offer;

import java.math.BigDecimal;

public interface OfferService {
    Offer saveOffer(Offer offer);
    Offer findOfferByBidding_idAndAmount(Integer bidding_id, BigDecimal amount);
    Iterable<Offer> getOffersByBidding_id(Integer bidding_id);
}
