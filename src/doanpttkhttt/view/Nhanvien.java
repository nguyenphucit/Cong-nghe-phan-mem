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
        jPanel5.setVisible(false);
        jLabel6.setVisible(false);
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
    public void tinhluong()
    {
         try {
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 sttemp=conn.createStatement();
                 int luong=0;
                 rs = st.executeQuery("select LUONGTHEOGIO from NHANVIEN where MANV like'%"+manv.getText()+"%'");
                 while(rs.next())
                 {
                     luong+=rs.getInt("LUONGTHEOGIO")*Integer.parseInt(sogiolam.getText());
                 }
                 luong=luong+Integer.parseInt(luongthuong.getText());
                 jLabel6.setText(Integer.toString(luong)+" VND");
             conn.close();
                     } catch (Exception ex) {
            ex.printStackTrace();
        }
       
        jLabel6.setVisible(true);
    }
    public  DefaultTableModel tim()
    {
         jPanel4.setVisible(false);
        tblModel = new DefaultTableModel(header, 0);
           try {
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 sttemp=conn.createStatement();
             rs = st.executeQuery("select * from TAIKHOAN where chucvu!='admin' and MANV ='"+manv.getText()+"'");
             int check=0;
            while (rs.next()) {
                check+=1;
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
            if(check==0)
            {
               JOptionPane.showMessageDialog(this,"Không có nhân viên này");
               return tblModel;
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jTable2.removeAll();
        jTable2.setModel(tblModel);
        jPanel4.setVisible(true);
           return tblModel;
    }
    public void xoa()
    {
        try {
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 ps=(PreparedStatement) conn.prepareStatement("delete from TAIKHOAN where MANV = '"+manv.getText()+"'");
                 ps.executeUpdate();
                 ps=(PreparedStatement) conn.prepareStatement("delete from NHANVIEN where MANV = '"+manv.getText()+"'");
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
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        sogiolam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        luongthuong = new javax.swing.JTextField();
        tinhluong = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(255, 204, 204));

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel2.setText("Nhập mã nhân viên cần xử lý");

        manv.setBackground(new java.awt.Color(242, 242, 242));
        manv.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        manv.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        manv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manvActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jButton1.setText("Tìm thông tin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jButton2.setText("Xóa khỏi hệ thống");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jButton3.setText("Sửa thông tin");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setBackground(new java.awt.Color(255, 255, 204));
        jTable2.setForeground(new java.awt.Color(204, 0, 204));
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
        jTable2.setFocusable(false);
        jTable2.setRowHeight(40);
        jTable2.setShowHorizontalLines(true);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jButton4.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jButton4.setText("Thêm nhân viên ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jButton5.setText("Tính lương");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 2, 18)); // NOI18N
        jLabel3.setText("Nhập số giờ làm của nhân viên trong tháng");

        sogiolam.setBackground(new java.awt.Color(242, 242, 242));
        sogiolam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sogiolam.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sogiolam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sogiolamActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 2, 18)); // NOI18N
        jLabel4.setText("Nhập lương thưởng");

        luongthuong.setBackground(new java.awt.Color(242, 242, 242));
        luongthuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        luongthuong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        luongthuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luongthuongActionPerformed(evt);
            }
        });

        tinhluong.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        tinhluong.setText("Tính");
        tinhluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinhluongActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 2, 18)); // NOI18N
        jLabel5.setText("Lương nhân viên này là:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 2, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(luongthuong, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sogiolam, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tinhluong)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sogiolam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(luongthuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(tinhluong)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(219, 219, 219))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manv, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý nhân viên", jPanel2);

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
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

    private void manvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manvActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
           jPanel5.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void sogiolamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sogiolamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sogiolamActionPerformed

    private void luongthuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luongthuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_luongthuongActionPerformed

    private void tinhluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinhluongActionPerformed
tinhluong();        
    }//GEN-LAST:event_tinhluongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField luongthuong;
    private javax.swing.JTextField manv;
    private javax.swing.JTextField sogiolam;
    private javax.swing.JButton tinhluong;
    // End of variables declaration//GEN-END:variables
}
