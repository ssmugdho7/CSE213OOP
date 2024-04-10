package Mugdho_2220644;

/**
 *
 * @author Lenovo
 */
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoiceRequest implements Serializable {
    private int customerId;
    private String address;
    private LocalDate invoiceDate;
    private String services;
//    private float amount;

    public InvoiceRequest(int customerId, String address, LocalDate invoiceDate, String services) {
        this.customerId = customerId;
        this.address = address;
        this.invoiceDate = invoiceDate;
        this.services = services;
//        this.amount = amount;
    }

//    Invoice(int customerId, String address, LocalDate invoiceDate, String services) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

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
//
//    public float getAmount() {
//        return amount;
//    }

//    public void setAmount(float amount) {
//        this.amount = amount;
//    }

    @Override
    public String toString() {
        return  
                "customerId=" + customerId +
                ", address=" + address  +
                ", invoiceDate=" + invoiceDate +
                ", services=" + services
                ;
    }

    public static boolean writeToFile(List<InvoiceRequest> invoices, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (InvoiceRequest x : invoices) {
                oos.writeObject(x);
                System.out.println("Invoice Request Written Successfully");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<InvoiceRequest> readFromFile(String filename) {
        List<InvoiceRequest> invoices = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof InvoiceRequest) {
                        InvoiceRequest y = (InvoiceRequest) obj;
                        invoices.add(y);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return invoices;
    }

    public static boolean addNewInstance(InvoiceRequest invoice, String filename) {
        List<InvoiceRequest> invoices = readFromFile(filename);
        invoices.add(invoice);
        return writeToFile(invoices, filename);
    }
}
