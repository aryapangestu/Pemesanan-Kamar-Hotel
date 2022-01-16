/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Kontrol.KamarKontrol;
import Kontrol.PemesananKontrol;
import Kontrol.TamuKontrol;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DriverDatabase {
    private TamuKontrol tamuKontrol = new TamuKontrol();
    private KamarKontrol kamarKontrol = new KamarKontrol();
    private PemesananKontrol pemesananKontrol = new PemesananKontrol();

    public TamuKontrol getTamuKontrol() {
        return tamuKontrol;
    }
    public void setTamuKontrol(TamuKontrol tamuKontrol) {
        this.tamuKontrol = tamuKontrol;
    }
    public KamarKontrol getKamarKontrol() {
        return kamarKontrol;
    }
    public void setKamarKontrol(KamarKontrol kamarKontrol) {
        this.kamarKontrol = kamarKontrol;
    }
    public PemesananKontrol getPemesananKontrol() {
        return pemesananKontrol;
    }
    public void setPemesananKontrol(PemesananKontrol pemesananKontrol) {
        this.pemesananKontrol = pemesananKontrol;
    }

    public void simpanDatabase() throws FileNotFoundException, UnsupportedEncodingException{
        tamuKontrol.setTxt();
        kamarKontrol.setTxt();
        pemesananKontrol.setTxt(tamuKontrol, kamarKontrol);
    }

    public void memuatDatabase() throws IOException{
        tamuKontrol.getTxt();
        kamarKontrol.getTxt();
        pemesananKontrol.getTxt(tamuKontrol, kamarKontrol);
    }
}
