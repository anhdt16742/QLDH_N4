
package services.ISV_H;

import java.util.ArrayList;
import models.model_H.DongHo;
import models.model_H.KieuMay;

public interface IKieuMayService {
    void themMoiKieuMay(KieuMay kieuMay);
    void suaThongTinKieuMay(KieuMay kieuMay);
    ArrayList<KieuMay> layThongTinKieuMay();
}
