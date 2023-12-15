
package repositorys.imp.Imp_H;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.model_H.KhachHang;
import static repositorys.imp.Imp_H.KhachHangRepository.conn;
import repositorys.IRepo_H.INhanVienRepository;
import utilconnext.DBConnection;

public class NhanVienRepository implements INhanVienRepository{

    @Override
    public int getIDMaNhanVienByName(String tenNhanVien) {
        ArrayList<KhachHang> arr_khachHang = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select id from nhanvien where Ten like ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tenNhanVien);
            
            ResultSet rs = stmt.executeQuery();
            int idNV = 0;
            while (rs.next()) {
                 idNV = rs.getInt("id");
            }
            stmt.close();
            conn.close();
            rs.close();

            return idNV;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error lấy id nhân viên theo tên : " + ex.getMessage());
        } 
        return -1;
    }
    
}
