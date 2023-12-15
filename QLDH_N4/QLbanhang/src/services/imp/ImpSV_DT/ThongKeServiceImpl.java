/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp.ImpSV_DT;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.model_DT.ThongKe;
import repositorys.imp.Imp_DT.ThongKeRepository;
import services.ISV_DT.ThongKeService;
import viewmodel.ViewModel_DT.SanPhamTronHoaDonModel;

/**
 *
 * @author Admin
 */
public class ThongKeServiceImpl implements ThongKeService {

    private ThongKeRepository thongKe = new ThongKeRepository();

    @Override
    public List<ThongKe> getAll() {
        return thongKe.getAll();
    }

    @Override
    public List<ThongKe> sortNgayTao() {
        return thongKe.sortNgayTao();
    }

    @Override
    public List<ThongKe> searchThoiGian(Date tuNgay, Date denNgay) {
        return thongKe.searchThoiGian(tuNgay, denNgay);
    }

    @Override
    public ArrayList<SanPhamTronHoaDonModel> getThongTinDongHo() {
        return thongKe.getThongTinDongHo();
    }

    @Override
    public ArrayList<SanPhamTronHoaDonModel> getThongTinDongHoSapHet(int soLuong) {
     return thongKe.getThongTinDongHoSapHet(soLuong);
    }

}
