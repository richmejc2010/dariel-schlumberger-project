package com.schlumberger.app;

import com.schlumberger.app.entities.CompanyDTO;
import com.schlumberger.app.entities.LegalCasesDTO;
import com.schlumberger.app.services.CompanyService;
import com.schlumberger.app.services.impl.CompanyServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

public class App {
    private static Logger log;
    
    public static void main( String[] args ) throws IOException, SQLException {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        boolean flagMenu = false;
    
        while (!flagMenu){
            menu();
            int  value_in = Integer.parseInt(myObj.nextLine());               
            switch (value_in) {
                case 1 : //"CALCULATE_SUM_ACTIVE_LEGAL_CASES":
                    calculateSumLegal();
                    break;
                case 2://"CALCULATE_AVERAGE_LEGAL_CASE":
                    calculateAverageLegalCase();    
                    break;
                case 3://"CALCULATE_NUMBER_LEGAL_CASES":
                    calculateNumberLegalCases();
                    break;
                case 4://"LIST_LEGAL_CASES":
                    listLegalCases();
                    break;
                case 5://"LIST_LEGAL_CASES_SAME_DEPARTAMENT":
                    listLegalCasesSameDepartment();
                    break;
                case 6://"LIST_LEGAL_CASES_CONTAIN_ACRONYM":
                    listLegalCasesContainAcronym();
                    break;
                case 7:
                    // insert into DATA BASE
                    CompanyDTO companyDTO = new CompanyDTO();

                    System.out.println("Enter company name");
                    String companyName = myObj.nextLine();
                    companyDTO.setCompanyName(companyName);

                    System.out.println("Enter Register Number");
                    String registerNumber = myObj.nextLine();
                    companyDTO.setRegisterNumber(registerNumber);

                    System.out.println("Enter Departament");
                    String departament = myObj.nextLine();
                    companyDTO.setDepartament(departament);
                    
                    CompanyService company = new CompanyServiceImpl();
                    company.addCompany(companyDTO); 
                    break;
                case 8:
                    companyQuery();
                    break;
                case 9:
                    legalCasesQuery();
                    break;                
                case 0://Exit
                    flagMenu= true;
                    System.out.println("Thanks for using Schulmber Demo System ");
                    break;                
                case 10: //Insert Legal Case
                                    // insert into DATA BASE
                    LegalCasesDTO legalcaseDTO = new LegalCasesDTO();

                    System.out.println("Enter Legal Case Number");
                    String legalCaseNumber = myObj.nextLine();
                    legalcaseDTO.setLegalCaseNumber(legalCaseNumber); 

                    System.out.println("Enter Register Number");
                    String registerNumberLegal = myObj.nextLine();
                    legalcaseDTO.setRegisterNumber(registerNumberLegal);

                    System.out.println("Enter Departament Case");
                    String departamentLegalCase = myObj.nextLine();
                    legalcaseDTO.setDepartamentCase(departamentLegalCase);
                    
                    System.out.println("Total Amount Legal Case");
                    int totalLegalCase = Integer.parseInt(myObj.nextLine());
                    legalcaseDTO.setTotal(totalLegalCase);         
                    
                    System.out.println("State Legal Case");
                    String stateLegalCase = myObj.nextLine();
                    legalcaseDTO.setStateCase(stateLegalCase);    
                    
                    CompanyService legalCase = new CompanyServiceImpl();
                    legalCase.addLegalCase(legalcaseDTO); 
                    break;    
                default: // Invalid Option
                      System.out.println("Invalid Option");
                      break;
            }
          }
    }
    
    public static void menu(){
            System.out.println("Menú:" +
              "\n***************************************************************************************************" +
              "\n***************************************************************************************************" +  
              "\n**"+"   1. Total (SUM) of the active legal cases." + "                                                  "+"**" +  
              "\n**"+"   2. Average of the legal case in Rio de Janeiro for the client “Company A”." + "                 "+"**" + 
              "\n**"+"   3. Calculate the number of legal cases with the amount greater than USD 100.000,00." + "        "+"**" +   
              "\n**"+"   4. List of legal cases on the month of September and year 2007." + "                            "+"**" + 
              "\n**"+"   5. List of legal case with the same department of the client." + "                              "+"**" + 
              "\n**"+"   6. List of legal cases that contains the acronym “TRAB”." + "                                   "+"**" + 
              "\n**"+"   7. Entering records COMPANY." + "                                                               "+"**" + 
              "\n**"+"   8. Gettting Recors From COMPANY." + "                                                           "+"**" +    
              "\n**"+"   9. List of legal cases on the month of September and year 2007." + "                            "+"**" + 
              "\n**"+"   10. Gettting Recors From LEGAL CASES." + "                                                      "+"**" + 
              "\n**"+"   0. Exit." + "                                                                                  "+"**" +
              "\n***************************************************************************************************" +
              "\n***************************************************************************************************"   
                );
        System.out.println("Enter Option(Numeric value 1 - 10):");
       
    }
    
