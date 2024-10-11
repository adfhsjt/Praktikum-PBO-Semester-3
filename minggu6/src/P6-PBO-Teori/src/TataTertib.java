/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class TataTertib {
    public String peraturan;
    public String sanksi;

    public TataTertib(String peraturan, String sanksi) {
        this.peraturan = peraturan;
        this.sanksi = sanksi;
    }

    public String getPeraturan() {
        return peraturan;
    }

    public String getSanksi() {
        return sanksi;
    }
    
    public void terapkanSanksi(AnggotaKampus anggota, String tanggal){
        Pelanggaran pelanggaran = new Pelanggaran(anggota, this, tanggal);
        System.out.println("Sanksi diterapkan pada " + pelanggaran.getPelanggar().nama);
    }
}
