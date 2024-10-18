/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minggu8;

/**
 *
 * @author ahmad
 */
public class Komputer {
    public String merk;
    public int kecProsesor;
    public int sizeMemory;
    public String jnsProsesor;

    public Komputer() {
    }

    public Komputer(String merk, int kecProsesor, int sizeMemory, String jnsProsesor) {
        this.merk = merk;
        this.kecProsesor = kecProsesor;
        this.sizeMemory = sizeMemory;
        this.jnsProsesor = jnsProsesor;
    }
    
    public void tampilData(){
        System.out.println("Merk\t\t\t:\t" + merk);
        System.out.println("Kecepatan Prosesor\t:\t" + kecProsesor);
        System.out.println("Size Memory\t\t:\t" + sizeMemory);
        System.out.println("Jenis Prosesor\t\t:\t" + jnsProsesor);
    }
}
