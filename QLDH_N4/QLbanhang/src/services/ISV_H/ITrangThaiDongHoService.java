package services.ISV_H;

import java.util.ArrayList;
import models.model_H.TrangThaiDongHo;

public interface ITrangThaiDongHoService {

    String layTrangThaiBangID(int idTrangThai);

    Integer layIDByTrangThai(String tenTrangThai);

    ArrayList<TrangThaiDongHo> latTTrangThaiDH();
    
    void themMoiTrangThaiDH(TrangThaiDongHo trangThai);

    void suaTrangThaiDH(TrangThaiDongHo trangThai);
    
    
}
