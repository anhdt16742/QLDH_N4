/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel.ViewModel_Huy;

import java.util.Date;
import models.model_Huy.Chucvu;

/**
 *
 * @author hungh
 */
public class UsersViewmodel {

    private String ten;
    private String ngaysinh;
    private Integer gioitinh;
    private String sdt;
    private Chucvu chucvu;
    private Integer TT;

    public UsersViewmodel() {
    }

    public UsersViewmodel( String ten, String ngaysinh, Integer gioitinh, String sdt, Chucvu chucvu, Integer TT) {
        this.ten = ten;
        
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
       
        this.chucvu = chucvu;
        this.TT = TT;
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


    public Chucvu getChucVu() {
        return chucvu;
    }

    public void setChucVu(Chucvu chucvu) {
        this.chucvu = chucvu;
    }

    public Integer getTT() {
        return TT;
    }

    public void setTT(Integer TT) {
        this.TT = TT;
    }

    public String getgt(int gt) {
        return gt == 1 ? "Nam" : "Nữ";
    }

}
