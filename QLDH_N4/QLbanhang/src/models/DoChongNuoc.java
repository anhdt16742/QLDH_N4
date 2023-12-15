
package models;


public class DoChongNuoc {
    private Integer id;
    private Integer soLieuDo;
    private String moTa;

    public DoChongNuoc() {
    }

    public DoChongNuoc(Integer id, Integer soLieuDo, String moTa) {
        this.id = id;
        this.soLieuDo = soLieuDo;
        this.moTa = moTa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoLieuDo() {
        return soLieuDo;
    }

    public void setSoLieuDo(Integer soLieuDo) {
        this.soLieuDo = soLieuDo;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    
    
    
}
