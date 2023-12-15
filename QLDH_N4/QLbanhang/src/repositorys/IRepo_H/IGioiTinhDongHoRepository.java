
package repositorys.IRepo_H;

import java.util.ArrayList;
import models.model_H.DongHo;
import models.model_H.GioiTinh;

public interface IGioiTinhDongHoRepository {
   boolean create(GioiTinh gioiTinh);
   boolean update(GioiTinh gioiTinh);
   ArrayList<GioiTinh> selectAll();
}
