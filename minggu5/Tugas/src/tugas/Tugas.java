/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas;

/**
 *
 * @author ahmad
 */
public class Tugas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Motherboard motherboard1 = new Motherboard("ASUS ROG Strix Z490-E", "LGA 1200", "Intel Z490", 95.0);
        Motherboard motherboard2 = new Motherboard("MSI B450 TOMAHAWK MAX", "AM4", "AMD B450", 85.0);
        
        Processor processor1 = new Processor("Intel i7-11700K", "LGA 1200", 8, 16, 3.6);
        Processor processor2 = new Processor("AMD Ryzen 5 5600X", "AM4", 6, 12, 3.7);
        Processor processor3 = new Processor("Intel i5-10400", "LGA 1200", 6, 12, 2.9);

        GraphicCard graphicCard1 = new GraphicCard("NVIDIA GeForce RTX 3080", 1710, 10);
        GraphicCard graphicCard2 = new GraphicCard("AMD Radeon RX 6800 XT", 2015, 16);

        Memory memory1 = new Memory("Corsair Vengeance LPX", 16, 3200.0);
        Memory memory2 = new Memory("G.SKILL Ripjaws V", 32, 3600.0);

        Storage storage1 = new Storage("Samsung 970 EVO Plus", 1000, 3500.0); // 1TB SSD
        Storage storage2 = new Storage("Western Digital Blue", 2000, 5400.0); // 2TB HDD

        PowerSupply powerSupply1 = new PowerSupply("Corsair RM750x", 750, 80); // 750W, 80 Plus Gold
        PowerSupply powerSupply2 = new PowerSupply("EVGA 600 W1", 600, 70);   // 600W, 70 Plus
        
        Komputer komputer1 = new Komputer();
        komputer1.info();
        komputer1.spesifikasi();
        komputer1.setP(processor3);
        komputer1.setM(motherboard2);
        komputer1.setP(processor3);
        komputer1.setP(processor2);
        komputer1.nyalakan();
        komputer1.info();
        komputer1.setMr(memory2);
        komputer1.setS(storage2);
        komputer1.setPs(powerSupply2);
        komputer1.info();
        komputer1.mainMinecraft();
        komputer1.nyalakan();
        komputer1.info();
        komputer1.mainMinecraft();
        komputer1.mainGTA();
        komputer1.spesifikasi();
        komputer1.setG(graphicCard2);
        komputer1.matikan();
        komputer1.setG(graphicCard2);
        komputer1.info();
        komputer1.nyalakan();
        komputer1.info();
        komputer1.spesifikasi();
        
        

        
    }
    
}
