package repositorys.IRepo_H;

import java.util.ArrayList;
import models.model_H.ChiTietDongHo;
import models.model_H.DongHo;
import viewmodel.ViewModel_H.DongHoChiTietViewModel;
import viewmodel.ViewModel_H.SanPhamTronHoaDonModel;

public interface IChiTietDongHoRepository {

    Boolean create( ChiTietDongHo chiTietDongHo);

    boolean update( ChiTietDongHo chiTietDongHo);
    boolean updateSoLuong(int soLuong, int idChiTietDH);
    boolean updateTrangThaiDH(int soLuong);
    
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
