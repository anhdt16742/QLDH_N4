/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services.ISV_Huy;

import java.util.List;
import models.model_Huy.Users;

import viewmodel.ViewModel_Huy.UsersViewmodel;

/**
 *
 * @author hungh
 */
public interface IUsersService {

    public List<Users> getAllNhanVien();

    boolean add(Users nv);

    boolean update(Users us, String id);

    boolean delete(String id);

    List<Users> SearchNVV(String Ten);

}
