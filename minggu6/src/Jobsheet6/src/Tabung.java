/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Tabung extends Bangun{
    protected int t;
    public void setSuperPhi(double phi){
        super.phi = phi;
    }
    
    public void setSuperR(int r){
        super.r = r;
    }
    
    public void setT(int t){
        this.t = t;
    }
    
    public void volume(){
        System.out.println("Volume tabung adalah : " + (super.phi*super.r*super.r*this.t));
    }
}
