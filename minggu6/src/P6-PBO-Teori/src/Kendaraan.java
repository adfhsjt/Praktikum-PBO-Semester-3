/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Kendaraan {
    String brand;
    int tahun;

    public Kendaraan(String brand, int tahun) {
        this.brand = brand;
        this.tahun = tahun;
        System.out.println("Memuat data kendaran ...");
    }
    
    public void info(){
        System.out.println("Brand " + brand + " tahun " + tahun);
    }
}
