package repositorys.imp.Imp_H;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.model_H.DongHo;
import models.model_H.MauQuaiDeo;
import static repositorys.imp.Imp_H.DongHoRepository.conn;
import utilconnext.DBConnection;
import repositorys.IRepo_H.IMauQuaiDeoRepository;

public class MauQuaiDeoRepository implements IMauQuaiDeoRepository {

    @Override
    public Boolean create(MauQuaiDeo mauQuaiDeo) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "insert into MauDayDeo(ten) values (?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.clearParameters();
            stmt.setString(1, mauQuaiDeo.getTenQuaiDeo());
            stmt.executeUpdate();

            stmt.close();
            conn.close();

            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai tao moi Màu Quai Đeo: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(MauQuaiDeo mauQuaiDeo) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update MauDayDeo set ten=? where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mauQuaiDeo.getTenQuaiDeo());
            stmt.setInt(2, mauQuaiDeo.getIdMauQuaiDeo());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai update Màu quai đeo: " + ex.getMessage());
        }
        return false;
    }

   

    @Override
    public ArrayList<MauQuaiDeo> selectAll() {
        ArrayList<MauQuaiDeo> arr_mauQuaiDeo = new ArrayList<>();
        try { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select id, ten from  MauDayDeo";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                MauQuaiDeo mauQuaiDeo = new MauQuaiDeo(rs.getInt("id"), rs.getString("ten"));
                arr_mauQuaiDeo.add(mauQuaiDeo);
            }
            stmt.close();
            conn.close();
            rs.close();
            
            return arr_mauQuaiDeo;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of Màu quai đeo : " + ex.getMessage());
        }
        return null;
    }

}
