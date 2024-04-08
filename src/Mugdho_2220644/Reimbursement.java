/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mugdho_2220644;

/**
 *
 * @author Lenovo
 */
public class Reimbursement extends Employee {
    private String status;
    private float amount;
    private String expenseType;

    public Reimbursement(int empId, String empName, String empDesign, String paymentMethod,
                         String status, float amount, String expenseType) {
        super(empId, empName, empDesign, paymentMethod);
        this.status = status;
        this.amount = amount;
        this.expenseType = expenseType;
    }

    // Getters and setters

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "status='" + status + '\'' +
                ", amount=" + amount +
                ", expenseType='" + expenseType + '\'' +
                "} " + super.toString();
    }
}
