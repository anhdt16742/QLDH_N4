/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp.Imp_DT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.model_DT.HoaDon;
import models.model_DT.KhachHang;
import models.model_DT.NhanVien;
import repositorys.IRepo_DT.IHoaDonRepository;
import utilconnext.DBConnection;

/**
 *
 * @author Admin
 */
public class HoaDonRepository implements IHoaDonRepository {

    @Override
    public List<HoaDon> GetAll() {
        List<HoaDon> listHD = new ArrayList<>();
        listHD.removeAll(listHD);
        try {
            String sql = "SELECT        dbo.HoaDon.Id, dbo.KhachHang.MaKhachHang, dbo.KhachHang.TenKhachHang, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThanhToan, dbo.HoaDon.idTrangThai, dbo.nhanvien.Id AS Expr1, dbo.nhanvien.Ten\n"
                    + "FROM            dbo.HoaDon INNER JOIN\n"
                    + "                         dbo.nhanvien ON dbo.HoaDon.IdNV = dbo.nhanvien.Id INNER JOIN\n"
                    + "                         dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.MaKhachHang";
            Connection conn = DBConnection.openDbConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(7), rs.getString(8));
                KhachHang kh = new KhachHang(rs.getString(2), rs.getString(3));
                listHD.add(new HoaDon(rs.getString(1),kh,rs.getString(4),rs.getString(5),rs.getInt(6),nv));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;

    }

    @Override
    public boolean Update(HoaDon hd, String id) {
        String sql = "UPDATE [dbo].[HoaDon]\n"
                + "   SET \n"
                + "      [NgayThanhToan] = ?\n"
                + "      ,[idTrangThai] = ?\n"
                + " WHERE [dbo].[HoaDon].id=?";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, hd.getNgayThanhToan());
            pstm.setInt(2, hd.getIdTrangThai());
            pstm.setString(3, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        List<HoaDon> listPBH = new ArrayList<>();
        HoaDon pbh1 = new HoaDon();

        listPBH = new HoaDonRepository().GetAll();
        System.out.println(listPBH);

    }

}
