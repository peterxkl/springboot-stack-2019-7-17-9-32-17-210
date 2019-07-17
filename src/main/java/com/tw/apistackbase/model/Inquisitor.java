package com.tw.apistackbase.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Inquisitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inquisitorId;
    @Column(nullable = false)
    private String inquisitorName;
    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="inquisitor_id",referencedColumnName=" inquisitorId")
    private Procuratorate procuratorate;

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

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }
}
