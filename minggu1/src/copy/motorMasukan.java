/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class motorMasukan extends motor {
    double bensin;
    int gigi;

    public motorMasukan(String merk, int cc, int tekananAngin) {
        this.merk = merk;
        this.cc = cc;
        kecepatan = 0;
        this.tekananAngin = tekananAngin;
        bensin = 0;
        gigi = 0;
    }


    public void isiBensin(double increement) {
        bensin += increement;
    }

    public void gunakanMotor(int jarak) {
        double penggunaanBensin = jarak / 15;
        System.out.println("Siap berkendara ?");

//        if (cc >= 1000) {
//            penggunaanBensin = jarak / 4;
//        } else if (cc >= 500) {
//            penggunaanBensin = jarak / 8;
//        } else if (cc >= 150) {
//            penggunaanBensin = jarak / 12;
//        } else {
//            penggunaanBensin = jarak / 16;
//        }

        if (bensin > penggunaanBensin) {
            bensin -= penggunaanBensin;
            System.out.println("Brummm");
            gigi = 1;
            kecepatan = 20;
        } else {
            System.out.println("Mohon isi bensin terlebih dahulu");
        }
    }
    
    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
        if(kecepatan<=20){
            gigi = 1;
        } else if(kecepatan<=40){
            gigi = 2;
        } else if(kecepatan<=50) {
            gigi = 3;
        } else {
            gigi = 4;
        }
    }
    
    public void info() {
        System.out.println("Merk motor : " + merk);
        System.out.println("Bensin : " + bensin + " Liter");
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
        System.out.println("Gigi : " + gigi);
        System.out.println("Kecepatan : " + kecepatan);
    }

}
