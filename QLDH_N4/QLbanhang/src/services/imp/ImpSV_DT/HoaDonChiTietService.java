/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp.ImpSV_DT;

import java.util.List;
import models.model_DT.HoaDonChiTiet;
import repositorys.IRepo_DT.IHoaDonChiTietRepository;
import repositorys.imp.Imp_DT.HoaDonChiTietRepository;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietService implements IHoaDonChiTietRepository {

    @Override
    public List<HoaDonChiTiet> GetAll() {
        return new HoaDonChiTietRepository().GetAll();
    }

    @Override
    public boolean Update(HoaDonChiTiet hdct, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonChiTiet> GetByIdHD(String id) {
        return new HoaDonChiTietRepository().GetByIdHD(id);
    }

}
