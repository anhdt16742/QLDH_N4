/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp.ImpSV_DT;

import java.util.List;
import models.model_DT.HoaDon;
import repositorys.IRepo_DT.IHoaDonRepository;
import repositorys.imp.Imp_DT.HoaDonRepository;
import services.ISV_DT.IHoaDonService;

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
