
package models.model_DT;

import java.util.Date;

public class MaPhanBietSanPham {
        
    private String ma;
    private Integer idTrangThai;
    private Integer idChiTietDH;
    private Date ngayTao;

    public MaPhanBietSanPham() {
    }

    public MaPhanBietSanPham(String ma, Integer idTrangThai, Integer idChiTietDH, Date ngayTao) {
        this.ma = ma;
        this.idTrangThai = idTrangThai;
        this.idChiTietDH = idChiTietDH;
        this.ngayTao = ngayTao;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Integer getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(Integer idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public Integer getIdChiTietDH() {
        return idChiTietDH;
    }

    public void setIdChiTietDH(Integer idChiTietDH) {
        this.idChiTietDH = idChiTietDH;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    
            
}
