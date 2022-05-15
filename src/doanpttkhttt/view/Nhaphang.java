/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package doanpttkhttt.view;

import com.mysql.jdbc.PreparedStatement;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Nhaphang extends javax.swing.JPanel {

String header[] = {"mã phiếu nhập","Tên người nhập", "Nhà cung cấp ","Ngày lập phiếu","tổng tiền"};
            DefaultTableModel tblModel = new DefaultTableModel(header, 0);
            Vector data=null;
            Connection conn = null;
            Statement st = null;
            Statement temp=null;
            java.sql.ResultSet temprs = null;
            java.sql.ResultSet rs = null;
            PreparedStatement ps = null;
            PreparedStatement pstemp = null;
            String dbURL = "jdbc:mysql://localhost/csdl";
            String username = "root";
            String password = "";
    
    public Nhaphang() {
        
        initComponents();
        jTable1.setModel(xuatdanhsachphieunhap());
        setNVNHAP();
    }
     public void setNVNHAP()
    {
         try {
                conn =  DriverManager.getConnection(dbURL, username, password);
                st=(com.mysql.jdbc.Statement) conn.createStatement();
                rs=st.executeQuery("select MANV FROM TAIKHOAN WHERE CHUCVU='kiểm kho'");
               while(rs.next())
               {
                    manvnhap.addItem(rs.getString("MANV"));
                
               }
               rs=st.executeQuery("select MANCC FROM NHACC");
               while(rs.next())
               {
                    manccnhap.addItem(rs.getString("MANCC"));
                
               }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();}
    }

   public DefaultTableModel xuatdanhsachphieunhap()
   {
            tblModel = new DefaultTableModel(header, 0);
             try {
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 temp=conn.createStatement();
                 rs = st.executeQuery("select * from PHIEUNHAP");
            while (rs.next()) {
                 data = new Vector();
                data.add(rs.getString("MAPN"));
                temprs=temp.executeQuery("SELECT TENNV FROM NHANVIEN WHERE MANV='"+rs.getString("MANV")+ "'");
                while(temprs.next()){
                data.add(temprs.getString("TENNV"));
                break;}
                data.add(rs.getString("MANCC"));
                data.add(rs.getString("NGAYTHANG"));
                data.add(rs.getInt("TONGTIEN"));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        viewNhapphieu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mapn = new javax.swing.JTextField();
        ngaynhap = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        viewchitietpn = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        manvnhap = new javax.swing.JComboBox<>();
        manccnhap = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(799, 428));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHẬP HÀNG");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 2, 20)); // NOI18N
        jLabel2.setText("Mã phiếu nhập");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 2, 20)); // NOI18N
        jLabel3.setText("Mã nhân viên nhập");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 2, 20)); // NOI18N
        jLabel4.setText("Mã nhà cung cấp");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 2, 20)); // NOI18N
        jLabel5.setText("Ngày nhập");

        mapn.setBackground(new java.awt.Color(242, 242, 242));
        mapn.setFont(new java.awt.Font("Segoe UI Light", 2, 24)); // NOI18N
        mapn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        mapn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapnActionPerformed(evt);
            }
        });

        ngaynhap.setBackground(new java.awt.Color(242, 242, 242));
        ngaynhap.setFont(new java.awt.Font("Segoe UI Light", 2, 24)); // NOI18N
        ngaynhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jButton1.setFont(new java.awt.Font("Segoe UI Light", 2, 18)); // NOI18N
        jButton1.setText("Tạo phiếu nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewchitietpnLayout = new javax.swing.GroupLayout(viewchitietpn);
        viewchitietpn.setLayout(viewchitietpnLayout);
        viewchitietpnLayout.setHorizontalGroup(
            viewchitietpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
        viewchitietpnLayout.setVerticalGroup(
            viewchitietpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton2.setFont(new java.awt.Font("Segoe UI Light", 2, 18)); // NOI18N
        jButton2.setText("Hoàn thành");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        manvnhap.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N

        manccnhap.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N

        javax.swing.GroupLayout viewNhapphieuLayout = new javax.swing.GroupLayout(viewNhapphieu);
        viewNhapphieu.setLayout(viewNhapphieuLayout);
        viewNhapphieuLayout.setHorizontalGroup(
            viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewNhapphieuLayout.createSequentialGroup()
                .addGroup(viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewNhapphieuLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2))
                    .addGroup(viewNhapphieuLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(manvnhap, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mapn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addComponent(manccnhap, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(viewNhapphieuLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel4))
                    .addGroup(viewNhapphieuLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel5))
                    .addGroup(viewNhapphieuLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton2)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1))
                    .addGroup(viewNhapphieuLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(viewchitietpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        viewNhapphieuLayout.setVerticalGroup(
            viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewNhapphieuLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manvnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(manccnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(viewNhapphieuLayout.createSequentialGroup()
                .addComponent(viewchitietpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lập phiếu nhập", viewNhapphieu);

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
        jTable1.setFont(new java.awt.Font("Segoe UI Light", 2, 18)); // NOI18N
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách phiếu nhập", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

             try { 
                conn = DriverManager.getConnection(dbURL, username, password);
                 ps=(PreparedStatement) conn.prepareStatement("INSERT INTO phieunhap(mapn,manv,mancc,ngaythang,tongtien) VALUES(?,?,?,?,0)");
                 ps.setString(1,mapn.getText());
                 ps.setString(2,manvnhap.getSelectedItem().toString());
                 ps.setString(3,manccnhap.getSelectedItem().toString());
                 ps.setString(4,ngaynhap.getText());
                 int check=ps.executeUpdate();
                 if(check==1)
                 {
                     JOptionPane.showMessageDialog(this, "Tiến hành chọn hình thức nhập");
                 }
                 else if(check==0){
                     JOptionPane.showMessageDialog(this,"không the them duoc");
                 }
            conn.close();
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, "Thông tin phiếu có lẽ sai hoặc đã bị trùng,vui lòng nhập lại");
            ex.printStackTrace();
            return;
        }
        
        viewchitietpn.removeAll();
        viewchitietpn.setLayout(new BorderLayout());
        JPanel node=new ViewChitietphieunhap(mapn.getText(),manccnhap.getSelectedItem().toString());
        viewchitietpn.add(node);
        viewchitietpn.validate();
        viewchitietpn.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

            PreparedStatement st = null;
             try { 
                conn =  DriverManager.getConnection(dbURL, username, password);
                                st=(PreparedStatement) conn.prepareStatement("select * from chitietpn where mapn=?");
                st.setString(1,mapn.getText());
                rs = st.executeQuery();
                  int tong=0;
                while(rs.next())
                {
                     String gia=rs.getString("gia");
                     int soluong=rs.getInt("SOLUONG");
                     tong=tong+Integer.parseInt(gia)*soluong;
                }
                st=(PreparedStatement) conn.prepareStatement("UPDATE PHIEUNHAP set tongtien=? where MAPN=?");
                st.setInt(1,tong);
                st.setString(2,mapn.getText());
                  st.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();}
             viewchitietpn.removeAll();
             viewchitietpn.validate();
             viewchitietpn.repaint(); 
             jTable1.setModel(xuatdanhsachphieunhap());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void mapnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mapnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> manccnhap;
    private javax.swing.JComboBox<String> manvnhap;
    private javax.swing.JTextField mapn;
    private javax.swing.JTextField ngaynhap;
    private javax.swing.JPanel viewNhapphieu;
    private javax.swing.JPanel viewchitietpn;
    // End of variables declaration//GEN-END:variables
}
