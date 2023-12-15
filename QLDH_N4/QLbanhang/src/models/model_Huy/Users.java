/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.model_Huy;

import java.util.Date;
import models.model_Huy.Chucvu;

/**
 *
 * @author hungh
 */
public class Users {

    private String id;
    private String ten;
    private String ngaysinh;
    private Integer gioitinh;
    private String sdt;
    private Integer TT;
    private Chucvu ChucVu;

    public Users() {
    }

    public Users(String id, String ten, String ngaysinh, Integer gioitinh, String sdt, Integer TT, Chucvu ChucVu) {
        this.id = id;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.TT = TT;
        this.ChucVu = ChucVu;
    }

    public Users(String ten, String ngaysinh, Integer gioitinh, String sdt, Chucvu ChucVu, Integer TT) {
        this.ten = ten;

        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.sdt = sdt;

        this.ChucVu = ChucVu;
        this.TT = TT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Integer getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Integer gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Integer getTT() {
        return TT;
    }

    public void setTT(Integer TT) {
        this.TT = TT;
    }

    public Chucvu getChucVu() {
        return ChucVu;
    }

    public void setChucVu(Chucvu ChucVu) {
        this.ChucVu = ChucVu;
    }

    @Override
    public String toString() {
        return ten;
    }

}
