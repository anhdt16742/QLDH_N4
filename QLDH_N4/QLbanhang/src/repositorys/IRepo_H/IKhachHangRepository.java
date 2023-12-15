
package repositorys.IRepo_H;

import java.util.ArrayList;
import models.model_H.KhachHang;

public interface IKhachHangRepository {
    ArrayList<KhachHang> selectAll();
    ArrayList<KhachHang> searchBySDTKH(String sdt);
    String findBySDT_returnNameKH(String sdt);
    
;}
