package top;

import entity.Klienci_uzytkownicy;
import entity.Pracownicy_uzytkownicy;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
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

    private void alert(String tekst, String blad) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(tekst);
        alert.setContentText(blad);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/top/darkTheme.css").toExternalForm());
        dialogPane.getStyleClass().add("alert");
        alert.showAndWait();
    }

    @FXML
    private void actionZaloguj(ActionEvent event) throws ParseException, IOException, SQLException {
        login.setStyle("-fx-border-color: transparent;");
        haslo.setStyle("-fx-border-color: transparent;");
        int id = logAs.getSelectionModel().getSelectedIndex();
        if (sprawdzBledyLogowania()) {
            if (id == 0) {
                try {

                    Connection con = getConnection();

                    CallableStatement cstmt = con.prepareCall("call logowanie.klient_logowanie(?,?)");

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
                        alert("Błąd logowania", "Podałeś niepoprawne dane");
                    }

                }
            } else if (id == 1) {
                try {
                    Connection con = getConnection();

                    CallableStatement cstmt = con.prepareCall("call logowanie.mechanik_logowanie(?,?)");

                    cstmt.setString(1, login.getText());
                    cstmt.setString(2, haslo.getText());

                    cstmt.executeUpdate();

                    cstmt = con.prepareCall("select * from pracownicy_uzytkownicy\n"
                            + "where login = ?\n"
                            + "and haslo = ?");
                    cstmt.setString(1, login.getText());
                    cstmt.setString(2, haslo.getText());
                    ResultSet rs = cstmt.executeQuery();
                    Pracownicy_uzytkownicy mechanik = null;
                    while (rs.next()) {
                        mechanik = new Pracownicy_uzytkownicy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                        mechanik.setId(rs.getInt(1));
                    }

                    SceneMenager.renderScene("mechanicy");
                } catch (SQLException ex) {
                    if (ex.getErrorCode() == 20000) {
                        alert("Błąd logowania", "Podałeś niepoprawne dane");
                    }

                }
            } else if (id == 2) {
                try {
                    Connection con = getConnection();

                    CallableStatement cstmt = con.prepareCall("call logowanie.administrator_logowanie(?,?)");

                    cstmt.setString(1, login.getText());
                    cstmt.setString(2, haslo.getText());

                    cstmt.executeUpdate();

                    cstmt = con.prepareCall("select * from pracownicy_uzytkownicy\n"
                            + "where login = ?\n"
                            + "and haslo = ?");
                    cstmt.setString(1, login.getText());
                    cstmt.setString(2, haslo.getText());
                    ResultSet rs = cstmt.executeQuery();
                    Pracownicy_uzytkownicy mechanik = null;
                    while (rs.next()) {
                        mechanik = new Pracownicy_uzytkownicy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                        mechanik.setId(rs.getInt(1));
                    }

                    SceneMenager.renderScene("administratorzy");
                } catch (SQLException ex) {
                    if (ex.getErrorCode() == 20000) {
                        alert("Błąd logowania", "Podałeś niepoprawne dane");
                    }

                }
            }
        }
    }

    private boolean sprawdzPola(TextField tf) throws SQLException {
        Connection con = getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call walidacja.czy_puste(?)}");
        cstmt.registerOutParameter(1, Types.NUMERIC);
        cstmt.setString(2, tf.getText());
        cstmt.executeQuery();
        if (cstmt.getInt(1) == 1) {
            return false;
        }
        return true;
    }

    private boolean sprawdzPola(PasswordField pf) throws SQLException {
        Connection con = getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call walidacja.czy_puste(?)}");
        cstmt.registerOutParameter(1, Types.NUMERIC);
        cstmt.setString(2, pf.getText());
        cstmt.executeQuery();
        if (cstmt.getInt(1) == 1) {
            return false;
        }
        return true;
    }

    private boolean sprawdzBledyLogowania() throws SQLException {
        boolean blad = true;
        if (sprawdzPola(login)) {
            login.setStyle("-fx-border-color: red;");
            blad = false;
        }
        if (sprawdzPola(haslo)) {
            haslo.setStyle("-fx-border-color: red;");
            blad = false;
        }
        return blad;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logAs.getItems().addAll("Klient", "Mechanik", "Administrator");
        logAs.getSelectionModel().select(0);
    }

}
