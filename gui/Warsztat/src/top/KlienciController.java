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

    @FXML
    private void actionIdSamochoduU(ActionEvent event) throws ParseException, IOException {
        try {
            Connection con = getConnection();
            String tekst = wybierzSamochodU.getSelectionModel().getSelectedItem().toString();
            int iend = tekst.indexOf(" ");
            String marka = tekst.substring(0, iend);
            String model = tekst.substring(iend + 1);
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
            int iend = tekst.indexOf(" ");
            String marka = tekst.substring(0, iend);
            String model = tekst.substring(iend + 1);
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
            int iend = tekst.indexOf(" ");
            String marka = tekst.substring(0, iend);
            String model = tekst.substring(iend + 1);
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
    private void actionEdytujSamochod(ActionEvent event) throws ParseException, IOException {
        if (!markaE.getText().isEmpty() && !modelE.getText().isEmpty() && !pojSilnikaE.getText().isEmpty() && !rokE.getText().isEmpty()) {
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
                Alert good = new Alert(Alert.AlertType.INFORMATION);
                good.setTitle("Zmiana danych");
                good.setHeaderText("Operacja powiodła się");
                good.showAndWait();

            } catch (SQLException ex) {
                Alert bad = new Alert(Alert.AlertType.INFORMATION);
                bad.setTitle("Zmiana danych");
                bad.setHeaderText("Operacja nie powiodła się");
                bad.showAndWait();
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
            Alert good = new Alert(Alert.AlertType.INFORMATION);
            good.setTitle("Usuwanie samochodu");
            good.setHeaderText("Operacja powiodła się");
            good.showAndWait();

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
            Alert bad = new Alert(Alert.AlertType.INFORMATION);
            bad.setTitle("Usuwanie samochodu");
            bad.setHeaderText("Operacja nie powiodła się");
            bad.showAndWait();
        }

    }

    @FXML
    private void actionDodajSamochod(ActionEvent event) throws ParseException, IOException {
        if (!markaDod.getText().isEmpty() && !modelDod.getText().isEmpty() && !pojSilnikaDod.getText().isEmpty() && !rokDod.getText().isEmpty()) {
            if (pojSilnikaDod.getText().matches("^[0-9]+$") && rokDod.getText().matches("^[0-9]+$")) {
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
                    Alert good = new Alert(Alert.AlertType.INFORMATION);
                    good.setTitle("Dodawanie samochodu");
                    good.setHeaderText("Operacja powiodła się");
                    good.showAndWait();

                } catch (SQLException ex) {

                    Alert bad = new Alert(Alert.AlertType.INFORMATION);
                    bad.setTitle("Dodawanie samochodu");
                    bad.setHeaderText("Operacja nie powiodła się");
                    bad.showAndWait();
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
                        wybierzSamochodP.getItems().add(rs.getString("marka") + " " + rs.getString("model"));
                        wybierzSamochodP.setValue("Wybierz samochód");
                        wybierzSamochodU.getItems().add(rs.getString("marka") + " " + rs.getString("model"));
                        wybierzSamochodU.setValue("Wybierz samochód");
                        wybierzSamochodD.getItems().add(rs.getString("marka") + " " + rs.getString("model"));
                        wybierzSamochodD.setValue("Wybierz samochód");

                    }
                } catch (SQLException ed) {
                    ed.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void actionEdytujDane(ActionEvent event) throws ParseException, IOException {
        if (!imieE.getText().isEmpty() && !nazwiskoE.getText().isEmpty() && !nrTelE.getText().isEmpty()) {
            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("call edytuj_dane.edytuj_dane_klienta(?,?,?,?)");
                cstmt.setInt(1, idKlienta);
                cstmt.setString(2, imieE.getText());
                cstmt.setString(3, nazwiskoE.getText());
                cstmt.setString(4, nrTelE.getText());
                cstmt.executeQuery();

                Alert good = new Alert(Alert.AlertType.INFORMATION);
                good.setTitle("Zmiana danych");
                good.setHeaderText("Operacja powiodła się");
                good.showAndWait();

            } catch (SQLException ex) {
                Alert bad = new Alert(Alert.AlertType.INFORMATION);
                bad.setTitle("Zmiana danych");
                bad.setHeaderText("Wprowadzono błędne dane");
                bad.showAndWait();
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
    private void actionDodajUsluge(ActionEvent event) throws ParseException, IOException {
        if (!wybierzSamochodU.getSelectionModel().isEmpty() && !wybierzUsluge.getSelectionModel().isEmpty() && wybierzDateU.getValue() != null) {
            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("call dodaj_dane.dodaj_usluge(?,?,?)");
                cstmt.setInt(1, idUslugi);
                cstmt.setInt(2, idSamochoduU);
                cstmt.setString(3, wybierzDateU.getValue().toString());
                cstmt.executeQuery();

                Alert good = new Alert(Alert.AlertType.INFORMATION);
                good.setTitle("Dodaj usługę");
                good.setHeaderText("Operacja powiodła się");
                good.showAndWait();

            } catch (SQLException ex) {
                Alert bad = new Alert(Alert.AlertType.INFORMATION);
                bad.setTitle("Dodaj usługę");
                bad.setHeaderText("Wprowadzono błędne dane");
                bad.showAndWait();
            }

            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("select su.*, s.marka, s.model, u.nazwa\n"
                        + "from samochody s, samochody_uslugi su, uslugi u\n"
                        + "where s.id_klienta = ? and s.id = su.id_samochodu and u.id = su.id_uslugi and rownum = 1\n"
                        + "order by su.id desc");
                cstmt.setInt(1, idKlienta);

                ResultSet rs = cstmt.executeQuery();
                while (rs.next()) {
                    Samochody_uslugi nowa = new Samochody_uslugi(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8));
                    uslugi.getItems().add(nowa);
                }

                con.close();

            } catch (SQLException ed) {
                ed.printStackTrace();
            }
        }
    }

    @FXML
    private void actionDodajPrzeglad(ActionEvent event) throws ParseException, IOException {
        if (!wybierzSamochodP.getSelectionModel().isEmpty() && wybierzDateP.getValue() != null) {
            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("call dodaj_dane.dodaj_przeglad(?,?)");
                cstmt.setInt(1, idSamochoduP);
                cstmt.setString(2, wybierzDateP.getValue().toString());
                cstmt.executeQuery();

                Alert good = new Alert(Alert.AlertType.INFORMATION);
                good.setTitle("Dodaj przegląd");
                good.setHeaderText("Operacja powiodła się");
                good.showAndWait();

            } catch (SQLException ex) {
                Alert bad = new Alert(Alert.AlertType.INFORMATION);
                bad.setTitle("Dodaj przegląd");
                bad.setHeaderText("Wprowadzono błędne dane");
                bad.showAndWait();
            }

            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("select p.*, s.marka, s.model\n"
                        + "from samochody s, przeglady p\n"
                        + "where s.id = p.id_samochodu and s.id_klienta = ? and rownum = 1\n"
                        + "order by p.id desc");
                cstmt.setInt(1, idKlienta);
                ResultSet rs = cstmt.executeQuery();

                while (rs.next()) {
                    Przeglady nowa = new Przeglady(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                    przeglady.getItems().add(nowa);
                }

                con.close();

            } catch (SQLException ed) {
                ed.printStackTrace();
            }
        }
    }

    @FXML
    private void actionDodajDiagnoze(ActionEvent event) throws ParseException, IOException {
        if (!wybierzSamochodD.getSelectionModel().isEmpty() && wybierzDateD.getValue() != null) {
            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("call dodaj_dane.dodaj_diagnoze(?,?,?)");
                cstmt.setInt(1, idSamochoduD);
                cstmt.setString(2, uwagiKlienta.getText());
                cstmt.setString(3, wybierzDateD.getValue().toString());
                cstmt.executeQuery();

                Alert good = new Alert(Alert.AlertType.INFORMATION);
                good.setTitle("Dodaj diagnoze");
                good.setHeaderText("Operacja powiodła się");
                good.showAndWait();

            } catch (SQLException ex) {
                Alert bad = new Alert(Alert.AlertType.INFORMATION);
                bad.setTitle("Dodaj diagnoze");
                bad.setHeaderText("Wprowadzono błędne dane");
                bad.showAndWait();
            }

            try {
                Connection con = getConnection();
                CallableStatement cstmt = con.prepareCall("select d.*, s.marka, s.model\n"
                        + "from diagnozy d, samochody s\n"
                        + "where s.id = d.id_samochodu\n"
                        + "and s.id_klienta = ? and rownum = 1\n"
                        + "order by d.id desc");
                cstmt.setInt(1, idKlienta);
                ResultSet rs = cstmt.executeQuery();
                while (rs.next()) {
                    Diagnozy nowa = new Diagnozy(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getString(8));
                    diagnozy.getItems().add(nowa);
                }

                con.close();

            } catch (SQLException ed) {
                ed.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        idKlienta = Klienci_uzytkownicy.getId();

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

        markaU.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelU.setCellValueFactory(new PropertyValueFactory<>("model"));
        uslugaU.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        dataU.setCellValueFactory(new PropertyValueFactory<>("data"));
        try {
            Connection con = getConnection();
            CallableStatement cstmt = con.prepareCall("select su.*, s.marka, s.model, u.nazwa\n"
                    + "                    from samochody s, samochody_uslugi su, uslugi u\n"
                    + "                    where s.id_klienta = ? and s.id = su.id_samochodu and u.id = su.id_uslugi\n"
                    + "                    order by su.data");
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

        markaP.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelP.setCellValueFactory(new PropertyValueFactory<>("model"));
        wynikP.setCellValueFactory(new PropertyValueFactory<>("wynik"));
        dataP.setCellValueFactory(new PropertyValueFactory<>("data"));
        waznoscP.setCellValueFactory(new PropertyValueFactory<>("data_waznosci"));
        uwagiP.setCellValueFactory(new PropertyValueFactory<>("uwagi"));
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

        markaD.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelD.setCellValueFactory(new PropertyValueFactory<>("model"));
        uwagiD.setCellValueFactory(new PropertyValueFactory<>("uwagi_klienta"));
        uwagiMechD.setCellValueFactory(new PropertyValueFactory<>("uwagi_mechanika"));
        dataD.setCellValueFactory(new PropertyValueFactory<>("data"));
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
            diagnozy.setItems(diagnoza);
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
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
                wybierzSamochodP.getItems().add(rs.getString("marka") + " " + rs.getString("model"));
                wybierzSamochodP.setValue("Wybierz samochód");
                wybierzSamochodU.getItems().add(rs.getString("marka") + " " + rs.getString("model"));
                wybierzSamochodU.setValue("Wybierz samochód");
                wybierzSamochodD.getItems().add(rs.getString("marka") + " " + rs.getString("model"));
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
