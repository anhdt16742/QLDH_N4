
package services.imp.ImpSV_DT;

import java.util.ArrayList;
import models.model_DT.GioiTinh;
import models.model_DT.TrangThaiChiTietSanPham;
import models.model_DT.TrangThaiDongHo;
import repositorys.imp.Imp_DT.TrangThaiDongHoChiTietRepository;
import services.ISV_DT.ITrangThaiDHChiTietService;


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
