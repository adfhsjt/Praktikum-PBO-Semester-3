/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minggu2;

/**
 *
 * @author ahmad
 */
public class Lingkaran {
    final double phi;
    double r;

    public Lingkaran(double r) {
        this.phi = 3.14;
        this.r = r;
    }
    
    public double hitungLuas(){
        return phi * r * r;
    }
    
    public double hitungKeliling(){
        return 2 * phi * r;
    }
    
    public void hasil(Lingkaran temp){
        System.out.println("Luas\t:\t" + temp.hitungLuas());
        System.out.println("Keliling\t:\t" + temp.hitungKeliling());
    }
    

    
    
    
}
