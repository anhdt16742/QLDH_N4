
package services.imp.ImpSV_H;

import repositorys.imp.Imp_H.NhanVienRepository;
import repositorys.IRepo_H.INhanVienRepository;
import services.ISV_H.INhanVienService;

public class NhanVienService implements INhanVienService{
    INhanVienRepository repo = new NhanVienRepository();
    @Override
    public int layIDNhanVienTheoTen(String tenNhanVien) {
        return repo.getIDMaNhanVienByName(tenNhanVien);
    }
    
}
