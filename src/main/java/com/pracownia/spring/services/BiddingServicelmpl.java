package com.pracownia.spring.services;

import com.pracownia.spring.entities.Bidding;
import com.pracownia.spring.repositories.BiddingRepository;
import com.pracownia.spring.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiddingServicelmpl implements BiddingService{

    @Autowired
    private BiddingRepository biddingRepository;


    @Override
    public Bidding saveBidding(Bidding bidding) {
        return biddingRepository.save(bidding);
    }

}
