package repositorys.IRepo_DT;

import java.util.ArrayList;
import models.ChiTietDongHo;
import models.DongHo;
import viewmodel.ViewModel_DT.DongHoChiTietViewModel;
import viewmodel.ViewModel_DT.SanPhamTronHoaDonModel;

public interface IChiTietDongHoRepository {

    Boolean create( ChiTietDongHo chiTietDongHo);

    boolean update( ChiTietDongHo chiTietDongHo);
    boolean updateSoLuong(int soLuong);
    
    boolean delete(int maDongHo);

//    int getIDChiTietDongHo();
    
//    int getSoLuongDongHoCT(int idCTDH);
    
    ArrayList<ChiTietDongHo> getAll();
    ArrayList<DongHoChiTietViewModel> getDataOfChiTietDongHo();
    ArrayList<DongHoChiTietViewModel> filterByKhoangGia(String loaiLoc, Double giaLoc);
    ArrayList<DongHoChiTietViewModel> filterByTenDongHo(String tenDH);
    ArrayList<DongHoChiTietViewModel> filterByMauSac(String mauSac);
    
    ArrayList<SanPhamTronHoaDonModel> getThongTinDongHo();
    
    
}
