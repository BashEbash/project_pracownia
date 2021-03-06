package com.auction.controllers;

import com.auction.entities.Bidding;
import com.auction.entities.User;
import com.auction.services.BiddingService;
import com.auction.entities.Offer;
import com.auction.services.OfferService;
import com.auction.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class OfferController {

    @Autowired
    private UserService userService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private BiddingService biddingService;

    @GetMapping(value = "offers/{biddingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Offer> getOffersInBidding(@PathVariable Integer bidding_id) {
        return offerService.getOffersByBidding_id(bidding_id);

    }

    @PostMapping(value = "addOffer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Offer addOffer(@RequestParam HashMap<String, String> offer_data) {

        Bidding bidding = biddingService.findBiddingById(Integer.valueOf(offer_data.get("bidding_id")));
        BigDecimal amount = new BigDecimal(offer_data.get("amount"));
        User user = userService.findUserByLogin(offer_data.get("login"));

        Offer offer = new Offer(bidding, amount, user);
        offerService.saveOffer(offer);

        return offer;
    }


}
