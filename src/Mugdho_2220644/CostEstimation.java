/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mugdho_2220644;

/**
 *
 * @author Lenovo
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CostEstimation implements Serializable {

    private int subscriber;
    private float revenue;
    private float fixedCosts;
    private float variableCosts;
    private float additionalCost;

    public CostEstimation(int subscriber, float revenue, float fixedCosts, float variableCosts, float additionalCost) {
        this.subscriber = subscriber;
        this.revenue = revenue;
        this.fixedCosts = fixedCosts;
        this.variableCosts = variableCosts;
        this.additionalCost = additionalCost;
    }

    // Getters and setters

    public int getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(int subscriber) {
        this.subscriber = subscriber;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public float getFixedCosts() {
        return fixedCosts;
    }

    public void setFixedCosts(float fixedCosts) {
        this.fixedCosts = fixedCosts;
    }

    public float getVariableCosts() {
        return variableCosts;
    }

    public void setVariableCosts(float variableCosts) {
        this.variableCosts = variableCosts;
    }

    public float getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(float additionalCost) {
        this.additionalCost = additionalCost;
    }

    @Override
    public String toString() {
        return "CostEstimation{" +
                "subscriber=" + subscriber +
                ", revenue=" + revenue +
                ", fixedCosts=" + fixedCosts +
                ", variableCosts=" + variableCosts +
                ", additionalCost=" + additionalCost +
                '}';
    }



   // Method to write Invoice objects to a binary file
    public static boolean writeToFileToEstimateCost(List<CostEstimation> costs, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (CostEstimation est : costs) {
                oos.writeObject(est);
            System.out.println("Invoices generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing invoices to file: " + e.getMessage());
           return false;
        }
    }

    // Method to read invoices from a binary file
    public static List<CostEstimation> readFromFileToEstimateCost(String filename) {
        List<CostEstimation> costs = new ArrayList<>(); 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof CostEstimation) {
                        CostEstimation est = (CostEstimation) obj;
                        costs.add(est);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("Invoices loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading invoices from file: " + e.getMessage());
        }
        return costs;
    }



    // Method to add a new instance to the list and write to file
    public static boolean addToInstanceToEstimateCost(CostEstimation cost, String filename) {
        // Read existing invoices from file
        List<CostEstimation> costs = readFromFileToEstimateCost(filename);
        costs.add(cost);
       // Write updated list of invoices back to the file
        return writeToFileToEstimateCost(costs, filename);
    }






}


