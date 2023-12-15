/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp.Imp_Huy;

import java.util.ArrayList;
import java.util.List;
import models.model_Huy.Users;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.model_Huy.Chucvu;
import utilconnext.DBConnection;
import repositorys.IRepo_Huy.IUsersReposytory;
import viewmodel.ViewModel_Huy.UsersViewmodel;

/**
 *
 * @author hungh
 */
public class UsersReposytory implements IUsersReposytory {

    @Override
    public List<Users> getAllNhanVien() {
        List<Users> nvv = new ArrayList<>();
        String sql = "SELECT nhanvien.id,nhanvien.Ten,NgaySinh,Gioitinh,Sdt,IdCV,ChucVu.Ten,TrangThai FROM nhanvien join ChucVu \n"
                + "on ChucVu.Id = nhanvien.IdCV";

        ResultSet rs = null;
        try {
            rs = DBConnection.getDataFromQuery(sql);
            while (rs.next()) {
                Chucvu cvv = new Chucvu(rs.getString(7), rs.getString(8));
                String id = rs.getString(1);
                String ten = rs.getString(2);
                String ngaysinh = rs.getString(3);
                Integer gioitinh = rs.getInt(4);
                String sdt = rs.getString(5);
                Integer tt = rs.getInt(6);

                nvv.add(new Users(id, ten, ngaysinh, gioitinh, sdt, tt, cvv));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersReposytory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nvv;
    }

    @Override
    public boolean add(Users nv) {
        String sql = "INSERT INTO [dbo].[nhanvien]\n"
                + "           ([Ten]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[Gioitinh]\n"
                + "           ,[Sdt]\n"
                + "           ,[TrangThai]\n"
                + "           ,[IdCV])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, nv.getTen());

            pstm.setString(2, nv.getNgaysinh());
            pstm.setInt(3, nv.getGioitinh());
            pstm.setString(4, nv.getSdt());
            pstm.setObject(6, nv.getChucVu().getId());

            pstm.setInt(5, nv.getTT());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Users us, String id) {
        String sql = "UPDATE [dbo].[nhanvien]\n"
                + "   SET [Ten] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[Gioitinh] = ?\n"
                + "      ,[Sdt] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[IdCV] = ?\n"
                + " WHERE id=?";

        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, us.getTen());
            ;
            pstm.setString(2, us.getNgaysinh());
            pstm.setInt(3, us.getGioitinh());
            pstm.setString(4, us.getSdt());
            pstm.setObject(6, us.getChucVu().getId());

            pstm.setInt(5, us.getTT());
            pstm.setString(7, id);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Users> SearchNVV(String Ten) {
        List<Users> nvv = new ArrayList<>();
        String sql = "SELECT [Id]\n"
                + "      ,[Ten]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[Gioitinh]\n"
                + "      ,[Sdt]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdCV]\n"
                + "  FROM [dbo].[nhanvien] where ten like ? ";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + Ten + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Chucvu cvv = new Chucvu(rs.getString(7));
                String id = rs.getString(1);
                String ten = rs.getString(2);
                String ngaysinh = rs.getString(3);
                Integer gioitinh = rs.getInt(4);
                String sdt = rs.getString(5);
                Integer tt = rs.getInt(6);

                nvv.add(new Users(id, ten, ngaysinh, gioitinh, sdt, tt, cvv));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsersReposytory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nvv;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM [dbo].[nhanvien]\n"
                + "      WHERE id=?";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private List<Users> getdataQuery(String SQL, Object... arvg) {
        List<Users> lst = new ArrayList<>();

        try {
            ResultSet rs = DBConnection.getDataFromQuery(SQL, arvg);
            while (rs.next()) {
                Chucvu cvv = new Chucvu(rs.getString(7), rs.getString(8));
                String id = rs.getString(1);
                String ten = rs.getString(2);
                String ngaysinh = rs.getString(3);
                Integer gioitinh = rs.getInt(4);
                String sdt = rs.getString(5);
                Integer tt = rs.getInt(6);

                lst.add(new Users(id, ten, ngaysinh, gioitinh, sdt, tt, cvv));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersReposytory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    public static void main(String[] args) {
//        Users us = new Users("tên", "2003-08-08", 0, "0123111", new Chucvu("1"), 0);
//        boolean flag = new UsersReposytory().delete("5");
//        System.out.println(flag);
//        Lisst
            List<Users> lisstt = new UsersReposytory().SearchNVV("t");
            System.out.println(lisstt);
    }
}
