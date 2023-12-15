
package models.model_H;

import java.util.Date;

public class KhuyenMai {
    
    private Integer id;
    private String ten;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String hinhThucKM;
    private Double giaTriGiam;

    public KhuyenMai() {
    }

    public KhuyenMai(Integer id, String ten, Date ngayBatDau, Date ngayKetThuc, String hinhThucKM, Double giaTriGiam) {
        this.id = id;
        this.ten = ten;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.hinhThucKM = hinhThucKM;
        this.giaTriGiam = giaTriGiam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getHinhThucKM() {
        return hinhThucKM;
    }

    public void setHinhThucKM(String hinhThucKM) {
        this.hinhThucKM = hinhThucKM;
    }

    public Double getGiaTriGiam() {
        return giaTriGiam;
    }

    public void setGiaTriGiam(Double giaTriGiam) {
        this.giaTriGiam = giaTriGiam;
    }
    
    
}
