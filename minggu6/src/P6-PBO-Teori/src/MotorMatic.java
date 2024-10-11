/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class MotorMatic extends Motor{
    int kecepatan;

    public MotorMatic(String brand, int tahun, int cc, int kecepatan) {
        super(cc, brand, tahun);
        this.kecepatan = kecepatan;
        System.out.println("Memuat data Motor Matic ...");
        System.out.println("------------------------------------------");
    
    }
    
    public void infoMotorMatic(){
        super.infoMotor();
        System.out.println("Kecepatan\t:\t" + kecepatan + "km/jam");
        System.out.println("------------------------------------------");
    }
}
