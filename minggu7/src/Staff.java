/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Staff extends Karyawan{
    private int lembur;
    private double gajiLembur;

    public void setLembur(int lembur) {
        this.lembur = lembur;
    }

    public void setGajiLembur(double gajiLembur) {
        this.gajiLembur = gajiLembur;
    }

    public int getLembur() {
        return lembur;
    }
    
    public double getGaji(int lembur, double gajiLembur) {
        return super.getGaji() + lembur * gajiLembur;
    }
    
    @Override
    public double getGaji(){
        return super.getGaji() + lembur * gajiLembur;
    }
    

    public double getGajiLembur() {
        return gajiLembur;
    }
    
    public void lihatInfo(){
        System.out.println("NIP\t\t:\t" + this.getNip());
        System.out.println("Nama\t\t:\t" + this.getNama());
        System.out.println("Golongan\t:\t" + this.getGolongan());
        System.out.println("Jml Lembur\t:\t" + this.getLembur());
        System.out.printf("Gaji Lembur\t:\t%.0f\n", this.getGajiLembur());
        System.out.printf("Gaji\t\t:\t%.0f\n", this.getGaji());
        
    }
    
    public void methodX(int a){
        System.out.println("kkk");
    }
    
    public void methodX(double a){
        System.out.println("kkk");
    }
    
    public void methodX(){
        System.out.println("kkk");
    }
    
    public void methodX(int a, int b){
        System.out.println("kkk");
    }
    
    public void methodX(double a, double b){
        System.out.println("kkk");
    }
    
//    public void methodX(int b, double a){
//        System.out.println("kkk");
//    }
    
    public void methodX(double a, int b){
        System.out.println("kkk");
    }
    
    @Override
    public void makan(){
        System.out.println("Makan");
    }
    
    
    
    
    
    
    
    
}
