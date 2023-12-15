
package services.imp.ImpSV_DT;

import services.ISV_DT.IKieuMayService;
import java.util.ArrayList;
import models.model_DT.KieuMay;
import repositorys.IRepo_DT.IKieuMayRepository;
import repositorys.imp.Imp_DT.KieuMayRepository;



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
