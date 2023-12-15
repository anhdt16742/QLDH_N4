package repositorys.IRepo_H;

import java.util.ArrayList;
import models.model_H.DongHo;
import models.model_H.MauQuaiDeo;

public interface IMauQuaiDeoRepository {

    Boolean create(MauQuaiDeo mauQuaiDeo);

    boolean update(MauQuaiDeo mauQuaiDeo);


    ArrayList<MauQuaiDeo> selectAll();
    
    
}
