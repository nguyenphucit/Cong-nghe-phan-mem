/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package doanpttkhttt.view;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class nhapmoi extends javax.swing.JPanel {
        Connection conn = null;
        Statement st = null;
        Statement sttemp = null;
        PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String dbURL = "jdbc:mysql://localhost/csdl";
        String usernamedb = "root";
        String password = ""; 
        PreparedStatement pstemp = null;
    public nhapmoi() {
        initComponents();
    }
    public nhapmoi(String str,String ncc) {
        initComponents();
        jLabel6.setText(str);
        mancc.setText(ncc);
        mancc.setVisible(false);
        setTg();
        tacgianhap.setVisible(false);
        tacgiaselect.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent e){
                     if(tacgiaselect.getSelectedItem().toString().equalsIgnoreCase("khác"))
                     {
                         tacgianhap.setVisible(true);
                         tacgiaselect.setVisible(false);
                     }
                 }
            });
    }
   public void setTg()
   {
       try {
                conn =  DriverManager.getConnection(dbURL, usernamedb, password);
                st=(Statement) conn.createStatement();
                rs=st.executeQuery("select TENTG FROM TACGIA");
               while(rs.next())
               {
                    tacgiaselect.addItem(rs.getString("TENTG"));
               }
               tacgiaselect.addItem("khác");
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();}
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        masachnhap = new javax.swing.JTextField();
        tensachnhap = new javax.swing.JTextField();
        giasachnhap = new javax.swing.JTextField();
        soluongsachnhap = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tacgianhap = new javax.swing.JTextField();
        theloainhap = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tacgiaselect = new javax.swing.JComboBox<>();
        mancc = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Chi tiết phiếu nhập");

        jLabel2.setText("Mã sách");

        jLabel3.setText("Tên sách");

        jLabel4.setText("Giá");

        jLabel5.setText("Số lượng");

        jButton1.setText("Nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("jLabel6");

        jLabel7.setText("tên tác giả");

        jLabel8.setText("Thể loại");

        mancc.setText("jLabel9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(56, 56, 56)
                                    .addComponent(giasachnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel8))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(theloainhap, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(soluongsachnhap, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
                                .addComponent(mancc, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(masachnhap)
                                        .addComponent(tensachnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tacgiaselect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tacgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(masachnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tensachnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tacgiaselect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tacgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(giasachnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(soluongsachnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(theloainhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(mancc))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

             try {
                conn =  DriverManager.getConnection(dbURL, usernamedb, password);
                     sttemp=(Statement) conn.createStatement();
                 ps=(PreparedStatement) conn.prepareStatement("INSERT INTO CHITIETPN(MAPN,MASACH,TENSACH,GIA,SOLUONG) VALUES(?,?,?,?,?)");
                 ps.setString(1,jLabel6.getText());
                 ps.setString(2,masachnhap.getText());
                 ps.setString(3,tensachnhap.getText());
                 int test=Integer.parseInt(giasachnhap.getText());
                 ps.setInt(4,test);
                 ps.setInt(5,Integer.parseInt(soluongsachnhap.getText()));
                 int check=ps.executeUpdate();
                 pstemp=(PreparedStatement) conn.prepareStatement("INSERT INTO LOAISACH(MALOAI,TENTHELOAI) VALUES(?,?)");
                      rs=sttemp.executeQuery("SELECT MALOAI FROM LOAISACH");
                      int dem=0;
                      while(rs.next())
                      {
                          dem++;
                      }
                      pstemp.setString(1,"TL"+Integer.toString(dem+1));
                      pstemp.setString(2,theloainhap.getText());
                      pstemp.executeUpdate();
                 if(check==1)
                 {
                     JOptionPane.showMessageDialog(this,"đã nhập chi tiết phiếu nhập,nếu muốn dừng lại vui lòng chọn HOÀN THÀNH");
                     ps=(PreparedStatement) conn.prepareStatement("INSERT INTO SACH(MASACH,TENSACH,MATG,GIA,SLTON,MALOAI,MANCC) VALUES(?,?,?,?,?,?,?)");
                 ps.setString(1,masachnhap.getText());
                 ps.setString(2,tensachnhap.getText());
                 if(tacgianhap.isVisible())
                 {
                      pstemp=(PreparedStatement) conn.prepareStatement("INSERT INTO TACGIA(MATG,TENTG) VALUES(?,?)");
                      rs=sttemp.executeQuery("SELECT MATG FROM TACGIA");
                      int count=0;
                      while(rs.next())
                      {
                          count++;
                      }
                      pstemp.setString(1,"TG"+Integer.toString(count+1));
                      pstemp.setString(2,tacgianhap.getText());
                      pstemp.executeUpdate();
                       rs=sttemp.executeQuery("SELECT * FROM TACGIA");
                       while(rs.next())
                      {
                          if(rs.getString("TENTG").equalsIgnoreCase(tacgianhap.getText()))
                          {
                               ps.setString(3,rs.getString("MATG"));
                               break;
                          }
                      }
                 }
                 else{
                     int flag=0;
                      rs=sttemp.executeQuery("SELECT * FROM TACGIA");
                       while(rs.next())
                      {
                          if(rs.getString("TENTG").equalsIgnoreCase(tacgiaselect.getSelectedItem().toString()))
                          {
                               ps.setString(3,rs.getString("MATG"));
                               flag=1;
                               break;
                          }
                      }
                 }
                 int temp=Integer.parseInt(giasachnhap.getText());
                 ps.setInt(4,temp);
                 ps.setInt(5,Integer.parseInt(soluongsachnhap.getText())); 
                 rs=sttemp.executeQuery("SELECT * FROM LOAISACH");
                  while(rs.next())
                      {
                          if(rs.getString("TENTHELOAI").equalsIgnoreCase(theloainhap.getText()))
                          {
                               ps.setString(6,rs.getString("MALOAI"));
                               break;
                          }
                      }
                 ps.setString(7,mancc.getText());
                 ps.executeUpdate();
                 }

                 else if(check==0){
                     JOptionPane.showMessageDialog(this,"không the them duoc");
                 
                }
               
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();}
                             
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField giasachnhap;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel mancc;
    private javax.swing.JTextField masachnhap;
    private javax.swing.JTextField soluongsachnhap;
    private javax.swing.JTextField tacgianhap;
    private javax.swing.JComboBox<String> tacgiaselect;
    private javax.swing.JTextField tensachnhap;
    private javax.swing.JTextField theloainhap;
    // End of variables declaration//GEN-END:variables
}
