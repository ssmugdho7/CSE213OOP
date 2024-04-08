package Mugdho_2220644;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Lenovo
 */
public class Payroll extends Employee implements Serializable {

    public float getSalaryAmount() {
        return salaryAmount;
    }

    public float getBonusAmount() {
        return bonusAmount;
    }

    public float getOvertimeAmount() {
        return overtimeAmount;
    }

    public float getTotalSalary() {
        return totalSalary;
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

    public void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDatePaid(LocalDate datePaid) {
        this.datePaid = datePaid;
    }

    private float salaryAmount;
    private float bonusAmount;
    private float overtimeAmount;
    private float totalSalary;
    private String month;
    private LocalDate datePaid;

    public Payroll(int empId, String empName, String empDesign, String paymentMethod,
            float salaryAmount, float bonusAmount, float overtimeAmount,
            String month, LocalDate datePaid) {
        super(empId, empName, empDesign, paymentMethod);
        this.salaryAmount = salaryAmount;
        this.bonusAmount = bonusAmount;
        this.overtimeAmount = overtimeAmount;
        this.month = month;
        this.datePaid = datePaid;
    }

    public Payroll(int empId, String empName, String empDesign, String paymentMethod) {
        super(empId, empName, empDesign, paymentMethod);
    }

    public void writeToBinaryFile(ArrayList<Payroll> records) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("payroll.bin"))) {
            oos.writeObject(records);
            System.out.println("Records saved to payroll.bin");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Failed to save records.", e.getMessage());
        }
    }

    public ArrayList<Payroll> readFromBinaryFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("payroll.bin"))) {
            return (ArrayList<Payroll>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Failed to load records.", e.getMessage());
        }
        return new ArrayList<>();
    }

    private void showAlert(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public Payroll() {
        super(0, "", "", ""); // Pass appropriate arguments to match the Employee constructor
    }
}
