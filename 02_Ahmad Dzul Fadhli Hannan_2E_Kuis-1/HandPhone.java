/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Author: Ahmad
 */
public class HandPhone {

    private String noSeri;
    private String model;
    private String versiOs;
    private boolean on = false;
    private int volume = 0;
    private int tempVolume = 0; // Initialize tempVolume
    private boolean mute = false;

    public HandPhone() {
    }

    public HandPhone(String noSeri, String model, String versiOs) {
        this.noSeri = noSeri;
        this.model = model;
        this.versiOs = versiOs;
    }

    public void power() {
        this.on = true;
        System.out.println("Handphone dinyalakan");
    }
    
    public void off(){
        this.on = false;
        System.out.println("Handphone dimatikan");
    }

    public void tambahVolume() {
        if (!on) {
            System.out.println("Handphone masih mati");
            return;
        }
        if (volume >= 100) {
            System.out.println("Volume Max Tercapai");
        } else {
            volume += 5;
            if (volume > 100) {
                volume = 100;
            }
            mute = false;
        }
    }

    public void kurangiVolume() {
        if (!on) {
            System.out.println("Handphone masih mati");
            return;
        }
        if (volume <= 0) {
            System.out.println("Volume Minimum Tercapai");
        } else {
            volume -= 5;
            if (volume < 0) {
                volume = 0;
            }
            mute = false;
        }
    }

    public void mute() {
        if (!on) {
            System.out.println("Handphone masih mati");
            return;
        }
        if (!mute) {
            tempVolume = volume;
            volume = 0;
            mute = true;
            System.out.println("Handphone dimute.");
        } else {
            volume = tempVolume;
            mute = false;
        }
    }

    public void info() {
        System.out.println("Nomor Seri\t:\t" + noSeri);
        System.out.println("Model\t\t:\t" + model);
        System.out.println("Versi OS\t\t:\t" + versiOs);
        System.out.println("On\t\t:\t" + on);
        System.out.println("Volume\t:\t" + volume);
        System.out.println("-------------------------");
    }
}
