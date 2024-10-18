/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minggu8;

/**
 *
 * @author ahmad
 */
public class Minggu8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Objek Komputer
        Komputer komputer = new Komputer("Asus", 3200, 16, "Intel i7");
        komputer.tampilData();
        System.out.println("---------------------------------------------");
        // Objek Laptop
        Laptop laptop = new Laptop("Li-ion", "Dell", 2400, 8, "Intel i5");
        laptop.tampilLaptop();
        System.out.println("---------------------------------------------");
        // Objek Pc
        Pc pcDesktop = new Pc(24, "Lenovo", 3600, 32, "AMD Ryzen 5"); 
        pcDesktop.tampilPc();
        System.out.println("---------------------------------------------");
        //Objek Windows
        Windows windowsLaptop = new Windows("Touchscreen", "Li-ion", "Dell", 3200, 16, "Intel i7");
        windowsLaptop.tampilWindows();
        System.out.println("---------------------------------------------");
        // Objek Mac
        Mac macLaptop = new Mac("FileVault", "Li-ion", "Apple", 2800, 8, "M1");
        macLaptop.tampilMac();
        System.out.println("---------------------------------------------");
        
    }
    
}
