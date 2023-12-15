
package viewmodel.ViewModel_DT;

public class HoaDonChiTietViewModel {
    // mã hóa đơn, mã sp chi tiest, tên đồng hò, số lượng, giá bán, tổng tiền 
    
    private Integer idHoaDon;
    private Integer idChiTietDH;
    private String tenDH;
    private Integer soLuong;
    private Double giaBan;
    private Double tongTien;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(Integer idHoaDon, Integer idChiTietDH, String tenDH, Integer soLuong, Double giaBan, Double tongTien) {
        this.idHoaDon = idHoaDon;
        this.idChiTietDH = idChiTietDH;
        this.tenDH = tenDH;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.tongTien = tongTien;
    }

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Integer getIdChiTietDH() {
        return idChiTietDH;
    }

    public void setIdChiTietDH(Integer idChiTietDH) {
        this.idChiTietDH = idChiTietDH;
    }

    public String getTenDH() {
        return tenDH;
    }

    public void setTenDH(String tenDH) {
        this.tenDH = tenDH;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    
           
}
