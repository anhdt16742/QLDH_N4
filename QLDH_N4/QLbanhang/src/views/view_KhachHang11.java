/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.awt.Image;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.model_DT.KhachHang;
import models.model_DT.LichSuMua;
import services.ISV_DT.KhachHangService;
import services.imp.ImpSV_DT.KhachHangServiceImpl;
import services.imp.ImpSV_DT.LichSuMuaSV;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Admin
 */
public class view_KhachHang11 extends javax.swing.JPanel {

    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm2 = new DefaultTableModel();
    List<KhachHang> list = new ArrayList<>();
    List<LichSuMua> listLS = new ArrayList<>();
    private KhachHangService khSer = new KhachHangServiceImpl();
    int idClick;
    String duongdananh = "";

    /**
     * Creates new form view_KhachHang
     */
    public view_KhachHang11() {
        initComponents();
        
        TB_bang1.setModel(dtm);
        TB_bang02.setModel(dtm2);
        String[] header = {"ID Khách Hàng", "Tên Khách Hàng", "Ngày Sinh", "Địa Chỉ", "Số Điện Thoại", "Email", "Giới Tính", "Số Căn Cước", "Ảnh Đại Diện", "Điểm Tích Lũy ", "Trạng Thái"};
        String[] header1 = {"ID Khách Hàng", "Tên Khách Hàng","Số Điện Thoại", "ID Hoá Đơn", "Ngày Tạo", "Tổng Tiền", "Trạng Thái"};
        dtm2.setColumnIdentifiers(header1);
        dtm.setColumnIdentifiers(header);
        list = khSer.getAll();
        showData(list);
        int index1 = TB_bang1.getSelectedRow();
        if(index1<0){
            TB_bang02.setEnabled(false);
        }
//        LocalDate today = LocalDate.now();
//         Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());

//        for(KhachHang kh :list){
//            if(kh.getSinhNhat().equals(date)){
//                 String username = "duythph25904@fpt.edu.vn";
//        String password = "wahqtlysxzpaqgxj";
//        String email=txt_email.getText();
//       Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//          Session session = Session.getInstance(props, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//        try {
//
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("duythph25904@fpt.edu.vn"));
//            message.setRecipients( Message.RecipientType.TO,InternetAddress.parse(email)
//            );
//
//            message.setSubject("chúc mừng sinh nhật quý khách  "+txt_Ten.getText());
//            String baocao = "Chúc quý khách một tuổi mới dối dào sức khỏe vạn sự như ý luôn luôn hạnh phúc";
//
//            message.setText(baocao);
////            MimeBodyPart contentPart = new MimeBodyPart();
////            contentPart.setContent(baocao,"text/html;charset=utf-8");
//
////             
////             
////            MimeBodyPart attachmentPart = new MimeBodyPart();
////            File file = new File(duongDan);
////            
////            FileDataSource source = new FileDataSource(file);
////            attachmentPart.setDataHandler(new DataHandler(source));
////            attachmentPart.setFileName(file.getName());
////
////            // Tạo đối tượng Multipart để kết hợp nội dung email và tệp đính kèm
////            Multipart multipart = new MimeMultipart();
////            multipart.addBodyPart(contentPart);
////            multipart.addBodyPart(attachmentPart);
////            
////
////            // Gán nội dung email và tệp đính kèm vào thông điệp
////            message.setContent(multipart);
//            Transport.send(message);
//            JOptionPane.showMessageDialog(this, "Gửi Báo Cáo Thành Công");
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//            }
//        }
        
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lbImg.getWidth(), lbImg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void showData(List<KhachHang> list) {
        dtm.setRowCount(0);
        for (KhachHang kh : list) {
            dtm.addRow(kh.toDataRow());
        }
    }
    
    private void showData2(List<LichSuMua> list, String idKH){
        list = new LichSuMuaSV().getAll(idKH);
        dtm2.setRowCount(0);
        for (LichSuMua lichSuMua : list) {
            dtm2.addRow(lichSuMua.toDataRow());
        }
    }

