
package services.ISV_DT;

import java.util.ArrayList;
import models.model_DT.DongHo;
import models.model_DT.GioiTinh;

public interface IGioiTinhService {
    void themMoiGioiTinhDongHo(GioiTinh gioiTinh);
    void suaThongTinDongHo(GioiTinh gioiTinh);
    void xoaDongHo(int idGioiTinh);
    ArrayList<GioiTinh> layThongTinGT();
}
