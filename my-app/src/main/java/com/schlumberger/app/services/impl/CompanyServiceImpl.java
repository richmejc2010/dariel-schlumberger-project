package com.schlumberger.app.services.impl;

import com.schlumberger.app.entities.CompanyDTO;
import com.schlumberger.app.repositories.CompanyRepository;
import com.schlumberger.app.repositories.ConnectDataBaseSingleton;
import com.schlumberger.app.services.CompanyService;

import java.io.IOException;
import java.sql.*;
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
    public CompanyDTO addCompany(CompanyDTO companyData) throws IOException, SQLException {
        // Connect to database
        String SQL = "INSERT INTO test (numberId, name) "
                + "VALUES(?,?)";

        long id = 0;
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, companyData.getNumberID());
            pstmt.setString(2, companyData.getCompanyName());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        log.info("Database connection test id: " + id);
        return null;
    }

    @Override
    public CompanyDTO consultCompany() throws IOException, SQLException {
        // Connect to database
        Properties properties = new Properties();
        properties.load(ConnectDataBaseSingleton.class.getClassLoader().getResourceAsStream("application.properties"));

        Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM test");
        CompanyDTO companyDTO = new CompanyDTO();
        while (rs.next()) {
            System.out.print("Result numberId = " + rs.getInt("numberId"));
            System.out.print("Result Name = " + rs.getString("name"));
            companyDTO.setCompanyName(rs.getString("name"));
            companyDTO.setNumberID(rs.getInt("numberId"));
        }
        return companyDTO;
    }


}
