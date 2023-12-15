/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import java.util.List;
import models.PhieuBaoHanh;

/**
 *
 * @author Admin
 */
public interface IPhieuBaoHanhRepository {
    public List<PhieuBaoHanh> GetAll();
    
    public boolean Add(PhieuBaoHanh pbh);

    public boolean Update(PhieuBaoHanh pbh, String id);

    public boolean Delete(String id);

    public List<PhieuBaoHanh> getbyid(int id);
}
