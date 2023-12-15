/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp;

import java.util.List;
import models.TemplateBaoHanh;
import repositorys.ITemPlatePBHRepository;
import repositorys.imp.TemplatePBHRepository;
import services.ITemplatePBHService;

/**
 *
 * @author Admin
 */
public class TemplatePBHService implements ITemplatePBHService {

    @Override
    public List<TemplateBaoHanh> GetAll() {
        return new TemplatePBHRepository().GetAll();
    }

    @Override
    public boolean Update(TemplateBaoHanh pbh, String id) {
        boolean isUpdate = new TemplatePBHRepository().Update(pbh, id);
        return isUpdate;
    }

    @Override
    public boolean Delete(String id) {
        boolean isDelete = new TemplatePBHRepository().Delete(id);
        return isDelete;
    }

    @Override
    public List<TemplateBaoHanh> GetById(int id) {
        return new TemplatePBHRepository().getbyid(id);
    }

    @Override
    public boolean Add(TemplateBaoHanh pbh) {
        boolean isUpdate = new TemplatePBHRepository().Add(pbh);
        return isUpdate;
    }

}
