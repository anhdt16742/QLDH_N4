
package repositorys.imp.Imp_DT;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.model_DT.ChatLieuDay;
import models.model_DT.KieuMay;
import repositorys.IRepo_DT.IChatLieuDayRepository_;
import static repositorys.imp.Imp_DT.DongHoRepository.conn;
import utilconnext.DBConnection;


public class ChatLieuDayRepository implements IChatLieuDayRepository_ {

    @Override
    public boolean create(ChatLieuDay chatLieu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "insert into ChatLieuDay(ten) values (?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, chatLieu.getTen());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tao chat lieu day: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(ChatLieuDay chatLieu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update ChatLieuDay set ten=? where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, chatLieu.getTen());
            stmt.setInt(2, chatLieu.getId());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai cap nhat chat lieu day: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<ChatLieuDay> selectAll() {
        ArrayList<ChatLieuDay> arrChatLieuDay = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select id, ten from ChatLieuDay\n";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                ChatLieuDay chatLieuDay = new ChatLieuDay(result.getInt("id"), result.getString("ten"));
                arrChatLieuDay.add(chatLieuDay);
            }
            stmt.close();
            conn.close();
            result.close();
            
            return arrChatLieuDay;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of Chat lieu day : " + ex.getMessage());
        }
        return null;
    }

    
}
