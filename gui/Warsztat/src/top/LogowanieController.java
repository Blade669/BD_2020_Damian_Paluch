package top;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author h
 */
public class LogowanieController implements Initializable 
{
    @FXML
    private Button registerButton;
@FXML
    private void actionRejestracja(ActionEvent event) throws ParseException, IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("RejestracjaKlienta.fxml"));
        Parent root1 = (Parent)fxmlloader.load();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
