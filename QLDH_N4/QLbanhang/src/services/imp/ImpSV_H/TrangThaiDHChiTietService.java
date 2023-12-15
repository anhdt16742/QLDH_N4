
package services.imp.ImpSV_H;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.model_H.GioiTinh;
import models.model_H.TrangThaiChiTietSanPham;
import models.model_H.TrangThaiDongHo;
import static repositorys.imp.Imp_H.DongHoRepository.conn;
import repositorys.imp.Imp_H.TrangThaiDongHoChiTietRepository;
import repositorys.IRepo_H.ITrangThaiDongHoChiTietRepository;
import services.ISV_H.ITrangThaiDHChiTietService;
import utilconnext.DBConnection;

public class TrangThaiDHChiTietService implements ITrangThaiDHChiTietService{
    ITrangThaiDongHoChiTietRepository trangThaiRepo = new TrangThaiDongHoChiTietRepository();

    @Override
    public ArrayList<TrangThaiChiTietSanPham> layThongTinGT() {
        return trangThaiRepo.selectAll();
    }

    @Override
    public void themMoiTrangThai(TrangThaiChiTietSanPham trangThaiDongHoChiTietSanPham) {
         if(trangThaiRepo.create(trangThaiDongHoChiTietSanPham)){
            JOptionPane.showMessageDialog(null, "Thêm mới trạng thái đồng hồ chi tiết thành công");
            return;
        }
        JOptionPane.showMessageDialog(null, "Thêm mới trạng thái đồng hồ chi tiết thất bại !!!");
    }

    @Override
    public void suaThongTinTrangThai(TrangThaiChiTietSanPham trangThaiDongHoChiTietSanPham) {
        if(trangThaiRepo.update(trangThaiDongHoChiTietSanPham)){
            JOptionPane.showMessageDialog(null, "Sửa trạng thái đồng hồ chi tiết thành công");
            return;
        }
        JOptionPane.showMessageDialog(null, "Sửa trạng thái đồng hồ chi tiết thất bại !!!");
    }
    
}
