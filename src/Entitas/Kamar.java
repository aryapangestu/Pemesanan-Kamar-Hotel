/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitas;

public class Kamar {
    private boolean tipeKamar;
    private String nomorKamar; 
    private boolean statusWifi;
    private boolean statusKamar;
    private int rating;

    public Kamar(String nomorKamar, boolean tipeKamar, boolean statusWifi, boolean statusKamar, int rating) {
        //tipeKamar true = single, false = double
        //statusWifi true = ada, false = tidak ada
        //statusKamar true = ada orang, false = kosong
        this.tipeKamar = tipeKamar;
        this.nomorKamar = nomorKamar;
        this.statusWifi = statusWifi;
        this.statusKamar = statusKamar;
        this.rating = rating;
    }

    public boolean isTipeKamar() {
        return tipeKamar;
    }

    public void setTipeKamar(boolean tipeKamar) {
        this.tipeKamar = tipeKamar;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public void setNomorKamar(String nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public boolean isStatusWifi() {
        return statusWifi;
    }

    public void setStatusWifi(boolean statusWifi) {
        this.statusWifi = statusWifi;
    }

    public boolean isStatusKamar() {
        return statusKamar;
    }

    public void setStatusKamar(boolean statusKamar) {
        this.statusKamar = statusKamar;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
