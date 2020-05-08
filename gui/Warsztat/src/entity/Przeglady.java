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
public class Przeglady 
{
    private int id;
    private int id_samochodu;
    private Date data;
    private Date data_waznosci;
    private int id_mechanika;
    private int czy_pozytywny;
    private String uwagi;
    private String marka;
    private String model;

    public Przeglady(int id, int id_samochodu, Date data, Date data_waznosci, int id_mechanika, int czy_pozytywny, String uwagi, String marka, String model) {
        this.id = id;
        this.id_samochodu = id_samochodu;
        this.data = data;
        this.data_waznosci = data_waznosci;
        this.id_mechanika = id_mechanika;
        this.czy_pozytywny = czy_pozytywny;
        this.uwagi = uwagi;
        this.marka = marka;
        this.model = model;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData_waznosci() {
        return data_waznosci;
    }

    public void setData_waznosci(Date data_waznosci) {
        this.data_waznosci = data_waznosci;
    }

    public int getId_mechanika() {
        return id_mechanika;
    }

    public void setId_mechanika(int id_mechanika) {
        this.id_mechanika = id_mechanika;
    }

    public int getCzy_pozytywny() {
        return czy_pozytywny;
    }

    public void setCzy_pozytywny(int czy_pozytywny) {
        this.czy_pozytywny = czy_pozytywny;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
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

    
}