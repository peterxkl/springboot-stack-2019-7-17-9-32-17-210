package com.tw.apistackbase.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long time;
    @OneToMany(targetEntity=CaseDetail.class)
    @JoinColumn(name="caseDetail_id",referencedColumnName="id")
    private Set<CaseDetail> caseDetails = new HashSet<>();

    public Case(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Set<CaseDetail> getCaseDetails() {
        return caseDetails;
    }

    public void setCaseDetails(Set<CaseDetail> caseDetails) {
        this.caseDetails = caseDetails;
    }
}
