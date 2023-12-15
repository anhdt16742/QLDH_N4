
package models.model_H;

public class DongHo {
    private Integer id;
    private String ten;
    private String thuongHieu;
    private String xuatXu;
    private String noiSanXuat;
    private String chatLieuMatSo;
    private Double duongKinhMatSo;
    private Double beDayMatSo;
    private String tinhNang;
    private Integer thoiGianBH;
    private Integer idTrangThaiDH;

    public DongHo() {
    }

    public DongHo(Integer id, String ten, String thuongHieu, String xuatXu, String noiSanXuat, String chatLieuMatSo, Double duongKinhMatSo, Double beDayMatSo, String tinhNang, Integer thoiGianBH, Integer idTrangThaiDH) {
        this.id = id;
        this.ten = ten;
        this.thuongHieu = thuongHieu;
        this.xuatXu = xuatXu;
        this.noiSanXuat = noiSanXuat;
        this.chatLieuMatSo = chatLieuMatSo;
        this.duongKinhMatSo = duongKinhMatSo;
        this.beDayMatSo = beDayMatSo;
        this.tinhNang = tinhNang;
        this.thoiGianBH = thoiGianBH;
        this.idTrangThaiDH = idTrangThaiDH;
    }

    public String getTinhNang() {
        return tinhNang;
    }

    public void setTinhNang(String tinhNang) {
        this.tinhNang = tinhNang;
    }

    public Integer getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(Integer thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getNoiSanXuat() {
        return noiSanXuat;
    }

    public void setNoiSanXuat(String noiSanXuat) {
        this.noiSanXuat = noiSanXuat;
    }

    public String getChatLieuMatSo() {
        return chatLieuMatSo;
    }

    public void setChatLieuMatSo(String chatLieuMatSo) {
        this.chatLieuMatSo = chatLieuMatSo;
    }

    public Double getDuongKinhMatSo() {
        return duongKinhMatSo;
    }

    public void setDuongKinhMatSo(Double duongKinhMatSo) {
        this.duongKinhMatSo = duongKinhMatSo;
    }

    public Double getBeDayMatSo() {
        return beDayMatSo;
    }

    public void setBeDayMatSo(Double beDayMatSo) {
        this.beDayMatSo = beDayMatSo;
    }

    public Integer getIdTrangThaiDH() {
        return idTrangThaiDH;
    }

    public void setIdTrangThaiDH(Integer idTrangThaiDH) {
        this.idTrangThaiDH = idTrangThaiDH;
    }
    
    
}
