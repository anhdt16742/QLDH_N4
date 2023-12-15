/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;
import models.model_DN.ChiTietDongHo;

/**
 *
 * @author Admin
 */
public class HoaDonChiTiet {

    private String idHDCT;

    private HoaDon HD;

    private ChiTietDongHo idCTDH;

    private int soLuong;

    private long donGia;

    private long thanhTien = donGia * soLuong;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHDCT) {
        this.idHDCT = idHDCT;
    }

    public HoaDonChiTiet(String idHDCT, HoaDon HD, ChiTietDongHo idCTDH, int soLuong, long donGia, long thanhTien) {
        this.idHDCT = idHDCT;
        this.HD = HD;
        this.idCTDH = idCTDH;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;

    }

    public HoaDonChiTiet(String idHDCT, HoaDon HD, ChiTietDongHo idCTDH) {
        this.idHDCT = idHDCT;
        this.HD = HD;
        this.idCTDH = idCTDH;
    }

    public HoaDonChiTiet(int soLuong, long donGia, long thanhTien) {
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public HoaDonChiTiet(int soLuong, long donGia) {
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdHDCT() {
        return idHDCT;
    }

    public void setIdHDCT(String idHDCT) {
        this.idHDCT = idHDCT;
    }

    public HoaDon getHD() {
        return HD;
    }

    public void setHD(HoaDon HD) {
        this.HD = HD;
    }

    public ChiTietDongHo getIdCTDH() {
        return idCTDH;
    }

    public void setIdCTDH(ChiTietDongHo idCTDH) {
        this.idCTDH = idCTDH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "idHDCT=" + idHDCT + ", HD=" + HD + ", idCTDH=" + idCTDH + ", soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien=" + thanhTien + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{idHDCT, HD.getIdHD(), idCTDH.getIdDH().getTen(), soLuong, donGia, thanhTien};
    }

    public String[] toDataRow1() {
        return new String[]{String.valueOf(this.idHDCT), this.HD.getIdHD(), this.idCTDH.getIdDH().getTen(), String.valueOf(this.soLuong), String.valueOf(this.donGia), String.valueOf(this.thanhTien)};
    }

}
