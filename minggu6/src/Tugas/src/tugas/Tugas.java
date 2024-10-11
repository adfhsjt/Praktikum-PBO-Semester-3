/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas;

/**
 *
 * @author ahmad
 */
public class Tugas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DaftarGaji d = new DaftarGaji(5);
        Dosen dosen1 = new Dosen("123456789", "Budi Santoso", "Jl. Mawar No. 1");
        Dosen dosen2 = new Dosen("987654321", "Ani Lestari", "Jl. Melati No. 5");
        Dosen dosen3 = new Dosen("456789123", "Candra Wijaya", "Jl. Anggrek No. 10");
        Dosen dosen4 = new Dosen("234567891", "Dita Rahmawati", "Jl. Tulip No. 15");
        Dosen dosen5 = new Dosen("567891234", "Eka Saputra", "Jl. Lily No. 20");

        d.addPegawai(dosen1);
        d.addPegawai(dosen2);
        d.addPegawai(dosen3);
        d.addPegawai(dosen4);
        d.addPegawai(dosen5);
        
        dosen1.setSKS(4);
        dosen2.setSKS(6);
        dosen3.setSKS(2);
        dosen4.setSKS(3);
        dosen5.setSKS(0);
        
        d.printSemuaPegawai();
        
        
    }
    
}
