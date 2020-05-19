/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import entity.Diagnozy;
import entity.Pracownicy_uzytkownicy;
import entity.Przeglady;
import entity.Samochody_uslugi;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import oracle.jdbc.OracleTypes;
import static top.Polaczenie.getConnection;
import static top.SceneMenager.renderScene;

/**
 * FXML Controller class
 *
 * @author h
 */
public class MechanicyController implements Initializable {

    @FXML
    private Tab wyloguj;
    @FXML
    private Tab edycjaDanych;
    @FXML
    private TabPane tabPane;
    @FXML
    private AnchorPane edytujDane;
    @FXML
    private TableColumn<?, ?> markaD;
    @FXML
    private TableColumn<?, ?> modelD;
    @FXML
    private TableColumn<?, ?> uwagiD;
    @FXML
    private TableColumn<?, ?> dataD;
    @FXML
    private TableColumn<?, ?> markaDE;
    @FXML
    private TableColumn<?, ?> modelDE;
    @FXML
    private TableColumn<?, ?> uwagiMechDE;
    @FXML
    private TableColumn<?, ?> dataDE;
    @FXML
    private TableColumn<?, ?> markaP;
    @FXML
    private TableColumn<?, ?> modelP;
    @FXML
    private TableColumn<?, ?> dataP;
    @FXML
    private TableColumn<?, ?> markaPE;
    @FXML
    private TableColumn<?, ?> modelPE;
    @FXML
    private TableColumn<?, ?> dataPE;
    @FXML
    private TableColumn<?, ?> dataWaznosciPE;
    @FXML
    private TableColumn<?, ?> wynikPE;
    @FXML
    private TableColumn<?, ?> markaU;
    @FXML
    private TableColumn<?, ?> modelU;
    @FXML
    private TableColumn<?, ?> uslugaU;
    @FXML
    private TableColumn<?, ?> dataU;
    @FXML
    private TableColumn<?, ?> markaUE;
    @FXML
    private TableColumn<?, ?> modelUE;
    @FXML
    private TableColumn<?, ?> uslugaUE;
    @FXML
    private TableColumn<?, ?> dataUE;
    @FXML
    private TableView<Diagnozy> diagnozy;
    @FXML
    private TableView<Diagnozy> diagnozyE;
    @FXML
    private TableView<Przeglady> przeglady;
    @FXML
    private TableView<Przeglady> przegladyE;
    @FXML
    private TableView<Samochody_uslugi> uslugi;
    @FXML
    private TableView<Samochody_uslugi> uslugiE;
    @FXML
    private TextField wlascicielD;
    @FXML
    private TextField samochodD;
    @FXML
    private TextField uwagiKlientaD;
    @FXML
    private TextArea uwagiMechD;
    @FXML
    private TextField wlascicielP;
    @FXML
    private TextField samochodP;
    @FXML
    private DatePicker wybierzDateP;
    @FXML
    private TextArea uwagiMechP;
    @FXML
    private TextField wlascicielU;
    @FXML
    private TextField samochodU;
    @FXML
    private TextField usluga;
    @FXML
    private RadioButton pozytywny;
    @FXML
    private RadioButton negatywny;
    @FXML
    private TextField szukajDiagnozy;
    @FXML
    private TextField szukajPrzegladu;
    @FXML
    private TextField szukajUslugi;
    private int idMechanika;
    private static int idDiagnozy;
    private static int idUslugi = -1;
    private static int idPrzegladu = -1;
    private String wynikP;
    private static int licznik = 0;

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
    private void actionRadioPozytywny(ActionEvent event) throws ParseException, IOException {
        if (pozytywny.isSelected()) {
            wynikP = "pozytywny";
        }
    }

    @FXML
    private void actionRadioNegatywny(ActionEvent event) throws ParseException, IOException {
        if (negatywny.isSelected()) {
            wynikP = "negatywny";
        }
    }

