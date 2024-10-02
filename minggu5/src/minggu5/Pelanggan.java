/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minggu5;

/**
 *
 * @author ahmad
 */
public class Pelanggan {
    private String nama;
    private Mobil mobil;
    private Sopir sopir;
    private int hari;

    public Pelanggan() {
    }

    public Pelanggan(String nama, Mobil mobil, Sopir sopir, int hari) {
        this.nama = nama;
        this.mobil = mobil;
        this.sopir = sopir;
        this.hari = hari;
    }

    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setMobil(Mobil mobil){
        this.mobil = mobil;
    }
    
    public Mobil getMobil(){
        return mobil;
    }
    
    public void setSopir(Sopir sopir){
        this.sopir = sopir;
    }
    
    public Sopir getSopir(){
        return sopir;
    }
    
    public void setHari(int hari){
        this.hari = hari;
    }
    
    public int getHari(){
        return hari;
    }
    
    public int hitungBiayaTotal(){
        return getSopir().hitungBiayaSopir(hari) + getMobil().hitungBiayaMobil(hari);
    }
    
    public void info(){
        System.out.println("Nama Pelanggan\t\t:\t"+ nama);
        System.out.println("Nama Sopir\t\t:\t"+ sopir.getNama());
        System.out.println("Biaya Sopir\t\t:\t" + sopir.getBiaya());
        System.out.println("Merk Mobil\t\t:\t" + mobil.getNama());
        System.out.println("BIaya Mobil\t\t:\t" + mobil.getBiaya());
        System.out.println("Lama hari\t\t:\t" + hari);
        System.out.println("Biaya Keseluruhan\t:\t" + hitungBiayaTotal());
    }
    
}
