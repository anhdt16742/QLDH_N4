/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repositorys.imp.HoaDonChiTietRepository;

/**
 *
 * @author Admin
 */
public class HoaDon {

    private String idHD;

    private KhachHang KH;

    private String NgayTao;

    private String NgayThanhToan;

    private int idTrangThai;

    private NhanVien NV;

    private Double tongTien;

    public HoaDon() {
    }

    public HoaDon(String NgayThanhToan, int idTrangThai) {
        this.NgayThanhToan = NgayThanhToan;
        this.idTrangThai = idTrangThai;
    }

    public HoaDon(String idHD, KhachHang KH, String NgayTao, String NgayThanhToan, int idTrangThai, NhanVien NV, Double tongTien) {
        this.idHD = idHD;
        this.KH = KH;
        this.NgayTao = NgayTao;
        this.NgayThanhToan = NgayThanhToan;
        this.idTrangThai = idTrangThai;
        this.NV = NV;
        this.tongTien = tongTien;
    }

    public HoaDon(String idHD, KhachHang KH, String NgayTao, String NgayThanhToan, int idTrangThai, NhanVien NV) {
        this.idHD = idHD;
        this.KH = KH;
        this.NgayTao = NgayTao;
        this.NgayThanhToan = NgayThanhToan;
        this.idTrangThai = idTrangThai;
        this.NV = NV;
    }

    public HoaDon(String idHD, String NgayTao, int idTrangThai) {
        this.idHD = idHD;
        this.NgayTao = NgayTao;
        this.idTrangThai = idTrangThai;
    }

    public HoaDon(String idHD) {
        this.idHD = idHD;
    }

    public HoaDon(String idHD, KhachHang KH) {
        this.idHD = idHD;
        this.KH = KH;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public KhachHang getKH() {
        return KH;
    }

    public void setIdKH(KhachHang KH) {
        this.KH = KH;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public int getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(int idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public NhanVien getNV() {
        return NV;
    }

    public void setNV(NhanVien NV) {
        this.NV = NV;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Object[] toDataRow() {
        return new Object[]{idHD, KH.getTenKhachHang(), NV.getTenNV(), NgayTao, NgayThanhToan, tongTien, idTrangThai == 3 ? "Đã Thanh Toán" : "Chưa Thanh Toán"};
    }

    public HoaDon(KhachHang KH, String NgayTao, String NgayThanhToan, int idTrangThai, NhanVien NV, Double tongTien) {
        this.KH = KH;
        this.NgayTao = NgayTao;
        this.NgayThanhToan = NgayThanhToan;
        this.idTrangThai = idTrangThai;
        this.NV = NV;
        this.tongTien = tongTien;
    }

}
