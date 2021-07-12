package com.schlumberger.app.services.impl;

import com.schlumberger.app.entities.CompanyDTO;
import com.schlumberger.app.entities.LegalCasesDTO;
import com.schlumberger.app.repositories.ConnectDataBaseSingleton;
import com.schlumberger.app.services.CompanyService;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class CompanyServiceImpl implements CompanyService {

    private static Logger log;

    public Connection connect() throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(ConnectDataBaseSingleton.class.getClassLoader().getResourceAsStream("application.properties"));
        return DriverManager.getConnection(properties.getProperty("url"), properties);
    }

    @Override
    public String addCompany(CompanyDTO companyData) throws IOException, SQLException {
        // Connect to database
        String SQL = "INSERT INTO COMPANY (REGISTER_NUMBER, COMPANY_NAME, DEPARTAMENT) "
                + "VALUES(?, ?, ?)";
        String result="";
        long id = 0;
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, companyData.getRegisterNumber());
            pstmt.setString(2, companyData.getCompanyName());
            pstmt.setString(3, companyData.getDepartament());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
               result="Data inserted successfully";   
            } else {
                result = "No insert apply"; 
                System.out.println("No insert apply");
                log.info("No insert apply");
            }
        } catch (SQLException ex) {
            System.out.println("CompanyServiceImpl_addCompany_SQLException_2: "+ ex.toString());
            log.info("CompanyServiceImpl_addCompany_SQLException_2: "+ex.toString());
            result = "Error inserting into DB: " + ex.toString();
        }
        return result;
    }

    @Override
    public List<CompanyDTO> consultCompany() throws IOException, SQLException {
        // Connect to database
        Properties properties = new Properties();
        properties.load(ConnectDataBaseSingleton.class.getClassLoader().getResourceAsStream("application.properties"));

        Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM COMPANY");
        CompanyDTO companyDTO = new CompanyDTO();
        List<CompanyDTO> listCompanies = new ArrayList<>();
        while (rs.next()) {
            System.out.println("Result REGISTER_NUMBER = " + rs.getString("REGISTER_NUMBER"));
            System.out.println("Result COMPANY NAME  = " + rs.getString("COMPANY_NAME"));
            System.out.println("Result DEPARTAMENT   = " + rs.getString("DEPARTAMENT"));
            System.out.println("==========================================");
            companyDTO.setCompanyName(rs.getString("COMPANY_NAME"));
            companyDTO.setRegisterNumber(rs.getString("REGISTER_NUMBER"));
            companyDTO.setDepartament(rs.getString("DEPARTAMENT"));
            listCompanies.add(companyDTO);
        }
        return listCompanies;
    }

    @Override
    public List<LegalCasesDTO> legalCases() throws IOException, SQLException {
        // Connect to database
        Properties properties = new Properties();
        properties.load(ConnectDataBaseSingleton.class.getClassLoader().getResourceAsStream("application.properties"));

        Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM LEGAL_CASES");
        LegalCasesDTO legalCasesDTO = new LegalCasesDTO();
        List<LegalCasesDTO> listLegalCases = new ArrayList<>();
        while (rs.next()) {
            System.out.println("Result LEGAL_CASE_NUMBER = " + rs.getString("LEGAL_CASE_NUMBER"));
            System.out.println("Result REGISTER_NUMBER = " + rs.getString("REGISTER_NUMBER"));
            System.out.println("Result DEPARTAMENT_CASE = " + rs.getString("DEPARTAMENT_CASE"));
            System.out.println("Result TOTAL = " + rs.getInt("TOTAL"));
            System.out.println("Result STATE_CASE = " + rs.getString("STATE_CASE"));
            System.out.println("Result STARTED = " + rs.getDate("STARTED"));
            System.out.println("==========================================");
            legalCasesDTO.setLegalCaseNumber(rs.getString("LEGAL_CASE_NUMBER"));
            legalCasesDTO.setRegisterNumber(rs.getString("REGISTER_NUMBER"));
            legalCasesDTO.setDepartamentCase(rs.getString("DEPARTAMENT_CASE"));
            legalCasesDTO.setTotal(rs.getInt("TOTAL"));
            legalCasesDTO.setStateCase(rs.getString("STATE_CASE"));
            legalCasesDTO.setStarted(rs.getDate("STARTED"));
            listLegalCases.add(legalCasesDTO);
        }
        return listLegalCases;
    }

    @Override
    public int calculateSumActiveLegalCases() throws IOException, SQLException {
        int totalActiveLegalCases = 0;
        // Connect to database
        Properties properties = new Properties();
        properties.load(ConnectDataBaseSingleton.class.getClassLoader().getResourceAsStream("application.properties"));

        Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT SUM(TOTAL) TOTAL_ACTIVE_LEGAl_CASES " +
                    "FROM LEGAL_CASES " +
                    "WHERE STATE_CASE = 'active'");
        while (rs.next()) {
            totalActiveLegalCases = rs.getInt("TOTAL_ACTIVE_LEGAl_CASES");
            System.out.println("Result TOTAL_ACTIVE_LEGAl_CASES = " + totalActiveLegalCases);
        }
        return totalActiveLegalCases;
    }

    @Override
    public int calculateAverageLegalCase() throws IOException, SQLException {

        int avergageLegalCase = 0;
        // Connect to database
        Properties properties = new Properties();
        properties.load(ConnectDataBaseSingleton.class.getClassLoader().getResourceAsStream("application.properties"));

        Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT ROUND(AVG(total),2) AVERAGE_LEGAL_CASE_RIO " +
                        "FROM LEGAL_CASES " +
                        "WHERE REGISTER_NUMBER = '00000000001' " +
                        "and DEPARTAMENT_CASE = 'Rio de Janeiro'");
        while (rs.next()) {
            avergageLegalCase = rs.getInt("AVERAGE_LEGAL_CASE_RIO");
            System.out.println("Result AVERAGE_LEGAL_CASE_RIO = " + avergageLegalCase);
        }
        return avergageLegalCase;
    }

    @Override
    public int calculateNumberLegalCases() throws IOException, SQLException {
        int calculateNumberLegalCases = 0;
        // Connect to database
        Properties properties = new Properties();
        properties.load(ConnectDataBaseSingleton.class.getClassLoader().getResourceAsStream("application.properties"));

        Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT count(*) AMOUNT_GREATER_HUNDRED_THOUSAND " +
                        "FROM LEGAL_CASES " +
                        "WHERE TOTAL > 100000; ");
        while (rs.next()) {
            calculateNumberLegalCases = rs.getInt("AMOUNT_GREATER_HUNDRED_THOUSAND");
            System.out.println("Result AMOUNT_GREATER_HUNDRED_THOUSAND = " + calculateNumberLegalCases);
        }
        return calculateNumberLegalCases;
    }

    @Override
    public List<LegalCasesDTO> listLegalCases() throws IOException, SQLException {

        // Connect to database
        Properties properties = new Properties();
        properties.load(ConnectDataBaseSingleton.class.getClassLoader().getResourceAsStream("application.properties"));

        Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * " +
                        "FROM LEGAL_CASES " +
                        "WHERE STARTED BETWEEN '01-SEP-2007' AND '30-SEP-2007'");
        LegalCasesDTO legalCasesDTO = new LegalCasesDTO();
        List<LegalCasesDTO> listLegalCases = new ArrayList<>();
        while (rs.next()) {
            System.out.println("listLegalCases_LEGAL_CASE_NUMBER = " + rs.getString("LEGAL_CASE_NUMBER"));
            System.out.println("listLegalCases_REGISTER_NUMBER = " + rs.getString("REGISTER_NUMBER"));
            System.out.println("listLegalCases_DEPARTAMENT_CASE = " + rs.getString("DEPARTAMENT_CASE"));
            System.out.println("listLegalCases_TOTAL = " + rs.getInt("TOTAL"));
            System.out.println("listLegalCases_STATE_CASE = " + rs.getString("STATE_CASE"));
            System.out.println("listLegalCases_STARTED = " + rs.getDate("STARTED"));
            System.out.println("==========================================");
            legalCasesDTO.setLegalCaseNumber(rs.getString("LEGAL_CASE_NUMBER"));
            legalCasesDTO.setRegisterNumber(rs.getString("REGISTER_NUMBER"));
            legalCasesDTO.setDepartamentCase(rs.getString("DEPARTAMENT_CASE"));
            legalCasesDTO.setTotal(rs.getInt("TOTAL"));
            legalCasesDTO.setStateCase(rs.getString("STATE_CASE"));
            legalCasesDTO.setStarted(rs.getDate("STARTED"));
            listLegalCases.add(legalCasesDTO);
        }
        return listLegalCases;
    }

    @Override
    public List<LegalCasesDTO> listLegalCasesSameDepartament() throws IOException, SQLException {

        // Connect to database
        Properties properties = new Properties();
        properties.load(ConnectDataBaseSingleton.class.getClassLoader().getResourceAsStream("application.properties"));
        
        Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * " +
                    "FROM LEGAL_CASES LG, COMPANY CO " +
                        "WHERE LG.REGISTER_NUMBER = CO.REGISTER_NUMBER " +
                        "and LG.DEPARTAMENT_CASE = CO.DEPARTAMENT");
        LegalCasesDTO legalCasesDTO = new LegalCasesDTO();
        CompanyDTO companyDTO = new CompanyDTO();
        List<LegalCasesDTO> listLegalCases = new ArrayList<>();
        while (rs.next()) {
            System.out.println("listLegalCases_LEGAL_CASE_NUMBER = " + rs.getString("LEGAL_CASE_NUMBER"));
            System.out.println("listLegalCases_REGISTER_NUMBER = " + rs.getString("REGISTER_NUMBER"));
            System.out.println("listLegalCases_DEPARTAMENT_CASE = " + rs.getString("DEPARTAMENT_CASE"));
            System.out.println("listLegalCases_TOTAL = " + rs.getInt("TOTAL"));
            System.out.println("listLegalCases_STATE_CASE = " + rs.getString("STATE_CASE"));
            System.out.println("listLegalCases_STARTED = " + rs.getDate("STARTED"));


            System.out.println("companyDTO_REGISTER_NUMBER = " + rs.getString("REGISTER_NUMBER"));
            System.out.println("companyDTO_COMPANY_NAME = " + rs.getString("COMPANY_NAME"));
            System.out.println("companyDTO_DEPARTAMENT = " + rs.getString("DEPARTAMENT"));

            System.out.println("==========================================");
            
            legalCasesDTO.setLegalCaseNumber(rs.getString("LEGAL_CASE_NUMBER"));
            legalCasesDTO.setRegisterNumber(rs.getString("REGISTER_NUMBER"));
            legalCasesDTO.setDepartamentCase(rs.getString("DEPARTAMENT_CASE"));
            legalCasesDTO.setTotal(rs.getInt("TOTAL"));
            legalCasesDTO.setStateCase(rs.getString("STATE_CASE"));
            legalCasesDTO.setStarted(rs.getDate("STARTED"));

            companyDTO.setDepartament(rs.getString("DEPARTAMENT"));
            companyDTO.setRegisterNumber(rs.getString("REGISTER_NUMBER"));
            companyDTO.setCompanyName(rs.getString("COMPANY_NAME"));

            legalCasesDTO.setCompany(companyDTO);
            listLegalCases.add(legalCasesDTO);
        }
        return listLegalCases;
    }
    @Override
    public List<LegalCasesDTO> listLegalCasesContainAcronymService() throws IOException, SQLException {
        String SQL ="SELECT legal_case_number,\n" +
                    "       register_number,\n" +
                    "	    departament_case,\n" +
                    "	    total,\n" +
                    "	    state_case,\n" +
                    "	    started\n" +
                    "  FROM LEGAL_CASES\n" +
                    "  WHERE legal_case_number like'%TRAB%' ";
        List<LegalCasesDTO> listLegalCasesContainAcronym = new ArrayList<>();
        LegalCasesDTO legalCasesDTO = new LegalCasesDTO();
        //CompanyDTO companyDTO = new CompanyDTO();
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL); 
                while (rs.next()) {
                 System.out.println("listLegalCases_LEGAL_CASE_NUMBER = " + rs.getString("LEGAL_CASE_NUMBER"));
                 System.out.println("listLegalCases_REGISTER_NUMBER = " + rs.getString("REGISTER_NUMBER"));
                 System.out.println("listLegalCases_DEPARTAMENT_CASE = " + rs.getString("DEPARTAMENT_CASE"));
                 System.out.println("listLegalCases_TOTAL = " + rs.getInt("TOTAL"));
                 System.out.println("listLegalCases_STATE_CASE = " + rs.getString("STATE_CASE"));
                 System.out.println("listLegalCases_STARTED = " + rs.getDate("STARTED"));
                 System.out.println("==========================================");
                 legalCasesDTO.setLegalCaseNumber(rs.getString("LEGAL_CASE_NUMBER"));
                 legalCasesDTO.setRegisterNumber(rs.getString("REGISTER_NUMBER"));
                 legalCasesDTO.setDepartamentCase(rs.getString("DEPARTAMENT_CASE"));
                 legalCasesDTO.setTotal(rs.getInt("TOTAL"));
                 legalCasesDTO.setStateCase(rs.getString("STATE_CASE"));
                 legalCasesDTO.setStarted(rs.getDate("STARTED"));
                 listLegalCasesContainAcronym.add(legalCasesDTO);
                 }                

        }  catch (SQLException ex) {
            System.out.println("listLegalCasesContainAcronymService_SQLException: "+ ex.toString());
            log.info("CompanyServiceImpl_addCompany_SQLException_2: "+ex.toString());
        }   
      return listLegalCasesContainAcronym;
    }
}
