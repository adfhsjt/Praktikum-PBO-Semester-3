/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minggu5;

/**
 *
 * @author ahmad
 */
public class Minggu5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Sopir sopir1 = new Sopir("Bambang", 25000);
        Mobil mobil1 = new Mobil("Panther", 30000);
        Pelanggan pelanggan1 = new Pelanggan("Aziz", mobil1, sopir1, 2);
        pelanggan1.info();
//        System.out.println("Biaya Keseluruhan\t:\t" + pelanggan1.hitungBiayaTotal());
//        System.out.println("Nama Sopir\t\t:\t" + pelanggan1.getSopir().getNama());
//        System.out.println("Merk Mobil\t\t:\t" + pelanggan1.getMobil().getNama());
//        
        //Processor proc1 = new Processor("Intel", 128);
//        Laptop laptop1 = new Laptop("Lenovo", new Processor("Intel", 128));
//        
//        laptop1.info();
//        
//        Processor proc2 = new Processor();
//        proc2.setMerk("Intel 15");
//        proc2.setCache(4);
//        
//        Laptop laptop2 = new Laptop();
//        laptop2.setMerk("Thinkpad");
//        laptop2.setProc(proc2);
//        laptop2.info();
//        
//        Laptop laptop3 = new Laptop();
//        laptop3.info();
        
        
        
        
    }
    
}
