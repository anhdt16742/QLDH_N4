/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorys.imp.Imp_TA;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.KhuyenMai;
import repositorys.IRepo_TA.IKhuyenmaiRepository;

import utilconnext.DBConnection;

/**
 *
 * @author ADMIN
 */
public class KhuyenmaiReponsitory implements IKhuyenmaiRepository {

    List<KhuyenMai> lstKm;

    public KhuyenmaiReponsitory() {
        lstKm = new ArrayList<>();
    }

    @Override
    public List<KhuyenMai> GetAll() {
        try {
            lstKm.removeAll(lstKm);
            String sql = "Select * from Khuyenmai";
            Connection conn = DBConnection.openDbConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                Date dateObj = rs.getDate("Ngaybatdau");

                String ngaybatdau = dateObj.toString();
                Date dateObj2 = rs.getDate("Ngayketthuc");

                String Ngayketthuc = dateObj2.toString();

                lstKm.add(new KhuyenMai(rs.getString("Ten"),
                        rs.getString("HinhthucKM"), ngaybatdau, Ngayketthuc, rs.getDouble("GiatriGiam"), rs.getInt("id"), rs.getInt("Trangthai")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenmaiReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstKm;
    }

    @Override
    public boolean Add(KhuyenMai km) {
        String sql = "INSERT INTO KHUYENMAI(TEN,HINHTHUCKM,NGAYBATDAU,NGAYKETTHUC,GIATRIGIAM) VALUES(?,?,?,?,?)";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, km.getTenKM());
            pstm.setString(2, km.getHinhThucKM());
            pstm.setString(3, km.getNgayBatDau());
            pstm.setString(4, km.getNgayKetThuc());
            pstm.setDouble(5, km.getGiaTriGiam());

            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm khuyến mãi" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean Update(KhuyenMai km, int id) {
        String sql = "UPDATE KHUYENMAI SET TEN=?,NGAYBATDAU=?,NGAYKETTHUC = ?,HINHTHUCKM=?,GIATRIGIAM =? WHERE ID = ?";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, km.getTenKM());
            pstm.setString(2, km.getNgayBatDau());
            pstm.setString(3, km.getNgayKetThuc());
            pstm.setString(4, km.getHinhThucKM());
            pstm.setDouble(5, km.getGiaTriGiam());
            pstm.setInt(6, id);
            pstm.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println("Lỗi khi Sửa khuyến mãi" + e.getMessage());

        }
        return false;
    }

