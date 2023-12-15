
package repositorys.IRepo_DT;

import java.util.ArrayList;
import models.model_DT.DongHo;
import models.model_DT.GioiTinh;

public interface IGioiTinhDongHoRepository {
   boolean create(GioiTinh gioiTinh);
   boolean update(GioiTinh gioiTinh);
   ArrayList<GioiTinh> selectAll();
}
