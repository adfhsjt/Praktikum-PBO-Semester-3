/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Segitiga {
    private int sudut;
    
    public int totalSudut(int sudutA){
        sudut = Math.abs(180 - sudutA);
        return sudut;
    }
    
    public int totalSudut(int sudutA, int sudutB){
        sudut = Math.abs(180 - (sudutA + sudutB));
        return sudut;
    }
    
    public int keliling(int sisiA, int sisiB, int sisiC){
        int keliling = sisiA + sisiB + sisiC;
        return keliling;
    }
    
    public double keliling(int sisiA, int sisiB){
        double sisiC = Math.sqrt((sisiA * sisiA) + (sisiB * sisiB));
        double keliling = sisiA + sisiB + sisiC;
        return keliling;
    }
}
