package com.pracownia.spring.entities;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Check(constraints ="status IN ('in progress', 'purchased', 'not purchased')")
public class Bidding {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false, name = "subject_number", referencedColumnName = "number")
    private Subject subject_number;

    @Column
    private ZonedDateTime date_start;

    @Column
    private ZonedDateTime date_end = null;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "winner", referencedColumnName = "login")
    private User winner;

    @Column(length = 30)
    private String status = "in progress";


    //required by Hibernate
    public Bidding() {

    }

    public Bidding(Subject subject_number) {
        this.subject_number = subject_number;
        this.date_start = ZonedDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subject getSubject_number() {
        return subject_number;
    }

    public void setSubject_number(Subject subject_number) {
        this.subject_number = subject_number;
    }


    public ZonedDateTime getDate_start() {
        return date_start;
    }

    public void setDate_start(ZonedDateTime date_start) {
        this.date_start = date_start;
    }

    public ZonedDateTime getDate_end() {
        return date_end;
    }

    public void setDate_end(ZonedDateTime date_end) {
        this.date_end = date_end;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return winner;
    }

    public void setUser(User winner) {
        this.winner = winner;
    }
}
