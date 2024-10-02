/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;

/**
 *
 * @author ahmad
 */
public class GraphicCard {
    private String seri;
    private int kecepatan;
    private int vram;

    public GraphicCard(String seri, int kecepatan, int vram) {
        this.seri = seri;
        this.kecepatan = kecepatan;
        this.vram = vram;
    }

    public String getSeri() {
        return seri;
    }

    public int getKecepatan() {
        return kecepatan;
    }

    public int getVram() {
        return vram;
    }
    
    public double hitungSkorBenchmark(){
        return (kecepatan * 0.5) + (vram * 0.2);
    }
    
    public void info() {
    System.out.println("Seri\t\t\t:\t" + seri);
    System.out.println("Kecepatan\t\t:\t" + kecepatan + " Ghz");
    System.out.println("VRam\t\t\t:\t" + vram + " GB");
    System.out.println("Skor Benchmark\t:\t" + hitungSkorBenchmark());
}

    
}
