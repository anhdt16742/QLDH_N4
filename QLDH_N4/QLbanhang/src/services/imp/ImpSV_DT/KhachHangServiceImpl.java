/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.imp.ImpSV_DT;

import java.util.ArrayList;
import java.util.List;
import models.model_DT.KhachHang;
import repositorys.imp.Imp_DT.KhachHangRepository;
import services.ISV_DT.KhachHangService;

/**
 *
 * @author Admin
 */
public class KhachHangServiceImpl implements KhachHangService {

    private KhachHangRepository khRe = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        List<KhachHang> list = new ArrayList<>();

        list = khRe.getall();

        return list;

    }

    @Override
    public String add(KhachHang khachHang) {
        boolean addkhachhang = khRe.add(khachHang);
        if (addkhachhang) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(int id, KhachHang khachHang) {
        boolean updatehoadon = khRe.update(id, khachHang);
        if (updatehoadon) {
            return "Sửa thành công  ";
        }
        return "Sửa thất bại";

    }

    @Override
    public String delete(int id) {
        boolean deleteCuaHang = khRe.delete(id);
        if (deleteCuaHang) {
            return "Xóa thành công id = " + id;
        }
        return "Xóa thất bại";
    }

}
