/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class sistemInformasiTataTertib {

    Pelanggaran[] pelanggaran;

    public sistemInformasiTataTertib(int jumlah) {
        this.pelanggaran = new Pelanggaran[jumlah];
        System.out.println("Membuat database sistem sejumlah " + jumlah + " data ...");
    }

    public void catatPelanggaran(Pelanggaran pelanggaran) {
        for (int i = 0; i < this.pelanggaran.length; i++) {
            if (this.pelanggaran[i] == null) {
                this.pelanggaran[i] = pelanggaran;
                System.out.println("menyimpan data " + pelanggaran.pelanggar.nama);
                return;
            }
        }
        System.out.println("Gagal menyimpan data " + pelanggaran.pelanggar.nama + " karena database penuh ...");
    }

    public void lihatRiwayatPelanggaran(AnggotaKampus anggota) {
        System.out.println("Nama\t:\t" + anggota.getNama());
        System.out.println("ID\t:\t" + anggota.getId());
        System.out.println("Riwayat Pelanggaran : ");
        boolean temp = false;
        int count = 1;
        for(int i = 0; i < pelanggaran.length; i++) {
            if (pelanggaran[i].pelanggar.id.equals(anggota.id)) {
                System.out.println((count) + ".\tPeraturan\t:\t" + pelanggaran[i].peraturanDilanggar.peraturan);
                System.out.println("\tSanksi\t\t:\t" + pelanggaran[i].peraturanDilanggar.sanksi);
                count++;
                temp = true;
            }
        }
        if(temp != true){
            System.out.println(anggota.getNama() + " tidak memiliki riwayat sanksi pada sistem ini");
        }
        System.out.println("-------------------------------------------------------------------------");
    }
}
