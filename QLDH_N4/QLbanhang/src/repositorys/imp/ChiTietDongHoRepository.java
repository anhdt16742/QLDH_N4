package repositorys.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.ChiTietDongHo;

import viewmodel.DongHoChiTietViewModel;
import viewmodel.SanPhamTronHoaDonModel;
import repositorys.IMauQuaiDeoRepository;
import repositorys.IChiTietDongHoRepository;
import utilconnext.DBConnection;

public class ChiTietDongHoRepository implements IChiTietDongHoRepository {

    public static Connection conn = null;
    public static DongHoRepository dongHoRepo = new DongHoRepository();

    @Override
    public Boolean create(ChiTietDongHo chiTietDH) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "insert into ChiTietDongHo( idDongHo, idGioiTinh, idKieuMay, idLoaiDayDeo, idMauVo, soLuong, "
                    + "giaNhap, giaBan, idKhuyenMai, idTrangThaiCTDH)\n"
                    + "values(?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, chiTietDH.getIdDH());
            stmt.setInt(2, chiTietDH.getIdGioiTinh());
            stmt.setInt(3, chiTietDH.getIdKieuMay());
            stmt.setInt(4, chiTietDH.getIdLoaiDayDeo());
            stmt.setInt(5, chiTietDH.getIdMauVo());
            stmt.setInt(6, chiTietDH.getSoLuong());
            stmt.setDouble(7, chiTietDH.getGiaNhap());
            stmt.setDouble(8, chiTietDH.getGiaBan());
            stmt.setInt(9, chiTietDH.getIdKhuyenMai());
            stmt.setInt(10, chiTietDH.getIdTrangThaiSP());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error them moi chi tiet dong ho: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(ChiTietDongHo chiTietDH) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update ChiTietDongHo set  idDongHo=?, idGioiTinh=?, idKieuMay=?, idLoaiDayDeo=?,\n"
                    + "idMauVo=?,soLuong=?, giaNhap=?, giaBan=?, idKhuyenMai=?, idTrangThaiCTDH=? \n"
                    + "where idChiTietDH=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, chiTietDH.getIdDH());
            stmt.setInt(2, chiTietDH.getIdGioiTinh());
            stmt.setInt(3, chiTietDH.getIdKieuMay());
            stmt.setInt(4, chiTietDH.getIdLoaiDayDeo());
            stmt.setInt(5, chiTietDH.getIdMauVo());
            stmt.setInt(6, chiTietDH.getSoLuong());
            stmt.setDouble(7, chiTietDH.getGiaNhap());
            stmt.setDouble(8, chiTietDH.getGiaBan());
            stmt.setInt(9, chiTietDH.getIdKhuyenMai());
            stmt.setInt(10, chiTietDH.getIdTrangThaiSP());
            stmt.setInt(11, chiTietDH.getIdChiTietDH());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai sua thông tin của chi tiết đồng hồ: " + ex.getMessage());
        }
        return false;

    }

    @Override
    public boolean delete(int maDongHo) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            //"delete from HoaDonChiTiet where id_chiTietDH_=?\n"
            String sql = "delete from ChiTietDongHo where idChiTietDH=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, maDongHo);
