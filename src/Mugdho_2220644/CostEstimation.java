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

    // Method to write CostEstimation objects to a file
    public static void writeToFile(ArrayList<CostEstimation> costEstimations, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename,true))) {
            for (CostEstimation costEstimation : costEstimations) {
                oos.writeObject(costEstimation);
            }
            System.out.println("Cost estimations saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing cost estimations to file: " + e.getMessage());
        }
    }



     // Method to read CostEstimation objects from a binary file
    public static ArrayList<CostEstimation> readFromFile(String filename) {
        ArrayList<CostEstimation> costEstimations = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    // Read an object from the file
                    Object obj = ois.readObject();
                    if (obj instanceof CostEstimation) {
                        // If the object is an instance of CostEstimation, add it to the list
                        CostEstimation costEstimation = (CostEstimation) obj;
                        costEstimations.add(costEstimation);
                    }
                } catch (EOFException e) {
                    // End of file reached
                    break;
                }
            }
            System.out.println("Cost estimations loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading cost estimations from file: " + e.getMessage());
        }
        return costEstimations;
    }








}


