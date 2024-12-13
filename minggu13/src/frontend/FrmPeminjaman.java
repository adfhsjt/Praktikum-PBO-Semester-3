/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.*;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ahmad
 */
public class FrmPeminjaman extends javax.swing.JFrame {

    /**
     * Creates new form FrmPeminjaman
     */
    public FrmPeminjaman() {
        initComponents();
        tampilkanData();
        kosongkanForm();
    }

    public void kosongkanForm() {
        txtIdPeminjaman.setText("0");
        txtIdPegawai.setText("");
        txtIdAnggota.setText("");
        txtIdBuku.setText("");
        txtIdBuku.setEnabled(true);
        txtTanggalPinjam.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        lblNamaAnggota.setText("");
        lblNamaPegawai.setText("");
        lblJudulBuku.setText("");

    }

    public void tampilkanData() {
        String[] kolom = {"No. Peminjaman", "Pegawai", "Anggota", "Judul", "Tanggal Pinjam"};
        ArrayList<Peminjaman> list = new Peminjaman().getAll();
        Object rowData[] = new Object[5];

        tblPeminjaman.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getIdpeminjaman();
            rowData[1] = list.get(i).getPegawai().getNama();
            rowData[2] = list.get(i).getAnggota().getNama();
            rowData[3] = list.get(i).getBuku().getJudul();
            rowData[4] = list.get(i).getTglpeminjaman();

            ((DefaultTableModel) tblPeminjaman.getModel()).addRow(rowData);

        }
    }

    public void cari(String keyword) {
        String[] kolom = {"No. Peminjaman", "Nama Pegawai", "Nama Anggota", "Judul Buku", "Tanggal Peminjaman"};
        ArrayList<Peminjaman> list = new Peminjaman().search(keyword);
        Object rowData[] = new Object[5];

        tblPeminjaman.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Peminjaman p : list) {
            rowData[0] = p.getIdpeminjaman();
            rowData[1] = p.getPegawai().getNama();
            rowData[2] = p.getAnggota().getNama();
            rowData[3] = p.getBuku().getJudul();
            rowData[4] = p.getTglpeminjaman();

            ((DefaultTableModel) tblPeminjaman.getModel()).addRow(rowData);

        }
    }

    public Pegawai cariPegawai(String id) {
        String query = "SELECT idpegawai, nama, alamat, notelp, jabatan FROM pegawai WHERE idpegawai = '" + id + "'";
        ResultSet rs = DBHelper.selectQuery(query);
        Pegawai pegawai = null;

        try {
            if (rs.next()) {
                pegawai = new Pegawai();
                pegawai.setIdpegawai(rs.getInt("idpegawai"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.setAlamat(rs.getString("alamat"));
                pegawai.setNotelp(rs.getString("notelp"));
                pegawai.setJabatan(rs.getString("jabatan"));
            } else {
                txtIdPegawai.setText("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return pegawai;
    }

    public Anggota cariAnggota(String id) {
        String query = "SELECT idanggota, nama, alamat, telepon FROM anggota WHERE idanggota = '" + id + "'";
        ResultSet rs = DBHelper.selectQuery(query);
        Anggota anggota = null;

        try {
            if (rs.next()) {
                anggota = new Anggota();
                anggota.setIdanggota(rs.getInt("idanggota"));
                anggota.setNama(rs.getString("nama"));
                anggota.setAlamat(rs.getString("alamat"));
                anggota.setTelepon(rs.getString("telepon"));
            } else {
                // Clear the txtIdAnggota field if no record is found
                txtIdAnggota.setText("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return anggota;
    }

    public Buku cariBuku(String id) {
        String query = "SELECT b.idbuku, b.judul, b.penerbit, b.penulis, b.status, "
                + "k.idkategori, k.nama AS namakategori, k.keterangan "
                + "FROM buku b "
                + "LEFT JOIN kategori k ON b.idkategori = k.idkategori "
                + "WHERE b.idbuku = '" + id + "'";
        ResultSet rs = DBHelper.selectQuery(query);
        Buku buku = null;

        try {
            if (rs.next()) {
                buku = new Buku();
                buku.setIdbuku(rs.getInt("idbuku"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setStatus(rs.getInt("status"));

                Kategori kategori = new Kategori();
                kategori.setIdkategori(rs.getInt("idkategori"));
                kategori.setNama(rs.getString("namakategori"));
                kategori.setKeterangan(rs.getString("keterangan"));

                buku.setKategori(kategori);
            } else {
                txtIdBuku.setText("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return buku;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeminjaman = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblIdPegawai = new javax.swing.JLabel();
        lblIdBuku = new javax.swing.JLabel();
        lblIdAnggota = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnTambahBaru = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtIdPeminjaman = new javax.swing.JTextField();
        txtTanggalPinjam = new javax.swing.JTextField();
        txtIdAnggota = new javax.swing.JTextField();
        txtIdBuku = new javax.swing.JTextField();
        txtIdPegawai = new javax.swing.JTextField();
        cariPegawai = new javax.swing.JButton();
        lblNamaPegawai = new javax.swing.JLabel();
        lblNamaAnggota = new javax.swing.JLabel();
        lblJudulBuku = new javax.swing.JLabel();
        cariAnggota = new javax.swing.JButton();
        cariJudul1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 430));
        setSize(new java.awt.Dimension(500, 1000));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("FORM PEMINJAMAN");

        tblPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeminjaman);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("No. Urut Peminjaman");

        lblIdPegawai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdPegawai.setText("ID Pegawai");

        lblIdBuku.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdBuku.setText("ID Buku");

        lblIdAnggota.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdAnggota.setText("ID Anggota");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tanggal Pinjam");

        btnTambahBaru.setText("Tambah Baru");
        btnTambahBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBaruActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtIdPeminjaman.setEnabled(false);

        txtTanggalPinjam.setEnabled(false);

        cariPegawai.setText("Cari");
        cariPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPegawaiActionPerformed(evt);
            }
        });

        lblNamaPegawai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNamaPegawai.setText("Nama Pegawai");

        lblNamaAnggota.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNamaAnggota.setText("Nama Anggota");

        lblJudulBuku.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblJudulBuku.setText("Judul Buku");

        cariAnggota.setText("Cari");
        cariAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariAnggotaActionPerformed(evt);
            }
        });

        cariJudul1.setText("Cari");
        cariJudul1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariJudul1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cariPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNamaPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblIdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(txtIdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cariJudul1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnTambahBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(txtIdPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIdPegawai)
                        .addGap(18, 18, 18)
                        .addComponent(lblIdAnggota))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(txtIdAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIdPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cariPegawai)
                        .addGap(4, 4, 4)
                        .addComponent(cariAnggota))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblNamaPegawai)
                        .addGap(13, 13, 13)
                        .addComponent(lblNamaAnggota)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblIdBuku))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cariJudul1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblJudulBuku)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambahBaru)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cariPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPegawaiActionPerformed
        // TODO add your handling code here:
        if (txtIdPegawai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi ID Pegawai dulu.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            lblNamaPegawai.setText("Wajib diisi!");
        } else {
            // Check if the Pegawai exists in the database
            Pegawai p = cariPegawai(txtIdPegawai.getText());
            if (p != null) {
                JOptionPane.showMessageDialog(null, "Data Pegawai Ditemukan.\n"
                        + "ID Pegawai: " + p.getIdpegawai() + "\n"
                        + "Nama: " + p.getNama() + "\n"
                        + "Alamat: " + p.getAlamat() + "\n"
                        + "Telepon: " + p.getNotelp() + "\n"
                        + "Jabatan: " + p.getJabatan(),
                        "Sukses", JOptionPane.INFORMATION_MESSAGE);
                lblNamaPegawai.setText(p.getNama());

            } else {
                JOptionPane.showMessageDialog(null, "Pegawai tidak ditemukan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                lblNamaPegawai.setText("Pegawai tidak ditemukan");
            }
        }
    }//GEN-LAST:event_cariPegawaiActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if (txtIdPegawai.getText().isEmpty() || txtIdBuku.getText().isEmpty() || txtIdAnggota.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lengkapi data terlebih dahulu.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            kosongkanForm();
        } else {

            // Check if the Pegawai exists in the database
            Pegawai pg = cariPegawai(txtIdPegawai.getText());
            Anggota a = cariAnggota(txtIdAnggota.getText());
            Buku b = cariBuku(txtIdBuku.getText());
            if (pg != null && a != null && b != null) {
                if (b.getStatus() == 0) {
                    Peminjaman p = new Peminjaman();
                    p.setIdpeminjaman(Integer.parseInt(txtIdPeminjaman.getText()));
                    p.setPegawai(pg);
                    p.setAnggota(a);
                    p.setBuku(b);
                    p.setTglpeminjaman(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

                    p.save();
                    txtIdPeminjaman.setText(Integer.toString(p.getIdpeminjaman()));
                    tampilkanData();
                    JOptionPane.showMessageDialog(null, "Peminjaman Berhasil.\n", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showInternalMessageDialog(null, "Maaf, buku sedang dipinjam customer lain.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak valid, periksa kembali.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                kosongkanForm();
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTambahBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBaruActionPerformed
        // TODO add your handling code here:
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnTambahBaruActionPerformed

    private void cariAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariAnggotaActionPerformed
        // TODO add your handling code here:
        if (txtIdAnggota.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi ID Anggota dulu.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            lblNamaAnggota.setText("Wajib diisi!");
        } else {
            Anggota a = cariAnggota(txtIdAnggota.getText());
            if (a != null) {
                JOptionPane.showMessageDialog(null, "Data Anggota.\n"
                        + "ID Anggota: " + a.getIdanggota() + "\n"
                        + "Nama: " + a.getNama() + "\n"
                        + "Alamat: " + a.getAlamat() + "\n"
                        + "Telepon: " + a.getTelepon(),
                        "Sukses", JOptionPane.INFORMATION_MESSAGE);
                lblNamaAnggota.setText(a.getNama());
            } else {
                JOptionPane.showMessageDialog(null, "Anggota tidak ditemukan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                lblNamaAnggota.setText("Anggota tidak ditemukan");
            }
        }
    }//GEN-LAST:event_cariAnggotaActionPerformed

    private void tblPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeminjamanMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblPeminjaman.getModel();
        int row = tblPeminjaman.getSelectedRow();
        Peminjaman p = new Peminjaman();

        p = p.getById(Integer.parseInt(model.getValueAt(row, 0).toString()));

        txtIdPeminjaman.setText(String.valueOf(p.getIdpeminjaman()));
        txtIdPegawai.setText(String.valueOf(p.getPegawai().getIdpegawai()));
        txtIdAnggota.setText(String.valueOf(p.getAnggota().getIdanggota()));
        txtIdBuku.setText(String.valueOf(p.getBuku().getIdbuku()));
        txtIdBuku.setEnabled(false);
        txtTanggalPinjam.setText(p.getTglpeminjaman());
    }//GEN-LAST:event_tblPeminjamanMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblPeminjaman.getModel();
        int row = tblPeminjaman.getSelectedRow();

        Peminjaman p = new Peminjaman().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        p.delete();
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void cariJudul1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariJudul1ActionPerformed
        // TODO add your handling code here:
        if (txtIdBuku.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi ID Buku dulu.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            lblJudulBuku.setText("Wajib diisi!");
        } else {
            Buku b = cariBuku(txtIdBuku.getText());
            if (b != null) {
                if (b.getStatus() == 0) {
                    JOptionPane.showMessageDialog(null, "Data Buku.\n"
                            + "ID Buku: " + b.getIdbuku() + "\n"
                            + "Judul: " + b.getJudul() + "\n"
                            + "Penerbit: " + b.getPenerbit() + "\n"
                            + "Penulis: " + b.getPenulis() + "\n"
                            + "Kategori: " + b.getKategori().getNama(),
                            "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    lblJudulBuku.setText(b.getJudul());
                } else {
                    JOptionPane.showInternalMessageDialog(null, "Maaf, buku sedang dipinjam customer lain.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Buku tidak ditemukan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                lblJudulBuku.setText("Buku tidak ditemukan");
            }
        }

    }//GEN-LAST:event_cariJudul1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahBaru;
    private javax.swing.JButton cariAnggota;
    private javax.swing.JButton cariJudul1;
    private javax.swing.JButton cariPegawai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdAnggota;
    private javax.swing.JLabel lblIdBuku;
    private javax.swing.JLabel lblIdPegawai;
    private javax.swing.JLabel lblJudulBuku;
    private javax.swing.JLabel lblNamaAnggota;
    private javax.swing.JLabel lblNamaPegawai;
    private javax.swing.JTable tblPeminjaman;
    private javax.swing.JTextField txtIdAnggota;
    private javax.swing.JTextField txtIdBuku;
    private javax.swing.JTextField txtIdPegawai;
    private javax.swing.JTextField txtIdPeminjaman;
    private javax.swing.JTextField txtTanggalPinjam;
    // End of variables declaration//GEN-END:variables
}
