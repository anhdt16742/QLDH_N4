package repositorys.IRepo_DT;

import java.util.ArrayList;
import models.model_DT.ChatLieuDay;

public interface IChatLieuDayRepository_ {

    boolean create(ChatLieuDay chatLieu);

    boolean update(ChatLieuDay chatLieu);

    ArrayList<ChatLieuDay> selectAll();

}
