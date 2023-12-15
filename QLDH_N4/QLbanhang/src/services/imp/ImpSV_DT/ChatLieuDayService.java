
package services.imp.ImpSV_DT;

import services.ISV_DT.IChatLieuDayService;
import java.util.ArrayList;
import models.model_DT.ChatLieuDay;
import repositorys.IRepo_DT.IChatLieuDayRepository_;
import repositorys.imp.Imp_DT.ChatLieuDayRepository;


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
