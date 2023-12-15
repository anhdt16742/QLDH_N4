package repositorys;

import java.util.ArrayList;
import models.GioiTinh;
import models.TrangThaiChiTietSanPham;

public interface ITrangThaiDongHoChiTietRepository {

    boolean create(TrangThaiChiTietSanPham trangThai);

    boolean update(TrangThaiChiTietSanPham trangThai);

    ArrayList<TrangThaiChiTietSanPham> selectAll();
}
