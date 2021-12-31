package com.pracownia.spring.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bidding_id;

    @Column
    private BigDecimal amount;

    @ManyToOne()
    @JoinColumn(nullable = false, name= "user_login", referencedColumnName = "login")
    private User user;

    @Column
    private ZonedDateTime date;

    @Column
    private ZonedDateTime time;


    //required by Hibernate
    public Offer(){
    }

    public Offer(Integer bidding_id, BigDecimal amount, User user, ZonedDateTime date, ZonedDateTime time) {
        this.bidding_id = bidding_id;
        this.amount = amount;
        this.user = user;
        this.date = date;
        this.time = time;
    }

    public Integer getBidding_id() {
        return bidding_id;
    }

    public void setBidding_id(Integer bidding_id) {
        this.bidding_id = bidding_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getUser_login() {
        return user;
    }

    public void setUser_login(User user) {
        this.user = user;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }
}
