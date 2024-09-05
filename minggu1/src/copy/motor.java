/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class motor {

    String merk;
    int cc, kecepatan, tekananAngin;
    
    public motor(){
        
    }

    public motor(String merk, int cc) {
        this.merk = merk;
        this.cc = cc;
        kecepatan = 0;
        tekananAngin = 0;
    }

    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
    }

    public void tambahTekananAngin(int increment) {
        tekananAngin += increment;
    }
    
    public void info() {
        System.out.println("Merk motor : " + merk);
        System.out.println("CC motor : " + cc + "CC");
        String temp;
        if (cc >= 1000) {
            temp = "Sangat cepat";
        } else if (cc >= 500) {
            temp = "Cepat";
        } else if (cc >= 150) {
            temp = "Standar";
        } else {
            temp = "Lambat";
        }
        System.out.println("Level CC saat ini : " + temp);
        System.out.println("Kecepatan : " + kecepatan + " KM");
        System.out.println("Tekanan angin : " + tekananAngin + " PSI");
    }

}
