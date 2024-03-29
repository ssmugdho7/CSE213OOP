/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mugdho_2220644;

/**
 *
 * @author Lenovo
 */
public class Employee {
    int empId;
    String empName, empDesign, paymentMethod;


////////////==============////////////////////

    public Employee(int empId, String empName, String empDesign, String paymentMethod) {    
        this.empId = empId;
        this.empName = empName;
        this.empDesign = empDesign;
        this.paymentMethod = paymentMethod;
    }


    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpDesign(String empDesign) {
        this.empDesign = empDesign;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
///////////=============//////////////////////////////////////////

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpDesign() {
        return empDesign;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }


}
