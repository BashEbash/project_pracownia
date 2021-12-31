package com.pracownia.spring.entities;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

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
    private Subject subject;

    @Column
    private ZonedDateTime date_start;

    @Column
    private ZonedDateTime date_end;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false, name = "winner", referencedColumnName = "login")
    private User user;

    @Column(length = 30)
    private String status;


    //required by Hibernate
    public Bidding() {

    }

    public Bidding(Integer id, ZonedDateTime date_start, ZonedDateTime date_end, String status) {
        this.id = id;
        this.date_start = date_start;
        this.date_end = date_end;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subject getSubject_number() {
        return subject;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
