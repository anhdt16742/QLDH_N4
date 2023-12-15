
package models.model_H;

public class HoaDonChiTiet {
    
    private Integer idHoaDon;
    private Integer idChiTietDH;
    private Integer soLuong;
    private Double donGia;
    private Double thanhTien;
    private Double donGiaKhiGiam;

    public HoaDonChiTiet() {
    }

//    public HoaDonChiTiet(Integer idHoaDon, Integer idChiTietDH, Integer soLuong, Double donGia) {
//        this.idHoaDon = idHoaDon;
//        this.idChiTietDH = idChiTietDH;
//        this.soLuong = soLuong;

    public HoaDonChiTiet(Integer idHoaDon, Integer idChiTietDH, Integer soLuong, Double donGia, Double thanhTien, Double donGiaKhiGiam) {
        this.idHoaDon = idHoaDon;
        this.idChiTietDH = idChiTietDH;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

//        this.donGia = donGia;
//    }
    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Double getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(Double donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
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

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
    
    
    
    
}
