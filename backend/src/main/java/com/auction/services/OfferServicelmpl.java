package com.auction.services;

import com.auction.repositories.OfferRepository;
import com.auction.entities.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OfferServicelmpl implements OfferService{

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Offer saveOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer findOfferByBidding_idAndAmount(Integer bidding_id, BigDecimal amount) {
        return offerRepository.findOfferByBidding_idAndAmount(bidding_id, amount);
    }

    @Override
    public Iterable<Offer> getOffersByBidding_id(Integer id) {
        return offerRepository.findAllByBidding_id(id);
    }
}
