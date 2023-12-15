/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorys.IRepo_DN;

import java.util.List;
import models.model_DN.ChiTietDongHo;

/**
 *
 * @author Admin
 */
public interface IChiTietDongHoRepository {
    List<ChiTietDongHo> getAll();
}
