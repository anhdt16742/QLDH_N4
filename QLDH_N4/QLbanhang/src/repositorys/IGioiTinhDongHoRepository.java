
package repositorys;

import java.util.ArrayList;
import models.DongHo;
import models.GioiTinh;

public interface IGioiTinhDongHoRepository {
   boolean create(GioiTinh gioiTinh);
   boolean update(GioiTinh gioiTinh);
   ArrayList<GioiTinh> selectAll();
}
