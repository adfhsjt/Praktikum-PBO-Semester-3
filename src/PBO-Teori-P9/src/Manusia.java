/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Manusia {
    public void nyalakanPerangkat(Elektronik perangkat){
        if(perangkat instanceof TelevisiJadul){
            System.out.println("Nyalakan televisi jadul dengan input: DVI\nVoltase televisi: 220");
        } else if(perangkat instanceof TelevisiModern){
            System.out.println("Nyalakan televisi jadul dengan input: HDMI\nVoltase televisi: 220");
        }
    }
}
