
package repositorys.IRepo_DT;

import java.util.ArrayList;
import models.model_DT.ChiTietDongHo;
import models.model_DT.TrangThaiDongHo;
import viewmodel.ViewModel_DT.DongHoChiTietViewModel;


public interface ITrangThaiDongHoRepository {
    Boolean create(TrangThaiDongHo trangThai);

    boolean update(TrangThaiDongHo trangThai);
    
    boolean delete(int idTrangThai);
    
    String getTenTrangThaiByID(int idTrangThai);
    
    Integer getIDByTrangThai(String tenTrangThai);

    ArrayList<TrangThaiDongHo> selectAll();
    
    
}
