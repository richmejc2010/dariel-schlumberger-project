package com.schlumberger.app.entities;

import java.sql.Date;

public class LegalCasesDTO {
    private String legalCaseNumber;
    private String registerNumber;
    private String departamentCase;
    private int total;
    private String stateCase;
    private Date started;
    private CompanyDTO company;

    public String getLegalCaseNumber() {
        return legalCaseNumber;
    }

    public void setLegalCaseNumber(String legalCaseNumber) {
        this.legalCaseNumber = legalCaseNumber;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getDepartamentCase() {
        return departamentCase;
    }

    public void setDepartamentCase(String departamentCase) {
        this.departamentCase = departamentCase;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStateCase() {
        return stateCase;
    }

    public void setStateCase(String stateCase) {
        this.stateCase = stateCase;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {        
        this.started = started;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }
}
