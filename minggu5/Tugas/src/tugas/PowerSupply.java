/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;

import java.awt.GradientPaint;

/**
 *
 * @author ahmad
 */
public class PowerSupply {
    private String seri;
    private int power;
    private int grade;

    public PowerSupply(String seri, int power, int grade) {
        this.seri = seri;
        this.power = power;
        this.grade = grade;
    }

    public String getSeri() {
        return seri;
    }

    public int getPower() {
        return power;
    }

    public int getGrade() {
        return grade;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    public double hitungSkorBenchmark(){
        return (grade * 3) + (power * 1.5);
    }
    
    public void info() {
    System.out.println("Seri\t\t:\t" + seri);
    System.out.println("Power\t\t:\t" + power + " Watt");
    System.out.println("Skor Benchmark\t:\t" + hitungSkorBenchmark());
}


}
