package top;

import entity.Klienci_uzytkownicy;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static top.Polaczenie.getConnection;

/**
 * FXML Controller class
 *
 * @author h
 */
public class LogowanieController implements Initializable {

    @FXML
    private ComboBox logAs;
    @FXML
    private TextField login;
    @FXML
    private PasswordField haslo;

    @FXML
    private void actionRejestracja(ActionEvent event) throws ParseException, IOException {
        SceneMenager.renderScene("rejestracja");
    }

    @FXML
    private void actionZaloguj(ActionEvent event) throws ParseException, IOException {
        int id = logAs.getSelectionModel().getSelectedIndex();
        if (id == 0) {
            try {
                Connection con = getConnection();

                CallableStatement cstmt = con.prepareCall("call logowanie.sprawdz_dane(?,?)");

                cstmt.setString(1, login.getText());
                cstmt.setString(2, haslo.getText());

                cstmt.executeUpdate();

                cstmt = con.prepareCall("select * from klienci_uzytkownicy\n"
                        + "where login = ?\n"
                        + "and haslo = ?");
                cstmt.setString(1, login.getText());
                cstmt.setString(2, haslo.getText());
                ResultSet rs = cstmt.executeQuery();
                Klienci_uzytkownicy klient = null;
                while (rs.next()) {
                    klient = new Klienci_uzytkownicy(rs.getInt(1), rs.getString(2), rs.getString(3));
                    klient.setId(rs.getInt(1));
                }

                SceneMenager.renderScene("klienci");
            } catch (SQLException ex) {
                if (ex.getErrorCode() == 20000) {
                    Alert bad = new Alert(Alert.AlertType.INFORMATION);
                    bad.setTitle("Błąd logowania");
                    bad.setHeaderText("Podałeś niepoprawne dane");
                    bad.showAndWait();
                }

            }
        } else if (id == 1) {
            SceneMenager.renderScene("mechanicy");
        } else {
            SceneMenager.renderScene("administratorzy");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logAs.getItems().addAll("Klient", "Mechanik", "Administrator");
        logAs.getSelectionModel().selectFirst();
    }

}