    public static void calculateSumLegal() {
        try{
         CompanyService calculateSumLegalService = new CompanyServiceImpl();
         calculateSumLegalService.calculateSumActiveLegalCases();
        }catch( SQLException sql){
            log.info("calculateSumLegal_SQLException_2: "+sql.toString());             
        }
        catch( IOException ioe){
            log.info("calculateSumLegal_SQLException_2: "+ioe.toString());             
        }
         catch( Exception ex){
            log.info("calculateSumLegal_SQLException_2: "+ex.toString());             
        }       
    }
    
    public static void calculateAverageLegalCase(){
        try{
         CompanyService calculateAverageService = new CompanyServiceImpl();
         calculateAverageService.calculateAverageLegalCase();
        }catch( SQLException sql){
            log.info("calculateAverageLegalCase_SQLException_2: "+sql.toString());             
        }
        catch( IOException ioe){
            log.info("calculateAverageLegalCase_SQLException_2: "+ioe.toString());             
        }
         catch( Exception ex){
            log.info("calculateAverageLegalCase_SQLException_2: "+ex.toString());             
        }    
    }
    
    public static void calculateNumberLegalCases(){
        try{
         CompanyService calculateNumberLegalCasesService = new CompanyServiceImpl();
         calculateNumberLegalCasesService.calculateNumberLegalCases();
        }catch( SQLException sql){
            log.info("calculateNumberLegalCases_SQLException_2: "+sql.toString());             
        }
        catch( IOException ioe){
            log.info("calculateNumberLegalCases_SQLException_2: "+ioe.toString());             
        }
         catch( Exception ex){
            log.info("calculateNumberLegalCases_SQLException_2: "+ex.toString());             
        }    
    }   

    public static void listLegalCases(){
        try{
         CompanyService listLegalCasesService = new CompanyServiceImpl();
         listLegalCasesService.listLegalCases();
        }catch( SQLException sql){
            log.info("listLegalCases_SQLException_2: "+sql.toString());             
        }
        catch( IOException ioe){
            log.info("listLegalCases_SQLException_2: "+ioe.toString());             
        }
         catch( Exception ex){
            log.info("listLegalCases_SQLException_2: "+ex.toString());             
        }    
    } 

    public static void listLegalCasesSameDepartment(){
        try{
        CompanyService listLegalCasesSameDepartamentService = new CompanyServiceImpl();
        listLegalCasesSameDepartamentService.listLegalCasesSameDepartament();
        }catch( SQLException sql){
            log.info("listLegalCasesSameDepartment_SQLException_2: "+sql.toString());             
        }
        catch( IOException ioe){
            log.info("listLegalCasesSameDepartment_SQLException_2: "+ioe.toString());             
        }
         catch( Exception ex){
            log.info("listLegalCasesSameDepartment_SQLException_2: "+ex.toString());             
        }   
    }     
    public static void listLegalCasesContainAcronym(){
        try{
        CompanyService listLegalCasesContainAcronymService = new CompanyServiceImpl();
        listLegalCasesContainAcronymService.listLegalCasesContainAcronymService();  
        }catch( SQLException sql){
            log.info("listLegalCasesContainAcronym_SQLException_2: "+sql.toString());             
        }
        catch( IOException ioe){
            log.info("listLegalCasesContainAcronym_SQLException_2: "+ioe.toString());             
        }
         catch( Exception ex){
            log.info("listLegalCasesContainAcronym_SQLException_2: "+ex.toString());             
        }   
    }    
 
    public static void companyQuery(){
        try{
        CompanyService companyConsultService = new CompanyServiceImpl();
        companyConsultService.consultCompany();
        }catch( SQLException sql){
            log.info("companyQuery_SQLException_2: "+sql.toString());             
        }
        catch( IOException ioe){
            log.info("companyQuery_SQLException_2: "+ioe.toString());             
        }
         catch( Exception ex){
            log.info("companyQuery_SQLException_2: "+ex.toString());             
        }   
    }    
     public static void legalCasesQuery(){
        try{ 
        CompanyService legalCasesService = new CompanyServiceImpl();
        legalCasesService.legalCases();
        }catch( SQLException sql){
            log.info("legalCasesQuery: "+sql.toString());             
        }
        catch( IOException ioe){
            log.info("legalCasesQuery_SQLException_2: "+ioe.toString());             
        }
         catch( Exception ex){
            log.info("legalCasesQuery_SQLException_2: "+ex.toString());             
        }  
    }    


                    
}
