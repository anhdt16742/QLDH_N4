
package services.ISV_H;

import java.util.ArrayList;
import models.model_H.HoaDonChiTiet;
import viewmodel.ViewModel_H.HoaDonChiTietViewModel;


public interface IHoaDonChiTietService {
    ArrayList<HoaDonChiTiet> layTatCaThongTinHoaDonCT();
    ArrayList<HoaDonChiTietViewModel> layTatCaThongTinHoaDonCT_viewModel();
    void taoMoiHoaDonChiTiet (HoaDonChiTiet hoaDon);
    void suaHoaDonChiTiet (HoaDonChiTiet hoaDon);
    void xoaHoaDonChiTiet (int idHDCT, int idCTSP);
}
