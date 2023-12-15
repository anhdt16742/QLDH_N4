
package services.ISV_DT;

import java.util.ArrayList;
import models.model_DT.DongHo;
import models.model_DT.KieuMay;

public interface IKieuMayService {
    void themMoiDongHo(KieuMay kieuMay);
    void suaThongTinDongHo(KieuMay kieuMay);
    ArrayList<KieuMay> layThongTinDH();
}
