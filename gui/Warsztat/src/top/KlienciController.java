/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import entity.Diagnozy;
import entity.Przeglady;
import entity.Samochody_uslugi;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private void actionMarka(ActionEvent event) throws ParseException, IOException {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = null;
            pstmt = con.prepareStatement("SELECT model FROM samochody WHERE marka = ?");
            pstmt.setString(1, wybierzMarke.getSelectionModel().getSelectedItem().toString());

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
                pstmt = con.prepareStatement("SELECT * FROM samochody WHERE marka = ? and model = ?");
                pstmt.setString(1, wybierzMarke.getSelectionModel().getSelectedItem().toString());
                pstmt.setString(2, wybierzModel.getSelectionModel().getSelectedItem().toString());
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select su.id, su.id_uslugi, su.id_samochodu, su.id_mechanika, su.data, s.marka, s.model, u.nazwa \n"
                    + "from samochody s, samochody_uslugi su, uslugi u \n"
                    + "where s.id_klienta = 1 and s.id = su.id_samochodu and u.id = su.id_uslugi \n"
                    + "order by su.data");
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
        wynikP.setCellValueFactory(new PropertyValueFactory<>("czy_pozytywny"));
        dataP.setCellValueFactory(new PropertyValueFactory<>("data"));
        waznoscP.setCellValueFactory(new PropertyValueFactory<>("data_waznosci"));
        uwagiP.setCellValueFactory(new PropertyValueFactory<>("uwagi"));
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select p.id, p.id_samochodu, p.data, p.data_waznosci, p.id_mechanika, p.czy_pozytywny, p.uwagi, s.marka, s.model\n"
                    + "from samochody s, przeglady p\n"
                    + "where s.id = p.id_samochodu");
            ObservableList<Przeglady> przeglad = FXCollections.observableArrayList();
            while (rs.next()) {
                Przeglady nowa = new Przeglady(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9));
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
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select d.id, d.id_samochodu, d.uwagi_klienta, d.uwagi_mechanika, d.id_mechanika, d.data, s.marka, s.model\n"
                    + "from diagnozy d, samochody s\n"
                    + "where s.id = d.id_samochodu");
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

        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from samochody");
            while (rs.next()) {
                wybierzMarke.getItems().add(rs.getString("marka"));
                wybierzMarke.setValue("Wybierz marke");
            }
            con.close();

        } catch (SQLException ed) {
            ed.printStackTrace();
        }
    }

}
