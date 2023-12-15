
package models.model_DT;

public class TrangThaiDongHo {
    
    private Integer id;
    private String tenTrangThai;

    public TrangThaiDongHo() {
    }

    public TrangThaiDongHo(Integer id, String tenTrangThai) {
        this.id = id;
        this.tenTrangThai = tenTrangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }
            
    
            
    
}
