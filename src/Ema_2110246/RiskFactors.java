/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ema_2110246;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RiskFactors implements Serializable {
    private String riskCategory;
    private String riskFactorDescription;
    private String recommendations;
    private LocalDate assessmentDate;

    public RiskFactors(String riskCategory, String riskFactorDescription, String recommendations, LocalDate assessmentDate) {
        this.riskCategory = riskCategory;
        this.riskFactorDescription = riskFactorDescription;
        this.recommendations = recommendations;
        this.assessmentDate = assessmentDate;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public String getRiskFactorDescription() {
        return riskFactorDescription;
    }

    public void setRiskFactorDescription(String riskFactorDescription) {
        this.riskFactorDescription = riskFactorDescription;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public LocalDate getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(LocalDate assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    @Override
    public String toString() {
        return "RiskFactors{" + "riskCategory=" + riskCategory + ", riskFactorDescription=" + riskFactorDescription + ", recommendations=" + recommendations + ", assessmentDate=" + assessmentDate + '}';
    }
    
    
    
    
    
    // Method to write Invoice objects to a binary file
    public static boolean writeToFileToRiskFactors(List<RiskFactors> factor, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (RiskFactors xyz : factor) {
                oos.writeObject(xyz);
            System.out.println("RiskFactors generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing RiskFactors to file: " + e.getMessage());
           return false;
        }
    }

    
    
    // Method to read invoices from a binary file
    public static List< RiskFactors> readFromFileToRiskFactors(String filename) {
        List<RiskFactors>factor= new ArrayList<>(); 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof  RiskFactors) {
                        RiskFactors xyz = ( RiskFactors) obj;
                        factor.add(xyz);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("  RiskFactors loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading RiskFactors from file: " + e.getMessage());
        }
        return factor;
    }



    // Method to add a new instance to the list and write to file


    public static boolean addToInstanceToRiskFactors(RiskFactors factor, String filename) {
        // Read existing invoices from file
        List<RiskFactors>factors=readFromFileToRiskFactors(filename);
       factors.add(factor);
       // Write updated list of invoices back to the file
        return writeToFileToRiskFactors(factors, filename);
    }

//inoivces = old invoice 
//invoice = new invoice
   
    //support= new support 
    // supports= old support
    //suppt= new support 
    // suppts= old supp
    // factor = new factor
    // factors = old factor
}
