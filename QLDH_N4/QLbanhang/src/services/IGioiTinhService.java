
package services;

import java.util.ArrayList;
import models.DongHo;
import models.GioiTinh;

public interface IGioiTinhService {
    void themMoiGioiTinhDongHo(GioiTinh gioiTinh);
    void suaThongTinDongHo(GioiTinh gioiTinh);
    void xoaDongHo(int idGioiTinh);
    ArrayList<GioiTinh> layThongTinGT();
}
