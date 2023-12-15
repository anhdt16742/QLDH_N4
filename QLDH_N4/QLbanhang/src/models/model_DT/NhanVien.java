/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.model_DT;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String idNV;
    private String tenNV;
    private String DateNV;
    private int gioiTinh;
    private String SDT;
    private String idTrangThai;

    public NhanVien() {
    }

    public NhanVien(String idNV, String tenNV, String DateNV, int gioiTinh, String SDT, String idTrangThai) {
        this.idNV = idNV;
        this.tenNV = tenNV;
        this.DateNV = DateNV;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.idTrangThai = idTrangThai;
    }

    public NhanVien(String idNV, String tenNV) {
        this.idNV = idNV;
        this.tenNV = tenNV;
    }
    

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDateNV() {
        return DateNV;
    }

    public void setDateNV(String DateNV) {
        this.DateNV = DateNV;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(String idTrangThai) {
        this.idTrangThai = idTrangThai;
    }
    
    
}
