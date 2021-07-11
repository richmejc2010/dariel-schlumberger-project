package com.schlumberger.app.services;

import com.schlumberger.app.entities.CompanyDTO;

import java.io.IOException;
import java.sql.SQLException;

public interface CompanyService {

    CompanyDTO addCompany(CompanyDTO companyData) throws IOException, SQLException;
}
