/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.HoaDon;
import models.HoaDonChiTiet;
import models.KhachHang;
import models.ThongKe;
import utilconnext.DBConnection;

/**
 *
 * @author Admin
 */
public class ThongKeRepository {

    public List<ThongKe> getAll() {
        String query = "SELECT dbo.HoaDon.Id, dbo.KhachHang.TenKhachHang, dbo.HoaDonChiTiet.Soluong, dbo.HoaDonChiTiet.Dongia, dbo.HoaDon.NgayTao, \n"
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
        String query = "SELECT  dbo.HoaDon.Id, dbo.KhachHang.TenKhachHang, dbo.HoaDonChiTiet.Soluong, dbo.HoaDonChiTiet.Dongia, dbo.HoaDon.NgayTao, dbo.HoaDonChiTiet.Soluong * dbo.HoaDonChiTiet.Dongia AS 'thanh tien'\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon AND dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.MaKhachHang\n"
                + "ORDER BY dbo.HoaDon.NgayTao DESC";
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
        String querry = "SELECT  dbo.HoaDon.Id, dbo.KhachHang.TenKhachHang, dbo.HoaDonChiTiet.Soluong, dbo.HoaDonChiTiet.Dongia, dbo.HoaDon.NgayTao, dbo.HoaDonChiTiet.Soluong * dbo.HoaDonChiTiet.Dongia AS 'thanh tien'\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon AND dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.MaKhachHang\n"
                + "where dbo.HoaDon.NgayTao between ? and ?";
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

    public static void main(String[] args) {
        List<ThongKe> list = new ArrayList<>();
        list = new ThongKeRepository().getAll();
        for (ThongKe tk : list) {
            System.out.println(tk);
        }
        System.out.println(list);
    }

}
