package repositorys.IRepo_H;

import java.util.ArrayList;
import models.model_H.ChiTietDongHo;
import models.model_H.DongHo;

public interface IDongHoRepository {

    boolean create(DongHo dongHo);

    boolean update(DongHo dongHo);

    boolean delete(int idDongHo);

    ArrayList<DongHo> selectAll();

    ArrayList<DongHo> filterByTrangThai(int trangThai);

    ArrayList<DongHo> filterByTenDH_chatLieu_tinhNang(String tenLoc);
    
    int getIDDongHoByTenDongHo(String tenDH);
}
