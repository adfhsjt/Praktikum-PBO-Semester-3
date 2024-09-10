/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minggu2;

/**
 *
 * @author ahmad
 */
public class Matkul {
    public int kode;
    public String namaMatkul;
    public double nilai;

    public Matkul() {
    }
    
    public Matkul(int kode, String namaMatkul) {
        this.kode = kode;
        this.namaMatkul = namaMatkul;
        this.nilai = 0;
    }
    
    public void setNilai(double nilai) {
        this.nilai = nilai;
    }
    
    
    
}
