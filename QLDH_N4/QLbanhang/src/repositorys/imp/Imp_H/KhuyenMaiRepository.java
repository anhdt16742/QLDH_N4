
package repositorys.imp.Imp_H;

import repositorys.IRepo_H.IKhuyenMaiRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import models.model_H.KhuyenMai;
import static repositorys.imp.Imp_H.DongHoRepository.conn;
import utilconnext.DBConnection;

public class KhuyenMaiRepository implements IKhuyenMaiRepository{

    @Override
    public ArrayList<KhuyenMai> selectAll() {
        ArrayList<KhuyenMai> arr_khuyenMai = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select id, ten, ngayBatDau, ngayKetThuc, hinhThucKM, giaTriGiam from Khuyenmai\n";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                java.util.Date  ngayBatDau = new java.util.Date(rs.getDate("ngayBatDau").getTime());
                java.util.Date  ngayKetThuc = new java.util.Date(rs.getDate("ngayKetThuc").getTime());
                
                KhuyenMai khuyenMai = new KhuyenMai(rs.getInt("id"), rs.getString("ten")
                        , ngayBatDau, ngayKetThuc 
                        , rs.getString("hinhThucKM"), rs.getDouble("giaTriGiam"));
                arr_khuyenMai.add(khuyenMai);
            }
            stmt.close();
            conn.close();
            rs.close();
            
            return arr_khuyenMai;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of khuyen mai: " + ex.getMessage());
        }
        return null;
    }
    
}
