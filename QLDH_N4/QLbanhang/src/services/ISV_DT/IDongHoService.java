
package services.ISV_DT;

import java.util.ArrayList;
import models.DongHo;

public interface IDongHoService {
    void themMoiDongHo(DongHo dongHo);
    void suaThongTinDongHo(DongHo dongHo);
    void xoaDongHo(int idDH);
    ArrayList<DongHo> layThongTinDH();
    
    ArrayList<DongHo> locBangChonTrangThai(int trangThai);

    ArrayList<DongHo> LocBangNhapTenDH_chatLieu_tinhNang(String tenLoc);
    
    int layIDDongHoBangTenDH(String tenDH);
}
