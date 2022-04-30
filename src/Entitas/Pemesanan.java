/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitas;

import java.time.LocalDate;
import java.util.UUID;

public class Pemesanan {
    private UUID kodePemesanan;
    private boolean pembayaran;
    private LocalDate waktuCheckIn;
    private LocalDate waktuCheckOut;
    private Kamar kamar;
    private int harga;
    private Tamu tamu;
    
    public Pemesanan(UUID kodePemesanan, boolean pembayaran, LocalDate waktuCheckIn, LocalDate waktuCheckOut, Kamar kamar, int harga, Tamu tamu) {
        //pembayaran true = cash, false = kartu kredit
        //status true = CONFIRMED, false = UNCONFIRMED 
        this.kodePemesanan = kodePemesanan;
        this.pembayaran = pembayaran;
        this.waktuCheckIn = waktuCheckIn;
        this.waktuCheckOut = waktuCheckOut;
        this.kamar = kamar;
        this.harga = harga;
        this.tamu = tamu;
    }

    public UUID getKodePemesanan() {
        return kodePemesanan;
    }

    public void setKodePemesanan(UUID kodePemesanan) {
        this.kodePemesanan = kodePemesanan;
    }

    public boolean isPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(boolean pembayaran) {
        this.pembayaran = pembayaran;
    }

    public LocalDate getWaktuCheckIn() {
        return waktuCheckIn;
    }

    public void setWaktuCheckIn(LocalDate waktuCheckIn) {
        this.waktuCheckIn = waktuCheckIn;
    }

    public LocalDate getWaktuCheckOut() {
        return waktuCheckOut;
    }

    public void setWaktuCheckOut(LocalDate waktuCheckOut) {
        this.waktuCheckOut = waktuCheckOut;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public void setKamar(Kamar kamar) {
        this.kamar = kamar;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Tamu getTamu() {
        return tamu;
    }

    public void setTamu(Tamu tamu) {
        this.tamu = tamu;
    }
}
