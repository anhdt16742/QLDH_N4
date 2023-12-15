
package services;

import java.util.ArrayList;
import models.MauQuaiDeo;

public interface IMauQuaiDeoService {
    void themMoiSPPhanBiet(MauQuaiDeo mauQuaiDeo);
    void suaThongTinSPPhanBiet(MauQuaiDeo mauQuaiDeo);
    void xoaSPPhanBiet(int idMauQuaiDeo);
    ArrayList<MauQuaiDeo> layThongTinSPPB();
}
