package lms;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FormQLD extends javax.swing.JFrame {

    DefaultTableModel dftb = new DefaultTableModel();
    int checkTT=0;

    public FormQLD() {
        initComponents();
        loadData();
        loadtop3();
    }

    private void tinhdiemtb() {
        try {
            float ta = Float.parseFloat(tfdiemta.getText());
            float th = Float.parseFloat(tfdiemth.getText());
            float gdtc = Float.parseFloat(tfdiemgdtc.getText());
            float diemtb = (ta + th + gdtc) / 3;
            String abc = String.valueOf(diemtb);
            tfdiemtb.setText(abc);
            
        } catch (Exception ex) {
            if (tfdiemta.getText().equals("") || tfdiemgdtc.getText().equals("") || tfdiemgdtc.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Không được bỏ trống điểm");
            } else {
                JOptionPane.showMessageDialog(null, "Nhập sai giá trị điểm");
            }
        }
    }

    private void loadData() {

        try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "SELECT * FROM viewDiem";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int n = meta.getColumnCount();
            Vector col = new Vector();
            col.add("Mã sinh viên");
            col.add("Họ tên sinh viên");
            col.add("Khoa");
            col.add("Điểm tiếng anh");
            col.add("Điểm tin học");
            col.add("Điểm GDQP");
            col.add("Điểm trung bình");
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
                        tftenSV.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 1).toString());
                        tfNganhHoc.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 2).toString());
                        tfdiemta.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 3).toString());
                        tfdiemth.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 4).toString());
                        tfdiemgdtc.setText(tblSV.getValueAt(tblSV.getSelectedRow(), 5).toString());
                        tinhdiemtb();
                    }
                }
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi : " + ex);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadtop3() {
        try {
            DefaultTableModel dftb2 = new DefaultTableModel();
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "SELECT TOP 3 BANGDIEM.MASV,SINHVIEN.HoTen,DIEMTB FROM BANGDIEM JOIN SINHVIEN ON SINHVIEN.MASV=BANGDIEM.MASV ORDER BY DIEMTB DESC";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta2 = rs.getMetaData();
            int n = meta2.getColumnCount();
            Vector col2 = new Vector();
//            for (int i = 0; i < n; i++) {
//                col2.add(meta2.getColumnName(i + 1));
//            }
            col2.add("Mã sinh viên");
            col2.add("Họ tên sinh viên");
            col2.add("Điểm TB");
            dftb2.setColumnIdentifiers(col2);
            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 0; i < n; i++) {
                    if (i < n) {
                        row.addElement(rs.getString(i + 1));
                    } else {
                    }
                }
                dftb2.addRow(row);

            }
            lblSV2.setModel(dftb2);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi : " + ex);
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnnhapdiem = new javax.swing.JButton();
        btnsuadiem = new javax.swing.JButton();
        btnxoadiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfmasv = new javax.swing.JTextField();
        tfdiemta = new javax.swing.JTextField();
        tfdiemth = new javax.swing.JTextField();
        tfdiemgdtc = new javax.swing.JTextField();
        tfdiemtb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblSV2 = new javax.swing.JTable();
        tftenSV = new javax.swing.JTextField();
        tfNganhHoc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý điểm");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHỨC NĂNG QUẢN LÝ ĐIỂM");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Họ tên:");

        btnnhapdiem.setText("Nhập điểm");
        btnnhapdiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnhapdiemActionPerformed(evt);
            }
        });

        btnsuadiem.setText("Sửa điểm");
        btnsuadiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuadiemActionPerformed(evt);
            }
        });

        btnxoadiem.setText("Xóa điểm");
        btnxoadiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoadiemActionPerformed(evt);
            }
        });

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MaSV", "Họ tên", "Mã ngành", "Điểm Tiếng Anh", "Điểm Tin học", "ĐIểm GDTC", "Điểm Trung Bình"
            }
        ));
        jScrollPane2.setViewportView(tblSV);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Điểm tin học: ");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Điểm Tiếng Anh:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Điểm GDTC:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Điểm trung bình: ");

        tfdiemtb.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thông tin sinh viên");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Top 3 sinh viên");

        lblSV2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "MaSV", "Tên sinh viên", "DiemTB"
            }
        ));
        jScrollPane1.setViewportView(lblSV2);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Mã sinh viên:");

        jLabel10.setText("Mã ngành học: ");

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
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfdiemtb, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnnhapdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnsuadiem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnxoadiem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(tfdiemth, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfdiemta, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(tfmasv)
                                    .addComponent(tfNganhHoc))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(tftenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(tfdiemgdtc, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 63, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tftenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfNganhHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfdiemgdtc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfdiemta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfdiemth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdiemtb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnnhapdiem)
                            .addComponent(btnsuadiem)
                            .addComponent(btnxoadiem))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLuu)
                            .addComponent(btnHuy)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnnhapdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnhapdiemActionPerformed
