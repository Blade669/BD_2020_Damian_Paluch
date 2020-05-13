/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author h
 */
public class Pracownicy_uzytkownicy 
{
    private static int id;
    private String login;
    private String haslo;
    private int id_funkcji;

    public Pracownicy_uzytkownicy(int id, String login, String haslo, int id_funkcji) {
        this.id = id;
        this.login = login;
        this.haslo = haslo;
        this.id_funkcji = id_funkcji;
    }

    public int getId_funkcji() {
        return id_funkcji;
    }

    public void setId_funkcji(int id_funkcji) {
        this.id_funkcji = id_funkcji;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    
}
