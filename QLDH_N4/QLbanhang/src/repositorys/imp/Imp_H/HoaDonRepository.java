package repositorys.imp.Imp_H;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.model_H.DongHo;
import models.model_H.HoaDon;
import repositorys.IRepo_H.IHoaDonRepository;
import utilconnext.DBConnection;
import viewmodel.ViewModel_H.DongHoChiTietViewModel;
import viewmodel.ViewModel_H.HoaDonViewModel;
import viewmodel.ViewModel_H.HoaDonModelToInsert;
import java.time.LocalDate;
import java.sql.Date;

public class HoaDonRepository implements IHoaDonRepository {

    public static Connection conn = null;

    @Override
    public ArrayList<HoaDon> getAll() {
        ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select id, idKH, idNV, ngayTao, ngayThanhToan, idTrangThai from HoaDon \n";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // (Integer idHoaDon, Integer idKhachHang, Integer idNhanVien, String ma
                //, Date ngayTao, Date ngayThanhToan, Integer idTrangThai) {
                
                

                java.util.Date ngayTao = rs.getDate("ngayTao")==null? null: new java.util.Date(rs.getDate("ngayTao").getTime());
                java.util.Date ngayThanhToan = rs.getDate("ngayThanhToan")==null? null: new java.util.Date(rs.getDate("ngayThanhToan").getTime());
                
                HoaDon hoaDon = new HoaDon(rs.getInt("id"), rs.getInt("idKH"), rs.getInt("idNV"),
                         ngayTao, ngayThanhToan, rs.getInt("idTrangThai"));

                danhSachHoaDon.add(hoaDon);
            }
            stmt.close();
            conn.close();
            rs.close();

            return danhSachHoaDon;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error get all danh sach hoa don cho : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<HoaDonViewModel> getHoaDonModel() {
        
        ArrayList<HoaDonViewModel> danhSachHoaDon = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select HoaDon.id as maHoaDon, nhanvien.Ten as tenNV, KhachHang.TenKhachHang as tenKH "
                    + ", trangThaiHoaDon.tenTinhTrang as trangThai \n" +
                            "from HoaDon\n" +
                            "join nhanvien on HoaDon.IdNV = nhanvien.Id\n" +
                            "join KhachHang on HoaDon.IdKH = KhachHang.MaKhachHang\n" +
                            "join trangThaiHoaDon on HoaDon.idTrangThai = trangThaiHoaDon.id";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // Integer maHoaDon, String tenNhanVien, String tenKhachHang, String trangThaiHoaDon) {
                HoaDonViewModel hoaDonModel = new HoaDonViewModel(rs.getInt("maHoaDon"), rs.getString("tenNV"),
                         rs.getString("tenKH"), rs.getString("trangThai"));

                danhSachHoaDon.add(hoaDonModel);
            }
            stmt.close();
            conn.close();
            rs.close();

            return danhSachHoaDon;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error get all danh sach hoa don model cho : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean create(HoaDon hoaDon) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "insert into HoaDon (idKH, idNV, ngayTao) values(?,?,GETDATE())";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, hoaDon.getIdKhachHang());
            stmt.setInt(2, hoaDon.getIdNhanVien());

//            java.util.Date utilDate = hoaDon.getNgayTao();
//            java.sql.Date ngayTao = new java.sql.Date(utilDate.getTime());
//            
//            java.util.Date utilDate2 = hoaDon.getNgayThanhToan();
//            java.sql.Date ngayThanhToan = new java.sql.Date(utilDate2.getTime());
//
//            stmt.setDate(3, ngayTao);
//            stmt.setInt(4, hoaDon.getIdTrangThai());

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
    public boolean update(HoaDon hoaDon) {
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update HoaDon set IdKH=?, IdNV=?, NgayTao=?, NgayThanhToan=?, idTrangThai=?\n" +
                            "where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, hoaDon.getIdKhachHang());
            stmt.setInt(2, hoaDon.getIdNhanVien());

            java.util.Date utilDate = hoaDon.getNgayTao();
            java.sql.Date ngayTao = new java.sql.Date(utilDate.getTime());
            
            java.util.Date utilDate2 = hoaDon.getNgayThanhToan();
            java.sql.Date ngayThanhToan = new java.sql.Date(utilDate2.getTime());

            stmt.setDate(3, ngayTao);
            stmt.setDate(4, ngayThanhToan);
            stmt.setInt(5, hoaDon.getIdTrangThai());
            stmt.setInt(6, hoaDon.getIdHoaDon());
            
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai sua HÓA ĐƠN: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(int idHD) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "delete from HoaDon where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idHD);
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Xóa hóa đơn chi tiết của hóa đơn, mới xóa hóa đơn được" + ex.getMessage());
            
        }
        return false;
    }


    @Override
    public boolean updateHoaDonAfterThanhToan(int idHD, Double tongTien, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update HoaDon set tongTien=? , ghiChu = ? , ngayThanhToan=?, idTrangThai=3 where Id=?";
            Date ngayHomNay = Date.valueOf(LocalDate.now());
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, tongTien);
            stmt.setString(2, ghiChu);
            stmt.setDate(3, ngayHomNay);
            stmt.setInt(4, idHD);
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Lỗi khi cập nhật hóa đơn khi thanh toán" + ex.getMessage());
            
        }
        return false;
    }
    
    @Override
    public boolean updateHoaDonCho(HoaDon hoaDon) {
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update HoaDon set IdKH=?, IdNV=? where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, hoaDon.getIdKhachHang());
            stmt.setInt(2, hoaDon.getIdNhanVien());
            stmt.setInt(3, hoaDon.getIdHoaDon());

            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai sửa hóa đơn chờ: " + ex.getMessage());
        }
        return false;
    }

}
