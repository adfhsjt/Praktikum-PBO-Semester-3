/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minggu2;

/**
 *
 * @author ahmad
 */
public class Dosen {

    public int nip;
    public String namaDosen;
    public Matkul dosenMatkul; // Mata kuliah yang diajarkan oleh dosen
    public Mahasiswa[] mahasiswa;
    public int countMahasiswa;

    public Dosen(int nip, String namaDosen, Matkul matkul) {
        this.nip = nip;
        this.namaDosen = namaDosen;
        this.dosenMatkul = matkul;
        this.mahasiswa = new Mahasiswa[10];
        this.countMahasiswa = 0;
    }

    public void addMhs(Mahasiswa mhs) {
        if (countMahasiswa < mahasiswa.length) {
            mahasiswa[countMahasiswa++] = mhs;
        } else {
            System.out.println("Jumlah mahasiswa sudah mencapai batas maksimum.");
        }
    }

    public void setNilaiMhs(Mahasiswa mhs, double nilai) {
        for (int i = 0; i < countMahasiswa; i++) {
            if (mahasiswa[i].nim == mhs.nim) {
                Matkul matkul = mahasiswa[i].cariMatkul(dosenMatkul.kode);
                if (matkul != null) {
                    matkul.setNilai(nilai);
                    return;
                } else {
                    System.out.println("Mata kuliah tidak ditemukan untuk mahasiswa.");
                }
                return;
            }
        }
        System.out.println("Mahasiswa tidak ditemukan.");
    }

    public void infoDosen() {
        System.out.println("NIP\t\t:\t" + nip);
        System.out.println("Nama Dosen\t:\t" + namaDosen);
        System.out.println("Matkul Diajar\t:\t" + dosenMatkul.namaMatkul);
        System.out.println("-------------------------------------------");

    }

    public void infoMahasiswaYangDiajarDosen() {
        System.out.println("Daftar Mahasiswa Yang Diajar " + namaDosen);
        for (int i = 0; i < countMahasiswa; i++) {
            System.out.println((i+1) + ". " + mahasiswa[i].nama);
        }
        System.out.println("-------------------------------------------");

    }

}
