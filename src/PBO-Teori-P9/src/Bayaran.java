/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Bayaran {
    public int hitungBayaran(Pegawai pg){
        int uang = pg.getGaji();
        
        if(pg instanceof Manager){
            uang += ((Manager) pg).getTunjangan();
        } else if(pg instanceof Programmer){
            uang += ((Programmer) pg).getBonus();
        }
        
        return uang;
    }
}
