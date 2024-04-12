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
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;


class MarketingManager implements Serializable {
    //req reimbursement
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
    
    
    //-------------File read & write for Employee
    public static List<Object> readObjectsFromFile(String fileName) {
           List<Object> objects = new ArrayList<>();
           try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
               while (true) {
                   try {
                       Object obj = ois.readObject();
                       if (obj != null) {
                           objects.add(obj);
                       }
                   } catch (EOFException e) {
                       break; 
                   }
               }
           } catch (IOException | ClassNotFoundException ex) {
               ex.printStackTrace();
           }
           return objects;
           }
    public static boolean writeObjectsToFile(List<Object> objects, String fileName) {
           try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
               for (Object obj : objects) {
                   oos.writeObject(obj);
               }
               return true;
           } catch (IOException ex) {
               ex.printStackTrace();
               return false;
           }
       }
    
    
   

    public static boolean addNewEmployeeAttendance(EmployeeAttendance information, String fileName) {
           List<Object> information_row = readObjectsFromFile(fileName);
           information_row.add(information);
           return writeObjectsToFile(information_row, fileName);
       } 
       

    public static ArrayList<EmployeeAttendance> loadEmployeeAttendances(String fileName) {
        ArrayList<EmployeeAttendance> existingEmployeeAttendances = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    EmployeeAttendance employeeAttendance = (EmployeeAttendance) ois.readObject();
                    existingEmployeeAttendances.add(employeeAttendance);
                } catch (EOFException eof) {
                    // End of file reached, break the loop
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return existingEmployeeAttendances;
    }

}
