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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import static top.Polaczenie.getConnection;

/**
 * FXML Controller class
 *
 * @author h
 */
public class PrzegladyController implements Initializable {

    @FXML
    private RadioButton pozytywny;
    @FXML
    private RadioButton negatywny;
    @FXML
    private TextField samochod;
    @FXML
    private TextField wlasciciel;
    @FXML
    private TextArea uwagi;
    @FXML
    private DatePicker data;
    private String wynik;

    @FXML
    private void actionRadioPozytywny(ActionEvent event) throws ParseException, IOException {
        if (pozytywny.isSelected()) {
            wynik = "pozytywny";
        }
    }

    @FXML
    private void actionRadioNegatywny(ActionEvent event) throws ParseException, IOException {
        if (negatywny.isSelected()) {
            wynik = "negatywny";
        }
    }
    
    @FXML
    private void actionPowrot(ActionEvent event) throws ParseException, IOException {
        SceneMenager.renderScene("mechanicy");
    }
    
    @FXML
    private void actionZapiszPrzeglad(ActionEvent event) throws ParseException, IOException {

        try {
            Connection con = getConnection();
            CallableStatement cstmt = con.prepareCall("call edytuj_dane.edytuj_przeglad(?,?,?,?)");
            cstmt.setInt(1, MechanicyController.getIdPrzegladu());
            cstmt.setString(2, data.getValue().toString());
            cstmt.setString(3, wynik);
            cstmt.setString(4, uwagi.getText());

            cstmt.executeQuery();

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ToggleGroup toggleGroup = new ToggleGroup();
        pozytywny.setToggleGroup(toggleGroup);
        negatywny.setToggleGroup(toggleGroup);

        try {
            int idSamochodu = -1;
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("select p.*, s.marka, s.model\n"
                    + "from przeglady p, samochody s\n"
                    + "where p.id_samochodu = s.id\n"
                    + "and p.id = ?");

            pstmt.setInt(1, MechanicyController.getIdPrzegladu());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                samochod.setText(rs.getString("marka") + "  " + rs.getString("model"));
                uwagi.setText(rs.getString("uwagi"));
                if (rs.getString("wynik") != null) {
                    if (rs.getString("wynik").equalsIgnoreCase("pozytywny")) {
                        pozytywny.setSelected(true);
                    } else if (rs.getString("wynik").equalsIgnoreCase("negatywny")) {
                        negatywny.setSelected(true);
                    }
                }
                data.setValue(rs.getDate("data_waznosci").toLocalDate());
                idSamochodu = rs.getInt("id_samochodu");
            }

            pstmt = con.prepareStatement("select k.imie, k.nazwisko from klienci k, samochody s\n"
                    + "where k.id = s.id_klienta\n"
                    + "and s.id = ?");
            pstmt.setInt(1, idSamochodu);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                wlasciciel.setText(rs.getString("imie") + " " + rs.getString("nazwisko"));
            }
            con.close();
        } catch (SQLException ed) {
            ed.printStackTrace();
        }

    }

}
