/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.PhieuGiaoBH;

/**
 *
 * @author Admin
 */
public interface IPhieuGiaoBHService {

    public List<PhieuGiaoBH> GetAll();

    public boolean Update(PhieuGiaoBH pgbh, String id);

    public boolean Add(PhieuGiaoBH pgbh);

    public boolean Delete(String id);

    public List<PhieuGiaoBH> GetById(int id);
}
