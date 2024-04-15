/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class EmployeeTermsAndPolicyController implements Initializable {

    @FXML
    private Label viewEmployeeTermAndPolicy;
    @FXML
    private TextArea seeTextArea;
    @FXML
    private Button backButton;
//private List<md> nofi = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* nofi= md.readFromFileForSuggestions("Terms & Policys.bin");
         if (nofi != null && !nofi.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (md item : nofi) {
                stringBuilder.append(item.toString()).append("\n");
            }
            seeTextArea.setText(stringBuilder.toString());
        } else {
            seeTextArea.setText("No data found.");
        }
        
        //seeTextArea.setText(nofi.toString());
      
       */ 
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MarketingManagerDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
