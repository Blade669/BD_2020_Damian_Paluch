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
public class Pracownicy 
{
    private int id;
    private String imie;
    private String nazwisko;
    private long nr_tel;
    private String adres;
    private int id_uzytkownika;

    public Pracownicy(int id, String imie, String nazwisko, long nr_tel, String adres, int id_uzytkownika) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_tel = nr_tel;
        this.adres = adres;
        this.id_uzytkownika = id_uzytkownika;
    }

    public int getId_uzytkownika() {
        return id_uzytkownika;
    }

    public void setId_uzytkownika(int id_uzytkownika) {
        this.id_uzytkownika = id_uzytkownika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public long getNr_tel() {
        return nr_tel;
    }

    public void setNr_tel(long nr_tel) {
        this.nr_tel = nr_tel;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    
}
