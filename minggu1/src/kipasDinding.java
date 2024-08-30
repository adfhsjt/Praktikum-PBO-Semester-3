/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class kipasDinding {
    String merk;
    int level;

    public kipasDinding(String merk) {
        this.merk = merk;
        level = 0;
    }
    
    public void kurangiKecepatan(int decrement){
        level -= decrement;
    }
    
    public void tambahLevel(int increment) {
        level += increment;
    }
    
    public void info() {
        System.out.println("Merk kipas dinding" + merk);
        System.out.println("Level kecepatan kipas saat ini : " + level);
    }
    
}
