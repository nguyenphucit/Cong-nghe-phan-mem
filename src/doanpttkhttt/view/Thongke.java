/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package doanpttkhttt.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Thongke extends javax.swing.JPanel {
int tongdoanhthu=0;
    /**
     * Creates new form Thongke
     */
    public Thongke() {
        initComponents();
        Banhang a=new Banhang();
        Nhaphang b=new Nhaphang();
        headernhap.setVisible(false);
        valuenhap.setVisible(false);
        headerban.setVisible(false);
        valueban.setVisible(false);
        headerdoanhthu.setVisible(false);
        valuedoanhthu.setVisible(false);
        jTable2.setModel(b.xuatdanhsachphieunhap());
       jTable1.setModel(a.xuatdanhsach());
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
        thongke = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        headernhap = new javax.swing.JLabel();
        valuenhap = new javax.swing.JLabel();
        headerban = new javax.swing.JLabel();
        valueban = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        headerdoanhthu = new javax.swing.JLabel();
        valuedoanhthu = new javax.swing.JLabel();
        danhsachhd = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        danhsachpn = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 153, 255));
        setPreferredSize(new java.awt.Dimension(799, 428));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("THỐNG KÊ ");

        jButton1.setText("Tính tiền nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Tính tiền bán");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        headernhap.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        headernhap.setText("Tổng tiền nhập :");

        valuenhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        valuenhap.setText("jLabel3");

        headerban.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        headerban.setText("Tổng tiền bán :");

        valueban.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        valueban.setText("jLabel3");

        jButton3.setText("Tổng doanh thu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        headerdoanhthu.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        headerdoanhthu.setText("Tổng doanh thu :");

        valuedoanhthu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        valuedoanhthu.setText("jLabel3");

        javax.swing.GroupLayout thongkeLayout = new javax.swing.GroupLayout(thongke);
        thongke.setLayout(thongkeLayout);
        thongkeLayout.setHorizontalGroup(
            thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thongkeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(valueban)
                .addGap(284, 284, 284))
            .addGroup(thongkeLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(36, 36, 36)
                .addGroup(thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(thongkeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addGroup(thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thongkeLayout.createSequentialGroup()
                                    .addComponent(headernhap)
                                    .addGap(187, 187, 187))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thongkeLayout.createSequentialGroup()
                                    .addComponent(valuenhap)
                                    .addGap(288, 288, 288)))
                            .addGroup(thongkeLayout.createSequentialGroup()
                                .addGroup(thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(headerban)
                                    .addComponent(headerdoanhthu))
                                .addContainerGap())))
                    .addGroup(thongkeLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(valuedoanhthu)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        thongkeLayout.setVerticalGroup(
            thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thongkeLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(thongkeLayout.createSequentialGroup()
                        .addComponent(headernhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valuenhap)
                        .addGap(28, 28, 28)
                        .addComponent(headerban)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueban)
                        .addGap(21, 21, 21)
                        .addComponent(headerdoanhthu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valuedoanhthu))
                    .addGroup(thongkeLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê doanh thu", thongke);

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

        javax.swing.GroupLayout danhsachhdLayout = new javax.swing.GroupLayout(danhsachhd);
        danhsachhd.setLayout(danhsachhdLayout);
        danhsachhdLayout.setHorizontalGroup(
            danhsachhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhsachhdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
        );
        danhsachhdLayout.setVerticalGroup(
            danhsachhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhsachhdLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách hóa đơn", danhsachhd);

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

        javax.swing.GroupLayout danhsachpnLayout = new javax.swing.GroupLayout(danhsachpn);
        danhsachpn.setLayout(danhsachpnLayout);
        danhsachpnLayout.setHorizontalGroup(
            danhsachpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhsachpnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
        );
        danhsachpnLayout.setVerticalGroup(
            danhsachpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhsachpnLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách phiếu nhập", danhsachpn);

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
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        headerban.setVisible(true);
          
         Connection conn = null;
        Statement st = null;
        java.sql.ResultSet rs = null;
             try {
                 String dbURL = "jdbc:mysql://localhost/doanweb";
                String username = "root";
                String password = "";
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
             rs = st.executeQuery("select TONGTIEN from HOADON");
             int tongtienban=0;
            while (rs.next()) {
                tongtienban+=rs.getInt("tongtien");
            }
            tongdoanhthu+=tongtienban;
            valueban.setText(Integer.toString(tongtienban)+" VND");
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        valueban.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        headernhap.setVisible(true);
          
         Connection conn = null;
        Statement st = null;
        java.sql.ResultSet rs = null;
             try {
                 String dbURL = "jdbc:mysql://localhost/doanweb";
                String username = "root";
                String password = "";
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
             rs = st.executeQuery("select TONGTIEN from PHIEUNHAP");
             int tongtiennhap=0;
            while (rs.next()) {
                tongtiennhap+=rs.getInt("tongtien");
            }
            tongdoanhthu-=tongtiennhap;
            valuenhap.setText(Integer.toString(tongtiennhap)+" VND");
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        valuenhap.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        headerdoanhthu.setVisible(true);
        valuedoanhthu.setText(Integer.toString(tongdoanhthu));
        valuedoanhthu.setVisible(true);
        if(tongdoanhthu<0)
         JOptionPane.showMessageDialog(this,"Doanh thu của cửa hiệu : Lỗ "+valuedoanhthu.getText()+" VND");
        else if(tongdoanhthu>0)
            JOptionPane.showMessageDialog(this,"Doanh thu của cửa hiệu : Lời "+valuedoanhthu.getText()+" VND");
        else
            JOptionPane.showMessageDialog(this,"Doanh thu của cửa hiệu : Huề vốn");
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel danhsachhd;
    private javax.swing.JPanel danhsachpn;
    private javax.swing.JLabel headerban;
    private javax.swing.JLabel headerdoanhthu;
    private javax.swing.JLabel headernhap;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel thongke;
    private javax.swing.JLabel valueban;
    private javax.swing.JLabel valuedoanhthu;
    private javax.swing.JLabel valuenhap;
    // End of variables declaration//GEN-END:variables
}
