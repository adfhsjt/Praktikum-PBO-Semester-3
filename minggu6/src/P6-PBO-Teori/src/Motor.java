/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Motor extends Kendaraan {
    int cc;

    public Motor(int cc, String brand, int tahun) {
        super(brand, tahun);
        this.cc = cc;
        System.out.println("Memuat data Motor ...");
    }
    
    public void infoMotor(){
        super.info();
        System.out.println("CC\t:\t" + cc);
    }
}
