package top;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author h
 */
public class LogowanieController implements Initializable 
{
    @FXML
    private Button registerButton, loginButton;
    @FXML
    private ComboBox logAs;
    @FXML
    private void actionRejestracja(ActionEvent event) throws ParseException, IOException
    {
        SceneMenager.renderScene("rejestracja");
    }
    @FXML
    private void actionZaloguj(ActionEvent event) throws ParseException, IOException
    {
        int id = logAs.getSelectionModel().getSelectedIndex();
        if(id == 0)
        {
            SceneMenager.renderScene("klienci");
        }
        
        else if(id == 1)
        {
            SceneMenager.renderScene("mechanicy");
        }
        
        else
        {
            SceneMenager.renderScene("administratorzy");
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        logAs.getItems().addAll("Klient","Mechanik","Administrator");
        logAs.getSelectionModel().selectFirst();
    }    
    
}
