package com.auction.entities;

import com.auction.entities.Triggers.SubjectTrigger;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(SubjectTrigger.class)
public class Subject {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false, name = "user_login", referencedColumnName = "login")
    private User user_login;

    @Column(length = 50)
    private String subject_name;

    @Column(length = 30)
    private String category;

    @Column
    private BigDecimal start_price;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<DeliveryOption> deliveryOptions = new ArrayList<DeliveryOption>();


    public Subject(User user_login, String subject_name, String category, BigDecimal start_price) {
        this.user_login = user_login;
        this.subject_name = subject_name;
        this.category = category;
        this.start_price = start_price;
    }

    //required by Hibernate
    public Subject() {

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public User getUser_login() {
        return user_login;
    }

    public void setUser_login(User user_login) {
        this.user_login = user_login;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getStart_price() {
        return start_price;
    }

    public void setStart_price(BigDecimal start_price) {
        this.start_price = start_price;
    }

    public List<DeliveryOption> getDeliveryOptions() {
        return deliveryOptions;
    }

    public void setDeliveryOptions(List<DeliveryOption> deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
    }
}


