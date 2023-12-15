
package services;

import java.util.ArrayList;
import models.DongHo;
import models.KieuMay;

public interface IKieuMayService {
    void themMoiDongHo(KieuMay kieuMay);
    void suaThongTinDongHo(KieuMay kieuMay);
    ArrayList<KieuMay> layThongTinDH();
}
