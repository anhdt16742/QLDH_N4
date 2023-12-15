
package services.imp;

import services.IDongHoService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.DongHo;
import repositorys.IDongHoRepository;
import repositorys.imp.DongHoRepository;


public class DongHoService implements IDongHoService{
    IDongHoRepository dongHoRepo = new DongHoRepository();
    @Override
    public void themMoiDongHo(DongHo dongHo) {
        if(dongHoRepo.create(dongHo)){
            JOptionPane.showMessageDialog(null, "Them moi dong ho thanh cong");
            return;
        }
        JOptionPane.showMessageDialog(null, "Them moi dong ho that bai !!!");
    }

    @Override
    public void suaThongTinDongHo(DongHo dongHo) {
        if(dongHoRepo.update(dongHo)){
            JOptionPane.showMessageDialog(null, "Cap nhat thong tin dong ho thanh cong");
            return;
        }
        JOptionPane.showMessageDialog(null, "Cap nhat thong tin dong ho that bai !!!");
    }

    @Override
    public void xoaDongHo(int idDH) {
        if(dongHoRepo.delete(idDH)){
            JOptionPane.showMessageDialog(null, "Xoa dong ho thanh cong");
            return;
        }
        JOptionPane.showMessageDialog(null, "Xoa dong ho that bai !!!");
    }

    @Override
    public ArrayList<DongHo> layThongTinDH() {
        return dongHoRepo.selectAll();
    }

    @Override
    public ArrayList<DongHo> locBangChonTrangThai(int trangThai) {
        return dongHoRepo.filterByTrangThai(trangThai);
    }

    @Override
    public ArrayList<DongHo> LocBangNhapTenDH_chatLieu_tinhNang(String tenLoc) {
        return dongHoRepo.filterByTenDH_chatLieu_tinhNang(tenLoc);
    }

    @Override
    public int layIDDongHoBangTenDH(String tenDH) {
        return dongHoRepo.getIDDongHoByTenDongHo(tenDH);
    }
    
}
