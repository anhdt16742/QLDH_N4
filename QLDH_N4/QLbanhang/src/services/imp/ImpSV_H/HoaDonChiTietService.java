package services.imp.ImpSV_H;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.model_H.HoaDonChiTiet;
import repositorys.imp.Imp_H.HoaDonChiTietRepository;
import repositorys.IRepo_H.IHoaDonChiTietRepository;
import services.ISV_H.IHoaDonChiTietService;
import viewmodel.ViewModel_H.HoaDonChiTietViewModel;

public class HoaDonChiTietService implements IHoaDonChiTietService {

    IHoaDonChiTietRepository repo = new HoaDonChiTietRepository();

    @Override
    public ArrayList<HoaDonChiTiet> layTatCaThongTinHoaDonCT() {
        return repo.getAll();
    }

    @Override
    public ArrayList<HoaDonChiTietViewModel> layTatCaThongTinHoaDonCT_viewModel() {
        return repo.getHoaDonModel();
    }

    @Override
    public void taoMoiHoaDonChiTiet(HoaDonChiTiet hoaDon) {
        if (repo.create(hoaDon)) {
            System.out.println("Thanh toán thành công sản phẩm " + hoaDon.getIdChiTietDH());
            return;
        }
        JOptionPane.showMessageDialog(null, "Thanh toán thất bại !!!");
    }

    @Override
    public void suaHoaDonChiTiet(HoaDonChiTiet hoaDon) {
        if (repo.update(hoaDon)) {
            JOptionPane.showMessageDialog(null, "Sửa hóa đơn chi tiết thanh cong");
            return;
        }
        JOptionPane.showMessageDialog(null, "Sửa hóa đơn chi tiết that bai !!!");
    }

    @Override
    public void xoaHoaDonChiTiet(int idHDCT , int idCTSP) {
        if (repo.delete(idHDCT, idCTSP)) {
            System.out.println( "Xóa hóa đơn chi tiết cho sản phẩm " + idCTSP + " thanh cong");
            return;
        }
        System.out.println("Xóa hóa đơn chi tiết that bai !!!");
    }

}
