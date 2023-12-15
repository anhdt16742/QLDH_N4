/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.HoaDon;
import models.LichSuMua;
import repositorys.ILichSuMuaRepository;
import utilconnext.DBConnection;

/**
 *
 * @author Admin
 */
public class LichSuMuaRepository implements ILichSuMuaRepository {

    @Override
    public List<LichSuMua> getAll(String idKH) {
        List<LichSuMua> list = new ArrayList<>();
        list.remove(list);
        try {

            String sql = "SELECT        dbo.KhachHang.MaKhachHang, dbo.KhachHang.TenKhachHang, dbo.KhachHang.SoDienThoai, dbo.HoaDon.Id, dbo.HoaDon.NgayTao, dbo.HoaDon.idTrangThai\n"
                    + "FROM            dbo.KhachHang INNER JOIN\n"
                    + "                         dbo.HoaDon ON dbo.KhachHang.MaKhachHang = dbo.HoaDon.IdKH where MaKhachHang=?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idKH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               HoaDon hd = new HoaDon(rs.getString(4), rs.getString(5),rs.getInt(6));
               list.add(new LichSuMua(rs.getString(1), rs.getString(2), rs.getString(3), hd));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        List<LichSuMua> list = new ArrayList<>();
        list = new LichSuMuaRepository().getAll("1");
        System.out.println(list);
    }

}
