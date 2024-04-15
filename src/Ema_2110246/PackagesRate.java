/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ema_2110246;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PackagesRate implements Serializable{
    
    private String packageName;
    private float popularity;
    private float speed;
    private float rate;

    public PackagesRate(String packageName, float popularity, float speed, float rate) {
        this.packageName = packageName;
        this.popularity = popularity;
        this.speed = speed;
        this.rate = rate;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "PackagesRate{" + "packageName=" + packageName + ", popularity=" + popularity + ", speed=" + speed + ", rate=" + rate + '}';
    }
    
    
    
    // Method to write  objects to a binary file
    public static boolean writeToFileToPackagesRate(List<PackagesRate>packag, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (PackagesRate xyz : packag) {
                oos.writeObject(xyz);
            System.out.println("PackagesRate generated successfully.");
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing PackagesRate to file: " + e.getMessage());
           return false;
        }
    }

    
    
    // Method to read  from a binary file
    public static List<PackagesRate> readFromFileToPackagesRate(String filename) {
        List<PackagesRate>packag= new ArrayList<>(); 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof  PackagesRate) {
                        PackagesRate xyz = ( PackagesRate) obj;
                        packag.add(xyz);
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            System.out.println("  PackagesRate loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading PackagesRate from file: " + e.getMessage());
        }
        return packag;
    }



    // Method to add a new instance to the list and write to file


    public static boolean addToInstanceToPackagesRate(PackagesRate packag, String filename) {
        // Read existing invoices from file
        List<PackagesRate>packags=readFromFileToPackagesRate(filename);
      packags.add(packag);
       // Write updated list of invoices back to the file
        return writeToFileToPackagesRate(packags, filename);
    }

//inoivces = old invoice 
//invoice = new invoice
   
    //support= new support 
    // supports= old support
    //suppt= new support 
    // suppts= old supp
    // factor = new factor
    // factors = old factor
    //package= new data
//packages= old data
}
