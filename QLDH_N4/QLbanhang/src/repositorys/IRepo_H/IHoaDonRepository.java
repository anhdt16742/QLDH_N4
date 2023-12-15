
package repositorys.IRepo_H;

import java.util.ArrayList;
import models.model_H.HoaDon;
import viewmodel.ViewModel_H.HoaDonViewModel;
import viewmodel.ViewModel_H.HoaDonModelToInsert;

public interface IHoaDonRepository {
    ArrayList<HoaDon> getAll();
    ArrayList<HoaDonViewModel> getHoaDonModel();
    boolean create (HoaDon hoaDon);
    boolean update (HoaDon hoaDon);
    boolean delete (int idHD);
    boolean updateHoaDonAfterThanhToan(int idHD, Double tongTien, String ghiChu);
    boolean updateHoaDonCho(HoaDon hoaDon) ;
}
