
package viewmodel.ViewModel_DT;

import java.util.Date;


// INSERT INTO HoaDon(IdKH, IdNV, NgayTao, idTrangThai)
public class HoaDonModelToInsert {
    private Integer idKH;
    private Integer idNV;
    private Date ngayTao;
    private Integer idTrangThai;

    public HoaDonModelToInsert() {
    }

    public HoaDonModelToInsert(Integer idKH, Integer idNV, Date ngayTao, Integer idTrangThai) {
        this.idKH = idKH;
        this.idNV = idNV;
        this.ngayTao = ngayTao;
        this.idTrangThai = idTrangThai;
    }

    public Integer getIdKH() {
        return idKH;
    }

    public void setIdKH(Integer idKH) {
        this.idKH = idKH;
    }

    public Integer getIdNV() {
        return idNV;
    }

    public void setIdNV(Integer idNV) {
        this.idNV = idNV;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(Integer idTrangThai) {
        this.idTrangThai = idTrangThai;
    }
    
    
}
