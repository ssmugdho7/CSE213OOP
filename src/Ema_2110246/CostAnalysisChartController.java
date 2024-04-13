/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ema_2110246;

import Mugdho_2220644.CostEstimation;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;


public class CostAnalysisChartController implements Initializable {

    @FXML
    private PieChart costRatioChart;
    @FXML
    private BarChart<String, Integer> barchart;

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
int totalSubscribers = costs.size();

double totalFixedCosts = 0;
double totalVariableCosts = 0;
double totalAdditionalCosts = 0;

for (CostEstimation cost : costs) {
    totalFixedCosts =totalFixedCosts+ cost.getFixedCosts();
    totalVariableCosts = totalVariableCosts+cost.getVariableCosts();
    totalAdditionalCosts = totalAdditionalCosts+cost.getAdditionalCost();
}

ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
    new PieChart.Data("Fixed Costs", totalFixedCosts),
    new PieChart.Data("Variable Costs", totalVariableCosts),
    new PieChart.Data("Additional Costs", totalAdditionalCosts)
);

costRatioChart.setData(pieChartData);

XYChart.Series<String, Integer> series = new XYChart.Series<>();
for (CostEstimation ce : costs) {
    double totalCost = ce.getFixedCosts() + ce.getVariableCosts() + ce.getAdditionalCost();
    series.getData().add(new XYChart.Data<>("Subscriber " + ce.getSubscriber(), (int) totalCost));
}

barchart.getData().add(series);

        
        

    
    
}
        
    
    
}
