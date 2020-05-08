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
public class Klienci_uzytkownicy 
{
    private int id;
    private String login;
    private String haslo;

    public Klienci_uzytkownicy(int id, String login, String haslo) {
        this.id = id;
        this.login = login;
        this.haslo = haslo;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public int getId() {
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
    
}
