/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author h
 */
public class Samochody_uslugi 
{
    private int id_samochodu;
    private int id_uslugi;
    private int id;
    private int id_mechanika;
    private Date data;
    private String marka;
    private String model;
    private String nazwa;

    public Samochody_uslugi(int id_samochodu, int id_uslugi, int id, int id_mechanika, Date data, String marka, String model, String nazwa) {
        this.id_samochodu = id_samochodu;
        this.id_uslugi = id_uslugi;
        this.id = id;
        this.id_mechanika = id_mechanika;
        this.data = data;
        this.model = model;
        this.marka = marka;
        this.nazwa = nazwa;
    }

    public int getId_samochodu() {
        return id_samochodu;
    }

    public void setId_samochodu(int id_samochodu) {
        this.id_samochodu = id_samochodu;
    }

    public int getId_uslugi() {
        return id_uslugi;
    }

    public void setId_uslugi(int id_uslugi) {
        this.id_uslugi = id_uslugi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_mechanika() {
        return id_mechanika;
    }

    public void setId_mechanika(int id_mechanika) {
        this.id_mechanika = id_mechanika;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
}   