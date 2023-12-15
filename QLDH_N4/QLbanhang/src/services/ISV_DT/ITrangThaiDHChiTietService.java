
package services.ISV_DT;

import java.util.ArrayList;
import models.model_DT.TrangThaiChiTietSanPham;
import models.model_DT.TrangThaiDongHo;

public interface ITrangThaiDHChiTietService {
    void themMoiTrangThai(TrangThaiChiTietSanPham trangThaiDongHoChiTietSanPham);
    void suaThongTinTrangThai(TrangThaiChiTietSanPham trangThaiDongHoChiTietSanPham);
    ArrayList<TrangThaiChiTietSanPham> layThongTinGT();
}
