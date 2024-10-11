/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Mobil extends Kendaraan {
    int pintu;

    public Mobil(int pintu, String brand, int tahun) {
        super(brand, tahun);
        this.pintu = pintu;
        System.out.println("Memuat data mobil ...");
    }
    
    public void carInfo(){
        super.info();
        System.out.println("Jumlah pintu\t:\t" + pintu);
    }
    
    
}
