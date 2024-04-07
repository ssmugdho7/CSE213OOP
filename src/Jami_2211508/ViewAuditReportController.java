/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Jami_2211508;
// import Mugdho_2220644.AuditReport;
        
        
        
import Mugdho_2220644.AuditReport;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ViewAuditReportController implements Initializable {

    @FXML
    private TableView<?> auditTableView;
    @FXML
    private TableColumn<?, ?> dateTableCol;
    @FXML
    private TableColumn<?, ?> titleTableCol;
    @FXML
    private TableColumn<?, ?> findingsTableCol;
    @FXML
    private TableColumn<?, ?> recommendationsTableCol;
    @FXML
    private TableColumn<?, ?> commentsTableCol;
    @FXML
    private TextArea readReportTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void readAuditReportButtonOnClick(ActionEvent event) {
       readReportTextArea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
      

//        ArrayList<AuditReport> reports = new ArrayList<>();
    try {
            f = new File("AuditReport.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            AuditReport rep;
            try{
               readReportTextArea.setText("");
                while(true){
                    System.out.println("Here is your audit report");
                    rep = (AuditReport)ois.readObject();
                    
                    //=========== trying to find error ==================
                    
                    if (rep != null){
                        System.out.println("something is wrong");
                    }
                    
                    else{ 
                        System.out.println("Something is wrong 2");
                    }
                   
                    //============ trying to find error ==================
                    
                    
                    System.out.println(rep.toString());
                    readReportTextArea.appendText(rep.toString());
                }
            }
            
            catch(Exception e){
                // handling code
            }//nested catch     
            readReportTextArea.appendText("All objects are loaded successfully...\n");            
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } 
    
    finally {
            try {
                
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }           
    }
            
            
            
            
            
 }
    
    

 
    

//                    reports.add(report);