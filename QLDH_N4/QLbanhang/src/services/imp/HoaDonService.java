/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import java.util.List;
import models.HoaDon;
import repositorys.IHoaDonRepository;
import repositorys.imp.HoaDonRepository;
import services.IHoaDonService;

/**
 *
 * @author Admin
 */
public class HoaDonService implements IHoaDonService {

    @Override
    public List<HoaDon> GetAll() {
        return new HoaDonRepository().GetAll();
    }

    @Override
    public boolean Update(HoaDon hd, String id) {
       return new HoaDonRepository().Update(hd, id);
    }

}