    @FXML
    private void actionPrzejdzDiagnoza(ActionEvent event) throws ParseException, IOException {

        if (diagnozyE.getSelectionModel().getSelectedIndex() != -1) {
            idDiagnozy = diagnozyE.getSelectionModel().getSelectedItem().getId();
            Node newLoadedPane = FXMLLoader.load(getClass().getResource("/top/Diagnozy.fxml"));
            edytujDane.getChildren().clear();
            edytujDane.getChildren().add(newLoadedPane);
            edycjaDanych.setText("Edytuj diagnoze");
            licznik++;
        }
    }

    @FXML
    private void actionPrzejdzPrzeglad(ActionEvent event) throws ParseException, IOException {
        if (przegladyE.getSelectionModel().getSelectedIndex() != -1) {
            idPrzegladu = przegladyE.getSelectionModel().getSelectedItem().getId();
            Node newLoadedPane = FXMLLoader.load(getClass().getResource("/top/Przeglady.fxml"));
            edytujDane.getChildren().clear();
            edytujDane.getChildren().add(newLoadedPane);
            edycjaDanych.setText("Edytuj przegląd");
            licznik++;
        }
    }

    @FXML
    private void actionObsluzDiagnoze(ActionEvent event) throws ParseException, IOException {

        if (diagnozy.getSelectionModel().getSelectedIndex() != -1) {
            try {

                Connection con = getConnection();
                PreparedStatement pstmt = null;
                pstmt = con.prepareStatement("select d.*, s.marka, s.model\n"
                        + "from diagnozy d, samochody s\n"
                        + "where d.id_samochodu = s.id\n"
                        + "and d.id = ?");
                pstmt.setInt(1, diagnozy.getSelectionModel().getSelectedItem().getId());
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {

                    samochodD.setText(rs.getString("marka") + " " + rs.getString("model"));
                    uwagiKlientaD.setText(rs.getString("uwagi_klienta"));
                    idDiagnozy = diagnozy.getSelectionModel().getSelectedItem().getId();
                }

                pstmt = null;
                pstmt = con.prepareStatement("select s.*, k.imie, k.nazwisko\n"
                        + "from samochody s, klienci k\n"
                        + "where s.id_klienta = k.id\n"
                        + "and s.id = ?");
                pstmt.setInt(1, diagnozy.getSelectionModel().getSelectedItem().getId_samochodu());
                rs = pstmt.executeQuery();
                while (rs.next()) {

                    wlascicielD.setText(rs.getString("imie") + " " + rs.getString("nazwisko"));
                }
                con.close();

            } catch (SQLException ed) {
                ed.printStackTrace();
            }
        }
    }

    @FXML
    private void actionObsluzPrzeglad(ActionEvent event) throws ParseException, IOException {

        if (przeglady.getSelectionModel().getSelectedIndex() != -1) {
            try {

                Connection con = getConnection();
                PreparedStatement pstmt = null;
                pstmt = con.prepareStatement("select p.*, s.marka, s.model\n"
                        + "from przeglady p, samochody s\n"
                        + "where p.id_samochodu = s.id\n"
                        + "and p.id = ?");
                pstmt.setInt(1, przeglady.getSelectionModel().getSelectedItem().getId());
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {

                    samochodP.setText(rs.getString("marka") + " " + rs.getString("model"));
                    idPrzegladu = przeglady.getSelectionModel().getSelectedItem().getId();
                }

                pstmt = null;
                pstmt = con.prepareStatement("select s.*, k.imie, k.nazwisko\n"
                        + "from samochody s, klienci k\n"
                        + "where s.id_klienta = k.id\n"
                        + "and s.id = ?");
                pstmt.setInt(1, przeglady.getSelectionModel().getSelectedItem().getId_samochodu());
                rs = pstmt.executeQuery();
                while (rs.next()) {

                    wlascicielP.setText(rs.getString("imie") + " " + rs.getString("nazwisko"));
                }
                con.close();

            } catch (SQLException ed) {
                ed.printStackTrace();
            }
        }
    }

