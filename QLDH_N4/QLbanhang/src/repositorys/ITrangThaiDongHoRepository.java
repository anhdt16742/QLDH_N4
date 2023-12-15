
package repositorys;

import java.util.ArrayList;
import models.ChiTietDongHo;
import models.TrangThaiDongHo;
import viewmodel.DongHoChiTietViewModel;


public interface ITrangThaiDongHoRepository {
    Boolean create(TrangThaiDongHo trangThai);

    boolean update(TrangThaiDongHo trangThai);
    
    boolean delete(int idTrangThai);
    
    String getTenTrangThaiByID(int idTrangThai);
    
    Integer getIDByTrangThai(String tenTrangThai);

    ArrayList<TrangThaiDongHo> selectAll();
    
    
}
