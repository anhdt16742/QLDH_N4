package services.imp.ImpSV_H;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.model_H.TrangThaiDongHo;
import repositorys.imp.Imp_H.TrangThaiDongHoRepository;
import repositorys.IRepo_H.ITrangThaiDongHoRepository;
import services.ISV_H.ITrangThaiDongHoService;

public class TrangThaiDH_Service implements ITrangThaiDongHoService {

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

    @Override
    public void themMoiTrangThaiDH(TrangThaiDongHo trangThai) {
        if (repo.create(trangThai)) {
            JOptionPane.showMessageDialog(null, "Thêm mới trạng thái đồng hồ thành công");
            return;
        }
        JOptionPane.showMessageDialog(null, "Thêm mới trạng thái đồng hồ thất bại !!!");
    }

    @Override
    public void suaTrangThaiDH(TrangThaiDongHo trangThai) {
        if (repo.update(trangThai)) {
            JOptionPane.showMessageDialog(null, "Sửa trạng thái đồng hồ thành công");
            return;
        }
        JOptionPane.showMessageDialog(null, "Sửa trạng thái đồng hồ thất bại !!!");

    }

}
