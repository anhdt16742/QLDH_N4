/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp.ImpSV_DT;

import java.util.ArrayList;
import java.util.List;
import models.model_DT.PhieuBaoHanh;
import repositorys.IRepo_DT.IPhieuBaoHanhRepository;
import repositorys.imp.Imp_DT.PhieuBaoHanhRepository;
import services.ISV_DT.IPhieuBaoHanhService;

/**
 *
 * @author Admin
 */
public class PhieuBaoHanhService implements IPhieuBaoHanhService {

    private IPhieuBaoHanhRepository repository;
    private List<PhieuBaoHanh> listPBH = new ArrayList<>();

    public PhieuBaoHanhService() {
        repository = new PhieuBaoHanhRepository();
    }

    @Override
    public List<PhieuBaoHanh> GetAll() {
        return new PhieuBaoHanhRepository().GetAll();
    }

    @Override
    public boolean Update(PhieuBaoHanh pbh, String id) {
        boolean isUpdate = new PhieuBaoHanhRepository().Update(pbh, id);
        return isUpdate;
    }

    @Override
    public boolean Delete(String id) {
        boolean isDelete = new PhieuBaoHanhRepository().Delete(id);
        return isDelete;
    }

    @Override
    public List<PhieuBaoHanh> GetById(int id) {
        return new PhieuBaoHanhRepository().getbyid(id);
    }

}
