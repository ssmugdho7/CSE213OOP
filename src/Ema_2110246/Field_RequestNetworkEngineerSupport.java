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


public class Field_RequestNetworkEngineerSupport implements Serializable{
    
    private String reason,device,issue,address;
    private int customerId;
    private LocalDate date;

    public Field_RequestNetworkEngineerSupport(String reason, String device, String issue, String address, int customerId, LocalDate date) {
        this.reason = reason;
        this.device = device;
        this.issue = issue;
        this.address = address;
        this.customerId = customerId;
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Field_RequestNetworkEngineerSupport{" + "reason=" + reason + ", device=" + device + ", issue=" + issue + ", address=" + address + ", customerId=" + customerId + ", date=" + date + '}';
    }
    
    
    
    
    // Method to write I objects to a binary file
    public static boolean writeToFileToField_RequestNetworkEngineerSupport(List<Field_RequestNetworkEngineerSupport> suppt, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Field_RequestNetworkEngineerSupport xyz : suppt) {
                oos.writeObject(xyz);
            System.out.println("Field_RequestNetworkEngineerSupport generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing Field_RequestNetworkEngineerSupport to file: " + e.getMessage());
           return false;
        }
    }

    
    
    // Method to read  from a binary file
    public static List< Field_RequestNetworkEngineerSupport> readFromFileToField_RequestNetworkEngineerSupport(String filename) {
        List<Field_RequestNetworkEngineerSupport>suppt= new ArrayList<>(); 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof  Field_RequestNetworkEngineerSupport) {
                        Field_RequestNetworkEngineerSupport xyz = ( Field_RequestNetworkEngineerSupport) obj;
                        suppt.add(xyz);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("  Field_RequestNetworkEngineerSupport loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading Field_RequestNetworkEngineerSupport from file: " + e.getMessage());
        }
        return suppt;
    }



    // Method to add a new instance to the list and write to file


    public static boolean addToInstanceToField_RequestNetworkEngineerSupport(Field_RequestNetworkEngineerSupport suppt, String filename) {
        // Read existing invoices from file
        List<Field_RequestNetworkEngineerSupport>suppts=readFromFileToField_RequestNetworkEngineerSupport(filename);
       suppts.add(suppt);
       // Write updated list of invoices back to the file
        return writeToFileToField_RequestNetworkEngineerSupport(suppts, filename);
    }


}
