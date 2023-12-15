
package repositorys.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.TrangThaiChiTietSanPham;

import utilconnext.DBConnection;
import repositorys.ITrangThaiDongHoChiTietRepository;


public class TrangThaiDongHoChiTietRepository implements ITrangThaiDongHoChiTietRepository {
    public static Connection conn = null;


    @Override
    public boolean create(TrangThaiChiTietSanPham trangThai) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "insert into TrangThaiChiTietDongHo(ten) values (?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, trangThai.getTrangThai());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai create trang thai chi tiet san pham: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(TrangThaiChiTietSanPham trangThai) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update TrangThaiChiTietDongHo set ten=? where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, trangThai.getTrangThai());
            stmt.setInt(2, trangThai.getId());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai sua trang thai chi tiet san pham: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<TrangThaiChiTietSanPham> selectAll() {
        ArrayList<TrangThaiChiTietSanPham> arr_trangThaiChiTietSP = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select id, ten from TrangThaiChiTietDongHo\n";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                TrangThaiChiTietSanPham trangThaiSP = new TrangThaiChiTietSanPham(result.getInt("id"), result.getString("ten"));
                arr_trangThaiChiTietSP.add(trangThaiSP);
            }
            stmt.close();
            conn.close();
            result.close();
            
            return arr_trangThaiChiTietSP;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of trang thai chi tiet san pham : " + ex.getMessage());
        }
        return null;
    }
    
}
