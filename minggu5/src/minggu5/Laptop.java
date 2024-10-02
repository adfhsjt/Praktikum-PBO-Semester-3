/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minggu5;

/**
 *
 * @author ahmad
 */
public class Laptop {
    private String merk;
    private Processor proc;

    public Laptop() {
    }

    public Laptop(String merk, Processor proc) {
        this.merk = merk;
        this.proc = proc;
    }
    
    public void setMerk(String merk) {
        this.merk = merk;
    }
    
    public String getMerk(){
        return merk;
    }
    
    public void setProc(Processor proc){
        this.proc = proc;
    }
    
    public Processor getProcessor(){
        return proc;
    }
    
    public void info(){
        System.out.println("Merk Laptop\t:\t" + merk);
        System.out.println("Spesifikasi Processor");
        if(proc != null){
            getProcessor().info();
        
        }else {
            System.out.println("Processor Tidak Terpasang");
        }
        System.out.println("-----------------------------------");
        
    }
    
    
}
