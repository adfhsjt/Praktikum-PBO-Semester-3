/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ahmad
 */
public class Buku {
    private int idbuku;
    private Kategori kategori;
    private String judul, penerbit, penulis;

    public Buku() {
    }

    public Buku(String judul, Kategori kategori, String penerbit, String penulis) {
        this.judul = judul;
        this.kategori = kategori;
        this.penerbit = penerbit;
        this.penulis = penulis;
    }

    public int getIdbuku() {
        return idbuku;
    }

    public String getJudul() {
        return judul;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setIdbuku(int Idbuku) {
        this.idbuku = Idbuku;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }
    
    public Buku getById(int id){
        Buku an = new Buku();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM buku WHERE idbuku = '" + id + "'");
        
        try {
            while(rs.next()){
                an = new Buku();
                an.setIdbuku(rs.getInt("idbuku"));
                an.setJudul(rs.getString("judul"));
                an.setKategori(rs.getInt("kategori"));
                an.setPenerbit(rs.getString("penerbit"));
                an.setPenulis(rs.getString("penulis"));
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return an;
    }
    
    public ArrayList<Buku> getAll(){
        ArrayList<Buku> ListKategori = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM buku");
        
        try {
            while(rs.next()){
                Buku bk = new Buku();
                bk.setIdbuku(rs.getInt("idbuku"));
                bk.setJudul(rs.getString("judul"));
                bk.setKategori(rs.getInt("kategori"));
                bk.setPenerbit(rs.getString("penerbit"));
                bk.setPenulis(rs.getString("penulis"));
                
                ListKategori.add(bk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }
    
    public ArrayList<Buku> search(String keyword){
        ArrayList<Buku> ListBuku = new ArrayList();
        
        String sql = "SELECT * FROM anggota WHERE judul LIKE '%" + keyword + "%' OR keterangan LIKE '%" + keyword + "%'";

        ResultSet rs = DBHelper.selectQuery(sql);
        
        
        try {
            while(rs.next()){
                Buku bk = new Buku();
                bk.setIdbuku(rs.getInt("idbuku"));
                bk.setJudul(rs.getString("judul"));
                bk.setKategori(rs.getInt("Kategori"));
                bk.setPenerbit(rs.getString("penerbit"));
                bk.setPenulis(rs.getString("penulis"));
                
                
                ListBuku.add(bk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListBuku;
    }
    
    public void save() {
    if (getById(idbuku).getIdbuku()== 0) {
        String SQL = "INSERT INTO buku (judul, kategori, penerbit, penulis) VALUES ("
                + "'" + this.judul + "', "
                + "'" + this.kategori + "', "
                + "'" + this.penerbit + "', "
                + "'" + this.penulis + "')";
        this.idbuku = DBHelper.insertQueryGetId(SQL);
    } else {
        String SQL = "UPDATE buku SET "
                + "judul = '" + this.judul + "', "
                + "kategori = '" + this.kategori + "', "
                + "penerbit = '" + this.penerbit + "', "
                + "penulis '" + this.penulis + "' "
                + "WHERE idkategori = '" + this.idbuku + "'";
        DBHelper.executeQuery(SQL);
    }
}

    
    public void delete(){
        String SQL = "DELETE FROM buku WHERE idbuku = '" + this.idbuku + "'";
        DBHelper.executeQuery(SQL);
    }
    
}
