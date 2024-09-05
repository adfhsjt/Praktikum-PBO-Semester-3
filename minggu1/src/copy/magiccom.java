/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class magiccom {
    String merk;
    boolean mode;

    public magiccom(String merk) {
        this.merk = merk;
        mode = false;
    }
    
    public void modeWarm() {
        mode = false;
    }
    
    public void modeCook() {
        mode = true;
    }
    
    public void info() {
        System.out.println("Merk magiccom : " + merk);
        String mod = mode ? "Cook" : "Warm";
        System.out.println("Mode magiccom saat ini : " + mod);
    }
    
    
}
