/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class User {

    private String idUser;
    private String taiKhoan, matKhau;
    private int chucVu, trangThai;
    private String tenUSer;
    private int gioiTinh;
    private String date;

    public User() {
    }

    public User(String taiKhoan, String matKhau, int chucVu, int trangThai, String tenUSer, int gioiTinh, String date) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
        this.tenUSer = tenUSer;
        this.gioiTinh = gioiTinh;
        this.date = date;
    }

    public User(String idUser, String taiKhoan, String matKhau, int chucVu, int trangThai, String tenUSer, int gioiTinh, String date) {
        this.idUser = idUser;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
        this.tenUSer = tenUSer;
        this.gioiTinh = gioiTinh;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    

    public User(String idUser, String taiKhoan, String matKhau, int chucVu, int trangThai, String tenUSer, int gioiTinh) {
        this.idUser = idUser;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
        this.tenUSer = tenUSer;
        this.gioiTinh = gioiTinh;
    }

    public String getTenUSer() {
        return tenUSer;
    }

    public void setTenUSer(String tenUSer) {
        this.tenUSer = tenUSer;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public User(String taiKhoan, String matKhau, int chucVu, int trangThai) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getChucVu() {
        return chucVu;
    }

    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", chucVu=" + chucVu + ", trangThai=" + trangThai + '}';
    }

}
