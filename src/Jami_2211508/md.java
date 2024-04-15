package Jami_2211508;

import static Jami_2211508.csrReimnursement.writeToFileForRequestingReimbursement;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class md implements Serializable{
    private String termsPolicy, employee, topic, description;

    public md() {
    }

    public md(String termsPolicy) {
        this.termsPolicy = termsPolicy;
    }

    public md(String topic, String description) {
        this.topic = topic;
        this.description = description;
    }

    public String getTermsPolicy() {
        return termsPolicy;
    }

    public void setTermsPolicy(String termsPolicy) {
        this.termsPolicy = termsPolicy;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "md{" + "termsPolicy=" + termsPolicy + ", employee=" + employee + ", topic=" + topic + ", description=" + description + '}';
    }
    
    
    //---------------------------------------------------------------------------------------------------------------------------------
    //Terms and Policy
    
    public static boolean writeToFileForTermPolicys(List<md> termPolicys, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (md i : termPolicys) {
                oos.writeObject(i);
            System.out.println("writing terms & Policys generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing terms & Policys to file: " + e.getMessage());
           return false;
        }
    }
    
  
    public static List<md> readFromFileForTermPolicys(String filename) {
        List<md> termPolicys = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof md) {
                        md j = (md) obj;
                        termPolicys.add(j);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("reading terms & Policys loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading to terms & Policys from file: " + e.getMessage());
        }
        return termPolicys;
    }



    public static boolean addToInstanceForTermPolicys(md k, String filename) {
      
        List<md> termPolicys = readFromFileForTermPolicys(filename);
        termPolicys.add(k);
        return writeToFileForTermPolicys(termPolicys, filename);
    }
    
    //--------------------------------------------------------------------------------------------
    //Suggestions for change
    public static boolean writeToFileForSuggestions(List<md> Suggestions, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (md i : Suggestions) {
                oos.writeObject(i);
            System.out.println("Writing suggestions generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing suggestions to file: " + e.getMessage());
           return false;
        }
    }
    
  
    public static List<md> readFromFileForSuggestions(String filename) {
        List<md> Suggestions = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof md) {
                        md j = (md) obj;
                        Suggestions.add(j);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("reading suggestions loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading to suggestions from file: " + e.getMessage());
        }
        return Suggestions;
    }



    public static boolean addToInstanceForSuggestions(md k, String filename) {
      
        List<md> Suggestions = readFromFileForSuggestions(filename);
        Suggestions.add(k);
        return writeToFileForSuggestions(Suggestions, filename);
    }
}
