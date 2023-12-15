/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.Date;
import java.util.List;
import models.model_DT.ThongKe;

/**
 *
 * @author Admin
 */
public interface ThongKeService {
      List<ThongKe> getAll();

    List<ThongKe> sortNgayTao();

    List<ThongKe> searchThoiGian(Date tuNgay, Date denNgay);
    
}
