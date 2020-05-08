/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top;

/**
 *
 * @author h
 */

    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Polaczenie 
{

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "c##warsztat", "admin");

        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}



