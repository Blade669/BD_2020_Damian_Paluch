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
public class Diagnozy {

    private int id;
    private int id_samochodu;
    private String uwagi_klienta;
    private String uwagi_mechanika;
    private int id_mechanika;
    private Date data;
    private String marka;
    private String model;

    public Diagnozy(int id, int id_samochodu, String uwagi_klienta, String uwagi_mechanika, int id_mechanika, Date data, String marka, String model) {
        this.id = id;
        this.id_samochodu = id_samochodu;
        this.uwagi_klienta = uwagi_klienta;
        this.uwagi_mechanika = uwagi_mechanika;
        this.id_mechanika = id_mechanika;
        this.data = data;
        this.marka = marka;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_samochodu() {
        return id_samochodu;
    }

    public void setId_samochodu(int id_samochodu) {
        this.id_samochodu = id_samochodu;
    }

    public String getUwagi_klienta() {
        return uwagi_klienta;
    }

    public void setUwagi_klienta(String uwagi_klienta) {
        this.uwagi_klienta = uwagi_klienta;
    }

    public String getUwagi_mechanika() {
        return uwagi_mechanika;
    }

    public void setUwagi_mechanika(String uwagi_mechanika) {
        this.uwagi_mechanika = uwagi_mechanika;
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

}
