/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.model_TA;

import java.math.BigDecimal;

/**
 *
 * @author ADMIN
 */
public class KhuyenMai {

    private String TenKM, HinhThucKM, NgayBatDau, NgayKetThuc;
    private Double GiaTriGiam;
    private int ID, Trangthai;

    public KhuyenMai() {
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "TenKM=" + TenKM + ", HinhThucKM=" + HinhThucKM + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + ", GiaTriGiam=" + GiaTriGiam + ", ID=" + ID + ", Trangthai=" + Trangthai + '}';
    }

    public KhuyenMai(String TenKM, String HinhThucKM, String NgayBatDau, String NgayKetThuc, Double GiaTriGiam, int ID, int Trangthai) {
        this.TenKM = TenKM;
        this.HinhThucKM = HinhThucKM;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.GiaTriGiam = GiaTriGiam;
        this.ID = ID;
        this.Trangthai = Trangthai;
    }

//    public KhuyenMai(String TenKM, String HinhThucKM, String NgayBatDau, String NgayKetThuc, Double GiaTriGiam,int Trangthai) {
//        this.TenKM = TenKM;
//        this.HinhThucKM = HinhThucKM;
//        this.NgayBatDau = NgayBatDau;
//        this.NgayKetThuc = NgayKetThuc;
//        this.GiaTriGiam = GiaTriGiam;
//        this.Trangthai = Trangthai;
//    }
    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public String getHinhThucKM() {
        return HinhThucKM;
    }

    public void setHinhThucKM(String HinhThucKM) {
        this.HinhThucKM = HinhThucKM;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public String getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public Double getGiaTriGiam() {
        return GiaTriGiam;
    }

    public void setGiaTriGiam(Double GiaTriGiam) {
        this.GiaTriGiam = GiaTriGiam;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(int Trangthai) {
        this.Trangthai = Trangthai;
    }

}
