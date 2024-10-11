/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class MotorMasukan extends Motor {
    int gigi;
    int kecepatan;

    public MotorMasukan(String brand, int tahun, int cc, int gigi, int kecepatan) {
        super(cc, brand, tahun);
        this.gigi = gigi;
        this.kecepatan = kecepatan;
        System.out.println("Memuat data Motor Masukan ...");
        System.out.println("------------------------------------------");
    }   
                
    public void infoMotorMasukan(){
        super.infoMotor();
        System.out.println("Gigi\t:\t" + gigi);
        System.out.println("Kecepatan\t:\t" + kecepatan + "km/jam");
        System.out.println("------------------------------------------");
    }
}
