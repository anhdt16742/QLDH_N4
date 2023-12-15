package services.imp.ImpSV_H;

import services.ISV_H.IDongHoChiTietService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.model_H.ChiTietDongHo;
import repositorys.imp.Imp_H.ChiTietDongHoRepository;
import repositorys.IRepo_H.IChiTietDongHoRepository;
import viewmodel.ViewModel_H.DongHoChiTietViewModel;
import viewmodel.ViewModel_H.SanPhamTronHoaDonModel;

public class ChiTietDongHoService implements IDongHoChiTietService {

    IChiTietDongHoRepository ctRepo = new ChiTietDongHoRepository();

    @Override
    public void themMoiDongHoCT(ChiTietDongHo chiTietDongHo) {
        if (ctRepo.create(chiTietDongHo)) {
            JOptionPane.showMessageDialog(null, "Them moi chi tiet dong ho thanh cong");
            return;
        }
        JOptionPane.showMessageDialog(null, "Them moi chi tiet dong ho that bai !!!");
    }

    @Override
    public void suaThongTinDongHoCT(ChiTietDongHo chiTietDongHo) {
        if (ctRepo.update(chiTietDongHo)) {
            JOptionPane.showMessageDialog(null, "Cap nhat thong tin chi tiet dong ho thanh cong");
            return;
        }
        JOptionPane.showMessageDialog(null, "Cap nhat thong tin chi tiet dong ho that bai !!!");
    }

    @Override
    public void xoaDongHoCT(int idDHCT) {
        if (ctRepo.delete(idDHCT)) {
            JOptionPane.showMessageDialog(null, "Xoa chi tiet dong ho thanh cong");
            return;
        }
        JOptionPane.showMessageDialog(null, "Để xóa được đồng hồ này, bạn cần xóa hóa đơn chứa đồng hồ");
        return;
    }



    @Override
    public ArrayList<DongHoChiTietViewModel> locTheoKhoangGia(String loaiLoc, Double giaLoc) {
        return ctRepo.filterByKhoangGia(loaiLoc, giaLoc);
    }


    @Override
    public ArrayList<DongHoChiTietViewModel> locTheoTenDongHo(String tenDH) {
        return ctRepo.filterByTenDongHo(tenDH);
    }

    @Override
    public ArrayList<DongHoChiTietViewModel> locTheoMauSac(String mauSac) {
        return ctRepo.filterByMauSac(mauSac);
    }

    @Override
    public ArrayList<SanPhamTronHoaDonModel> layThongTinDongHoHienThi_hoaDon() {
        return ctRepo.getThongTinDongHo();
    }

    @Override
    public ArrayList<ChiTietDongHo> layTatCaThongTinChiTietDongHo() {
        return ctRepo.getAll();
    }

    @Override
    public ArrayList<DongHoChiTietViewModel> layThongTinChiTietDongHoNhuTable() {
        return ctRepo.getDataOfChiTietDongHo();
    }


    @Override
    public void capNhatSoLuongDHCT(int soLuong, int idChiTietDH) {
        
        if (ctRepo.updateSoLuong(soLuong, idChiTietDH)) {
            System.out.println("Cập nhật số lượng sp of DHCT thanh cong");
            return;
        }
        System.out.println( "Cập nhật số lượng sp of DHCT that bai !!!");
    }

    @Override
    public void capNhatTrangThaiDongHo(int soLuong) {
        if(ctRepo.updateTrangThaiDH(soLuong)){
            System.out.println("Cập nhật trạng thái đồng hồ thành công --- **");
            return;
        }
        System.out.println("Cập nhật trạng thái đồng hồ thất bại");
        
    }

}
