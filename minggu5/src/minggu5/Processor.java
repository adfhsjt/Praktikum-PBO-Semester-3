/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minggu5;

/**
 *
 * @author ahmad
 */
public class Processor {
    private String merk;
    private double cache;

    public Processor() {
    }

    public Processor(String merk, double cache) {
        this.merk = merk;
        this.cache = cache;
    }
    
    public void setMerk(String merk){
        this.merk = merk;
    }
    
    public String getMerk(){
        return merk;
    }
    
    public void setCache(double cache){
        this.cache = cache;
    }
    
    public double getCache(){
        return cache;
    }
    
    public void info(){
        System.out.println("Merk Processor\t:\t" + merk);
        System.out.println("Cache Processor\t:\t" + cache);
        System.out.println("-----------------------------------");
        
        
    }
}
