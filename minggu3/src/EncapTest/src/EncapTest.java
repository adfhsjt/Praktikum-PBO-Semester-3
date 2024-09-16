/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class EncapTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EncapDemo encap = new EncapDemo();
        encap.setName("James");
        encap.setAge(35);
        
        System.out.println("Name\t:\t" + encap.getName());
        System.out.println("Age\t:\t" + encap.getAge());
        
        encap.setAge(10);
        
        System.out.println("Name\t:\t" + encap.getName());
        System.out.println("Age\t:\t" + encap.getAge());
        
    }
    
}
