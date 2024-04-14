/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Field_ReadCustomerComplainController implements Initializable {

    @FXML
    private Button sendFeedback;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendFeedbackOnClick(ActionEvent event) {
        try {
            FXMLLoader termsLoader = new FXMLLoader(getClass().getResource("Field_ComplainFeedback.fxml"));
            Parent termsRoot = termsLoader.load();
            Stage termsStage = new Stage();
            termsStage.setTitle("Send feedback");
            termsStage.setScene(new Scene(termsRoot));
            termsStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FieldTechnicianDashboard.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
