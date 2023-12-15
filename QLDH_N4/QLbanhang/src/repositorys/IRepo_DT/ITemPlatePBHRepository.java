/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys.IRepo_DT;

import java.util.List;
import models.model_DT.TemplateBaoHanh;

/**
 *
 * @author Admin
 */
public interface ITemPlatePBHRepository {

    public List<TemplateBaoHanh> GetAll();

    public boolean Update(TemplateBaoHanh pbh, String id);
    
    public boolean Add(TemplateBaoHanh pbh);

    public boolean Delete(String id);

    public List<TemplateBaoHanh> getbyid(int id);
}
