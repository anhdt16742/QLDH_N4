
package viewmodel;

public class HoaDonViewModel {
    
        
   private Integer maHoaDon;
   private String tenNhanVien;
   private String tenKhachHang;
   private String trangThaiHoaDon;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(Integer maHoaDon, String tenNhanVien, String tenKhachHang, String trangThaiHoaDon) {
        this.maHoaDon = maHoaDon;
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.trangThaiHoaDon = trangThaiHoaDon;
    }

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTrangThaiHoaDon() {
        return trangThaiHoaDon;
    }

    public void setTrangThaiHoaDon(String trangThaiHoaDon) {
        this.trangThaiHoaDon = trangThaiHoaDon;
    }
   
   
   
}
