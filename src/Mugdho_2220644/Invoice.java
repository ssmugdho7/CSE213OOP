/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mugdho_2220644;

/**
 *
 * @author Lenovo
 */
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice implements Serializable {

    private int customerId;
    private String address;
    private LocalDate invoiceDate;
    private String services;
    private float amount;

    public Invoice(int customerId, String address, LocalDate invoiceDate, String services) {
        this.customerId = customerId;
        this.address = address;
        this.invoiceDate = invoiceDate;
        this.services = services;
    }

    public Invoice(int customerId, String address, LocalDate invoiceDate, String services, float amount) {
        this.customerId = customerId;
        this.address = address;
        this.invoiceDate = invoiceDate;
        this.services = services;
        this.amount = amount;
    }

    // Getters and setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    // toString method
    @Override
    public String toString() {
        return "Invoice{"
                + "customerId=" + customerId
                + ", address='" + address + '\''
                + ", invoiceDate=" + invoiceDate
                + ", services='" + services + '\''
                + ", amount=" + amount
                + '}';
    }

    // Method to write the invoice to a binary file
    // Method to write the invoice to a binary file
    public static void writeToFile(ArrayList<Invoice> invoices, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename, true))) {
            for (Invoice invoice : invoices) {
                oos.writeObject(invoice);
            }
            System.out.println("Invoices saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing invoices to file: " + e.getMessage());
        }
    }

    // Method to read invoices from a binary file
    public static ArrayList<Invoice> readFromFile(String filename) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    // Read an object from the file
                    Object obj = ois.readObject();
                    if (obj instanceof Invoice) {
                        // If the object is an instance of Invoice, add it to the list
                        Invoice invoice = (Invoice) obj;
                        invoices.add(invoice);
                    }
                } catch (EOFException e) {
                    // End of file reached
                    break;
                }
            }
            System.out.println("Invoices loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading invoices from file: " + e.getMessage());
        }
        return invoices;
    }

    public static void writeToFileForInvoiceRequest(ArrayList<Invoice> invoices, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Invoice invoice : invoices) {
                oos.writeObject(invoice);
            }
            System.out.println("Invoices saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing invoices to file: " + e.getMessage());
        }
    }

// Method to read invoices from a binary file
public static ArrayList<Invoice> readFromFileForInvoiceRequest(String filename) {
    ArrayList<Invoice> invoices = new ArrayList<>();
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
        while (true) {
            try {
                // Read an object from the file
                Object obj = ois.readObject();
                if (obj instanceof Invoice) {
                    // If the object is an instance of Invoice, add it to the list
                    Invoice invoice = (Invoice) obj;
                    invoices.add(invoice);
                }
            } catch (EOFException e) {
                // End of file reached
                break;
            }
        }
        System.out.println("Invoices loaded successfully.");
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Error reading invoices from file: " + e.getMessage());
    }
    return invoices;
}


}