    private void fillData(int i) throws ParseException {
        KhachHang kh = list.get(i);
        idClick = Integer.valueOf(kh.getIdKH());
        txt_Ten.setText(list.get(i).getTenKhachHang());
        txt_Date.setDate(kh.getSinhNhat());
        txt_diaChi.setText(list.get(i).getDiaChi());
        txt_email.setText(list.get(i).getEmail());
        txt_sdt.setText(list.get(i).getSoDienThoai());
        txt_soCanCuoc.setText(list.get(i).getSoCanCuoc());
        if (kh.isGioiTinh()) {
            rd_Nam1.setSelected(true);
        } else {
            rd_nu1.setSelected(true);
        }
        if (kh.getTrangThai() == 0) {
            rd_HoatDong.setSelected(true);
        } else {
            rd_KoHoatDong.setSelected(true);
        }
        lbImg.setIcon(ResizeImage(kh.getAnhDaiDien()));

    }

    public void sinhNhat(){
          String ten = txt_Ten.getText();
          String email = txt_email.getText();
         String username = "duydb23@gmail.com";
        String password = "kkk123kkk";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("duydb23@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(email)
            );

            message.setSubject("CHÚC MỪNG SINH NHẬT:   [ "+ten+" ]");
            String baocao = "chúc mừng sinh nhật quý khách mong quý khách có một tuổi mới tràn ngập hạnh phúc thành công và thuận lợi";
            message.setText(baocao);

            Transport.send(message);
            JOptionPane.showMessageDialog(this, "Gửi  chúc mừng Thành Công");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    private KhachHang kh() {
        
        
        int i = TB_bang1.getSelectedRow();
        String id = list.get(i).getIdKH();
        String ten = txt_Ten.getText();
        Date sinhNhat = txt_Date.getDate();
        String diaChi = txt_diaChi.getText();
        String soDienThoai = txt_sdt.getText();
        String email = txt_email.getText();
        boolean gioiTinh = true;
        if (rd_Nam1.isSelected()) {
            gioiTinh = true;
        } else {
            gioiTinh = false;
        }
        String soCanCuoc = txt_soCanCuoc.getText();
        // ảnh
        int trangThai;
        if (rd_HoatDong.isSelected()) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }
        KhachHang kh = new KhachHang(null, ten, sinhNhat, diaChi, soDienThoai, email, gioiTinh, soCanCuoc, duongdananh, WIDTH, trangThai);
        return kh;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        txt_Ten = new swing.MyTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_diaChi = new swing.MyTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_email = new swing.MyTextField();
        jLabel8 = new javax.swing.JLabel();
        rd_KoHoatDong = new javax.swing.JRadioButton();
        rd_HoatDong = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_sdt = new swing.MyTextField();
        btn_chonanh = new swing.MyButton();
        Btn_capNhat = new swing.MyButton();
        btn_LamMoi = new swing.MyButton();
        txt_tenDem1 = new swing.MyTextField();
        txt_soCanCuoc = new swing.MyTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rd_Nam1 = new javax.swing.JRadioButton();
        rd_nu1 = new javax.swing.JRadioButton();
        btn_them2 = new swing.MyButton();
        btn_xoa1 = new swing.MyButton();
        lbImg = new javax.swing.JLabel();
        txt_Date = new com.toedter.calendar.JDateChooser();
        btn_them3 = new swing.MyButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        tb_ThongTinKH = new javax.swing.JScrollPane();
        TB_bang1 = new javax.swing.JTable();
        panelBorder3 = new swing.PanelBorder();
        Btn_timKiem1 = new javax.swing.JLabel();
        txt_timKiem01 = new swing.SearchText();
        TXT_01 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tb_LichSuMua = new javax.swing.JScrollPane();
        TB_bang02 = new javax.swing.JTable();
        btn_LamMoi1 = new swing.MyButton();
        LBL_SOLUONG = new javax.swing.JLabel();

        panelBorder1.setBackground(new java.awt.Color(51, 204, 255));
        panelBorder1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tên");
        panelBorder1.add(jLabel1);
        jLabel1.setBounds(90, 10, 210, 20);
        panelBorder1.add(txt_Ten);
        txt_Ten.setBounds(90, 30, 210, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Địa chỉ");
        panelBorder1.add(jLabel5);
        jLabel5.setBounds(90, 70, 210, 20);
        panelBorder1.add(txt_diaChi);
        txt_diaChi.setBounds(90, 90, 210, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("E-mail");
        panelBorder1.add(jLabel6);
        jLabel6.setBounds(90, 130, 210, 20);
        panelBorder1.add(txt_email);
        txt_email.setBounds(90, 150, 210, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Trạng thái");
        panelBorder1.add(jLabel8);
        jLabel8.setBounds(380, 250, 60, 30);

        rd_KoHoatDong.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup2.add(rd_KoHoatDong);
        rd_KoHoatDong.setText("Ko Hoạt Động");
        panelBorder1.add(rd_KoHoatDong);
        rd_KoHoatDong.setBounds(580, 250, 110, 30);

        rd_HoatDong.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup2.add(rd_HoatDong);
        rd_HoatDong.setText("Còn Hoạt Động");
        rd_HoatDong.setToolTipText("");
        rd_HoatDong.setDoubleBuffered(true);
        panelBorder1.add(rd_HoatDong);
        rd_HoatDong.setBounds(450, 250, 110, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Số căn cước");
        panelBorder1.add(jLabel2);
        jLabel2.setBounds(390, 130, 210, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Số điện thoại");
        panelBorder1.add(jLabel7);
        jLabel7.setBounds(390, 70, 210, 20);
        panelBorder1.add(txt_sdt);
        txt_sdt.setBounds(390, 90, 210, 30);

        btn_chonanh.setBackground(new java.awt.Color(125, 224, 237));
        btn_chonanh.setText("chọn ảnh");
        btn_chonanh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_chonanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chonanhActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_chonanh);
        btn_chonanh.setBounds(660, 210, 90, 30);

        Btn_capNhat.setBackground(new java.awt.Color(125, 224, 237));
        Btn_capNhat.setText("Cập nhật");
        Btn_capNhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_capNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_capNhatActionPerformed(evt);
            }
        });
        panelBorder1.add(Btn_capNhat);
        Btn_capNhat.setBounds(850, 90, 120, 40);

        btn_LamMoi.setBackground(new java.awt.Color(125, 224, 237));
        btn_LamMoi.setText("Làm Mới");
        btn_LamMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_LamMoi);
        btn_LamMoi.setBounds(850, 160, 120, 40);
        panelBorder1.add(txt_tenDem1);
        txt_tenDem1.setBounds(90, 90, 210, 30);

        txt_soCanCuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soCanCuocActionPerformed(evt);
            }
        });
        panelBorder1.add(txt_soCanCuoc);
        txt_soCanCuoc.setBounds(390, 150, 210, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Ngày sinh");
        panelBorder1.add(jLabel3);
        jLabel3.setBounds(390, 10, 210, 20);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Giới tính");
        panelBorder1.add(jLabel11);
        jLabel11.setBounds(90, 200, 48, 30);

        rd_Nam1.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rd_Nam1);
        rd_Nam1.setSelected(true);
        rd_Nam1.setText("Nam");
        rd_Nam1.setToolTipText("");
        rd_Nam1.setDoubleBuffered(true);
        rd_Nam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_Nam1ActionPerformed(evt);
            }
        });
        panelBorder1.add(rd_Nam1);
        rd_Nam1.setBounds(157, 200, 60, 30);

        rd_nu1.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rd_nu1);
        rd_nu1.setText("Nữ");
        rd_nu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_nu1ActionPerformed(evt);
            }
        });
        panelBorder1.add(rd_nu1);
        rd_nu1.setBounds(230, 200, 60, 30);

        btn_them2.setBackground(new java.awt.Color(125, 224, 237));
        btn_them2.setText("Thêm");
        btn_them2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_them2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them2ActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_them2);
        btn_them2.setBounds(850, 300, 120, 40);

        btn_xoa1.setBackground(new java.awt.Color(125, 224, 237));
        btn_xoa1.setText("Xóa");
        btn_xoa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_xoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa1ActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_xoa1);
        btn_xoa1.setBounds(850, 230, 120, 40);

        lbImg.setText("image");
        panelBorder1.add(lbImg);
        lbImg.setBounds(643, 20, 140, 160);
        panelBorder1.add(txt_Date);
        txt_Date.setBounds(390, 32, 210, 30);

        btn_them3.setBackground(new java.awt.Color(125, 224, 237));
        btn_them3.setText("Sinh Nhật");
        btn_them3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_them3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them3ActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_them3);
        btn_them3.setBounds(850, 30, 120, 40);

        jTabbedPane3.setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        TB_bang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ Và Tên", "Giới Tính", "Ngày Sinh", "SĐT", "Email", "Điểm Thưởng"
            }
        ));
        TB_bang1.setGridColor(new java.awt.Color(255, 255, 255));
        TB_bang1.setRowHeight(25);
        TB_bang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_bang1MouseClicked(evt);
            }
        });
        tb_ThongTinKH.setViewportView(TB_bang1);

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        Btn_timKiem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_24px.png"))); // NOI18N
        Btn_timKiem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_timKiem1MouseClicked(evt);
            }
        });
        panelBorder3.add(Btn_timKiem1);
        Btn_timKiem1.setBounds(480, 0, 40, 40);

        txt_timKiem01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiem01ActionPerformed(evt);
            }
        });
        txt_timKiem01.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiem01KeyReleased(evt);
            }
        });
        panelBorder3.add(txt_timKiem01);
        txt_timKiem01.setBounds(20, 0, 450, 40);

        TXT_01.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TXT_01.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tb_ThongTinKH)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TXT_01, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_01, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tb_ThongTinKH, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Thông Tin Khách Hàng", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));

        TB_bang02.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ Và Tên", "SĐT", "Mã Hoá Đơn", "Ngày Tạo Hoá Đơn", "Tổng Tiền", "Trạng Thái"
            }
        ));
        TB_bang02.setRowHeight(25);
        tb_LichSuMua.setViewportView(TB_bang02);

        btn_LamMoi1.setBackground(new java.awt.Color(125, 224, 237));
        btn_LamMoi1.setText("HIển THị");
        btn_LamMoi1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_LamMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoi1ActionPerformed(evt);
            }
        });

        LBL_SOLUONG.setBackground(new java.awt.Color(51, 204, 255));
        LBL_SOLUONG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LBL_SOLUONG.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tb_LichSuMua)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LBL_SOLUONG, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_LamMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_LamMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBL_SOLUONG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tb_LichSuMua, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Lịch Sử Mua Hàng", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1179, Short.MAX_VALUE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_chonanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chonanhActionPerformed
        try {
            JFileChooser f = new JFileChooser("E:\\anh");
            //            JFileChooser f = new JFileChooser(ddanAnh);
            f.setDialogTitle("open file");
            f.showOpenDialog(null);
            File ftenanh = f.getSelectedFile();
            duongdananh = ftenanh.getAbsolutePath();
            if (duongdananh != null) {

                lbImg.setIcon(ResizeImage(String.valueOf(duongdananh)));
                System.out.println(duongdananh);
            } else {
                JOptionPane.showMessageDialog(this, "Ban chua chon anh");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ban chua chon anh");
        }
    }//GEN-LAST:event_btn_chonanhActionPerformed

    private void Btn_capNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_capNhatActionPerformed
        System.out.println(idClick);
        KhachHang kh = kh();
        try {
            khSer.update(idClick, kh);
            list = khSer.getAll();
            showData(list);
            JOptionPane.showMessageDialog(this, "cập nhật thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "lỗi ko cập nhật được");
        }
        System.out.println(idClick);
    }//GEN-LAST:event_Btn_capNhatActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        txt_Ten.setText("");
        txt_diaChi.setText("");
        txt_email.setText("");
        txt_Date.setCalendar(null);
        txt_sdt.setText("");
        txt_email.setText("");
        txt_soCanCuoc.setText("");
        lbImg.setIcon(null);

    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void txt_soCanCuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soCanCuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soCanCuocActionPerformed

    private void rd_Nam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_Nam1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_Nam1ActionPerformed

    private void rd_nu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_nu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_nu1ActionPerformed

    private void btn_them2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them2ActionPerformed
        KhachHang kh = kh();
        System.out.println(idClick);
        try {
            khSer.add(kh);
            list = khSer.getAll();
            showData(list);
            JOptionPane.showMessageDialog(this, "thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "lỗi ko thêm  được");
        }
    }//GEN-LAST:event_btn_them2ActionPerformed

    private void btn_xoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa1ActionPerformed
        KhachHang kh = kh();
        System.out.println(idClick);
        try {
            khSer.delete(idClick);
            list = khSer.getAll();
            showData(list);
            JOptionPane.showMessageDialog(this, "xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "lỗi ko xóa được");
        }
    }//GEN-LAST:event_btn_xoa1ActionPerformed

    private void TB_bang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_bang1MouseClicked
        int i = TB_bang1.getSelectedRow();
        try {
            fillData(i);
        } catch (ParseException ex) {
            Logger.getLogger(view_KhachHang11.class.getName()).log(Level.SEVERE, null, ex);
        }
        showData2(listLS, list.get(i).getIdKH());
    }//GEN-LAST:event_TB_bang1MouseClicked

    private void Btn_timKiem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_timKiem1MouseClicked

    }//GEN-LAST:event_Btn_timKiem1MouseClicked

    private void txt_timKiem01KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiem01KeyReleased
        //        defaultTableModel = (DefaultTableModel) TB_bang1.getModel();
        //        defaultTableModel.setRowCount(0);
        //        for (KhachHangViewMD khachHang01 : KH.GetTK(txt_timKiem01.getText())) {
        //            defaultTableModel.addRow(khachHang01.toDataRow());
        //        }
    }//GEN-LAST:event_txt_timKiem01KeyReleased

    private void btn_LamMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoi1ActionPerformed
        //        listKhachHang01 = KH.getall01();
        //        showTable2(listKhachHang01);
        //        LBL_SOLUONG.setText("Tổng số hoá đơn là : " + listKhachHang01.size());
    }//GEN-LAST:event_btn_LamMoi1ActionPerformed

    private void btn_them3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them3ActionPerformed
        String username = "duythph25904@fpt.edu.vn";
        String password = "wahqtlysxzpaqgxj";
        String email=txt_email.getText();
       Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

          Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("duythph25904@fpt.edu.vn"));
            message.setRecipients( Message.RecipientType.TO,InternetAddress.parse(email)
            );

            message.setSubject("chúc mừng sinh nhật quý khách  "+txt_Ten.getText());
            String baocao = "Chúc quý khách một tuổi mới dối dào sức khỏe vạn sự như ý luôn luôn hạnh phúc";

            message.setText(baocao);
