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
import models.DongHo;
import models.model_DN.ChiTietDongHo;
import models.HoaDon;
import models.HoaDonChiTiet;
import repositorys.IHoaDonChiTietRepository;
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
            String sql = "SELECT        dbo.HoaDonChiTiet.id_HDCT, dbo.HoaDonChiTiet.id_hoaDon, dbo.HoaDonChiTiet.id_chiTietDH_, dbo.ChiTietDongHo.idDongHo, dbo.DongHo.tenDongHo, dbo.HoaDonChiTiet.Soluong, dbo.HoaDonChiTiet.Dongia, \n"
                    + "                         dbo.HoaDonChiTiet.thanh_tien, dbo.HoaDonChiTiet.Dongiakhigiam\n"
                    + "FROM            dbo.DongHo INNER JOIN\n"
                    + "                         dbo.ChiTietDongHo ON dbo.DongHo.idDH = dbo.ChiTietDongHo.idDongHo INNER JOIN\n"
                    + "                         dbo.HoaDon INNER JOIN\n"
                    + "                         dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon AND dbo.HoaDon.Id = dbo.HoaDonChiTiet.id_hoaDon ON dbo.ChiTietDongHo.idChiTietDH = dbo.HoaDonChiTiet.id_chiTietDH_ AND \n"
                    + "                         dbo.ChiTietDongHo.idChiTietDH = dbo.HoaDonChiTiet.id_chiTietDH_";
            Connection conn = DBConnection.openDbConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(2));
                ChiTietDongHo ctdh = new ChiTietDongHo(rs.getInt(3), new DongHo(rs.getInt(4), rs.getString(5)));
                listHDCT.add(new HoaDonChiTiet(rs.getString(1), hd, ctdh, rs.getInt(6), rs.getLong(7), rs.getLong(8)));
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

        listPBH = new HoaDonChiTietRepository().GetAll();
        for (HoaDonChiTiet hoaDonChiTiet : listPBH) {
            System.out.println(hoaDonChiTiet.getIdCTDH().getIdDH().getTen());
        }

    }

    @Override
    public List<HoaDonChiTiet> GetByIdHD(String id) {
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try {

            String sql = "SELECT        dbo.HoaDonChiTiet.id_HDCT, dbo.HoaDonChiTiet.id_hoaDon, dbo.HoaDonChiTiet.id_chiTietDH_, dbo.DongHo.idDH, dbo.DongHo.tenDongHo, dbo.HoaDonChiTiet.Soluong, dbo.HoaDonChiTiet.Dongia, \n"
                    + "                         dbo.HoaDonChiTiet.thanh_tien, dbo.HoaDonChiTiet.Dongiakhigiam\n"
                    + "FROM            dbo.ChiTietDongHo INNER JOIN\n"
                    + "                         dbo.DongHo ON dbo.ChiTietDongHo.idDongHo = dbo.DongHo.idDH INNER JOIN\n"
                    + "                         dbo.HoaDonChiTiet ON dbo.ChiTietDongHo.idChiTietDH = dbo.HoaDonChiTiet.id_chiTietDH_ AND dbo.ChiTietDongHo.idChiTietDH = dbo.HoaDonChiTiet.id_chiTietDH_ INNER JOIN\n"
                    + "                         dbo.HoaDon ON dbo.HoaDonChiTiet.id_hoaDon = dbo.HoaDon.Id AND dbo.HoaDonChiTiet.id_hoaDon = dbo.HoaDon.Id where dbo.HoaDon.id= ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(2));
                ChiTietDongHo ctdh = new ChiTietDongHo(rs.getInt(3), new DongHo(rs.getInt(4), rs.getString(5)));
                listHDCT.add(new HoaDonChiTiet(rs.getString(1), hd, ctdh, rs.getInt(6), rs.getLong(7), rs.getLong(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

}
