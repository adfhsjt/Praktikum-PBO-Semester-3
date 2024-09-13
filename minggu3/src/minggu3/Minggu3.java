/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minggu3;

/**
 *
 * @author ahmad
 */
public class Minggu3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Anggota anggota1 = new Anggota("Iwan Setiawan", "Jalan Sukarno Hatta no 10");
        System.out.println("Simpanan " + anggota1.getNama() + "\t:\tRp." + anggota1.getSimpanan());
        System.out.println("--------------------------------------------------------------------");
//        anggota1.setNama("Iwan Setiawan");
//        anggota1.setAlamat("Jalan Sukarno Hatta no 10");
        anggota1.setorUang(1000000);
        System.out.println("Simpanan " + anggota1.getNama() + "\t:\tRp." + anggota1.getSimpanan());
        System.out.println("--------------------------------------------------------------------");
        anggota1.pinjam(500000);
        System.out.println("Simpanan " + anggota1.getNama() + "\t:\tRp." + anggota1.getSimpanan());
        System.out.println("--------------------------------------------------------------------");
        
        
//        Motor honda = new Motor();
//        honda.printStatus();
//        honda.tambahKecepatan();
//        
//        honda.nyalakanMesin();
//        honda.printStatus();
//        
//        honda.tambahKecepatan();
//        honda.printStatus();
//        
//        honda.kurangiKecepatan();
//        honda.printStatus();
//        
//        honda.matikanMesin();
//        honda.printStatus();
//        
//        honda.nyalakanMesin();
//        for (int i = 0; i < 22; i++) {
//            honda.tambahKecepatan();
//        }
//        honda.printStatus();
    }
    
}
