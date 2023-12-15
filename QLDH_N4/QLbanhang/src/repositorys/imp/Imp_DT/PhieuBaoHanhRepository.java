/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp.Imp_DT;

import java.util.List;
import models.model_DT.PhieuBaoHanh;
import repositorys.IRepo_DT.IPhieuBaoHanhRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ChiTietDongHo;
import models.model_DT.HoaDon;
import models.model_DT.HoaDonChiTiet;
import models.model_DT.KhachHang;
import utilconnext.DBConnection;

/**
 *
 * @author Admin
 */
public class PhieuBaoHanhRepository implements IPhieuBaoHanhRepository {

    @Override
    public List<PhieuBaoHanh> GetAll() {
        List<PhieuBaoHanh> listPBH = new ArrayList<>();
        listPBH.removeAll(listPBH);
        try {
            String sql = "SELECT        dbo.PhieuBaoHanh.id_phieu_bao_hanh, dbo.PhieuBaoHanh.ngay_mua, dbo.PhieuBaoHanh.thoi_han_bao_hanh, dbo.PhieuBaoHanh.id_trang_thai_bao_hanh, dbo.HoaDonChiTiet.id_HDCT, dbo.HoaDonChiTiet.id_hoaDon, \n"
                    + "                         dbo.HoaDonChiTiet.id_chiTietDH_, dbo.HoaDon.IdKH\n"
                    + "FROM            dbo.PhieuBaoHanh INNER JOIN\n"
                    + "                         dbo.HoaDonChiTiet ON dbo.PhieuBaoHanh.id_hoa_don = dbo.HoaDonChiTiet.id_HDCT INNER JOIN\n"
                    + "                         dbo.HoaDon ON dbo.HoaDonChiTiet.id_hoaDon = dbo.HoaDon.Id AND dbo.HoaDonChiTiet.id_hoaDon = dbo.HoaDon.Id";
            Connection conn = DBConnection.openDbConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ChiTietDongHo ctdh = new ChiTietDongHo(rs.getInt(7));
                KhachHang kh = new KhachHang(rs.getString(8));
                HoaDon hd = new HoaDon(rs.getString(6), kh);
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getString(5), hd, ctdh);
                listPBH.add(new PhieuBaoHanh(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), hdct));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPBH;
    }

    @Override
    public boolean Update(PhieuBaoHanh pbh, String id) {
        String sql = "UPDATE [dbo].[PhieuBaoHanh]\n"
                + "   SET \n"
                + "      [thoi_han_bao_hanh] = ?\n"
                + "    \n"
                + " WHERE id_phieu_bao_hanh=?";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pbh.getThoiHan());
            pstm.setString(2, id);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean Delete(String id) {
        String sql = "DELETE FROM [dbo].[PhieuBaoHanh]\n"
                + "      WHERE id_phieu_bao_hanh=?";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<PhieuBaoHanh> getbyid(int id) {
        List<PhieuBaoHanh> pbh = new ArrayList<>();
        try {

            String sql = "SELECT        dbo.PhieuBaoHanh.id_phieu_bao_hanh, dbo.PhieuBaoHanh.ngay_mua, dbo.PhieuBaoHanh.thoi_han_bao_hanh, dbo.PhieuBaoHanh.id_hoa_don, dbo.PhieuBaoHanh.id_trang_thai_bao_hanh, dbo.HoaDonChiTiet.id_hoaDon, \n"
                    + "                         dbo.HoaDonChiTiet.id_chiTietDH_, dbo.HoaDon.IdKH\n"
                    + "FROM            dbo.PhieuBaoHanh INNER JOIN\n"
                    + "                         dbo.HoaDonChiTiet ON dbo.PhieuBaoHanh.id_hoa_don = dbo.HoaDonChiTiet.id_HDCT INNER JOIN\n"
                    + "                         dbo.HoaDon ON dbo.HoaDonChiTiet.id_hoaDon = dbo.HoaDon.Id AND dbo.HoaDonChiTiet.id_hoaDon = dbo.HoaDon.Id where dbo.PhieuBaoHanh.id_phieu_bao_hanh=?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietDongHo ctdh = new ChiTietDongHo(rs.getInt(7));
                KhachHang kh = new KhachHang(rs.getString(8));
                HoaDon hd = new HoaDon(rs.getString("[dbo].[HoaDon].[Id]"), kh);
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getString(5), hd, ctdh);
                pbh.add(new PhieuBaoHanh(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), hdct));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pbh;
    }

    public static void main(String[] args) {
        List<PhieuBaoHanh> listPBH = new ArrayList<>();
        PhieuBaoHanh pbh1 = new PhieuBaoHanh();

        listPBH = new PhieuBaoHanhRepository().getbyid(6);
        System.out.println(listPBH);

    }

}
