/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package doanpttkhttt.view;

import com.mysql.jdbc.PreparedStatement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Nhanvien extends javax.swing.JPanel {
        Vector data=null;
        Connection conn = null;
        Statement st = null;
        java.sql.ResultSet rs = null;
        Statement sttemp = null;
        java.sql.ResultSet rstemp = null;
        PreparedStatement ps = null;
        String header[] = {"Mã nhân viên", "Tên nhân viên","Tên tài khoản","password","Chức vụ"};
        DefaultTableModel tblModel = new DefaultTableModel(header, 0);
        String dbURL = "jdbc:mysql://localhost/csdl";
        String username = "root";
        String password = "";
   
      public Nhanvien() {
        initComponents();
        jTable1.setModel(xuatdanhsachnhanvien());
        jPanel4.setVisible(false);
    }
    
    public DefaultTableModel xuatdanhsachnhanvien()
    {
       tblModel = new DefaultTableModel(header, 0);
             try {  
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 sttemp=conn.createStatement();
             rs = st.executeQuery("select * from TAIKHOAN where chucvu!='admin'");
            while (rs.next()) {
                 data = new Vector();
  data.add(rs.getString("MANV"));
                rstemp=sttemp.executeQuery("SELECT TENNV FROM NHANVIEN WHERE MANV='"+rs.getString("MANV")+"'");
                while(rstemp.next())
                {
                  data.add(rstemp.getString("TENNV"));  
                }
  data.add(rs.getString("TENDN"));
  data.add(rs.getString("MATKHAU"));
  data.add(rs.getString("CHUCVU"));
   tblModel.addRow(data);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

       jTable1.setModel(tblModel);
        jTable1.setBounds(30, 40, 200, 300);
        return tblModel;
    }
    public  DefaultTableModel tim()
    {
         jPanel4.setVisible(true);
           try {
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 sttemp=conn.createStatement();
             rs = st.executeQuery("select * from TAIKHOAN where chucvu!='admin' and MANV like'%"+manv.getText()+"%'");
            tblModel = new DefaultTableModel(header, 0);
            

            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("MANV"));
                rstemp=sttemp.executeQuery("SELECT TENNV FROM NHANVIEN WHERE MANV='"+manv.getText()+"'");
                while(rstemp.next())
                {
                  data.add(rstemp.getString("TENNV"));  
                }
                data.add(rs.getString("TENDN"));
                data.add(rs.getString("MATKHAU"));
                data.add(rs.getString("CHUCVU"));
                tblModel.addRow(data);
            }
            
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            jTable2.setModel(tblModel);
        jTable2.setBounds(30, 40, 200, 300);
        jTable1.setModel(xuatdanhsachnhanvien());
           return tblModel;
    }
    public void xoa()
    {
        try {
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 ps=(PreparedStatement) conn.prepareStatement("delete from TAIKHOAN where MANV = '"+manv.getText()+"'");
                 int check=ps.executeUpdate();
                 if(check==1)
                     JOptionPane.showMessageDialog(this,"Đã xóa thành công");
                 else
                      JOptionPane.showMessageDialog(this,"Không có nhân viên này");
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jTable1.setModel(xuatdanhsachnhanvien());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        manv = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(255, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));

        jLabel2.setText("Nhập mã nhân viên cần xử lý");

        jButton1.setText("Tìm thông tin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Xóa khỏi hệ thống");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sửa thông tin");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jButton4.setText("Thêm nhân viên ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(manv, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý nhân viên", jPanel2);

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setFont(new java.awt.Font("Segoe UI Light", 2, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(204, 0, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setFocusable(false);
        jTable1.setRowHeight(40);
        jTable1.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách nhân viên", jPanel3);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Quản lí nhân viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        tim();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        xoa();
        jPanel4.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        themnhanvien themnv=new themnhanvien();
                     themnv.setVisible(true);
                     themnv.setBounds(600, 270,themnv.getWidth(), themnv.getHeight());
                     themnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         try {
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 sttemp=conn.createStatement();
                 rs=st.executeQuery("select * from taikhoan");
                 int flag=0;
                 String masua="";
                 String tensua="";
                 String tentksua="";
                 String matkhau="";
                 int luong=0;
                 String chucvu="";
                 while(rs.next())
                 {
                     if(rs.getString("MANV").equalsIgnoreCase(manv.getText())){
                         flag=1;
                         masua=rs.getString("MANV");
                         rstemp=sttemp.executeQuery("SELECT TENNV FROM NHANVIEN WHERE MANV='"+manv.getText()+"'");
                        while(rstemp.next())
                        {
                         tensua=rstemp.getString("TENNV");
                        }
                         tentksua=rs.getString("TENDN");
                         matkhau=rs.getString("MATKHAU");
                         chucvu=rs.getString("chucvu");
                          rstemp=sttemp.executeQuery("SELECT LUONGTHEOGIO FROM NHANVIEN WHERE MANV='"+manv.getText()+"'");
                        while(rstemp.next())
                        {
                         luong=rstemp.getInt("LUONGTHEOGIO");
                        }
                     break;}
                 }
                 if(flag==0)
                     JOptionPane.showMessageDialog(this,"Mã NV không tồn tại");
                 else if(flag==1)
                 {
                     Suanhanvien suanv=new Suanhanvien(masua,tensua,tentksua,matkhau,chucvu,luong);
                     suanv.setVisible(true);
                     suanv.setBounds(600, 270,suanv.getWidth(), suanv.getHeight());
                     suanv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField manv;
    // End of variables declaration//GEN-END:variables
}
