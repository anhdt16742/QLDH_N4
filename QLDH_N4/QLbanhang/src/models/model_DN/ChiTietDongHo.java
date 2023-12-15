/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.model_DN;

import models.DongHo;

/**
 *
 * @author Admin
 */
public class ChiTietDongHo {

    private Integer idChiTietDH;
    private DongHo DH;
    private Integer idGioiTinh;
    private Integer idKieuMay;
    private Integer idLoaiDayDeo;
    private Integer idMauVo;
    private Integer soLuong;
    private Double giaNhap;
    private Double giaBan;
    private Integer idKhuyenMai;
    private Integer idTrangThaiSP;

    public ChiTietDongHo() {
    }

    public ChiTietDongHo(Integer idChiTietDH, DongHo DH) {
        this.idChiTietDH = idChiTietDH;
        this.DH = DH;
    }

    public ChiTietDongHo(Integer idChiTietDH) {
        this.idChiTietDH = idChiTietDH;
    }

    public ChiTietDongHo(Integer idChiTietDH, DongHo DH, Integer idGioiTinh, Integer idKieuMay, Integer idLoaiDayDeo, Integer idMauVo, Integer soLuong, Double giaNhap, Double giaBan, Integer idKhuyenMai, Integer idTrangThaiSP) {
        this.idChiTietDH = idChiTietDH;
        this.DH = DH;
        this.idGioiTinh = idGioiTinh;
        this.idKieuMay = idKieuMay;
        this.idLoaiDayDeo = idLoaiDayDeo;
        this.idMauVo = idMauVo;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.idKhuyenMai = idKhuyenMai;
        this.idTrangThaiSP = idTrangThaiSP;
    }

    public Integer getIdChiTietDH() {
        return idChiTietDH;
    }

    public void setIdChiTietDH(Integer idChiTietDH) {
        this.idChiTietDH = idChiTietDH;
    }

    public DongHo getIdDH() {
        return DH;
    }

    public void setIdDH(DongHo idDH) {
        this.DH = idDH;
    }

    public Integer getIdGioiTinh() {
        return idGioiTinh;
    }

    public void setIdGioiTinh(Integer idGioiTinh) {
        this.idGioiTinh = idGioiTinh;
    }

    public Integer getIdKieuMay() {
        return idKieuMay;
    }

    public void setIdKieuMay(Integer idKieuMay) {
        this.idKieuMay = idKieuMay;
    }

    public Integer getIdLoaiDayDeo() {
        return idLoaiDayDeo;
    }

    public void setIdLoaiDayDeo(Integer idLoaiDayDeo) {
        this.idLoaiDayDeo = idLoaiDayDeo;
    }

    public Integer getIdMauVo() {
        return idMauVo;
    }

    public void setIdMauVo(Integer idMauVo) {
        this.idMauVo = idMauVo;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(Integer idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public Integer getIdTrangThaiSP() {
        return idTrangThaiSP;
    }

    public void setIdTrangThaiSP(Integer idTrangThaiSP) {
        this.idTrangThaiSP = idTrangThaiSP;
    }
}
