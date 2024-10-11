/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Mamalia extends Hewan{
    public Mamalia(String nama, int umur) {
        super.setHewan(nama, umur);
        System.out.println("Konstruktor Mamalia ...");
    }
    
    void menyusui(){
        System.out.println("Menyusui anaknya ...");
    }
    
    
    
}
