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

    private Pegawai pegawai = new Pegawai();
    private Anggota anggota = new Anggota();
    private Buku buku = new Buku();

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
        txtTanggalPinjam.setText("yyyy-MM-dd");
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
        cariJudul = new javax.swing.JButton();
        lblNamaPegawai = new javax.swing.JLabel();
        lblNamaAnggota = new javax.swing.JLabel();
        lblJudulBuku = new javax.swing.JLabel();
        cariAnggota = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 7));
        setPreferredSize(new java.awt.Dimension(505, 423));
        setSize(new java.awt.Dimension(500, 1000));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("FORM PEMINJAMAN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(162, 13, 179, 25);

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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 263, 683, 147);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("No. Urut Peminjaman");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 47, 122, 16);

        lblIdPegawai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdPegawai.setText("ID Pegawai");
        getContentPane().add(lblIdPegawai);
        lblIdPegawai.setBounds(12, 75, 90, 16);

        lblIdBuku.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdBuku.setText("ID Buku");
        getContentPane().add(lblIdBuku);
        lblIdBuku.setBounds(12, 138, 80, 16);

        lblIdAnggota.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdAnggota.setText("ID Anggota");
        getContentPane().add(lblIdAnggota);
        lblIdAnggota.setBounds(12, 109, 90, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tanggal Pinjam");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(12, 177, 110, 16);

        btnTambahBaru.setText("Tambah Baru");
        btnTambahBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBaruActionPerformed(evt);
            }
        });
        getContentPane().add(btnTambahBaru);
        btnTambahBaru.setBounds(12, 220, 103, 25);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan);
        btnSimpan.setBounds(133, 220, 103, 25);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus);
        btnHapus.setBounds(254, 220, 103, 25);

        txtIdPeminjaman.setEnabled(false);
        getContentPane().add(txtIdPeminjaman);
        txtIdPeminjaman.setBounds(152, 44, 112, 30);

        txtTanggalPinjam.setEnabled(false);
        getContentPane().add(txtTanggalPinjam);
        txtTanggalPinjam.setBounds(152, 174, 168, 30);
        getContentPane().add(txtIdAnggota);
        txtIdAnggota.setBounds(152, 105, 112, 30);
        getContentPane().add(txtIdBuku);
        txtIdBuku.setBounds(152, 135, 112, 30);
        getContentPane().add(txtIdPegawai);
        txtIdPegawai.setBounds(152, 76, 112, 30);

        cariPegawai.setText("Cari");
        cariPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPegawaiActionPerformed(evt);
            }
        });
        getContentPane().add(cariPegawai);
        cariPegawai.setBounds(271, 75, 65, 25);

        cariJudul.setText("Cari");
        cariJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariJudulActionPerformed(evt);
            }
        });
        getContentPane().add(cariJudul);
        cariJudul.setBounds(271, 142, 65, 25);

        lblNamaPegawai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNamaPegawai.setText("Nama Pegawai");
        getContentPane().add(lblNamaPegawai);
        lblNamaPegawai.setBounds(354, 79, 160, 16);

        lblNamaAnggota.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNamaAnggota.setText("Nama Anggota");
        getContentPane().add(lblNamaAnggota);
        lblNamaAnggota.setBounds(354, 108, 160, 16);

        lblJudulBuku.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblJudulBuku.setText("Judul Buku");
        getContentPane().add(lblJudulBuku);
        lblJudulBuku.setBounds(354, 146, 180, 16);

        cariAnggota.setText("Cari");
        cariAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariAnggotaActionPerformed(evt);
            }
        });
        getContentPane().add(cariAnggota);
        cariAnggota.setBounds(271, 104, 65, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cariPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPegawaiActionPerformed
        // TODO add your handling code here:
        if (txtIdPegawai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi ID Pegawai dulu.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    lblNamaPegawai.setText("Wajib diisi!");
                }
            });
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
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        lblNamaPegawai.setText(p.getNama());
                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "Pegawai tidak ditemukan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        lblNamaPegawai.setText("Pegawai tidak ditemukan");
                    }
                });
            }
        }
    }//GEN-LAST:event_cariPegawaiActionPerformed

    private void cariJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariJudulActionPerformed
        // TODO add your handling code here:
        if (txtIdBuku.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi ID Buku dulu.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    lblJudulBuku.setText("Wajib diisi!");
                }
            });
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
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            lblJudulBuku.setText(b.getJudul());
                        }
                    });
                } else {
                    JOptionPane.showInternalMessageDialog(null, "Maaf, buku sedang dipinjam customer lain.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Buku tidak ditemukan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        lblJudulBuku.setText("Buku tidak ditemukan");
                    }
                });
            }
        }
    }//GEN-LAST:event_cariJudulActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblPeminjaman.getModel();
        int row = tblPeminjaman.getSelectedRow();

        Peminjaman p = new Peminjaman().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        p.delete();
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnHapusActionPerformed

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
                    pegawai.setIdpegawai(Integer.parseInt(txtIdPegawai.getText()));
                    anggota.setIdanggota(Integer.parseInt(txtIdAnggota.getText()));
                    buku.setIdbuku(Integer.parseInt(txtIdBuku.getText()));
                    p.setPegawai(pegawai);
                    p.setAnggota(anggota);
                    p.setBuku(buku);
                    p.setTglpeminjaman(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

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
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    lblNamaAnggota.setText("Wajib diisi!");
                }
            });
        } else {
            Anggota a = cariAnggota(txtIdAnggota.getText());
            if (a != null) {
                JOptionPane.showMessageDialog(null, "Data Anggota.\n"
                        + "ID Anggota: " + a.getIdanggota() + "\n"
                        + "Nama: " + a.getNama() + "\n"
                        + "Alamat: " + a.getAlamat() + "\n"
                        + "Telepon: " + a.getTelepon(),
                        "Sukses", JOptionPane.INFORMATION_MESSAGE);
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        lblNamaAnggota.setText(a.getNama());
                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "Anggota tidak ditemukan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        lblNamaAnggota.setText("Anggota tidak ditemukan");
                    }
                });
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
    private javax.swing.JButton cariJudul;
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
