/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.ControllerMahasiswa;
import static controller.SQLServerConnection.closeConnection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/********************
 * @author myoenoes
 *******************/

public class Mahasiswa extends javax.swing.JInternalFrame {
    ControllerMahasiswa controllerMahasiswa;

    public Mahasiswa() {
        initComponents();
        TampilDataMahasiswa();
    }

    private void TampilDataMahasiswa() {
        controllerMahasiswa = new ControllerMahasiswa(this);    //ok
        controllerMahasiswa.viewListMahasiswa();                //ok
    }

    public void setTableMahasiswa(JTable tableMahasiswa) {
        this.tableMahasiswa = tableMahasiswa;
    }
    
    public JTable getTableMahasiwa() {
        return this.tableMahasiswa;
    }
    
    public String gettfNim(){
        return this.tfNim.getText();
    }
    
    public String gettfNama(){
        return this.tfNama.getText();
    }
    
    public String gettfTmpLahir(){
        return this.tfTmpLahir.getText();
    }
    
    public String getspTglLahir(){
        String TglLahir = spTglLahir.getValue().toString();
        String Year     = TglLahir.substring(24);
        String Month    = TglLahir.substring(4, 7);
        switch (Month) {
            case "Jan" -> Month = "01";
            case "Feb" -> Month = "02";
            case "Mar" -> Month = "03";
            case "Apr" -> Month = "04";
            case "May" -> Month = "04";
            case "Jun" -> Month = "06";
            case "Jul" -> Month = "07";
            case "Aug" -> Month = "08";
            case "Sep" -> Month = "09";
            case "Oct" -> Month = "10";
            case "Nov" -> Month = "11";
            case "Dec" -> Month = "12";
        }
        String Day = TglLahir.substring(8, 10);
        return Year+"-"+Month+"-"+Day;
    }
    
    public String getcbGender(){
        return cbGender.getItemAt(cbGender.getSelectedIndex());
    }
    
    public String gettfAlamat(){
        return tfAlamat.getText();
    }
    
    public String gettfDesaKelurahan(){
        return tfDesaKelurahan.getText();
    }
    
    public String gettfKecamatan(){
        return tfKecamatan.getText();
    }
    
    public String gettfKabupatenKota(){
        return tfKabupatenKota.getText();
    }
    
    public String gettfProvinsi(){
        return tfProvinsi.getText();
    }
    
///---------------------------------------------------------------------------    
    private void EmptyForm() {
        int Year = java.time.LocalDate.now().getYear();
        int Month = java.time.LocalDate.now().getMonthValue();
        int Day = java.time.LocalDate.now().getDayOfMonth();
        Calendar calendar = new GregorianCalendar(Year, Month-1, Day);
        //----------------------------------------------------------
        tfNama.setText(null);
        tfTmpLahir.setText(null);
        spTglLahir.setValue(calendar.getTime());
        cbGender.setSelectedIndex(0);
        tfAlamat.setText(null);
        tfDesaKelurahan.setText(null);
        tfKecamatan.setText(null);
        tfKabupatenKota.setText(null);
        tfProvinsi.setText(null);
    }
    
