/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Kucing extends Hewan {
    private String warnaBulu;

    public Kucing(String name, int umur, String warnaBulu) {
        super.Hewan(name, umur);
        this.warnaBulu = warnaBulu;
        System.out.println("Konstruktor kucing dengan ras");
    }
    
    public void meow(){
        System.out.println("Meow ... ");
    }
    
    @Override
    public void suaraHewan(){
        System.out.println("Suara Kucing adalah meow ...");
    }
    
    public void info(){
        super.info();
        System.out.println("Warna bulu\t:\t" + warnaBulu);
    }
    
}
