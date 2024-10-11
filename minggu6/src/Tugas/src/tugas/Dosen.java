/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;

/**
 *
 * @author ahmad
 */
public class Dosen extends Pegawai{
    public int jumlahSKS, TARIF_SKS;
    
    public Dosen(String nip, String nama, String alamat){
        super(nip, nama, alamat);
        this.TARIF_SKS = 100000;
        System.out.println(" Dosen " + super.nama);
        System.out.println("---------------------------------------------------");
    
    }
    
    public void setSKS(int sks){
        this.jumlahSKS = sks;
    }
    
    @Override
    public int getGaji(){
       return jumlahSKS * TARIF_SKS;
    }
}
