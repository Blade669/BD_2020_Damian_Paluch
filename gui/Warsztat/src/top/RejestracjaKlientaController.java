/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static top.KlienciController.czyLiczba;
import static top.Polaczenie.getConnection;

/**
 * FXML Controller class
 *
 * @author h
 */
public class RejestracjaKlientaController implements Initializable {

    @FXML
    private TextField login;
    @FXML
    private TextField imie;
    @FXML
    private TextField nazwisko;
    @FXML
    private TextField nrTel;
    @FXML
    private PasswordField haslo;
    @FXML
    private PasswordField powtorzHaslo;

    @FXML
    private void actionPowrot(ActionEvent event) throws ParseException, IOException {
        SceneMenager.renderScene("logowanie");
    }

    @FXML
    private void actionRejestruj(ActionEvent event) throws ParseException, IOException, SQLException {
        login.setStyle("-fx-border-color: transparent;");
        haslo.setStyle("-fx-border-color: transparent;");
        powtorzHaslo.setStyle("-fx-border-color: transparent;");
        imie.setStyle("-fx-border-color: transparent;");
        nazwisko.setStyle("-fx-border-color: transparent;");
        nrTel.setStyle("-fx-border-color: transparent;");
        CallableStatement stmt = null;
        if (sprawdzBledyRejestracji()) {
            try {
                Connection con = getConnection();
                stmt = con.prepareCall("{call klient_rejestracja.rejestruj_klienta(?,?,?,?,?,?)}");
                stmt.setString(1, login.getText());
                stmt.setString(2, haslo.getText());
                stmt.setString(3, powtorzHaslo.getText());
                stmt.setString(4, imie.getText());
                stmt.setString(5, nazwisko.getText());
                stmt.setLong(6, Long.parseLong(nrTel.getText()));
                stmt.execute();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Rejestracja");
                alert.setContentText("Rejestracja pomyślna");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("/top/darkTheme.css").toExternalForm());
                dialogPane.getStyleClass().add("alert");
                alert.showAndWait();

            } catch (SQLException ex) {
                if (ex.getErrorCode() == 00001) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Błąd rejestracji");
                    alert.setContentText("Login zajęty");
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("/top/darkTheme.css").toExternalForm());
                    dialogPane.getStyleClass().add("alert");
                    alert.showAndWait();
                } else if (ex.getErrorCode() == 20001) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Błąd rejestracji");
                    alert.setContentText("Login musi zawierać przynajmniej 6 znaków");
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("/top/darkTheme.css").toExternalForm());
                    dialogPane.getStyleClass().add("alert");
                    alert.showAndWait();
                }else if (ex.getErrorCode() == 20002) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Błąd rejestracji");
                    alert.setContentText("Hasło musi zawierać przynajmniej 6 znaków");
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("/top/darkTheme.css").toExternalForm());
                    dialogPane.getStyleClass().add("alert");
                    alert.showAndWait();
                } 
                else if (ex.getErrorCode() == 20003) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Błąd rejestracji");
                    alert.setContentText("Hasło musi zawierać cyfrę");
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("/top/darkTheme.css").toExternalForm());
                    dialogPane.getStyleClass().add("alert");
                    alert.showAndWait();
                } else if (ex.getErrorCode() == 20004) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Błąd rejestracji");
                    alert.setContentText("Numer telefonu musi zawierać 9 cyfr");
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("/top/darkTheme.css").toExternalForm());
                    dialogPane.getStyleClass().add("alert");
                    alert.showAndWait();
                } else if (ex.getErrorCode() == 20005) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Błąd rejestracji");
                    alert.setContentText("Hasła się różnią");
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("/top/darkTheme.css").toExternalForm());
                    dialogPane.getStyleClass().add("alert");
                    alert.showAndWait();
                } 
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Błąd rejestracji");
                    alert.setContentText("Wystąpił błąd");
                    DialogPane dialogPane = alert.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("/top/darkTheme.css").toExternalForm());
                    dialogPane.getStyleClass().add("alert");
                    alert.showAndWait();
                }
            }
        }
    }

    private boolean sprawdzPola(TextField pf) throws SQLException {
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

    private boolean sprawdzBledyRejestracji() throws SQLException {
        boolean blad = true;
        if (sprawdzPola(login)) {
            login.setStyle("-fx-border-color: red;");
            blad = false;
        }
        if (sprawdzPola(haslo)) {
            haslo.setStyle("-fx-border-color: red;");
            blad = false;
        }
        if (sprawdzPola(powtorzHaslo)) {
            powtorzHaslo.setStyle("-fx-border-color: red;");
            blad = false;
        }
        if (sprawdzPola(imie)) {
            imie.setStyle("-fx-border-color: red;");
            blad = false;
        }
        if (sprawdzPola(nazwisko)) {
            nazwisko.setStyle("-fx-border-color: red;");
            blad = false;
        }
        if (sprawdzPola(nrTel)) {
            nrTel.setStyle("-fx-border-color: red;");
            blad = false;
        }
        if (!czyLiczba(nrTel.getText())) {
            nrTel.setStyle("-fx-border-color: red;");
            blad = false;
        }
        return blad;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
