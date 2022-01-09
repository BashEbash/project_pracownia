package com.auction.entities.EmbeddedKeys;

import com.auction.entities.Bidding;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Embeddable
public class OfferEmbeddedKey implements Serializable{

    @ManyToOne()
    @JoinColumn(nullable = false, name= "bidding_id", referencedColumnName = "id")
    public Bidding bidding_id;

    public BigDecimal amount;

    public OfferEmbeddedKey() {
    }

    public OfferEmbeddedKey(Bidding bidding_id, BigDecimal amount) {
        this.bidding_id = bidding_id;
        this.amount = amount;
    }
}
