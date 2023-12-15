package repositorys.IRepo_DT;

import java.util.ArrayList;
import models.model_DT.DongHo;
import models.model_DT.MauQuaiDeo;

public interface IMauQuaiDeoRepository {

    Boolean create(MauQuaiDeo mauQuaiDeo);

    boolean update(MauQuaiDeo mauQuaiDeo);

    boolean delete(int idMauQuaiDeo);

    ArrayList<MauQuaiDeo> selectAll();
    
    
}
