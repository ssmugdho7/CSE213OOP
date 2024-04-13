package Jami_2211508;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class customer implements Serializable{
    private int id,  hours;
    private LocalDate date;
    private String location, problem, inquiry, details;  
  

    public customer() {
    }

    public customer(int id, LocalDate date, String problem) {
        this.id = id;
        this.date = date;
        this.problem = problem;
    }

    public customer(String inquiry, int id, String details) {
        this.id = id;
        this.inquiry = inquiry;
        this.details = details;
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
  

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


    public customer(int id, LocalDate date, String location, String problem) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.problem = problem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return "customer{" + "id=" + id + ", hours=" + hours + ", date=" + date + ", location=" + location + ", problem=" + problem + ", inquiry=" + inquiry + ", details=" + details + '}';
    }

   

    

    //------------------------------------------------------------------------------------------------------------------------------------
    //Field Technician
  
    public static boolean writeToFileForDutyToFieldTechnician(List<customer> dutyFieldTechnicians, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (customer i : dutyFieldTechnicians) {
                oos.writeObject(i);
            System.out.println("Writing Duty to Field Technicians generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing duty to Field Technicians to file: " + e.getMessage());
           return false;
        }
    }
    
   
    public static List<customer> readFromFileForDutyToFieldTechnician(String filename) {
        List<customer> dutyFieldTechnicians = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof customer) {
                        customer j = (customer) obj;
                        dutyFieldTechnicians.add(j);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("Reading Duty to Field Technicians loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading duty to Field Technicians from file: " + e.getMessage());
        }
        return dutyFieldTechnicians;
    }



   
    public static boolean addToInstanceForDutyToFieldTechnician(customer k, String filename) {
      
        List<customer> dutyFieldTechnicians = readFromFileForDutyToFieldTechnician(filename);
        dutyFieldTechnicians.add(k);
       
        return writeToFileForDutyToFieldTechnician(dutyFieldTechnicians, filename);
    }
    //--------------------------------------------------------------------------------------------------------
    
    //Network Engineer
    
    public static boolean writeToFileForDutyToNetworkEngineer(List<customer> DutyToNetworkEngineers, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (customer i : DutyToNetworkEngineers) {
                oos.writeObject(i);
            System.out.println("writing Duty to Network Engineer generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing duty to Network Engineer to file: " + e.getMessage());
           return false;
        }
    }
    
    
    public static List<customer> readFromFileForDutyToNetworkEngineer(String filename) {
        List<customer> DutyToNetworkEngineers = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof customer) {
                        customer j = (customer) obj;
                        DutyToNetworkEngineers.add(j);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("reading Duty to Network Engineer loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading duty to Network Engineer from file: " + e.getMessage());
        }
        return DutyToNetworkEngineers;
    }



    public static boolean addToInstanceForDutyToNetworkEngineer(customer k, String filename) {
        
        List<customer> DutyToNetworkEngineers = readFromFileForDutyToNetworkEngineer(filename);
        DutyToNetworkEngineers.add(k);
       
        return writeToFileForDutyToNetworkEngineer(DutyToNetworkEngineers, filename);
    }
    //-------------------------------------------------------------------------------------------------------
    //Technical Support
    public static boolean writeToFileForDutyToTechnicalSupport(List<customer> DutyToTechnicalSupports, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (customer i : DutyToTechnicalSupports) {
                oos.writeObject(i);
            System.out.println("writing Duty to Technical Support generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing duty to Technical Support to file: " + e.getMessage());
           return false;
        }
    }
    
    
    public static List<customer> readFromFileForDutyToTechnicalSupport(String filename) {
        List<customer> DutyToTechnicalSupports = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof customer) {
                        customer j = (customer) obj;
                        DutyToTechnicalSupports.add(j);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("reading Duty to Technical Support loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading duty to Technical Support from file: " + e.getMessage());
        }
        return DutyToTechnicalSupports;
    }



    public static boolean addToInstanceForDutyToTechnicalSupport(customer k, String filename) {
        
        List<customer> DutyToTechnicalSupports = readFromFileForDutyToTechnicalSupport(filename);
        DutyToTechnicalSupports.add(k);
       
        return writeToFileForDutyToTechnicalSupport(DutyToTechnicalSupports, filename);
    }
    //-------------------------------------------------------------------------------------------------------
    //Customer Complain
    public static boolean writeToFileForInquiry(List<customer> inquirys, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (customer i : inquirys) {
                oos.writeObject(i);
            System.out.println("Writing inquiry generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing inquiry to file: " + e.getMessage());
           return false;
        }
    }
    
   
    public static List<customer> readFromFileForInquiry(String filename) {
        List<customer> inquirys = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof customer) {
                        customer j = (customer) obj;
                        inquirys.add(j);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("Reading inquiry loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading inquiry from file: " + e.getMessage());
        }
        return inquirys;
    }



   
    public static boolean addToInstanceForInquiry(customer k, String filename) {
      
        List<customer> inquirys = readFromFileForInquiry(filename);
        inquirys.add(k);
        return writeToFileForInquiry(inquirys, filename);
    }
    
    
}
