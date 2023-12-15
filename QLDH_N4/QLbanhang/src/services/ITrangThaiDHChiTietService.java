
package services;

import java.util.ArrayList;
import models.TrangThaiChiTietSanPham;
import models.TrangThaiDongHo;

public interface ITrangThaiDHChiTietService {
    void themMoiTrangThai(TrangThaiChiTietSanPham trangThaiDongHoChiTietSanPham);
    void suaThongTinTrangThai(TrangThaiChiTietSanPham trangThaiDongHoChiTietSanPham);
    ArrayList<TrangThaiChiTietSanPham> layThongTinGT();
}
