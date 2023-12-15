
package services.imp;

import java.util.ArrayList;
import models.MauQuaiDeo;
import repositorys.IMauQuaiDeoRepository;
import repositorys.imp.MauQuaiDeoRepository;
import services.IMauQuaiDeoService;

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
