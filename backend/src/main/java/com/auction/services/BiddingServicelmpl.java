package com.auction.services;

import com.auction.repositories.BiddingRepository;
import com.auction.entities.Bidding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BiddingServicelmpl implements BiddingService{

    @Autowired
    private BiddingRepository biddingRepository;


    @Override
    public Bidding saveBidding(Bidding bidding) {
        return biddingRepository.save(bidding);
    }

    @Override
    public Bidding findBiddingById(Integer id) {
        return biddingRepository.findBiddingById(id);
    }

    @Override
    public Iterable<Bidding> getAllBiddings() {
        return biddingRepository.findAll();
    }

    @Override
    public Iterable<Bidding> AllBiddingsPaging(Integer pageNr, Integer howManyOnPage) {
        return biddingRepository.findAll(PageRequest.of(pageNr, howManyOnPage));
    }

    @Override
    public void deleteBidding(Integer id) {
        biddingRepository.deleteById(id);
    }

}
