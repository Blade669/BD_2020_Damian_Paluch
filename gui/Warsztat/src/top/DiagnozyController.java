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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static top.Polaczenie.getConnection;

/**
 * FXML Controller class
 *
 * @author h
 */
public class DiagnozyController implements Initializable {

    @FXML
    private TextField wlasciciel;
    @FXML
    private TextField samochod;
    @FXML
    private TextArea uwagi;
    @FXML
    private TextArea uwagiMech;

    @FXML
    private void actionPowrot(ActionEvent event) throws ParseException, IOException {
        SceneMenager.renderScene("mechanicy");
    }

    @FXML
    private void actionZapiszDiagnoze(ActionEvent event) throws ParseException, IOException {

        try {
            Connection con = getConnection();
            CallableStatement cstmt = con.prepareCall("call edytuj_dane.edytuj_diagnoze(?,?)");
            cstmt.setInt(1, MechanicyController.getIdDiagnozy());
            cstmt.setString(2, uwagiMech.getText());

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

        try {
            int idSamochodu = -1;
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("select d.*, s.marka, s.model\n"
                    + "from diagnozy d, samochody s\n"
                    + "where d.id_samochodu = s.id\n"
                    + "and d.id = ?");

            pstmt.setInt(1, MechanicyController.getIdDiagnozy());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                samochod.setText(rs.getString("marka") + "  " + rs.getString("model"));
                uwagi.setText(rs.getString("uwagi_klienta"));
                uwagiMech.setText(rs.getString("uwagi_mechanika"));
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
