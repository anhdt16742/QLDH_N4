package services;

import java.util.ArrayList;
import models.ChiTietDongHo;
import models.DongHo;
import viewmodel.DongHoChiTietViewModel;
import viewmodel.SanPhamTronHoaDonModel;

public interface IDongHoChiTietService {

    void themMoiDongHoCT(ChiTietDongHo chiTietDongHo);

    void suaThongTinDongHoCT(ChiTietDongHo chiTietDongHo);
    void capNhatSoLuongDHCT(int soLuong);

    void xoaDongHoCT(int idDHCT);


    ArrayList<ChiTietDongHo> layTatCaThongTinChiTietDongHo();
    ArrayList<DongHoChiTietViewModel> layThongTinChiTietDongHoNhuTable();

    ArrayList<DongHoChiTietViewModel> locTheoKhoangGia(String loaiLoc, Double giaLoc);

    ArrayList<DongHoChiTietViewModel> locTheoTenDongHo(String tenDH);

    ArrayList<DongHoChiTietViewModel> locTheoMauSac(String mauSac);
    ArrayList<SanPhamTronHoaDonModel> layThongTinDongHoHienThi_hoaDon();
}
