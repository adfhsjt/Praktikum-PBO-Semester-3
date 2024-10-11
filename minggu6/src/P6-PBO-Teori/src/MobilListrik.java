/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class MobilListrik extends Mobil{
    int persentaseBattery;

    public MobilListrik(String brand, int tahun, int pintu, int persentaseBattery) {
        super(pintu, brand, tahun);
        this.persentaseBattery = persentaseBattery;
        System.out.println("Memuat data Mobil Listrik ...");
        System.out.println("------------------------------------------");
    
    }

    public void mobilListrikInfo(){
        super.carInfo();
        System.out.println("Persentase Battery\t:\t" + persentaseBattery + "%");
        System.out.println("------------------------------------------");
    }
     
    
    
}
