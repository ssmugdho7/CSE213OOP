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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice extends InvoiceRequest {
    private float amount;

    public Invoice(int customerId, String address, LocalDate invoiceDate, String services, float amount) {
        super(customerId, address, invoiceDate, services);
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return  super.toString() +
                 "amount" + amount
                ;
    }


   // Method to write Invoice objects to a binary file
    public static boolean writeToFileToGenerateInvoice(List<Invoice> invoices, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Invoice invoice : invoices) {
                oos.writeObject(invoice);
            System.out.println("Invoices generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing invoices to file: " + e.getMessage());
           return false;
        }
    }

    // Method to read invoices from a binary file
    public static List<Invoice> readFromFileToGenerateInvoice(String filename) {
        List<Invoice> invoices = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Invoice) {
                        Invoice invoice = (Invoice) obj;
                        invoices.add(invoice);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("Invoices loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading invoices from file: " + e.getMessage());
        }
        return invoices;
    }



    // Method to add a new instance to the list and write to file
    public static boolean addToInstanceToGenerateInvoice(Invoice invoice, String filename) {
        // Read existing invoices from file
        List<Invoice> invoices = readFromFileToGenerateInvoice(filename);
        invoices.add(invoice);
       // Write updated list of invoices back to the file
        return writeToFileToGenerateInvoice(invoices, filename);
    }









}
