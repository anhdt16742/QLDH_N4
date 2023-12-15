
package services.imp;

import services.IGioiTinhService;
import java.util.ArrayList;
import models.GioiTinh;
import repositorys.IGioiTinhDongHoRepository;
import repositorys.imp.GioiTinhDongHoRepository;


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
