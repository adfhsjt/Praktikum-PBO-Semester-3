/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minggu2;

/**
 *
 * @author ahmad
 */
public class Mahasiswa {
    public int nim;
    public String nama, alamat, kelas;
    public Matkul[] matkulMhs;
    public int countMatkul;

    public Mahasiswa() {
    }
    
    public Mahasiswa(int nim, String nama, String alamat, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.kelas = kelas;
        matkulMhs = new Matkul[5];
        for(int i = 0; i < matkulMhs.length; i++){
            matkulMhs[i] = new Matkul();
        }
        countMatkul = 0;
    }
    
    public void addMatkulMhs(Matkul matkul){
        if(countMatkul > matkulMhs.length){
            System.out.println("Maksimal matkul tercapai");
        } else {
            matkulMhs[countMatkul] = matkul;
            countMatkul++;
        }
    }
    
    public Matkul cariMatkul(int kode) {
        for (int i = 0; i < countMatkul; i++) {
            if (matkulMhs[i].kode == kode) {
                return matkulMhs[i];
            }
        }
        return null;
    }
    
    public void tampilBoidata(){
        System.out.println("NIM\t\t:\t" + nim);
        System.out.println("Nama\t\t:\t"+ nama);
        System.out.println("Alamat\t\t:\t" + alamat);
        System.out.println("Kelas\t\t:\t" + kelas);
        System.out.println("-----------------------------------");
    }
    
    public void rincianNilaiMhs(){
        System.out.println("NIM\t\t:\t" + nim);
        System.out.println("Nama\t\t:\t"+ nama);
        System.out.println("Alamat\t\t:\t" + alamat);
        System.out.println("Kelas\t\t:\t" + kelas);
        for(int i = 0; i < matkulMhs.length; i++){
            System.out.println(matkulMhs[i].namaMatkul + "\t:\t" + matkulMhs[i].nilai);
        }
        System.out.println("-------------------------------------------------");
    }
    
}
