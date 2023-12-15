package services.ISV_H;

import java.util.ArrayList;
import models.model_H.ChiTietDongHo;
import models.model_H.DongHo;
import viewmodel.ViewModel_H.DongHoChiTietViewModel;
import viewmodel.ViewModel_H.SanPhamTronHoaDonModel;

public interface IDongHoChiTietService {

    void capNhatTrangThaiDongHo(int soLuong);
    void themMoiDongHoCT(ChiTietDongHo chiTietDongHo);

    void suaThongTinDongHoCT(ChiTietDongHo chiTietDongHo);
    void capNhatSoLuongDHCT(int soLuong, int idChiTietDH);

    void xoaDongHoCT(int idDHCT);


    ArrayList<ChiTietDongHo> layTatCaThongTinChiTietDongHo();
    ArrayList<DongHoChiTietViewModel> layThongTinChiTietDongHoNhuTable();

    ArrayList<DongHoChiTietViewModel> locTheoKhoangGia(String loaiLoc, Double giaLoc);

    ArrayList<DongHoChiTietViewModel> locTheoTenDongHo(String tenDH);

    ArrayList<DongHoChiTietViewModel> locTheoMauSac(String mauSac);
    ArrayList<SanPhamTronHoaDonModel> layThongTinDongHoHienThi_hoaDon();
}
