/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhachHang {

    private String idKH;
    private String tenKhachHang;
    private Date sinhNhat;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private boolean gioiTinh;
    private String soCanCuoc;
    private String anhDaiDien;
    private int diemTichLuy;
    private int trangThai;

    public KhachHang() {
    }

    public KhachHang(String tenKhachHang, Date sinhNhat, String diaChi, String soDienThoai, String email, boolean gioiTinh, String soCanCuoc, String anhDaiDien, int diemTichLuy, int trangThai) {
        this.tenKhachHang = tenKhachHang;
        this.sinhNhat = sinhNhat;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.soCanCuoc = soCanCuoc;
        this.anhDaiDien = anhDaiDien;
        this.diemTichLuy = diemTichLuy;
        this.trangThai = trangThai;
    }

    public KhachHang(String idKH, String tenKhachHang, Date sinhNhat, String diaChi, String soDienThoai, String email, boolean gioiTinh, String soCanCuoc, String anhDaiDien, int diemTichLuy, int trangThai) {
        this.idKH = idKH;
        this.tenKhachHang = tenKhachHang;
        this.sinhNhat = sinhNhat;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.soCanCuoc = soCanCuoc;
        this.anhDaiDien = anhDaiDien;
        this.diemTichLuy = diemTichLuy;
        this.trangThai = trangThai;
    }

    public KhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
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

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCanCuoc() {
        return soCanCuoc;
    }

    public void setSoCanCuoc(String soCanCuoc) {
        this.soCanCuoc = soCanCuoc;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] toDataRow() {
        return new Object[]{idKH, tenKhachHang, sinhNhat, diaChi, soDienThoai, email, gioiTinh == true ? "Nam" : "Nữ", soCanCuoc, anhDaiDien, diemTichLuy, trangThai};
    }

    public KhachHang(String idKH, String tenKhachHang) {
        this.idKH = idKH;
        this.tenKhachHang = tenKhachHang;
    }

}
