/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import Mugdho_2220644.CostEstimation;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Button;
import javafx.stage.Stage;


public class CostAnalysisChartController implements Initializable {

    @FXML
    private PieChart costRatioChart;
    @FXML
    private BarChart<String, Number> barchart;
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
    private void loadButtonOnClick(ActionEvent event) {
        costRatioChart.getData().clear();
        barchart.getData().clear();
        
        
        
         List<CostEstimation> costs = CostEstimation.readFromFileToEstimateCost("costEstimation.bin");
         


int subscriber = costs.size();

float FixedCosts = 0;
float VariableCosts = 0;
float AdditionalCosts = 0;
float revenue = 0;

for (CostEstimation cost : costs) {
    
    FixedCosts =FixedCosts+ cost.getFixedCosts();
    VariableCosts = VariableCosts+cost.getVariableCosts();
    AdditionalCosts = AdditionalCosts+cost.getAdditionalCost();
    revenue = revenue+ cost.getRevenue();
    subscriber = subscriber + cost.getSubscriber();
}
//float averageRevenueperSubscriber = revenue / Totalsubscriber;
ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
   new PieChart.Data("Subscribers", subscriber),
    new PieChart.Data("Fixed Costs", FixedCosts),
    new PieChart.Data("Variable Costs", VariableCosts),
    new PieChart.Data("Additional Costs", AdditionalCosts),
    new PieChart.Data("Average Revenue per Subscriber", revenue)
);

costRatioChart.setData(pieChartData);

XYChart.Series<String, Number> series = new XYChart.Series<>();

// Add data points to the series
series.getData().add(new XYChart.Data<>("Subscribers", subscriber));

series.getData().add(new XYChart.Data<>("Fixed Costs", FixedCosts));
series.getData().add(new XYChart.Data<>("Variable Costs", VariableCosts));
series.getData().add(new XYChart.Data<>("Additional Costs", AdditionalCosts));
series.getData().add(new XYChart.Data<>(" Average Revenue per Subscriber", revenue));

// Add the series to the bar chart
barchart.getData().add(series);



        
        

    
    
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
