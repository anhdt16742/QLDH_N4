
package services.imp;

import services.IChatLieuDayService;
import java.util.ArrayList;
import models.ChatLieuDay;
import repositorys.IChatLieuDayRepository_;
import repositorys.imp.ChatLieuDayRepository;


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
