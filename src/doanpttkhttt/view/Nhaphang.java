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

    /**
     * Creates new form Nhaphang
     */
    public Nhaphang() {
        
        initComponents();
        jTable1.setModel(xuatdanhsachphieunhap());
    }

   public DefaultTableModel xuatdanhsachphieunhap()
   {
    String header[] = {"mã phiếu nhập","Tên người nhập", "Nhà cung cấp ","tổng tiền"};
         DefaultTableModel tblModel = new DefaultTableModel(header, 0);
         Vector data=null;
         
         Connection conn = null;
        Statement st = null;
        java.sql.ResultSet rs = null;
             try {
                 String dbURL = "jdbc:mysql://localhost/doanweb";
                String username = "root";
                String password = "";
                conn = DriverManager.getConnection(dbURL, username, password);
            // crate statement
                 st = conn.createStatement();
            // get data from table 'student'
             rs = st.executeQuery("select * from PHIEUNHAP");
            
            

            while (rs.next()) {
                 data = new Vector();
  data.add(rs.getString(1));
  data.add(rs.getString(2));
  data.add(rs.getString(3));
  data.add(rs.getInt(4));
   tblModel.addRow(data);
//                System.out.println(rs.getString(1)+"\t\t"+rs.getString(2));
            }
            // close connection
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
        tennguoinhap = new javax.swing.JTextField();
        tenncc = new javax.swing.JTextField();
        ngaynhap = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        viewchitietpn = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 102, 102));
        setPreferredSize(new java.awt.Dimension(799, 428));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHẬP HÀNG");

        jLabel2.setText("Mã phiếu nhập");

        jLabel3.setText("Tên người nhập");

        jLabel4.setText("Tên nhà cung cấp");

        jLabel5.setText("Ngày nhập");

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
            .addGap(0, 429, Short.MAX_VALUE)
        );
        viewchitietpnLayout.setVerticalGroup(
            viewchitietpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton2.setText("Hoàn thành");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewNhapphieuLayout = new javax.swing.GroupLayout(viewNhapphieu);
        viewNhapphieu.setLayout(viewNhapphieuLayout);
        viewNhapphieuLayout.setHorizontalGroup(
            viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewNhapphieuLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(viewNhapphieuLayout.createSequentialGroup()
                        .addGroup(viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mapn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tennguoinhap, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenncc, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(71, 71, 71)
                .addComponent(viewchitietpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewNhapphieuLayout.setVerticalGroup(
            viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewNhapphieuLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mapn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tennguoinhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tenncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewNhapphieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(viewNhapphieuLayout.createSequentialGroup()
                .addComponent(viewchitietpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lập phiếu nhập", viewNhapphieu);

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
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
       Connection conn = null;
        Statement st = null;
        PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        Vector data=null;
             try {
                 String dbURL = "jdbc:mysql://localhost/doanweb";
                String username = "root";
                String password = "";   
                conn = DriverManager.getConnection(dbURL, username, password);
                 ps=(PreparedStatement) conn.prepareStatement("INSERT INTO phieunhap(maphieunhap,tennguoinhap,tennhacc,tongtien) VALUES(?,?,?,0)");
                 ps.setString(1,mapn.getText());
                 ps.setString(2,tennguoinhap.getText());
                 ps.setString(3,tenncc.getText());
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
            ex.printStackTrace();}
        
        viewchitietpn.removeAll();
        viewchitietpn.setLayout(new BorderLayout());
        JPanel node=new ViewChitietphieunhap(mapn.getText());
        viewchitietpn.add(node);
        viewchitietpn.validate();
        viewchitietpn.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 Connection conn = null;
        PreparedStatement st = null;
        PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
             try {
                 String dbURL = "jdbc:mysql://localhost/doanweb";
                String usernamedb = "root";
                String password = "";   
                conn =  DriverManager.getConnection(dbURL, usernamedb, password);
              //  them chi tiet hoa don vao hoa don
                                st=(PreparedStatement) conn.prepareStatement("select * from chitietphieunhap where maphieunhap=?");
                st.setString(1,mapn.getText());
                rs = st.executeQuery();
                  int tong=0;
                while(rs.next())
                {
                     String gia=rs.getString("gia");
                     int soluong=rs.getInt("SOLUONGNHAP");
                     tong=tong+Integer.parseInt(gia)*soluong;
                }
                st=(PreparedStatement) conn.prepareStatement("UPDATE PHIEUNHAP set tongtien=? where MAPHIEUNHAP=?");
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
    private javax.swing.JTextField mapn;
    private javax.swing.JTextField ngaynhap;
    private javax.swing.JTextField tenncc;
    private javax.swing.JTextField tennguoinhap;
    private javax.swing.JPanel viewNhapphieu;
    private javax.swing.JPanel viewchitietpn;
    // End of variables declaration//GEN-END:variables
}
