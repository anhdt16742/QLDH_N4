package repositorys.IRepo_DT;

import java.util.ArrayList;
import models.model_DT.GioiTinh;
import models.model_DT.TrangThaiChiTietSanPham;

public interface ITrangThaiDongHoChiTietRepository {

    boolean create(TrangThaiChiTietSanPham trangThai);

    boolean update(TrangThaiChiTietSanPham trangThai);

    ArrayList<TrangThaiChiTietSanPham> selectAll();
}
