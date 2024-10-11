/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Anjing extends Hewan{
    private String jenisBulu;
    
    public Anjing(String nama, int umur, String jenisBulu) {
        super.setHewan(nama, umur);
        this.jenisBulu = jenisBulu;
    }
    
    public String getJenisBulu(){
        return jenisBulu;
    }
    
    public void gukguk(){
        System.out.println("Gukguk ...");
    }
    
}
