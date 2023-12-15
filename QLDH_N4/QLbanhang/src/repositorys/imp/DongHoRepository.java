
package repositorys.imp;

import models.DongHo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import repositorys.IDongHoRepository;
import utilconnext.DBConnection;


public class DongHoRepository implements IDongHoRepository {
    public static Connection conn = null;


    @Override
    public boolean update(DongHo dongHo) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "update DongHo set tenDongHo=?, thuongHieu=?, xuatXu=?, noiSanXuat=?"
                    + ",chatLieuMatSo=?,duongKinhMatSo=?,beDayMatSo=?, idTrangThaiDH=?, "
                    + "tinhNang=?, thoiGianBaoHanh=?"
                    + " where idDH=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dongHo.getTen());
            stmt.setString(2, dongHo.getThuongHieu());
            stmt.setString(3, dongHo.getXuatXu());
            stmt.setString(4, dongHo.getNoiSanXuat());
            stmt.setString(5, dongHo.getChatLieuMatSo());
            stmt.setDouble(6, dongHo.getDuongKinhMatSo());
            stmt.setDouble(7, dongHo.getBeDayMatSo());
            stmt.setInt(8, dongHo.getIdTrangThaiDH());
            stmt.setString(9, dongHo.getTinhNang());
            stmt.setInt(10, dongHo.getThoiGianBH());
            stmt.setInt(11, dongHo.getId());
            
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error tai sua dong ho: " + ex.getMessage());
        }
        return false;
    }


    @Override
    public boolean create(DongHo dongHo) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "insert into DongHo (tenDongHo, thuongHieu, xuatXu, noiSanXuat, chatLieuMatSo,"
                    + " duongKinhMatSo, beDayMatSo, tinhNang, thoiGianBaoHanh, idTrangThaiDH) values  \n" +
                    "(?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dongHo.getTen());
            stmt.setString(2, dongHo.getThuongHieu());
            stmt.setString(3, dongHo.getXuatXu());
            stmt.setString(4, dongHo.getNoiSanXuat());
            stmt.setString(5, dongHo.getChatLieuMatSo());
            stmt.setDouble(6, dongHo.getDuongKinhMatSo());
            stmt.setDouble(7, dongHo.getBeDayMatSo());
            stmt.setString(8, dongHo.getTinhNang());
            stmt.setDouble(9, dongHo.getThoiGianBH());
            stmt.setInt(10, dongHo.getIdTrangThaiDH());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error khi tạo mới dong ho: " + ex.getMessage());
        }
        return false;
    }


    @Override
    public boolean delete(int idDongHo) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "delete from DongHo where idDH=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idDongHo);
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Xóa các sản phẩm chi tiết của sản phẩm mới xóa được sản phẩm" );
            
        }
        return false;
    }

    @Override
    public ArrayList<DongHo> selectAll() {
        ArrayList<DongHo> arr_dongHo = new ArrayList<>();
        try { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select idDH,tenDongHo, thuongHieu, xuatXu, noiSanXuat, chatLieuMatSo, duongKinhMatSo, "
                    + "beDayMatSo, tinhNang, thoiGianBaoHanh, idTrangThaiDH from DongHo order by idDH DESC";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                DongHo dongHo = new DongHo(rs.getInt("idDH"), rs.getString("tenDongHo"), rs.getString("thuongHieu")
                        , rs.getString("xuatXu"), rs.getString("noiSanXuat"), rs.getString("chatLieuMatSo")
                        , rs.getDouble("duongKinhMatSo"), rs.getDouble("beDayMatSo"), rs.getString("tinhNang")
                        , rs.getInt("thoiGianBaoHanh"), rs.getInt("idTrangThaiDH"));
                arr_dongHo.add(dongHo);
            }
            stmt.close();
            conn.close();
            rs.close();
            
            return arr_dongHo;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of Dong Ho : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<DongHo> filterByTrangThai(int trangThai) {
        ArrayList<DongHo> arr_dongHo = new ArrayList<>();
        try { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select idDH,tenDongHo, thuongHieu, xuatXu, noiSanXuat, chatLieuMatSo, duongKinhMatSo, "
                    + "beDayMatSo, tinhNang, thoiGianBaoHanh, idTrangThaiDH from DongHo\n" +
"                    where idTrangThaiDH=?  order by idDH DESC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, trangThai);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                DongHo dongHo = new DongHo(rs.getInt("idDH"), rs.getString("tenDongHo"), rs.getString("thuongHieu")
                        , rs.getString("xuatXu"), rs.getString("noiSanXuat"), rs.getString("chatLieuMatSo")
                        , rs.getDouble("duongKinhMatSo"), rs.getDouble("beDayMatSo"), rs.getString("tinhNang")
                        , rs.getInt("thoiGianBaoHanh"), rs.getInt("idTrangThaiDH"));
                arr_dongHo.add(dongHo);
            }
            stmt.close();
            conn.close();
            rs.close();
            
            return arr_dongHo;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of Dong Ho : " + ex.getMessage());
        }
        return null;
    }


    @Override
    public ArrayList<DongHo> filterByTenDH_chatLieu_tinhNang(String tenLoc) {
        ArrayList<DongHo> arr_dongHo = new ArrayList<>();
        try { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select idDH,tenDongHo, thuongHieu, xuatXu, noiSanXuat, chatLieuMatSo, duongKinhMatSo, beDayMatSo, tinhNang, thoiGianBaoHanh, idTrangThaiDH from DongHo\n" +
                        "where chatLieuMatSo like ? or tinhNang like ? or "
                        + "tenDongHo like ? \n" +
                        " order by idDH DESC";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,  "%" + tenLoc + "%" );
            stmt.setString(2,   "%" + tenLoc + "%" );
            stmt.setString(3,   "%" + tenLoc + "%" );
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                DongHo dongHo = new DongHo(rs.getInt("idDH"), rs.getString("tenDongHo"), rs.getString("thuongHieu")
                        , rs.getString("xuatXu"), rs.getString("noiSanXuat"), rs.getString("chatLieuMatSo")
                        , rs.getDouble("duongKinhMatSo"), rs.getDouble("beDayMatSo"), rs.getString("tinhNang")
                        , rs.getInt("thoiGianBaoHanh"), rs.getInt("idTrangThaiDH"));
                arr_dongHo.add(dongHo);
            }
            stmt.close();
            conn.close();
            rs.close();
            
            return arr_dongHo;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error load data of Dong Ho : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public int getIDDongHoByTenDongHo(String tenDH) {
        try { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DBConnection.openDbConnection();
            String sql = "select idDH from DongHo where tenDongHo like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,tenDH);
            
            int idDH = -1;
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                 idDH = rs.getInt("idDH");
            }
            stmt.close();
            conn.close();
            rs.close();
            
            return idDH;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Driver : " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error ở lấy ra id đồng hồ qua tên : " + ex.getMessage());
        }
        return -1;
    }
    
    

  

}