//        tfNganhHoc.enable(true);
//        tftenSV.enable(true);
        tfmasv.enable(true);
        tfdiemta.enable(true);
        tfdiemth.enable(true);
        tfdiemgdtc.enable(true);
        tfmasv.setText("");
        tftenSV.setText("");
        tfdiemth.setText("");
        tfdiemta.setText("");
        tfdiemtb.setText("");
        tfNganhHoc.setText("");
        tfdiemgdtc.setText("");
        tfmasv.requestFocus();
        checkTT=1;
    }//GEN-LAST:event_btnnhapdiemActionPerformed

    private void btnxoadiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoadiemActionPerformed
        try {
            Connects a = new Connects();
            Connection con = a.getConnection();
            String sql = "DELETE FROM BANGDIEM WHERE MASV=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfmasv.getText());
            ps.executeUpdate();
            dftb.setRowCount(0);
            loadData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không xóa được nữa !");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnxoadiemActionPerformed

    private void btnsuadiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuadiemActionPerformed

        tfdiemta.enable(true);
        tfdiemth.enable(true);
        tfdiemgdtc.enable(true);
        tfdiemta.requestFocus();
        checkTT=2;
    }//GEN-LAST:event_btnsuadiemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new FormMain().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tfNganhHoc.enable(false);
        tftenSV.enable(false);
        tfmasv.enable(false);
        tfdiemta.enable(false);
        tfdiemth.enable(false);
        tfdiemgdtc.enable(false);
        
    }//GEN-LAST:event_formWindowOpened

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
             Connects a = new Connects();    
            if (checkTT==1)
            {
                try {
                    Connection con = a.getConnection();
                    String sql = "INSERT INTO BANGDIEM values(?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, tfmasv.getText());
                    ps.setString(2, tfdiemta.getText());
                    ps.setString(3, tfdiemth.getText());
                    ps.setString(4, tfdiemgdtc.getText());
                    tinhdiemtb();
                    ps.setString(5, tfdiemtb.getText());
                    ps.executeUpdate();
                    dftb.setRowCount(0);
                    loadData();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "\tKhông nhập được điểm\nNgười này chưa tồn tại hoặc đã có điểm");
//                    Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if( checkTT==2)
            {
                try {
                    Connection con = a.getConnection();
                    String sql = "UPDATE BANGDIEM SET DIEMTA = ?,DIEMTH = ?,DIEMGDQP = ?,DIEMTB= ? WHERE MASV = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, tfdiemta.getText());
                    ps.setString(2, tfdiemth.getText());
                    ps.setString(3, tfdiemgdtc.getText());
                    tinhdiemtb();
                    ps.setString(4, tfdiemtb.getText());
                    ps.setString(5, tfmasv.getText());
                    ps.executeUpdate();
                    dftb.setRowCount(0);
                    loadData();
                    loadtop3();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Không update được điểm");
//                    Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            tfNganhHoc.enable(false);
            tftenSV.enable(false);
            tfmasv.enable(false);
            tfdiemta.enable(false);
            tfdiemth.enable(false);
            tfdiemgdtc.enable(false);
//            }
//        } catch (SQLException ex) {
////            Logger.getLogger(FormQLD.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println("lms.FormQLD.btnLuuActionPerformed()");
//        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        tfNganhHoc.enable(false);
        tftenSV.enable(false);
        tfmasv.enable(false);
        tfdiemta.enable(false);
        tfdiemth.enable(false);
        tfdiemgdtc.enable(false);
    }//GEN-LAST:event_btnHuyActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQLD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnnhapdiem;
    private javax.swing.JButton btnsuadiem;
    private javax.swing.JButton btnxoadiem;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable lblSV2;
    private javax.swing.JTable tblSV;
    private javax.swing.JTextField tfNganhHoc;
    private javax.swing.JTextField tfdiemgdtc;
    private javax.swing.JTextField tfdiemta;
    private javax.swing.JTextField tfdiemtb;
    private javax.swing.JTextField tfdiemth;
    private javax.swing.JTextField tfmasv;
    private javax.swing.JTextField tftenSV;
    // End of variables declaration//GEN-END:variables
}
