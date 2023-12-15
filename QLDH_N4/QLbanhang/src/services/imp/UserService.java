
package services.imp;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.User;
import repositorys.imp.UserReponsitory;
import services.IUserService;

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
