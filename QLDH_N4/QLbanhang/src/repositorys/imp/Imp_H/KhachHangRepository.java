package repositorys.imp.Imp_H;

import java.sql.Connection;
import java.util.ArrayList;
import models.model_H.KhachHang;
import repositorys.IRepo_H.IKhachHangRepository;
import utilconnext.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangRepository implements IKhachHangRepository {

    public static Connection conn = null;

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> arr_khachHang = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select MaKhachHang,TenKhachHang, SinhNhat, DiaChi, SoDienThoai, Email, "
                    + "GioiTinh, SoCanCuoc, AnhDaiDien, DiemTichLuy, TrangThai from KhachHang";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
// Integer maKH, String tenKH, Date sinhNhat, String diaChi, String soDienThoai, 
//String email, Boolean gioiTinh, String soCMND, String anhDaiDien, Integer diemTichLuy, Integer trangThai) {
        
                KhachHang khachHang = new KhachHang(rs.getInt("maKhachHang")
                        , rs.getString("TenKhachHang"), rs.getDate("SinhNhat"), rs.getString("DiaChi"), 
                        rs.getString("SoDienThoai"), rs.getString("Email"), rs.getBoolean("GioiTinh")
                        , rs.getString("SoCanCuoc"), rs.getString("AnhDaiDien")
                        , rs.getInt("DiemTichLuy"), rs.getInt("TrangThai"));
                arr_khachHang.add(khachHang);
            }
            stmt.close();
            conn.close();
            rs.close();

            return arr_khachHang;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of Khách hàng : " + ex.getMessage());
        } 
        return null;
    }

    @Override
    public ArrayList<KhachHang> searchBySDTKH(String sdt) {
        ArrayList<KhachHang> arr_khachHang = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select MaKhachHang,TenKhachHang, SinhNhat, DiaChi, SoDienThoai, Email, "
                    + "GioiTinh, SoCanCuoc, AnhDaiDien, DiemTichLuy, TrangThai from KhachHang \n"
                    + "where SoDienThoai like ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, sdt);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
// Integer maKH, String tenKH, Date sinhNhat, String diaChi, String soDienThoai, 
//String email, Boolean gioiTinh, String soCMND, String anhDaiDien, Integer diemTichLuy, Integer trangThai) {
        
                KhachHang khachHang = new KhachHang(rs.getInt("maKhachHang")
                        , rs.getString("TenKhachHang"), rs.getDate("SinhNhat"), rs.getString("DiaChi"), 
                        rs.getString("SoDienThoai"), rs.getString("Email"), rs.getBoolean("GioiTinh")
                        , rs.getString("SoCanCuoc"), rs.getString("AnhDaiDien")
                        , rs.getInt("DiemTichLuy"), rs.getInt("TrangThai"));
                arr_khachHang.add(khachHang);
            }
            stmt.close();
            conn.close();
            rs.close();

            return arr_khachHang;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of Khách hàng : " + ex.getMessage());
        } 
        return null;
    }

    @Override
    public String findBySDT_returnNameKH(String sdt) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select TenKhachHang from KhachHang \n"
                    + "where SoDienThoai like ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, sdt);
            
            ResultSet rs = stmt.executeQuery();
            String tenKH = "";
            while (rs.next()) {
                 tenKH = rs.getString("TenKhachHang");
            }
            stmt.close();
            conn.close();
            rs.close();

            return tenKH;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error khi find sdt khách hàng : " + ex.getMessage());
        } 
        return "";
    }

}
