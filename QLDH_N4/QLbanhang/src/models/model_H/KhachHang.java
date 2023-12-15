
package models.model_H;

import java.util.Date;

public class KhachHang {
    private Integer maKH;
    private String tenKH;
    private Date sinhNhat;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private Boolean gioiTinh;
    private String soCMND;
    private String anhDaiDien;
    private Integer diemTichLuy;
    private Integer trangThai;

    public KhachHang() {
    }

    public KhachHang(Integer maKH, String tenKH, Date sinhNhat, String diaChi, String soDienThoai, String email, Boolean gioiTinh, String soCMND, String anhDaiDien, Integer diemTichLuy, Integer trangThai) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sinhNhat = sinhNhat;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.anhDaiDien = anhDaiDien;
        this.diemTichLuy = diemTichLuy;
        this.trangThai = trangThai;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Date getSinhNhat() {
        return sinhNhat;
    }

    public void setSinhNhat(Date sinhNhat) {
        this.sinhNhat = sinhNhat;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public Integer getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(Integer diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
            
    
}
