
package services.ISV_DT;

import java.util.ArrayList;
import models.model_DT.ChatLieuDay;

public interface IChatLieuDayService {
    void themMoiDongHo(ChatLieuDay chatLieuDay);
    void suaThongTinDongHo(ChatLieuDay chatLieuDay);
    ArrayList<ChatLieuDay> layThongTinCLD();
}
