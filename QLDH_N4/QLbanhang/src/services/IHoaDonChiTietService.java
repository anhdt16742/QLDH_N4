/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.HoaDonChiTiet;

/**
 *
 * @author Admin
 */
public interface IHoaDonChiTietService {

    public List<HoaDonChiTiet> GetAll();

    public boolean Update(HoaDonChiTiet hdct, String id);
    
    public List<HoaDonChiTiet> GetByIdHD(String id);
    
}
