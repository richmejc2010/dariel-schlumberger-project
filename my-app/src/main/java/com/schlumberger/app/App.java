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
                String numberId = myObj.nextLine();
                companyDTO.setRegisterNumber(numberId);
                CompanyService company = new CompanyServiceImpl();
                company.addCompany(companyDTO);
                break;
            case "C":
                CompanyService companyConsultService = new CompanyServiceImpl();
                companyConsultService.consultCompany();
                break;
            case "L":
                CompanyService legalCasesService = new CompanyServiceImpl();
                legalCasesService.legalCases();
                break;
            case "CALCULATE_SUM_ACTIVE_LEGAL_CASES":
                CompanyService calculateSumLegalService = new CompanyServiceImpl();
                calculateSumLegalService.calculateSumActiveLegalCases();
                break;
            case "CALCULATE_AVERAGE_LEGAL_CASE":
                CompanyService calculateAverageService = new CompanyServiceImpl();
                calculateAverageService.calculateAverageLegalCase();
                break;
            case "CALCULATE_NUMBER_LEGAL_CASES":
                CompanyService calculateNumberLegalCasesService = new CompanyServiceImpl();
                calculateNumberLegalCasesService.calculateNumberLegalCases();
                break;
            case "LIST_LEGAL_CASES":
                CompanyService listLegalCasesService = new CompanyServiceImpl();
                listLegalCasesService.listLegalCases();
                break;
            case "LIST_LEGAL_CASES_SAME_DEPARTAMENT":
                CompanyService listLegalCasesSameDepartamentService = new CompanyServiceImpl();
                listLegalCasesSameDepartamentService.listLegalCasesSameDepartament();
                break;
            case "LIST_LEGAL_CASES_CONTAIN_TRAB":
                //Missing this implementation
                break;
            case "Q":
                System.exit(0);
                break;
            default:
//                throw new InvalidInputException("Invalid command!");
        }

    }
}
