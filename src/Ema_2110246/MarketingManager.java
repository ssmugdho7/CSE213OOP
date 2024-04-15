/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ema_2110246;

import java.io.Serializable;


public class MarketingManager implements Serializable {
   /* //request reimbursement
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

   //-----------------*/
   /* // Method to write Invoice objects to a binary file
    public static boolean writeToFileToPackagesRate(List<PackagesRate>packag, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (PackagesRate xyz : packag) {
                oos.writeObject(xyz);
            System.out.println("PackagesRate generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing PackagesRate to file: " + e.getMessage());
           return false;
        }
    }

    
    
    // Method to read  from a binary file
    public static List<PackagesRate> readFromFileToPackagesRate(String filename) {
        List<PackagesRate>packag= new ArrayList<>(); 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof  PackagesRate) {
                        PackagesRate xyz = ( PackagesRate) obj;
                        packag.add(xyz);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("  PackagesRate loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading PackagesRate from file: " + e.getMessage());
        }
        return packag;
    }



    // Method to add a new instance to the list and write to file


    public static boolean addToInstanceToPackagesRate(PackagesRate packag, String filename) {
        // Read existing invoices from file
        List<PackagesRate>packags=readFromFileToPackagesRate(filename);
      packags.add(packag);
       // Write updated list of invoices back to the file
        return writeToFileToPackagesRate(packags, filename);
    }*/

//inoivces = old invoice 
    
       

   
}
