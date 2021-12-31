package com.pracownia.spring.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class DeliveryOption {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String option_name;

    @Column(length = 20)
    private String firm;

    @Column
    private BigDecimal price;


    //required by Hibernate
    public DeliveryOption(){

    }

    public DeliveryOption(Integer id, String option_name, String firm, BigDecimal price) {
        this.id = id;
        this.option_name = option_name;
        this.firm = firm;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOption_name() {
        return option_name;
    }

    public void setOption_name(String option_name) {
        this.option_name = option_name;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
