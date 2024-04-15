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


public class Field_RequestTechnicalSupport implements Serializable{
     private String reason,show;
     private LocalDate date;

    public Field_RequestTechnicalSupport(String reason, String show, LocalDate date) {
        this.reason = reason;
        this.show = show;
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Field_RequestTechnicalSupport{" + "reason=" + reason + ", show=" + show + ", date=" + date + '}';
    }
     
     
     // Method to write  objects to a binary file
    public static boolean writeToFileToField_RequestTechnicalSupport(List<Field_RequestTechnicalSupport> support, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Field_RequestTechnicalSupport xyz : support) {
                oos.writeObject(xyz);
            System.out.println("Field_RequestTechnicalSupport generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing Field_RequestTechnicalSupport to file: " + e.getMessage());
           return false;
        }
    }

    
    
    // Method to read  from a binary file
    public static List< Field_RequestTechnicalSupport> readFromFileToField_RequestTechnicalSupport(String filename) {
        List<Field_RequestTechnicalSupport>support= new ArrayList<>(); 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof  Field_RequestTechnicalSupport) {
                        Field_RequestTechnicalSupport xyz = ( Field_RequestTechnicalSupport) obj;
                        support.add(xyz);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("  Field_RequestTechnicalSupport loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading Field_RequestTechnicalSupport from file: " + e.getMessage());
        }
        return support;
    }



    


    public static boolean addToInstanceToField_RequestTechnicalSupport( Field_RequestTechnicalSupport support, String filename) {
        // Read existing invoices from file
        List<Field_RequestTechnicalSupport>supports=readFromFileToField_RequestTechnicalSupport(filename);
       supports.add(support);
       // Write updated list of invoices back to the file
        return writeToFileToField_RequestTechnicalSupport(supports, filename);
    }


    
}
