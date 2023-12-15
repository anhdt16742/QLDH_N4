package repositorys;

import java.util.ArrayList;
import models.ChiTietDongHo;
import models.DongHo;

public interface IDongHoRepository {

    boolean create(DongHo dongHo);

    boolean update(DongHo dongHo);

    boolean delete(int idDongHo);

    ArrayList<DongHo> selectAll();

    ArrayList<DongHo> filterByTrangThai(int trangThai);

    ArrayList<DongHo> filterByTenDH_chatLieu_tinhNang(String tenLoc);
    
    int getIDDongHoByTenDongHo(String tenDH);
}
