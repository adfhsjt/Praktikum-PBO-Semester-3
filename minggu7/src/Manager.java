/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Manager extends Karyawan{
    private double tunjangan;
    private String bagian;
    Staff st[];
    
    public void setTunjangan(double tunjangan) {
        this.tunjangan = tunjangan;
    }

    public void setBagian(String bagian) {
        this.bagian = bagian;
    }

    public void setStaff(Staff[] st) {
        this.st = st;
    }

    public double getTunjangan() {
        return tunjangan;
    }

    public String getBagian() {
        return bagian;
    }

    public void viewStaff() {
        int i;
        System.out.println("-------------------------------");
        for(i = 0; i < st.length; i++){
            st[i].lihatInfo();
        }
        System.out.println("-------------------------------");
    }
    
    public void lihatInfo(){
        System.out.println("Manager\t\t:\t" + this.getBagian());
        System.out.println("NIP\t\t:\t" + this.getNip());
        System.out.println("Nama\t\t:\t" + this.getNama());
        System.out.println("Golongan\t:\t" + this.getGolongan());
        System.out.printf("Tunjangan\t:\t%.0f\n", this.getTunjangan());
        System.out.printf("Gaji\t\t:\t%.0f\n", this.getGaji());
        System.out.println("Bagian\t\t:\t" + this.getBagian());
        this.viewStaff();
        
    }
    
    @Override
    public double getGaji(){
        return super.getGaji() + tunjangan;
    }
    
    
}
