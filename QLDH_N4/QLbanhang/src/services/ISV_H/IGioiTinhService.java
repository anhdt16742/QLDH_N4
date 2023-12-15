
package services.ISV_H;

import java.util.ArrayList;
import models.model_H.DongHo;
import models.model_H.GioiTinh;

public interface IGioiTinhService {
    void themMoiGioiTinhDongHo(GioiTinh gioiTinh);
    void suaThongTinDongHo(GioiTinh gioiTinh);
    ArrayList<GioiTinh> layThongTinGT();
}
