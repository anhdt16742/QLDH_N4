package services.imp;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.ChiTietDongHo;
import repositorys.IChiTietDongHoRepository;
import repositorys.imp.ChiTietDongHoRepository;
import services.IDongHoChiTietService;
import viewmodel.DongHoChiTietViewModel;
import viewmodel.SanPhamTronHoaDonModel;

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
        JOptionPane.showMessageDialog(null, "Xoa chi tiet dong ho that bai !!!");
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
    public void capNhatSoLuongDHCT(int soLuong) {
        if (ctRepo.updateSoLuong(soLuong)) {
            System.out.println("Cập nhật số lượng sp of DHCT thanh cong");
            return;
        }
        System.out.println( "Cập nhật số lượng sp of DHCT that bai !!!");
    }

}
