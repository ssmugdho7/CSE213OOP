
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
import javafx.collections.ObservableList;



class EmployeeAttendance implements Serializable {


    private String designation;
    private LocalDate date;
    private int overtimeHours;
    private String remarks;

    public EmployeeAttendance(String designation, LocalDate date, int overtimeHours, String remarks) {
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

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
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

     
    }
     
     
     
    
    
    

