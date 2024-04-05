
package Mugdho_2220644;
import java.io.*;
import java.time.LocalDate;

public class AuditReport implements Serializable {
    private String title;
    private String findings;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AuditReport{");
        sb.append("title=").append(title);
        sb.append(", findings=").append(findings);
        sb.append(", recommendations=").append(recommendations);
        sb.append(", comments=").append(comments);
        sb.append(", auditDate=").append(auditDate);
        sb.append('}');
        return sb.toString();
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

    // Getters and setters
    // Add getters and setters for each field

    // Write method to write AuditReport object to file
    public void writeToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Audit report saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing audit report to file: " + e.getMessage());
        }
    }
}