//            stmt.setInt(2, maDongHo);
            stmt.executeUpdate();

            stmt.close();
            conn.close();

            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error delete chi tiet dong ho: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<DongHoChiTietViewModel> filterByTenDongHo(String tenDH) {
        ArrayList<DongHoChiTietViewModel> arr_chiTietDongHo = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select idChiTietDH, tenDongHo, tinhNang, thoiGianBaoHanh, GioiTinh.ten as loaiGioiTinh, KieuMay.ten as loaiKieuMay, ChatLieuDay.ten as loaiChatLieuDay\n"
                    + ", MauDayDeo.ten as loaiMauDay, soLuong, giaBan, Khuyenmai.Ten as chuongTrinhKM, giaGiam = giaBan - Khuyenmai.Giatrigiam , TrangThaiChiTietDongHo.ten as trangThaiDHCT\n"
                    + "from ChiTietDongHo\n"
                    + "join DongHo on ChiTietDongHo.idDongHo = DongHo.idDH\n"
                    + "join GioiTinh on ChiTietDongHo.idGioiTinh = GioiTinh.id\n"
                    + "join KieuMay on ChiTietDongHo.idKieuMay = KieuMay.id\n"
                    + "join ChatLieuDay on ChiTietDongHo.idLoaiDayDeo = ChatLieuDay.id\n"
                    + "join MauDayDeo on ChiTietDongHo.idMauVo = MauDayDeo.id\n"
                    + "join Khuyenmai on ChiTietDongHo.idKhuyenMai = Khuyenmai.id\n"
                    + "join TrangThaiChiTietDongHo on ChiTietDongHo.idTrangThaiCTDH = TrangThaiChiTietDongHo.id"
                    + " where tenDongHo like ?\n"
                    + "order by idChiTietDH DESC";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + tenDH + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DongHoChiTietViewModel dongHo = new DongHoChiTietViewModel(rs.getInt("idChiTietDH"), rs.getString("tenDongHo"), rs.getString("tinhNang"), rs.getInt("thoiGianBaoHanh"),
                        rs.getString("loaiGioiTinh"), rs.getString("loaiKieuMay"), rs.getString("loaiChatLieuDay"),
                        rs.getString("loaiMauDay"), rs.getInt("soLuong"), rs.getDouble("giaBan"),
                         rs.getString("chuongTrinhKM"), rs.getDouble("giaGiam"), rs.getString("trangThaiDHCT"));

                arr_chiTietDongHo.add(dongHo);
            }
            stmt.close();
            conn.close();
            rs.close();

            return arr_chiTietDongHo;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of loc theo ten : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<DongHoChiTietViewModel> filterByMauSac(String mauSac) {
        ArrayList<DongHoChiTietViewModel> arr_chiTietDongHo = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select idChiTietDH, tenDongHo, tinhNang, thoiGianBaoHanh, GioiTinh.ten as loaiGioiTinh, KieuMay.ten as loaiKieuMay, ChatLieuDay.ten as loaiChatLieuDay\n"
                    + ", MauDayDeo.ten as loaiMauDay, soLuong, giaBan, Khuyenmai.Ten as chuongTrinhKM, giaGiam = giaBan - Khuyenmai.Giatrigiam , TrangThaiChiTietDongHo.ten as trangThaiDHCT\n"
                    + "from ChiTietDongHo\n"
                    + "join DongHo on ChiTietDongHo.idDongHo = DongHo.idDH\n"
                    + "join GioiTinh on ChiTietDongHo.idGioiTinh = GioiTinh.id\n"
                    + "join KieuMay on ChiTietDongHo.idKieuMay = KieuMay.id\n"
                    + "join ChatLieuDay on ChiTietDongHo.idLoaiDayDeo = ChatLieuDay.id\n"
                    + "join MauDayDeo on ChiTietDongHo.idMauVo = MauDayDeo.id\n"
                    + "join Khuyenmai on ChiTietDongHo.idKhuyenMai = Khuyenmai.id\n"
                    + "join TrangThaiChiTietDongHo on ChiTietDongHo.idTrangThaiCTDH = TrangThaiChiTietDongHo.id"
                    + " where MauDayDeo.ten like ?\n"
                    + "order by idChiTietDH DESC";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mauSac);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DongHoChiTietViewModel dongHo = new DongHoChiTietViewModel(rs.getInt("idChiTietDH"), rs.getString("tenDongHo"), rs.getString("tinhNang"), rs.getInt("thoiGianBaoHanh"),
                        rs.getString("loaiGioiTinh"), rs.getString("loaiKieuMay"), rs.getString("loaiChatLieuDay"),
                        rs.getString("loaiMauDay"), rs.getInt("soLuong"), rs.getDouble("giaBan"),
                         rs.getString("chuongTrinhKM"), rs.getDouble("giaGiam"), rs.getString("trangThaiDHCT"));

                arr_chiTietDongHo.add(dongHo);
            }
            stmt.close();
            conn.close();
            rs.close();

            return arr_chiTietDongHo;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of Loc mau sac : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<DongHoChiTietViewModel> filterByKhoangGia(String loaiLoc, Double giaLoc) {
        String sql = "";

        if (loaiLoc.trim().equalsIgnoreCase("bang")) {
            sql = "select idChiTietDH, tenDongHo, tinhNang, thoiGianBaoHanh, GioiTinh.ten as loaiGioiTinh, KieuMay.ten as loaiKieuMay, ChatLieuDay.ten as loaiChatLieuDay\n"
                    + ", MauDayDeo.ten as loaiMauDay, soLuong, giaBan, Khuyenmai.Ten as chuongTrinhKM, giaGiam = giaBan - Khuyenmai.Giatrigiam , TrangThaiChiTietDongHo.ten as trangThaiDHCT\n"
                    + "from ChiTietDongHo\n"
                    + "join DongHo on ChiTietDongHo.idDongHo = DongHo.idDH\n"
                    + "join GioiTinh on ChiTietDongHo.idGioiTinh = GioiTinh.id\n"
                    + "join KieuMay on ChiTietDongHo.idKieuMay = KieuMay.id\n"
                    + "join ChatLieuDay on ChiTietDongHo.idLoaiDayDeo = ChatLieuDay.id\n"
                    + "join MauDayDeo on ChiTietDongHo.idMauVo = MauDayDeo.id\n"
                    + "join Khuyenmai on ChiTietDongHo.idKhuyenMai = Khuyenmai.id\n"
                    + "join TrangThaiChiTietDongHo on ChiTietDongHo.idTrangThaiCTDH = TrangThaiChiTietDongHo.id\n"
                    + "where giaBan=? order by idChiTietDH DESC";
        } else if (loaiLoc.trim().equalsIgnoreCase("lonHon")) {
            sql = "select idChiTietDH, tenDongHo, tinhNang, thoiGianBaoHanh, GioiTinh.ten as loaiGioiTinh, KieuMay.ten as loaiKieuMay, ChatLieuDay.ten as loaiChatLieuDay\n"
                    + ", MauDayDeo.ten as loaiMauDay, soLuong, giaBan, Khuyenmai.Ten as chuongTrinhKM, giaGiam = giaBan - Khuyenmai.Giatrigiam , TrangThaiChiTietDongHo.ten as trangThaiDHCT\n"
                    + "from ChiTietDongHo\n"
                    + "join DongHo on ChiTietDongHo.idDongHo = DongHo.idDH\n"
                    + "join GioiTinh on ChiTietDongHo.idGioiTinh = GioiTinh.id\n"
                    + "join KieuMay on ChiTietDongHo.idKieuMay = KieuMay.id\n"
                    + "join ChatLieuDay on ChiTietDongHo.idLoaiDayDeo = ChatLieuDay.id\n"
                    + "join MauDayDeo on ChiTietDongHo.idMauVo = MauDayDeo.id\n"
                    + "join Khuyenmai on ChiTietDongHo.idKhuyenMai = Khuyenmai.id\n"
                    + "join TrangThaiChiTietDongHo on ChiTietDongHo.idTrangThaiCTDH = TrangThaiChiTietDongHo.id\n"
                    + "where giaBan>? order by idChiTietDH DESC";
        } else if (loaiLoc.trim().equalsIgnoreCase("nhoHon")) {
            sql = "select idChiTietDH, tenDongHo, tinhNang, thoiGianBaoHanh, GioiTinh.ten as loaiGioiTinh, KieuMay.ten as loaiKieuMay, ChatLieuDay.ten as loaiChatLieuDay\n"
                    + ", MauDayDeo.ten as loaiMauDay, soLuong, giaBan, Khuyenmai.Ten as chuongTrinhKM, giaGiam = giaBan - Khuyenmai.Giatrigiam , TrangThaiChiTietDongHo.ten as trangThaiDHCT\n"
                    + "from ChiTietDongHo\n"
                    + "join DongHo on ChiTietDongHo.idDongHo = DongHo.idDH\n"
                    + "join GioiTinh on ChiTietDongHo.idGioiTinh = GioiTinh.id\n"
                    + "join KieuMay on ChiTietDongHo.idKieuMay = KieuMay.id\n"
                    + "join ChatLieuDay on ChiTietDongHo.idLoaiDayDeo = ChatLieuDay.id\n"
                    + "join MauDayDeo on ChiTietDongHo.idMauVo = MauDayDeo.id\n"
                    + "join Khuyenmai on ChiTietDongHo.idKhuyenMai = Khuyenmai.id\n"
                    + "join TrangThaiChiTietDongHo on ChiTietDongHo.idTrangThaiCTDH = TrangThaiChiTietDongHo.id\n"
                    + "where giaBan<? order by idChiTietDH DESC";
        } else if (loaiLoc.trim().equalsIgnoreCase("nhoHonBang")) {
            sql = "select idChiTietDH, tenDongHo, tinhNang, thoiGianBaoHanh, GioiTinh.ten as loaiGioiTinh, KieuMay.ten as loaiKieuMay, ChatLieuDay.ten as loaiChatLieuDay\n"
                    + ", MauDayDeo.ten as loaiMauDay, soLuong, giaBan, Khuyenmai.Ten as chuongTrinhKM, giaGiam = giaBan - Khuyenmai.Giatrigiam , TrangThaiChiTietDongHo.ten as trangThaiDHCT\n"
                    + "from ChiTietDongHo\n"
                    + "join DongHo on ChiTietDongHo.idDongHo = DongHo.idDH\n"
                    + "join GioiTinh on ChiTietDongHo.idGioiTinh = GioiTinh.id\n"
                    + "join KieuMay on ChiTietDongHo.idKieuMay = KieuMay.id\n"
                    + "join ChatLieuDay on ChiTietDongHo.idLoaiDayDeo = ChatLieuDay.id\n"
                    + "join MauDayDeo on ChiTietDongHo.idMauVo = MauDayDeo.id\n"
                    + "join Khuyenmai on ChiTietDongHo.idKhuyenMai = Khuyenmai.id\n"
                    + "join TrangThaiChiTietDongHo on ChiTietDongHo.idTrangThaiCTDH = TrangThaiChiTietDongHo.id\n"
                    + "where giaBan<=? order by idChiTietDH DESC";
        } else if (loaiLoc.trim().equalsIgnoreCase("lonHonBang")) {
            sql = "select idChiTietDH, tenDongHo, tinhNang, thoiGianBaoHanh, GioiTinh.ten as loaiGioiTinh, KieuMay.ten as loaiKieuMay, ChatLieuDay.ten as loaiChatLieuDay\n"
                    + ", MauDayDeo.ten as loaiMauDay, soLuong, giaBan, Khuyenmai.Ten as chuongTrinhKM, giaGiam = giaBan - Khuyenmai.Giatrigiam , TrangThaiChiTietDongHo.ten as trangThaiDHCT\n"
                    + "from ChiTietDongHo\n"
                    + "join DongHo on ChiTietDongHo.idDongHo = DongHo.idDH\n"
                    + "join GioiTinh on ChiTietDongHo.idGioiTinh = GioiTinh.id\n"
                    + "join KieuMay on ChiTietDongHo.idKieuMay = KieuMay.id\n"
                    + "join ChatLieuDay on ChiTietDongHo.idLoaiDayDeo = ChatLieuDay.id\n"
                    + "join MauDayDeo on ChiTietDongHo.idMauVo = MauDayDeo.id\n"
                    + "join Khuyenmai on ChiTietDongHo.idKhuyenMai = Khuyenmai.id\n"
                    + "join TrangThaiChiTietDongHo on ChiTietDongHo.idTrangThaiCTDH = TrangThaiChiTietDongHo.id\n"
                    + "where giaBan>=? order by idChiTietDH DESC";
        } else {
            JOptionPane.showMessageDialog(null, "Giá phải lớn hơn 0");
            return null;
        }

        ArrayList<DongHoChiTietViewModel> arr_chiTietDongHo = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, giaLoc);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DongHoChiTietViewModel dongHo = new DongHoChiTietViewModel(rs.getInt("idChiTietDH"), rs.getString("tenDongHo"), rs.getString("tinhNang"), rs.getInt("thoiGianBaoHanh"),
                        rs.getString("loaiGioiTinh"), rs.getString("loaiKieuMay"), rs.getString("loaiChatLieuDay"),
                        rs.getString("loaiMauDay"), rs.getInt("soLuong"), rs.getDouble("giaBan"),
                         rs.getString("chuongTrinhKM"), rs.getDouble("giaGiam"), rs.getString("trangThaiDHCT"));

                arr_chiTietDongHo.add(dongHo);
            }
            stmt.close();
            conn.close();
            rs.close();

            return arr_chiTietDongHo;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of Loc mau sac : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<SanPhamTronHoaDonModel> getThongTinDongHo() {
        ArrayList<SanPhamTronHoaDonModel> arr_SPTrongHoaDon = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select idChiTietDH, tenDongHo , GioiTinh.ten as gioiTinh, KieuMay.ten as kieuMay, ChatLieuDay.ten as chatLieuDay, \n"
                    + "duongKinhMatSo, giaBan, soLuong, Khuyenmai.HinhthucKM, giaGiam=giaBan-Khuyenmai.Giatrigiam\n"
                    + "from ChiTietDongHo\n"
                    + "inner join DongHo on ChiTietDongHo.idDongHo = DongHo.idDH\n"
                    + "inner join GioiTinh on ChiTietDongHo.idGioiTinh = GioiTinh.id\n"
                    + "inner join KieuMay on ChiTietDongHo.idKieuMay = KieuMay.id\n"
                    + "inner join ChatLieuDay on ChiTietDongHo.idLoaiDayDeo = ChatLieuDay.id\n"
                    + "inner join Khuyenmai on ChiTietDongHo.idKhuyenMai = Khuyenmai.id";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                //(Integer idChiTietDH, String tenDongHo, String gioiTinhDH, 
                // String loaiKieuMay, String kieuDayDeo, Double duongKinh, Double giaBan, 
                // Integer soLuong, String hinhThucKhuyenMai, Double giaGiam) {

                SanPhamTronHoaDonModel sp = new SanPhamTronHoaDonModel(rs.getInt("idChiTietDH"), rs.getString("tenDongHo"), rs.getString("gioiTinh"), rs.getString("kieuMay"),
                        rs.getString("chatLieuDay"), rs.getDouble("duongKinhMatSo"),
                        rs.getDouble("giaBan"), rs.getInt("soLuong"), rs.getString("HinhthucKM"), rs.getDouble("giaGiam"));

                arr_SPTrongHoaDon.add(sp);
            }

            stmt.close();
            conn.close();
            rs.close();

            return arr_SPTrongHoaDon;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of Sản phẩm được hiển thị trong hóa đơn : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<DongHoChiTietViewModel> getDataOfChiTietDongHo() {
        ArrayList<DongHoChiTietViewModel> arr_dongHo = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select idChiTietDH, tenDongHo, tinhNang, thoiGianBaoHanh, GioiTinh.ten as loaiGioiTinh, KieuMay.ten as loaiKieuMay, ChatLieuDay.ten as loaiChatLieuDay\n"
                    + ", MauDayDeo.ten as loaiMauDay, soLuong, giaBan, Khuyenmai.Ten as chuongTrinhKM, giaGiam = giaBan - Khuyenmai.Giatrigiam , TrangThaiChiTietDongHo.ten as trangThaiDHCT\n"
                    + "from ChiTietDongHo\n"
                    + "join DongHo on ChiTietDongHo.idDongHo = DongHo.idDH\n"
                    + "join GioiTinh on ChiTietDongHo.idGioiTinh = GioiTinh.id\n"
                    + "join KieuMay on ChiTietDongHo.idKieuMay = KieuMay.id\n"
                    + "join ChatLieuDay on ChiTietDongHo.idLoaiDayDeo = ChatLieuDay.id\n"
                    + "join MauDayDeo on ChiTietDongHo.idMauVo = MauDayDeo.id\n"
                    + "join Khuyenmai on ChiTietDongHo.idKhuyenMai = Khuyenmai.id\n"
                    + "join TrangThaiChiTietDongHo on ChiTietDongHo.idTrangThaiCTDH = TrangThaiChiTietDongHo.id\n"
                    + "order by idChiTietDH DESC";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DongHoChiTietViewModel dongHo = new DongHoChiTietViewModel(rs.getInt("idChiTietDH"), rs.getString("tenDongHo"), rs.getString("tinhNang"), rs.getInt("thoiGianBaoHanh"),
                        rs.getString("loaiGioiTinh"), rs.getString("loaiKieuMay"), rs.getString("loaiChatLieuDay"),
                        rs.getString("loaiMauDay"), rs.getInt("soLuong"), rs.getDouble("giaBan"),
                         rs.getString("chuongTrinhKM"), rs.getDouble("giaGiam"), rs.getString("trangThaiDHCT"));

                arr_dongHo.add(dongHo);
            }
            stmt.close();
            conn.close();
            rs.close();

            return arr_dongHo;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of Chi tiet dong ho : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<ChiTietDongHo> getAll() {
        ArrayList<ChiTietDongHo> arr_dongHo = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select idChiTietDH, idDongHo, idGioiTinh, idKieuMay, idLoaiDayDeo, idMauVo, soLuong, "
                    + "giaNhap, giaBan, idKhuyenMai, idTrangThaiCTDH\n"
                    + "from ChiTietDongHo order by idChiTietDH desc";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                ChiTietDongHo dongHo = new ChiTietDongHo(
                        rs.getInt("idChiTietDH"), rs.getInt("idDongHo"), rs.getInt("idGioiTinh"), rs.getInt("idKieuMay"),
                        rs.getInt("idLoaiDayDeo"), rs.getInt("idMauVo"), rs.getInt("soLuong"), rs.getDouble("giaNhap"),
                        rs.getDouble("giaBan"), rs.getInt("idKhuyenMai"), rs.getInt("idTrangThaiCTDH"));

                arr_dongHo.add(dongHo);
            }

            stmt.close();
            conn.close();
            rs.close();

            return arr_dongHo;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of ALL Chi tiet dong ho : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateSoLuong(int soLuong) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update ChiTietDongHo set soLuong = 2 where idChiTietDH=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, soLuong);
            stmt.executeUpdate();

            stmt.close();
            conn.close();

            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error khi cập nhật số lượng đồng hồ: " + ex.getMessage());
        }
        return false;
    }

}
