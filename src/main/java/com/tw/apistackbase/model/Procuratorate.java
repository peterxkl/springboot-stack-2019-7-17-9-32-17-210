package com.tw.apistackbase.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int procuratotateId;
    @Column(nullable = false , unique = true)
    private String procuratotateName;
    @OneToMany(targetEntity=Case.class)
    @JoinColumn(name="case_id",referencedColumnName="procuratotateId")
    private Set<Case> cases = new HashSet<>();
    @OneToMany(targetEntity=Inquisitor.class)
    @JoinColumn(name="procuratotate_Id",referencedColumnName="procuratotateId")
    private Set<Inquisitor> inquisitors = new HashSet<>();

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

    public Set<Case> getCases() {
        return cases;
    }

    public void setCases(Set<Case> cases) {
        this.cases = cases;
    }

    public Set<Inquisitor> getInquisitors() {
        return inquisitors;
    }

    public void setInquisitors(Set<Inquisitor> inquisitors) {
        this.inquisitors = inquisitors;
    }
}
