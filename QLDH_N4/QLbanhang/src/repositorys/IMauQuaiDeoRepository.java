package repositorys;

import java.util.ArrayList;
import models.DongHo;
import models.MauQuaiDeo;

public interface IMauQuaiDeoRepository {

    Boolean create(MauQuaiDeo mauQuaiDeo);

    boolean update(MauQuaiDeo mauQuaiDeo);

    boolean delete(int idMauQuaiDeo);

    ArrayList<MauQuaiDeo> selectAll();
    
    
}
