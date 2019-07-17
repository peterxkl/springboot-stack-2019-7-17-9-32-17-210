package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
public class CaseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caseId;
    @Column(nullable = false)
    private String subCondition;
    @Column(nullable = false)
    private String obCondition;
    @ManyToOne(targetEntity=Case.class)
    @JoinColumn(name="caseDetail_id",referencedColumnName="id")
    private Case aCase;

    public CaseDetail(String subCondition, String obCondition) {
        this.subCondition = subCondition;
        this.obCondition = obCondition;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getSubCondition() {
        return subCondition;
    }

    public void setSubCondition(String subCondition) {
        this.subCondition = subCondition;
    }

    public String getObCondition() {
        return obCondition;
    }

    public void setObCondition(String obCondition) {
        this.obCondition = obCondition;
    }

    public Case getaCase() {
        return aCase;
    }

    public void setaCase(Case aCase) {
        this.aCase = aCase;
    }
}
