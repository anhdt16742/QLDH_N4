package repositorys.imp;

import repositorys.IGioiTinhDongHoRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.DongHo;
import models.GioiTinh;
import static repositorys.imp.DongHoRepository.conn;

import utilconnext.DBConnection;

public class GioiTinhDongHoRepository implements IGioiTinhDongHoRepository {

    @Override
    public boolean create(GioiTinh gioiTinh) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "insert into GioiTinh(ten) values (?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, gioiTinh.getTen());

            stmt.executeUpdate();
            stmt.close();
            conn.close();

            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai create Gioi Tinh dong ho: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(GioiTinh gioiTinh) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update GioiTinh set ten=? where id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, gioiTinh.getTen());
            stmt.setInt(2, gioiTinh.getId());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai update Gioi Tinh: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<GioiTinh> selectAll() {
        ArrayList<GioiTinh> arr_gioiTinh = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select id, ten from gioiTinh\n";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                GioiTinh gt = new GioiTinh(result.getInt("id"), result.getString("ten"));
                arr_gioiTinh.add(gt);
            }
            stmt.close();
            conn.close();
            result.close();

            return arr_gioiTinh;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai update Gioi Tinh: " + ex.getMessage());
        }
        return null;
    }

}
