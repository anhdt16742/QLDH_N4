/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys;

import java.util.List;
import models.LichSuMua;

/**
 *
 * @author Admin
 */
public interface ILichSuMuaRepository {
    List<LichSuMua> getAll(String idKH);
}
