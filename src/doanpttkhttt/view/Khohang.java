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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Khohang extends javax.swing.JPanel {
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
         String header[] = {"Mã sách", "Tên sách","Tên tác giả","Giá","Số lượng tồn","Thể loại"};
         DefaultTableModel tblModel = new DefaultTableModel(header, 0);
    public Khohang() {
        initComponents();
        jTable1.setModel(xuatdanhsachkho());
        setSACH();
       
    }
    public void setSACH()
    {
         try {
                conn =  DriverManager.getConnection(dbURL, username, password);
                st=(com.mysql.jdbc.Statement) conn.createStatement();
                rs=st.executeQuery("select MASACH FROM SACH");
               while(rs.next())
               {
                    maxoa.addItem(rs.getString("MASACH"));
                    sachsua.addItem(rs.getString("MASACH"));
               }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();}
    }
    public DefaultTableModel xuatdanhsachkho()
    {
          tblModel = new DefaultTableModel(header, 0);
             try {
                 conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 sttemp=conn.createStatement();
                 rs = st.executeQuery("select * from SACH");
            while (rs.next()) {
                                data = new Vector();
                 data.add(rs.getString("MASACH"));
                 data.add(rs.getString("TENSACH"));
                 rstemp=sttemp.executeQuery("SELECT TENTG from TACGIA WHERE MATG='"+rs.getString("MATG")+"'");
                 while(rstemp.next()){
                 data.add(rstemp.getString("TENTG"));
                 break;
                 }
                 data.add(rs.getString("GIA")+" VND");
                 data.add(rs.getInt("SLTON"));
                 rstemp=sttemp.executeQuery("SELECT TENTHELOAI FROM LOAISACH WHERE MALOAI='"+rs.getString("MALOAI")+"'");
                 while(rstemp.next()){
                 data.add(rstemp.getString("TENTHELOAI"));
                 break;

                 }
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        maxoa = new javax.swing.JComboBox<>();
        sachsua = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(799, 428));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHO");

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(84, 65));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(787, 336));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("DANH SÁCH");

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
        jTable1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 102, 102));
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
        jTable1.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jTable1.setShowHorizontalLines(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Nhập mã/tên sách cần kiếm");

        jButton1.setText("tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Mã sách cần xóa");

        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Mã sách cần sửa");

        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchbox, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(maxoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(53, 53, 53)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sachsua, 0, 142, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton2)
                    .addComponent(jLabel5)
                    .addComponent(jButton3)
                    .addComponent(maxoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sachsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Kho", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String header[] = {"Mã sách", "Tên sách","Tên tác giả","Giá","Số lượng tồn","Thể loại"};
         DefaultTableModel tblModel = new DefaultTableModel(header, 0);
             try {
//                 String dbURL = "jdbc:mysql://localhost/doanweb";
//                String username = "root";
//                String password = "";
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 sttemp=conn.createStatement();
             rs = st.executeQuery("select * from SACH where MASACH like '%"+searchbox.getText()+"%' OR TENSACH like '%"+searchbox.getText()+"%'  ");
            while (rs.next()) {
                    data = new Vector();
                    data.add(rs.getString("MASACH"));
                    data.add(rs.getString("TENSACH"));
                    rstemp=sttemp.executeQuery("SELECT TENTG from TACGIA WHERE MATG='"+rs.getString("MATG")+"'");
                    while(rstemp.next()){
                    data.add(rstemp.getString("TENTG"));
                    break;
                    }
                    data.add(rs.getString("GIA")+" VND");
                    data.add(rs.getInt("SLTON"));
                    rstemp=sttemp.executeQuery("SELECT TENTHELOAI FROM LOAISACH WHERE MALOAI='"+rs.getString("MALOAI")+"'");
                    while(rstemp.next()){
                    data.add(rstemp.getString("TENTHELOAI"));
                    break;
  }
        tblModel.addRow(data);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

       jTable1.setModel(tblModel);
        jTable1.setBounds(30, 40, 200, 300);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

             try {
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 ps=(PreparedStatement) conn.prepareStatement("delete from SACH where MASACH = '"+maxoa.getSelectedItem().toString()+"'");
                 int check=ps.executeUpdate();
                 if(check==1)
                     JOptionPane.showMessageDialog(this,"Đã xóa thành công");
                 else
                      JOptionPane.showMessageDialog(this,"Mã sách không tồn tại");
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

       jTable1.setModel(xuatdanhsachkho());
        jTable1.setBounds(30, 40, 200, 300);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

             try {
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 sttemp=conn.createStatement();
                 rs=st.executeQuery("select * from sach");
                 int flag=0;
                 String masua="";
                 String tensua="";
                 String tentgsua="";
                 int giasua=0;
                 int slton=0;
                 String theloai="";
                 while(rs.next())
                 {
                     if(rs.getString("MASACH").equalsIgnoreCase(sachsua.getSelectedItem().toString())){
                         flag=1;
                         masua=rs.getString("MASACH");
                         tensua=rs.getString("TENSACH");
                          rstemp=sttemp.executeQuery("SELECT TENTG from TACGIA WHERE MATG='"+rs.getString("MATG")+"'");
                        while(rstemp.next()){
                         tentgsua=(rstemp.getString("TENTG"));
                        break;
                    }
                         giasua=rs.getInt("GIA");
                         slton=rs.getInt("SLTON");
                          rstemp=sttemp.executeQuery("SELECT TENTHELOAI FROM LOAISACH WHERE MALOAI='"+rs.getString("MALOAI")+"'");
                    while(rstemp.next()){
                    theloai=(rstemp.getString("TENTHELOAI"));
                    break;}
                     break;}
                 }
                 if(flag==0)
                     JOptionPane.showMessageDialog(this,"Mã sách không tồn tại");
                 else if(flag==1)
                 {
                     SuaSach suabox=new SuaSach(masua,tensua,tentgsua,giasua,slton,theloai);
                     suabox.setVisible(true);
                     suabox.setBounds(600, 270,suabox.getWidth(), suabox.getHeight());
                     suabox.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> maxoa;
    private javax.swing.JComboBox<String> sachsua;
    private javax.swing.JTextField searchbox;
    // End of variables declaration//GEN-END:variables
}
