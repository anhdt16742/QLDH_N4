package repositorys.IRepo_H;

import java.util.ArrayList;
import models.model_H.GioiTinh;
import models.model_H.TrangThaiChiTietSanPham;

public interface ITrangThaiDongHoChiTietRepository {

    boolean create(TrangThaiChiTietSanPham trangThai);

    boolean update(TrangThaiChiTietSanPham trangThai);

    ArrayList<TrangThaiChiTietSanPham> selectAll();
}
