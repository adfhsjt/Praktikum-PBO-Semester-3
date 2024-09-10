/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minggu2;

/**
 *
 * @author ahmad
 */
public class Minggu2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
         // Objek mata kuliah
        Matkul matkul1 = new Matkul(8164, "Pemrograman Dasar");
        Matkul matkul2 = new Matkul(5162, "Algoritma dan Struktur Data");
        Matkul matkul3 = new Matkul(9321, "Jaringan Komputer");
        Matkul matkul4 = new Matkul(9172, "Sistem Operasi");
        Matkul matkul5 = new Matkul(5132, "Basis Data");
        
        // Objek dosen
        Dosen dosen1 = new Dosen(101, "Dr. Andi", matkul1);
        Dosen dosen2 = new Dosen(102, "Prof. Sari", matkul2);
        Dosen dosen3 = new Dosen(103, "Dr. Budi", matkul3);
        Dosen dosen4 = new Dosen(104, "Prof. Cici", matkul4);
        Dosen dosen5 = new Dosen(105, "Dr. Dedi", matkul5);

        // Objek mahasiswa
        Mahasiswa mahasiswa1 = new Mahasiswa(201, "Alice", "Jl. Mawar No. 12", "TI-A");
        
        // Mahasiswa menambahkan matkul 
        mahasiswa1.addMatkulMhs(matkul1);
        mahasiswa1.addMatkulMhs(matkul2);
        mahasiswa1.addMatkulMhs(matkul3);
        mahasiswa1.addMatkulMhs(matkul4);
        mahasiswa1.addMatkulMhs(matkul5);
        
        // Menambahkan mahasiswa ke dosen
        dosen1.addMhs(mahasiswa1);
        dosen2.addMhs(mahasiswa1);
        dosen3.addMhs(mahasiswa1);
        dosen4.addMhs(mahasiswa1);
        dosen5.addMhs(mahasiswa1);
        
        // Dosen memberi nilai ke mahasiswa
        
        dosen1.setNilaiMhs(mahasiswa1, 86);
        dosen2.setNilaiMhs(mahasiswa1, 81); 
        dosen3.setNilaiMhs(mahasiswa1, 95);
        dosen4.setNilaiMhs(mahasiswa1, 88);
        dosen5.setNilaiMhs(mahasiswa1, 77);
        
        // Rincian nilai Mahasiswa
        mahasiswa1.rincianNilaiMhs();

        // List mahasiswa yang diajar dosen
        dosen1.infoMahasiswaYangDiajarDosen();
        dosen2.infoMahasiswaYangDiajarDosen();
        dosen3.infoMahasiswaYangDiajarDosen();
        dosen4.infoMahasiswaYangDiajarDosen();
        dosen5.infoMahasiswaYangDiajarDosen();
        
        
        
//        Mahasiswa mhs1 = new Mahasiswa(1, "Karim", "Jombang", "TI-2H");
//        
//        dosen dsn1 = new dosen(1, "Pak Yunus");
//        dosen dsn2 = new dosen(2, "Pak Indra");
//        dosen dsn3 = new dosen(3, "Pak Yan");
//        
//        matkul pbo = new matkul(1, "Permograman Berbasis Objek", dsn1);
//        matkul sim = new matkul(2, "Sistem Informasi Bisnis", dsn2);
//        matkul basdat = new matkul(3, "Basis Data Lanjut", dsn3);
//        
//        nilai mhs1PBO = new nilai(mhs1, pbo, 85);
//        nilai mhs1sim = new nilai(mhs1, sim, 82);
//        nilai mhs1basdat = new nilai(mhs1, basdat, 88);
//        
//        System.out.println(mhs1PBO.mhs.nama);
//        System.out.println(mhs1PBO.d.namaDosen);
//        System.out.println(mhs1PBO.l.namaMatkul);
//        System.out.println(mhs1PBO.nilai);
//        
//        System.out.println(mhs1sim.mhs.nama);
//        System.out.println(mhs1sim.d.namaDosen);
//        System.out.println(mhs1sim.l.namaMatkul);
//        System.out.println(mhs1sim.nilai);
//        
//        System.out.println(mhs1basdat.mhs.nama);
//        System.out.println(mhs1basdat.d.namaDosen);
//        System.out.println(mhs1basdat.l.namaMatkul);
//        System.out.println(mhs1basdat.nilai);
        
//        Lingkaran l1 = new Lingkaran(3);
//        l1.hasil(l1);
        
//        TokoVideo game1 = new TokoVideo(1, 5000, "Dian", "FF");
//        game1.tampilData();
//        game1.pembayaran(3);
        
//        Mahasiswa mhs1 = new Mahasiswa();
//        mhs1.nim=1234;
//        mhs1.nama="Jamaludin";
//        mhs1.alamat="Gondang";
//        mhs1.kelas="TI-2E";
//        mhs1.tampilBoidata();
//        
//        Mahasiswa mhs2 = new Mahasiswa();
//        mhs2.nim=2345;
//        mhs2.nama="Kasimudin";
//        mhs2.alamat="Karanganyar";
//        mhs2.kelas="TI-2A";
//        mhs2.tampilBoidata();
        
    }
}
