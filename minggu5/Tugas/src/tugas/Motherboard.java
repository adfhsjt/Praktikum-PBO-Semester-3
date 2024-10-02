/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;

/**
 *
 * @author ahmad
 */
public class Motherboard {
    private String seri;
    private String soket;
    private String chipset;
    private double poinBenchmark;

    public Motherboard(String seri, String soket, String chipset, double poinBenchmark) {
        this.seri = seri;
        this.soket = soket;
        this.chipset = chipset;
        this.poinBenchmark = poinBenchmark;
    }

    public void info() {
    System.out.println("Seri\t\t:\t" + seri);
    System.out.println("Soket\t\t:\t" + soket);
    System.out.println("Chipset\t\t:\t" + chipset);
    System.out.println("Skor Benchmark\t:\t" + poinBenchmark);
}


    // Getters dan Setters (opsional)
    public String getSeri() {
        return seri;
    }

    public String getSoket() {
        return soket;
    }

    public String getChipset() {
        return chipset;
    }

    public double getPoinBenchmark() {
        return poinBenchmark;
    }

    
}
