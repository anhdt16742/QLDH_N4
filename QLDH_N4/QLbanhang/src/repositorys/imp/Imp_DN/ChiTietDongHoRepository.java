/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp.Imp_DN;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.DongHo;
import models.model_DN.ChiTietDongHo;
import repositorys.IRepo_DN.IChiTietDongHoRepository;
import utilconnext.DBConnection;

/**
 *
 * @author Admin
 */
public class ChiTietDongHoRepository implements IChiTietDongHoRepository {

    @Override
    public List<ChiTietDongHo> getAll() {
        List<ChiTietDongHo> listHDCT = new ArrayList<>();
        listHDCT.removeAll(listHDCT);
        try {
            String sql = "SELECT        dbo.ChiTietDongHo.*, dbo.DongHo.tenDongHo\n"
                    + "FROM            dbo.ChiTietDongHo INNER JOIN\n"
                    + "                         dbo.DongHo ON dbo.ChiTietDongHo.idDongHo = dbo.DongHo.idDH";
            Connection conn = DBConnection.openDbConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DongHo dh = new DongHo(rs.getInt(2), rs.getString(12));
                listHDCT.add(new ChiTietDongHo(rs.getInt(1), dh, rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getDouble(8), rs.getDouble(9), rs.getInt(10), rs.getInt(11)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    public static void main(String[] args) {
        List<ChiTietDongHo> list = new ArrayList<>();
        list = new ChiTietDongHoRepository().getAll();
        for (ChiTietDongHo chiTietDongHo : list) {
            System.out.println(chiTietDongHo.getIdDH().getTen());
        }
    }

}
