package com.pracownia.spring.entities;

import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity
@Check(constraints = "adres_mail LIKE '%@%'")
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Basic(optional = false)
    //@Column(length = 20)
    private String login;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String surname;

    @Column(length = 50)
    private String address_of_residence;

    @Column(length = 30)
    private String adres_mail;

    //required by Hibernate
    public User(){

    }

    public User(/*String login,*/ String name, String surname, String address_of_residence, String adres_mail) {
        this.login = adres_mail.split("@")[0];
        this.name = name;
        this.surname = surname;
        this.address_of_residence = address_of_residence;
        this.adres_mail = adres_mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress_of_residence() {
        return address_of_residence;
    }

    public void setAddress_of_residence(String address_of_residence) {
        this.address_of_residence = address_of_residence;
    }

    public String getAdres_mail() {
        return adres_mail;
    }

    public void setAdres_mail(String adres_mail) {
        this.adres_mail = adres_mail;
    }
}
