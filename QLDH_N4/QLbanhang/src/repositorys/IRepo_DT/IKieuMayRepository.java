
package repositorys.IRepo_DT;

import java.util.ArrayList;
import models.model_DT.KieuMay;

public interface IKieuMayRepository {
    boolean create(KieuMay kieuMay);
    boolean update(KieuMay kieuMay);
    ArrayList<KieuMay> selectAll();
}
