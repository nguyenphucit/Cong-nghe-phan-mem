/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package doanpttkhttt.view;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ADMIN
 */
public class Thongke extends javax.swing.JPanel {
int tongdoanhthu=0;
                String dbURL = "jdbc:mysql://localhost/csdl";
                String username = "root";
                String password = "";
                Connection conn = null;
        Statement st = null;
        java.sql.ResultSet rs = null;
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
    public void InHD()
    {
        try {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet spreadsheet=workbook.createSheet("Hóa đơn");
        XSSFRow row=null;
        Cell cell=null;
        row=spreadsheet.createRow((short)2);
        row.setHeight((short)500);
        cell=row.createCell(0,CellType.STRING);
        cell.setCellValue("Danh sách hóa đơn");
        //stt//
         row=spreadsheet.createRow((short)2);
        row.setHeight((short)500);
        cell=row.createCell(0,CellType.STRING);
        cell.setCellValue("STT");
        //mahd//
        cell=row.createCell(1,CellType.STRING);
        cell.setCellValue("Mã hóa đơn");
        //MANV//
        cell=row.createCell(2,CellType.STRING);
        cell.setCellValue("Mã nhân viên");
        //MAKH//
        cell=row.createCell(3,CellType.STRING);
        cell.setCellValue("Mã khách hàng");
        //TONGTIEN//
        cell=row.createCell(4,CellType.STRING);
        cell.setCellValue("Tổng tiền");
        //NGAYTHANG//
        cell=row.createCell(5,CellType.STRING);
        cell.setCellValue("Ngày nhập");
        conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
             rs = st.executeQuery("select * from HOADON");
             int i=0;
             while(rs.next())
             {
                 row=spreadsheet.createRow((short)4+i);
                 row.setHeight((short)400);
                 row.createCell(0).setCellValue(i+1);
                 row.createCell(1).setCellValue(rs.getString("MAHD"));
                 row.createCell(2).setCellValue(rs.getString("MANV"));
                 row.createCell(3).setCellValue(rs.getString("MAKH"));
                 row.createCell(4).setCellValue((double)rs.getInt("TONGTIEN"));
                 row.createCell(5).setCellValue(rs.getString("NGAYTHANG"));
                 i++;
             }

             File hd=new File("C:/Users/ADMIN/Desktop/DSHD.xlsx");
             FileOutputStream out=new FileOutputStream(hd);
                 workbook.write(out);
              
                 out.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void InPN()
    {
        try {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet spreadsheet=workbook.createSheet("Phiếu nhập");
        XSSFRow row=null;
        Cell cell=null;
        row=spreadsheet.createRow((short)2);
        row.setHeight((short)500);
        cell=row.createCell(0,CellType.STRING);
        cell.setCellValue("Danh sách phiếu nhập");
        //stt//
         row=spreadsheet.createRow((short)2);
        row.setHeight((short)500);
        cell=row.createCell(0,CellType.STRING);
        cell.setCellValue("STT");
        //mahd//
        cell=row.createCell(1,CellType.STRING);
        cell.setCellValue("Mã phiếu nhập");
        //MANV//
        cell=row.createCell(2,CellType.STRING);
        cell.setCellValue("Mã nhân viên");
        //MAKH//
        cell=row.createCell(3,CellType.STRING);
        cell.setCellValue("Mã nhà cung cấp");
        //TONGTIEN//
        cell=row.createCell(4,CellType.STRING);
        cell.setCellValue("Tổng tiền");
        //NGAYTHANG//
        cell=row.createCell(5,CellType.STRING);
        cell.setCellValue("Ngày nhập");
        conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
             rs = st.executeQuery("select * from PHIEUNHAP");
             int i=0;
             while(rs.next())
             {
                 row=spreadsheet.createRow((short)4+i);
                 row.setHeight((short)400);
                 row.createCell(0).setCellValue(i+1);
                 row.createCell(1).setCellValue(rs.getString("MAPN"));
                 row.createCell(2).setCellValue(rs.getString("MANV"));
                 row.createCell(3).setCellValue(rs.getString("MANCC"));
                 row.createCell(4).setCellValue((double)rs.getInt("TONGTIEN"));
                 row.createCell(5).setCellValue(rs.getString("NGAYTHANG"));
                 i++;
             }

             File hd=new File("C:/Users/ADMIN/Desktop/DSPN.xlsx");
             FileOutputStream out=new FileOutputStream(hd);
                 workbook.write(out);
              
                 out.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        jButton6 = new javax.swing.JButton();
        danhsachpn = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 153, 255));
        setPreferredSize(new java.awt.Dimension(799, 428));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("THỐNG KÊ ");

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jButton1.setText("Tính tiền nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jButton2.setText("Tính tiền bán");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        headernhap.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        headernhap.setText("Tổng tiền nhập :");

        valuenhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        valuenhap.setText("jLabel3");

        headerban.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        headerban.setText("Tổng tiền bán :");

        valueban.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        valueban.setText("jLabel3");

        jButton3.setBackground(new java.awt.Color(153, 255, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jButton3.setText("Tổng doanh thu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        headerdoanhthu.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        headerdoanhthu.setText("Tổng doanh thu :");

        valuedoanhthu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        valuedoanhthu.setText("jLabel3");

        javax.swing.GroupLayout thongkeLayout = new javax.swing.GroupLayout(thongke);
        thongke.setLayout(thongkeLayout);
        thongkeLayout.setHorizontalGroup(
            thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thongkeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(valuedoanhthu)
                .addGap(278, 278, 278))
            .addGroup(thongkeLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thongkeLayout.createSequentialGroup()
                        .addComponent(valueban)
                        .addGap(284, 284, 284))))
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
                        .addGap(28, 28, 28)
                        .addComponent(headerdoanhthu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valuedoanhthu))
                    .addGroup(thongkeLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê doanh thu", thongke);

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
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

        jButton6.setBackground(new java.awt.Color(255, 255, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanpttkhttt/icon_image/icons8-printer-30.png"))); // NOI18N
        jButton6.setText("In danh sách hóa đơn");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout danhsachhdLayout = new javax.swing.GroupLayout(danhsachhd);
        danhsachhd.setLayout(danhsachhdLayout);
        danhsachhdLayout.setHorizontalGroup(
            danhsachhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhsachhdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(danhsachhdLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        danhsachhdLayout.setVerticalGroup(
            danhsachhdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, danhsachhdLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách hóa đơn", danhsachhd);

        jScrollPane2.setBackground(new java.awt.Color(102, 255, 255));

        jTable2.setBackground(new java.awt.Color(102, 255, 255));
        jTable2.setFont(new java.awt.Font("Segoe UI Light", 2, 18)); // NOI18N
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

        jButton7.setBackground(new java.awt.Color(102, 255, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanpttkhttt/icon_image/icons8-printer-30.png"))); // NOI18N
        jButton7.setText("In danh sách phiếu nhập");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout danhsachpnLayout = new javax.swing.GroupLayout(danhsachpn);
        danhsachpn.setLayout(danhsachpnLayout);
        danhsachpnLayout.setHorizontalGroup(
            danhsachpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
            .addGroup(danhsachpnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        danhsachpnLayout.setVerticalGroup(
            danhsachpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, danhsachpnLayout.createSequentialGroup()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách phiếu nhập", danhsachpn);

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
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        headerban.setVisible(true);
             try {
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
             try {
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
        valuedoanhthu.setText(Integer.toString(tongdoanhthu)+" VND");
        valuedoanhthu.setVisible(true);
        if(tongdoanhthu<0)
         JOptionPane.showMessageDialog(this,"Doanh thu của cửa hiệu : Lỗ "+valuedoanhthu.getText()+" VND");
        else if(tongdoanhthu>0)
            JOptionPane.showMessageDialog(this,"Doanh thu của cửa hiệu : Lời "+valuedoanhthu.getText()+" VND");
        else
            JOptionPane.showMessageDialog(this,"Doanh thu của cửa hiệu : Huề vốn");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        InHD();
        JOptionPane.showMessageDialog(this,"Đã xuất file Excel ra màn hình chính");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        InPN();
         JOptionPane.showMessageDialog(this,"Đã xuất file Excel ra màn hình chính");
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel danhsachhd;
    private javax.swing.JPanel danhsachpn;
    private javax.swing.JLabel headerban;
    private javax.swing.JLabel headerdoanhthu;
    private javax.swing.JLabel headernhap;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
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
