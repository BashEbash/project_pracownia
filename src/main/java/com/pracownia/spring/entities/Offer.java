package com.pracownia.spring.entities;

import com.pracownia.spring.entities.EmbeddedKeys.OfferEmbeddedKey;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
//@IdClass(OfferEmbeddedKey.class)
//@Check(constraints = "PRIMARY KEY (bidding_id, amount)")
public class Offer implements Serializable {

//    @Id
//    @ManyToOne()
//    @JoinColumn(nullable = false, name= "bidding_id", referencedColumnName = "id")
//    private Bidding bidding_id;
//
//    @Id
//    private BigDecimal amount;
    @EmbeddedId
    private OfferEmbeddedKey offerEmbeddedKey;

    @ManyToOne()
    @JoinColumn(nullable = false, name= "user_login", referencedColumnName = "login")
    private User user;

    @Column
    private ZonedDateTime date_and_time;



    //required by Hibernate
    public Offer(){
    }

    public Offer(Bidding bidding_id, BigDecimal amount, User user) {
        this.offerEmbeddedKey = new OfferEmbeddedKey();
        this.offerEmbeddedKey.bidding_id = bidding_id;
        this.offerEmbeddedKey.amount = amount;

        //this.bidding_id = bidding_id;
        //this.amount = amount;
        this.user = user;
        this.date_and_time = ZonedDateTime.now();
    }

    public Bidding getBidding_id() {
        //return bidding_id;
        return offerEmbeddedKey.bidding_id;
    }

    public void setBidding_id(Bidding bidding_id) {
        //this.bidding_id = bidding_id;
        this.offerEmbeddedKey.bidding_id = bidding_id;
    }

    public BigDecimal getAmount() {
        //return amount;
        return offerEmbeddedKey.amount;
    }

    public void setAmount(BigDecimal amount) {
        //this.amount = amount;
        this.offerEmbeddedKey.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ZonedDateTime getDate_and_time() {
        return date_and_time;
    }

    public void setDate_and_time(ZonedDateTime date_and_time) {
        this.date_and_time = date_and_time;
    }
}
