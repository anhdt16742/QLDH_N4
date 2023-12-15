/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class PhieuGiaoBH {
    private String idPhieuGiao;
    private String idPBH;
    private String lyDo;
    private String viecLam;
    private String tieuChi;
    private int thoiGianBH;
    private int trangThai;

    public PhieuGiaoBH() {
    }

    public PhieuGiaoBH(String idPhieuGiao, String idPBH, String lyDo, String viecLam, String tieuChi, int thoiGianBH, int trangThai) {
        this.idPhieuGiao = idPhieuGiao;
        this.idPBH = idPBH;
        this.lyDo = lyDo;
        this.viecLam = viecLam;
        this.tieuChi = tieuChi;
        this.thoiGianBH = thoiGianBH;
        this.trangThai = trangThai;
    }

    public PhieuGiaoBH(String idPBH, String lyDo, String viecLam, String tieuChi, int thoiGianBH, int trangThai) {
        this.idPBH = idPBH;
        this.lyDo = lyDo;
        this.viecLam = viecLam;
        this.tieuChi = tieuChi;
        this.thoiGianBH = thoiGianBH;
        this.trangThai = trangThai;
    }

    public String getIdPhieuGiao() {
        return idPhieuGiao;
    }

    public void setIdPhieuGiao(String idPhieuGiao) {
        this.idPhieuGiao = idPhieuGiao;
    }

    public String getIdPBH() {
        return idPBH;
    }

    public void setIdPBH(String idPBH) {
        this.idPBH = idPBH;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getViecLam() {
        return viecLam;
    }

    public void setViecLam(String viecLam) {
        this.viecLam = viecLam;
    }

    public String getTieuChi() {
        return tieuChi;
    }

    public void setTieuChi(String tieuChi) {
        this.tieuChi = tieuChi;
    }

    public int getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(int thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhieuGiaoBH{" + "idPhieuGiao=" + idPhieuGiao + ", idPBH=" + idPBH + ", lyDo=" + lyDo + ", viecLam=" + viecLam + ", tieuChi=" + tieuChi + ", thoiGianBH=" + thoiGianBH + ", trangThai=" + trangThai + '}';
    }
    
    public String trangThai(int trangThai){
        String trangThai1="";
        if(trangThai==1){
            trangThai1 = "Đang Bảo Hành";
        }else if(trangThai==2){
            trangThai1 = "Đã Hoàn Thành";
        }else{
            trangThai1 = "Không đủ tiêu chí bảo hành";
        }
        return trangThai1;
    }
    
    public Object[] toDataRow2() {
        return new Object[]{idPhieuGiao,idPBH,lyDo,viecLam,thoiGianBH,trangThai(trangThai)};
    }
}
