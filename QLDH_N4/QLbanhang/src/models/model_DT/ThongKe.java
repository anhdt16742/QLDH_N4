/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.model_DT;


    
/**
 *  
 * @author Admin
 */
public class ThongKe {
    
    private HoaDon hd;
        
    private KhachHang kh;
    
    private HoaDonChiTiet hdct;

    public ThongKe() {
    }

    public ThongKe(HoaDon hd, KhachHang kh, HoaDonChiTiet hdct) {
        this.hd = hd;
        this.kh = kh;
        this.hdct = hdct;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public HoaDonChiTiet getHdct() {
        return hdct;
    }

    public void setHdct(HoaDonChiTiet hdct) {
        this.hdct = hdct;
    }

    @Override
    public String toString() {
        return "ThongKe{" + "hd=" + hd.getIdHD() + ", kh=" + kh.getTenKhachHang() + ", hdct=" + hdct.getSoLuong() + ", hdct=" + hdct.getDonGia()+", hdct=" + (hdct.getSoLuong()*hdct.getDonGia())+ '}';
    }
    
     public Object[]toDataRow(){
      return new Object[]{hd.getIdHD(), kh.getTenKhachHang() , hdct.getSoLuong() ,hdct.getDonGia(),hd.getNgayTao(),(hdct.getSoLuong()*hdct.getDonGia())};
  }
  
    
}
