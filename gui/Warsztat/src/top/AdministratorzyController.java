/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import entity.Diagnozy;
import entity.Pracownicy;
import entity.Przeglady;
import entity.Samochody_uslugi;
import entity.Uslugi;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.DialogPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import oracle.jdbc.OracleTypes;
import static top.KlienciController.czyLiczba;
import static top.Polaczenie.getConnection;
import static top.SceneMenager.renderScene;

/**
 * FXML Controller class
 *
 * @author h
 */
public class AdministratorzyController implements Initializable {

    @FXML
    private TableColumn<?, ?> nazwaU;
    @FXML
    private TableColumn<?, ?> opisU;
    @FXML
    private TableColumn<?, ?> imie;
    @FXML
    private TableColumn<?, ?> nazwisko;
    @FXML
    private TableColumn<?, ?> nrTel;
    @FXML
    private TableColumn<?, ?> adres;
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
    private TableColumn<?, ?> markaP;
    @FXML
    private TableColumn<?, ?> modelP;
    @FXML
    private TableColumn<?, ?> wynikP;
    @FXML
    private TableColumn<?, ?> dataWaznosciP;
    @FXML
    private TableColumn<?, ?> uwagiP;
    @FXML
    private TableColumn<?, ?> dataP;
    @FXML
    private TableView<Uslugi> edycjaUslug;
    @FXML
    private TableColumn<?, ?> markaU;
    @FXML
    private TableColumn<?, ?> modelU;
    @FXML
    private TableColumn<?, ?> uslugaU;
    @FXML
    private TableColumn<?, ?> dataU;
    @FXML
    private TableView<Pracownicy> pracownicy;
    @FXML
    private TableView<Diagnozy> diagnozy;
    @FXML
    private TableView<Przeglady> przeglady;
    @FXML
    private TableView<Samochody_uslugi> uslugi;
    @FXML
    private TextField szukajEdycjiUslugi;
    @FXML
    private TextField szukajPracownika;
    @FXML
    private TextField szukajDiagnozy;
    @FXML
    private TextField szukajPrzegladu;
    @FXML
    private TextField szukajUslugi;
    @FXML
    private TextField nazwaE;
    @FXML
    private TextField imieE;
    @FXML
    private TextField nazwiskoE;
    @FXML
    private TextField nrTelE;
    @FXML
    private TextField adresE;
    @FXML
    private TextArea opisE;
    @FXML
    private TextField nazwaD;
    @FXML
    private TextArea opisD;
    @FXML
    private Tab wyloguj;
    @FXML
    private TabPane tabPane;
    private int idUslugi = 0;
    private int idPracownika = 0;

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
    private void actionSzukajEdycjiUslugi(ActionEvent event) throws ParseException, IOException {

        CallableStatement stmt = null;

        try {
            Connection con = getConnection();
            stmt = con.prepareCall("{call szukaj_danych.szukaj_edycji_uslugi_admin(?,?)}");
            stmt.setString(1, szukajEdycjiUslugi.getText());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rs = (ResultSet) stmt.getObject(2);
            edycjaUslug.getItems().clear();
            while (rs.next()) {
                Uslugi nowa = new Uslugi(rs.getInt(1), rs.getString(2), rs.getString(3));
                edycjaUslug.getItems().add(nowa);

            }
        } catch (SQLException ex) {
            System.out.println("cd");
        }
    }

