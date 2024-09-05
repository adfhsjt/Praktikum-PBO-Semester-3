/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // KIPAS DINDING
        System.out.println("---Kipas Dinding---");
        kipasDinding kipas1 = new kipasDinding("Maspion f300");
        kipas1.info();
        kipas1.tambahLevel(2);
        kipas1.info();
        kipas1.kurangiKecepatan(1);
        kipas1.info();        
        
        // MAGICCOM
        System.out.println("---Magiccom---");
        magiccom magiccom1 = new magiccom("Cosmos j2 prime");
        magiccom1.info();
        magiccom1.modeCook();
        magiccom1.info();
        magiccom1.modeWarm();
        magiccom1.info();
        
        // MOTOR
        System.out.println("---Motor---");
        motor motor1 = new motor("Scoopy Fashion", 110);
        motor1.info();
        motor1.setKecepatan(45);
        motor1.tambahTekananAngin(34);
        motor1.info();
        
        // MOTOR MASUKKAN
        System.out.println("---Motor Masukan---");
        motorMasukan mm1 = new motorMasukan("Supra X 125", 125, 34);
        mm1.info();
        mm1.gunakanMotor(15);
        mm1.isiBensin(5);
        mm1.gunakanMotor(15);
        mm1.info();
        mm1.setKecepatan(60);
        mm1.info();
        
        // MOTOR LISTRIK
        System.out.println("---Motor Listrik---");
        motorListrik ml1 = new motorListrik("Viar NX", 100, 32);
        ml1.info();
        ml1.gunakanMotor(13);
        ml1.isiBaterai(75);
        ml1.gunakanMotor(13);
        ml1.info();
        ml1.setKecepatan(60);
        ml1.info();
        
    }
    
}
