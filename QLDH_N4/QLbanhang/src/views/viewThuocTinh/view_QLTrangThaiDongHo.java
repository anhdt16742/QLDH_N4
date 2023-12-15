package views.viewThuocTinh;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.model_H.GioiTinh;
import models.model_H.TrangThaiDongHo;
import services.imp.ImpSV_H.TrangThaiDH_Service;
import services.ISV_H.ITrangThaiDongHoService;

public class view_QLTrangThaiDongHo extends javax.swing.JFrame {

    ITrangThaiDongHoService trangThaiService = new TrangThaiDH_Service();

    public view_QLTrangThaiDongHo() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        txt_maTrangThai.setEditable(false);
        fillDataToTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_maTrangThai = new javax.swing.JTextField();
        txt_trangThai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_the = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_lamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_danhSachGioiTinh = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý trạng thái đồng hồ");

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Trạng thái");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_trangThai)
                    .addComponent(txt_maTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_maTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn_the.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_the.setText("Thêm");
        btn_the.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_theActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_lamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_lamMoi.setText("Làm mới");
        btn_lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_lamMoi)
                    .addComponent(btn_the, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_the)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_sua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_lamMoi)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tbl_danhSachGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_danhSachGioiTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Trạng thái"
            }
        ));
        tbl_danhSachGioiTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_danhSachGioiTinhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_danhSachGioiTinh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_theActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_theActionPerformed
        themGioiTinh();
        fillDataToTable();
    }//GEN-LAST:event_btn_theActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        suaGioiTinh();
        fillDataToTable();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
        lamMoiForm();
    }//GEN-LAST:event_btn_lamMoiActionPerformed

    private void tbl_danhSachGioiTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhSachGioiTinhMouseClicked
        clickShowData();
    }//GEN-LAST:event_tbl_danhSachGioiTinhMouseClicked

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
            java.util.logging.Logger.getLogger(view_QLTrangThaiDongHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_QLTrangThaiDongHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_QLTrangThaiDongHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_QLTrangThaiDongHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_QLTrangThaiDongHo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lamMoi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_the;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_danhSachGioiTinh;
    private javax.swing.JTextField txt_maTrangThai;
    private javax.swing.JTextField txt_trangThai;
    // End of variables declaration//GEN-END:variables

    private void fillDataToTable() {
        ArrayList<TrangThaiDongHo> dsTrangThai = new ArrayList<>();
        dsTrangThai = trangThaiService.latTTrangThaiDH();

        String columns[] = {"ID giới tính", "Giới tính"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        tableModel.setRowCount(0);

        for (TrangThaiDongHo x : dsTrangThai) {
            Object objects[] = new Object[]{x.getId(), x.getTenTrangThai()};
            tableModel.addRow(objects);
        }
        tbl_danhSachGioiTinh.setModel(tableModel);
    }

    private void themGioiTinh() {
        String loaiGioiTinh = txt_trangThai.getText();
        if (loaiGioiTinh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn cần nhập loại trạng thái mới thêm mới được");
            return;
        }

//        Integer id = Integer.parseInt(txt_maTrangThai.getText().trim());

        TrangThaiDongHo gt = new TrangThaiDongHo();
        gt.setTenTrangThai(loaiGioiTinh);

        trangThaiService.themMoiTrangThaiDH(gt);
    }

    private void suaGioiTinh() {
        int rowSelected = tbl_danhSachGioiTinh.getSelectedRow();
        if (rowSelected < 0) {
            JOptionPane.showMessageDialog(this, "Chọn thông tin trên bảng để sửa trạng thái nhanh hơn");
            return;
        }
        Integer id = Integer.parseInt(txt_maTrangThai.getText().trim());
        String loaiGioiTinh = txt_trangThai.getText();
        if (loaiGioiTinh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn cần nhập loại trạng thái mới thêm mới được");
            return;
        }

        TrangThaiDongHo gt = new TrangThaiDongHo(id, loaiGioiTinh);

        trangThaiService.suaTrangThaiDH(gt);
    }

    private void lamMoiForm() {
        txt_maTrangThai.setText("");
        txt_trangThai.setText("");
    }

    private void clickShowData() {
        int selectedRow = tbl_danhSachGioiTinh.getSelectedRow();
        txt_maTrangThai.setText(tbl_danhSachGioiTinh.getValueAt(selectedRow, 0).toString());
        txt_trangThai.setText(tbl_danhSachGioiTinh.getValueAt(selectedRow, 1).toString());

    }
}
