
package services.imp.ImpSV_DT;

import java.util.ArrayList;
import models.model_DT.MauQuaiDeo;
import repositorys.IRepo_DT.IMauQuaiDeoRepository;
import repositorys.imp.Imp_DT.MauQuaiDeoRepository;
import services.ISV_DT.IMauQuaiDeoService;

public class MauQuaiDeoService implements IMauQuaiDeoService {
    IMauQuaiDeoRepository mauRepo = new MauQuaiDeoRepository();
    @Override
    public void themMoiSPPhanBiet(MauQuaiDeo mauQuaiDeo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void suaThongTinSPPhanBiet(MauQuaiDeo mauQuaiDeo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void xoaSPPhanBiet(int idMauQuaiDeo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<MauQuaiDeo> layThongTinSPPB() {
        return mauRepo.selectAll();
    }
    
}
