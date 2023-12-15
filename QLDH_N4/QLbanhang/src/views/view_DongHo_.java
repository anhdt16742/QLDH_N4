package views;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.DongHo;
import models.TrangThaiDongHo;
import repositorys.ITrangThaiDongHoRepository;
import services.ITrangThaiDongHoService;
import services.imp.DongHoService;
import services.imp.TrangThaiDH_Service;


public class view_DongHo_ extends javax.swing.JFrame {

    DongHoService dongHoService = new DongHoService();
    ITrangThaiDongHoService trangThaiDHService = new TrangThaiDH_Service();
    ArrayList<DongHo> dsDongHo = new ArrayList<>();

    public view_DongHo_() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        txt_maDH.setEditable(false);
        txt_tenDH.requestFocus();
        this.fillDataToTable();
        this.fillDataToCombobox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_titleQuanLyDongHo = new javax.swing.JLabel();
        pn_nhomChucNang = new javax.swing.JPanel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_lamMoi = new javax.swing.JButton();
        pn_thongTinDongHo = new javax.swing.JPanel();
        lbl_xuatXu = new javax.swing.JLabel();
        lbl_nsx = new javax.swing.JLabel();
        lbl_thuongHieu = new javax.swing.JLabel();
        lbl_tenDongHo = new javax.swing.JLabel();
        lbl_chatLieuMatSo = new javax.swing.JLabel();
        txt_chatLieuMatSo = new javax.swing.JTextField();
        lbl_duongKinhMatSo = new javax.swing.JLabel();
        lbl_beDayMatSo = new javax.swing.JLabel();
        txt_nsx = new javax.swing.JTextField();
        txt_xuatXu = new javax.swing.JTextField();
        txt_thuongHieu = new javax.swing.JTextField();
        txt_duongKinh = new javax.swing.JTextField();
        txt_beDay = new javax.swing.JTextField();
        lbl_trangThai = new javax.swing.JLabel();
        cbx_trangThai = new javax.swing.JComboBox<>();
        txt_tenDH = new javax.swing.JTextField();
        txt_maDH = new javax.swing.JTextField();
        lbl_maDH = new javax.swing.JLabel();
        txt_tinhNang = new javax.swing.JTextField();
        lbl_tinhNang = new javax.swing.JLabel();
        lbl_thangBaoHanh = new javax.swing.JLabel();
        txt_baoHanh = new javax.swing.JTextField();
        lbl_baoHanh = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_showThongTinDH = new javax.swing.JTable();
        cbx_locTrangThai = new javax.swing.JComboBox<>();
        lbl_locTrangThai = new javax.swing.JLabel();
        lbl_locTenDH = new javax.swing.JLabel();
        txt_locTheoTenDH = new javax.swing.JTextField();
        btn_loc = new javax.swing.JButton();
        btn_timKiem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_titleQuanLyDongHo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_titleQuanLyDongHo.setText("Quản lý đồng hồ");

