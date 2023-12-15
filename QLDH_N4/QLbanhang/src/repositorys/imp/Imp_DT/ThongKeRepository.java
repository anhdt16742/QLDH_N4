/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp.Imp_DT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.ChiTietDongHo;
import models.model_DT.HoaDon;
import models.model_DT.HoaDonChiTiet;
import models.model_DT.KhachHang;
import models.model_DT.ThongKe;
import static repositorys.imp.Imp_DT.ChiTietDongHoRepository.conn;
import utilconnext.DBConnection;
import viewmodel.ViewModel_DT.SanPhamTronHoaDonModel;

/**
 *
 * @author Admin
 */
public class ThongKeRepository {

    public List<ThongKe> getAll() {
        String query = "SELECT dbo.HoaDon.Id, dbo.KhachHang.TenKhachHang, dbo.HoaDonChiTiet.Soluong, dbo.HoaDonChiTiet.Dongia, dbo.HoaDon.NgayThanhToan, \n"
                + "                  dbo.HoaDonChiTiet.Soluong * dbo.HoaDonChiTiet.Dongia AS 'thanh tien'\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon AND dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.MaKhachHang";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<ThongKe> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                KhachHang kh = new KhachHang(rs.getString(2));
                HoaDon hd = new HoaDon(rs.getString(1), kh);
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(3), rs.getLong(4), rs.getLong(6));
                ThongKe tk = new ThongKe(hd, kh, hdct);
                list.add(tk);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<ThongKe> sortNgayTao() {
        String query = "SELECT  dbo.HoaDon.Id, dbo.KhachHang.TenKhachHang, dbo.HoaDonChiTiet.Soluong, dbo.HoaDonChiTiet.Dongia, dbo.HoaDon.NgayThanhToan, dbo.HoaDonChiTiet.Soluong * dbo.HoaDonChiTiet.Dongia AS 'thanh tien'\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon AND dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.MaKhachHang\n"
                + "ORDER BY dbo.HoaDon.NgayThanhToan DESC";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<ThongKe> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                KhachHang kh = new KhachHang(rs.getString(2));
                HoaDon hd = new HoaDon(rs.getString(1), kh);
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(3), rs.getLong(4), rs.getLong(6));
                ThongKe tk = new ThongKe(hd, kh, hdct);
                list.add(tk);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<ThongKe> searchThoiGian(Date tuNgay, Date denNgay) {
        String querry = "SELECT  dbo.HoaDon.Id, dbo.KhachHang.TenKhachHang, dbo.HoaDonChiTiet.Soluong, dbo.HoaDonChiTiet.Dongia, dbo.HoaDon.NgayThanhToan, dbo.HoaDonChiTiet.Soluong * dbo.HoaDonChiTiet.Dongia AS 'thanh tien'\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon AND dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.MaKhachHang\n"
                + "where dbo.HoaDon.NgayThanhToan between ? and ?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(querry)) {
            List<ThongKe> list = new ArrayList<>();
            ps.setObject(1, tuNgay);
            ps.setObject(2, denNgay);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                KhachHang kh = new KhachHang(rs.getString(2));
                HoaDon hd = new HoaDon(rs.getString(1), kh);
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(3), rs.getLong(4), rs.getLong(6));
                ThongKe tk = new ThongKe(hd, kh, hdct);
                list.add(tk);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SanPhamTronHoaDonModel> getThongTinDongHo() {
        ArrayList<SanPhamTronHoaDonModel> arr_SPTrongHoaDon = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select idChiTietDH, tenDongHo , GioiTinh.ten as gioiTinh, KieuMay.ten as kieuMay, ChatLieuDay.ten as chatLieuDay, \n"
                    + "duongKinhMatSo,giaNhap, giaBan, soLuong, Khuyenmai.HinhthucKM, giaGiam=giaBan-Khuyenmai.Giatrigiam\n"
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
                        rs.getString("chatLieuDay"), rs.getDouble("duongKinhMatSo"),rs.getDouble("giaNhap"),
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
      public ArrayList<SanPhamTronHoaDonModel> getThongTinDongHoSapHet(int soLuong) {
        ArrayList<SanPhamTronHoaDonModel> arr_SPTrongHoaDon = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select idChiTietDH, tenDongHo , GioiTinh.ten as gioiTinh, KieuMay.ten as kieuMay, ChatLieuDay.ten as chatLieuDay, \n"
                    + "duongKinhMatSo,giaNhap, giaBan, soLuong, Khuyenmai.HinhthucKM, giaGiam=giaBan-Khuyenmai.Giatrigiam\n"
                    + "from ChiTietDongHo\n"
                    + "inner join DongHo on ChiTietDongHo.idDongHo = DongHo.idDH\n"
                    + "inner join GioiTinh on ChiTietDongHo.idGioiTinh = GioiTinh.id\n"
                    + "inner join KieuMay on ChiTietDongHo.idKieuMay = KieuMay.id\n"
                    + "inner join ChatLieuDay on ChiTietDongHo.idLoaiDayDeo = ChatLieuDay.id\n"
                    + "inner join Khuyenmai on ChiTietDongHo.idKhuyenMai = Khuyenmai.id where soLuong <= ? order by soLuong DESC";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, soLuong);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SanPhamTronHoaDonModel sp = new SanPhamTronHoaDonModel(rs.getInt("idChiTietDH"), rs.getString("tenDongHo"), rs.getString("gioiTinh"), rs.getString("kieuMay"),
                        rs.getString("chatLieuDay"), rs.getDouble("duongKinhMatSo"),rs.getDouble("giaNhap"),
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
    public static void main(String[] args) {
        List<SanPhamTronHoaDonModel> list = new ArrayList<>();
        list = new ThongKeRepository().getThongTinDongHoSapHet(4);
        for (SanPhamTronHoaDonModel tk : list) {
            System.out.println(tk);
        }
        System.out.println(list);
    }

}
