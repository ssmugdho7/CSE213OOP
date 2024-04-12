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
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ProcessReimbursement implements Serializable {
  String empName, designation, expenseType; 
  LocalDate expenseDate; 
  Float amount ;  

    public ProcessReimbursement(String empName, String designation, String expenseType, LocalDate expenseDate, Float amount) {
        this.empName = empName;
        this.designation = designation;
        this.expenseType = expenseType;
        this.expenseDate = expenseDate;
        this.amount = amount;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProcessReimbursement{" + "empName=" + empName + ", designation=" + designation + ", expenseType=" + expenseType + ", expenseDate=" + expenseDate + ", amount=" + amount + '}';
    }



    
   // Method to write Invoice objects to a binary file
    public static boolean writeToFileToProcessReimbursement(List<ProcessReimbursement> processes, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (ProcessReimbursement xyz : processes) {
                oos.writeObject(xyz);
            System.out.println("Invoices generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing invoices to file: " + e.getMessage());
           return false;
        }
    }

    // Method to read invoices from a binary file
    public static List<ProcessReimbursement> readFromFileToProcessReimbursement(String filename) {
        List<ProcessReimbursement> processes = new ArrayList<>(); 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof ProcessReimbursement) {
                        ProcessReimbursement xyz = (ProcessReimbursement) obj;
                        processes.add(xyz);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("Invoices loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading invoices from file: " + e.getMessage());
        }
        return processes;
    }



    // Method to add a new instance to the list and write to file


    public static boolean addToInstanceToProcessReimbursement(ProcessReimbursement process, String filename) {
        // Read existing invoices from file
        List<ProcessReimbursement>processes= readFromFileToProcessReimbursement(filename);
        processes.add(process);
       // Write updated list of invoices back to the file
        return writeToFileToProcessReimbursement(processes, filename);
    }

//inoivces = old invoice 
//invoice = new invoice
    
}
