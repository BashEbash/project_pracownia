package com.pracownia.spring.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Subject {


    @Id
    @Column
    private Integer number;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false, name = "user_login", referencedColumnName = "login")
    private User user;

    @Column(length = 50)
    private String subject_name;

    @Column(length = 30)
    private String category;

    @Column
    private BigDecimal start_price;


    public Subject(Integer number, User user, String subject_name, String category, BigDecimal start_price) {
        this.number = number;
        this.user = user;
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
        return user;
    }

    public void setUser_login(User user) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


