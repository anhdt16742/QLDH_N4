Create Database DuAn1
go
Use DuAn1
go
--Màu Sắc
Create Table MauSac(
Id INT Identity(1,1) primary key,
Ten nvarchar(50) not  null
)
go
--Kích cỡ
Create Table KichCo(
Id INT Identity(1,1) primary key,
Ten nvarchar(50) not  null
)
go
--Chất liệu
Create Table ChatLieu(
Id INT Identity(1,1) primary key,
Ten nvarchar(50) not  null
)
go
--Danh Mục sản phẩm
Create Table DanhMucSP(
Id INT Identity(1,1) primary key,
Ten nvarchar(50) not null
)
go
--Thương hiệu
Create Table ThuongHieu(
Id INT Identity(1,1) primary key,
Ten nvarchar(50) not null
)
go
--Nhà sản xuất
Create Table NSX(
Id INT Identity(1,1) primary key,
Ten nvarchar(50) not null
)
go
--Chức vụ
Create Table ChucVu(
Id INT Identity(1,1) primary key,
Ten nvarchar(50) not null
)
go
--Khuyến mãi
Create Table KhuyenMai(
Id INT Identity(1,1) primary key,
Ten nvarchar(50) not null,
Ngaybatdau Date not null,
Ngayketthuc date not null,
HinhthucKM nvarchar(50) not null,
Giatrigiam decimal DEFAULT 0
)
go
--Chi tiết sản phẩm
Create Table ChitietSP(
Id INT Identity(1,1) PRIMARY KEY ,
Ma nvarchar(10) not  null,
Ten nvarchar(50) not null,
IdNsx INT foreign key references NSX(Id),
IdMauSac INT foreign key references MauSac(Id),
IdDMuc INT foreign key references DanhMucSP(Id),
IdKC INT foreign key references KichCo(Id),
IdCL INT foreign key references ChatLieu(Id),
IdTH INT foreign key references ThuongHieu(Id),
IdKM INT foreign key references KhuyenMai(Id),
MoTa NVARCHAR(50) DEFAULT NULL,
SoLuongTon INT,
GiaNhap DECIMAL(20,0) DEFAULT 0,
GiaBan DECIMAL(20,0) DEFAULT 0,
QrCode nvarchar(max) DEFAULT null
)
go
--User
Create Table Users(
Id INT Identity(1,1) PRIMARY KEY ,
Ten NVARCHAR(30) not null,
TenDem NVARCHAR(30) DEFAULT NULL,
Ho NVARCHAR(30) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
Gioitinh bit null,
Sdt VARCHAR(30) DEFAULT NULL,
IdCV INT foreign key references ChucVu(Id),
TaiKhoan VARCHAR(MAX) DEFAULT NULL,
MatKhau VARCHAR(MAX) DEFAULT NULL,
Email varchar(max) not null,
TrangThai bit DEFAULT 0
)
go
--Khách hàng
Create Table KhachHang(
Id INT Identity(1,1) PRIMARY KEY ,
Ten NVARCHAR(30) not null,
TenDem NVARCHAR(30) DEFAULT NULL,
Ho NVARCHAR(30) DEFAULT NULL,
Gioitinh bit Null,
NgaySinh DATE DEFAULT NULL,
Email varchar(max) not null,
Sdt VARCHAR(30) DEFAULT NULL,
Diemthuong int DEFAULT NULL
)
go
--Hóa đơn
Create Table HoaDon(
Id INT Identity(1,1) primary key ,
IdKH INT foreign key references KhachHang(Id),
IdNV INT foreign key references Users(Id),
Ma VARCHAR(20) UNIQUE,
NgayTao DATE DEFAULT NULL,
NgayThanhToan DATE DEFAULT NULL,
TinhTrang bit DEFAULT 0
)
go
--Hóa đơn chi tiết
Create Table HoaDonChiTiet(
IdHD int foreign key references HoaDon(Id) not null,
IdCTSP int foreign key references ChitietSP(Id) not null,
Soluong int not  null,
Dongia decimal not  null,
primary key(IdHD,IdCTSP),
Dongiakhigiam decimal not  null
)
ALTER TABLE Hoadon

ADD Ghichu varchar(255)
ALTER TABLE Khuyenmai

ADD Trangthai bit Default 0
ALTER TABLE HoaDonChiTiet

Drop COLUMN DonGiakhiGiam
ALTER TABLE Hoadon

ADD TongTien decimal


INSERT INTO Users  values('anh','tuan','do','2002/05/02',1,'0123457890',5,'user','123','anhdt@gmail.com',1)
update Users set IdCV=5 where id=12
SELECT * FROM  Users
SELECT * FROM  ChucVu
INSERT INTO ChucVu  values('quan ly'),
                         ('nhan viên')
						
INSERT INTO ChucVu  values('admin')
						 delete from ChucVu where id=2
						 update ChucVu set Ten= N'quản lý' where id=5
						 select * from KhuyenMai