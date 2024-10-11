/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Hewan {
    private String nama;
    protected int umur;

    public void Hewan(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }
    
    public void berjalan(){
        System.out.println(nama + " berjalan ...");
    }
    
    public void suaraHewan(){
        System.out.println("Suara hewan ... ");
    }
    
    
    public void info(){
        System.out.println("Nama hewan\t:\t" + nama);  
        System.out.println("Umur hewan\t:\t" + umur);  
        
    }
}
