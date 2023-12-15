package services;

import java.util.ArrayList;
import models.TrangThaiDongHo;

public interface ITrangThaiDongHoService {

    String layTrangThaiBangID(int idTrangThai);

    Integer layIDByTrangThai(String tenTrangThai);

    ArrayList<TrangThaiDongHo> latTTrangThaiDH();
}
