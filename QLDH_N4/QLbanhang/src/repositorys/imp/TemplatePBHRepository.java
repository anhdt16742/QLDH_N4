/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorys.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.PhieuBaoHanh;
import models.TemplateBaoHanh;
import repositorys.ITemPlatePBHRepository;
import utilconnext.DBConnection;

/**
 *
 * @author Admin
 */
public class TemplatePBHRepository implements ITemPlatePBHRepository {

    @Override
    public List<TemplateBaoHanh> GetAll() {
        List<TemplateBaoHanh> listPBH = new ArrayList<>();
        listPBH.removeAll(listPBH);
        try {
            String sql = "SELECT [id_template_bao_hanh]\n"
                    + "      ,[tenSP]\n"
                    + "      ,[thoi_han_bao_hanh]\n"
                    + "  FROM [dbo].[TemplateBaoHanh]";
            Connection conn = DBConnection.openDbConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                listPBH.add(new TemplateBaoHanh(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPBH;
    }

    @Override
    public boolean Update(TemplateBaoHanh pbh, String id) {
        String sql = "UPDATE [dbo].[TemplateBaoHanh]\n"
                + "   SET [tenSP] = ?\n"
                + "      ,[thoi_han_bao_hanh] = ?\n"
                + " WHERE id_template_bao_hanh=?";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, pbh.getTenSP());
            pstm.setInt(2, pbh.getThoiHan());
            pstm.setString(3, id);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean Delete(String id) {
        String sql = "DELETE FROM [dbo].[TemplateBaoHanh]\n"
                + "      WHERE id_template_bao_hanh=?";
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

    @Override
    public List<TemplateBaoHanh> getbyid(int id) {
        List<TemplateBaoHanh> pbh = new ArrayList<>();
        try {

            String sql = "SELECT [id_template_bao_hanh]\n"
                    + "      ,[tenSP]\n"
                    + "      ,[thoi_han_bao_hanh]\n"
                    + "  FROM [dbo].[TemplateBaoHanh] where id_template_bao_hanh=?";
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pbh.add(new TemplateBaoHanh(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pbh;
    }

    @Override
    public boolean Add(TemplateBaoHanh pbh) {
        String sql = "INSERT INTO [dbo].[TemplateBaoHanh]\n"
                + "           ([tenSP]\n"
                + "           ,[thoi_han_bao_hanh])\n"
                + "     VALUES\n"
                + "           (?"
                + "           ,?)";
        try {
            Connection conn = DBConnection.openDbConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, pbh.getTenSP());
            pstm.setInt(2, pbh.getThoiHan());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        List<TemplateBaoHanh> listPBH = new ArrayList<>();

        listPBH = new TemplatePBHRepository().GetAll();
        System.out.println(listPBH);

    }

}
