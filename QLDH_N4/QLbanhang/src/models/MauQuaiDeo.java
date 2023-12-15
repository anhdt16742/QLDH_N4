
package models;

public class MauQuaiDeo {
    private Integer idMauQuaiDeo;
    private String tenQuaiDeo;

    public MauQuaiDeo() {
    }

    public MauQuaiDeo(Integer idMauQuaiDeo, String tenQuaiDeo) {
        this.idMauQuaiDeo = idMauQuaiDeo;
        this.tenQuaiDeo = tenQuaiDeo;
    }

    public Integer getIdMauQuaiDeo() {
        return idMauQuaiDeo;
    }

    public void setIdMauQuaiDeo(Integer idMauQuaiDeo) {
        this.idMauQuaiDeo = idMauQuaiDeo;
    }

    public String getTenQuaiDeo() {
        return tenQuaiDeo;
    }

    public void setTenQuaiDeo(String tenQuaiDeo) {
        this.tenQuaiDeo = tenQuaiDeo;
    }
    
    
    
}
