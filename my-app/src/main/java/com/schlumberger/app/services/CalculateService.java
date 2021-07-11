package com.schlumberger.app.services;

import com.schlumberger.app.entities.CompanyDTO;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface CalculateService {

    BigInteger calculateActiveLegalClases (CompanyDTO data);

    BigInteger calculateAverageLegalCase (CompanyDTO data);

    int calculateNumberLegalCases (CompanyDTO data);

    List<CompanyDTO> getListLegalCases (Date date);

    List<CompanyDTO> getListLegalCasesSameDapartment (CompanyDTO data);

    List<CompanyDTO> getListLegalCasesContains (String acronym);
}
