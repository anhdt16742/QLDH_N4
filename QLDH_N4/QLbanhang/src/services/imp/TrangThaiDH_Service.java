
package services.imp;

import java.util.ArrayList;
import models.TrangThaiDongHo;
import repositorys.ITrangThaiDongHoRepository;
import repositorys.imp.TrangThaiDongHoRepository;
import services.ITrangThaiDongHoService;


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
