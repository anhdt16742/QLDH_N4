
package viewmodel.ViewModel_TA;

public class DongHoChiTietViewModel {
//{"Tên đồng hồ","Tính năng","Thời gian bảo hành","Giới tính", "Kiểu máy",
//"Loại dây đeo","Màu dây đeo","Số lượng","Giá bán","Chương trình KM","Giá sp sau KM"}
    private Integer idCTDH;
    private String tenDongHo;
    private String tinhNang;
    private Integer thoiGianBH;
    private String loaiGioiTinh;
    private String loaiKieuMay;
    private String loaiDayDeo;
    private String mauDayDeo;
    private Integer soLuong;
    private Double giaBan;
    private String chuongTrinhKM;
    private Double giaSauKM;
    private String trangThaiDHCT ;

    public DongHoChiTietViewModel() {
    }

    public DongHoChiTietViewModel(Integer idCTDH, String tenDongHo, String tinhNang, Integer thoiGianBH, String loaiGioiTinh, String loaiKieuMay, String loaiDayDeo, String mauDayDeo, Integer soLuong, Double giaBan, String chuongTrinhKM, Double giaSauKM, String trangThaiDHCT) {
        this.idCTDH = idCTDH;
        this.tenDongHo = tenDongHo;
        this.tinhNang = tinhNang;
        this.thoiGianBH = thoiGianBH;
        this.loaiGioiTinh = loaiGioiTinh;
        this.loaiKieuMay = loaiKieuMay;
        this.loaiDayDeo = loaiDayDeo;
        this.mauDayDeo = mauDayDeo;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.chuongTrinhKM = chuongTrinhKM;
        this.giaSauKM = giaSauKM;
        this.trangThaiDHCT = trangThaiDHCT;
    }

    
    public String getTrangThaiDHCT() {
        return trangThaiDHCT;
    }

    public void setTrangThaiDHCT(String trangThaiDHCT) {
        this.trangThaiDHCT = trangThaiDHCT;
    }

    

    public Integer getIdCTDH() {
        return idCTDH;
    }

    public void setIdCTDH(Integer idCTDH) {
        this.idCTDH = idCTDH;
    }

    

    public String getTenDongHo() {
        return tenDongHo;
    }

    public void setTenDongHo(String tenDongHo) {
        this.tenDongHo = tenDongHo;
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

    public String getLoaiGioiTinh() {
        return loaiGioiTinh;
    }

    public void setLoaiGioiTinh(String loaiGioiTinh) {
        this.loaiGioiTinh = loaiGioiTinh;
    }

    public String getLoaiKieuMay() {
        return loaiKieuMay;
    }

    public void setLoaiKieuMay(String loaiKieuMay) {
        this.loaiKieuMay = loaiKieuMay;
    }

    public String getLoaiDayDeo() {
        return loaiDayDeo;
    }

    public void setLoaiDayDeo(String loaiDayDeo) {
        this.loaiDayDeo = loaiDayDeo;
    }

    public String getMauDayDeo() {
        return mauDayDeo;
    }

    public void setMauDayDeo(String mauDayDeo) {
        this.mauDayDeo = mauDayDeo;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public String getChuongTrinhKM() {
        return chuongTrinhKM;
    }

    public void setChuongTrinhKM(String chuongTrinhKM) {
        this.chuongTrinhKM = chuongTrinhKM;
    }

    public Double getGiaSauKM() {
        return giaSauKM;
    }

    public void setGiaSauKM(Double giaSauKM) {
        this.giaSauKM = giaSauKM;
    }
    
    
       
}
