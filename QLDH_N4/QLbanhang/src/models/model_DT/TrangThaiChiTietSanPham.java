
package models.model_DT;


public class TrangThaiChiTietSanPham {
    private Integer id;
    private String trangThai;

    public TrangThaiChiTietSanPham() {
    }

    public TrangThaiChiTietSanPham(Integer id, String trangThai) {
        this.id = id;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
