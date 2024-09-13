/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minggu3;

/**
 * @author ahmad
 */
public class Anggota {
    private String nama;
    private String alamat;
    private float simpanan;
    private float limit;

    public Anggota(String nama, String alamat, float simpanan) {
        this.nama = nama;
        this.alamat = alamat;
        this.simpanan = simpanan;
        this.limit = 5000000;
    }
    
//    public void setNama(String nama){
//        if(this.nama != null){
//            this.nama = nama;
//        } else {
//            System.out.println("Nama sudah terisi");
//        }
//    }
//    
//    public void setAlamat(String nama){
//        if(this.alamat != null){
//            this.alamat = nama;
//        } else {
//            System.out.println("Alamat sudah terisi");
//        }
//    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public String getAlamat(){
        return this.alamat;
    }
    
    public float getSimpanan(){
        return this.simpanan;
    }
    
    public void setorUang(float uang){
        simpanan += uang;
    }
    
    public void pinjam(float uang){
        simpanan -= uang;
    }
    
    public void info(){
        System.out.println("Nama\t:\t" + getNama());
        System.out.println("Alamat\t:\t" + getAlamat());
        System.out.println("Simpanan\t:\t" + getSimpanan());
    }
    
}
