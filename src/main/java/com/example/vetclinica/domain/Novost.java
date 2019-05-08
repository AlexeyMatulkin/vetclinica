package com.example.vetclinica.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Novost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer novost_id;
    private String text;
    private Date date_post;

    public Novost() {
    }



    public Novost(String text, Date date_post) {
        this.text = text;
        this.date_post = date_post;
    }

    public Integer getNovost_id() {
        return novost_id;
    }

    public void setNovost_id(Integer novost_id) {
        this.novost_id = novost_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate_post() {
        return date_post;
    }

    public void setDate_post(Date date_post) {
        this.date_post = date_post;
    }
}




