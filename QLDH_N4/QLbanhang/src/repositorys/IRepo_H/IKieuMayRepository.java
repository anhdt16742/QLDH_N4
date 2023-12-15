
package repositorys.IRepo_H;

import java.util.ArrayList;
import models.model_H.KieuMay;

public interface IKieuMayRepository {
    boolean create(KieuMay kieuMay);
    boolean update(KieuMay kieuMay);
    ArrayList<KieuMay> selectAll();
}
