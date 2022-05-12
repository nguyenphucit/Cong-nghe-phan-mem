/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package doanpttkhttt.view;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class nhapbosung extends javax.swing.JPanel {

            String header[] = {"Mã sách", "Tên sách","Tên tác giả","Giá","Số lượng tồn","Thể loại"};
         DefaultTableModel tblModel = new DefaultTableModel(header, 0);
         Vector data=null;       
        Connection conn = null;
        Statement st = null;
        Statement sttemp=null;
        java.sql.ResultSet rstemp = null;
        java.sql.ResultSet rs = null;
        PreparedStatement ps = null;
         String dbURL = "jdbc:mysql://localhost/csdl";
                String username = "root";
                String password = "";
    
    public nhapbosung() {
        initComponents();
        jTable1.setModel(danhsachcanbosung());
    }
    public nhapbosung(String str) {
        initComponents();
        jLabel4.setText(str);
        jLabel4.setVisible(false);
        jTable1.setModel(danhsachcanbosung());
    }
    public DefaultTableModel danhsachcanbosung()
    {
             tblModel = new DefaultTableModel(header, 0);
             try {
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 sttemp=conn.createStatement();
             rs = st.executeQuery("select * from SACH where SLTON <= 10");
            while (rs.next()) {
                  data = new Vector();
                 data.add(rs.getString("MASACH"));
                 data.add(rs.getString("TENSACH"));
                 rstemp=sttemp.executeQuery("SELECT TENTG from TACGIA WHERE MATG='"+rs.getString("MATG")+"'");
                 while(rstemp.next()){
                 data.add(rstemp.getString("TENTG"));
                 break;
                 }
                 data.add(rs.getString("GIA"));
                 data.add(rs.getInt("SLTON"));
                 rstemp=sttemp.executeQuery("SELECT TENTHELOAI FROM LOAISACH WHERE MALOAI='"+rs.getString("MALOAI")+"'");
                 while(rstemp.next()){
                 data.add(rstemp.getString("TENTHELOAI"));
                 break;}
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        masachbosung = new javax.swing.JTextField();
        soluongbosung = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        jLabel1.setText("Mã sách");

        jLabel2.setText("số lượng");

        masachbosung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masachbosungActionPerformed(evt);
            }
        });

        jButton1.setText("Nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Danh sách sản phẩm cần nhập thêm");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(soluongbosung, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(masachbosung, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(masachbosung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(soluongbosung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jButton1)
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void masachbosungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masachbosungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masachbosungActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      PreparedStatement ps = null;
         Connection conn = null;
        Statement st = null;
        java.sql.ResultSet rs = null;
         try {

                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 rs=st.executeQuery("select SLTON,TENSACH,GIA FROM SACH WHERE MASACH='"+masachbosung.getText()+"'");
                 int bosung=0;
                 int gia=0;
                 while(rs.next())
                 {
                     bosung+=rs.getInt("SLTON")+Integer.parseInt(soluongbosung.getText());
                     gia+=rs.getInt("GIA");
                 }
                  ps=(PreparedStatement) conn.prepareStatement("UPDATE SACH SET SLTON="+bosung+" WHERE MASACH = '"+masachbosung.getText()+"'");
                   int check=ps.executeUpdate();
                 if(check==1){
                     JOptionPane.showMessageDialog(this,"Đã bổ sung thành công");
                      ps=(PreparedStatement) conn.prepareStatement("INSERT INTO CHITIETPN values(?,?,?,?)");
                      ps.setString(1,jLabel4.getText());
                      ps.setString(2,masachbosung.getText());
                      ps.setInt(3,gia);
                      ps.setInt(4,Integer.parseInt(soluongbosung.getText()));
                      ps.executeUpdate();
                 }
                 else
                      JOptionPane.showMessageDialog(this,"Mã sách không tồn tại");
                 jTable1.setModel(danhsachcanbosung());
                conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField masachbosung;
    private javax.swing.JTextField soluongbosung;
    // End of variables declaration//GEN-END:variables
}
