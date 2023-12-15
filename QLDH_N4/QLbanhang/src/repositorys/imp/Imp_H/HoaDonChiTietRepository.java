package repositorys.imp.Imp_H;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.model_H.HoaDon;
import models.model_H.HoaDonChiTiet;
import static repositorys.imp.Imp_H.HoaDonRepository.conn;
import repositorys.IRepo_H.IHoaDonChiTietRepository;
import utilconnext.DBConnection;
import viewmodel.ViewModel_H.HoaDonChiTietViewModel;

public class HoaDonChiTietRepository implements IHoaDonChiTietRepository {

    @Override
    public ArrayList<HoaDonChiTiet> getAll() {
        ArrayList<HoaDonChiTiet> dsHoaDonCT = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select id_hoaDon, id_chiTietDH_, soLuong, donGia, thanh_tien,Dongiakhigiam from HoaDonChiTiet \n";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            //(Integer idHoaDon, Integer idChiTietDH, Integer soLuong, Double donGia,
            //Double thanhTien, Double donGiaKhiGiam) {
        
                HoaDonChiTiet hoaDon = new HoaDonChiTiet(rs.getInt("id_hoaDon"), rs.getInt("id_chiTietDH_"),
                         rs.getInt("soLuong"), rs.getDouble("donGia"), rs.getDouble("thanh_tien"), rs.getDouble("Dongiakhigiam"));

                dsHoaDonCT.add(hoaDon);
            }
            stmt.close();
            conn.close();
            rs.close();

            return dsHoaDonCT;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error get all danh sach hoa don chi tiết : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<HoaDonChiTietViewModel> getHoaDonModel() {
        ArrayList<HoaDonChiTietViewModel> dsHoaDonCT = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select id_hoaDon , id_chiTietDH_, tenDongHo,  HoaDonChiTiet.Soluong as soLuong, "
                    + "giaBan, Dongiakhigiam, tongTien =giaBan*HoaDonChiTiet.Soluong\n"
                    + "from HoaDonChiTiet\n"
                    + "join ChiTietDongHo on HoaDonChiTiet.id_chiTietDH_ = ChiTietDongHo.idChiTietDH\n"
                    + "join HoaDon on HoaDonChiTiet.id_hoaDon = HoaDon.Id\n"
                    + "join DongHo on ChiTietDongHo.idDongHo = DongHo.idDH";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // (Integer idHoaDon, Integer idChiTietDH, String tenDH, Integer soLuong, 
                //Double giaBan, Double giaBanGiam, Double thanhTien) {
        
                
                HoaDonChiTietViewModel hoaDon = new HoaDonChiTietViewModel
            (rs.getInt("id_hoaDon"), rs.getInt("id_chiTietDH_"), rs.getString("tenDongHo"), rs.getInt("soLuong"),
                             rs.getDouble("giaBan"), rs.getDouble("Dongiakhigiam"), rs.getDouble("tongTien"));
                
                dsHoaDonCT.add(hoaDon);
            }
            stmt.close();
            conn.close();
            rs.close();

            return dsHoaDonCT;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error get all danh sach hoa don chi tiết view model  : " + ex.getMessage());
        }
        return null;
    }   

    @Override
    public boolean create(HoaDonChiTiet hoaDon) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "insert into HoaDonChiTiet(id_hoaDon, id_chiTietDH_, soLuong, donGia, thanh_tien"
                    + ",Dongiakhigiam)\n" +
                    "values(?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, hoaDon.getIdHoaDon());
            stmt.setInt(2, hoaDon.getIdChiTietDH());
            stmt.setInt(3, hoaDon.getSoLuong());
            stmt.setDouble(4, hoaDon.getDonGia());
            stmt.setDouble(5, hoaDon.getThanhTien());
            stmt.setDouble(6, hoaDon.getDonGiaKhiGiam());
            

            stmt.executeUpdate();

            stmt.close();
            conn.close();

            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error khi tạo mới HOA DON: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(HoaDonChiTiet hoaDon) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update HoaDonChiTiet \n"
                    + "set Soluong= ?\n"
                    + "where id_hoaDon=? and id_chiTietDH_=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, hoaDon.getSoLuong());
            stmt.setInt(2, hoaDon.getIdHoaDon());
            stmt.setInt(3, hoaDon.getIdChiTietDH());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai sua HÓA ĐƠN CHI TIẾT: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(int idHDCT, int idCTSP) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "delete from HoaDonChiTiet where id_hoaDon=? and id_chiTietDH_=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idHDCT);
            stmt.setInt(2, idCTSP);

            stmt.executeUpdate();

            stmt.close();
            conn.close();

            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi xảy ra khi xóa hóa đơn chi tiết : " + ex.getMessage());

        }
        return false;
    }

}
