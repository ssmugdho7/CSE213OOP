/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Jami_2211508;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class CSRViewTermsPolicyController implements Initializable {

    
    @FXML
    private TableView<md> TermsPolicyTableView;
    @FXML
    private TableColumn<md, String> TermsPolicyCol;
    
    List<md> termPolicys = new ArrayList<>();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TermsPolicyCol.setCellValueFactory(new PropertyValueFactory<>("TermsPolicy"));
        
        TermsPolicyTableView.getItems().addAll(termPolicys);
    }    

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
        termPolicys = md.readFromFileForTermPolicys("termsPolicys.bin");
        TermsPolicyTableView.getItems().clear();
        TermsPolicyTableView.getItems().addAll(termPolicys);
//        termPolicys = md.readFromFileForTermPolicys("termsPolicys.bin");
//        StringBuilder sb = new StringBuilder();
//        for (md termsPolicy : termPolicys){
//            sb.append(termsPolicy.toString()).append("\n"); 
//        }
//        termsAndPolicyLabel.setText(termPolicys.toString()); 
    }
    
}
