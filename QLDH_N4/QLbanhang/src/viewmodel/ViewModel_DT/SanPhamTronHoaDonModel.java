package viewmodel.ViewModel_DT;

public class SanPhamTronHoaDonModel {

    private Integer idChiTietDH;
    private String tenDongHo;
    private String gioiTinhDH;
    private String loaiKieuMay;
    private String kieuDayDeo;
    private Double duongKinh;
    private Double giaNhap;
    private Double giaBan;
    private Integer soLuong;
    private String hinhThucKhuyenMai;
    private Double giaGiam;

    public SanPhamTronHoaDonModel() {
    }

    public SanPhamTronHoaDonModel(Integer idChiTietDH, String tenDongHo, String gioiTinhDH, String loaiKieuMay, String kieuDayDeo, Double duongKinh, Double giaBan, Integer soLuong, String hinhThucKhuyenMai, Double giaGiam) {
        this.idChiTietDH = idChiTietDH;
        this.tenDongHo = tenDongHo;
        this.gioiTinhDH = gioiTinhDH;
        this.loaiKieuMay = loaiKieuMay;
        this.kieuDayDeo = kieuDayDeo;
        this.duongKinh = duongKinh;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.hinhThucKhuyenMai = hinhThucKhuyenMai;
        this.giaGiam = giaGiam;
    }

    public SanPhamTronHoaDonModel(Integer idChiTietDH, String tenDongHo, String gioiTinhDH, String loaiKieuMay, String kieuDayDeo, Double duongKinh, Double giaNhap, Double giaBan, Integer soLuong, String hinhThucKhuyenMai, Double giaGiam) {
        this.idChiTietDH = idChiTietDH;
        this.tenDongHo = tenDongHo;
        this.gioiTinhDH = gioiTinhDH;
        this.loaiKieuMay = loaiKieuMay;
        this.kieuDayDeo = kieuDayDeo;
        this.duongKinh = duongKinh;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.hinhThucKhuyenMai = hinhThucKhuyenMai;
        this.giaGiam = giaGiam;
    }

    
    public Integer getIdChiTietDH() {
        return idChiTietDH;
    }

    public void setIdChiTietDH(Integer idChiTietDH) {
        this.idChiTietDH = idChiTietDH;
    }

    public String getTenDongHo() {
        return tenDongHo;
    }

    public void setTenDongHo(String tenDongHo) {
        this.tenDongHo = tenDongHo;
    }

    public String getGioiTinhDH() {
        return gioiTinhDH;
    }

    public void setGioiTinhDH(String gioiTinhDH) {
        this.gioiTinhDH = gioiTinhDH;
    }

    public String getLoaiKieuMay() {
        return loaiKieuMay;
    }

    public void setLoaiKieuMay(String loaiKieuMay) {
        this.loaiKieuMay = loaiKieuMay;
    }

    public String getKieuDayDeo() {
        return kieuDayDeo;
    }

    public void setKieuDayDeo(String kieuDayDeo) {
        this.kieuDayDeo = kieuDayDeo;
    }

    public Double getDuongKinh() {
        return duongKinh;
    }

    public void setDuongKinh(Double duongKinh) {
        this.duongKinh = duongKinh;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    
    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getHinhThucKhuyenMai() {
        return hinhThucKhuyenMai;
    }

    public void setHinhThucKhuyenMai(String hinhThucKhuyenMai) {
        this.hinhThucKhuyenMai = hinhThucKhuyenMai;
    }

    public Double getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(Double giaGiam) {
        this.giaGiam = giaGiam;
    }
  
     public Object[]toDataRow1(){
      return new Object[]{tenDongHo,soLuong,giaNhap,giaBan,hinhThucKhuyenMai,giaGiam};
  }
}
