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

public class Csr implements Serializable{
    private static final long serialVersionUID = 1L;
    protected int id,  hours;
    protected float amount;
    protected String name, Designation, remarks;
    protected LocalDate date;

    public Csr() {
    }

    public Csr(String Designation, LocalDate date, int hours,   String remarks) {
        this.hours = hours;
        this.Designation = Designation;
        this.remarks = remarks;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
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
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Csr{" + "id=" + id + ", hours=" + hours + ", amount=" + amount + ", name=" + name + ", Designation=" + Designation + ", remarks=" + remarks + ", date=" + date + '}';
    }

    //------------------------------------------------------------------------------------------------
    //CSR Attendence and Overtime
    
    public static boolean writeToFileForAttendenceOvertimes(List<Csr> attendenceOvertimes, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Csr i : attendenceOvertimes) {
                oos.writeObject(i);
            }
            System.out.println("writing Attendence and overtime hours generated successfully.");
            return true;
        } catch (IOException e) {
            System.err.println("Error writing attendence and overtime hours to file: " + e.getMessage());
            return false;
        }
    }

    public static List<Csr> readFromFileForAttendenceOvertimes(String filename) {
        List<Csr> attendenceOvertimes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Csr) {
                        Csr j = (Csr) obj;
                        attendenceOvertimes.add(j);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("reading Attendence and overtime hours loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading Attendence and overtime hours from file: " + e.getMessage());
        }
        return attendenceOvertimes;
    }

    public static boolean addToInstanceForCSRattendenceOvertime(Csr k, String filename) {
        List<Csr> attendenceOvertimes = readFromFileForAttendenceOvertimes(filename);
        attendenceOvertimes.add(k);
        return writeToFileForAttendenceOvertimes(attendenceOvertimes, filename);
    }

}
