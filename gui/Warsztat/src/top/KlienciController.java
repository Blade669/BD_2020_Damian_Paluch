/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import entity.Diagnozy;
import entity.Klienci_uzytkownicy;
import entity.Przeglady;
import entity.Samochody_uslugi;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static top.Polaczenie.getConnection;
import static top.SceneMenager.renderScene;

/**
 * FXML Controller class
 *
 * @author h
 */
public class KlienciController implements Initializable {

    @FXML
    private TableView<Samochody_uslugi> uslugi;
    @FXML
    private TableView<Przeglady> przeglady;
    @FXML
    private TableView<Diagnozy> diagnozy;
    @FXML
    private TableColumn<?, ?> markaU;
    @FXML
    private TableColumn<?, ?> modelU;
    @FXML
    private TableColumn<?, ?> uslugaU;
    @FXML
    private TableColumn<?, ?> dataU;
    @FXML
    private TableColumn<?, ?> markaP;
    @FXML
    private TableColumn<?, ?> modelP;
    @FXML
    private TableColumn<?, ?> wynikP;
    @FXML
    private TableColumn<?, ?> dataP;
    @FXML
    private TableColumn<?, ?> waznoscP;
    @FXML
    private TableColumn<?, ?> uwagiP;
    @FXML
    private TableColumn<?, ?> markaD;
    @FXML
    private TableColumn<?, ?> modelD;
    @FXML
    private TableColumn<?, ?> uwagiD;
    @FXML
    private TableColumn<?, ?> uwagiMechD;
    @FXML
    private TableColumn<?, ?> dataD;
    @FXML
    private ComboBox wybierzMarke;
    @FXML
    private ComboBox wybierzModel;
    @FXML
    private TextField markaE;
    @FXML
    private TextField modelE;
    @FXML
    private TextField pojSilnikaE;
    @FXML
    private TextField rokE;
    @FXML
    private Tab wyloguj;
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField markaDod;
    @FXML
    private TextField modelDod;
    @FXML
    private TextField pojSilnikaDod;
    @FXML
    private TextField rokDod;
    @FXML
    private ComboBox wybierzSamochodP;
    @FXML
    private ComboBox wybierzSamochodU;
    @FXML
    private ComboBox wybierzSamochodD;
    @FXML
    private ComboBox wybierzUsluge;
    @FXML
    private TextField imieE;
    @FXML
    private TextField nazwiskoE;
    @FXML
    private TextField nrTelE;
    @FXML
    private DatePicker wybierzDateU;
    @FXML
    private DatePicker wybierzDateP;
    @FXML
    private DatePicker wybierzDateD;
    @FXML
    private TextArea uwagiKlienta;
    private int idSamochodu;
    private int idKlienta;
    private int idSamochoduD;
    private int idSamochoduU;
    private int idSamochoduP;
    private int idUslugi;
    private boolean poprawnaDiagnoza = true;
    private boolean poprawnyPrzeglad = true;
    private boolean poprawnaUsluga = true;
    private boolean poprawnyDodajSamochod = true;
    private boolean poprawneDane = true;
    private boolean poprawnyEdytujSamochod = true;

