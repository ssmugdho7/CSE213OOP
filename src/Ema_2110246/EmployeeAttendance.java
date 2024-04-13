
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



class EmployeeAttendance implements Serializable {



    private String designation;
    private LocalDate date;
    private float overtimeHours;
    private String remarks;

    public EmployeeAttendance(String designation, LocalDate date, float overtimeHours, String remarks) {
        this.designation = designation;
        this.date = date;
        this.overtimeHours = overtimeHours;
        this.remarks = remarks;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(float overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "EmployeeAttendance{" + "designation=" + designation + ", date=" + date + ", overtimeHours=" + overtimeHours + ", remarks=" + remarks + '}';
    }

    
    // Method to write Invoice objects to a binary file
    public static boolean writeToFileToEmployeeAttendance(List<EmployeeAttendance> attendance, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (EmployeeAttendance xyz : attendance) {
                oos.writeObject(xyz);
            System.out.println("Attendance generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing Attendance to file: " + e.getMessage());
           return false;
        }
    }

    
    
    // Method to read invoices from a binary file
    public static List< EmployeeAttendance> readFromFileToEmployeeAttendance(String filename) {
        List< EmployeeAttendance> attendance= new ArrayList<>(); 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof  EmployeeAttendance) {
                        EmployeeAttendance xyz = ( EmployeeAttendance) obj;
                        attendance.add(xyz);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("  Attendance loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading Attendance from file: " + e.getMessage());
        }
        return attendance;
    }



    // Method to add a new instance to the list and write to file


    public static boolean addToInstanceToEmployeeAttendance( EmployeeAttendance attendance, String filename) {
        // Read existing invoices from file
        List<EmployeeAttendance>attendances= readFromFileToEmployeeAttendance(filename);
       attendances.add(attendance);
       // Write updated list of invoices back to the file
        return writeToFileToEmployeeAttendance(attendances, filename);
    }

//inoivces = old invoice 
//invoice = new invoice
     
    }
     
     
     
    
    
    

