/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ahmad
 */
import java.util.Scanner;

public class TestKoperasi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        int pilihan;
        System.out.println("DAFTAR ANGGOTA");
        System.out.print("Masukkan Nomor KTP\t:\t");
        String ktp = sc1.next();
        System.out.print("Masukkan Nama\t\t:\t");
        String nama = sc1.next();
        System.out.print("Masukkan Limit Pinjaman\t:\t");
        double limitPinjaman = sc.nextDouble();
        Anggota input = new Anggota(ktp, nama, limitPinjaman);
        boolean next = false;
        do {
            System.out.println("MENU");
            System.out.println("1. Pinjam");
            System.out.println("2. Angsur");
            System.out.println("3. Info");
            System.out.println("0. EXIT");
            boolean lanjut = false;
            do {
                pilihan = sc.nextInt();
                if (pilihan > 3) {
                    System.out.println("Pilihan tidak valid");
                    lanjut = false;
                } else {
                    lanjut = true;
                }
            } while (lanjut != true);
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jumlah uang yang ingin dipinjam : ");
                    double jumlah = sc.nextDouble();
                    System.out.println("Meminjam Uang Sejumlah " + (int)jumlah + "...");
                    input.pinjam(jumlah);
                    System.out.println("Jumlah Pinjaman\t:\t" + input.getJumlahPinjaman());
                    break;
                case 2:
                    System.out.print("Masukkan jumlah uang diangsur : ");
                    double angsur = sc.nextDouble();
                    System.out.println("Mengangsur Pinjaman Sejumlah " + angsur + "...");
                    input.angsur(angsur);
                    System.out.println("Jumlah Pinjaman\t:\t" + input.getJumlahPinjaman());
                    break;
                case 3:
                    System.out.println("KTP\t\t:\t" + input.getNomorKTP());
                    System.out.println("Nama\t\t:\t" + input.getNama());
                    System.out.println("Limit Peminjaman\t:\t" + input.getLimitPinjaman());
                    System.out.println("Jumlah Pinjaman\t:\t" + input.getJumlahPinjaman());
                    break;
                case 0:
                    if (input.getJumlahPinjaman() != 0) {
                        System.out.println("Tidak bisa Keluar karena pinjaman masih ada.\nSilahkan cek pada menu INFO");
                    } else {
                        next = true;
                        break;
                    }
            }
        } while (next != true);
//        Anggota donny = new Anggota("111333444", "Donny", 5000000);
//
//        System.out.println("Nama Anggota: " + donny.getNama());
//        System.out.println("Limit Pinjaman: " + donny.getLimitPinjaman());
//        System.out.println("\nMeminjam uang 10.000.000...");
//        donny.pinjam(10000000);
//        System.out.println("Jumlah pinjaman saat ini: " + donny.getJumlahPinjaman());
//        System.out.println("\nMeminjam uang 4.000.000...");
//        donny.pinjam(4000000);
//        System.out.println("Jumlah pinjaman saat ini: " + donny.getJumlahPinjaman());
//        System.out.println("\nMembayar angsuran 100.000");
//        donny.angsur(100000);
//        System.out.println("Jumlah pinjaman saat ini: " + donny.getJumlahPinjaman());
//        System.out.println("\nMembayar angsuran 3.000.000");
//        donny.angsur(3000000);
//        System.out.println("Jumlah pinjaman saat ini: " + donny.getJumlahPinjaman());
    }
}
