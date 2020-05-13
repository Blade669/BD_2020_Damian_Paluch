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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TabPane tabPane;
    @FXML
    private TableColumn<?, ?> markaD;
    @FXML
    private TableColumn<?, ?> modelD;
    @FXML
    private TableColumn<?, ?> uwagiD;
    @FXML
    private TableColumn<?, ?> dataD;
    @FXML
    private TableColumn<?, ?> markaP;
    @FXML
    private TableColumn<?, ?> modelP;
    @FXML
    private TableColumn<?, ?> dataP;
    @FXML
    private TableColumn<?, ?> markaU;
    @FXML
    private TableColumn<?, ?> modelU;
    @FXML
    private TableColumn<?, ?> uslugaU;
    @FXML
    private TableView<Diagnozy> diagnozy;
    @FXML
    private TableView<Przeglady> przeglady;
    @FXML
    private TableView<Samochody_uslugi> uslugi;
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
    private int idMechanika;
    private int idDiagnozy = -1;
    private int idUslugi = -1;
    private int idPrzegladu = -1;
    private String wynikP;

    @FXML
    private void actionRadioPozytywny(ActionEvent event) throws ParseException, IOException {
        if(pozytywny.isSelected()) wynikP = "pozytywny";
    }
    
    @FXML
    private void actionRadioNegatywny(ActionEvent event) throws ParseException, IOException {
        if(negatywny.isSelected()) wynikP = "negatywny";
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

                Alert good = new Alert(Alert.AlertType.INFORMATION);
                good.setTitle("Zapisz diagnoze");
                good.setHeaderText("Operacja powiodła się");
                good.showAndWait();

            } catch (SQLException ex) {
                Alert bad = new Alert(Alert.AlertType.INFORMATION);
                bad.setTitle("Zapisz diagnoze");
                bad.setHeaderText("Wprowadzono błędne dane");
                bad.showAndWait();
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
                System.out.println(wynikP);
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

                Alert good = new Alert(Alert.AlertType.INFORMATION);
                good.setTitle("Zapisz diagnoze");
                good.setHeaderText("Operacja powiodła się");
                good.showAndWait();

            } catch (SQLException ex) {
                Alert bad = new Alert(Alert.AlertType.INFORMATION);
                bad.setTitle("Zapisz diagnoze");
                bad.setHeaderText("Wprowadzono błędne dane");
                bad.showAndWait();
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

                Alert good = new Alert(Alert.AlertType.INFORMATION);
                good.setTitle("Zapisz diagnoze");
                good.setHeaderText("Operacja powiodła się");
                good.showAndWait();

            } catch (SQLException ex) {
                Alert bad = new Alert(Alert.AlertType.INFORMATION);
                bad.setTitle("Zapisz diagnoze");
                bad.setHeaderText("Wprowadzono błędne dane");
                bad.showAndWait();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idMechanika = Pracownicy_uzytkownicy.getId();
        ToggleGroup toggleGroup = new ToggleGroup();
        pozytywny.setToggleGroup(toggleGroup);
        negatywny.setToggleGroup(toggleGroup);

        wyloguj.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (wyloguj.isSelected()) {
                    try {
                        Alert delete = new Alert(Alert.AlertType.CONFIRMATION);
                        delete.setTitle("Wylogowywanie");
                        delete.setHeaderText("Na pewno?");
                        Optional<ButtonType> cos = delete.showAndWait();
                        if (cos.get() == ButtonType.OK) {
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

        markaU.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelU.setCellValueFactory(new PropertyValueFactory<>("model"));
        uslugaU.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select su.*, s.marka, s.model, u.nazwa\n"
                    + "from samochody_uslugi su, samochody s, uslugi u\n"
                    + "where su.id_samochodu = s.id and su.id_uslugi = u.id\n"
                    + "and su.id_mechanika is null");
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
}
