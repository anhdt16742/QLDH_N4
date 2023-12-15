
package viewmodel.ViewModel_H;

public class HoaDonChiTietViewModel {
    // mã hóa đơn, mã sp chi tiest, tên đồng hò, số lượng, giá bán, tổng tiền 
    
    private Integer idHoaDon;
    private Integer idChiTietDH;
    private String tenDH;
    private Integer soLuong;
    private Double giaBan;
    private Double giaBanGiam;
    private Double thanhTien;

    public HoaDonChiTietViewModel() {
    }

//    public HoaDonChiTietViewModel(Integer idHoaDon, Integer idChiTietDH, String tenDH, Integer soLuong, Double giaBan, Double thanhTien) {
//        this.idHoaDon = idHoaDon;
//        this.idChiTietDH = idChiTietDH;
//        this.tenDH = tenDH;
//        this.soLuong = soLuong;
//        this.giaBan = giaBan;
//        this.thanhTien = thanhTien;
//    }

    public HoaDonChiTietViewModel(Integer idHoaDon, Integer idChiTietDH, String tenDH, Integer soLuong, Double giaBan, Double giaBanGiam, Double thanhTien) {
        this.idHoaDon = idHoaDon;
        this.idChiTietDH = idChiTietDH;
        this.tenDH = tenDH;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaBanGiam = giaBanGiam;
        this.thanhTien = thanhTien;
    }

    public Double getGiaBanGiam() {
        return giaBanGiam;
    }

    public void setGiaBanGiam(Double giaBanGiam) {
        this.giaBanGiam = giaBanGiam;
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

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    

           
}
