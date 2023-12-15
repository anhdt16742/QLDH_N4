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
import java.util.List;
import models.model_DT.KhachHang;
import utilconnext.DBConnection;

/**
 *
 * @author Admin
 */
public class KhachHangRepository {

    public List<KhachHang> getall() {
        String query = "SELECT [MaKhachHang]\n"
                + "      ,[TenKhachHang]\n"
                + "      ,[SinhNhat]\n"
                + "      ,[DiaChi]\n"
                + "      ,[SoDienThoai]\n"
                + "      ,[Email]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[SoCanCuoc]\n"
                + "      ,[AnhDaiDien]\n"
                + "      ,[DiemTichLuy]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[KhachHang] where [dbo].[KhachHang].Trangthai = 1";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang> listSP = new ArrayList<>();
            while (rs.next()) {
                KhachHang khachhang = new KhachHang();
                khachhang.setIdKH(rs.getString(1));
                khachhang.setTenKhachHang(rs.getString(2));
                khachhang.setSinhNhat(rs.getDate(3));
                khachhang.setDiaChi(rs.getString(4));
                khachhang.setSoDienThoai(rs.getString(5));
                khachhang.setEmail(rs.getString(6));
                khachhang.setGioiTinh(rs.getBoolean(7));
                khachhang.setSoCanCuoc(rs.getString(8));
                khachhang.setAnhDaiDien(rs.getString(9));
                khachhang.setDiemTichLuy(rs.getInt(10));
                khachhang.setTrangThai(rs.getInt(11));

                listSP.add(khachhang);
            }
            return listSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(KhachHang khachhang) {
        int check = 0;
        String sql = "INSERT INTO [dbo].[KhachHang]\n"
                + "           ([TenKhachHang]\n"
                + "           ,[SinhNhat]\n"
                + "           ,[DiaChi]\n"
                + "           ,[SoDienThoai]\n"
                + "           ,[Email]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[SoCanCuoc]\n"
                + "           ,[AnhDaiDien]\n"
                + "           ,[DiemTichLuy]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,? ,?,?,?,?)";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, khachhang.getTenKhachHang());
            ps.setObject(2, khachhang.getSinhNhat());
            ps.setObject(3, khachhang.getDiaChi());
            ps.setObject(4, khachhang.getSoDienThoai());
            ps.setObject(5, khachhang.getEmail());
            ps.setObject(6, khachhang.isGioiTinh());
            ps.setObject(7, khachhang.getSoCanCuoc());
            ps.setObject(8, khachhang.getAnhDaiDien());
            ps.setObject(9, khachhang.getDiemTichLuy());
            ps.setObject(10, khachhang.getTrangThai());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(int id, KhachHang khachhang) {
        int check = 0;
        String sql = "UPDATE [dbo].[KhachHang]\n"
                + "   SET [TenKhachHang] = ?\n"
                + "      ,[SinhNhat] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[SoDienThoai] =?\n"
                + "      ,[Email] = ?\n"
                + "      ,[GioiTinh] =?\n"
                + "      ,[SoCanCuoc] = ?\n"
                + "      ,[AnhDaiDien] = ?\n"
                + "      ,[DiemTichLuy] = ?\n"
                + "      ,[TrangThai] =?\n"
                + " WHERE MaKhachHang=?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, khachhang.getTenKhachHang());
            ps.setObject(2, khachhang.getSinhNhat());
            ps.setObject(3, khachhang.getDiaChi());
            ps.setObject(4, khachhang.getSoDienThoai());
            ps.setObject(5, khachhang.getEmail());
            ps.setObject(6, khachhang.isGioiTinh());
            ps.setObject(7, khachhang.getSoCanCuoc());
            ps.setObject(8, khachhang.getAnhDaiDien());
            ps.setObject(9, khachhang.getDiemTichLuy());
            ps.setObject(10, khachhang.getTrangThai());
            ps.setObject(11, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(int id) {
        int check = 0;
        String sql = "DELETE FROM [dbo].[KhachHang]\n"
                + "      WHERE MaKhachHang=?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<KhachHang> list = new ArrayList<>();
        list = new KhachHangRepository().getall();
        for (KhachHang khachHang : list) {
            System.out.println(khachHang);
        }
       
    }

}
