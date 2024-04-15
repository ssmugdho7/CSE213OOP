/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mugdho_2220644;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Reimbursement extends Employee {
    private String status;
    private float amount;
    private String expenseType;

    public Reimbursement(int empId, String empName, String empDesign, String paymentMethod,
                         String status, float amount, String expenseType) {
        super(empId, empName, empDesign, paymentMethod);
        this.status = status;
        this.amount = amount;
        this.expenseType = expenseType;
    }

    // Getters and setters

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "status='" + status + '\'' +
                ", amount=" + amount +
                ", expenseType='" + expenseType + '\'' +
                "} " + super.toString();
    }
//         Method to write Reimbursement objects to a binary file
    public static boolean writeToFile(List<Reimbursement> reimbursements, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Reimbursement reimbursement : reimbursements) {
                oos.writeObject(reimbursement);
            }
            System.out.println("Reimbursements written to file successfully.");
            return true;
        } catch (IOException e) {
            System.err.println("Error writing reimbursements to file: " + e.getMessage());
            return false;
        }
    }

    // Method to read reimbursements from a binary file
    public static List<Reimbursement> readFromFile(String filename) {
        List<Reimbursement> reimbursements = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Reimbursement) {
                        Reimbursement reimbursement = (Reimbursement) obj;
                        reimbursements.add(reimbursement);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("Reimbursements loaded from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading reimbursements from file: " + e.getMessage());
        }
        return reimbursements;
    }

    // Method to add a new reimbursement instance to the list and write to file
    public static boolean addReimbursement(Reimbursement reimbursement, String filename) {
        // Read existing reimbursements from file
        List<Reimbursement> existingReimbursements = readFromFile(filename);
        existingReimbursements.add(reimbursement);
        // Write updated list of reimbursements back to the file
        return writeToFile(existingReimbursements, filename);
    }
    
    }




