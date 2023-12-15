package repositorys.imp.Imp_DT;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.model_DT.DongHo;
import models.model_DT.MauQuaiDeo;

import utilconnext.DBConnection;
import repositorys.IRepo_DT.IMauQuaiDeoRepository;
import static repositorys.imp.Imp_DT.DongHoRepository.conn;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int idMauQuaiDeo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
