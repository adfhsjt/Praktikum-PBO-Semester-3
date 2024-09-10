/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minggu2;

/**
 *
 * @author ahmad
 */
public class TokoVideo {
    int id, harga;
    String namaMember, namaGame;

    public TokoVideo(int id, int harga, String namaMember, String namaGame) {
        this.id = id;
        this.harga = harga;
        this.namaMember = namaMember;
        this.namaGame = namaGame;
    }
    
    public void tampilData(){
        System.out.println("Id member\t:\t" + id);
        System.out.println("Nama member\t:\t" + namaMember);
        System.out.println("Nama game\t:\t" + namaGame);
        System.out.println("Harga\t\t:\t" + harga + " / hari");
        
    }
    
    public int pembayaran(int lamaSewa){
        int totBayar = lamaSewa * harga;
        System.out.println("Lama sewa\t:\t" + lamaSewa + " / hari");
        System.out.println("Total bayar\t:\t" + totBayar);
        return totBayar; 
    }
}
