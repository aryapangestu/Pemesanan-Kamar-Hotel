/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontrol;

import Entitas.Kamar;
import Entitas.Pemesanan;
import Entitas.Tamu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 *
 * @author aryap
 */
public class PemesananKontrol {
    private List<Pemesanan> daftarPemesanan;

    public PemesananKontrol(){
        this.daftarPemesanan = new ArrayList<>(); 
    }
    
    public List<Pemesanan> listPemesanan(){
        return daftarPemesanan;
    }
    
    public void updateListPemesanan(int idx, Tamu tamu, boolean pembayaran, String checkIn, String checkOut, Kamar kamar, int harga) {
        UUID kodePemesanan = UUID.randomUUID();

    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	LocalDate waktuCheckIn = LocalDate.parse(checkIn, formatter);
		LocalDate waktuCheckOut = LocalDate.parse(checkOut, formatter);
        Pemesanan pemesanan = new Pemesanan(kodePemesanan, pembayaran, waktuCheckIn, waktuCheckOut, kamar, harga, tamu);
        
        if(idx == -1){
            this.daftarPemesanan.add(pemesanan);
        }else{
            this.daftarPemesanan.set(idx, pemesanan);
        }
        
    }
    
    public int sizeData(){
        return daftarPemesanan.size();
    }
    
    public Object[] oneRow(int idx){
        //pembayaran true = cash, false = kartu kredit
        String pembayaran;
        if(daftarPemesanan.get(idx).isPembayaran() == true){
            pembayaran = "Cash";
        }else{
            pembayaran = "Kredit";
        }
        
        //Ubah ke tulisan rupiah
        String uangString = NumberFormat.getCurrencyInstance(new Locale("id", "ID")).format(daftarPemesanan.get(idx).getHarga());
        
        Object[] row = {daftarPemesanan.get(idx).getKodePemesanan(),
                    daftarPemesanan.get(idx).getTamu().getNamaTamu(),
                    daftarPemesanan.get(idx).getKamar().getNomorKamar(),
                    daftarPemesanan.get(idx).getWaktuCheckIn(),
                    daftarPemesanan.get(idx).getWaktuCheckOut(),
                    pembayaran,
                    uangString};
                            
        return row;
    }
    
    public int HargaKamarKosong(String tipeKamar, String statusWifi, int Rating, String checkIn, String checkOut){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	LocalDate waktuCheckIn = LocalDate.parse(checkIn, formatter);
	LocalDate waktuCheckOut = LocalDate.parse(checkOut, formatter);
        
        // Hitung durasi hari
        Duration diff = Duration.between(waktuCheckIn.atStartOfDay(), waktuCheckOut.atStartOfDay());
        Long Days = diff.toDays();
        int hari = Days.intValue();
        
        // Harga kamar bawaan = Rp150.000
        int hargaKamar = 150000;

        // Harga single bed = +Rp50.000
        // Harga double bed = +Rp100.000
        if(tipeKamar.equals("Single bad")){
            hargaKamar += 50000;
        }else if(tipeKamar.equals("Double bad")){
            hargaKamar += 100000;
        }

        // harga wifi = +Rp50.000
        if(statusWifi.equals("Ada")){
            hargaKamar += 50000;
        }

        // Rating >90 = +40.000
        // Rating >80 = +20.000
        if(Rating > 90){
            hargaKamar += 40000;
        } else if (Rating > 80 ){
            hargaKamar += 20000;
        }

        // dikali berapa malam
        hargaKamar *= hari;
        
        return hargaKamar;

    }

    public void setTxt(TamuKontrol tamuKontrol, KamarKontrol kamarKontrol) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter data = new PrintWriter("..\\Pemesanan_Kamar_Hotel\\src\\Database\\DataPemesanan.txt", "UTF-8");
        for (int i = 0; i < daftarPemesanan.size(); i++) {
                data.println(daftarPemesanan.get(i).getKodePemesanan() + "," +
                            daftarPemesanan.get(i).isPembayaran() + "," +
                            daftarPemesanan.get(i).getWaktuCheckIn() + "," +
                            daftarPemesanan.get(i).getWaktuCheckOut() + "," +
                            kamarKontrol.getLocFromKamar(daftarPemesanan.get(i).getKamar()) + "," +
                            daftarPemesanan.get(i).getHarga() + "," +
                            tamuKontrol.getLocFromTamu(daftarPemesanan.get(i).getTamu()) + ",");
        }
            data.close();
    }
    
    public void getTxt(TamuKontrol tamuKontrol, KamarKontrol kamarKontrol) throws IOException{
        Path path = Paths.get("..\\Pemesanan_Kamar_Hotel\\src\\Database\\DataPemesanan.txt");
        //read all lines
        List<String> lines = Files.readAllLines(path);
        for(int count = 0; count<lines.size();count++) {
        	String[] description = new String[7];
        	description = lines.get(count).split(",");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Pemesanan pemesanan = new Pemesanan(UUID.fromString(description[0]), 
                                                Boolean.valueOf(description[1]), 
                                                LocalDate.parse(description[2], formatter), 
                                                LocalDate.parse(description[3], formatter), 
                                                kamarKontrol.getKamar(Integer.valueOf(description[4])),
                                                Integer.valueOf(description[5]), 
                                                tamuKontrol.getTamuFromLoc(Integer.valueOf(description[6])));
            this.daftarPemesanan.add(pemesanan);
        }
    }
}
