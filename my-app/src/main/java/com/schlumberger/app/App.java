package com.schlumberger.app;

import com.schlumberger.app.entities.CompanyDTO;
import com.schlumberger.app.entities.Status;
import com.schlumberger.app.services.CompanyService;
import com.schlumberger.app.services.impl.CompanyServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException, SQLException {
        System.out.println( "Hello World!" );
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        String userName = myObj.nextLine();  // Read user input
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCompanyName(userName);
        System.out.println("Username is: " + userName);  // Output user input
        Status myVar = Status.MEDIUM;
        System.out.println("Username is: " + myVar);  // Output user input

        String numberID = myObj.nextLine();  // Read user input
        System.out.println("numberID is: " + numberID);  // Output user input
        companyDTO.setNumberID((Integer.parseInt(numberID)));

        // insert into DATA BASE
        CompanyService company = new CompanyServiceImpl();
        company.addCompany(companyDTO);
    }
}
