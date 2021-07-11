package com.schlumberger.app;

import com.schlumberger.app.entities.CompanyDTO;
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
        System.out.println("Enter Command");

        String command = myObj.nextLine();  // Read user input

        switch (command) {
            case "A":
                // insert into DATA BASE
                System.out.println("Enter company name");
                String companyName = myObj.nextLine();
                CompanyDTO companyDTO = new CompanyDTO();
                companyDTO.setCompanyName(companyName);

                System.out.println("Enter numberID");
                int numberId = myObj.nextInt();
                companyDTO.setNumberID(numberId);
                CompanyService company = new CompanyServiceImpl();
                company.addCompany(companyDTO);
                break;
            case "C":
                CompanyService companyConsult = new CompanyServiceImpl();
                companyConsult.consultCompany();
            case "M":
//                return new Line();
            case "Q":
                System.exit(0);
            default:
//                throw new InvalidInputException("Invalid command!");
        }

    }
}