    @FXML
    private void actionEdytujUsluge(ActionEvent event) throws ParseException, IOException {
        nazwaE.setDisable(false);
        opisE.setDisable(false);
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from uslugi where id = ?");
            pstmt.setInt(1, edycjaUslug.getSelectionModel().getSelectedItem().getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                nazwaE.setText(rs.getString(2));
                opisE.setText(rs.getString(3));
                idUslugi = rs.getInt(1);
            }
        } catch (SQLException ex) {

        }
    }

    @FXML
    private void actionZapiszUsluge(ActionEvent event) throws ParseException, IOException, SQLException {
        nazwaE.setStyle("-fx-border-color: transparent");
        opisE.setStyle("-fx-border-color: transparent");
        if (idUslugi != 0 && sprawdzBledyEdycjaUslugi()) {
            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("call edytuj_dane.edytuj_uslugi(?,?,?)");
                cstmt.setInt(1, idUslugi);
                cstmt.setString(2, nazwaE.getText());
                cstmt.setString(3, opisE.getText());
                cstmt.executeQuery();
                uzupelnijEdycjeUslug();

                alertInformacja("Edytuj usługe", "Operacja powiodła się");

            } catch (SQLException ex) {
                alertBlad("Edytuj usługe", "Operacja nie powiodła się");
            }
        }
    }

    @FXML
    private void actionDodajUsluge(ActionEvent event) throws ParseException, IOException, SQLException {
        nazwaD.setStyle("-fx-border-color: transparent");
        opisD.setStyle("-fx-border-color: transparent");
        if (sprawdzBledyDodajUsluge()) {
            try {

                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("call dodaj_dane.dodaj_usluge_admin(?,?)");
                cstmt.setString(1, nazwaD.getText());
                cstmt.setString(2, opisD.getText());
                cstmt.executeQuery();
                uzupelnijEdycjeUslug();

                alertInformacja("Dodaj usługe", "Operacja powiodła się");

            } catch (SQLException ex) {
                alertBlad("Dodaj usługe", "Operacja nie powiodła się");
            }
        }
    }

    @FXML
    private void actionEdytujPracownika(ActionEvent event) throws ParseException, IOException {
        if (pracownicy.getSelectionModel().getSelectedIndex() != - 1) {
            idPracownika = pracownicy.getSelectionModel().getSelectedItem().getId();
            imieE.setText(pracownicy.getSelectionModel().getSelectedItem().getImie());
            nazwiskoE.setText(pracownicy.getSelectionModel().getSelectedItem().getNazwisko());
            nrTelE.setText(Long.toString(pracownicy.getSelectionModel().getSelectedItem().getNr_tel()));
            adresE.setText(pracownicy.getSelectionModel().getSelectedItem().getAdres());
            imieE.setDisable(false);
            nazwiskoE.setDisable(false);
            nrTelE.setDisable(false);
            adresE.setDisable(false);
        }
    }

    @FXML
    private void actionSzukajPracownika(ActionEvent event) throws ParseException, IOException {

        CallableStatement stmt = null;

        try {
            Connection con = getConnection();
            stmt = con.prepareCall("{call szukaj_danych.szukaj_pracownika(?,?)}");
            stmt.setString(1, szukajPracownika.getText());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rs = (ResultSet) stmt.getObject(2);
            pracownicy.getItems().clear();
            while (rs.next()) {
                Pracownicy nowa = new Pracownicy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getInt(6));
                pracownicy.getItems().add(nowa);

            }
        } catch (SQLException ex) {
            System.out.println("cd");
        }
    }

    @FXML
    private void actionSzukajDiagnozy(ActionEvent event) throws ParseException, IOException {

        CallableStatement stmt = null;

        try {
            Connection con = getConnection();
            stmt = con.prepareCall("{call szukaj_danych.szukaj_diagnozy_admin(?,?)}");
            stmt.setString(1, szukajDiagnozy.getText());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rs = (ResultSet) stmt.getObject(2);
            diagnozy.getItems().clear();
            while (rs.next()) {
                Diagnozy nowa = new Diagnozy(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8));
                diagnozy.getItems().add(nowa);

            }
        } catch (SQLException ex) {
            System.out.println("cd");
        }
    }

    @FXML
    private void actionSzukajPrzegladu(ActionEvent event) throws ParseException, IOException {

        CallableStatement stmt = null;

        try {
            Connection con = getConnection();
            stmt = con.prepareCall("{call szukaj_danych.szukaj_przegladu_admin(?,?)}");
            stmt.setString(1, szukajPrzegladu.getText());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rs = (ResultSet) stmt.getObject(2);
            przeglady.getItems().clear();
            while (rs.next()) {
                Przeglady nowa = new Przeglady(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                przeglady.getItems().add(nowa);

            }
        } catch (SQLException ex) {
            System.out.println("cd");
        }
    }

    @FXML
    private void actionSzukajUslugi(ActionEvent event) throws ParseException, IOException {

        CallableStatement stmt = null;

        try {
            Connection con = getConnection();
            stmt = con.prepareCall("{call szukaj_danych.szukaj_uslugi_admin(?,?)}");
            stmt.setString(1, szukajUslugi.getText());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rs = (ResultSet) stmt.getObject(2);
            uslugi.getItems().clear();
            while (rs.next()) {
                Samochody_uslugi nowa = new Samochody_uslugi(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8));
                uslugi.getItems().add(nowa);

            }
        } catch (SQLException ex) {
            System.out.println("cd");
        }
    }

    @FXML
    private void actionZapiszPracownika(ActionEvent event) throws ParseException, IOException, SQLException {
        imieE.setStyle("-fx-border-color: transparent");
        nazwiskoE.setStyle("-fx-border-color: transparent");
        nrTelE.setStyle("-fx-border-color: transparent");
        adresE.setStyle("-fx-border-color: transparent");
        if (idPracownika != 0 && sprawdzBledyEdytujPracownika()) {
            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("call edytuj_dane.edytuj_pracownikow(?,?,?,?,?)");
                cstmt.setInt(1, idPracownika);
                cstmt.setString(2, imieE.getText());
                cstmt.setString(3, nazwiskoE.getText());
                cstmt.setString(4, nrTelE.getText());
                cstmt.setString(5, adresE.getText());
                cstmt.executeQuery();
                uzupelnijPracownikow();

                alertInformacja("Dodaj diagnoze", "Operacja powiodła się");

            } catch (SQLException ex) {
                alertBlad("Dodaj diagnoze", "Operacja nie powiodła się");
            }
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

    private boolean sprawdzDane(TextArea ta) throws SQLException {
        Connection con = getConnection();
        CallableStatement cstmt = con.prepareCall("{? = call walidacja.czy_puste(?)}");
        cstmt.registerOutParameter(1, Types.NUMERIC);
        cstmt.setString(2, ta.getText());
        cstmt.executeQuery();
        if (cstmt.getInt(1) == 1) {
            return false;
        }
        return true;
    }

    private boolean sprawdzBledyDodajUsluge() throws SQLException {
        boolean blad = true;
        if (sprawdzDane(nazwaD)) {
            nazwaD.setStyle("-fx-border-color: red");
            blad = false;
        }
        if (sprawdzDane(opisD)) {
            opisD.setStyle("-fx-border-color: red");
            blad = false;
        }

        return blad;
    }

    private boolean sprawdzBledyEdycjaUslugi() throws SQLException {
        boolean blad = true;
        if (!nazwaE.isDisabled()) {
            if (sprawdzDane(nazwaE)) {
                nazwaE.setStyle("-fx-border-color: red");
                blad = false;
            }
            if (sprawdzDane(opisE)) {
                opisE.setStyle("-fx-border-color: red");
                blad = false;
            }
        }

        return blad;
    }

    private boolean sprawdzBledyEdytujPracownika() throws SQLException {
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
        if (sprawdzDane(adresE)) {
            adresE.setStyle("-fx-border-color: red");
            blad = false;
        }
        if (czyLiczba(nrTel.getText())) {
            nrTelE.setStyle("-fx-border-color: red");
            blad = false;
        }
        return blad;
    }

    private void uzupelnijEdycjeUslug() {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from uslugi");
            ObservableList<Uslugi> usluga = FXCollections.observableArrayList();
            while (rs.next()) {
                Uslugi nowa = new Uslugi(rs.getInt(1), rs.getString(2), rs.getString(3));
                usluga.add(nowa);
            }
            edycjaUslug.getItems().clear();
            edycjaUslug.setItems(usluga);
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    private void uzupelnijPracownikow() {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pracownicy where id_uzytkownika = 1");
            ObservableList<Pracownicy> pracownik = FXCollections.observableArrayList();
            while (rs.next()) {
                Pracownicy nowa = new Pracownicy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getInt(6));
                pracownik.add(nowa);
            }
            pracownicy.getItems().clear();
            pracownicy.setItems(pracownik);
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    private void uzupelnijDiagnozy() {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select d.*, s.marka, s.model\n"
                    + "from diagnozy d, samochody s\n"
                    + "where d.id_samochodu = s.id");
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
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select p.*, s.marka, s.model\n"
                    + "from przeglady p, samochody s\n"
                    + "where p.id_samochodu = s.id");
            ObservableList<Przeglady> przeglad = FXCollections.observableArrayList();
            while (rs.next()) {
                Przeglady nowa = new Przeglady(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                przeglad.add(nowa);
            }
            przeglady.getItems().clear();
            przeglady.setItems(przeglad);
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    private void uzupelnijUslugi() {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select su.*, s.marka, s.model, u.nazwa\n"
                    + "from samochody s, samochody_uslugi su, uslugi u\n"
                    + "where s.id = su.id_samochodu and u.id = su.id_uslugi");
            ObservableList<Samochody_uslugi> usluga = FXCollections.observableArrayList();
            while (rs.next()) {
                Samochody_uslugi nowa = new Samochody_uslugi(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8));
                usluga.add(nowa);
            }
            uslugi.getItems().clear();
            uslugi.setItems(usluga);
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nazwaU.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        opisU.setCellValueFactory(new PropertyValueFactory<>("opis"));
        imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        nrTel.setCellValueFactory(new PropertyValueFactory<>("nr_tel"));
        adres.setCellValueFactory(new PropertyValueFactory<>("adres"));
        markaD.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelD.setCellValueFactory(new PropertyValueFactory<>("model"));
        uwagiD.setCellValueFactory(new PropertyValueFactory<>("uwagi_klienta"));
        uwagiMechD.setCellValueFactory(new PropertyValueFactory<>("uwagi_mechanika"));
        dataD.setCellValueFactory(new PropertyValueFactory<>("data"));
        markaP.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelP.setCellValueFactory(new PropertyValueFactory<>("model"));
        wynikP.setCellValueFactory(new PropertyValueFactory<>("wynik"));
        dataWaznosciP.setCellValueFactory(new PropertyValueFactory<>("data_waznosci"));
        uwagiP.setCellValueFactory(new PropertyValueFactory<>("uwagi"));
        dataP.setCellValueFactory(new PropertyValueFactory<>("data"));
        markaU.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelU.setCellValueFactory(new PropertyValueFactory<>("model"));
        uslugaU.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        dataU.setCellValueFactory(new PropertyValueFactory<>("data"));

        uzupelnijEdycjeUslug();
        uzupelnijPracownikow();
        uzupelnijDiagnozy();
        uzupelnijPrzeglady();
        uzupelnijUslugi();

        wyloguj.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (wyloguj.isSelected()) {
                    try {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Wylogowywanie");
                        alert.setHeaderText("Na pewno?");
                        DialogPane dialogPane = alert.getDialogPane();
                        dialogPane.getStylesheets().add(
                                getClass().getResource("/top/darkTheme.css").toExternalForm());
                        dialogPane.getStyleClass().add("alert");
                        Optional<ButtonType> tak = alert.showAndWait();
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
    }

}
