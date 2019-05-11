package com.example.vetclinica.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer price_id;

    private String procedur;
    private Integer cost;

    public Price(){

    }

    public Price(String procedur, Integer cost) {
        this.procedur = procedur;
        this.cost = cost;
    }

    public Integer getPrice_id() {
        return price_id;
    }

    public void setPrice_id(Integer price_id) {
        this.price_id = price_id;
    }

    public String getProcedur() {
        return procedur;
    }

    public void setProcedur(String procedur) {
        this.procedur = procedur;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
