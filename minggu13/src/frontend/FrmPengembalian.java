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
public class FrmPengembalian extends javax.swing.JFrame {

    /**
     * Creates new form FrmPengembalian
     */
    public FrmPengembalian() {
        initComponents();
        tampilkanData();
        kosongkanForm();
    }

    public void kosongkanForm() {
        txtIdPeminjaman.setText("");
        txtIdPegawai.setText("");
        txtNamaPegawai.setText("");
        txtIdAnggota.setText("");
        txtNamaAnggota.setText("");
        txtIdBuku.setText("");
        txtJudul.setText("");
        txtTanggalPinjam.setText("yyyy-MM-dd");
        txtTanggalKembali.setText("yyyy-MM-dd");
    }

    public void tampilkanData() {
        String[] kolom = {"No. Peminjaman", "Pegawai", "Anggota", "Judul", "Tanggal Pinjam", "Tanggal Kembali"};
        ArrayList<Pengembalian> list = new Pengembalian().getAll();
        Object rowData[] = new Object[6];

        tblPengembalian.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getIdpeminjaman();
            rowData[1] = list.get(i).getPegawai().getNama();
            rowData[2] = list.get(i).getAnggota().getNama();
            rowData[3] = list.get(i).getBuku().getJudul();
            rowData[4] = list.get(i).getTglpeminjaman();
            rowData[5] = list.get(i).getTglpengembalian();

            ((DefaultTableModel) tblPengembalian.getModel()).addRow(rowData);

        }
    }

    public Peminjaman cariPeminjaman(String id) {
        String query = "SELECT "
                + "p.idpeminjaman AS idpeminjaman, "
                + "p.tanggalpinjam AS tanggalpinjam, "
                + "p.tanggalkembali AS tanggalkembali, "
                + "s.idpegawai AS idpegawai, "
                + "s.nama AS namapegawai, "
                + "s.alamat AS alamatpegawai, "
                + "s.notelp AS teleponpegawai, "
                + "s.jabatan AS jabatan, "
                + "s.username AS username, "
                + "s.password AS password, "
                + "a.idanggota AS idanggota, "
                + "a.nama AS namaanggota, "
                + "a.alamat AS alamatanggota, "
                + "a.telepon AS teleponanggota, "
                + "b.idbuku AS idbuku, "
                + "k.idkategori AS idkategori, "
                + "k.nama AS namakategori, "
                + "k.keterangan AS keterangankategori, "
                + "b.judul AS judul, "
                + "b.penerbit AS penerbit, "
                + "b.penulis AS penulis, "
                + "b.status AS status "
                + "FROM peminjaman p "
                + "JOIN pegawai s ON p.idpegawai = s.idpegawai "
                + "JOIN anggota a ON p.idanggota = a.idanggota "
                + "JOIN buku b ON p.idbuku = b.idbuku "
                + "JOIN kategori k ON k.idkategori = b.idkategori "
                + "WHERE p.idpeminjaman = '" + id + "'";

        ResultSet rs = DBHelper.selectQuery(query);
        Peminjaman peminjaman = null;

        try {
            if (rs.next()) {
                peminjaman = new Peminjaman();
                peminjaman.setIdpeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.setTglpeminjaman(rs.getString("tanggalpinjam"));
                peminjaman.setTglpengembalian(rs.getString("tanggalkembali"));

                Pegawai pegawai = new Pegawai();
                pegawai.setIdpegawai(rs.getInt("idpegawai"));
                pegawai.setNama(rs.getString("namapegawai"));
                pegawai.setAlamat(rs.getString("alamatpegawai"));
                pegawai.setNotelp(rs.getString("teleponpegawai"));
                pegawai.setJabatan(rs.getString("jabatan"));
                pegawai.setUsername(rs.getString("username"));
                pegawai.setPassword(rs.getString("password"));

                peminjaman.setPegawai(pegawai);

                Anggota anggota = new Anggota();
                anggota.setIdanggota(rs.getInt("idanggota"));
                anggota.setNama(rs.getString("namaanggota"));
                anggota.setAlamat(rs.getString("alamatanggota"));
                anggota.setTelepon(rs.getString("teleponanggota"));

                peminjaman.setAnggota(anggota);

                Buku buku = new Buku();
                buku.setIdbuku(rs.getInt("idbuku"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setStatus(rs.getInt("status"));

                Kategori kategori = new Kategori();
                kategori.setIdkategori(rs.getInt("idkategori"));
                kategori.setNama(rs.getString("namakategori"));
                kategori.setKeterangan(rs.getString("keterangankategori"));

                buku.setKategori(kategori);

                peminjaman.setBuku(buku);

            } else {
                txtIdPegawai.setText("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return peminjaman;
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
        lblIdPeminjaman = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        cariPeminjaman = new javax.swing.JButton();
        btnKosongkan = new javax.swing.JButton();
        btnKonfirmasi = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPengembalian = new javax.swing.JTable();
        lblIdPeminjaman1 = new javax.swing.JLabel();
        lblIdPeminjaman2 = new javax.swing.JLabel();
        lblIdPeminjaman3 = new javax.swing.JLabel();
        lblIdPeminjaman4 = new javax.swing.JLabel();
        lblIdPeminjaman5 = new javax.swing.JLabel();
        lblIdPeminjaman6 = new javax.swing.JLabel();
        txtIdPeminjaman = new javax.swing.JTextField();
        txtIdAnggota = new javax.swing.JTextField();
        txtNamaAnggota = new javax.swing.JTextField();
        txtIdPegawai = new javax.swing.JTextField();
        txtNamaPegawai = new javax.swing.JTextField();
        txtIdBuku = new javax.swing.JTextField();
        lblIdPeminjaman7 = new javax.swing.JLabel();
        txtTanggalPinjam = new javax.swing.JTextField();
        lblIdPeminjaman8 = new javax.swing.JLabel();
        txtTanggalKembali = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("FORM PENGEMBALIAN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(162, 13, 197, 25);

        lblIdPeminjaman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdPeminjaman.setText("Nama Anggota");
        getContentPane().add(lblIdPeminjaman);
        lblIdPeminjaman.setBounds(20, 140, 110, 20);

        txtJudul.setEnabled(false);
        getContentPane().add(txtJudul);
        txtJudul.setBounds(130, 250, 180, 30);

        cariPeminjaman.setText("Cari");
        cariPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPeminjamanActionPerformed(evt);
            }
        });
        getContentPane().add(cariPeminjaman);
        cariPeminjaman.setBounds(250, 70, 65, 25);

        btnKosongkan.setText("Kosongkan");
        btnKosongkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKosongkanActionPerformed(evt);
            }
        });
        getContentPane().add(btnKosongkan);
        btnKosongkan.setBounds(380, 70, 105, 25);

        btnKonfirmasi.setText("Konfirmasi");
        btnKonfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonfirmasiActionPerformed(evt);
            }
        });
        getContentPane().add(btnKonfirmasi);
        btnKonfirmasi.setBounds(380, 110, 103, 25);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus);
        btnHapus.setBounds(380, 150, 103, 25);

        tblPengembalian.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPengembalian);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 360, 580, 120);

        lblIdPeminjaman1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdPeminjaman1.setText("No. Peminjaman");
        getContentPane().add(lblIdPeminjaman1);
        lblIdPeminjaman1.setBounds(12, 75, 110, 16);

        lblIdPeminjaman2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdPeminjaman2.setText("Id Pegawai");
        getContentPane().add(lblIdPeminjaman2);
        lblIdPeminjaman2.setBounds(20, 170, 110, 20);

        lblIdPeminjaman3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdPeminjaman3.setText("ID Buku");
        getContentPane().add(lblIdPeminjaman3);
        lblIdPeminjaman3.setBounds(20, 230, 110, 20);

        lblIdPeminjaman4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdPeminjaman4.setText("Id Anggota");
        getContentPane().add(lblIdPeminjaman4);
        lblIdPeminjaman4.setBounds(20, 110, 110, 20);

        lblIdPeminjaman5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdPeminjaman5.setText("Judul Buku");
        getContentPane().add(lblIdPeminjaman5);
        lblIdPeminjaman5.setBounds(20, 260, 110, 20);

        lblIdPeminjaman6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdPeminjaman6.setText("Nama Pegawai");
        getContentPane().add(lblIdPeminjaman6);
        lblIdPeminjaman6.setBounds(20, 200, 110, 20);
        getContentPane().add(txtIdPeminjaman);
        txtIdPeminjaman.setBounds(130, 70, 112, 30);

        txtIdAnggota.setEnabled(false);
        getContentPane().add(txtIdAnggota);
        txtIdAnggota.setBounds(130, 100, 180, 30);

        txtNamaAnggota.setEnabled(false);
        getContentPane().add(txtNamaAnggota);
        txtNamaAnggota.setBounds(130, 130, 180, 30);

        txtIdPegawai.setEnabled(false);
        getContentPane().add(txtIdPegawai);
        txtIdPegawai.setBounds(130, 160, 180, 30);

        txtNamaPegawai.setEnabled(false);
        getContentPane().add(txtNamaPegawai);
        txtNamaPegawai.setBounds(130, 190, 180, 30);

        txtIdBuku.setEnabled(false);
        getContentPane().add(txtIdBuku);
        txtIdBuku.setBounds(130, 220, 180, 30);

        lblIdPeminjaman7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdPeminjaman7.setText("Tanggal Pinjam");
        getContentPane().add(lblIdPeminjaman7);
        lblIdPeminjaman7.setBounds(20, 290, 110, 20);

        txtTanggalPinjam.setEnabled(false);
        getContentPane().add(txtTanggalPinjam);
        txtTanggalPinjam.setBounds(130, 280, 180, 30);

        lblIdPeminjaman8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIdPeminjaman8.setText("Tanggal Kembali");
        getContentPane().add(lblIdPeminjaman8);
        lblIdPeminjaman8.setBounds(20, 320, 110, 20);

        txtTanggalKembali.setEnabled(false);
        getContentPane().add(txtTanggalKembali);
        txtTanggalKembali.setBounds(130, 310, 180, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cariPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPeminjamanActionPerformed
        // TODO add your handling code here:
        if (txtIdPeminjaman.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi No. Peminjaman dulu.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        } else {
            // Check if the Pegawai exists in the database
            Peminjaman p = cariPeminjaman(txtIdPeminjaman.getText());
            if (p != null) {
                if (p.getTglpengembalian() == null) {
                    JOptionPane.showMessageDialog(null,
                            "Data Peminjaman Ditemukan.\n"
                            + "ID Pegawai: " + p.getPegawai().getIdpegawai() + "\n"
                            + "Nama Pegawai: " + p.getPegawai().getNama() + "\n"
                            + "ID Anggota: " + p.getAnggota().getIdanggota() + "\n"
                            + "Nama Anggota: " + p.getAnggota().getNama() + "\n"
                            + "ID Buku: " + p.getBuku().getIdbuku() + "\n"
                            + "Judul Buku: " + p.getBuku().getJudul() + "\n"
                            + "Tanggal Pinjam: " + p.getTglpeminjaman(),
                            "Sukses", JOptionPane.INFORMATION_MESSAGE);

                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            txtIdPegawai.setText(String.valueOf(p.getPegawai().getIdpegawai()));
                            txtNamaPegawai.setText(p.getPegawai().getNama());
                            txtIdAnggota.setText(String.valueOf(p.getAnggota().getIdanggota()));
                            txtNamaAnggota.setText(p.getAnggota().getNama());
                            txtIdBuku.setText(String.valueOf(p.getBuku().getIdbuku()));
                            txtJudul.setText(p.getBuku().getJudul());
                            txtTanggalPinjam.setText(p.getTglpeminjaman());
                            txtTanggalKembali.setText("NULL");
                        }
                    });
                } else {
                    JOptionPane.showInternalMessageDialog(null, "Judul buku : " + p.getBuku().getJudul()
                            + " Dengan ID : " + p.getBuku().getIdbuku()
                            + " \nSudah dikembalikan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Data Peminjaman tidak ditemukan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                kosongkanForm();
            }

        }
    }//GEN-LAST:event_cariPeminjamanActionPerformed

    private void btnKosongkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKosongkanActionPerformed
        // TODO add your handling code here:
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnKosongkanActionPerformed

    private void btnKonfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonfirmasiActionPerformed
        // TODO add your handling code here:
        if (txtIdPeminjaman.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Masukkan ID Peminjaman terlebih dahulu.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            kosongkanForm();
        } else {

            Peminjaman pm = cariPeminjaman(txtIdPeminjaman.getText());
            if (pm != null) {
                if (pm.getTglpengembalian() == null) {
                    Pengembalian p = new Pengembalian();
                    Pegawai pegawai = new Pegawai();
                    Anggota anggota = new Anggota();
                    Buku buku = new Buku();

                    p.setIdpeminjaman(Integer.parseInt(txtIdPeminjaman.getText()));
                    pegawai.setIdpegawai(Integer.parseInt(txtIdPegawai.getText()));
                    anggota.setIdanggota(Integer.parseInt(txtIdAnggota.getText()));
                    buku.setIdbuku(Integer.parseInt(txtIdBuku.getText()));

                    p.setPegawai(pegawai);
                    p.setAnggota(anggota);
                    p.setBuku(buku);
                    p.setTglpengembalian(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

                    p.save();
                    txtJudul.setText(Integer.toString(p.getIdpeminjaman()));
                    tampilkanData();
                    JOptionPane.showMessageDialog(null, "Pengembalian Berhasil.\n", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showInternalMessageDialog(null, "Judul buku : " + pm.getBuku().getJudul()
                            + " Dengan ID : " + pm.getBuku().getIdbuku()
                            + " \nSudah dikembalikan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "ID Peminjaman tidak valid, periksa kembali.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                kosongkanForm();
            }
        }
    }//GEN-LAST:event_btnKonfirmasiActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblPengembalian.getModel();
        int row = tblPengembalian.getSelectedRow();

        Pengembalian p = new Pengembalian().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        p.delete();
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKonfirmasi;
    private javax.swing.JButton btnKosongkan;
    private javax.swing.JButton cariPeminjaman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdPeminjaman;
    private javax.swing.JLabel lblIdPeminjaman1;
    private javax.swing.JLabel lblIdPeminjaman2;
    private javax.swing.JLabel lblIdPeminjaman3;
    private javax.swing.JLabel lblIdPeminjaman4;
    private javax.swing.JLabel lblIdPeminjaman5;
    private javax.swing.JLabel lblIdPeminjaman6;
    private javax.swing.JLabel lblIdPeminjaman7;
    private javax.swing.JLabel lblIdPeminjaman8;
    private javax.swing.JTable tblPengembalian;
    private javax.swing.JTextField txtIdAnggota;
    private javax.swing.JTextField txtIdBuku;
    private javax.swing.JTextField txtIdPegawai;
    private javax.swing.JTextField txtIdPeminjaman;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtNamaAnggota;
    private javax.swing.JTextField txtNamaPegawai;
    private javax.swing.JTextField txtTanggalKembali;
    private javax.swing.JTextField txtTanggalPinjam;
    // End of variables declaration//GEN-END:variables
}
