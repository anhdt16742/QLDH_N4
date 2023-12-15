
package repositorys.IRepo_H;

import java.util.ArrayList;
import models.model_H.HoaDonChiTiet;
import viewmodel.ViewModel_H.HoaDonChiTietViewModel;


public interface IHoaDonChiTietRepository {
    ArrayList<HoaDonChiTiet> getAll();
    ArrayList<HoaDonChiTietViewModel> getHoaDonModel();
    boolean create (HoaDonChiTiet hoaDon);
    boolean update (HoaDonChiTiet hoaDon);
    boolean delete (int idHDCT, int idCTSP);
}
