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
import javafx.collections.ObservableList;


public class Reimbursement implements Serializable{

    private String employeeName;
    private Float expenseAmount;
    private LocalDate reimbursementDate;
    private String designation;
    private String paymentMethod;
     private String expenseDistribution;

    @Override
    public String toString() {
        return "Reimbursement{" + "employeeName=" + employeeName + ", expenseAmount=" + expenseAmount + ", reimbursementDate=" + reimbursementDate + ", designation=" + designation + ", paymentMethod=" + paymentMethod + ", expenseDistribution=" + expenseDistribution + '}';
    }

    public Reimbursement(String employeeName, Float expenseAmount, LocalDate reimbursementDate, String designation, String paymentMethod, String expenseDistribution) {
        this.employeeName = employeeName;
        this.expenseAmount = expenseAmount;
        this.reimbursementDate = reimbursementDate;
        this.designation = designation;
        this.paymentMethod = paymentMethod;
        this.expenseDistribution = expenseDistribution;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Float getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Float expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public LocalDate getReimbursementDate() {
        return reimbursementDate;
    }

    public void setReimbursementDate(LocalDate reimbursementDate) {
        this.reimbursementDate = reimbursementDate;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getExpenseDistribution() {
        return expenseDistribution;
    }

    public void setExpenseDistribution(String expenseDistribution) {
        this.expenseDistribution = expenseDistribution;
    }
    
     
    //request reimbursement
    public static boolean writeReimbursements(ObservableList<Reimbursement> reimbursements, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (Reimbursement reimbursement : reimbursements) {
                oos.writeObject(reimbursement);
            }

            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Reimbursement> loadReimbursements(String fileName) {
        ArrayList<Reimbursement> existingReimbursements = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    Reimbursement reimbursement = (Reimbursement) ois.readObject();
                    existingReimbursements.add(reimbursement);
                } catch (EOFException eof) {
                    // End of file reached, break the loop
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return existingReimbursements;
    }

   //-----------------
    
       
    
}
