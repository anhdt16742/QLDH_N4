/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import java.util.List;
import models.HoaDon;

/**
 *
 * @author Admin
 */
public interface IHoaDonRepository {
    public List<HoaDon> GetAll();
    
    public boolean Update(HoaDon hd, String id);
    
    public List<HoaDon> GetOneByTenKH(String tenKH);
}
