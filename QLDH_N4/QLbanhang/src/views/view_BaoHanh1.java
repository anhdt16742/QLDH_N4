/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.PhieuBaoHanh;
import models.PhieuGiaoBH;
import models.TemplateBaoHanh;
import models.User;
import services.imp.PhieuBaoHanhService;
import services.imp.TemplatePBHService;

/**
 *
 * @author Admin
 */
public class view_BaoHanh1 extends javax.swing.JPanel {

    private DefaultTableModel dtm1, dtm2, dtm3;
    private List<PhieuBaoHanh> listPBH;
    private List<PhieuGiaoBH> listPGBH;
    private List<TemplateBaoHanh> listTPBH;
    private PhieuBaoHanhService pbhSV;
    private TemplatePBHService tpbhSV;

    /**
     * Creates new form view_BaoHanh1
     */
    public view_BaoHanh1() {
        initComponents();
        dtm1 = new DefaultTableModel();
        dtm2 = new DefaultTableModel();
        dtm3 = new DefaultTableModel();
        listPBH = new ArrayList<>();
        listTPBH = new ArrayList<>();
        listPGBH = new ArrayList<>();
        pbhSV = new PhieuBaoHanhService();
        tpbhSV = new TemplatePBHService();
        tb_PhieuBaoHanh.setModel(dtm1);
//        tb_PhieuGiao.setModel(dtm2);
        tb_MauBaoHanh.setModel(dtm3);
        String[] headers1 = {"ID Phiếu Bảo Hành", "Tên Khách Hàng", "ID Hoá Đơn", "ID Sản Phẩm", "Ngày Mua", "Thời Hạn", "Trạng Thái"};
        String[] headers3 = {"ID Mẫu Bảo Hành", "Tên Sản Phẩm", "Thời Hạn"};
        String[] headers2 = {"ID Phiếu Giao", "ID Phiếu Bảo Hành", "Lý Do Bảo Hành", "Việc Làm", "Thời Gian Xong", "Trạng Thái"};
        dtm1.setColumnIdentifiers(headers1);
        dtm2.setColumnIdentifiers(headers2);
        dtm3.setColumnIdentifiers(headers3);
        listPBH = pbhSV.GetAll();
        listTPBH = tpbhSV.GetAll();
        showData1(listPBH);
        showData2(listPGBH);
        showData3(listTPBH);
        txt_id_bao_hanh.setEnabled(false);
        txt_id_template_bh3.setEnabled(false);
//        txt_id_PG.setEnabled(false);
        txt_id_bao_hanh.setEnabled(false);
        txt_id_hoa_don_chi_tiet.setEnabled(false);
        txt_id_khach_hang.setEnabled(false);
        txt_idsp.setEnabled(false);
        txt_ngayMua.setEnabled(false);
    }

    private void Delete() {
        txt_id_bao_hanh.setText("");
        txt_idsp.setText("");
        txt_id_khach_hang.setText("");
        txt_ngayMua.setCalendar(null);
        txt_thoiGianBH.setText("");
        cbb_trangThai1.setSelectedIndex(0);
        txt_Search.setText("");
        txt_id_hoa_don_chi_tiet.setText("");

    }

    private void showData1(List<PhieuBaoHanh> listPBH) {
        dtm1.setRowCount(0);
        for (PhieuBaoHanh pbh : listPBH) {
            dtm1.addRow(pbh.toDataRow());
        }
    }

    private void showData2(List<PhieuGiaoBH> listPGBH) {
        dtm2.setRowCount(0);
        for (PhieuGiaoBH pgbh : listPGBH) {
            dtm2.addRow(pgbh.toDataRow2());
        }
    }

    private void showData3(List<TemplateBaoHanh> listTPBH) {
        dtm3.setRowCount(0);
        for (TemplateBaoHanh pbh : listTPBH) {
            dtm3.addRow(pbh.toDataRow3());
        }
    }

