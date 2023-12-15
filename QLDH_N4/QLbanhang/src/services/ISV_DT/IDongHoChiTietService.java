package services.ISV_DT;

import java.util.ArrayList;
import models.ChiTietDongHo;
import models.model_DT.DongHo;
import viewmodel.ViewModel_DT.DongHoChiTietViewModel;
import viewmodel.ViewModel_DT.SanPhamTronHoaDonModel;

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
