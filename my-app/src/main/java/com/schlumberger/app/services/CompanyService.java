package com.schlumberger.app.services;

import com.schlumberger.app.entities.CompanyDTO;
import com.schlumberger.app.entities.LegalCasesDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CompanyService {

    String addCompany(CompanyDTO companyData) throws IOException, SQLException;

    List<CompanyDTO> consultCompany() throws IOException, SQLException;

    List<LegalCasesDTO> legalCases() throws IOException, SQLException;

    int calculateSumActiveLegalCases() throws IOException, SQLException;

    int calculateAverageLegalCase() throws IOException, SQLException;

    int calculateNumberLegalCases() throws IOException, SQLException;

    List<LegalCasesDTO> listLegalCases() throws IOException, SQLException;

    List<LegalCasesDTO> listLegalCasesSameDepartament() throws IOException, SQLException;
    
    List<LegalCasesDTO> listLegalCasesContainAcronymService()throws IOException, SQLException ;
    
    String addLegalCase(LegalCasesDTO legalCaseData) throws IOException, SQLException;
    
}