    private void fillData(int index) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(listPBH.get(index).getNgayMua());
        txt_ngayMua.setDate(date1);
        txt_id_bao_hanh.setText(listPBH.get(index).getIdPBH());
        txt_thoiGianBH.setText(String.valueOf(listPBH.get(index).getThoiHan()));
        if (listPBH.get(index).getTrangThai() == 1) {
            cbb_trangThai1.setSelectedIndex(0);
        } else {
            cbb_trangThai1.setSelectedIndex(1);
        }
        txt_id_khach_hang.setText(listPBH.get(index).getHdct().getHD().getKH().getTenKhachHang());
        txt_idsp.setText(String.valueOf(listPBH.get(index).getHdct().getIdCTDH().getIdChiTietDH()));
        txt_id_hoa_don_chi_tiet.setText(listPBH.get(index).getHdct().getIdHDCT());
    }

//    private void fillData2(int index2) throws ParseException {
//        txt_id_PG.setText(listPGBH.get(index2).getIdPhieuGiao());
//        txt_id_PBH2.setText(listPGBH.get(index2).getIdPBH());
//        txt_lyDo.setText(listPGBH.get(index2).getLyDo());
//        txt_ViecLam.setText(listPGBH.get(index2).getViecLam());
//        if (listPGBH.get(index2).getTrangThai() == 1) {
//            cbb_trangThaiGiao.setSelectedIndex(0);
//        } else if (listPGBH.get(index2).getTrangThai() == 2) {
//            cbb_trangThaiGiao.setSelectedIndex(1);
//        } else {
//            cbb_trangThaiGiao.setSelectedIndex(2);
//        }
//    }

    private void fillData3(int index3) throws ParseException {
        txt_id_template_bh3.setText(listTPBH.get(index3).getIdMauBH());
        txt_tensp3.setText(listTPBH.get(index3).getTenSP());
        txt_thoi_HanBaoHanh3.setText(String.valueOf(listTPBH.get(index3).getThoiHan()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        panelBorder1 = new swing.PanelBorder();
        txt_thoiGianBH = new swing.MyTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_remove = new swing.MyButton();
        btn_update = new swing.MyButton();
        btn_clear = new swing.MyButton();
        jLabel4 = new javax.swing.JLabel();
        txt_idsp = new swing.MyTextField();
        txt_id_bao_hanh = new swing.MyTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_id_khach_hang = new swing.MyTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_Search = new swing.SearchText();
        lbl_Search = new javax.swing.JLabel();
        cbb_trangThai1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txt_id_hoa_don_chi_tiet = new swing.MyTextField();
        txt_ngayMua = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_PhieuBaoHanh = new javax.swing.JTable();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        panelBorder3 = new swing.PanelBorder();
        txt_thoi_HanBaoHanh3 = new swing.MyTextField();
        jLabel9 = new javax.swing.JLabel();
        btn_remove3 = new swing.MyButton();
        btn_update3 = new swing.MyButton();
        btn_clear3 = new swing.MyButton();
        jLabel17 = new javax.swing.JLabel();
        txt_id_template_bh3 = new swing.MyTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_tensp3 = new swing.MyTextField();
        txt_Search3 = new swing.SearchText();
        lbl_Search3 = new javax.swing.JLabel();
        btn_add3 = new swing.MyButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_MauBaoHanh = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setToolTipText("");

        jInternalFrame1.setVisible(true);

        panelBorder1.setBackground(new java.awt.Color(51, 204, 255));
        panelBorder1.add(txt_thoiGianBH);
        txt_thoiGianBH.setBounds(360, 160, 260, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Thời Hạn Bảo Hành");
        panelBorder1.add(jLabel3);
        jLabel3.setBounds(360, 140, 260, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("ID Sản Phẩm");
        panelBorder1.add(jLabel8);
        jLabel8.setBounds(360, 0, 260, 20);

        btn_remove.setBackground(new java.awt.Color(125, 224, 237));
        btn_remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash.png"))); // NOI18N
        btn_remove.setText("Xoá");
        btn_remove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_remove);
        btn_remove.setBounds(670, 150, 130, 40);

        btn_update.setBackground(new java.awt.Color(125, 224, 237));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btn_update.setText("Cập nhật");
        btn_update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_update);
        btn_update.setBounds(830, 90, 130, 40);

        btn_clear.setBackground(new java.awt.Color(125, 224, 237));
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_clear.setText("Làm mới");
        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_clear);
        btn_clear.setBounds(670, 90, 130, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("ID Phiếu Bảo Hành");
        panelBorder1.add(jLabel4);
        jLabel4.setBounds(60, 0, 260, 20);
        panelBorder1.add(txt_idsp);
        txt_idsp.setBounds(360, 20, 260, 40);
        panelBorder1.add(txt_id_bao_hanh);
        txt_id_bao_hanh.setBounds(60, 20, 260, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("ID Khách Hàng");
        panelBorder1.add(jLabel5);
        jLabel5.setBounds(60, 70, 260, 20);
        panelBorder1.add(txt_id_khach_hang);
        txt_id_khach_hang.setBounds(60, 90, 260, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Ngày Mua");
        panelBorder1.add(jLabel6);
        jLabel6.setBounds(360, 70, 260, 20);

        txt_Search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_SearchCaretUpdate(evt);
            }
        });
        panelBorder1.add(txt_Search);
        txt_Search.setBounds(660, 20, 240, 40);

        lbl_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        lbl_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_SearchMouseClicked(evt);
            }
        });
        panelBorder1.add(lbl_Search);
        lbl_Search.setBounds(900, 20, 40, 40);

        cbb_trangThai1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trong thời hạn bảo hành", "Đã hết hạn bảo hành" }));
        panelBorder1.add(cbb_trangThai1);
        cbb_trangThai1.setBounds(360, 220, 170, 22);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("ID Hoá Đơn");
        panelBorder1.add(jLabel12);
        jLabel12.setBounds(60, 140, 260, 20);

        txt_id_hoa_don_chi_tiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_hoa_don_chi_tietActionPerformed(evt);
            }
        });
        panelBorder1.add(txt_id_hoa_don_chi_tiet);
        txt_id_hoa_don_chi_tiet.setBounds(60, 160, 260, 40);
        panelBorder1.add(txt_ngayMua);
        txt_ngayMua.setBounds(360, 90, 260, 40);

        tb_PhieuBaoHanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID Phiếu Bảo Hành", "ID Khách Hàng", "ID Hoá Đơn", "ID Sản Phẩm", "Ngày Mua", "Thời Gian Bảo Hành"
            }
        ));
        tb_PhieuBaoHanh.setRowHeight(25);
        tb_PhieuBaoHanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_PhieuBaoHanhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_PhieuBaoHanh);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quản Lý Phiếu Bảo Hành", jInternalFrame1);

        jInternalFrame3.setVisible(true);

        panelBorder3.setBackground(new java.awt.Color(0, 204, 204));
        panelBorder3.add(txt_thoi_HanBaoHanh3);
        txt_thoi_HanBaoHanh3.setBounds(60, 160, 260, 40);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Thời Hạn Bảo Hành");
        panelBorder3.add(jLabel9);
        jLabel9.setBounds(60, 140, 260, 20);

        btn_remove3.setBackground(new java.awt.Color(125, 224, 237));
        btn_remove3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash.png"))); // NOI18N
        btn_remove3.setText("Xoá");
        btn_remove3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_remove3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_remove3ActionPerformed(evt);
            }
        });
        panelBorder3.add(btn_remove3);
        btn_remove3.setBounds(550, 150, 130, 40);

        btn_update3.setBackground(new java.awt.Color(125, 224, 237));
        btn_update3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppy-disk.png"))); // NOI18N
        btn_update3.setText("Cập nhật");
        btn_update3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_update3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update3ActionPerformed(evt);
            }
        });
        panelBorder3.add(btn_update3);
        btn_update3.setBounds(550, 80, 130, 40);

        btn_clear3.setBackground(new java.awt.Color(125, 224, 237));
        btn_clear3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_clear3.setText("Làm mới");
        btn_clear3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_clear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear3ActionPerformed(evt);
            }
        });
        panelBorder3.add(btn_clear3);
        btn_clear3.setBounds(360, 80, 130, 40);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("ID Mẫu Bảo Hành");
        panelBorder3.add(jLabel17);
        jLabel17.setBounds(60, 0, 260, 20);
        panelBorder3.add(txt_id_template_bh3);
        txt_id_template_bh3.setBounds(60, 20, 260, 40);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Tên Sản Phẩm");
        panelBorder3.add(jLabel18);
        jLabel18.setBounds(60, 70, 260, 20);
        panelBorder3.add(txt_tensp3);
        txt_tensp3.setBounds(60, 90, 260, 40);

        txt_Search3.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_Search3CaretUpdate(evt);
            }
        });
        panelBorder3.add(txt_Search3);
        txt_Search3.setBounds(360, 20, 240, 40);

        lbl_Search3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        lbl_Search3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_Search3MouseClicked(evt);
            }
        });
        panelBorder3.add(lbl_Search3);
        lbl_Search3.setBounds(600, 20, 40, 40);

        btn_add3.setBackground(new java.awt.Color(125, 224, 237));
        btn_add3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_add3.setText("Thêm");
        btn_add3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add3ActionPerformed(evt);
            }
        });
        panelBorder3.add(btn_add3);
        btn_add3.setBounds(360, 150, 130, 40);

        tb_MauBaoHanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID Phiếu Bảo Hành", "ID Khách Hàng", "ID Hoá Đơn", "ID Sản Phẩm", "Ngày Mua", "Thời Gian Bảo Hành"
            }
        ));
        tb_MauBaoHanh.setRowHeight(25);
        tb_MauBaoHanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_MauBaoHanhMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_MauBaoHanh);

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Mẫu Bảo Hành", jInternalFrame3);

        add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 567));
    }// </editor-fold>//GEN-END:initComponents

    private void tb_MauBaoHanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_MauBaoHanhMouseClicked
        // TODO add your handling code here:
        int index3 = tb_MauBaoHanh.getSelectedRow();
        try {
            fillData3(index3);
        } catch (ParseException ex) {
            Logger.getLogger(view_BaoHanh1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tb_MauBaoHanhMouseClicked

    private void btn_add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add3ActionPerformed
        // TODO add your handling code here:
        TemplateBaoHanh tpBH = new TemplateBaoHanh(txt_tensp3.getText(), Integer.valueOf(txt_thoi_HanBaoHanh3.getText()));
        if (tpbhSV.Add(tpBH) == true) {
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm Không Thành Công");
        }
        listTPBH = tpbhSV.GetAll();
        showData3(listTPBH);
    }//GEN-LAST:event_btn_add3ActionPerformed

    private void lbl_Search3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Search3MouseClicked
        // TODO add your handling code here:
        String id = txt_Search3.getText();
        List<TemplateBaoHanh> pbh1 = new ArrayList<>();
        pbh1 = new TemplatePBHService().GetById(Integer.valueOf(txt_Search3.getText()));
        showData3(pbh1);
    }//GEN-LAST:event_lbl_Search3MouseClicked

    private void txt_Search3CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_Search3CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Search3CaretUpdate

    private void btn_clear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear3ActionPerformed
        // TODO add your handling code here:
        txt_id_template_bh3.setText("");
        txt_tensp3.setText("");
        txt_thoi_HanBaoHanh3.setText("");
        txt_Search3.setText("");
        listTPBH = tpbhSV.GetAll();
        showData3(listTPBH);
    }//GEN-LAST:event_btn_clear3ActionPerformed

    private void btn_update3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update3ActionPerformed
        // TODO add your handling code here:
        int index3 = tb_MauBaoHanh.getSelectedRow();
        String idUpdate = listTPBH.get(index3).getIdMauBH();
        TemplateBaoHanh tpBH = new TemplateBaoHanh(txt_tensp3.getText(), Integer.valueOf(txt_thoi_HanBaoHanh3.getText()));
        if (tpbhSV.Update(tpBH, idUpdate) == true) {
            JOptionPane.showMessageDialog(this, "Sửa Thành Công");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa Không Thành Công");
        }
        listTPBH = tpbhSV.GetAll();
        showData3(listTPBH);
    }//GEN-LAST:event_btn_update3ActionPerformed

    private void btn_remove3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove3ActionPerformed
        // TODO add your handling code here:
        int index3 = tb_MauBaoHanh.getSelectedRow();
        String id = listTPBH.get(index3).getIdMauBH();
        if (tpbhSV.Delete(id) == true) {
            JOptionPane.showMessageDialog(this, "Xoá thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Xoá không thành công");
        }
        listTPBH = tpbhSV.GetAll();
        showData3(listTPBH);
    }//GEN-LAST:event_btn_remove3ActionPerformed

    private void tb_PhieuBaoHanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_PhieuBaoHanhMouseClicked
        int index = tb_PhieuBaoHanh.getSelectedRow();
        try {
            fillData(index);

            // TODO add your handling code here:
            //        try {
                //            // TODO add your handling code here:
                //            int r = tb_khuyenmai.getSelectedRow();
                //            txt_thoiGianBH.setText((String) tb_khuyenmai.getValueAt(r, 1));
                //            //            txt_giatrgiam.setText((String) tb_khuyenmai.getValueAt(r, 4));
                //            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //            Date date1 = sdf.parse((String) tb_khuyenmai.getValueAt(r, 2));
                //            Date date2 = sdf.parse((String) tb_khuyenmai.getValueAt(r, 3));
                //            date_BD.setDate(date1);
                //            date_KT.setDate(date2);
                //            String hinhthuc = tb_khuyenmai.getValueAt(r, 4).toString();
                //            String giatri = tb_khuyenmai.getValueAt(r, 4).toString();
                //            if (hinhthuc.contains("%")) {
                    //                rd_phantram.setSelected(true);
                    //            } else if (hinhthuc.contains("VND")) {
                    //                rd_VND.setSelected(true);
                    //            }
                //            if (giatri.contains("%")) {
                    //                int index = giatri.indexOf("%");
                    //                txt_id_hoa_don_chi_tiet.setText(giatri.substring(0, index));
                    //            } else if (giatri.contains("VND")) {
                    //                int index = giatri.indexOf("VND");
                    //                txt_id_hoa_don_chi_tiet.setText(giatri.substring(0, index));
                    //            }
                //        } catch (ParseException ex) {
                //            //            Logger.getLogger(FrmKhuyenmai.class.getName()).log(Level.SEVERE, null, ex);
                //        }
        } catch (ParseException ex) {
            Logger.getLogger(view_BaoHanh1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tb_PhieuBaoHanhMouseClicked

    private void txt_id_hoa_don_chi_tietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_hoa_don_chi_tietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_hoa_don_chi_tietActionPerformed

    private void lbl_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_SearchMouseClicked
        List<PhieuBaoHanh> pbh1 = new ArrayList<>();
        pbh1 = new PhieuBaoHanhService().GetById(Integer.valueOf(txt_Search.getText()));
        if (txt_Search.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập điều kiện tìm kiếm ");
        } else if (pbh1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
        } else {
            showData1(pbh1);
        }

        //        // TODO add your handling code here:
        //        if (dateTK_BD.getDate() == null && dateTK_KT.getDate() == null && src_timkiem.getText().equals("")) {
            //            JOptionPane.showMessageDialog(this, "Bạn chưa chọn ngày bắt đầu hoặc ngày kết thúc hoặc tên khuyến mãi để tìm kiếm");
            //            return;
            //        }
        //        if (dateTK_BD.getDate() != null && dateTK_KT.getDate() == null) {
            //            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //            String date3 = sdf.format(dateTK_BD.getDate());
            //            if (khuyenmaiService.GetOnebyBD(date3).isEmpty()) {
                //                JOptionPane.showMessageDialog(this, "Không có khuyến mãi nào");
                //                return;
                //            }
            //            defaultTableModel.setRowCount(0);
            //            int stt = 1;
            //            for (KhuyenmaiViewmodel x : khuyenmaiService.GetOnebyBD(date3)) {
                //                defaultTableModel.addRow(new Object[]{
                    //                    stt,
                    //                    x.getTenKM(),
                    //                    x.getNgayBatDau(),
                    //                    x.getNgayKetThuc(),
                    //                    String.format("%.0f", x.getGiaTriGiam()) + " " + x.getHinhThucKM(),
                    //                    x.getTrangthai() == 0 ? "Còn hạn" : "Hết hạn"
                    //                });
            //                stt++;
            //            }
        //            return;
        //        }
        //        if (dateTK_BD.getDate() == null && dateTK_KT.getDate() != null) {
            //            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //            String date4 = sdf.format(dateTK_KT.getDate());
            //            if (khuyenmaiService.GetOnebyKT(date4).isEmpty()) {
                //                JOptionPane.showMessageDialog(this, "Không có khuyến mãi nào");
                //                return;
                //            }
            //            defaultTableModel.setRowCount(0);
            //            int stt = 1;
            //            for (KhuyenmaiViewmodel x : khuyenmaiService.GetOnebyKT(date4)) {
                //                defaultTableModel.addRow(new Object[]{
                    //                    stt,
                    //                    x.getTenKM(),
                    //                    x.getNgayBatDau(),
                    //                    x.getNgayKetThuc(),
                    //                    String.format("%.0f", x.getGiaTriGiam()) + " " + x.getHinhThucKM(),
                    //                    x.getTrangthai() == 0 ? "Còn hạn" : "Hết hạn"
                    //                });
            //                stt++;
            //            }
        //            return;
        //        }
        //        if (dateTK_BD.getDate() != null && dateTK_KT.getDate() != null) {
            //            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //            String date3 = sdf.format(dateTK_BD.getDate());
            //            String date4 = sdf.format(dateTK_KT.getDate());
            //            if (khuyenmaiService.GetOnebyALL(date3, date4).isEmpty()) {
                //                JOptionPane.showMessageDialog(this, "Không có khuyến mãi nào");
                //                return;
                //            }
            //            defaultTableModel.setRowCount(0);
            //            int stt = 1;
            //            for (KhuyenmaiViewmodel x : khuyenmaiService.GetOnebyALL(date3, date4)) {
                //                defaultTableModel.addRow(new Object[]{
                    //                    stt,
                    //                    x.getTenKM(),
                    //                    x.getNgayBatDau(),
                    //                    x.getNgayKetThuc(),
                    //                    String.format("%.0f", x.getGiaTriGiam()) + " " + x.getHinhThucKM(),
                    //                    x.getTrangthai() == 0 ? "Còn hạn" : "Hết hạn"
                    //                });
            //                stt++;
            //            }
        //            return;
        //        }
    }//GEN-LAST:event_lbl_SearchMouseClicked

    private void txt_SearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_SearchCaretUpdate
        // TODO add your handling code here:
        //        defaultTableModel.setRowCount(0);
        //        int stt = 1;
        //        for (KhuyenmaiViewmodel x : khuyenmaiService.GetOnebyten("%" + src_timkiem.getText() + "%")) {
            //            defaultTableModel.addRow(new Object[]{
                //                stt,
                //                x.getTenKM(),
                //                x.getNgayBatDau(),
                //                x.getNgayKetThuc(),
                //                String.format("%.0f", x.getGiaTriGiam()) + " " + x.getHinhThucKM(),
                //                x.getTrangthai() == 0 ? "Còn hạn" : "Hết hạn"
                //            });
        //            stt++;
        //        }
    }//GEN-LAST:event_txt_SearchCaretUpdate

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        txt_id_bao_hanh.setText("");
        txt_idsp.setText("");
        txt_id_khach_hang.setText("");
        txt_ngayMua.setCalendar(null);
        txt_thoiGianBH.setText("");
        cbb_trangThai1.setSelectedIndex(0);
        txt_Search.setText("");
        listPBH = pbhSV.GetAll();
        Delete();
        showData1(listPBH);
        //        // TODO add your handling code here:
        //        txt_thoiGianBH.setText("");
        //        txt_id_hoa_don_chi_tiet.setText("");
        //        date_BD.setCalendar(null);
        //        date_KT.setCalendar(null);
        //        dateTK_BD.setCalendar(null);
        //        dateTK_KT.setCalendar(null);
        //        buttonGroup1.clearSelection();
        //        src_timkiem.setText("");
        //        khuyenmaiService.UpdateTT();
        //        khuyenmaiService.UpdateTT2();
        //        LoadData();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int index = tb_PhieuBaoHanh.getSelectedRow();
        //                int trangThai;
        //        if(cbb_trangThai1.getSelectedIndex()==0){
            //            trangThai=1;
            //        }else{
            //            trangThai=2;
            //        }
        String id = listPBH.get(index).getIdPBH();
        PhieuBaoHanh pbhUpdate = new PhieuBaoHanh(Integer.valueOf(txt_thoiGianBH.getText()));
        //        pbhUpdate.setNgayMua(date1);
        //        pbhUpdate.setThoiHan(Integer.valueOf(txt_thoiGianBH.getText()));
        //        pbhUpdate.setTrangThai(trangThai);
        if (pbhSV.Update(pbhUpdate, id) == true) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
        listPBH = pbhSV.GetAll();
        showData1(listPBH);
        Delete();

        //        // TODO add your handling code here:
        //        int r = tb_khuyenmai.getSelectedRow();
        //        IKhuyenmaiRepository repository = new KhuyenmaiReponsitory();
        //        List<KhuyenMai> lst = repository.GetAll();
        //
        //        if (r < 0) {
            //            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng nào");
            //            return;
            //        }
        //        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không?", "Update", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            //            KhuyenmaiViewmodel km = new KhuyenmaiViewmodel();
            //            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //            String date1 = sdf.format(date_BD.getDate());
            //            String date2 = sdf.format(date_KT.getDate());
            //            km.setNgayBatDau(date1);
            //            km.setNgayKetThuc(date2);
            //            km.setTenKM(txt_thoiGianBH.getText());
            //            if (rd_VND.isSelected()) {
                //                km.setHinhThucKM("VND");
                //            } else if (rd_phantram.isSelected()) {
                //                km.setHinhThucKM("%");
                //            }
            //            km.setGiaTriGiam(Double.parseDouble(txt_id_hoa_don_chi_tiet.getText()));
            //            if (date_KT.getDate().before(date_BD.getDate())) {
                //                JOptionPane.showMessageDialog(this, "Ngày kết thúc phải lớn hơn ngày bắt đầu");
                //                return;
                //            }
            //            long time = System.currentTimeMillis();
            //            java.sql.Date date = new java.sql.Date(time);
            //            if (date.before(chiTietSPServices.checkngay(lst.get(r).getID()))) {
                //                JOptionPane.showMessageDialog(this, "khuyến mãi chưa đến ngày áp dụng vui lòng xem và chọn khuyến mãi khác");
                //                return;
                //            }
            //            for (int i = 0; i < tb_sp.getRowCount(); i++) {
                //                boolean ischeckbox = (boolean) tb_sp.getValueAt(i, 0);
                //                if (ischeckbox) {
                    //                    System.out.println(tb_sp.getValueAt(i, 1));
                    //                    chiTietSPServices.Update(lst.get(r).getID(), tb_sp.getValueAt(i, 1).toString());
                    //                }
                //
                //            }
            //            khuyenmaiService.Update(km, lst.get(r).getID());
            //            khuyenmaiService.UpdateTT2();
            //            LoadData();
            //            JOptionPane.showMessageDialog(this, "Sửa thành công");
            //
            //        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        int index = tb_PhieuBaoHanh.getSelectedRow();
        String id = listPBH.get(index).getIdPBH();
        if (pbhSV.Delete(id) == true) {
            JOptionPane.showMessageDialog(this, "Xoá thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Xoá không thành công");
        }
        listPBH = pbhSV.GetAll();
        Delete();
        showData1(listPBH);
        ////        // TODO add your handling code here:
        ////        Pattern p = Pattern.compile("^[0-9]+$");
        ////        try {
            ////            if (txt_thoiGianBH.getText().equals("")) {
                ////                JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên khuyến mãi");
                ////                return;
                ////            }
            ////        } catch (NullPointerException e) {
            ////            e.printStackTrace();
            ////        }
        ////        try {
            ////            if (date_BD.getDate() == null) {
                ////                JOptionPane.showMessageDialog(this, "Bạn chưa chọn ngày bắt đầu");
                ////                return;
                ////            }
            ////        } catch (Exception e) {
            ////        }
        ////        try {
            ////            if (date_KT.getDate() == null) {
                ////                JOptionPane.showMessageDialog(this, "Bạn chưa chọn ngày kết thúc");
                ////                return;
                ////            }
            ////        } catch (Exception e) {
            ////        }
        ////        try {
            ////            if (!rd_VND.isSelected() && !rd_phantram.isSelected()) {
                ////                JOptionPane.showMessageDialog(this, "Bạn chưa chọn hình thức giảm giá");
                ////                return;
                ////            }
            ////        } catch (Exception e) {
            ////        }
        ////
        ////        try {
            ////            if (txt_id_hoa_don_chi_tiet.getText().equals("")) {
                ////                JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá trị giảm");
                ////                return;
                ////            }
            ////        } catch (Exception e) {
            ////        }
        ////
        ////        try {
            ////            Integer.valueOf(txt_id_hoa_don_chi_tiet.getText());
            ////        } catch (NumberFormatException e) {
            ////            JOptionPane.showMessageDialog(this, "Giá trị giảm phải là số!");
            ////            return;
            ////        }
        ////
        ////        try {
            ////            if (date_KT.getDate().before(date_BD.getDate())) {
                ////                JOptionPane.showMessageDialog(this, "Ngày kết thúc phải lớn hơn ngày bắt đầu");
                ////                return;
                ////            }
            ////        } catch (Exception e) {
            ////        }
        ////        if (p.matcher(txt_thoiGianBH.getText()).find() == true) {
            ////            JOptionPane.showMessageDialog(this, "Tên không được nhập số");
            ////            return;
            ////        }
        ////        if (txt_thoiGianBH.getText().length() > 50) {
            ////            JOptionPane.showMessageDialog(this, "Tên không được quá 50 kí tự");
            ////            return;
            ////        }
        ////        if (khuyenmaiService.checktrung(txt_thoiGianBH.getText()) != null) {
            ////            JOptionPane.showMessageDialog(this, "Tên khuyến mãi đã tồn tại");
            ////            return;
            ////        }
        ////        IKhuyenmaiRepository repository = new KhuyenmaiReponsitory();
        ////        List<KhuyenMai> lst = repository.GetAll();
        ////        long time = System.currentTimeMillis();
        ////        java.sql.Date date = new java.sql.Date(time);
        ////
        ////        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?", "Add", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            ////            KhuyenmaiViewmodel km = new KhuyenmaiViewmodel();
            ////            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ////            String date1 = sdf.format(date_BD.getDate());
            ////            String date2 = sdf.format(date_KT.getDate());
            ////            km.setNgayBatDau(date1);
            ////            km.setNgayKetThuc(date2);
            ////            km.setTenKM(txt_thoiGianBH.getText());
            ////            if (rd_VND.isSelected()) {
                ////                km.setHinhThucKM("VND");
                ////            } else if (rd_phantram.isSelected()) {
                ////                km.setHinhThucKM("%");
                ////            }
            ////            km.setGiaTriGiam(Double.parseDouble(txt_id_hoa_don_chi_tiet.getText()));
            ////            khuyenmaiService.Add(km);
            ////            LoadData();
            ////            if (date.before(chiTietSPServices.checkngay(lst.get(lst.size() - 1).getID()))) {
                ////                JOptionPane.showMessageDialog(this, "khuyến mãi chưa đến ngày áp dụng vui lòng xem và chọn khuyến mãi khác");
                ////                return;
                ////            }
            ////            for (int i = 0; i < tb_sp.getRowCount(); i++) {
                ////                boolean ischeckbox = (boolean) tb_sp.getValueAt(i, 0);
                ////                if (ischeckbox) {
                    ////                    System.out.println(tb_sp.getValueAt(i, 1));
                    ////                    chiTietSPServices.Update(lst.get(lst.size() - 1).getID(), tb_sp.getValueAt(i, 1).toString());
                    ////                }
                ////            }
            ////            JOptionPane.showMessageDialog(this, "Thêm thành công");
            ////        }
    }//GEN-LAST:event_btn_removeActionPerformed
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(view_BaoHanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(view_BaoHanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(view_BaoHanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(view_BaoHanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new view_BaoHanh1().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton btn_add3;
    private swing.MyButton btn_clear;
    private swing.MyButton btn_clear3;
    private swing.MyButton btn_remove;
    private swing.MyButton btn_remove3;
    private swing.MyButton btn_update;
    private swing.MyButton btn_update3;
    private javax.swing.JComboBox<String> cbb_trangThai1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbl_Search;
    private javax.swing.JLabel lbl_Search3;
    private swing.PanelBorder panelBorder1;
    private swing.PanelBorder panelBorder3;
    private javax.swing.JTable tb_MauBaoHanh;
    private javax.swing.JTable tb_PhieuBaoHanh;
    private swing.SearchText txt_Search;
    private swing.SearchText txt_Search3;
    private swing.MyTextField txt_id_bao_hanh;
    private swing.MyTextField txt_id_hoa_don_chi_tiet;
    private swing.MyTextField txt_id_khach_hang;
    private swing.MyTextField txt_id_template_bh3;
    private swing.MyTextField txt_idsp;
    private com.toedter.calendar.JDateChooser txt_ngayMua;
    private swing.MyTextField txt_tensp3;
    private swing.MyTextField txt_thoiGianBH;
    private swing.MyTextField txt_thoi_HanBaoHanh3;
    // End of variables declaration//GEN-END:variables

}
