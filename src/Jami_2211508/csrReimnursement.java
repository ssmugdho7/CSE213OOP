package Jami_2211508;

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


public class csrReimnursement implements Serializable{
    private float amount;
    protected String name,designation, expanse;
    protected LocalDate date;

    public csrReimnursement() {
    }

    public csrReimnursement( LocalDate date, String name, String designation, String expanse,  float amount) {
        this.date = date;
        this.name = name;
        this.designation = designation;
        this.expanse = expanse;
        this.amount = amount;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getExpanse() {
        return expanse;
    }

    public void setExpanse(String expanse) {
        this.expanse = expanse;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "csrReimnursement{" + "amount=" + amount + ", name=" + name + ", designation=" + designation + ", expanse=" + expanse + ", date=" + date + '}';
    }

   

    
 
    public static boolean writeToFileForRequestingReimbursement(List<csrReimnursement> reimbursements, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (csrReimnursement reimbursement : reimbursements) {
                oos.writeObject(reimbursement);
            System.out.println("reimbursements generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing reimbursements to file: " + e.getMessage());
           return false;
        }
    }

  
    public static List<csrReimnursement> readFromFileForRequestingReimbursement(String filename) {
        List<csrReimnursement> reimbursements = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof csrReimnursement) {
                        csrReimnursement reimbursement = (csrReimnursement) obj;
                        reimbursements.add(reimbursement);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("Reimbursements loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading reimbursements from file: " + e.getMessage());
        }
        return reimbursements;
    }



   
    public static boolean addToInstanceForRequestingReimbursement(csrReimnursement reimnursement, String filename) {
        
        List<csrReimnursement> reimbursements = readFromFileForRequestingReimbursement(filename);
        reimbursements.add(reimnursement);
     
        return writeToFileForRequestingReimbursement(reimbursements, filename);
    }

    
}
