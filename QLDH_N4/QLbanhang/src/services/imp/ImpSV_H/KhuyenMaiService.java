
package services.imp.ImpSV_H;

import services.ISV_H.IKhuyenMaiService;
import java.util.ArrayList;
import models.model_H.KhuyenMai;
import repositorys.IRepo_H.IKhuyenMaiRepository;
import repositorys.imp.Imp_H.KhuyenMaiRepository;

public class KhuyenMaiService implements IKhuyenMaiService {
    IKhuyenMaiRepository khuyenMaiRepo = new KhuyenMaiRepository();
    @Override
    public ArrayList<KhuyenMai> layThongTinKM() {
        return khuyenMaiRepo.selectAll();
    }
    
}