    @Override
    public boolean Delete(int id) {
        String sql = "DELETE FROM KHUYENMAI WHERE ID = ?";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi khi Xóa khuyến mãi" + e.getMessage());
        }
        return false;
    }

    @Override
    public String checktrung(String ten) {
        String sql = " SELECT TEN FROM KHUYENMAI WHERE TEN = ?";
        String box = null;
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, ten);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                box = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return box;
    }

    @Override
    public List<KhuyenMai> GetOnebyBD(String date) {
        try {
            lstKm.removeAll(lstKm);
            String sql = "Select id, Ten, Ngaybatdau, Ngayketthuc, HinhthucKM, Giatrigiam,Trangthai from KhuyenMai \n"
                    + "Where Ngaybatdau =?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, date);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Date dateObj = rs.getDate("Ngaybatdau");

                String ngaybatdau = dateObj.toString();
                Date dateObj2 = rs.getDate("Ngayketthuc");

                String Ngayketthuc = dateObj2.toString();
                lstKm.add(new KhuyenMai(rs.getString("Ten"),
                        rs.getString("HinhthucKM"), ngaybatdau, Ngayketthuc, rs.getDouble("GiatriGiam"), rs.getInt("id"), rs.getInt("Trangthai")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenmaiReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstKm;
    }

    @Override
    public List<KhuyenMai> GetOnebyKT(String date) {
        try {
            lstKm.removeAll(lstKm);
            String sql = "Select id, Ten, Ngaybatdau, Ngayketthuc, HinhthucKM, Giatrigiam,Trangthai from KhuyenMai \n"
                    + "Where NGAYKETTHUC =?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, date);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Date dateObj = rs.getDate("Ngaybatdau");

                String ngaybatdau = dateObj.toString();
                Date dateObj2 = rs.getDate("Ngayketthuc");

                String Ngayketthuc = dateObj2.toString();
                lstKm.add(new KhuyenMai(rs.getString("Ten"),
                        rs.getString("HinhthucKM"), ngaybatdau, Ngayketthuc, rs.getDouble("GiatriGiam"), rs.getInt("id"), rs.getInt("Trangthai")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenmaiReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstKm;
    }

    @Override
    public List<KhuyenMai> GetOnebyALL(String datedb, String datekt) {
        try {
            lstKm.removeAll(lstKm);
            String sql = "SELECT [id]\n"
                    + "      ,[Ten]\n"
                    + "      ,[Ngaybatdau]\n"
                    + "      ,[Ngayketthuc]\n"
                    + "      ,[HinhthucKM]\n"
                    + "      ,[Giatrigiam]\n"
                    + "      ,[trangThai]\n"
                    + "  FROM [dbo].[Khuyenmai] where Ngaybatdau=? and Ngayketthuc= ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, datedb);
            pstm.setString(2, datekt);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Date dateObj = rs.getDate("Ngaybatdau");

                String ngaybatdau = dateObj.toString();
                Date dateObj2 = rs.getDate("Ngayketthuc");

                String Ngayketthuc = dateObj2.toString();
                lstKm.add(new KhuyenMai(rs.getString("Ten"),
                        rs.getString("HinhthucKM"), ngaybatdau, Ngayketthuc, rs.getDouble("GiatriGiam"), rs.getInt("id"), rs.getInt("Trangthai")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lstKm;
    }

    @Override
    public List<KhuyenMai> GetOnebyten(String ten) {
        try {
            lstKm.removeAll(lstKm);
            String sql = "SELECT [id]\n"
                    + "      ,[Ten]\n"
                    + "      ,[Ngaybatdau]\n"
                    + "      ,[Ngayketthuc]\n"
                    + "      ,[HinhthucKM]\n"
                    + "      ,[Giatrigiam]\n"
                    + "      ,[trangThai]\n"
                    + "  FROM [dbo].[Khuyenmai] where Ten=? ";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, ten);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Date dateObj = rs.getDate("Ngaybatdau");

                String ngaybatdau = dateObj.toString();
                Date dateObj2 = rs.getDate("Ngayketthuc");

                String Ngayketthuc = dateObj2.toString();
                lstKm.add(new KhuyenMai(rs.getString("Ten"),
                        rs.getString("HinhthucKM"), ngaybatdau, Ngayketthuc, rs.getDouble("GiatriGiam"), rs.getInt("id"), rs.getInt("Trangthai")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenmaiReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstKm;
    }

//    @Override
//    public boolean UpdateTT() {
//        String sql = "UPDATE KHUYENMAI SET TrangThai = 1,GIATRIGIAM =0 WHERE NGAYKETTHUC < GETDATE()";
//        try {
//            Connection conn = DBConnection.getConnection();
//            PreparedStatement pstm = conn.prepareStatement(sql);
//            pstm.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    @Override
//    public boolean UpdateTT2() {
//        String sql = "UPDATE KHUYENMAI SET TrangThai = 0 WHERE NGAYKETTHUC > GETDATE()";
//        try {
//            Connection conn = DBConnection.getConnection();
//            PreparedStatement pstm = conn.prepareStatement(sql);
//            pstm.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
    private List<KhuyenMai> Getbyid(int id) {
        List<KhuyenMai> lst = new ArrayList<>();
        try {

            String sql = "SELECT * FROM dbo.KhuyenMai WHERE Id = ?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Date dateObj = rs.getDate("Ngaybatdau");

                String ngaybatdau = dateObj.toString();
                Date dateObj2 = rs.getDate("Ngayketthuc");

                String Ngayketthuc = dateObj2.toString();
                lstKm.add(new KhuyenMai(rs.getString("Ten"),
                        rs.getString("HinhthucKM"), ngaybatdau, Ngayketthuc, rs.getDouble("GiatriGiam"), rs.getInt("id"), rs.getInt("Trangthai")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenmaiReponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public KhuyenMai getbyid(int id) {
        KhuyenMai km = new KhuyenMai();
        if (id == 0) {
            return km;
        }
        km = Getbyid(id).get(0);
        return km;
    }

    public static void main(String[] args) {
        boolean flag = new KhuyenmaiReponsitory().updateStatusKMHetHan();
        System.out.println(flag);
        
    }

    @Override
    public Boolean updateStatusKMHetHan() {
         String sql = "update Khuyenmai set trangThai = 1 where Ngayketthuc<GETDATE()";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật trạng thái khuyến mãi" + e.getMessage());
        }
        return false;
    }
    
    

}

