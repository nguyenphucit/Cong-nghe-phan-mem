/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package doanpttkhttt.view;

import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ADMIN
 */
public class chitiethoadon extends javax.swing.JFrame {
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
                 String header[] = {"mã sách","số lượng", "giá"};
         DefaultTableModel tblModel = new DefaultTableModel(header, 0);
    public chitiethoadon() {
        initComponents();
    }
    public chitiethoadon(String mahd) {
        initComponents();
//        JOptionPane.showMessageDialog(this,mahd);
        jLabel2.setText(mahd);
        setchitiethd();
    }

public DefaultTableModel setchitiethd()
{
     DefaultTableModel tblModel = new DefaultTableModel(header, 0);
             try {
                
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 temp=conn.createStatement();
             rs = st.executeQuery("select * from CHITIETHD WHERE MAHD='"+jLabel2.getText()+"'");
            while (rs.next()) {
                 data = new Vector();
                data.add(rs.getString("MASACH"));
                data.add(rs.getInt("SOLUONG"));
                data.add(rs.getInt("GIA"));
                 tblModel.addRow(data);
            }
            rs=st.executeQuery("SELECT TONGTIEN FROM HOADON WHERE MAHD='"+jLabel2.getText()+"'");
            while(rs.next())
            {
                jLabel4.setText(Integer.toString(rs.getInt("tongtien"))+" VND");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jLabel1.setText("chi tiết hóa đơn");

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

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 2, 14)); // NOI18N
        jLabel3.setText("Tổng tiền:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 2, 14)); // NOI18N
        jLabel4.setText("jLabel4");

        jButton1.setText("In hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void INCTHD()
    {
        try {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet spreadsheet=workbook.createSheet("Hóa đơn");
        XSSFRow row=null;
        Cell cell=null;
        row=spreadsheet.createRow((short)2);
        row.setHeight((short)500);
        row.createCell(0).setCellValue("Hóa đơn :"+jLabel2.getText());
        cell=row.createCell(0,CellType.STRING);
        cell.setCellValue("Hóa đơn");
         row=spreadsheet.createRow((short)2);
        row.setHeight((short)500);
        cell=row.createCell(0,CellType.STRING);
        cell.setCellValue("STT");
        cell=row.createCell(1,CellType.STRING);
        cell.setCellValue("Mã sách");
        cell=row.createCell(2,CellType.STRING);
        cell.setCellValue("Số lượng");
        cell=row.createCell(3,CellType.STRING);
        cell.setCellValue("Giá");
        conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
             rs = st.executeQuery("select * from CHITIETHD WHERE MAHD='"+jLabel2.getText()+"'");
             int i=0;
             while(rs.next())
             {
                 row=spreadsheet.createRow((short)4+i);
                 row.setHeight((short)400);
                 row.createCell(0).setCellValue(i+1);
                 row.createCell(1).setCellValue(rs.getString("MASACH"));
                 row.createCell(2).setCellValue((double)rs.getInt("SOLUONG"));
                 row.createCell(3).setCellValue((double)rs.getInt("GIA"));
                 i++;
             }
             rs=st.executeQuery("select tongtien from hoadon where mahd='"+jLabel2.getText()+"'");
              row=spreadsheet.createRow((short)4+i);
                 row.setHeight((short)400);
                 row.createCell(0).setCellValue("Tổng tiền");
                 while(rs.next()){
                 row.createCell(1).setCellValue((double)rs.getInt("TONGTIEN"));}
             File hd=new File("C:/Users/ADMIN/Desktop/HD.xlsx");
             FileOutputStream out=new FileOutputStream(hd);
                 workbook.write(out);
              
                 out.close();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        INCTHD();
         JOptionPane.showMessageDialog(this,"Hóa đơn đã được xuất ra");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chitiethoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chitiethoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chitiethoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chitiethoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chitiethoadon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
