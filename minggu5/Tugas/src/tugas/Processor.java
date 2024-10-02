/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;

/**
 *
 * @author ahmad
 */
public class Processor {
    private String seri;
    private String socket;
    private int core;
    private int thread;
    private double kecepatan;

    public Processor() {
    }

    public Processor(String seri, String socket, int core, int thread, double kecepatan) {
        this.seri = seri;
        this.socket = socket;
        this.core = core;
        this.thread = thread;
        this.kecepatan = kecepatan;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public void setsocket(String socket) {
        this.socket = socket;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public void setThread(int thread) {
        this.thread = thread;
    }

    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    public String getSeri() {
        return seri;
    }

    public String getsocket() {
        return socket;
    }
    
    public int getCore() {
        return core;
    }

    public int getThread() {
        return thread;
    }

    public double getKecepatan() {
        return kecepatan;
    }
    
    public double hitungSkorBenchmark() {
        double skor = (core * 2) + (thread * 1.5) + (kecepatan * 10);
        return skor;
    }
    
    public void info() {
    System.out.println("Seri\t\t:\t" + seri);
    System.out.println("Socket\t\t:\t" + socket);
    System.out.println("Core\t\t:\t" + core);
    System.out.println("Thread\t\t:\t" + thread);
    System.out.println("Kecepatan\t:\t" + kecepatan + " GHz");
}

}
