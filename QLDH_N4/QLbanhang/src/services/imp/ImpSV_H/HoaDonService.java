package services.imp.ImpSV_H;

import services.ISV_H.IHoaDonService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.model_H.HoaDon;
import repositorys.imp.Imp_H.HoaDonRepository;
import repositorys.IRepo_H.IHoaDonRepository;
import viewmodel.ViewModel_H.HoaDonViewModel;

public class HoaDonService implements IHoaDonService {

    IHoaDonRepository repo = new HoaDonRepository();

    @Override
    public ArrayList<HoaDon> layThongTinCuaHoaDon() {
        return repo.getAll();
    }

    @Override
    public ArrayList<HoaDonViewModel> layThongTinHoaDonModel() {
        return repo.getHoaDonModel();
    }

    @Override
    public void taoHoaDon(HoaDon hoaDon) {
        if (repo.create(hoaDon)) {
            JOptionPane.showMessageDialog(null, "Them moi hóa đơn thanh cong");
            return;
        }
        JOptionPane.showMessageDialog(null, "Them moi hóa đơn that bai !!!");
    }

    @Override
    public void suaHoaDon(HoaDon hoaDon) {
        if (repo.update(hoaDon)) {
            JOptionPane.showMessageDialog(null, "Sửa hóa đơn thành công");
            return;
        }
        JOptionPane.showMessageDialog(null, "Sửa hóa đơn thất bại !!!");
    }

    @Override
    public void xoaHoaDon(int idHD) {
        if (repo.delete(idHD)) {
            JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công");
            return;
        }
        JOptionPane.showMessageDialog(null, "Xóa hóa đơn thất bại !!!");
    }

    @Override
    public void capNhatHoaDonSauKhiThanhToan(int idHD, Double tongTien, String ghiChu) {

        if (repo.updateHoaDonAfterThanhToan(idHD, tongTien, ghiChu)) {
            System.out.println("Cập nhật hóa đơn sau khi thanh toán thành công");
            return;
        }
        System.out.println("Cập nhật hóa đơn sau khi thanh toán thất bại !!!");
    }

    @Override
    public void capNhatThongTinHoaDonCho(HoaDon hoaDon) {
        if (repo.updateHoaDonCho(hoaDon)) {
            JOptionPane.showMessageDialog(null, "Cập nhật thông tin hóa đơn chờ thanh toán thành công");
            return;
        }

        JOptionPane.showMessageDialog(null, "Cập nhật thông tin hóa đơn chờ thanh toán thất bại");
    }

}
