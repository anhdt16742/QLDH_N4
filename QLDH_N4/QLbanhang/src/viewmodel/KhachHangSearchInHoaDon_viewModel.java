package viewmodel;

import java.util.Date;

public class KhachHangSearchInHoaDon_viewModel {

    private Integer maKH;
    private String tenKH;
    private Date sinhNhat;
    private String sdt;
    private Integer diemTichLuy;
    private String trangThaiKH;

    public KhachHangSearchInHoaDon_viewModel() {
    }

    public KhachHangSearchInHoaDon_viewModel(Integer maKH, String tenKH, Date sinhNhat, String sdt, Integer diemTichLuy, String trangThaiKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sinhNhat = sinhNhat;
        this.sdt = sdt;
        this.diemTichLuy = diemTichLuy;
        this.trangThaiKH = trangThaiKH;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Date getSinhNhat() {
        return sinhNhat;
    }

    public void setSinhNhat(Date sinhNhat) {
        this.sinhNhat = sinhNhat;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Integer getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(Integer diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public String getTrangThaiKH() {
        return trangThaiKH;
    }

    public void setTrangThaiKH(String trangThaiKH) {
        this.trangThaiKH = trangThaiKH;
    }

    
}
