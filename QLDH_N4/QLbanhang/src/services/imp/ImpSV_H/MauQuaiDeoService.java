
package services.imp.ImpSV_H;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.model_H.MauQuaiDeo;
import repositorys.imp.Imp_H.MauQuaiDeoRepository;
import repositorys.IRepo_H.IMauQuaiDeoRepository;
import services.ISV_H.IMauQuaiDeoService;

public class MauQuaiDeoService implements IMauQuaiDeoService {
    IMauQuaiDeoRepository mauRepo = new MauQuaiDeoRepository();
    @Override
    public void themMoiMauQuaiDeo(MauQuaiDeo mauQuaiDeo) {
        if(mauRepo.create(mauQuaiDeo)){
            JOptionPane.showMessageDialog(null, "Thêm mới màu quai đeo đồng hồ thành công");
            return;
        }
        JOptionPane.showMessageDialog(null, "Thêm mới màu quai đeo đồng hồ thất bại !!!");
    }

    @Override
    public void suaMauQuaiDeo(MauQuaiDeo mauQuaiDeo) {
        if(mauRepo.update(mauQuaiDeo)){
            JOptionPane.showMessageDialog(null, "Sửa màu quai đeo đồng hồ thành công");
            return;
        }
        JOptionPane.showMessageDialog(null, "Sửa màu quai đeo đồng hồ thất bại !!!");
    }


    @Override
    public ArrayList<MauQuaiDeo> layThongTinMauQuaiDeo() {
        return mauRepo.selectAll();
    }
    
}
