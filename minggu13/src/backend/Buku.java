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

    private int idbuku, status;
    private Kategori kategori = new Kategori();
    private String judul, penerbit, penulis;

    public Buku() {
    }

    public Buku(Kategori kategori, String judul, String penerbit, String penulis, int status) {
        this.kategori = kategori;
        this.judul = judul;
        this.penerbit = penerbit;
        this.penulis = penulis;
        this.status = status;
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

    public int getStatus() {
        return status;
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

    public void setStatus(int status) {
        this.status = status;
    }

    public Buku getById(int id) {
        Buku bk = new Buku();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "b.idbuku AS idbuku, "
                + "b.judul AS judul, "
                + "b.penerbit as penerbit, "
                + "b.penulis as penulis, "
                + "b.status as status, "
                + "k.idkategori AS idkategori, "
                + "k.nama AS nama, "
                + "k.keterangan AS keterangan "
                + "FROM buku b "
                + "LEFT JOIN kategori k ON b.idkategori = k.idkategori "
                + "WHERE b.idbuku = '" + id + "'");

        try {
            while (rs.next()) {
                bk = new Buku();
                bk.setIdbuku(rs.getInt("idbuku"));
                bk.getKategori().setIdkategori(rs.getInt("idkategori"));
                bk.getKategori().setNama(rs.getString("nama"));
                bk.getKategori().setKeterangan(rs.getString("keterangan"));
                bk.setJudul(rs.getString("judul"));
                bk.setPenerbit(rs.getString("penerbit"));
                bk.setPenulis(rs.getString("penulis"));
                bk.setStatus(rs.getInt("status"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bk;
    }

    public ArrayList<Buku> getAll() {
        ArrayList<Buku> ListBuku = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "b.idbuku AS idbuku, "
                + "b.judul AS judul, "
                + "b.penerbit as penerbit, "
                + "b.penulis as penulis, "
                + "b.status as status, "
                + "k.idkategori AS idkategori, "
                + "k.nama AS nama, "
                + "k.keterangan AS keterangan "
                + "FROM buku b "
                + "LEFT JOIN kategori k ON b.idkategori = k.idkategori");

        try {
            while (rs.next()) {
                Buku bk = new Buku();
                bk.setIdbuku(rs.getInt("idbuku"));
                bk.getKategori().setIdkategori(rs.getInt("idkategori"));
                bk.getKategori().setNama(rs.getString("nama"));
                bk.getKategori().setKeterangan(rs.getString("keterangan"));
                bk.setJudul(rs.getString("judul"));
                bk.setPenerbit(rs.getString("penerbit"));
                bk.setPenulis(rs.getString("penulis"));
                bk.setStatus(rs.getInt("status"));

                ListBuku.add(bk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListBuku;
    }

    public ArrayList<Buku> search(String keyword) {
        ArrayList<Buku> ListBuku = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "b.idbuku AS idbuku, "
                + "b.judul AS judul, "
                + "b.penerbit as penerbit, "
                + "b.penulis as penulis, "
                + "b.status as status, "
                + "k.idkategori AS idkategori, "
                + "k.nama AS nama, "
                + "k.keterangan AS keterangan "
                + "FROM buku b "
                + "LEFT JOIN kategori k ON b.idkategori = k.idkategori "
                + "WHERE b.judul LIKE '%" + keyword + "%' "
                + "OR b.penerbit LIKE '%" + keyword + "%' "
                + "OR b.penulis LIKE '%" + keyword + "%' ");

        try {
            while (rs.next()) {
                Buku bk = new Buku();
                bk.setIdbuku(rs.getInt("idbuku"));
                bk.getKategori().setIdkategori(rs.getInt("idkategori"));
                bk.getKategori().setNama(rs.getString("nama"));
                bk.getKategori().setKeterangan(rs.getString("keterangan"));
                bk.setJudul(rs.getString("judul"));
                bk.setPenerbit(rs.getString("penerbit"));
                bk.setPenulis(rs.getString("penulis"));
                bk.setStatus(rs.getInt("status"));

                ListBuku.add(bk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListBuku;
    }

    public void save() {
        if (getById(idbuku).getIdbuku() == 0) {
            String SQL = "INSERT INTO buku (judul, idkategori, penerbit, penulis) VALUES ("
                    + "     '" + this.judul + "', "
                    + "     '" + this.getKategori().getIdkategori() + "', "
                    + "     '" + this.penerbit + "', "
                    + "     '" + this.penulis + "'"
                    + "     )";
            this.idbuku = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE buku SET"
                    + "     judul = '" + this.judul + "', "
                    + "     idkategori = '" + this.getKategori().getIdkategori() + "', "
                    + "     penerbit ='" + this.penerbit + "', "
                    + "     penulis = '" + this.penulis + "' "
                    + "     WHERE idbuku = '" + this.idbuku + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM buku WHERE idbuku = '" + this.idbuku + "'";
        DBHelper.executeQuery(SQL);
    }

}
