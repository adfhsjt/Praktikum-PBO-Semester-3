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
public class Peminjaman {

    private int idpeminjaman;
    private Pegawai pegawai = new Pegawai();
    private Buku buku = new Buku();
    private Anggota anggota = new Anggota();
    private String tglpeminjaman, tglpengembalian;

    public Peminjaman() {
    }

    public Peminjaman(Pegawai pegawai, Buku buku, Anggota anggota, String tglpeminjaman, String tglpengembalian) {
        this.pegawai = pegawai;
        this.buku = buku;
        this.anggota = anggota;
        this.tglpeminjaman = tglpeminjaman;
        this.tglpengembalian = tglpengembalian;
    }

    public int getIdpeminjaman() {
        return idpeminjaman;
    }

    public String getTglpengembalian() {
        return tglpengembalian;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public Buku getBuku() {
        return buku;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public String getTglpeminjaman() {
        return tglpeminjaman;
    }

    public void setTglpengembalian(String tglpengembalian) {
        this.tglpengembalian = tglpengembalian;
    }
    
    public void setIdpeminjaman(int idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public void setTglpeminjaman(String tglpeminjaman) {
        this.tglpeminjaman = tglpeminjaman;
    }

    public Peminjaman getById(int id) {
        Peminjaman p = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.idpeminjaman AS idpeminjaman, "
                + "p.tanggalpinjam AS tanggalpinjam, " // Added missing comma
                + "s.idpegawai AS idpegawai, "
                + "s.nama AS namapegawai, "
                + "s.alamat AS alamatpegawai, "
                + "s.notelp AS teleponpegawai, "
                + "s.jabatan AS jabatanpegawai, "
                + "s.username AS usernamepegawai, "
                + "s.password AS passwordpegawai, "
                + "a.idanggota AS idanggota, "
                + "a.nama AS namaanggota, "
                + "a.alamat AS alamatanggota, "
                + "a.telepon AS teleponanggota, "
                + "b.idbuku AS idbuku, "
                + "b.idkategori AS idkategori, "
                + "b.judul AS judul, "
                + "b.penerbit AS penerbit, "
                + "b.penulis AS penulis "
                + "FROM peminjaman p " // Removed extra comma
                + "LEFT JOIN pegawai s ON p.idpegawai = s.idpegawai "
                + "LEFT JOIN anggota a ON p.idanggota = a.idanggota "
                + "LEFT JOIN buku b ON p.idbuku = b.idbuku "
                + "WHERE p.idpeminjaman = '" + id + "' AND p.tanggalkembali IS NULL");

        try {
            while (rs.next()) {
                p = new Peminjaman();
                p.setIdpeminjaman(rs.getInt("idpeminjaman"));
                p.setTglpeminjaman(rs.getString("tanggalpinjam"));
                p.getPegawai().setIdpegawai(rs.getInt("idpegawai"));
                p.getPegawai().setNama(rs.getString("namapegawai"));
                p.getPegawai().setAlamat(rs.getString("alamatpegawai"));
                p.getPegawai().setNotelp(rs.getString("teleponpegawai"));
                p.getPegawai().setJabatan(rs.getString("jabatanpegawai"));
                p.getPegawai().setUsername(rs.getString("usernamepegawai"));
                p.getPegawai().setPassword(rs.getString("passwordpegawai"));
                p.getAnggota().setIdanggota(rs.getInt("idanggota"));
                p.getAnggota().setNama(rs.getString("namaanggota"));
                p.getAnggota().setAlamat(rs.getString("alamatanggota"));
                p.getAnggota().setTelepon(rs.getString("teleponanggota"));
                p.getBuku().setIdbuku(rs.getInt("idbuku"));
                p.getBuku().getKategori().setIdkategori(rs.getInt("idkategori"));
                p.getBuku().setJudul(rs.getString("judul"));
                p.getBuku().setPenerbit(rs.getString("penerbit"));
                p.getBuku().setPenulis(rs.getString("penulis"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList<>();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.idpeminjaman AS idpeminjaman, "
                + "p.tanggalpinjam AS tanggalpinjam, "
                + "s.idpegawai AS idpegawai, "
                + "s.nama AS namapegawai, "
                + "s.alamat AS alamatpegawai, "
                + "s.notelp AS teleponpegawai, "
                + "s.jabatan AS jabatanpegawai, "
                + "s.username AS usernamepegawai, "
                + "s.password AS passwordpegawai, "
                + "a.idanggota AS idanggota, "
                + "a.nama AS namaanggota, "
                + "a.alamat AS alamatanggota, "
                + "a.telepon AS teleponanggota, "
                + "b.idbuku AS idbuku, "
                + "b.idkategori AS idkategori, "
                + "b.judul AS judul, "
                + "b.penerbit AS penerbit, "
                + "b.penulis AS penulis "
                + "FROM peminjaman p "
                + "LEFT JOIN pegawai s ON p.idpegawai = s.idpegawai "
                + "LEFT JOIN anggota a ON p.idanggota = a.idanggota "
                + "LEFT JOIN buku b ON p.idbuku = b.idbuku "
                + "WHERE p.tanggalkembali IS NULL");

        try {
            while (rs.next()) {
                Peminjaman p = new Peminjaman();
                p.setIdpeminjaman(rs.getInt("idpeminjaman"));
                p.setTglpeminjaman(rs.getString("tanggalpinjam"));
                p.getPegawai().setIdpegawai(rs.getInt("idpegawai"));
                p.getPegawai().setNama(rs.getString("namapegawai"));
                p.getPegawai().setAlamat(rs.getString("alamatpegawai"));
                p.getPegawai().setNotelp(rs.getString("teleponpegawai"));
                p.getPegawai().setJabatan(rs.getString("jabatanpegawai"));
                p.getPegawai().setUsername(rs.getString("usernamepegawai"));
                p.getPegawai().setPassword(rs.getString("passwordpegawai"));
                p.getAnggota().setIdanggota(rs.getInt("idanggota"));
                p.getAnggota().setNama(rs.getString("namaanggota"));
                p.getAnggota().setAlamat(rs.getString("alamatanggota"));
                p.getAnggota().setTelepon(rs.getString("teleponanggota"));
                p.getBuku().setIdbuku(rs.getInt("idbuku"));
                p.getBuku().getKategori().setIdkategori(rs.getInt("idkategori"));
                p.getBuku().setJudul(rs.getString("judul"));
                p.getBuku().setPenerbit(rs.getString("penerbit"));
                p.getBuku().setPenulis(rs.getString("penulis"));
                ListPeminjaman.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPeminjaman;
    }

    public ArrayList<Peminjaman> search(String keyword) {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList<>();
        String sql = "SELECT "
                + "p.idpeminjaman AS idpeminjaman, "
                + "p.tanggalpinjam AS tanggalpinjam "
                + "s.idpegawai AS idpegawai, "
                + "s.nama AS namapegawai, "
                + "s.alamat AS alamatpegawai, "
                + "s.notelp AS teleponpegawai, "
                + "s.jabatan AS jabatanpegawai, "
                + "s.username AS usernamepegawai, "
                + "s.password AS passwordpegawai, "
                + "a.idanggota AS idanggota, "
                + "a.nama AS namaanggota, "
                + "a.alamat AS alamatanggota, "
                + "a.telepon AS teleponanggota, "
                + "b.idbuku AS idbuku, "
                + "b.idkategori AS idkategori, "
                + "b.judul AS judul, "
                + "b.penerbit AS penerbit, "
                + "b.penulis AS penulis, "
                + "FROM peminjaman p "
                + "LEFT JOIN pegawai s ON p.idpegawai = s.idpegawai "
                + "LEFT JOIN anggota a ON p.idanggota = a.idanggota "
                + "LEFT JOIN buku b ON p.idbuku = b.idbuku "
                + "WHERE p.idpeminjaman LIKE '%" + keyword + "%' OR ";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Peminjaman p = new Peminjaman();
                p.setIdpeminjaman(rs.getInt("idpeminjaman"));
                p.setTglpeminjaman(rs.getString("tanggalpinjam"));
                p.getPegawai().setIdpegawai(rs.getInt("idpegawai"));
                p.getPegawai().setNama(rs.getString("namapegawai"));
                p.getPegawai().setAlamat(rs.getString("alamatpegawai"));
                p.getPegawai().setNotelp(rs.getString("teleponpegawai"));
                p.getPegawai().setJabatan(rs.getString("jabatanpegawai"));
                p.getPegawai().setUsername(rs.getString("usernamepegawai"));
                p.getPegawai().setPassword(rs.getString("passwordpegawai"));
                p.getAnggota().setIdanggota(rs.getInt("idanggota"));
                p.getAnggota().setNama(rs.getString("namaanggota"));
                p.getAnggota().setAlamat(rs.getString("alamatanggota"));
                p.getAnggota().setTelepon(rs.getString("teleponanggota"));
                p.getBuku().setIdbuku(rs.getInt("idbuku"));
                p.getBuku().getKategori().setIdkategori(rs.getInt("idkategori"));
                p.getBuku().setJudul(rs.getString("judul"));
                p.getBuku().setPenerbit(rs.getString("penerbit"));
                p.getBuku().setPenulis(rs.getString("penulis"));
                ListPeminjaman.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPeminjaman;
    }

    public void save() {
        if (getIdpeminjaman() == 0) {
            String insertSQL = "INSERT INTO peminjaman (idpegawai, idanggota, idbuku, tanggalpinjam) VALUES ("
                    + "     '" + this.getPegawai().getIdpegawai() + "', "
                    + "     '" + this.getAnggota().getIdanggota() + "', "
                    + "     '" + this.getBuku().getIdbuku() + "', "
                    + "     '" + this.tglpeminjaman + "');";
            String updateSQL = "UPDATE buku SET status = 1 WHERE idbuku = '" + this.getBuku().getIdbuku() + "';";

            this.idpeminjaman = DBHelper.insertQueryGetId(insertSQL);

            DBHelper.executeQuery(updateSQL);
        } else {
            String SQL = "UPDATE peminjaman SET "
                    + "tanggalpinjam = '" + this.tglpeminjaman + "', "
                    + "idpegawai = '" + this.getPegawai().getIdpegawai() + "', "
                    + "idanggota = '" + this.getAnggota().getIdanggota() + "', "
                    + "idbuku = '" + this.getBuku().getIdbuku() + "' "
                    + "WHERE idpeminjaman = '" + this.idpeminjaman + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM peminjaman WHERE idpeminjaman = '" + this.idpeminjaman + "'; "
                + "UPDATE buku SET status = 0 WHERE idbuku = '" + this.getBuku().getIdbuku() + "'; ";
        DBHelper.executeQuery(SQL);
    }

}
