package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int procuratotateId;
    @Column(nullable = false , unique = true)
    private String procuratotateName;

    public Procuratorate(String procuratotateName) {
        this.procuratotateName = procuratotateName;
    }

    public int getProcuratotateId() {
        return procuratotateId;
    }

    public void setProcuratotateId(int procuratotateId) {
        this.procuratotateId = procuratotateId;
    }

    public String getProcuratotateName() {
        return procuratotateName;
    }

    public void setProcuratotateName(String procuratotateName) {
        this.procuratotateName = procuratotateName;
    }
}
