/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */

public class Anggota {
    private String nomorKTP, nama;
    private double limitPeminjaman, jumlahPinjaman;

    public Anggota(String nomorKTP, String nama, double limitPeminjaman) {
        this.nomorKTP = nomorKTP;
        this.nama = nama;
        this.limitPeminjaman = limitPeminjaman;
        this.jumlahPinjaman = 0;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public String getNomorKTP(){
        return this.nomorKTP;
    }
    
    public double getLimitPinjaman(){
        return this.limitPeminjaman;
    }
    
    public double getJumlahPinjaman(){
        return this.jumlahPinjaman;
    }    
    
    public void pinjam(double jumlah){
        if(jumlah > limitPeminjaman){
            System.out.println("Maaf, jumlah pinjaman melebihi limit");
        } else {
            jumlahPinjaman += jumlah;
        }
    }
    
    public void angsur(double jumlah){
        if(jumlah > jumlahPinjaman){
            System.out.println("Maaf, jumlah uang kebanyakan");
        } else {
            if(jumlah < (jumlahPinjaman * 0.1)){
                System.out.println("Maaf, angsuran harus 10% dari jumlah pinjaman");
            } else{
                jumlahPinjaman -= jumlah;
            }
        }
    }
    
    
    
    
    
}
