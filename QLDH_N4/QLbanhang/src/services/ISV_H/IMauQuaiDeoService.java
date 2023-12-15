
package services.ISV_H;

import java.util.ArrayList;
import models.model_H.MauQuaiDeo;

public interface IMauQuaiDeoService {
    void themMoiMauQuaiDeo(MauQuaiDeo mauQuaiDeo);
    void suaMauQuaiDeo(MauQuaiDeo mauQuaiDeo);
    ArrayList<MauQuaiDeo> layThongTinMauQuaiDeo();
}
