
package services.imp.ImpSV_DT;

import services.ISV_DT.IGioiTinhService;
import java.util.ArrayList;
import models.model_DT.GioiTinh;
import repositorys.IRepo_DT.IGioiTinhDongHoRepository;
import repositorys.imp.Imp_DT.GioiTinhDongHoRepository;


public class GioiTinhService implements IGioiTinhService {
    IGioiTinhDongHoRepository gioiTinhRepo = new GioiTinhDongHoRepository();
    @Override
    public void themMoiGioiTinhDongHo(GioiTinh gioiTinh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void suaThongTinDongHo(GioiTinh gioiTinh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void xoaDongHo(int idGioiTinh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<GioiTinh> layThongTinGT() {
        return gioiTinhRepo.selectAll();
    }
    
}
