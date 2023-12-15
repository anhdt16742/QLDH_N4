package repositorys;

import java.util.ArrayList;
import models.ChatLieuDay;

public interface IChatLieuDayRepository_ {

    boolean create(ChatLieuDay chatLieu);

    boolean update(ChatLieuDay chatLieu);

    ArrayList<ChatLieuDay> selectAll();

}
