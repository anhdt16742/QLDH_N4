/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import models.TemplateBaoHanh;

/**
 *
 * @author Admin
 */
public interface ITemplatePBHService {

    public List<TemplateBaoHanh> GetAll();

    public boolean Update(TemplateBaoHanh pbh, String id);

    public boolean Add(TemplateBaoHanh pbh);

    public boolean Delete(String id);

    public List<TemplateBaoHanh> GetById(int id);
}
