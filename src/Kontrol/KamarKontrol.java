/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontrol;

import Entitas.Kamar;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class KamarKontrol extends Kontrol{
    private List<Kamar> daftarKamar;

    public KamarKontrol() {
        this.daftarKamar = new ArrayList<>();
    }
    
    public List<Kamar> listKamar(){
        return daftarKamar;
    }

    public void updateListKamar(int idx, String nomorKamar, boolean tipeKamar, boolean statusWifi, boolean statusKamar, int rating){
        Kamar kamar = new Kamar(nomorKamar, tipeKamar, statusWifi, statusKamar, rating);
        
        if(idx == -1){
            this.daftarKamar.add(kamar);
        }else{
            this.daftarKamar.set(idx, kamar);
        }
    }
    
    @Override
    public int sizeData(){
        return daftarKamar.size();
    }
    
    @Override
    public Object[] oneRow(int idx){
        //tipeKamar true = single, false = double
        //statusWifi true = ada, false = tidak ada
        //statusKamar true = ada orang, false = kosong
        String tipe_kamar;
        String status_wifi;
        String status_kamar;
        if(daftarKamar.get(idx).isTipeKamar() == true){
            tipe_kamar = "Single bed";
        }else{
            tipe_kamar = "Double bed";
        }
        if(daftarKamar.get(idx).isStatusWifi() == true){
            status_wifi = "Ada";
        }else{
            status_wifi = "Tidak ada";
        }
        if(daftarKamar.get(idx).isStatusKamar() == true){
            status_kamar = "Ditempati";
        }else{
            status_kamar = "Kosong";
        }
        Object[] row = {daftarKamar.get(idx).getNomorKamar(),
                    tipe_kamar,
                    status_wifi,
                    status_kamar,
                    daftarKamar.get(idx).getRating()};         
        return row;
    }
    
    //START Kebutuhan Pemesanan
    public void updateStatusKamar(int idx, boolean statusKamar){
        daftarKamar.get(idx).setStatusKamar(statusKamar);
    }
    
    // START polimorfisme statis overloading
    public Kamar getKamar(String nomorKamar){
        int idx = -1;
        for (int i = 0; i < daftarKamar.size(); i++) {
            if(daftarKamar.get(i).getNomorKamar().equals(nomorKamar)){
                idx = i;
            }
        }
        return daftarKamar.get(idx);
    }
    
    public Kamar getKamar(int locTamu){
        if(locTamu != -1){
            return daftarKamar.get(locTamu);
        }else{
            return null;
        }
    }
    // END polimorfisme statis overloading
    
    public int getLoc(Kamar kamar){
        int idx = -1;
        for (int i = 0; i < daftarKamar.size(); i++) {
            if(daftarKamar.get(i).equals(kamar)){
                idx = i;
            }
        }
        return idx;
    }
    //END Kebutuhan Pemesanan

    public void setTxt() throws FileNotFoundException, UnsupportedEncodingException{
        PrintWriter data = new PrintWriter("..\\Pemesanan_Kamar_Hotel\\src\\Database\\DataKamar.txt", "UTF-8");
        for (int i = 0; i < daftarKamar.size(); i++) {
                data.println(daftarKamar.get(i).getNomorKamar() + "," + 
                            daftarKamar.get(i).isTipeKamar() + "," + 
                            daftarKamar.get(i).isStatusWifi() + "," + 
                            daftarKamar.get(i).isStatusKamar() + "," +    
                            daftarKamar.get(i).getRating());
        }
        data.close();
    }
    
    public void getTxt() throws IOException{
        Path path = Paths.get("..\\Pemesanan_Kamar_Hotel\\src\\Database\\DataKamar.txt");
        //read all lines
        List<String> lines = Files.readAllLines(path);
        for(int count = 0; count<lines.size();count++) {
        	String[] description = new String[7];
        	description = lines.get(count).split(",");
            Kamar kamar = new Kamar(description[0], 
                                    Boolean.valueOf(description[1]),  
                                    Boolean.valueOf(description[2]), 
                                    Boolean.valueOf(description[3]), 
                                    Integer.valueOf(description[4]));
            this.daftarKamar.add(kamar);
        }
    }
}
