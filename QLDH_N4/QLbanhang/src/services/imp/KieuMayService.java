
package services.imp;

import services.IKieuMayService;
import java.util.ArrayList;
import models.KieuMay;
import repositorys.IKieuMayRepository;
import repositorys.imp.KieuMayRepository;



public class KieuMayService implements IKieuMayService{
    IKieuMayRepository kieuMayRepo = new KieuMayRepository();
    
    @Override
    public void themMoiDongHo(KieuMay kieuMay) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void suaThongTinDongHo(KieuMay kieuMay) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<KieuMay> layThongTinDH() {
        return kieuMayRepo.selectAll();
    }
    
}
