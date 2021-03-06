
Create database TienQLSV		
go
Use TienQLSV
GO
CREATE TABLE Khoa
(
maKhoa NVARCHAR(5) PRIMARY KEY NOT NULL,
tenKhoa NVARCHAR(30),
tenChuNhiem NVARCHAR(50)
)
go
Create table SINHVIEN(
MaSV nvarchar(30),
HoTen nvarchar(50),
maKhoa NVARCHAR(5),
NgaySinh nvarchar(50),
GioiTinh bit,
DiaChi nvarchar(50),
constraint PK_SINHVIEN primary key (MaSV),
CONSTRAINT fk_SinhVien FOREIGN KEY(maKhoa) REFERENCES dbo.Khoa(maKhoa)
)
go
Create table BANGDIEM
(
MaSV nvarchar(30),
DiemTA float,
DiemTH float,
DiemGDQP float,
DiemTB float,
constraint PK_BANGDIEM primary key (MaSV),
Constraint FK_BANGDIEM_SINHVIEN foreign key (MaSV) references SINHVIEN(MASV),
)
go

----------------Nhập liệu---------------------

INSERT INTO dbo.Khoa
        ( maKhoa, tenKhoa,tenChuNhiem )
VALUES  ( N'TH',N'Công Nghệ Thông Tin',N'Nguyễn Mạnh Tuấn'),
		( N'KT',N'Kế Toán',N'Nguyễn Văn Linh')
--SinhVien
Insert into SINHVIEN
values('PH001',N'Nguyễn Hồng Tiến','TH','22/10/2000',1,N'Hà Nội')

Insert into SINHVIEN
values('PH002',N'Nguyễn Văn Bình','TH','07-01-1997',1,N'Thái Nguyên')

Insert into SINHVIEN
values('PH003',N'Nguyễn Văn Tiến','TH','02-01-1997',0,N'Hà Nam')

Insert into SINHVIEN
values('PH004',N'Nguyễn Văn Duy','TH','03-01-1997',1,N'Ninh Bình')

Insert into SINHVIEN
values('PH005',N'Kiều Văn Anh','TH','04-01-1997',0,N'Nam Định')

Insert into SINHVIEN
values('PH006',N'Nguyễn Vân Linh','KT','05-01-1997',1,N'Thái Bình')

--BANGDIEM

Insert into BANGDIEM
values('PH001',7,8.5,8.5,8)


Insert into BANGDIEM
values('PH002',5,9,8,7.3)


Insert into BANGDIEM
values('PH003',0,5,8,4.3)


Insert into BANGDIEM
values('PH004',9,7,10,8.7)


Insert into BANGDIEM
values('PH005',7,5,6,6)


----select bảng
select * from SinhVien
select * from BangDiem
SELECT * FROM dbo.Khoa
 
CREATE VIEW viewDiem AS 
SELECT BD.MaSV,SV.HoTen,SV.maKhoa,BD.DiemTA,BD.DiemTH,BD.DiemGDQP,BD.DiemTB FROM dbo.SINHVIEN AS SV JOIN dbo.BANGDIEM AS BD ON SV.MaSV = BD.MaSV
SELECT * FROM viewDiem
SELECT TOP 3 BANGDIEM.MASV,dbo.SINHVIEN.HoTen,DIEMTB FROM BANGDIEM JOIN SINHVIEN ON SINHVIEN.MASV=BANGDIEM.MASV ORDER BY DIEMTB DESC
SELECT COUNT(MaSV) FROM dbo.BANGDIEM WHERE MaSV = 'PH001'