    @FXML
    private void actionObsluzUsluge(ActionEvent event) throws ParseException, IOException {

        if (uslugi.getSelectionModel().getSelectedIndex() != -1) {
            try {

                Connection con = getConnection();
                PreparedStatement pstmt = null;
                pstmt = con.prepareStatement("select su.*, s.marka, s.model\n"
                        + "from samochody_uslugi su, samochody s\n"
                        + "where su.id_samochodu = s.id\n"
                        + "and s.id = ?");
                pstmt.setInt(1, uslugi.getSelectionModel().getSelectedItem().getId());
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    samochodU.setText(rs.getString("marka") + " " + rs.getString("model"));
                    idUslugi = uslugi.getSelectionModel().getSelectedItem().getId();
                }

                pstmt = null;
                pstmt = con.prepareStatement("select s.*, k.imie, k.nazwisko\n"
                        + "from samochody s, klienci k\n"
                        + "where s.id_klienta = k.id\n"
                        + "and s.id = ?");
                pstmt.setInt(1, uslugi.getSelectionModel().getSelectedItem().getId_samochodu());
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    wlascicielU.setText(rs.getString("imie") + " " + rs.getString("nazwisko"));
                }
                pstmt = null;
                pstmt = con.prepareStatement("select u.nazwa\n"
                        + "from uslugi u\n"
                        + "where u.id = ?");
                pstmt.setInt(1, uslugi.getSelectionModel().getSelectedItem().getId_uslugi());
                rs = pstmt.executeQuery();
                while (rs.next()) {

                    usluga.setText(rs.getString("nazwa"));
                }
                con.close();

            } catch (SQLException ed) {
                ed.printStackTrace();
            }
        }
    }

    @FXML
    private void actionZapiszDiagnoze(ActionEvent event) throws ParseException, IOException {
        if (!uwagiMechD.getText().isEmpty() && idDiagnozy != -1) {
            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("call obsluz_dane.obsluz_diagnoze(?,?,?)");
                cstmt.setInt(1, idDiagnozy);
                cstmt.setString(2, uwagiMechD.getText());
                cstmt.setInt(3, idMechanika);
                cstmt.executeQuery();
                for (int i = 0; i < diagnozy.getItems().size(); i++) {
                    if (diagnozy.getItems().get(i).getId() == idDiagnozy) {
                        diagnozy.getItems().remove(i);
                    }
                }

                idDiagnozy = -1;
                wlascicielD.clear();
                samochodD.clear();
                uwagiKlientaD.clear();
                uwagiMechD.clear();
                diagnozyE.getItems().clear();
                uzupelnijDiagnozeE();

                alertInformacja("Zapisz diagnoze", "Operacja powiodła się");

            } catch (SQLException ex) {
                alertBlad("Zapisz diagnoze", "Wprowadzono błędne dane");
            }

        }
    }

    @FXML
    private void actionZapiszPrzeglad(ActionEvent event) throws ParseException, IOException {
        if (idPrzegladu != -1) {
            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("call obsluz_dane.obsluz_przeglad(?,?,?,?,?)");
                cstmt.setInt(1, idPrzegladu);
                cstmt.setString(2, wybierzDateP.getValue().toString());
                cstmt.setInt(3, idMechanika);
                cstmt.setString(4, wynikP);
                cstmt.setString(5, uwagiMechP.getText());
                cstmt.executeQuery();
                for (int i = 0; i < przeglady.getItems().size(); i++) {
                    if (przeglady.getItems().get(i).getId() == idPrzegladu) {
                        przeglady.getItems().remove(i);
                    }
                }

                idPrzegladu = -1;
                wlascicielP.clear();
                samochodP.clear();
                uwagiMechP.clear();
                wybierzDateP.setValue(null);
                pozytywny.setSelected(false);
                negatywny.setSelected(false);

                alertInformacja("Zapisz diagnoze", "Operacja powiodła się");

            } catch (SQLException ex) {
                alertBlad("Zapisz diagnoze", "Wprowadzono błędne dane");
            }
        }
    }

    @FXML
    private void actionZapiszUsluge(ActionEvent event) throws ParseException, IOException {
        if (idUslugi != -1) {
            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("call obsluz_dane.obsluz_usluge(?,?)");
                cstmt.setInt(1, idUslugi);
                cstmt.setInt(2, idMechanika);
                cstmt.executeQuery();
                for (int i = 0; i < uslugi.getItems().size(); i++) {
                    if (uslugi.getItems().get(i).getId() == idUslugi) {
                        uslugi.getItems().remove(i);
                    }
                }

                idUslugi = -1;
                wlascicielU.clear();
                samochodU.clear();
                usluga.clear();

                alertInformacja("Zapisz diagnoze", "Operacja powiodła się");

            } catch (SQLException ex) {
                alertBlad("Zapisz diagnoze", "Wprowadzono błędne dane");
            }
        }
    }

    @FXML
    private void actionSzukajDiagnozy(ActionEvent event) throws ParseException, IOException {

        if (!szukajDiagnozy.getText().isEmpty()) {
            CallableStatement stmt = null;

            try {
                Connection con = getConnection();
                stmt = con.prepareCall("{call szukaj_danych.szukaj_diagnozy(?,?,?)}");
                stmt.setString(1, szukajDiagnozy.getText());
                stmt.setInt(2, idMechanika);
                stmt.registerOutParameter(3, OracleTypes.CURSOR);

                stmt.execute();
                ResultSet rs = (ResultSet) stmt.getObject(3);
                diagnozyE.getItems().clear();
                while (rs.next()) {

                    Diagnozy nowa = new Diagnozy(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8));
                    diagnozyE.getItems().add(nowa);
                }
            } catch (SQLException ex) {

            }
        }
    }

    @FXML
    private void actionSzukajPrzegladu(ActionEvent event) throws ParseException, IOException {

        if (!szukajPrzegladu.getText().isEmpty()) {
            CallableStatement stmt = null;

            try {
                Connection con = getConnection();
                stmt = con.prepareCall("{call szukaj_danych.szukaj_przegladu(?,?,?)}");
                stmt.setString(1, szukajPrzegladu.getText());
                stmt.setInt(2, idMechanika);
                stmt.registerOutParameter(3, OracleTypes.CURSOR);

                stmt.execute();
                ResultSet rs = (ResultSet) stmt.getObject(3);
                przegladyE.getItems().clear();
                while (rs.next()) {
                    Przeglady nowa = new Przeglady(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                    przegladyE.getItems().add(nowa);
                }
            } catch (SQLException ex) {

            }
        }
    }

    @FXML
    private void actionSzukajUslugi(ActionEvent event) throws ParseException, IOException {

        if (!szukajUslugi.getText().isEmpty()) {
            CallableStatement stmt = null;

            try {
                Connection con = getConnection();
                stmt = con.prepareCall("{call szukaj_danych.szukaj_uslugi(?,?,?)}");
                stmt.setString(1, szukajUslugi.getText());
                stmt.setInt(2, idMechanika);
                stmt.registerOutParameter(3, OracleTypes.CURSOR);

                stmt.execute();
                ResultSet rs = (ResultSet) stmt.getObject(3);
                uslugiE.getItems().clear();
                while (rs.next()) {
                    Samochody_uslugi nowa = new Samochody_uslugi(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8));
                    uslugiE.getItems().add(nowa);
                }
            } catch (SQLException ex) {

            }
        }
    }

    @FXML
    private void actionZresetujDiagnozyE(ActionEvent event) throws ParseException, IOException {
        uzupelnijDiagnozeE();
    }

    @FXML
    private void actionZresetujPrzegladyE(ActionEvent event) throws ParseException, IOException {
        uzupelnijPrzegladE();
    }

    @FXML
    private void actionZresetujUslugiE(ActionEvent event) throws ParseException, IOException {
        uzupelnijUslugeE();
    }

    private void uzupelnijDiagnozeE() {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("select d.*, s.marka, s.model\n"
                    + "from diagnozy d, samochody s\n"
                    + "where d.id_samochodu = s.id\n"
                    + "and d.id_mechanika = ?");
            pstmt.setInt(1, idMechanika);
            ResultSet rs = pstmt.executeQuery();
            ObservableList<Diagnozy> diagnoza = FXCollections.observableArrayList();
            while (rs.next()) {
                Diagnozy nowa = new Diagnozy(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8));
                diagnoza.add(nowa);
            }
            diagnozyE.getItems().clear();
            diagnozyE.setItems(diagnoza);
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    private void uzupelnijPrzegladE() {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("select p.*, s.marka, s.model\n"
                    + "from przeglady p, samochody s\n"
                    + "where p.id_samochodu = s.id\n"
                    + "and p.id_mechanika = ?");
            pstmt.setInt(1, idMechanika);
            ResultSet rs = pstmt.executeQuery();
            ObservableList<Przeglady> przeglad = FXCollections.observableArrayList();
            while (rs.next()) {
                Przeglady nowa = new Przeglady(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                przeglad.add(nowa);
            }
            przegladyE.setItems(przeglad);
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    private void uzupelnijUslugeE() {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("select su.*, s.marka, s.model, u.nazwa\n"
                    + "from samochody_uslugi su, samochody s, uslugi u\n"
                    + "where su.id_samochodu = s.id and su.id_uslugi = u.id\n"
                    + "and su.id_mechanika = ?");
            pstmt.setInt(1, idMechanika);
            ResultSet rs = pstmt.executeQuery();
            ObservableList<Samochody_uslugi> usluga = FXCollections.observableArrayList();
            while (rs.next()) {
                Samochody_uslugi nowa = new Samochody_uslugi(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8));
                usluga.add(nowa);
            }
            uslugiE.setItems(usluga);
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        if (licznik > 0) {
            selectionModel.select(3);
        }
        idMechanika = Pracownicy_uzytkownicy.getId();
        ToggleGroup toggleGroup = new ToggleGroup();
        pozytywny.setToggleGroup(toggleGroup);
        negatywny.setToggleGroup(toggleGroup);

        uzupelnijDiagnozeE();
        uzupelnijPrzegladE();
        uzupelnijUslugeE();

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
                            licznik = 0;
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

        markaD.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelD.setCellValueFactory(new PropertyValueFactory<>("model"));
        uwagiD.setCellValueFactory(new PropertyValueFactory<>("uwagi_klienta"));
        dataD.setCellValueFactory(new PropertyValueFactory<>("data"));
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select d.*, s.marka, s.model\n"
                    + "from diagnozy d, samochody s\n"
                    + "where d.id_samochodu = s.id\n"
                    + "and d.id_mechanika is null");
            ObservableList<Diagnozy> diagnoza = FXCollections.observableArrayList();
            while (rs.next()) {
                Diagnozy nowa = new Diagnozy(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8));
                diagnoza.add(nowa);
            }
            diagnozy.setItems(diagnoza);
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }

        markaDE.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelDE.setCellValueFactory(new PropertyValueFactory<>("model"));
        uwagiMechDE.setCellValueFactory(new PropertyValueFactory<>("uwagi_mechanika"));
        dataDE.setCellValueFactory(new PropertyValueFactory<>("data"));

        markaP.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelP.setCellValueFactory(new PropertyValueFactory<>("model"));
        dataP.setCellValueFactory(new PropertyValueFactory<>("data"));
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select p.*, s.marka, s.model\n"
                    + "from przeglady p, samochody s\n"
                    + "where p.id_samochodu = s.id\n"
                    + "and p.id_mechanika is null");
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

        markaPE.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelPE.setCellValueFactory(new PropertyValueFactory<>("model"));
        dataPE.setCellValueFactory(new PropertyValueFactory<>("data"));
        dataWaznosciPE.setCellValueFactory(new PropertyValueFactory<>("data_waznosci"));
        wynikPE.setCellValueFactory(new PropertyValueFactory<>("wynik"));

        markaU.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelU.setCellValueFactory(new PropertyValueFactory<>("model"));
        uslugaU.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        dataU.setCellValueFactory(new PropertyValueFactory<>("data"));
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select su.*, s.marka, s.model, u.nazwa\n"
                    + "from samochody_uslugi su, samochody s, uslugi u\n"
                    + "where su.id_samochodu = s.id and su.id_uslugi = u.id\n"
                    + "and su.id_mechanika is NULL");
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

        markaUE.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelUE.setCellValueFactory(new PropertyValueFactory<>("model"));
        uslugaUE.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        dataUE.setCellValueFactory(new PropertyValueFactory<>("data"));

    }

    public static int getIdDiagnozy() {
        return idDiagnozy;
    }

    public static int getIdPrzegladu() {
        return idPrzegladu;
    }
}
