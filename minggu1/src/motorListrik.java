/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class motorListrik extends motor {
    double kapasitasBaterai;
    double daya; 

    public motorListrik(String merk, int cc, int tekananAngin) {
        this.merk = merk;
        this.cc = cc;
        this.kecepatan = 0;
        this.tekananAngin = tekananAngin; 
        this.kapasitasBaterai = 0;
        this.daya = 0; 
    }

    public void isiBaterai(double tambahan) {
        kapasitasBaterai += tambahan;
        if (kapasitasBaterai > 100) {
            kapasitasBaterai = 100; 
        }
    }

    public void gunakanMotor(int jarak) {
        double penggunaanBaterai = jarak / 10.0; 
        
        if (kapasitasBaterai > penggunaanBaterai) {
            kapasitasBaterai -= penggunaanBaterai;
            System.out.println("Wrrrrm");
            kecepatan = 20;
            daya = 500;
        } else {
            System.out.println("Mohon isi baterai terlebih dahulu");
        }
    }

    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
        if(kecepatan<=20){
            daya = 500;
        } else if(kecepatan<=30){
            daya = 1500;
        } else if(kecepatan<=40) {
            daya = 3500;
        } else {
            daya = 4500;
        }
    }

    public void info() {
        System.out.println("Merk motor : " + merk);
        System.out.println("Kapasitas Baterai : " + kapasitasBaterai + "%");
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
        System.out.println("Tekanan angin : " + tekananAngin + "PSI"); 
        System.out.println("Kecepatan : " + kecepatan);
        System.out.println("Daya Motor : " + daya + " Watt"); 
    }
}
