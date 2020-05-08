/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static top.Polaczenie.getConnection;

/**
 * FXML Controller class
 *
 * @author h
 */
public class RejestracjaKlientaController implements Initializable {

    @FXML
    private Label loginError, passwordError;
    @FXML
    private TextField loginField, imieField, nazwiskoField, nrField;
    @FXML
    private PasswordField passwordField1, passwordField2; 
    @FXML
    private Button registerButton;
    
    @FXML
    private void actionPowrot(ActionEvent event) throws ParseException, IOException
    {
        SceneMenager.renderScene("logowanie");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginError.setVisible(false);
        passwordError.setVisible(false);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
            Connection con = getConnection();
            registerButton.setOnAction(e -> {
            if (!passwordField1.getText().equals(passwordField2.getText())){
                passwordError.setVisible(true);
            }
    });  

    
}
}
