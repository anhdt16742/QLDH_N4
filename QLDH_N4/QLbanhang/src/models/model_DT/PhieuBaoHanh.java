/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.model_DT;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhieuBaoHanh {

    private String idPBH, ngayMua;
    private int thoiHan, trangThai;
    private int count;
    private HoaDonChiTiet hdct;

    public PhieuBaoHanh() {
    }
    
    public PhieuBaoHanh(String idPBH, String ngayMua, int thoiHan, int trangThai) {
        this.idPBH = idPBH;
        this.ngayMua = ngayMua;
        this.thoiHan = thoiHan;
        this.trangThai = trangThai;
    }

    public PhieuBaoHanh(String idPBH, String ngayMua, int thoiHan, int trangThai, int count, HoaDonChiTiet hdct) {
        this.idPBH = idPBH;
        this.ngayMua = ngayMua;
        this.thoiHan = thoiHan;
        this.trangThai = trangThai;
        this.count = count;
        this.hdct = hdct;
    }

    public PhieuBaoHanh(String ngayMua, int thoiHan, int trangThai, HoaDonChiTiet hdct) {
        this.ngayMua = ngayMua;
        this.thoiHan = thoiHan;
        this.trangThai = trangThai;
        this.hdct = hdct;
    }

    public PhieuBaoHanh(String idPBH, String ngayMua, int thoiHan, int trangThai, HoaDonChiTiet hdct) {
        this.idPBH = idPBH;
        this.ngayMua = ngayMua;
        this.thoiHan = thoiHan;
        this.trangThai = trangThai;
        this.hdct = hdct;
    }

    public HoaDonChiTiet getHdct() {
        return hdct;
    }

    public void setHdct(HoaDonChiTiet hdct) {
        this.hdct = hdct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public PhieuBaoHanh(String ngayMua, int thoiHan, int trangThai) {
        this.ngayMua = ngayMua;
        this.thoiHan = thoiHan;
        this.trangThai = trangThai;
    }

    public String getIdPBH() {
        return idPBH;
    }

    public void setIdPBH(String idPBH) {
        this.idPBH = idPBH;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(int thoiHan) {
        this.thoiHan = thoiHan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhieuBaoHanh{" + "idPBH=" + idPBH + ", ngayMua=" + ngayMua + ", thoiHan=" + thoiHan + ", trangThai=" + trangThai + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{this.idPBH, this.hdct.getHD().getKH().getTenKhachHang(),this.hdct.getHD().getIdHD(), this.hdct.getIdCTDH().getIdChiTietDH(), this.ngayMua, thoiHan + " Tháng", this.trangThai == 1 ? "Trong thời hạn bảo hành" : "Đã hết hạn bảo hành"};
    }

}
