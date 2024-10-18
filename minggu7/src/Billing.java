/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Billing {
    public double hitung(int jum, int kel) {
    double total = 0;
    int j = 0;
    
    for(int i = 1; i <= jum; i++){
        if(j > 50){
            kel += 50000;
            j = 0;
        } 
        total += kel;
        j++;
    }
    return total;

    
}

}
