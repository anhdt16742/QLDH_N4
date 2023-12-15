
package services.imp.ImpSV_H;

import java.util.ArrayList;
import models.model_H.KhachHang;
import repositorys.imp.Imp_H.KhachHangRepository;
import repositorys.IRepo_H.IKhachHangRepository;
import services.ISV_H.IKhachHangService;

public class KhachHangService  implements IKhachHangService{
    IKhachHangRepository repo = new KhachHangRepository();
    @Override
    public ArrayList<KhachHang> layTatCaThongTinKhachHang() {
        return repo.selectAll();
    }

    @Override
    public ArrayList<KhachHang> timKiemKhachHangTheoSDT(String sdt) {
        return repo.searchBySDTKH(sdt);
    }

    @Override
    public String timKiemKhachHangTheoSDTTraVeTenKH(String sdt) {
        return repo.findBySDT_returnNameKH(sdt);
    }
    
}
