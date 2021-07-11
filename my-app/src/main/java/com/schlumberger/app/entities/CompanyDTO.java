package com.schlumberger.app.entities;

import java.util.Date;

public class CompanyDTO {
    private long activeLegalCases;
    private int numberID;
    private String companyName;
    private String department;
    private Date Date;
    private String legalCaseNumber;
    private Status status;
    private String registerNumber;

    public long getActiveLegalCases() {
        return activeLegalCases;
    }

    public void setActiveLegalCases(long activeLegalCases) {
        this.activeLegalCases = activeLegalCases;
    }

    public int getNumberID() {
        return numberID;
    }

    public void setNumberID(int numberID) {
        this.numberID = numberID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getLegalCaseNumber() {
        return legalCaseNumber;
    }

    public void setLegalCaseNumber(String legalCaseNumber) {
        this.legalCaseNumber = legalCaseNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }
}
