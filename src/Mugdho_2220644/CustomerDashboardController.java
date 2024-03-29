/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mugdho_2220644;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class CustomerDashboardController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Button logOutButton;
    @FXML
    private TableView<?> internetRates;
    @FXML
    private TableColumn<?, ?> sppedCol;
    @FXML
    private TableColumn<?, ?> netRateCol;
    @FXML
    private PieChart popularpackagesPieChart;
    @FXML
    private TableView<?> installationfeeTAble;
    @FXML
    private TableColumn<?, ?> serviceCol;
    @FXML
    private TableColumn<?, ?> servicecostCol;
    @FXML
    private Hyperlink speedtesthyperlink;
    @FXML
    private Hyperlink link3hyperlonk;

    private HostServices hostServices;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void payBillButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewAndDownloadInvoiceButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void requestForServiceButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void complainButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void giveRatingsButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void sendMessageForTechnicalSupportButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void feedbackFromTechnicalSupportButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void gobackButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewTermsAndPolicyButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) {
    }

}
