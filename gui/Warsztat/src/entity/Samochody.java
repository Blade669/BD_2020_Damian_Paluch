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
public class Samochody {

    private int id;
    private String marka;
    private String model;
    private int poj_silnika;
    private int rok;
    private int id_klienta;
    private String imie;
    private String nazwisko;

    public Samochody(int id, String marka, String model, int poj_silnika, int rok, int id_klienta, String imie, String nazwisko) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.poj_silnika = poj_silnika;
        this.rok = rok;
        this.id_klienta = id_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPoj_silnika() {
        return poj_silnika;
    }

    public void setPoj_silnika(int poj_silnika) {
        this.poj_silnika = poj_silnika;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
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

}
