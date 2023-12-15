/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.model_DT;

/**
 *
 * @author Admin
 */
public class LichSuMua {

    private String idKH;
    private String tenKH;
    private String SDT;
    private HoaDon hd;

    public LichSuMua() {
    }

    public LichSuMua(String idKH, String tenKH, String SDT, HoaDon hd) {
        this.idKH = idKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.hd = hd;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    public Object[] toDataRow() {
        return new Object[]{idKH, tenKH, SDT, hd.getIdHD(), hd.getNgayTao(), hd.getTongTien(), hd.getIdTrangThai() == 0 ? "Đã Thanh Toán" : "Chưa Thanh Toán"};
    }

}