    private void FillForm(int RecNum){
        tfNim.setText(tableMahasiswa.getModel().getValueAt(RecNum, 0).toString());
        tfNama.setText(tableMahasiswa.getModel().getValueAt(RecNum, 1).toString());
        tfTmpLahir.setText(tableMahasiswa.getModel().getValueAt(RecNum, 2).toString());
        //----------------------------------------------------------------------
        String Date = tableMahasiswa.getModel().getValueAt(RecNum, 3).toString();
        int Year  = Integer.parseInt(Date.substring(0,4));
        int Month = Integer.parseInt(Date.substring(5,7));
        int Day   = Integer.parseInt(Date.substring(8,10));
        Calendar calendar = new GregorianCalendar(Year, Month-1, Day);
        spTglLahir.setValue(calendar.getTime());
        //----------------------------------------------------------------------       
        cbGender.setSelectedItem(tableMahasiswa.getModel().getValueAt(RecNum, 4).toString());
        tfAlamat.setText(tableMahasiswa.getModel().getValueAt(RecNum, 5).toString());
        tfDesaKelurahan.setText(tableMahasiswa.getModel().getValueAt(RecNum, 6).toString());
        tfKecamatan.setText(tableMahasiswa.getModel().getValueAt(RecNum, 7).toString());
        tfKabupatenKota.setText(tableMahasiswa.getModel().getValueAt(RecNum, 8).toString());
        tfProvinsi.setText(tableMahasiswa.getModel().getValueAt(RecNum, 9).toString());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfNim = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        tfTmpLahir = new javax.swing.JTextField();
        spTglLahir = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        tfAlamat = new javax.swing.JTextField();
        tfDesaKelurahan = new javax.swing.JTextField();
        tfKecamatan = new javax.swing.JTextField();
        tfKabupatenKota = new javax.swing.JTextField();
        tfProvinsi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMahasiswa = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Data Mahasiswa");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jButton1.setText("Tambah/Koreksi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("NIM");

        jLabel2.setText("Nama Mahasiswa");

        jLabel3.setText("Tmp. Lahir");

        jLabel4.setText("Tgl. Lahir");

        jLabel5.setText("Jenis Kelamin");

        jLabel6.setText("Alamat");

        jLabel7.setText("Desa/Kelurahan");

        jLabel8.setText("Kecamatan");

        jLabel9.setText("Kabupaten/Kota");

        tfNim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNimKeyReleased(evt);
            }
        });

        spTglLahir.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(1731047821088L), null, java.util.Calendar.DAY_OF_MONTH));

        jLabel10.setText("Provinsi");

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pria", "Wanita" }));

        tableMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        tableMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMahasiswaMouseClicked(evt);
            }
        });
        tableMahasiswa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableMahasiswaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableMahasiswa);

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Keluar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNim, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(spTglLahir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(tfTmpLahir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfKabupatenKota, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfKecamatan, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfDesaKelurahan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfProvinsi, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(105, 105, 105)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 138, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfTmpLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfDesaKelurahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(tfKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfKabupatenKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfProvinsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        closeConnection();
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tfNim.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfNimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNimKeyReleased
        int RowCount = tableMahasiswa.getModel().getRowCount();
        for (int RecNum = 0; RecNum < RowCount; RecNum++) {
            if (tfNim.getText().equals(tableMahasiswa.getValueAt(RecNum,0).toString())){
                //JOptionPane.showMessageDialog(null, "Id Ketemu");
                FillForm(RecNum);
                break;
            } else EmptyForm();
        }
    }//GEN-LAST:event_tfNimKeyReleased

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        closeConnection();
        dispose();
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tfNim.getText().isEmpty()) JOptionPane.showMessageDialog(null, "NIM is Empty");
        else controllerMahasiswa.saveMahasiswa();
        TampilDataMahasiswa();
        tfNim.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (tfNim.getText().isEmpty()) JOptionPane.showMessageDialog(null, "NIM is Empty");
        else controllerMahasiswa.deleteMahasiswa();
        TampilDataMahasiswa();
        EmptyForm();
        tfNim.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tableMahasiswaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableMahasiswaKeyReleased
        FillForm(tableMahasiswa.getSelectedRow());
    }//GEN-LAST:event_tableMahasiswaKeyReleased

    private void tableMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMahasiswaMouseClicked
        FillForm(tableMahasiswa.getSelectedRow());
    }//GEN-LAST:event_tableMahasiswaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spTglLahir;
    private javax.swing.JTable tableMahasiswa;
    private javax.swing.JTextField tfAlamat;
    private javax.swing.JTextField tfDesaKelurahan;
    private javax.swing.JTextField tfKabupatenKota;
    private javax.swing.JTextField tfKecamatan;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNim;
    private javax.swing.JTextField tfProvinsi;
    private javax.swing.JTextField tfTmpLahir;
    // End of variables declaration//GEN-END:variables
}
