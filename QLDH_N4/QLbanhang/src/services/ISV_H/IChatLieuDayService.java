
package services.ISV_H;

import java.util.ArrayList;
import models.model_H.ChatLieuDay;

public interface IChatLieuDayService {
    void themMoiDongHo(ChatLieuDay chatLieuDay);
    void suaThongTinDongHo(ChatLieuDay chatLieuDay);
    ArrayList<ChatLieuDay> layThongTinCLD();
}
