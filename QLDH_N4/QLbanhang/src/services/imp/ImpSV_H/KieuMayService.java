
package services.imp.ImpSV_H;

import services.ISV_H.IKieuMayService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.model_H.KieuMay;
import repositorys.IRepo_H.IKieuMayRepository;
import repositorys.imp.Imp_H.KieuMayRepository;


public class KieuMayService implements IKieuMayService{
    IKieuMayRepository kieuMayRepo = new KieuMayRepository();
    
    @Override
    public void themMoiKieuMay(KieuMay kieuMay) {
        if(kieuMayRepo.create(kieuMay)){
            JOptionPane.showMessageDialog(null, "Thêm mới kiểu máy đồng hồ thành công");
            return;
        }
        JOptionPane.showMessageDialog(null, "Thêm mới kiểu máy đồng hồ thất bại !!!");
    }

    @Override
    public void suaThongTinKieuMay(KieuMay kieuMay) {
        if(kieuMayRepo.update(kieuMay)){
            JOptionPane.showMessageDialog(null, "Sửa kiểu máy đồng hồ thành công");
            return;
        }
        JOptionPane.showMessageDialog(null, "Sửa kiểu máy đồng hồ thất bại !!!");
    }

    @Override
    public ArrayList<KieuMay> layThongTinKieuMay() {
        return kieuMayRepo.selectAll();
    }

    
}