        pn_nhomChucNang.setBackground(new java.awt.Color(255, 255, 255));
        pn_nhomChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        btn_them.setText("Thêm đồng hồ");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa đồng hồ");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa đồng hồ");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_lamMoi.setText("Làm mới");
        btn_lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_nhomChucNangLayout = new javax.swing.GroupLayout(pn_nhomChucNang);
        pn_nhomChucNang.setLayout(pn_nhomChucNangLayout);
        pn_nhomChucNangLayout.setHorizontalGroup(
            pn_nhomChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_nhomChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_nhomChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_sua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_lamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_them, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_nhomChucNangLayout.setVerticalGroup(
            pn_nhomChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_nhomChucNangLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_them)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn_xoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_lamMoi)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pn_thongTinDongHo.setBackground(new java.awt.Color(51, 204, 255));
        pn_thongTinDongHo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin đồng hồ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N
        pn_thongTinDongHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_thongTinDongHoMouseClicked(evt);
            }
        });

        lbl_xuatXu.setText("Xuất xứ");

        lbl_nsx.setText("Nhà sản xuất");

        lbl_thuongHieu.setText("Thương hiệu");

        lbl_tenDongHo.setText("Tên đồng hồ");

        lbl_chatLieuMatSo.setText("Chất liệu mặt số");

        txt_chatLieuMatSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chatLieuMatSoActionPerformed(evt);
            }
        });

        lbl_duongKinhMatSo.setText("Đường kính mặt số");

        lbl_beDayMatSo.setText("Bề dày mặt số");

        txt_thuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_thuongHieuActionPerformed(evt);
            }
        });

        txt_duongKinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_duongKinhActionPerformed(evt);
            }
        });

        txt_beDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_beDayActionPerformed(evt);
            }
        });

        lbl_trangThai.setText("Trang thái");

        cbx_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbl_maDH.setText("Mã đồng hồ");

        lbl_tinhNang.setText("Tính năng");

        lbl_thangBaoHanh.setText("Tháng");

        txt_baoHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_baoHanhActionPerformed(evt);
            }
        });

        lbl_baoHanh.setText("Bảo hành");

        javax.swing.GroupLayout pn_thongTinDongHoLayout = new javax.swing.GroupLayout(pn_thongTinDongHo);
        pn_thongTinDongHo.setLayout(pn_thongTinDongHoLayout);
        pn_thongTinDongHoLayout.setHorizontalGroup(
            pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_thongTinDongHoLayout.createSequentialGroup()
                .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_thongTinDongHoLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_tenDongHo)
                            .addComponent(lbl_maDH))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tenDH, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_maDH, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pn_thongTinDongHoLayout.createSequentialGroup()
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pn_thongTinDongHoLayout.createSequentialGroup()
                                    .addGap(61, 61, 61)
                                    .addComponent(lbl_xuatXu))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_thongTinDongHoLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lbl_chatLieuMatSo)))
                            .addComponent(lbl_nsx, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_thuongHieu, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_thuongHieu, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(txt_chatLieuMatSo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_nsx)
                                .addComponent(txt_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_thongTinDongHoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lbl_duongKinhMatSo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_duongKinh, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_thongTinDongHoLayout.createSequentialGroup()
                            .addComponent(lbl_tinhNang)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_tinhNang, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pn_thongTinDongHoLayout.createSequentialGroup()
                            .addGap(95, 95, 95)
                            .addComponent(lbl_baoHanh)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_baoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbl_thangBaoHanh)
                            .addGap(30, 30, 30)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_thongTinDongHoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_beDayMatSo)
                            .addComponent(lbl_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbx_trangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_beDay, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11))
        );
        pn_thongTinDongHoLayout.setVerticalGroup(
            pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_thongTinDongHoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_thongTinDongHoLayout.createSequentialGroup()
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_maDH)
                            .addComponent(txt_maDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_tenDongHo)
                            .addComponent(txt_tenDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_xuatXu)
                            .addComponent(txt_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_thuongHieu)
                            .addComponent(txt_thuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nsx)
                            .addComponent(txt_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_chatLieuMatSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_chatLieuMatSo)))
                    .addGroup(pn_thongTinDongHoLayout.createSequentialGroup()
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_duongKinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_duongKinhMatSo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_beDayMatSo)
                            .addComponent(txt_beDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tinhNang, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_thongTinDongHoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbl_tinhNang)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_baoHanh)
                            .addComponent(txt_baoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_thangBaoHanh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pn_thongTinDongHoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_trangThai)
                            .addComponent(cbx_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(135, 135, 135))
        );

        tbl_showThongTinDH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã đồng hồ", "Tên đồng hồ", "Xuất xứ", "Thương hiệu", "NSX", "Chất liệu mặt số", "Đường kính mặt số", "Bề dày mặt số", "Trạng thái"
            }
        ));
        tbl_showThongTinDH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_showThongTinDHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_showThongTinDH);

        cbx_locTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_locTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_locTrangThaiActionPerformed(evt);
            }
        });
        cbx_locTrangThai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_locTrangThaiKeyPressed(evt);
            }
        });

        lbl_locTrangThai.setText("Lọc trạng thái");

        lbl_locTenDH.setText("Tìm theo tên đồng hồ");

        btn_loc.setText("Lọc");
        btn_loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_locActionPerformed(evt);
            }
        });

        btn_timKiem.setText("Tìm kiếm ");
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_locTrangThai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_locTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_loc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_locTenDH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_locTheoTenDH, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_timKiem)
                        .addGap(76, 76, 76))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_locTrangThai)
                    .addComponent(cbx_locTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_locTenDH)
                    .addComponent(txt_locTheoTenDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timKiem)
                    .addComponent(btn_loc))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_titleQuanLyDongHo)
                        .addGap(323, 323, 323))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pn_thongTinDongHo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pn_nhomChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titleQuanLyDongHo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_nhomChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_thongTinDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 255, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        themMoi();
        this.fillDataToTable();
    }//GEN-LAST:event_btn_themActionPerformed

    private void tbl_showThongTinDHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_showThongTinDHMouseClicked
        clickShowData();
    }//GEN-LAST:event_tbl_showThongTinDHMouseClicked

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        xoaDongHo();
        lamMoiForm();
        this.fillDataToTable();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
        this.lamMoiForm();
    }//GEN-LAST:event_btn_lamMoiActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        suaDongHo();
        this.lamMoiForm();
        this.fillDataToTable();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_chatLieuMatSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chatLieuMatSoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chatLieuMatSoActionPerformed

    private void txt_thuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_thuongHieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_thuongHieuActionPerformed

    private void txt_duongKinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_duongKinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_duongKinhActionPerformed

    private void txt_beDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_beDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_beDayActionPerformed

    private void pn_thongTinDongHoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_thongTinDongHoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pn_thongTinDongHoMouseClicked

    private void txt_baoHanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_baoHanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_baoHanhActionPerformed

    private void cbx_locTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_locTrangThaiActionPerformed

    }//GEN-LAST:event_cbx_locTrangThaiActionPerformed

    private void cbx_locTrangThaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_locTrangThaiKeyPressed
       
    }//GEN-LAST:event_cbx_locTrangThaiKeyPressed

    private void btn_locActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_locActionPerformed
        this.fillTrangThaiLocTheoTrangThaiLenTable();
    }//GEN-LAST:event_btn_locActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        this.fillTrangThaiLocTheoTenLenTable();
    }//GEN-LAST:event_btn_timKiemActionPerformed

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
            java.util.logging.Logger.getLogger(view_DongHo_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_DongHo_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_DongHo_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_DongHo_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new view_DongHo_().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lamMoi;
    private javax.swing.JButton btn_loc;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbx_locTrangThai;
    private javax.swing.JComboBox<String> cbx_trangThai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_baoHanh;
    private javax.swing.JLabel lbl_beDayMatSo;
    private javax.swing.JLabel lbl_chatLieuMatSo;
    private javax.swing.JLabel lbl_duongKinhMatSo;
    private javax.swing.JLabel lbl_locTenDH;
    private javax.swing.JLabel lbl_locTrangThai;
    private javax.swing.JLabel lbl_maDH;
    private javax.swing.JLabel lbl_nsx;
    private javax.swing.JLabel lbl_tenDongHo;
    private javax.swing.JLabel lbl_thangBaoHanh;
    private javax.swing.JLabel lbl_thuongHieu;
    private javax.swing.JLabel lbl_tinhNang;
    private javax.swing.JLabel lbl_titleQuanLyDongHo;
    private javax.swing.JLabel lbl_trangThai;
    private javax.swing.JLabel lbl_xuatXu;
    private javax.swing.JPanel pn_nhomChucNang;
    private javax.swing.JPanel pn_thongTinDongHo;
    private javax.swing.JTable tbl_showThongTinDH;
    private javax.swing.JTextField txt_baoHanh;
    private javax.swing.JTextField txt_beDay;
    private javax.swing.JTextField txt_chatLieuMatSo;
    private javax.swing.JTextField txt_duongKinh;
    private javax.swing.JTextField txt_locTheoTenDH;
    private javax.swing.JTextField txt_maDH;
    private javax.swing.JTextField txt_nsx;
    private javax.swing.JTextField txt_tenDH;
    private javax.swing.JTextField txt_thuongHieu;
    private javax.swing.JTextField txt_tinhNang;
    private javax.swing.JTextField txt_xuatXu;
    // End of variables declaration//GEN-END:variables

    private void fillDataToTable() {
        ArrayList<DongHo> ds_dongHo = new ArrayList<>();
        ds_dongHo.clear();
        ds_dongHo = dongHoService.layThongTinDH();
        //tenDongHo, thuongHieu, xuatXu, noiSanXuat, chatLieuMatSo, duongKinhMatSo, beDayMatSo, idTrangThaiDH
        String columns[] = {"Mã đồng hồ", "Tên đồng hồ", "Thương hiệu", "Xuất xứ", "NSX", "Chất liệu","Tính năng","Thời gian BH", "Trạng thái"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        tableModel.setRowCount(0);

        for (DongHo x : ds_dongHo) {
            int idTrangThai = x.getIdTrangThaiDH();
            String trangThai = this.trangThaiDHService.layTrangThaiBangID(idTrangThai);
            Object objects[] = new Object[]{x.getId(), x.getTen(), x.getThuongHieu(), x.getXuatXu()
                    , x.getNoiSanXuat(), x.getChatLieuMatSo(),
                    x.getTinhNang(), x.getThoiGianBH(), trangThai};
            tableModel.addRow(objects);
        }
        tbl_showThongTinDH.setModel(tableModel);
    }

    private void clickShowData() {
        int soRow = tbl_showThongTinDH.getSelectedRow();
        //mã , tên, xuất xứ, thương hiệu, nsx, chất liệu mặt số, đường kính , bề dày mặt số, trạng thái

        int idDH_ = Integer.parseInt(tbl_showThongTinDH.getValueAt(soRow, 0).toString());
        dsDongHo.clear();
        dsDongHo = dongHoService.layThongTinDH();
        for (DongHo x : dsDongHo) {
            if(x.getId()==idDH_){
                txt_maDH.setText(String.valueOf(x.getId()));
                txt_tenDH.setText(String.valueOf(x.getTen()));
                txt_xuatXu.setText(String.valueOf(x.getXuatXu()));
                txt_thuongHieu.setText(String.valueOf(x.getThuongHieu()));
                txt_nsx.setText(String.valueOf(x.getNoiSanXuat()));
                txt_chatLieuMatSo.setText(String.valueOf(x.getChatLieuMatSo()));
                txt_duongKinh.setText(String.valueOf(x.getDuongKinhMatSo()));
                txt_beDay.setText(String.valueOf(x.getBeDayMatSo()));
                int idTTDH = x.getIdTrangThaiDH();
                String trangThai = trangThaiDHService.layTrangThaiBangID(idTTDH);
                cbx_trangThai.setSelectedItem(trangThai);
                txt_tinhNang.setText(x.getTinhNang());
                txt_baoHanh.setText(String.valueOf(x.getThoiGianBH()));
            }
        }

    }

    private void lamMoiForm() {
        txt_maDH.setText("");
        txt_tenDH.setText("");
        txt_xuatXu.setText("");
        txt_thuongHieu.setText("");
        txt_nsx.setText("");
        txt_chatLieuMatSo.setText("");
        txt_duongKinh.setText("");
        txt_beDay.setText("");
        cbx_trangThai.setSelectedIndex(0);
    }

    private void xoaDongHo() {
        int xoaSP = tbl_showThongTinDH.getSelectedRow();
        if (xoaSP < 0 || txt_maDH.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm muốn XÓA trên bảng");
            return;
        }

        int idSP = Integer.parseInt(txt_maDH.getText());
        dongHoService.xoaDongHo(idSP);

    }

    private void suaDongHo() {
        int rowSelected = tbl_showThongTinDH.getSelectedRow();
        if (rowSelected < 0 || txt_maDH.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm muốn SỬA THÔNG TIN trên bảng danh sách sản phẩm");
            return;
        }

        int idDongHo = Integer.parseInt(txt_maDH.getText());
        DongHo dongHo = new DongHo();
        dongHo = this.getTTFormDH();
        dongHoService.suaThongTinDongHo(dongHo);
    }

    private void themMoi() {

        ArrayList<DongHo> arr_dsdh = new ArrayList<>();

        arr_dsdh = dongHoService.layThongTinDH();
        String tenDH = txt_tenDH.getText();
//        if(tenDH.isBlank()){
//            JOptionPane.showMessageDialog(this, "Bạn cần nhập tên sản phẩm để thêm mới đồng hồ");
//            txt_tenDH.requestFocus();
//            return;
//        }
//        
        for (DongHo x : arr_dsdh) {
            if (x.getTen().equalsIgnoreCase(tenDH)) {
                JOptionPane.showMessageDialog(this, "Bạn cần nhập tên đồng hồ khác");
                return;
            }
        }

        DongHo dongHo = new DongHo();
        dongHo = this.getTTFormDH();
        dongHoService.themMoiDongHo(dongHo);

    }

    public DongHo getTTFormDH() {

        Integer idDH = Integer.parseInt(txt_maDH.getText());
        String tenDH = txt_tenDH.getText();
        String xuatXu = txt_xuatXu.getText();
        String thuongHieu = txt_thuongHieu.getText();
        String nsx = txt_nsx.getText();
        String chatLieuMatSo = txt_chatLieuMatSo.getText();
        Double duongKinhMatSo = Double.parseDouble(txt_duongKinh.getText());
        Double beDayMatSo = Double.parseDouble(txt_beDay.getText());
        String tenTrangThai = cbx_trangThai.getSelectedItem().toString();
        int idTrangThai = trangThaiDHService.layIDByTrangThai(tenTrangThai);
        String tinhNang = txt_tinhNang.getText();
        int thoiGianBH = Integer.parseInt(txt_baoHanh.getText());
        DongHo dongHo = new DongHo(idDH, tenDH, thuongHieu, xuatXu, nsx, chatLieuMatSo
                , duongKinhMatSo, beDayMatSo, tinhNang, thoiGianBH, idTrangThai);
        return dongHo;

    }

    private void fillDataToCombobox() {
        ArrayList<TrangThaiDongHo> dsTrangThai = new ArrayList<>();
        dsTrangThai = trangThaiDHService.latTTrangThaiDH();
        cbx_trangThai.removeAllItems();
        cbx_locTrangThai.removeAllItems();
        for(TrangThaiDongHo tt : dsTrangThai){
            cbx_trangThai.addItem(tt.getTenTrangThai());
            cbx_locTrangThai.addItem(tt.getTenTrangThai());
        }
    }


    private void fillTrangThaiLocTheoTrangThaiLenTable() {
        String trangThaiDuocChon = cbx_locTrangThai.getSelectedItem().toString();
        int idTrangThai = trangThaiDHService.layIDByTrangThai(trangThaiDuocChon);
        System.out.println("ID trạng thái: " + idTrangThai);
        
        ArrayList<DongHo> ds_dongHo = new ArrayList<>();
        ds_dongHo.clear();
        ds_dongHo = dongHoService.locBangChonTrangThai(idTrangThai);
        if(ds_dongHo==null){
            System.out.println("Không có sản phẩm có kết quả lọc phù hợp");
            return;
        }
        //tenDongHo, thuongHieu, xuatXu, noiSanXuat, chatLieuMatSo, duongKinhMatSo, beDayMatSo, idTrangThaiDH
        String columns[] = {"Mã đồng hồ", "Tên đồng hồ", "Thương hiệu", "Xuất xứ", "NSX"
                             , "Chất liệu","Tính năng","Thời gian BH", "Trạng thái"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        tableModel.setRowCount(0);
  
        for (DongHo x : ds_dongHo) {
            int idTrangThaiDS = x.getIdTrangThaiDH();
            String trangThai = this.trangThaiDHService.layTrangThaiBangID(idTrangThaiDS);
            Object objects[] = new Object[]{x.getId(), x.getTen(), x.getThuongHieu(), x.getXuatXu()
                                    , x.getNoiSanXuat(), x.getChatLieuMatSo(),
                                    x.getTinhNang(), x.getThoiGianBH(), trangThai};
            tableModel.addRow(objects);
        }
        tbl_showThongTinDH.setModel(tableModel);
    }

    private void fillTrangThaiLocTheoTenLenTable() {
        String inputFindTenDH = txt_locTheoTenDH.getText();
        
        ArrayList<DongHo> ds_dongHo = new ArrayList<>();
        ds_dongHo.clear();
        ds_dongHo = dongHoService.LocBangNhapTenDH_chatLieu_tinhNang(inputFindTenDH);
        if(ds_dongHo==null){
            System.out.println("Không có sản phẩm có kết quả lọc phù hợp");
            return;
        }
        //tenDongHo, thuongHieu, xuatXu, noiSanXuat, chatLieuMatSo, duongKinhMatSo, beDayMatSo, idTrangThaiDH
        String columns[] = {"Mã đồng hồ", "Tên đồng hồ", "Thương hiệu", "Xuất xứ", "NSX"
                             , "Chất liệu","Tính năng","Thời gian BH", "Trạng thái"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        tableModel.setRowCount(0);
  
        for (DongHo x : ds_dongHo) {
            int idTrangThaiDS = x.getIdTrangThaiDH();
            String trangThai = this.trangThaiDHService.layTrangThaiBangID(idTrangThaiDS);
            Object objects[] = new Object[]{x.getId(), x.getTen(), x.getThuongHieu(), x.getXuatXu()
                                    , x.getNoiSanXuat(), x.getChatLieuMatSo(),
                                    x.getTinhNang(), x.getThoiGianBH(), trangThai};
            tableModel.addRow(objects);
        }
        tbl_showThongTinDH.setModel(tableModel);
    }
}
