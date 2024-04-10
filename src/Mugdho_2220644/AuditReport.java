package Mugdho_2220644;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuditReport implements Serializable {

    @Override
    public String toString() {
        return "AuditReport{" + "title=" + title + ", findings=" + findings + ", recommendations=" + recommendations + ", comments=" + comments + ", auditDate=" + auditDate + '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFindings() {
        return findings;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(LocalDate auditDate) {
        this.auditDate = auditDate;
    }

    private String title;
    private String findings;
    private String recommendations;
    private String comments;
    private LocalDate auditDate;

    public AuditReport(String title, String findings, String recommendations, String comments, LocalDate auditDate) {
        this.title = title;
        this.findings = findings;
        this.recommendations = recommendations;
        this.comments = comments;
        this.auditDate = auditDate;
    }

    
     // Method to write Invoice objects to a binary file
    public static boolean writeToFileForAuditReport(List<AuditReport> reports, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (AuditReport rep : reports) {
                oos.writeObject(rep);
            System.out.println("Audit report generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing invoices to file: " + e.getMessage());
           return false;
        }
    }

    // Method to read invoices from a binary file
    public static List<AuditReport> readFromFileForAuditReport(String filename) {
        List<AuditReport> reports = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Invoice) {
                        AuditReport rep = (AuditReport) obj;
                        reports.add(rep);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("Audit report loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading invoices from file: " + e.getMessage());
        }
        return reports;
    }



    // Method to add a new instance to the list and write to file
    public static boolean addToInstanceForAuditReport(AuditReport report, String filename) {
        // Read existing invoices from file
        List<AuditReport> reports = readFromFileForAuditReport(filename);
        reports.add(report);
       // Write updated list of invoices back to the file
        return writeToFileForAuditReport(reports, filename);
    }


 
    
    
    
    
    
    
    
    
    
}