
package services.imp;

import java.util.ArrayList;
import models.GioiTinh;
import models.TrangThaiChiTietSanPham;
import models.TrangThaiDongHo;
import repositorys.imp.TrangThaiDongHoChiTietRepository;
import services.ITrangThaiDHChiTietService;


public class TrangThaiDHChiTietService implements ITrangThaiDHChiTietService{
    TrangThaiDongHoChiTietRepository trangThaiRepo = new TrangThaiDongHoChiTietRepository();

    @Override
    public ArrayList<TrangThaiChiTietSanPham> layThongTinGT() {
        return trangThaiRepo.selectAll();
    }

    @Override
    public void themMoiTrangThai(TrangThaiChiTietSanPham trangThaiDongHoChiTietSanPham) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void suaThongTinTrangThai(TrangThaiChiTietSanPham trangThaiDongHoChiTietSanPham) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
