/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author h
 */
public class AdministratorzyController implements Initializable {

    @FXML
    private ComboBox comboDiagnozy, comboPrzeglady, comboUslugi;
    @FXML
    private Tab edytujDane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        comboDiagnozy.getItems().add("gg");
        comboDiagnozy.getSelectionModel().selectFirst();
    }    
    
}
