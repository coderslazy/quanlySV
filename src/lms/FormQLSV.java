package lms;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FormQLSV extends javax.swing.JFrame {

    DefaultTableModel dftb = new DefaultTableModel();
    int checkTT=0;
    public FormQLSV() {
        initComponents();
        loadData();
    }

    private void loadData() {

        try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "SELECT * FROM SINHVIEN";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int n = meta.getColumnCount();
            Vector col = new Vector();
            col.add("Mã sinh viên");
            col.add("Họ tên sinh viên");
            col.add("Ngành học");
            col.add("Ngày sinh");
            col.add("Giới tính");
            col.add("Địa chỉ");
            dftb.setColumnIdentifiers(col);
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 0; i < n; i++) {
                    if (i < n) {
                        row.addElement(rs.getString(i + 1));
                    } else {
                    }
                }
                dftb.addRow(row);

            }
            tblSV.setModel(dftb);
            tblSV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (tblSV.getSelectedRow() >= 0) {
                        tfmasv.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 0).toString());
                        tftensv.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 1).toString());
                        tfNganhHoc.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 2).toString());
                        tfngaysinh.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 3).toString());
                        String s = tblSV.getValueAt(tblSV.getSelectedRow(), 4).toString();
                        if (s.equals("1")) {
                            rdbnam.setSelected(true);
                        } else {
                            rdbnu.setSelected(true);
                        }
                        tfdiachi.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 5).toString());
                    }
                }
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi : " + ex);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfmasv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tftensv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfngaysinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdbnam = new javax.swing.JRadioButton();
        rdbnu = new javax.swing.JRadioButton();
        tfdiachi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnthemsv = new javax.swing.JButton();
        btnsuasv = new javax.swing.JButton();
        btnxoasv = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfNganhHoc = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý sinh viên");
        setBackground(new java.awt.Color(51, 255, 51));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MaSV", "TenSV", "Ngành Học", "Ngày sinh", "Giới tính", "Địa chỉ"
            }
        ));
        jScrollPane1.setViewportView(tblSV);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHỨC NĂNG QUẢN LÝ SINH VIÊN");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Mã sinh viên");

        tfmasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfmasvActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Tên sinh viên");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Ngày sinh");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Giới tính");

        rdbnam.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rdbnam);
        rdbnam.setText("Nam");

        rdbnu.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rdbnu);
        rdbnu.setText("Nữ");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Địa chỉ");

        btnthemsv.setText("Thêm SV");
        btnthemsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemsvActionPerformed(evt);
            }
        });

        btnsuasv.setText("Sửa SV");
        btnsuasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuasvActionPerformed(evt);
            }
        });

        btnxoasv.setText("Xóa SV");
        btnxoasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoasvActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel7.setText("Notes : 1-Nam ; 2-Nữ");

        jLabel8.setText("Ngành Học");

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(tfdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tfmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37)
                                            .addComponent(jLabel3))
                                        .addComponent(tfngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rdbnam)
                                .addGap(28, 28, 28)
                                .addComponent(rdbnu)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnthemsv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tftensv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnxoasv, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnsuasv, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNganhHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tftensv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfNganhHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthemsv))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsuasv))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbnam)
                            .addComponent(rdbnu)
                            .addComponent(btnxoasv))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnLuu)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(1, 1, 1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfmasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfmasvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfmasvActionPerformed

    private void btnthemsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemsvActionPerformed
        tfmasv.enable(true);
        tfNganhHoc.enable(true);
        tfdiachi.enable(true);
        tfngaysinh.enable(true);
        tftensv.enable(true);
        buttonGroup1.clearSelection();
        
        tftensv.setText("");
        tfngaysinh.setText("");
        tfdiachi.setText("");
        tfNganhHoc.setText("");
        tfmasv.setText("");
        tfmasv.requestFocus();
        checkTT=1;
       
    }//GEN-LAST:event_btnthemsvActionPerformed

    private void btnxoasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoasvActionPerformed
        try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "DELETE FROM SINHVIEN WHERE MASV=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfmasv.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không xóa được sinh viên");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnxoasvActionPerformed

    private void btnsuasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuasvActionPerformed
            checkTT=2;
            tfngaysinh.enable(true);
            tftensv.enable(true);
            tfdiachi.enable(true);
            tfngaysinh.enable(true);
            tfNganhHoc.enable(true);
            
    }//GEN-LAST:event_btnsuasvActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
       if(checkTT==1)
       {
            try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "INSERT INTO SINHVIEN values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfmasv.getText());
            ps.setString(2, tftensv.getText());
            ps.setString(3, tfNganhHoc.getText());
            ps.setString(4, tfngaysinh.getText());
            ps.setBoolean(5, rdbnam.isSelected() ? true : false);
            ps.setString(6, tfdiachi.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thể thêm sinh viên");
//            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       else if(checkTT==2)
       {
             try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "UPDATE SINHVIEN SET HoTen = ?,maKhoa = ?,NgaySinh = ?,GioiTinh = ?,DiaChi= ? where MaSV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tftensv.getText());
            ps.setString(2, tfNganhHoc.getText());
            ps.setString(3, tfngaysinh.getText());
            ps.setBoolean(4, rdbnam.isSelected() ? true : false);
            ps.setString(5, tfdiachi.getText());
            ps.setString(6, tfmasv.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không update được sinh viên");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        tfmasv.enable(false);
        tfNganhHoc.enable(false);
        tfdiachi.enable(false);
        tfngaysinh.enable(false);
        tftensv.enable(false);
    }//GEN-LAST:event_btnLuuActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tfmasv.enable(false);
        tfNganhHoc.enable(false);
        tfdiachi.enable(false);
        tfngaysinh.enable(false);
        tftensv.enable(false);
    }//GEN-LAST:event_formWindowOpened

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        tfmasv.enable(false);
        tfNganhHoc.enable(false);
        tfdiachi.enable(false);
        tfngaysinh.enable(false);
        tftensv.enable(false);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new FormMain().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQLSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnsuasv;
    private javax.swing.JButton btnthemsv;
    private javax.swing.JButton btnxoasv;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbnam;
    private javax.swing.JRadioButton rdbnu;
    private javax.swing.JTable tblSV;
    private javax.swing.JTextField tfNganhHoc;
    private javax.swing.JTextField tfdiachi;
    private javax.swing.JTextField tfmasv;
    private javax.swing.JTextField tfngaysinh;
    private javax.swing.JTextField tftensv;
    // End of variables declaration//GEN-END:variables
}
