
package services.ISV_DT;

import java.util.ArrayList;
import models.model_DT.MauQuaiDeo;

public interface IMauQuaiDeoService {
    void themMoiSPPhanBiet(MauQuaiDeo mauQuaiDeo);
    void suaThongTinSPPhanBiet(MauQuaiDeo mauQuaiDeo);
    void xoaSPPhanBiet(int idMauQuaiDeo);
    ArrayList<MauQuaiDeo> layThongTinSPPB();
}
