/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package doanpttkhttt.view;

import com.mysql.jdbc.PreparedStatement;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFrame;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ADMIN
 */
public class Banhang extends javax.swing.JPanel {
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
                 String header[] = {"mã hóa đơn","Tên người nhập", "Tên người mua ","tổng tiền"};
         DefaultTableModel tblModel = new DefaultTableModel(header, 0);
    public Banhang() {
        initComponents();
        xuatdanhsach();
        makh.setVisible(false);
        tenkhachhang.setEnabled(false);
        jLabel4.setVisible(true);
        setKH_NV();
        KH.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent e){
                     if(KH.getSelectedItem().toString().equalsIgnoreCase("Khác"))
                     {
                         makh.setVisible(true);
                         tenkhachhang.setText("");
                         tenkhachhang.setEnabled(true);
                           KH.setVisible(false);
                     }
                     else{
                          try {
                            conn =  DriverManager.getConnection(dbURL, username, password);
                            st=(com.mysql.jdbc.Statement) conn.createStatement();
                            rs=st.executeQuery("select * FROM KHACHHANG");
                           while(rs.next())
                           {
                                if(KH.getSelectedItem().toString().equalsIgnoreCase(rs.getString("MAKH")))
                                {
                                    tenkhachhang.setText(rs.getString("TENKH"));
//                                    JOptionPane.showMessageDialog(tenkhachhang, "Thông tin hóa đơn có lẽ sai hoặc đã bị trùng,vui lòng nhập lại");
                                break;
                                }
                           }
                        conn.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();}
                                 }
                             }
            });
    }
    public void setKH_NV()
    {
         try {
                conn =  DriverManager.getConnection(dbURL, username, password);
                st=(com.mysql.jdbc.Statement) conn.createStatement();
                rs=st.executeQuery("select MAKH FROM KHACHHANG");
               while(rs.next())
               {
                    KH.addItem(rs.getString("MAKH"));
               }
               KH.addItem("Khác");
                rs=st.executeQuery("select MANV FROM TAIKHOAN where chucvu='Bán hàng'");
               while(rs.next())
               {
                    NV.addItem(rs.getString("MANV"));
               }
               NV.addItem("Khác");
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();}
    }
    public void capnhat(String str){
        JOptionPane.showMessageDialog(this,str);
    }
    public DefaultTableModel xuatdanhsach()
    {
         DefaultTableModel tblModel = new DefaultTableModel(header, 0);
             try {
                
                conn = DriverManager.getConnection(dbURL, username, password);
                 st = conn.createStatement();
                 temp=conn.createStatement();
             rs = st.executeQuery("select * from HOADON");
            while (rs.next()) {
                 data = new Vector();
                data.add(rs.getString("MAHD"));
                temprs=temp.executeQuery("SELECT TENNV FROM NHANVIEN WHERE MANV='"+rs.getString("MANV")+ "'");
                while(temprs.next()){
                data.add(temprs.getString("TENNV"));
                break;}
                temprs=temp.executeQuery("SELECT TENKH FROM KHACHHANG WHERE MAKH='"+rs.getString("MAKH")+ "'");
                while(temprs.next()){
                data.add(temprs.getString("TENKH"));
                break;}
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        viewnhap = new javax.swing.JPanel();
        mahoadon = new javax.swing.JTextField();
        tenkhachhang = new javax.swing.JTextField();
        ngaynhap = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        viewChitiethoadon = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        makh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        KH = new javax.swing.JComboBox<>();
        NV = new javax.swing.JComboBox<>();
        danhsachhoadon = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("BÁN HÀNG");

        mahoadon.setBackground(new java.awt.Color(242, 242, 242));
        mahoadon.setFont(new java.awt.Font("Segoe UI Light", 2, 24)); // NOI18N
        mahoadon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        tenkhachhang.setBackground(new java.awt.Color(242, 242, 242));
        tenkhachhang.setFont(new java.awt.Font("Segoe UI Light", 2, 24)); // NOI18N
        tenkhachhang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tenkhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenkhachhangActionPerformed(evt);
            }
        });

        ngaynhap.setBackground(new java.awt.Color(242, 242, 242));
        ngaynhap.setFont(new java.awt.Font("Segoe UI Light", 2, 24)); // NOI18N
        ngaynhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        ngaynhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngaynhapActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mã hóa đơn");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Mã nhân viên ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tên người mua");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Ngày nhập hàng");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Tạo hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewChitiethoadonLayout = new javax.swing.GroupLayout(viewChitiethoadon);
        viewChitiethoadon.setLayout(viewChitiethoadonLayout);
        viewChitiethoadonLayout.setHorizontalGroup(
            viewChitiethoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );
        viewChitiethoadonLayout.setVerticalGroup(
            viewChitiethoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("hoàn thành");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Mã khách hàng");

        makh.setBackground(new java.awt.Color(242, 242, 242));
        makh.setFont(new java.awt.Font("Segoe UI Light", 2, 24)); // NOI18N
        makh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        makh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makhActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel7.setText("Mời nhập thông tin hóa đơn");

        KH.setBackground(new java.awt.Color(204, 204, 204));
        KH.setFont(new java.awt.Font("Segoe UI Light", 2, 24)); // NOI18N
        KH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        NV.setBackground(new java.awt.Color(204, 204, 204));
        NV.setFont(new java.awt.Font("Segoe UI Light", 2, 24)); // NOI18N
        NV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout viewnhapLayout = new javax.swing.GroupLayout(viewnhap);
        viewnhap.setLayout(viewnhapLayout);
        viewnhapLayout.setHorizontalGroup(
            viewnhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewnhapLayout.createSequentialGroup()
                .addGroup(viewnhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewnhapLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel7))
                    .addGroup(viewnhapLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel2))
                    .addGroup(viewnhapLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel3))
                    .addGroup(viewnhapLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel6))
                    .addGroup(viewnhapLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(viewnhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KH, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(makh, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NV, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(viewnhapLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel4))
                    .addGroup(viewnhapLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel5))
                    .addGroup(viewnhapLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton2)
                        .addGap(29, 29, 29)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(viewChitiethoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewnhapLayout.setVerticalGroup(
            viewnhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewChitiethoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewnhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewnhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(73, 126, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lập hóa đơn", viewnhap);

        danhsachhoadon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setFont(new java.awt.Font("Segoe UI Semilight", 3, 18)); // NOI18N
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout danhsachhoadonLayout = new javax.swing.GroupLayout(danhsachhoadon);
        danhsachhoadon.setLayout(danhsachhoadonLayout);
        danhsachhoadonLayout.setHorizontalGroup(
            danhsachhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, danhsachhoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                .addContainerGap())
        );
        danhsachhoadonLayout.setVerticalGroup(
            danhsachhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(danhsachhoadonLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách hóa đơn", danhsachhoadon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ngaynhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngaynhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngaynhapActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            pstemp=(PreparedStatement) conn.prepareStatement("INSERT INTO khachhang(MAKH,TENKH) VALUES(?,?)");
            if(makh.isVisible())
            pstemp.setString(1,makh.getText());
            else
            pstemp.setString(1,KH.getSelectedItem().toString());
            pstemp.setString(2,tenkhachhang.getText());
            if(makh.isVisible())
            pstemp.executeUpdate();
            ps=(PreparedStatement) conn.prepareStatement("INSERT INTO hoadon(MAHD,MANV,MAKH,TONGTIEN,NGAYTHANG) VALUES(?,?,?,0,?)");
            ps.setString(1,mahoadon.getText());
            ps.setString(2,NV.getSelectedItem().toString());
            if(makh.isVisible())
            ps.setString(3,makh.getText());
            else
            ps.setString(3,KH.getSelectedItem().toString());
            ps.setString(4,ngaynhap.getText());
            int check=ps.executeUpdate();
            if(check==1)
            {
                JOptionPane.showMessageDialog(this, "Tiến hành nhập chi tiết hóa đơn");
            }
            else if(check==0){
                JOptionPane.showMessageDialog(this,"không the them duoc");
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thông tin hóa đơn có lẽ sai hoặc đã bị trùng,vui lòng nhập lại");
            return;
        }

        viewChitiethoadon.removeAll();
        viewChitiethoadon.setLayout(new BorderLayout());
        JPanel node=new ViewChitiethoadon(mahoadon.getText());
        viewChitiethoadon.add(node);
        viewChitiethoadon.validate();
        viewChitiethoadon.repaint();
        xuatdanhsach();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        PreparedStatement st = null;
        try {
            conn =  DriverManager.getConnection(dbURL, username, password);
            st=(PreparedStatement) conn.prepareStatement("select * from chitiethd where MAHD=?");
            st.setString(1,mahoadon.getText());
            rs = st.executeQuery();
            int tong=0;
            while(rs.next())
            {
                String gia=rs.getString("GIA");
                int soluong=rs.getInt("SOLUONG");
                tong=tong+Integer.parseInt(gia)*soluong;
            }
            st=(PreparedStatement) conn.prepareStatement("UPDATE HOADON set tongtien=? where MAHD=?");
            st.setInt(1,tong);
            st.setString(2,mahoadon.getText());
            st.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();}
        viewChitiethoadon.removeAll();
        viewChitiethoadon.validate();
        viewChitiethoadon.repaint();
        xuatdanhsach();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel Model=(DefaultTableModel) jTable1.getModel();
        int selectedRow=jTable1.getSelectedRow();
        chitiethoadon cthd = new chitiethoadon(Model.getValueAt(selectedRow,0).toString());
        cthd.setVisible(true);
        cthd.setBounds(600, 270,cthd.getWidth(), cthd.getHeight());
        cthd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jTable1MouseClicked

    private void tenkhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenkhachhangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenkhachhangActionPerformed

    private void makhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_makhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> KH;
    private javax.swing.JComboBox<String> NV;
    private javax.swing.JPanel danhsachhoadon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField mahoadon;
    private javax.swing.JTextField makh;
    private javax.swing.JTextField ngaynhap;
    private javax.swing.JTextField tenkhachhang;
    private javax.swing.JPanel viewChitiethoadon;
    private javax.swing.JPanel viewnhap;
    // End of variables declaration//GEN-END:variables
}
