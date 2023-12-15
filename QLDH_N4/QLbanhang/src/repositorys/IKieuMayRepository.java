
package repositorys;

import java.util.ArrayList;
import models.KieuMay;

public interface IKieuMayRepository {
    boolean create(KieuMay kieuMay);
    boolean update(KieuMay kieuMay);
    ArrayList<KieuMay> selectAll();
}
