
package services.ISV_H;

import java.util.ArrayList;
import models.model_H.HoaDon;
import viewmodel.ViewModel_H.HoaDonViewModel;

public interface IHoaDonService {
    ArrayList<HoaDon> layThongTinCuaHoaDon();
    ArrayList<HoaDonViewModel> layThongTinHoaDonModel();
    
    void taoHoaDon (HoaDon hoaDon);
    void suaHoaDon (HoaDon hoaDon);
    void xoaHoaDon (int idHD);
    void capNhatHoaDonSauKhiThanhToan(int idHD, Double tongTien, String ghiChu);
    void capNhatThongTinHoaDonCho(HoaDon hoaDon) ;
}
