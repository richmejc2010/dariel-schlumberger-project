package com.schlumberger.app.services.impl;

import com.schlumberger.app.entities.CompanyDTO;
import com.schlumberger.app.repositories.CompanyRepository;
import com.schlumberger.app.repositories.ConnectDataBaseSingleton;
import com.schlumberger.app.services.CompanyService;

import java.io.IOException;
import java.sql.SQLException;

public class CompanyServiceImpl implements CompanyService {

    @Override
    public CompanyDTO addCompany(CompanyDTO companyData) throws IOException, SQLException {
        // Connect to database

        ConnectDataBaseSingleton connectBD = ConnectDataBaseSingleton.getInstance();
        CompanyRepository companyBD = new CompanyRepository();
        return null;
    }
}
