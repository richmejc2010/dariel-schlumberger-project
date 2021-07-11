package com.schlumberger.app.services;

import com.schlumberger.app.entities.CompanyDTO;
import com.schlumberger.app.entities.LegalCasesDTO;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface CalculateService {

    BigInteger calculateActiveLegalClases (CompanyDTO data);

    BigInteger calculateAverageLegalCase (CompanyDTO data);

    int calculateNumberLegalCases (CompanyDTO data);

    List<LegalCasesDTO> getListLegalCases (Date date);

    List<CompanyDTO> getListLegalCasesSameDapartment (CompanyDTO data);

    List<CompanyDTO> getListLegalCasesContains (String acronym);
}
