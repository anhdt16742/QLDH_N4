
package repositorys.imp.Imp_H;

import repositorys.IRepo_H.IKieuMayRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.model_H.GioiTinh;
import models.model_H.KieuMay;
import static repositorys.imp.Imp_H.DongHoRepository.conn;
import utilconnext.DBConnection;
public class KieuMayRepository implements IKieuMayRepository{

    @Override
    public boolean create(KieuMay kieuMay) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "insert into KieuMay(ten) values (?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kieuMay.getTen());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai create kieu may: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(KieuMay kieuMay) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update KieuMay set ten=? where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kieuMay.getTen());
            stmt.setInt(2, kieuMay.getId());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai update kieu may: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<KieuMay> selectAll() {
        ArrayList<KieuMay> arr_kieuMay = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select id, ten from KieuMay\n";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                KieuMay kieuMay = new KieuMay(result.getInt("id"), result.getString("ten"));
                arr_kieuMay.add(kieuMay);
            }
            stmt.close();
            conn.close();
            result.close();
            
            return arr_kieuMay;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of KieuMay : " + ex.getMessage());
        }
        return null;
    }
    
}
