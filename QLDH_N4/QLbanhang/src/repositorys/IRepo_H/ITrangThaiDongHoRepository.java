
package repositorys.IRepo_H;

import java.util.ArrayList;
import models.model_H.ChiTietDongHo;
import models.model_H.TrangThaiDongHo;
import viewmodel.ViewModel_H.DongHoChiTietViewModel;


public interface ITrangThaiDongHoRepository {
    Boolean create(TrangThaiDongHo trangThai);

    boolean update(TrangThaiDongHo trangThai);
    
    
    String getTenTrangThaiByID(int idTrangThai);
    
    Integer getIDByTrangThai(String tenTrangThai);

    ArrayList<TrangThaiDongHo> selectAll();
    
    
}
