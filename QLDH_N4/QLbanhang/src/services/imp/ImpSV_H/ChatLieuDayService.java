
package services.imp.ImpSV_H;

import services.ISV_H.IChatLieuDayService;
import java.util.ArrayList;
import models.model_H.ChatLieuDay;
import repositorys.imp.Imp_H.ChatLieuDayRepository;
import repositorys.IRepo_H.IChatLieuDayRepository_;

public class ChatLieuDayService implements IChatLieuDayService{
    IChatLieuDayRepository_ chatLieuDayRepo = new ChatLieuDayRepository();
    
    @Override
    public void themMoiDongHo(ChatLieuDay chatLieuDay) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void suaThongTinDongHo(ChatLieuDay chatLieuDay) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ChatLieuDay> layThongTinCLD() {
        return chatLieuDayRepo.selectAll();
    }
    
}
