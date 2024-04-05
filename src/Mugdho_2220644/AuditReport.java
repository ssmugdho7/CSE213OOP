package Mugdho_2220644;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

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

       public static void writeToFile(ArrayList<AuditReport> reports, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename, true))) {
            for (AuditReport report : reports) {
                oos.writeObject(report);
            }
            System.out.println("Audit reports saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing audit reports to file: " + e.getMessage());
        }
    }
public static ArrayList<AuditReport> readFromFile(String filename) {
        ArrayList<AuditReport> reports = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    AuditReport report = (AuditReport) ois.readObject();
                    reports.add(report);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("Audit reports loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading audit reports from file: " + e.getMessage());
        }
        return reports;
    }
}
