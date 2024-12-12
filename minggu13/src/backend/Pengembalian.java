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
public class Pengembalian {
    private int idpeminjaman;
    private Pegawai pegawai = new Pegawai();
    private Buku buku = new Buku();
    private Anggota anggota = new Anggota();
    private String tglpeminjaman, tglpengembalian;

    public Pengembalian() {
    }

    public Pengembalian(int idpeminjaman, String tglpeminjaman, String tglpengembalian) {
        this.idpeminjaman = idpeminjaman;
        this.tglpeminjaman = tglpeminjaman;
        this.tglpengembalian = tglpengembalian;
    }

    public int getIdpeminjaman() {
        return idpeminjaman;
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

    public String getTglpengembalian() {
        return tglpengembalian;
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

    public void setTglpengembalian(String tglpengembalian) {
        this.tglpengembalian = tglpengembalian;
    }

    public Pengembalian getById(int id) {
        Pengembalian p = new Pengembalian();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.idpeminjaman AS idpeminjaman, "
                + "p.tanggalpinjam AS tanggalpinjam, " // Added missing comma
                + "p.tanggalkembali AS tanggalkembali, "
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
                + "WHERE p.idpeminjaman = '" + id + "' p.tanggalkembali IS NOT NULL");

        try {
            while (rs.next()) {
                p = new Pengembalian();
                p.setIdpeminjaman(rs.getInt("idpeminjaman"));
                p.setTglpeminjaman(rs.getString("tanggalpinjam"));
                p.setTglpengembalian(rs.getString("tanggalkembali"));
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

    public ArrayList<Pengembalian> getAll() {
        ArrayList<Pengembalian> ListPengembalian = new ArrayList<>();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.idpeminjaman AS idpeminjaman, "
                + "p.tanggalpinjam AS tanggalpinjam, "
                + "p.tanggalkembali AS tanggalkembali, "
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
                + "WHERE p.tanggalkembali IS NOT NULL");

        try {
            while (rs.next()) {
                Pengembalian p = new Pengembalian();
                p.setIdpeminjaman(rs.getInt("idpeminjaman"));
                p.setTglpeminjaman(rs.getString("tanggalpinjam"));
                p.setTglpengembalian(rs.getString("tanggalkembali"));
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
                ListPengembalian.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPengembalian;
    }

    public ArrayList<Pengembalian> search(String keyword) {
        ArrayList<Pengembalian> ListPengembalian = new ArrayList<>();
        String sql = "SELECT "
                + "p.idpeminjaman AS idpeminjaman, "
                + "p.tanggalpinjam AS tanggalpinjam, "
                + "p.tanggalkembali AS tanggalkembali, "
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
                Pengembalian p = new Pengembalian();
                p.setIdpeminjaman(rs.getInt("idpeminjaman"));
                p.setTglpeminjaman(rs.getString("tanggalpinjam"));
                p.setTglpeminjaman(rs.getString("tanggalkembali"));
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
                ListPengembalian.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPengembalian;
    }

    public void save() {
        String updateSQL = "UPDATE buku SET status = 0 WHERE idbuku = '" + this.getBuku().getIdbuku() + "';";
        String SQL = "UPDATE peminjaman SET "
                + "tanggalkembali = '" + this.tglpengembalian + "', "
                + "idpegawai = '" + this.getPegawai().getIdpegawai() + "', "
                + "idanggota = '" + this.getAnggota().getIdanggota() + "', "
                + "idbuku = '" + this.getBuku().getIdbuku() + "' "
                + "WHERE idpeminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(SQL);
        DBHelper.executeQuery(updateSQL);

    }

    public void delete(){
        String SQL = "DELETE FROM peminjaman WHERE idpeminjaman = '" + this.idpeminjaman + "'; "
                + "UPDATE buku SET status = 0 WHERE idbuku = '" + this.getBuku().getIdbuku() + "'; ";
        DBHelper.executeQuery(SQL);
    }


}
