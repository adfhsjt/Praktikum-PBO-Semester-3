/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Minggu9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        IntershipEmployee iEmp = new IntershipEmployee("Sunarto", 5);
        
        ElectricityBill eBill = new ElectricityBill(5, "A-1");
        Employee e;
        
        e = pEmp;
        
        System.out.println(e.getEmployeeInfo());
        System.out.println("-----------------");
        System.out.println(pEmp.getEmployeeInfo());
        Payable p;
        
        e = pEmp;
        System.out.println(e.getEmployeeInfo());
        e = iEmp;
        System.out.println(e.getEmployeeInfo());
        p = pEmp;
        System.out.println(p.getPaymentAmount());
        p = eBill;
        System.out.println(p.getPaymentAmount());
        
        
        
//        Deer d = new Deer();
//        Animal a = d;
//        
//        a.walk();
//        d.walk();
//        
//        a = new Animal();
//        a.walk();
//        
//        Animal an[] = new Animal[2];
//        an[0] = new Deer();
//        an[1] = new Lion();
//        
//        an[0].walk();
//        an[1].walk();
//        
//        Lion l = new Lion();
//        
//        Human h = new Human();
//        h.drive(d);
//        h.drive(l);
//        
//        System.out.println(a instanceof Deer);
//        Animal as = new Animal();
//        as.walk();
//        Deer dr = new Deer();
//        dr.walk();
        
        
        
        
        
    }
    
}
