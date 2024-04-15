
//package Ema_2110246;
package Jami_2211508;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class  Cost_Management implements Serializable {

    
    private String suggestion;
    private String budgetPlan;
    private String saveMoneyby;

    public Cost_Management(String suggestion, String budgetPlan, String saveMoneyby){
        this.suggestion = suggestion;
        this.budgetPlan = budgetPlan;
        this.saveMoneyby = saveMoneyby;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getBudgetPlan() {
        return budgetPlan;
    }

    public void setBudgetPlan(String budgetPlan) {
        this.budgetPlan = budgetPlan;
    }

    public String getSaveMoneyby() {
        return saveMoneyby;
    }

    public void setSaveMoneyby(String saveMoneyby) {
        this.saveMoneyby = saveMoneyby;
    }

    @Override
    public String toString() {
        return "Cost_Management{" + "suggestion=" + suggestion + ", budgetPlan=" + budgetPlan + ", saveMoneyby=" + saveMoneyby + '}';
    }

   
    
    
   
    
    
    
    public static boolean writeToFileToCost_Management(List<Cost_Management> process, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Cost_Management xyz : process) {
                oos.writeObject(xyz);
            System.out.println("suggestion generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing suggestion to file: " + e.getMessage());
           return false;
        }
    }

    
    public static List<Cost_Management> readFromFileToCost_Management(String filename) {
        List<Cost_Management> process = new ArrayList<>(); 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Cost_Management) {
                       Cost_Management xyz = (Cost_Management) obj;
                        process.add(xyz);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println(" suggestions loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading suggestions from file: " + e.getMessage());
        }
        return process;
    }



    // Method to add a new instance to the list and write to file


    public static boolean addToInstanceToCost_Management(Cost_Management process, String filename) {
        // Read existing invoices from file
        List<Cost_Management>processes= readFromFileToCost_Management(filename);
        processes.add(process);
       // Write updated list of invoices back to the file
        return writeToFileToCost_Management(processes, filename);
    }


    
    
}