    private void alertInformacja(String tekst, String blad) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(tekst);
        alert.setContentText(blad);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("/top/darkTheme.css").toExternalForm());
        dialogPane.getStyleClass().add("alert");
        alert.showAndWait();
    }

    private void alertBlad(String tekst, String blad) {
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
    private void actionIdSamochoduU(ActionEvent event) throws ParseException, IOException {
        try {
            Connection con = getConnection();
            String tekst = wybierzSamochodU.getSelectionModel().getSelectedItem().toString();
            int iend = tekst.lastIndexOf("  ");
            String marka = tekst.substring(0, iend);
            String model = tekst.substring(iend + 2);
            CallableStatement cstmt = con.prepareCall("select * from samochody where id_klienta = ? and marka = ? and model = ?");
            cstmt.setInt(1, idKlienta);
            cstmt.setString(2, marka);
            cstmt.setString(3, model);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                idSamochoduU = rs.getInt(1);
            }
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    @FXML
    private void actionIdSamochoduP(ActionEvent event) throws ParseException, IOException {
        try {
            Connection con = getConnection();
            String tekst = wybierzSamochodP.getSelectionModel().getSelectedItem().toString();
            int iend = tekst.lastIndexOf("  ");
            String marka = tekst.substring(0, iend);
            String model = tekst.substring(iend + 2);
            CallableStatement cstmt = con.prepareCall("select * from samochody where id_klienta = ? and marka = ? and model = ?");
            cstmt.setInt(1, idKlienta);
            cstmt.setString(2, marka);
            cstmt.setString(3, model);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                idSamochoduP = rs.getInt(1);
            }
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    @FXML
    private void actionIdSamochoduD(ActionEvent event) throws ParseException, IOException {
        try {
            Connection con = getConnection();
            String tekst = wybierzSamochodD.getSelectionModel().getSelectedItem().toString();
            int iend = tekst.lastIndexOf("  ");
            String marka = tekst.substring(0, iend);
            String model = tekst.substring(iend + 2);
            CallableStatement cstmt = con.prepareCall("select * from samochody where id_klienta = ? and marka = ? and model = ?");
            cstmt.setInt(1, idKlienta);
            cstmt.setString(2, marka);
            cstmt.setString(3, model);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                idSamochoduD = rs.getInt(1);
            }
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    @FXML
    private void actionIdUslugiU(ActionEvent event) throws ParseException, IOException {
        try {
            Connection con = getConnection();

            CallableStatement cstmt = con.prepareCall("select * from uslugi where nazwa = ?");
            cstmt.setString(1, wybierzUsluge.getSelectionModel().getSelectedItem().toString());

            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                idUslugi = rs.getInt(1);
            }
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    @FXML
    private void actionMarka(ActionEvent event) throws ParseException, IOException {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = null;
            pstmt = con.prepareStatement("SELECT model FROM samochody WHERE marka = ? and id_klienta = ?");
            pstmt.setString(1, wybierzMarke.getSelectionModel().getSelectedItem().toString());
            pstmt.setInt(2, idKlienta);
            ResultSet rs = pstmt.executeQuery();
            wybierzModel.getItems().clear();
            while (rs.next()) {

                wybierzModel.getItems().add(rs.getString("model"));
                wybierzModel.setValue("Wybierz model");
            }
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }

    }

    @FXML
    private void actionModel(ActionEvent event) throws ParseException, IOException {
        if (wybierzModel.getSelectionModel().getSelectedIndex() != -1) {
            try {
                Connection con = getConnection();
                PreparedStatement pstmt = null;
                pstmt = con.prepareStatement("SELECT * FROM samochody WHERE marka = ? and model = ? and id_klienta = ?");
                pstmt.setString(1, wybierzMarke.getSelectionModel().getSelectedItem().toString());
                pstmt.setString(2, wybierzModel.getSelectionModel().getSelectedItem().toString());
                pstmt.setInt(3, idKlienta);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    idSamochodu = rs.getInt("id");
                    markaE.setText(rs.getString("marka"));
                    modelE.setText(rs.getString("model"));
                    pojSilnikaE.setText(rs.getString("poj_silnika"));
                    rokE.setText(rs.getString("rok"));

                }

            } catch (SQLException ed) {
                ed.printStackTrace();
            }
        }

    }

    @FXML
    private void actionEdytujSamochod(ActionEvent event) throws ParseException, IOException, SQLException {
        markaE.setStyle("-fx-border-color: transparent");
        modelE.setStyle("-fx-border-color: transparent");
        rokE.setStyle("-fx-border-color: transparent");
        pojSilnikaE.setStyle("-fx-border-color: transparent");
        if (sprawdzBledyEdytujSamochod()) {
            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("call edytuj_dane.edytuj_samochod(?,?,?,?,?)");
                cstmt.setInt(1, idSamochodu);
                cstmt.setString(2, markaE.getText());
                cstmt.setString(3, modelE.getText());
                cstmt.setString(4, pojSilnikaE.getText());
                cstmt.setString(5, rokE.getText());
                cstmt.executeQuery();

                wybierzMarke.setValue("Wybierz marke");
                wybierzModel.getItems().clear();
                markaE.clear();
                modelE.clear();
                pojSilnikaE.clear();
                rokE.clear();
                alertInformacja("Zmiana danych", "Operacja powiodła się");

            } catch (SQLException ex) {
                alertBlad("Zmiana danych", "Operacja nie powiodła się");
            }
        }
    }

    @FXML
    private void actionUsunSamochod(ActionEvent event) throws ParseException, IOException {
        try {
            Connection con = getConnection();
            CallableStatement cstmt = con.prepareCall("call usun_dane.usun_samochod(?)");
            cstmt.setInt(1, idSamochodu);
            cstmt.executeQuery();

            wybierzModel.getItems().clear();
            markaE.clear();
            modelE.clear();
            pojSilnikaE.clear();
            rokE.clear();
            if (wybierzModel.getSelectionModel().getSelectedIndex() != -1) {
                alertInformacja("Usuwanie samochodu", "Operacja powiodła się");
            }

            cstmt = con.prepareCall("select * from samochody where id_klienta = ?");
            cstmt.setInt(1, idKlienta);
            ResultSet rs = cstmt.executeQuery();
            wybierzMarke.getItems().clear();
            wybierzMarke.setValue("Wybierz marke");
            while (rs.next()) {
                if (!wybierzMarke.getItems().contains(rs.getString("marka"))) {
                    wybierzMarke.getItems().add(rs.getString("marka"));
                }
            }
            con.close();

        } catch (SQLException ex) {
            alertBlad("Usuwanie samochodu", "Nie można usunąć pojazdu posiadającego historię");
        }

    }

    @FXML
    private void actionDodajSamochod(ActionEvent event) throws ParseException, IOException, SQLException {
            markaDod.setStyle("-fx-border-color: transparent");
            modelDod.setStyle("-fx-border-color: transparent");
            rokDod.setStyle("-fx-border-color: transparent");
            pojSilnikaDod.setStyle("-fx-border-color: transparent");
            if (sprawdzBledyDodajSamochod()) {
                if (czyMoznaSamochod(markaDod, modelDod)) {
                try {
                    Connection con = getConnection();
                    CallableStatement cstmt = con.prepareCall("call dodaj_dane.dodaj_samochod(?,?,?,?,?)");
                    cstmt.setString(1, markaDod.getText());
                    cstmt.setString(2, modelDod.getText());
                    cstmt.setInt(3, Integer.parseInt(pojSilnikaDod.getText()));
                    cstmt.setInt(4, Integer.parseInt(rokDod.getText()));
                    cstmt.setInt(5, idKlienta);
                    cstmt.executeQuery();

                    markaDod.clear();
                    modelDod.clear();
                    pojSilnikaDod.clear();
                    rokDod.clear();
                    alertInformacja("Dodawanie samochodu", "Operacja powiodła się");

                } catch (SQLException ex) {

                    alertBlad("Dodawanie samochodu", "Operacja nie powiodła się");
                }
                try {
                    Connection con = getConnection();
                    CallableStatement cstmt = con.prepareCall("select marka, model from samochody where id_klienta = ?");
                    cstmt.setInt(1, idKlienta);
                    ResultSet rs = cstmt.executeQuery();
                    wybierzMarke.getItems().clear();
                    wybierzSamochodP.getItems().clear();
                    wybierzSamochodU.getItems().clear();
                    wybierzSamochodD.getItems().clear();
                    while (rs.next()) {

                        if (!wybierzMarke.getItems().contains(rs.getString("marka"))) {
                            wybierzMarke.getItems().add(rs.getString("marka"));
                        }
                        wybierzMarke.setValue("Wybierz marke");
                        wybierzSamochodP.getItems().add(rs.getString("marka") + "  " + rs.getString("model"));
                        wybierzSamochodP.setValue("Wybierz samochód");
                        wybierzSamochodU.getItems().add(rs.getString("marka") + "  " + rs.getString("model"));
                        wybierzSamochodU.setValue("Wybierz samochód");
                        wybierzSamochodD.getItems().add(rs.getString("marka") + "  " + rs.getString("model"));
                        wybierzSamochodD.setValue("Wybierz samochód");

                    }
                } catch (SQLException ed) {
                    ed.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void actionEdytujDane(ActionEvent event) throws ParseException, IOException, SQLException {
        imieE.setStyle("-fx-border-color: transparent");
        nazwiskoE.setStyle("-fx-border-color: transparent");
        nrTelE.setStyle("-fx-border-color: transparent");

        if (sprawdzBledyEdytujDane()) {
            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("call edytuj_dane.edytuj_dane_klienta(?,?,?,?)");
                cstmt.setInt(1, idKlienta);
                cstmt.setString(2, imieE.getText());
                cstmt.setString(3, nazwiskoE.getText());
                cstmt.setString(4, nrTelE.getText());
                cstmt.executeQuery();

                alertInformacja("Zmiana danych", "Operacja powiodła się");

            } catch (SQLException ex) {
                alertBlad("Zmiana danych", "Wprowadzono błędne dane");
            }
        }
    }

    @FXML
    private void actionOdblokujDane(ActionEvent event) throws ParseException, IOException {
        imieE.setEditable(true);
        nazwiskoE.setEditable(true);
        nrTelE.setEditable(true);
    }

    @FXML
    private void actionDodajUsluge(ActionEvent event) throws ParseException, IOException, SQLException {
        if (czyMoznaUsluge()) {
            if (wybierzSamochodU.getSelectionModel().getSelectedIndex() == -1) {
                wybierzSamochodU.setStyle("-fx-border-color: red;");
            } else {
                wybierzSamochodU.setStyle("-fx-border-color: transparent;");
            }
            if (wybierzUsluge.getSelectionModel().getSelectedIndex() == -1) {
                wybierzUsluge.setStyle("-fx-border-color: red;");
            } else {
                wybierzUsluge.setStyle("-fx-border-color: transparent;");
            }

            wybierzDateU.setStyle("-fx-border-color: transparent;");

            if (sprawdzBledyUsluga() && !wybierzSamochodU.getSelectionModel().isEmpty() && !wybierzUsluge.getSelectionModel().isEmpty()) {
                try {
                    Connection con = getConnection();
                    CallableStatement cstmt = con.prepareCall("call dodaj_dane.dodaj_usluge(?,?,?)");
                    cstmt.setInt(1, idUslugi);
                    cstmt.setInt(2, idSamochoduU);
                    cstmt.setString(3, wybierzDateU.getValue().toString());
                    cstmt.executeQuery();

                    alertInformacja("Dodaj usługę", "Operacja powiodła się");

                } catch (SQLException ex) {
                    if (ex.getErrorCode() == 20006) {
                        alertBlad("Dodaj usługe", "Podano datę z przeszłości");
                    } else if (ex.getErrorCode() == 20007) {
                        alertBlad("Dodaj usługe", "Nie można umówić sie na weekend");
                    } else {
                        alertBlad("Dodaj usługe", "Operacja nie powiodła się");
                    }
                }
                uzupelnijUslugi();

            }
        } else {
            alertBlad("Dodaj usługe", "Tego dnia zapisanych jest za dużo wizyt");
        }
    }

    @FXML
    private void actionDodajPrzeglad(ActionEvent event) throws ParseException, IOException, SQLException {
        if (czyMoznaPrzeglad()) {
            if (wybierzSamochodP.getSelectionModel().getSelectedIndex() == -1) {
                wybierzSamochodP.setStyle("-fx-border-color: red;");
            } else {
                wybierzSamochodP.setStyle("-fx-border-color: transparent;");
            }

            wybierzDateP.setStyle("-fx-border-color: transparent;");
            if (sprawdzBledyPrzeglad() && !wybierzSamochodP.getSelectionModel().isEmpty()) {
                try {
                    Connection con = getConnection();
                    CallableStatement cstmt = con.prepareCall("call dodaj_dane.dodaj_przeglad(?,?)");
                    cstmt.setInt(1, idSamochoduP);
                    cstmt.setString(2, wybierzDateP.getValue().toString());
                    cstmt.executeQuery();

                    alertInformacja("Dodaj przegląd", "Operacja powiodła się");

                } catch (SQLException ex) {
                    if (ex.getErrorCode() == 20006) {
                        alertBlad("Dodaj przegląd", "Podano datę z przeszłości");
                    } else if (ex.getErrorCode() == 20007) {
                        alertBlad("Dodaj przegląd", "Nie można umówić sie na weekend");
                    } else {
                        alertBlad("Dodaj przegląd", "Operacja nie powiodła się");
                    }
                }
                uzupelnijPrzeglady();

            }
        } else {
            alertBlad("Dodaj przegląd", "Tego dnia zapisanych jest za dużo wizyt");
        }
    }

    @FXML
    private void actionDodajDiagnoze(ActionEvent event) throws ParseException, IOException, SQLException {
        if (czyMoznaDiagnoze()) {
            if (wybierzSamochodD.getSelectionModel().getSelectedIndex() == -1) {
                wybierzSamochodD.setStyle("-fx-border-color: red;");
            } else {
                wybierzSamochodD.setStyle("-fx-border-color: transparent;");
            }
            wybierzDateD.setStyle("-fx-border-color: transparent;");
            if (sprawdzBledyDiagnoza() && wybierzSamochodD.getSelectionModel().getSelectedIndex() != -1) {
                try {
                    Connection con = getConnection();
                    CallableStatement cstmt = con.prepareCall("call dodaj_dane.dodaj_diagnoze(?,?,?)");
                    cstmt.setInt(1, idSamochoduD);
                    cstmt.setString(2, uwagiKlienta.getText());
                    cstmt.setString(3, wybierzDateD.getValue().toString());
                    cstmt.executeQuery();

                    alertInformacja("Dodaj diagnoze", "Operacja powiodła się");

                } catch (SQLException ex) {
                    if (ex.getErrorCode() == 20006) {
                        alertBlad("Dodaj diagnoze", "Podano datę z przeszłości");
                    } else if (ex.getErrorCode() == 20007) {
                        alertBlad("Dodaj diagnoze", "Nie można umówić sie na weekend");
                    } else {
                        alertBlad("Dodaj diagnoze", "Operacja nie powiodła się");
                    }
                }
                uzupelnijDiagnozy();

            }
        } else {
            alertBlad("Dodaj diagnoze", "Tego dnia zapisanych jest za dużo wizyt");
        }
    }

    private boolean czyMoznaDiagnoze() throws SQLException {
        Connection con = getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call czy_mozna.czy_mozna_diagnozy(?)}");
        cstmt.registerOutParameter(1, Types.NUMERIC);
        if (wybierzDateD.getValue() == null) {
            cstmt.setString(2, "");
        } else {
            cstmt.setString(2, wybierzDateD.getValue().toString());
        }
        cstmt.executeQuery();
        if (cstmt.getInt(1) == 1) {
            return false;
        }
        return true;
    }

    private boolean czyMoznaPrzeglad() throws SQLException {
        Connection con = getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call czy_mozna.czy_mozna_przeglady(?)}");
        cstmt.registerOutParameter(1, Types.NUMERIC);
        if (wybierzDateP.getValue() == null) {
            cstmt.setString(2, "");
        } else {
            cstmt.setString(2, wybierzDateP.getValue().toString());
        }
        cstmt.executeQuery();
        if (cstmt.getInt(1) == 1) {
            return false;
        }
        return true;
    }

    private boolean czyMoznaUsluge() throws SQLException {
        Connection con = getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call czy_mozna.czy_mozna_uslugi(?)}");
        cstmt.registerOutParameter(1, Types.NUMERIC);
        if (wybierzDateU.getValue() == null) {
            cstmt.setString(2, "");
        } else {
            cstmt.setString(2, wybierzDateU.getValue().toString());
        }
        cstmt.executeQuery();
        if (cstmt.getInt(1) == 1) {
            return false;
        }
        return true;
    }

    private boolean czyMoznaSamochod(TextField marka, TextField model) throws SQLException {
        try {
            Connection con = getConnection();
            CallableStatement cstmt = con.prepareCall("call czy_mozna.czy_mozna_samochod(?,?,?)");
            cstmt.setString(1, marka.getText());
            cstmt.setString(2, model.getText());
            cstmt.setInt(3, idKlienta);
            cstmt.executeQuery();
            return true;
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 20008) {
                alertBlad("Dodawanie samochodu", "Podany samochód istnieje w bazie");
            }
            return false;
        }
    }

    private boolean sprawdzDane(TextField tf) throws SQLException {
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

    private boolean sprawdzDane(DatePicker dp) throws SQLException {
        Connection con = getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call walidacja.czy_puste(?)}");
        cstmt.registerOutParameter(1, Types.NUMERIC);
        if (dp.getValue() == null) {
            cstmt.setString(2, "");
        } else {
            cstmt.setString(2, dp.getValue().toString());
        }
        cstmt.executeQuery();
        if (cstmt.getInt(1) == 1) {
            return false;
        }
        return true;
    }

    private boolean sprawdzBledyDiagnoza() throws SQLException {
        if (sprawdzDane(wybierzDateD)) {
            wybierzDateD.setStyle("-fx-border-color: red");
            return false;
        }
        return true;
    }

    private boolean sprawdzBledyPrzeglad() throws SQLException {
        if (sprawdzDane(wybierzDateP)) {
            wybierzDateP.setStyle("-fx-border-color: red");
            return false;
        }
        return true;
    }

    private boolean sprawdzBledyUsluga() throws SQLException {
        if (sprawdzDane(wybierzDateU)) {
            wybierzDateU.setStyle("-fx-border-color: red");
            return false;
        }
        return true;
    }

    private boolean sprawdzBledyDodajSamochod() throws SQLException {
        boolean blad = true;
        if (sprawdzDane(markaDod)) {
            markaDod.setStyle("-fx-border-color: red");
            blad = false;
        }
        if (sprawdzDane(modelDod)) {
            modelDod.setStyle("-fx-border-color: red");
            blad = false;
        }
        if (sprawdzDane(rokDod)) {
            rokDod.setStyle("-fx-border-color: red");
            blad = false;
        }
        if (sprawdzDane(pojSilnikaDod)) {
            pojSilnikaDod.setStyle("-fx-border-color: red");
            blad = false;
        }
        if (!czyLiczba(pojSilnikaDod.getText())) {
            pojSilnikaDod.setStyle("-fx-border-color: red");
            blad = false;
        }
        if (!czyLiczba(rokDod.getText())) {
            rokDod.setStyle("-fx-border-color: red");
            blad = false;
        }
        return blad;
    }

    private boolean sprawdzBledyEdytujDane() throws SQLException {
        boolean blad = true;
        if (sprawdzDane(imieE)) {
            imieE.setStyle("-fx-border-color: red");
            blad = false;
        }
        if (sprawdzDane(nazwiskoE)) {
            nazwiskoE.setStyle("-fx-border-color: red");
            blad = false;
        }
        if (sprawdzDane(nrTelE)) {
            nrTelE.setStyle("-fx-border-color: red");
            blad = false;
        }
        if (!czyLiczba(nrTelE.getText())) {
            nrTelE.setStyle("-fx-border-color: red");
            blad = false;
        }
        return blad;
    }

    private boolean sprawdzBledyEdytujSamochod() throws SQLException {
        boolean blad = true;
        if (wybierzModel.getSelectionModel().getSelectedIndex() != -1) {

            if (sprawdzDane(markaE)) {
                markaE.setStyle("-fx-border-color: red");
                blad = false;
            }
            if (sprawdzDane(modelE)) {
                modelE.setStyle("-fx-border-color: red");
                blad = false;
            }
            if (sprawdzDane(rokE)) {
                rokE.setStyle("-fx-border-color: red");
                blad = false;
            }
            if (sprawdzDane(pojSilnikaE)) {
                pojSilnikaE.setStyle("-fx-border-color: red");
                blad = false;
            }
            if (!czyLiczba(pojSilnikaE.getText())) {
                pojSilnikaE.setStyle("-fx-border-color: red");
                blad = false;
            }
            if (!czyLiczba(rokE.getText())) {
                rokE.setStyle("-fx-border-color: red");
                blad = false;
            }
            return blad;
        }
        return false;
    }

    public static boolean czyLiczba(String liczba) {
        if (liczba == null) {
            return false;
        }
        try {
            long x = Long.parseLong(liczba);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private void uzupelnijDiagnozy() {
        try {
            Connection con = getConnection();
            CallableStatement cstmt = con.prepareCall("select d.*, s.marka, s.model\n"
                    + "from diagnozy d, samochody s\n"
                    + "where s.id = d.id_samochodu\n"
                    + "and s.id_klienta = ?");
            cstmt.setInt(1, idKlienta);
            ResultSet rs = cstmt.executeQuery();
            ObservableList<Diagnozy> diagnoza = FXCollections.observableArrayList();
            while (rs.next()) {
                Diagnozy nowa = new Diagnozy(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8));
                diagnoza.add(nowa);
            }
            diagnozy.getItems().clear();
            diagnozy.setItems(diagnoza);
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    private void uzupelnijPrzeglady() {
        try {
            Connection con = getConnection();
            CallableStatement cstmt = con.prepareCall("select p.*, s.marka, s.model\n"
                    + "from samochody s, przeglady p\n"
                    + "where s.id = p.id_samochodu\n"
                    + "and s.id_klienta = ?");
            cstmt.setInt(1, idKlienta);
            ResultSet rs = cstmt.executeQuery();
            ObservableList<Przeglady> przeglad = FXCollections.observableArrayList();
            while (rs.next()) {
                Przeglady nowa = new Przeglady(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                przeglad.add(nowa);
            }
            przeglady.setItems(przeglad);
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    private void uzupelnijUslugi() {
        try {
            Connection con = getConnection();
            CallableStatement cstmt = con.prepareCall("select su.*, s.marka, s.model, u.nazwa\n"
                    + "from samochody s, samochody_uslugi su, uslugi u\n"
                    + "where s.id_klienta = ? and s.id = su.id_samochodu and u.id = su.id_uslugi");
            cstmt.setInt(1, idKlienta);

            ResultSet rs = cstmt.executeQuery();
            ObservableList<Samochody_uslugi> usluga = FXCollections.observableArrayList();
            while (rs.next()) {
                Samochody_uslugi nowa = new Samochody_uslugi(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8));
                usluga.add(nowa);
            }
            uslugi.setItems(usluga);
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        idKlienta = Klienci_uzytkownicy.getId();
        uzupelnijDiagnozy();
        uzupelnijPrzeglady();
        uzupelnijUslugi();
        wyloguj.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (wyloguj.isSelected()) {
                    try {

                        Alert wyloguj = new Alert(Alert.AlertType.CONFIRMATION);
                        wyloguj.setTitle("Wylogowywanie");
                        wyloguj.setHeaderText("Na pewno?");
                        DialogPane dialogPane = wyloguj.getDialogPane();
                        dialogPane.getStylesheets().add(
                                getClass().getResource("/top/darkTheme.css").toExternalForm());
                        dialogPane.getStyleClass().add("alert");
                        Optional<ButtonType> tak = wyloguj.showAndWait();
                        if (tak.get() == ButtonType.OK) {
                            renderScene("logowanie");
                        } else {
                            tabPane.getSelectionModel().selectFirst();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        markaU.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelU.setCellValueFactory(new PropertyValueFactory<>("model"));
        uslugaU.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        dataU.setCellValueFactory(new PropertyValueFactory<>("data"));

        markaP.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelP.setCellValueFactory(new PropertyValueFactory<>("model"));
        wynikP.setCellValueFactory(new PropertyValueFactory<>("wynik"));
        dataP.setCellValueFactory(new PropertyValueFactory<>("data"));
        waznoscP.setCellValueFactory(new PropertyValueFactory<>("data_waznosci"));
        uwagiP.setCellValueFactory(new PropertyValueFactory<>("uwagi"));

        markaD.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelD.setCellValueFactory(new PropertyValueFactory<>("model"));
        uwagiD.setCellValueFactory(new PropertyValueFactory<>("uwagi_klienta"));
        uwagiMechD.setCellValueFactory(new PropertyValueFactory<>("uwagi_mechanika"));
        dataD.setCellValueFactory(new PropertyValueFactory<>("data"));

//uzupelnianie pol
        try {
            Connection con = getConnection();
            CallableStatement cstmt = con.prepareCall("select * from samochody where id_klienta = ?");
            cstmt.setInt(1, idKlienta);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                if (!wybierzMarke.getItems().contains(rs.getString("marka"))) {
                    wybierzMarke.getItems().add(rs.getString("marka"));
                }
                wybierzMarke.setValue("Wybierz marke");
                wybierzSamochodP.getItems().add(rs.getString("marka") + "  " + rs.getString("model"));
                wybierzSamochodP.setValue("Wybierz samochód");
                wybierzSamochodU.getItems().add(rs.getString("marka") + "  " + rs.getString("model"));
                wybierzSamochodU.setValue("Wybierz samochód");
                wybierzSamochodD.getItems().add(rs.getString("marka") + "  " + rs.getString("model"));
                wybierzSamochodD.setValue("Wybierz samochód");
            }
            rs = cstmt.executeQuery("select * from uslugi");
            while (rs.next()) {
                wybierzUsluge.getItems().add(rs.getString("nazwa"));
                wybierzUsluge.setValue("Wybierz usluge");
            }

            cstmt = con.prepareCall("select * from klienci where id = ?");
            cstmt.setInt(1, idKlienta);

            rs = cstmt.executeQuery();
            while (rs.next()) {
                imieE.setText(rs.getString("imie"));
                nazwiskoE.setText(rs.getString("nazwisko"));
                nrTelE.setText(String.valueOf(rs.getLong("nr_tel")));
            }
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

}