//            MimeBodyPart contentPart = new MimeBodyPart();
//            contentPart.setContent(baocao,"text/html;charset=utf-8");

//             
//             
//            MimeBodyPart attachmentPart = new MimeBodyPart();
//            File file = new File(duongDan);
//            
//            FileDataSource source = new FileDataSource(file);
//            attachmentPart.setDataHandler(new DataHandler(source));
//            attachmentPart.setFileName(file.getName());
//
//            // Tạo đối tượng Multipart để kết hợp nội dung email và tệp đính kèm
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(contentPart);
//            multipart.addBodyPart(attachmentPart);
//            
//
//            // Gán nội dung email và tệp đính kèm vào thông điệp
//            message.setContent(multipart);
            Transport.send(message);
            JOptionPane.showMessageDialog(this, "Gửi Báo Cáo Thành Công");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_them3ActionPerformed

    private void txt_timKiem01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiem01ActionPerformed
       List<KhachHang> listSearch = new ArrayList<>();
        for(KhachHang kh :list){
            if(kh.getSoDienThoai().equals(txt_timKiem01.getText())||kh.getSoCanCuoc().equals(txt_timKiem01.getText())){
                listSearch.add(kh);
            }
        }
        showData(listSearch);
    }//GEN-LAST:event_txt_timKiem01ActionPerformed

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
            java.util.logging.Logger.getLogger(view_KhachHang11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_KhachHang11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_KhachHang11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_KhachHang11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new view_KhachHang11().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.MyButton Btn_capNhat;
    private javax.swing.JLabel Btn_timKiem1;
    private javax.swing.JLabel LBL_SOLUONG;
    private javax.swing.JTable TB_bang02;
    private javax.swing.JTable TB_bang1;
    private javax.swing.JLabel TXT_01;
    private swing.MyButton btn_LamMoi;
    private swing.MyButton btn_LamMoi1;
    private swing.MyButton btn_chonanh;
    private swing.MyButton btn_them2;
    private swing.MyButton btn_them3;
    private swing.MyButton btn_xoa1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lbImg;
    private swing.PanelBorder panelBorder1;
    private swing.PanelBorder panelBorder3;
    private javax.swing.JRadioButton rd_HoatDong;
    private javax.swing.JRadioButton rd_KoHoatDong;
    private javax.swing.JRadioButton rd_Nam1;
    private javax.swing.JRadioButton rd_nu1;
    private javax.swing.JScrollPane tb_LichSuMua;
    private javax.swing.JScrollPane tb_ThongTinKH;
    private com.toedter.calendar.JDateChooser txt_Date;
    private swing.MyTextField txt_Ten;
    private swing.MyTextField txt_diaChi;
    private swing.MyTextField txt_email;
    private swing.MyTextField txt_sdt;
    private swing.MyTextField txt_soCanCuoc;
    private swing.MyTextField txt_tenDem1;
    private swing.SearchText txt_timKiem01;
    // End of variables declaration//GEN-END:variables
}
