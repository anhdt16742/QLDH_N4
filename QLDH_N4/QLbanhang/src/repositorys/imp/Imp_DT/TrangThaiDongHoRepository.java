package repositorys.imp.Imp_DT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.model_DT.ChiTietDongHo;
import models.model_DT.TrangThaiChiTietSanPham;
import models.model_DT.TrangThaiDongHo;

import repositorys.IRepo_DT.IChiTietDongHoRepository;
import repositorys.IRepo_DT.ITrangThaiDongHoRepository;
import utilconnext.DBConnection;
import viewmodel.ViewModel_DT.DongHoChiTietViewModel;
import viewmodel.ViewModel_DT.SanPhamTronHoaDonModel;

public class TrangThaiDongHoRepository implements ITrangThaiDongHoRepository {

    public static Connection conn = null;

    @Override
    public Boolean create(TrangThaiDongHo trangThai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(TrangThaiDongHo trangThai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int idTrangThai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTenTrangThaiByID(int idTrangThai) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select ten from TrangThaiDongHo where id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idTrangThai);

            ResultSet rs = stmt.executeQuery();
            String tenTrangThai = "";
            while (rs.next()) {
                tenTrangThai = rs.getString("ten");
            }

            rs.close();
            stmt.close();
            conn.close();

            return tenTrangThai;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai sua dong ho: " + ex.getMessage());
        }
        return "";
    }

    @Override
    public ArrayList<TrangThaiDongHo> selectAll() {
        ArrayList<TrangThaiDongHo> arr_trangThaiDH = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select id, ten from TrangThaiDongHo\n";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                TrangThaiDongHo trangThai = new TrangThaiDongHo(result.getInt("id"), result.getString("ten"));
                arr_trangThaiDH.add(trangThai);
            }
            stmt.close();
            conn.close();
            result.close();

            return arr_trangThaiDH;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of trang thai dong ho : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Integer getIDByTrangThai(String tenTrangThai) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select id from TrangThaiDongHo where ten=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tenTrangThai);

            ResultSet rs = stmt.executeQuery();
            int idTH = 0;
            while (rs.next()) {
                idTH = rs.getInt("id");
            }

            rs.close();
            stmt.close();
            conn.close();

            return idTH;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai sua dong ho: " + ex.getMessage());
        }
        return -1;
    }

}
