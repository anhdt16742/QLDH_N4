/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp.Imp_DT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.model_DT.User;
import repositorys.IRepo_DT.IUserReponsitory;
import utilconnext.DBConnection;

/**
 *
 * @author Admin
 */
public class UserReponsitory implements IUserReponsitory {

    @Override
    public boolean Update(User us, String taiKhoan) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET [taiKhoan] = ?\n"
                + "      ,[matKhau] = ?\n"
                + "      ,[chucVu] = ?\n"
                + "      ,[trangThai] = ?\n"
                + "      ,[tenUser] = ?\n"
                + "      ,[gioiTinh] = ?\n"
                + "      ,[ngaySinh] = ?\n"
                + " WHERE taiKhoan=?";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, us.getTaiKhoan());
            pstm.setString(2, us.getMatKhau());
            pstm.setInt(3, us.getChucVu());
            pstm.setInt(4, us.getTrangThai());
            pstm.setString(5, us.getTenUSer());
            pstm.setInt(6, us.getGioiTinh());
            pstm.setString(7, us.getDate());
            pstm.setString(8, taiKhoan);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean Add(User us) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    public static void main(String[] args) {
//        List<User> us = new ArrayList<>();
//        us = new UserReponsitory().GetAll();
//        System.out.println(us);
//    }
    @Override
    public List<User> GetOne(String taiKhoan, String matKhau) {
        List<User> us = new ArrayList<>();
        try {

            String sql = "SELECT [Id]\n"
                    + "      ,[taiKhoan]\n"
                    + "      ,[matKhau]\n"
                    + "      ,[chucVu]\n"
                    + "      ,[trangThai]\n"
                    + "      ,[tenUser]\n"
                    + "      ,[gioiTinh]\n"
                    + "      ,[ngaySinh]\n"
                    + "  FROM [dbo].[User] where taiKhoan=?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, taiKhoan);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                us.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }

//    public static void main(String[] args) {
//        List<User> list = new ArrayList<>();
//        list = new UserReponsitory().GetOne("duy123");
//        System.out.println(list);
//    }
}
