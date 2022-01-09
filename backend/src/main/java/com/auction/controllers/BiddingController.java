package com.auction.controllers;

import com.auction.entities.Bidding;
import com.auction.services.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BiddingController {

    @Autowired
    private BiddingService biddingService;

    @GetMapping(value = "bidding/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Bidding getBidding(@PathVariable Integer id) {
        return biddingService.findBiddingById(id);

    }

    @GetMapping(value = "biddings", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Bidding> getAllBiddings() {
        return biddingService.getAllBiddings();

    }

    @GetMapping(value = "biddings/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Bidding> getBiddingsPage(@PathVariable Integer page) {
        return biddingService.AllBiddingsPaging(page, 5);

    }

    @DeleteMapping(value = "bidding/{id}")
    public ResponseEntity deleteBidding(@PathVariable Integer id) {
        biddingService.deleteBidding(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping(value = "/bidding/edit")
    public ResponseEntity editBidding(@RequestBody Bidding bidding) {

        if(biddingService.findBiddingById(bidding.getId()) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        biddingService.saveBidding(bidding);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
