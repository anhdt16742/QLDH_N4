package services.ISV_DT;

import java.util.ArrayList;
import models.model_DT.TrangThaiDongHo;

public interface ITrangThaiDongHoService {

    String layTrangThaiBangID(int idTrangThai);

    Integer layIDByTrangThai(String tenTrangThai);

    ArrayList<TrangThaiDongHo> latTTrangThaiDH();
}
