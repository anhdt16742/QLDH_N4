
package services.imp.ImpSV_H;

import services.ISV_H.IGioiTinhService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.model_H.GioiTinh;
import repositorys.imp.Imp_H.GioiTinhDongHoRepository;
import repositorys.IRepo_H.IGioiTinhDongHoRepository;

public class GioiTinhService implements IGioiTinhService {
    IGioiTinhDongHoRepository gioiTinhRepo = new GioiTinhDongHoRepository();
    @Override
    public void themMoiGioiTinhDongHo(GioiTinh gioiTinh) {
        if(gioiTinhRepo.create(gioiTinh)){
            JOptionPane.showMessageDialog(null, "Thêm mới giới tính đồng hồ thành công");
            return;
        }
        JOptionPane.showMessageDialog(null, "Thêm mới giới tính đồng hồ thất bại !!!");
    }

    @Override
    public void suaThongTinDongHo(GioiTinh gioiTinh) {
        if(gioiTinhRepo.update(gioiTinh)){
            JOptionPane.showMessageDialog(null, "Sửa giới tính đồng hồ thành công");
            return;
        }
        JOptionPane.showMessageDialog(null, "Sửa giới tính đồng hồ thất bại !!!");
    }


    @Override
    public ArrayList<GioiTinh> layThongTinGT() {
        return gioiTinhRepo.selectAll();
    }
    
}
