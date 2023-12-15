package repositorys.IRepo_H;

import java.util.ArrayList;
import models.model_H.ChatLieuDay;

public interface IChatLieuDayRepository_ {

    boolean create(ChatLieuDay chatLieu);

    boolean update(ChatLieuDay chatLieu);

    ArrayList<ChatLieuDay> selectAll();

}
