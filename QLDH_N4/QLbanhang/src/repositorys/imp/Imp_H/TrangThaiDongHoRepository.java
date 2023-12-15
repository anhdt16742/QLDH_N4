package repositorys.imp.Imp_H;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.model_H.ChiTietDongHo;
import models.model_H.TrangThaiChiTietSanPham;
import models.model_H.TrangThaiDongHo;
import static repositorys.imp.Imp_H.ChiTietDongHoRepository.conn;
import static repositorys.imp.Imp_H.DongHoRepository.conn;
import repositorys.IRepo_H.IChiTietDongHoRepository;
import repositorys.IRepo_H.ITrangThaiDongHoRepository;
import utilconnext.DBConnection;
import viewmodel.ViewModel_H.DongHoChiTietViewModel;
import viewmodel.ViewModel_H.SanPhamTronHoaDonModel;

public class TrangThaiDongHoRepository implements ITrangThaiDongHoRepository {

    public static Connection conn = null;

    @Override
    public Boolean create(TrangThaiDongHo trangThai) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "insert into TrangThaiDongHo(ten) values (?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, trangThai.getTenTrangThai());
            
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai create Trạng thái đồng hồ : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(TrangThaiDongHo trangThai) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update TrangThaiDongHo set ten=? where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, trangThai.getTenTrangThai());
            stmt.setInt(2, trangThai.getId());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai update trạng thái đồng hồ: " + ex.getMessage());
        }
        return false;
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
