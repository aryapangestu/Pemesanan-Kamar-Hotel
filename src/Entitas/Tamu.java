/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitas;

/**
 *
 * @author aryap
 */
public class Tamu {
    private String namaTamu;
    private String nomorKartuKredit;
    private String alamat;
    private String negara;
    private String gender;
    private String kontak;

    public Tamu(String namaTamu, String nomorKartuKredit, String alamat, String negara, String gender, String kontak) {
        this.nomorKartuKredit = nomorKartuKredit;
        this.namaTamu = namaTamu;
        this.alamat = alamat;
        this.negara = negara;
        this.gender = gender;
        this.kontak = kontak;
    }

    public String getNamaTamu() {
        return namaTamu;
    }

    public void setNamaTamu(String namaTamu) {
        this.namaTamu = namaTamu;
    }

    public String getNomorKartuKredit() {
        return nomorKartuKredit;
    }

    public void setNomorKartuKredit(String nomorKartuKredit) {
        this.nomorKartuKredit = nomorKartuKredit;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }
}
