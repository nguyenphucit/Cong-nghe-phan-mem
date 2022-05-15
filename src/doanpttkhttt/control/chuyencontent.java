/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doanpttkhttt.control;

import doanpttkhttt.view.Banhang;
import doanpttkhttt.bean.Danhmucbean;
import doanpttkhttt.view.Khohang;
import doanpttkhttt.view.Nhanvien;
import doanpttkhttt.view.Nhaphang;
import doanpttkhttt.view.Thongke;
import doanpttkhttt.view.TrangChu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class chuyencontent {
    private JPanel jpnroot;
    private String kindselected="";
    private List<Danhmucbean> listitem=null;
    public chuyencontent(JPanel jpnroot){
        this.jpnroot=jpnroot;
    }
    public void setview(JPanel jpnitem,JLabel jlbitem)
    {
        kindselected="Bán hàng";
        jpnitem.setBackground(new Color(160,100,191));
        jlbitem.setBackground(new Color(160,100,191));
        
        jpnroot.removeAll();
        jpnroot.setLayout(new BorderLayout());
        JPanel node=new Banhang();
        jpnroot.add(node);
        jpnroot.validate();
        jpnroot.repaint();
    }
    public void setview()
    {
        jpnroot.removeAll();
        jpnroot.setLayout(new BorderLayout());
        JPanel node=new TrangChu();
        jpnroot.add(node);
        jpnroot.validate();
        jpnroot.repaint();
    }
    public void setevent(List<Danhmucbean> listitem){
        this.listitem=listitem;
        for(Danhmucbean item:listitem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb()));
        }
        
    }
        class LabelEvent implements MouseListener{

                private JPanel node;
                private String kind="";
                private JPanel jpnitem;
                private JLabel jlbitem;

        public LabelEvent(String kind,JPanel jpnitem, JLabel jlbitem) {
            this.kind=kind;
            this.jpnitem = jpnitem;
            this.jlbitem = jlbitem;
        }
                
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind)
            {
                case "Banhang":
                    node=new Banhang();
                    break;
                case "Khohang":
                    node=new Khohang();
                    break;
                case "Nhaphang":
                    node=new Nhaphang();
                    break;
                case "Doanhthu":
                    node=new Thongke();
                    break;
                case "Nhanvien":
                    node=new Nhanvien();
                    break;
                default:
                    node=new TrangChu();
                    break;
            }
            jpnroot.removeAll();
             jpnroot.setLayout(new BorderLayout());
        jpnroot.add(node);
        jpnroot.validate();
        jpnroot.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {
           kindselected=kind;
//              jpnitem.setBackground(new Color(160,100,191));
//        jlbitem.setBackground(new Color(160,100,191));
     
                setchangeBackground(kindselected);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//             if(!kindselected.equalsIgnoreCase(kind))
//           {
//            jpnitem.setBackground(new Color(102,102,255));
//            jlbitem.setBackground(new Color(102,102,255));
//           } 
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//                 jpnitem.setBackground(new Color(160,100,191));
//        jlbitem.setBackground(new Color(160,100,191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
//           if(!kindselected.equalsIgnoreCase(kind))
//           {
//            jpnitem.setBackground(new Color(102,102,255));
//        jlbitem.setBackground(new Color(102,102,255));
//           }
               
            }
            
        }
        public void setchangeBackground(String kind)
        {
            for(Danhmucbean item:listitem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(160,100,191));
                item.getJlb().setBackground(new Color(160,100,191));
                }
            else{
                 item.getJpn().setBackground(new Color(105,105,105));
                item.getJlb().setBackground(new Color(105,105,105));
            }
            }
        }
    
}
