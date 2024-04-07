package Mugdho_2220644;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainPKG.AppendableObjectOutputStream;

public class AuditReport implements Serializable {

    @Override
    public String toString() {
        return "AuditReport{" + "title=" + title + ", findings=" + findings + ", recommendations=" + recommendations + ", comments=" + comments + ", auditDate=" + auditDate + "}\n";
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

<<<<<<< Updated upstream
    // Method to write AuditReport objects to a file
    public static void writeToFile(ArrayList<AuditReport> reports, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename, true))) {
=======
    public static void writeToFile(ArrayList<AuditReport> reports, String filename) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File(filename);

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

>>>>>>> Stashed changes
            for (AuditReport report : reports) {

                System.out.println("testing purpose:\n" + report);
                oos.writeObject(report);
            }
            System.out.println("Audit reports saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing audit reports to file: " + e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(AuditReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

<<<<<<< Updated upstream
public static ArrayList<AuditReport> readFromFile(String filename) {
    ArrayList<AuditReport> reports = new ArrayList<>();
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
        while (true) {
            try {
                // Read an object from the file
                Object obj = ois.readObject();
                if (obj instanceof AuditReport) {
                    // If the object is an instance of AuditReport, add it to the list
                    AuditReport report = (AuditReport) obj;
=======
  public static ArrayList<AuditReport> readFromFile(String filename) {
        ArrayList<AuditReport> reports = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    AuditReport report = (AuditReport) ois.readObject();
>>>>>>> Stashed changes
                    reports.add(report);
                }
            } catch (EOFException e) {
                // End of file reached
                break;
            }
        }
        System.out.println("Audit reports loaded successfully.");
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Error reading audit reports from file: " + e.getMessage());
    }
    return reports;
}


}
