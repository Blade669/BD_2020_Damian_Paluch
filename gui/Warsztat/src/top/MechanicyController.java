/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import entity.Diagnozy;
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
    private TableView<Diagnozy> diagnozy;
    @FXML
    private TextField wlascicielD;
    @FXML
    private TextField samochodD;
    @FXML
    private TextField uwagiKlientaD;
    @FXML
    private TextArea uwagiMechD;

    @FXML
    private void actionObsluzD(ActionEvent event) throws ParseException, IOException {

        if (diagnozy.getSelectionModel().getSelectedIndex() != -1) {
            try {

                Connection con = getConnection();
                PreparedStatement pstmt = null;
                pstmt = con.prepareStatement("select d.id, d.id_samochodu, d.uwagi_klienta, d.uwagi_mechanika, d.id_mechanika, d.data, s.marka, s.model\n"
                        + "from diagnozy d, samochody s\n"
                        + "where d.id_samochodu = s.id\n"
                        + "and d.id = ?");
                pstmt.setInt(1, diagnozy.getSelectionModel().getSelectedItem().getId());
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {

                    samochodD.setText(rs.getString("marka") + " " + rs.getString("model"));
                    uwagiKlientaD.setText(rs.getString("uwagi_klienta"));
                }

                pstmt = null;
                pstmt = con.prepareStatement("select s.id, s.marka, s.model, s.poj_silnika, s.rok, s.id_klienta, k.imie, k.nazwisko\n"
                        + "from samochody s, klienci k\n"
                        + "where s.id_klienta = s.id\n"
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

        markaD.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelD.setCellValueFactory(new PropertyValueFactory<>("model"));
        uwagiD.setCellValueFactory(new PropertyValueFactory<>("uwagi_klienta"));
        dataD.setCellValueFactory(new PropertyValueFactory<>("data"));
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select d.id, d.id_samochodu, d.uwagi_klienta, d.uwagi_mechanika, d.id_mechanika, d.data, s.marka, s.model\n"
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
    }
}
