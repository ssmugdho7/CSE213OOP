//package Mugdho_2220644;

package Jami_2211508;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */

public class Employee implements Serializable{
    private int empId;
    private String empName;
    private String empDesign;
    private String paymentMethod;

    // Constructor
    public Employee(int empId, String empName, String empDesign, String paymentMethod) {
        this.empId = empId;
        this.empName = empName;
        this.empDesign = empDesign;
        this.paymentMethod = paymentMethod;
    }

    // Getters and setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesign() {
        return empDesign;
    }

    public void setEmpDesign(String empDesign) {
        this.empDesign = empDesign;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
