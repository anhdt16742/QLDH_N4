
package services.ISV_H;

import java.util.ArrayList;
import models.model_H.TrangThaiChiTietSanPham;
import models.model_H.TrangThaiDongHo;

public interface ITrangThaiDHChiTietService {
    void themMoiTrangThai(TrangThaiChiTietSanPham trangThaiDongHoChiTietSanPham);
    void suaThongTinTrangThai(TrangThaiChiTietSanPham trangThaiDongHoChiTietSanPham);
    ArrayList<TrangThaiChiTietSanPham> layThongTinGT();
}
