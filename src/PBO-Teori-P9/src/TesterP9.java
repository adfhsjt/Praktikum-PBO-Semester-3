
import javax.swing.plaf.multi.MultiPanelUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class TesterP9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Manusia indro = new Manusia();
        TelevisiJadul tvjadul = new TelevisiJadul();
        tvjadul.
        TelevisiModern tvmodern = new TelevisiModern();
        
        indro.nyalakanPerangkat(tvjadul);
        indro.nyalakanPerangkat(tvmodern);
        
        
    }
    
}

//Manager man = new Manager(50, "Agus", 800);
//        Programmer prog = new Programmer(30, "Budi", 600);
//        Bayaran hr = new Bayaran();
//        
//        System.out.println("Bayaran manager: " + hr.hitungBayaran(man));
//        System.out.println("Bayaran programmer: " + hr.hitungBayaran(prog));
