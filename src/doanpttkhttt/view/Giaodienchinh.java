/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package doanpttkhttt.view;

import doanpttkhttt.bean.Danhmucbean;
import doanpttkhttt.control.chuyencontent;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class Giaodienchinh extends javax.swing.JFrame {

    /**
     * Creates new form Giaodienchinh
     */
    public Giaodienchinh() {
        initComponents();
        setTitle("Quản lý cửa hàng sách");
        chuyencontent chuyen = new chuyencontent(jpnView);
//        chuyen.setview(jpnBanhang,jlbBanhang);
        chuyen.setview();
        List<Danhmucbean> listitem=new ArrayList<>();
        listitem.add(new Danhmucbean("Banhang",jpnBanhang,jlbBanhang));
          listitem.add(new Danhmucbean("Khohang",jpnKho,jlbKho));
          listitem.add(new Danhmucbean("Nhaphang",jpnNhaphang,jlbNhaphang));
          listitem.add(new Danhmucbean("Doanhthu",jpnDoanhthu,jlbDoanhthu));
          listitem.add(new Danhmucbean("Nhanvien",jpnNhanvien,jlbNhanvien));
          chuyen.setevent(listitem);
    }
 class jPanelGradient extends JPanel{
        protected void paintComponent(Graphics g)
        {
           Graphics2D g2d=(Graphics2D) g; 
           int width=getWidth();
           int height=getHeight();
           Color color1 = new Color(52,142,80);
           Color color2=new Color(86,182,211);
           GradientPaint gp=new GradientPaint(0,0,color1,180,height,color2);
           g2d.setPaint(gp);
           g2d.fillRect(0,0, width, height);
             
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

        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jpnBanhang = new javax.swing.JPanel();
        jlbBanhang = new javax.swing.JLabel();
        jpnKho = new javax.swing.JPanel();
        jlbKho = new javax.swing.JLabel();
        jpnNhaphang = new javax.swing.JPanel();
        jlbNhaphang = new javax.swing.JLabel();
        jpnDoanhthu = new javax.swing.JPanel();
        jlbDoanhthu = new javax.swing.JLabel();
        jpnNhanvien = new javax.swing.JPanel();
        jlbNhanvien = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        logout = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 102, 153));

        jPanel7.setBackground(new java.awt.Color(105, 105, 105));

        jPanel6.setBackground(new java.awt.Color(255, 204, 102));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanpttkhttt/icon_image/icons8-book-50.png"))); // NOI18N
        jLabel3.setText("Quản lí cửa hàng sách");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jpnBanhang.setBackground(new java.awt.Color(105, 105, 105));

        jlbBanhang.setFont(new java.awt.Font("Segoe UI Light", 3, 24)); // NOI18N
        jlbBanhang.setForeground(new java.awt.Color(255, 255, 102));
        jlbBanhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanpttkhttt/icon_image/icons8-shopping-cart-promotion-30.png"))); // NOI18N
        jlbBanhang.setText("Quản lí bán hàng");

        javax.swing.GroupLayout jpnBanhangLayout = new javax.swing.GroupLayout(jpnBanhang);
        jpnBanhang.setLayout(jpnBanhangLayout);
        jpnBanhangLayout.setHorizontalGroup(
            jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBanhangLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jlbBanhang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnBanhangLayout.setVerticalGroup(
            jpnBanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBanhangLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jlbBanhang, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpnKho.setBackground(new java.awt.Color(105, 105, 105));
        jpnKho.setPreferredSize(new java.awt.Dimension(208, 90));

        jlbKho.setFont(new java.awt.Font("Segoe UI Light", 3, 24)); // NOI18N
        jlbKho.setForeground(new java.awt.Color(255, 255, 102));
        jlbKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanpttkhttt/icon_image/icons8-warehouse-30.png"))); // NOI18N
        jlbKho.setText("Quản lí kho hàng");

        javax.swing.GroupLayout jpnKhoLayout = new javax.swing.GroupLayout(jpnKho);
        jpnKho.setLayout(jpnKhoLayout);
        jpnKhoLayout.setHorizontalGroup(
            jpnKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhoLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jlbKho, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnKhoLayout.setVerticalGroup(
            jpnKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnKhoLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jlbKho)
                .addGap(20, 20, 20))
        );

        jpnNhaphang.setBackground(new java.awt.Color(105, 105, 105));
        jpnNhaphang.setPreferredSize(new java.awt.Dimension(208, 90));

        jlbNhaphang.setFont(new java.awt.Font("Segoe UI Light", 3, 24)); // NOI18N
        jlbNhaphang.setForeground(new java.awt.Color(255, 255, 102));
        jlbNhaphang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanpttkhttt/icon_image/icons8-container-truck-30.png"))); // NOI18N
        jlbNhaphang.setText("Quản lí nhập hàng");

        javax.swing.GroupLayout jpnNhaphangLayout = new javax.swing.GroupLayout(jpnNhaphang);
        jpnNhaphang.setLayout(jpnNhaphangLayout);
        jpnNhaphangLayout.setHorizontalGroup(
            jpnNhaphangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNhaphangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbNhaphang)
                .addGap(76, 76, 76))
        );
        jpnNhaphangLayout.setVerticalGroup(
            jpnNhaphangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhaphangLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlbNhaphang)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jpnDoanhthu.setBackground(new java.awt.Color(105, 105, 105));
        jpnDoanhthu.setPreferredSize(new java.awt.Dimension(208, 90));

        jlbDoanhthu.setFont(new java.awt.Font("Segoe UI Light", 3, 24)); // NOI18N
        jlbDoanhthu.setForeground(new java.awt.Color(255, 255, 102));
        jlbDoanhthu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanpttkhttt/icon_image/icons8-statistics-30.png"))); // NOI18N
        jlbDoanhthu.setText("Thống kê doanh thu");

        javax.swing.GroupLayout jpnDoanhthuLayout = new javax.swing.GroupLayout(jpnDoanhthu);
        jpnDoanhthu.setLayout(jpnDoanhthuLayout);
        jpnDoanhthuLayout.setHorizontalGroup(
            jpnDoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDoanhthuLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jlbDoanhthu)
                .addGap(69, 69, 69))
        );
        jpnDoanhthuLayout.setVerticalGroup(
            jpnDoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDoanhthuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jlbDoanhthu)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jpnNhanvien.setBackground(new java.awt.Color(105, 105, 105));
        jpnNhanvien.setPreferredSize(new java.awt.Dimension(208, 90));

        jlbNhanvien.setFont(new java.awt.Font("Segoe UI Light", 3, 24)); // NOI18N
        jlbNhanvien.setForeground(new java.awt.Color(255, 255, 102));
        jlbNhanvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanpttkhttt/icon_image/icons8-employee-50.png"))); // NOI18N
        jlbNhanvien.setText("Quản lý nhân viên");

        javax.swing.GroupLayout jpnNhanvienLayout = new javax.swing.GroupLayout(jpnNhanvien);
        jpnNhanvien.setLayout(jpnNhanvienLayout);
        jpnNhanvienLayout.setHorizontalGroup(
            jpnNhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanvienLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jlbNhanvien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnNhanvienLayout.setVerticalGroup(
            jpnNhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanvienLayout.createSequentialGroup()
                .addComponent(jlbNhanvien)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(334, 107));

        logout.setBackground(new java.awt.Color(255, 204, 102));
        logout.setFont(new java.awt.Font("Segoe UI Semilight", 3, 32)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 0, 51));
        logout.setText("Đăng xuất");
        logout.setBorder(null);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(logout)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(logout)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnBanhang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnKho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .addComponent(jpnNhaphang, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .addComponent(jpnDoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .addComponent(jpnNhanvien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnBanhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpnKho, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpnNhaphang, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpnDoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpnNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {                                       
        int input = JOptionPane.showConfirmDialog(this, "Bạn có chắc là muốn đăng xuất ?");
        if(input==0){
        DangNhap dn=new DangNhap();
        dn.setVisible(true);
        this.dispose();
        }

    }                                      

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
            java.util.logging.Logger.getLogger(Giaodienchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Giaodienchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Giaodienchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Giaodienchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giaodienchinh().setVisible(true);
            }
        });
    }
    public void thungan()
    {
        this.jpnKho.setVisible(false);
        this.jpnDoanhthu.setVisible(false);
        this.jpnNhaphang.setVisible(false);
        this.jpnNhanvien.setVisible(false);
        this.jlbKho.setVisible(false);
    }
    public void thukho()
    {
        this.jpnDoanhthu.setVisible(false);
        this.jpnNhanvien.setVisible(false);     
        this.jpnBanhang.setVisible(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel jlbBanhang;
    private javax.swing.JLabel jlbDoanhthu;
    private javax.swing.JLabel jlbKho;
    private javax.swing.JLabel jlbNhanvien;
    private javax.swing.JLabel jlbNhaphang;
    private javax.swing.JPanel jpnBanhang;
    private javax.swing.JPanel jpnDoanhthu;
    private javax.swing.JPanel jpnKho;
    private javax.swing.JPanel jpnNhanvien;
    private javax.swing.JPanel jpnNhaphang;
    private javax.swing.JPanel jpnView;
    private javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables
}
