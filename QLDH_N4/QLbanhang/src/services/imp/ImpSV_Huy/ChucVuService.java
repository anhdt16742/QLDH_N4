/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp.ImpSV_Huy;

import java.util.ArrayList;
import java.util.List;
import models.model_Huy.Chucvu;
import repositorys.IRepo_Huy.IChucvuRepo;
import repositorys.imp.Imp_Huy.Chucvurepo;
import services.ISV_Huy.IChucvuService;

/**
 *
 * @author hungh
 */
public class ChucVuService implements IChucvuService {

    IChucvuRepo chucvuRepo;
    List<Chucvu> lstcv;

    public ChucVuService() {
        lstcv = new ArrayList<>();
        chucvuRepo = new Chucvurepo();
    }

    @Override
    public List<Chucvu> getAllChucVu() {
        lstcv = new ArrayList<>();
        for (Chucvu cv : chucvuRepo.getAllChucVu()) {
            lstcv.add(new Chucvu(cv.getId(), cv.getTen()));
        }
        return lstcv;
    }

}
