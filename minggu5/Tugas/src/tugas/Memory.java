/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;

/**
 *
 * @author ahmad
 */
public class Memory {
    private String nama;
    private int kapasitas;
    private double kecepatan;

    public Memory() {
    }
    
    public Memory(String nama, int kapasitas, double kecepatan) {
        this.nama = nama;
        this.kapasitas = kapasitas;
        this.kecepatan = kecepatan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    public String getNama() {
        return nama;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public double getKecepatan() {
        return kecepatan;
    }
    
    public double hitungSkorBenchmark() {
        double skor = (kapasitas * 2) + (kecepatan * 0.1);
        return skor;
    }

    public void info() {
    System.out.println("Nama\t\t:\t" + nama);
    System.out.println("Kapasitas\t:\t" + kapasitas + " GB");
    System.out.println("Kecepatan\t:\t" + kecepatan + " MHz");
    System.out.println("Skor Benchmark\t:\t" + hitungSkorBenchmark());
}

    
    
}
