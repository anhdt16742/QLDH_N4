
package services.imp.ImpSV_DT;

import java.util.ArrayList;
import models.model_DT.TrangThaiDongHo;
import repositorys.IRepo_DT.ITrangThaiDongHoRepository;
import repositorys.imp.Imp_DT.TrangThaiDongHoRepository;
import services.ISV_DT.ITrangThaiDongHoService;


public class TrangThaiDH_Service implements ITrangThaiDongHoService{
    ITrangThaiDongHoRepository repo = new TrangThaiDongHoRepository();
    @Override
    public String layTrangThaiBangID(int idTrangThai) {
        return repo.getTenTrangThaiByID(idTrangThai);
    }

    @Override
    public Integer layIDByTrangThai(String tenTrangThai) {
        return repo.getIDByTrangThai(tenTrangThai);
    }

    @Override
    public ArrayList<TrangThaiDongHo> latTTrangThaiDH() {
        return repo.selectAll();
    }
    
}
