/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontrol;

import Entitas.Tamu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TamuKontrol extends Kontrol{
    private List<Tamu> daftarTamu;   

    public TamuKontrol() {
        this.daftarTamu = new ArrayList<>();
    }
    
    public List<Tamu> listTamu(){
        return daftarTamu;
    }
    
    public void updateListTamu(int idx, String namaTamu, String nomorKartuKredit, String alamat, String negara, String gender, String kontak){
        Tamu tamu = new Tamu(namaTamu, nomorKartuKredit, alamat, negara, gender, kontak);
        
        if(idx == -1){
            this.daftarTamu.add(tamu);
        }else{
            this.daftarTamu.set(idx, tamu);
        }
    }

    @Override
    public int sizeData(){
        return daftarTamu.size();
    }
    
    @Override
    public Object[] oneRow(int idx){
        Object[] row = {(idx+1),
                    daftarTamu.get(idx).getNamaTamu(),
                    daftarTamu.get(idx).getNomorKartuKredit(),
                    daftarTamu.get(idx).getAlamat(),
                    daftarTamu.get(idx).getNegara(),
                    daftarTamu.get(idx).getGender(),
                    daftarTamu.get(idx).getKontak()};
                            
        return row;
    }
    
    //START Kebutuhan Pemesanan
    public Tamu getTamu(int locTamu){
        if(locTamu != -1){
            return daftarTamu.get(locTamu);
        }else{
            return null;
        }
    }
    
    public int getLoc(Tamu tamu){
        int idx = -1;
        for (int i = 0; i < daftarTamu.size(); i++) {
            if(daftarTamu.get(i).equals(tamu)){
                idx = i;
            }
        }
        return idx;
    }
    
    public int cariTamu(String namaKontakTamu){
        int idx = -1;
        for (int i = 0; i < daftarTamu.size(); i++) {
            if(daftarTamu.get(i).getNamaTamu().equals(namaKontakTamu)){
                idx = i;
            }
            if(daftarTamu.get(i).getKontak().equals(namaKontakTamu)){
                idx = i;
            }
        }
        return idx;
    }
    //END Kebutuhan Pemesanan
    public void setTxt() throws FileNotFoundException, UnsupportedEncodingException{
        PrintWriter data = new PrintWriter("..\\Pemesanan_Kamar_Hotel\\src\\Database\\DataTamu.txt", "UTF-8");
        for (int i = 0; i < daftarTamu.size(); i++) {
                data.println(daftarTamu.get(i).getNamaTamu() + "," + 
                            daftarTamu.get(i).getNomorKartuKredit() + "," + 
                            daftarTamu.get(i).getAlamat() + "," +    
                            daftarTamu.get(i).getNegara() + "," + 
                            daftarTamu.get(i).getGender() + "," + 
                            daftarTamu.get(i).getKontak());
        }
        data.close();
    }
    
    public void getTxt() throws IOException{
        Path path = Paths.get("..\\Pemesanan_Kamar_Hotel\\src\\Database\\DataTamu.txt");
        //read all lines
        List<String> lines = Files.readAllLines(path);
        for(int count = 0; count<lines.size();count++) {
        	String[] description = new String[6];
        	description = lines.get(count).split(",");
        	Tamu tamu = new Tamu(description[0], 
                                description[1], 
                                description[2], 
                                description[3], 
                                description[4], 
                                description[5]);
            this.daftarTamu.add(tamu);
        }
    }
}
