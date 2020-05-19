/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author h
 */
public class Warsztat extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        
        SceneMenager.setStage(primaryStage);
        SceneMenager.addScene("logowanie", "/top/Logowanie.fxml");
        SceneMenager.addScene("rejestracja", "/top/RejestracjaKlienta.fxml");
        SceneMenager.addScene("klienci", "/top/Klienci.fxml");
        SceneMenager.addScene("mechanicy", "/top/Mechanicy.fxml");
        SceneMenager.addScene("administratorzy", "/top/Administratorzy.fxml");
        SceneMenager.addScene("diagnozy", "/top/Diagnozy.fxml");
        
        SceneMenager.renderScene("logowanie");

    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
