
package models.model_H;

import java.util.Date;

public class HoaDon {
//    Id bigINT Identity(1,1) primary key ,
//	IdKH bigINT ,
//	IdNV int ,
//	Ma VARCHAR(20) UNIQUE,
//	NgayTao DATE DEFAULT NULL,
//	NgayThanhToan DATE DEFAULT NULL,
//	idTrangThai int 
     private Integer idHoaDon;
     private Integer idKhachHang;
     private Integer idNhanVien;
     private Date ngayTao;
     private Date ngayThanhToan;
     private Integer idTrangThai;

    public HoaDon() {
    }

    public HoaDon(Integer idHoaDon, Integer idKhachHang, Integer idNhanVien, Date ngayTao, Date ngayThanhToan, Integer idTrangThai) {
        this.idHoaDon = idHoaDon;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.idTrangThai = idTrangThai;
    }

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Integer getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(Integer idTrangThai) {
        this.idTrangThai = idTrangThai;
    }


    
     
     
                
                
}
