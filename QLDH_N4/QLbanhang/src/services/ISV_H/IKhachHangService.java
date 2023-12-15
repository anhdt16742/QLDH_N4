
package services.ISV_H;

import java.util.ArrayList;
import models.model_H.KhachHang;

public interface IKhachHangService {
    ArrayList<KhachHang> layTatCaThongTinKhachHang();
    ArrayList<KhachHang> timKiemKhachHangTheoSDT(String sdt);
    String timKiemKhachHangTheoSDTTraVeTenKH(String sdt);
}
