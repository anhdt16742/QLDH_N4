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
import models.ChiTietDongHo;
import models.model_DT.HoaDon;
import models.model_DT.HoaDonChiTiet;
import repositorys.IRepo_DT.IHoaDonChiTietRepository;
import utilconnext.DBConnection;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietRepository implements IHoaDonChiTietRepository {

    @Override
    public List<HoaDonChiTiet> GetAll() {
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        listHDCT.removeAll(listHDCT);
        try {
            String sql = "SELECT        dbo.HoaDonChiTiet.id_HDCT, dbo.HoaDonChiTiet.id_hoaDon, dbo.HoaDonChiTiet.id_chiTietDH_, dbo.HoaDonChiTiet.Soluong, dbo.HoaDonChiTiet.Dongia, dbo.HoaDonChiTiet.thanh_tien, \n"
                    + "                         dbo.HoaDonChiTiet.Dongiakhigiam\n"
                    + "FROM            dbo.HoaDon INNER JOIN\n"
                    + "                         dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon AND dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon INNER JOIN\n"
                    + "                         dbo.ChiTietDongHo ON dbo.HoaDonChiTiet.id_chiTietDH_ = dbo.ChiTietDongHo.idChiTietDH AND dbo.HoaDonChiTiet.id_chiTietDH_ = dbo.ChiTietDongHo.idChiTietDH";
            Connection conn = DBConnection.openDbConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(2));
                ChiTietDongHo ctdh = new ChiTietDongHo(Integer.valueOf(rs.getString(3)));
                listHDCT.add(new HoaDonChiTiet(rs.getString(1), hd, ctdh, rs.getInt(4), rs.getLong(5), rs.getLong(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    @Override
    public boolean Update(HoaDonChiTiet hdct, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        List<HoaDonChiTiet> listPBH = new ArrayList<>();
        HoaDon pbh1 = new HoaDon();

        listPBH = new HoaDonChiTietRepository().GetByIdHD("2");
        System.out.println(listPBH);

    }

    @Override
    public List<HoaDonChiTiet> GetByIdHD(String id) {
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try {

            String sql = "SELECT [id_HDCT]\n"
                    + "      ,[id_hoaDon]\n"
                    + "      ,[id_chiTietDH_]\n"
                    + "      ,[Soluong]\n"
                    + "      ,[Dongia]\n"
                    + "      ,[thanh_tien]\n"
                    + "      ,[Dongiakhigiam]\n"
                    + "  FROM [dbo].[HoaDonChiTiet] where [id_hoaDon]=?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(2));
                ChiTietDongHo ctdh = new ChiTietDongHo(Integer.valueOf(rs.getString(3)));
                listHDCT.add(new HoaDonChiTiet(rs.getString(1), hd, ctdh, rs.getInt(4), rs.getLong(5), rs.getLong(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

}
