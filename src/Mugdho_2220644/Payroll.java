/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mugdho_2220644;

import java.time.LocalDate;

/**
 *
 * @author Lenovo
 */
public class Payroll extends Employee{ 
    float salaryAmount, bonusAmount, overtimeAmount,totalSalary;
    String month; 
    LocalDate datePaid; 

    public Payroll(float salaryAmount, float bonusAmount, float overtimeAmount, String month, LocalDate datePaid, int empId, String empName, String empDesign, String paymentMethod) {
        super(empId, empName, empDesign, paymentMethod);
        this.salaryAmount = salaryAmount;
        this.bonusAmount = bonusAmount;
        this.overtimeAmount = overtimeAmount;
        this.month = month;
        this.datePaid = datePaid;
    }

    public float getSalaryAmount() {
        return salaryAmount;
    }

    public float getBonusAmount() {
        return bonusAmount;
    }

    public float getOvertimeAmount() {
        return overtimeAmount;
    }

    public String getMonth() {
        return month;
    }

    public LocalDate getDatePaid() {
        return datePaid;
    }

    public void setSalaryAmount(float salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public void setBonusAmount(float bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public void setOvertimeAmount(float overtimeAmount) {
        this.overtimeAmount = overtimeAmount;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDatePaid() {
        this.datePaid = datePaid;
    }
    
    public float getTotalSalaryAmount(){
      return totalSalary = this.getSalaryAmount() + this.getBonusAmount() + this.getOvertimeAmount();
    }

    @Override
    public String toString() {
        return "Payroll{" + "salaryAmount=" + salaryAmount + ", bonusAmount=" + bonusAmount + ", overtimeAmount=" + overtimeAmount + ", totalSalary=" + totalSalary + ", month=" + month + ", datePaid=" + datePaid + '}';
    }
    
    
    
    
}
