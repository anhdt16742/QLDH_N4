/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp.ImpSV_DT;

import java.util.List;
import models.model_DT.LichSuMua;
import repositorys.imp.Imp_DT.LichSuMuaRepository;
import services.ISV_DT.ILichSuMuaSV;

/**
 *
 * @author Admin
 */
public class LichSuMuaSV implements ILichSuMuaSV {

    @Override
    public List<LichSuMua> getAll(String idKH) {
        return new LichSuMuaRepository().getAll(idKH);
    }

}
