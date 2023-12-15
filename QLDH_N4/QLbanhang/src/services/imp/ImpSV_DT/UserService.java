/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp.ImpSV_DT;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.model_DT.User;
import repositorys.imp.Imp_DT.UserReponsitory;
import services.ISV_DT.IUserService;

/**
 *
 * @author Admin
 */
public class UserService implements IUserService {

    @Override
    public boolean Update(User us, String taiKhoan) {
        return new UserReponsitory().Update(us, taiKhoan);
    }

    @Override
    public boolean Add(User us) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> getUser(String taiKhoan, String matKhau) {
        return new UserReponsitory().GetOne(taiKhoan, matKhau);
    }
}
