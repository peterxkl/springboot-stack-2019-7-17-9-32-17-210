package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
public class Inquisitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inquisitorId;
    @Column(nullable = false)
    private String inquisitorName;

    public Inquisitor(String inquisitorName) {
        this.inquisitorName = inquisitorName;
    }

    public int getInquisitorId() {
        return inquisitorId;
    }

    public void setInquisitorId(int inquisitorId) {
        this.inquisitorId = inquisitorId;
    }

    public String getInquisitorName() {
        return inquisitorName;
    }

    public void setInquisitorName(String inquisitorName) {
        this.inquisitorName = inquisitorName;
    }
}
