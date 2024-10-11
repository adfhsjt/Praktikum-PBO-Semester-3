/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;

/**
 *
 * @author ahmad
 */
public class DaftarGaji {

    public Pegawai[] listPegawai;

    public DaftarGaji(int jumlahPegawai) {
        listPegawai = new Pegawai[jumlahPegawai];
        System.out.println("Membuat List Gaji Pegawai ...");
        System.out.println("---------------------------------------------------");
    }

    public void addPegawai(Pegawai pegawai) {
        for (int i = 0; i < listPegawai.length; i++) {
            if (listPegawai[i] == null) {
                listPegawai[i] = pegawai;
                return;
            }
        }
        System.out.println("Dosen sudah penuh");
    }
    
    public void printSemuaPegawai(){
        System.out.printf("%-15s %-15s %-10s%n", "Nama", "NIP", "Gaji");
    System.out.println("---------------------------------------------------");
    
    for (Pegawai pegawai : listPegawai) {
        if (pegawai != null) {
            // Printing in table format
            System.out.printf("%-15s %-15s %-10d%n", pegawai.getNama(), pegawai.nip, pegawai.getGaji());
        }
    }
    
    System.out.println("---------------------------------------------------");
    }

}
