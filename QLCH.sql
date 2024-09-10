--alter session set "_ORACLE_SCRIPT" =TRUE; 
--create user QLCH identified by QLCH;
--grant all privileges to QLCH;
--grant DBA to QLCH;
--/
--set autocommit on
--set autocommit off
--set transaction isolation level serializable;
--set transaction isolation level read committed;


--drop table NHANVIEN CASCADE CONSTRAINTS;
--drop table KHACHHANG CASCADE CONSTRAINTS;
--drop table HOADON CASCADE CONSTRAINTS;
--drop table NHACUNGCAP CASCADE CONSTRAINTS;
--drop table CTHOADON CASCADE CONSTRAINTS;
--drop table CTPHIEUNHAP CASCADE CONSTRAINTS;
--drop table PHIEUNHAP CASCADE CONSTRAINTS;
--drop table SANPHAM CASCADE CONSTRAINTS;
--drop table PHANQUYEN CASCADE CONSTRAINTS;
--drop table TAIKHOAN CASCADE CONSTRAINTS;
--/



--Nhan Vien
CREATE TABLE NHANVIEN (
    MaNV NUMBER(11) NOT NULL,
    Ho VARCHAR2(200) NOT NULL,
    Ten VARCHAR2(200) NOT NULL,
    GioiTinh VARCHAR2(11) NOT NULL,
    ChucVu VARCHAR2(200) NOT NULL,
    NgayBD DATE NOT NULL,
    NgaySinh DATE NOT NULL
);

INSERT ALL
    INTO NHANVIEN (MaNV, Ho, Ten, GioiTinh, ChucVu, NgayBD, NgaySinh) VALUES (1, 'Admin', ' ', ' ', 'Admin',TO_DATE('2024-01-05', 'YYYY-MM-DD'), TO_DATE('2000-01-01', 'YYYY-MM-DD'))
    INTO NHANVIEN (MaNV, Ho, Ten, GioiTinh, ChucVu, NgayBD, NgaySinh) VALUES (0434342411, 'Sau Dai', 'Phat', 'Nam', 'Quan Ly', TO_DATE('2024-01-05', 'YYYY-MM-DD'), TO_DATE('1980-03-15', 'YYYY-MM-DD'))
    INTO NHANVIEN (MaNV, Ho, Ten, GioiTinh, ChucVu, NgayBD, NgaySinh) VALUES (0543844342, 'Tran Quang', 'Vinh', 'Nam', 'Quan Ly', TO_DATE('2024-01-05', 'YYYY-MM-DD'), TO_DATE('1975-06-20', 'YYYY-MM-DD'))
    INTO NHANVIEN (MaNV, Ho, Ten, GioiTinh, ChucVu, NgayBD, NgaySinh) VALUES (0184342343, 'Tran Huu', 'Khuong', 'Nam', 'Quan Ly', TO_DATE('2024-01-05', 'YYYY-MM-DD'), TO_DATE('1988-11-30', 'YYYY-MM-DD'))
    INTO NHANVIEN (MaNV, Ho, Ten, GioiTinh, ChucVu, NgayBD, NgaySinh) VALUES (0953742344, 'Nhu Quoc Anh', 'Tai', 'Nam', 'Nhan Vien', TO_DATE('2024-01-05', 'YYYY-MM-DD'), TO_DATE('1990-05-22', 'YYYY-MM-DD'))
    INTO NHANVIEN (MaNV, Ho, Ten, GioiTinh, ChucVu, NgayBD, NgaySinh) VALUES (0934843912, 'Trinh Thu', 'Huyen', 'Nu', 'Nhan Vien', TO_DATE('2024-01-05', 'YYYY-MM-DD'),TO_DATE('1995-07-18', 'YYYY-MM-DD'))
    INTO NHANVIEN (MaNV, Ho, Ten, GioiTinh, ChucVu, NgayBD, NgaySinh) VALUES (0458348313, 'Nguyen Ngoc Mai', 'Linh', 'Nu', 'Nhan Vien',TO_DATE('2024-01-05', 'YYYY-MM-DD'), TO_DATE('1993-02-12', 'YYYY-MM-DD'))
    INTO NHANVIEN (MaNV, Ho, Ten, GioiTinh, ChucVu, NgayBD, NgaySinh) VALUES (0923483414, 'Ha Van', 'Hung', 'Nam', 'Nhan Vien', TO_DATE('2024-01-05', 'YYYY-MM-DD'), TO_DATE('1987-09-09', 'YYYY-MM-DD'))
    INTO NHANVIEN (MaNV, Ho, Ten, GioiTinh, ChucVu, NgayBD, NgaySinh) VALUES (0384234315, 'Le Thi Thuy', 'Diem', 'Nu', 'Quan Ly', TO_DATE('2024-01-05', 'YYYY-MM-DD'),  TO_DATE('1982-12-25', 'YYYY-MM-DD'))
SELECT * FROM dual;
/

--Nha cung cap
CREATE TABLE NHACUNGCAP (
    MaNCC NUMBER(11) NOT NULL,
    TenNCC VARCHAR2(200) NOT NULL,
    DiaChi VARCHAR2(200) NOT NULL,
    DienThoai VARCHAR2(200) NOT NULL
);

INSERT ALL
    INTO NHACUNGCAP (MaNCC, TenNCC, DiaChi, DienThoai) VALUES (0396527908, 'Cong ty thuc pham sach Khanh Toan', '273 An Duong Vuong, phuong 3, quan 5, TP.HCM', '0396527908')
    INTO NHACUNGCAP (MaNCC, TenNCC, DiaChi, DienThoai) VALUES (0902669733, 'Cong ty giai khat Tuong Vy', '12/49/2 Vo Van Kiet, P. Co Giang, Q1', '0902669733')
    INTO NHACUNGCAP (MaNCC, TenNCC, DiaChi, DienThoai) VALUES (0397682193, 'Cong ty banh keo Viet Hoang', '492 Xo Viet Nghe Tinh, P.25, Q. Binh Thanh', '0397682193')
SELECT * FROM dual;
/

--San pham
CREATE TABLE SANPHAM (
    MaSP NUMBER(11) NOT NULL,
    TenSP VARCHAR2(200) NOT NULL,
    Loai VARCHAR2(200) NOT NULL,
    SoLuong NUMBER(11) NOT NULL,
    DonViTinh VARCHAR2(200),
    HinhAnh VARCHAR2(200),
    DonGia NUMBER(11) NOT NULL
);

INSERT ALL
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (111, 'Pizza Hai San', 'Mon Chinh', 31, 'Cai', 'monchinh0.png', 169000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (112, 'Com Ca Ri Bo', 'Mon Chinh', 39, 'Dia', 'monchinh1.png', 129000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (113, 'Com Teriyaki', 'Mon Chinh', 34, 'Dia', 'monchinh2.png', 119000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (114, 'Pizza Tom Cocktail', 'Mon Chinh', 36, 'Cai', 'monchinh3.png', 159000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (115, 'Burger Zinger', 'Mon Chinh', 38, 'Cai', 'monchinh4.png', 119000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (116, 'Pasta Popcorn', 'Mon Chinh', 39, 'Dia', 'monchinh5.png', 130000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (117, 'Pizza Thit Nguoi', 'Mon Chinh', 34, 'Cai', 'monchinh6.png', 149000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (118, 'Salad Hat', 'Mon Phu', 35, 'Cai', 'monphu0.png', 129000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (119, 'Salad Pop', 'Mon Phu', 13, 'Thanh', 'monphu1.jpg', 239000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (120, 'Fishsticks', 'Mon Phu', 37, 'Thanh', 'monphu2.jpg', 239000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (121, 'Chewy Cheese', 'Mon Phu', 41, 'Vien', 'monphu3.jpg', 229000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (122, 'French Fries', 'Mon Phu', 43, 'Cai', 'monphu4.jpg', 249000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (123, 'Seaweed Soup', 'Mon Phu', 33, 'Chen', 'monphu5.jpg', 269000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (124, 'Pepsi lon 330ml', 'Nuoc Uong', 150, 'Lon', 'nuocuong0.jpeg', 19000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (125, 'Pepsi chai 1.5l', 'Nuoc Uong', 250, 'Chai', 'nuocuong1.jpeg', 29000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (126, '7Up lon 330ml', 'Nuoc Uong', 150, 'Lon', 'nuocuong2.jpeg', 19000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (127, '7Up chai 1.5l', 'Nuoc Uong', 110, 'Chai', 'nuocuong3.jpeg', 29000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (128, 'Pepsi no calories 330ml', 'Nuoc Uong', 180, 'Lon', 'nuocuong4.jpg', 19000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (129, 'Mirinda cam 330ml', 'Nuoc Uong', 100, 'Lon', 'nuocuong5.jpg', 19000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (130, 'Mirinda kem soda 330ml', 'Nuoc Uong', 80, 'Lon', 'nuocuong6.jpg', 19000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (131, 'Nuoc suoi Aquafina', 'Nuoc Uong', 52, 'Chai', 'nuocuong7.jpg', 10000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (132, 'Tra sua tra den', 'Nuoc Uong', 6, 'Ly', 'nuocuong8.jpg', 25000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (135, 'Dui ga ran sot me', 'Mon Chinh', 100, 'Goi', 'default.png', 10000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (136, 'Uc ga ran sot cay', 'Mon Chinh', 200, 'Hop', 'default.png', 23000)
    INTO SANPHAM (MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (137, 'Ga vien lac pho mai', 'Mon Chinh', 80, 'Hop', 'default.png', 84500)
SELECT * FROM dual;
/

--Khach hang
CREATE TABLE KHACHHANG (
    MaKH NUMBER(11) NOT NULL,
    Ho VARCHAR2(200) NOT NULL,
    Ten VARCHAR2(200) NOT NULL,
    GioiTinh VARCHAR2(11) NOT NULL,
    TongChiTieu NUMBER(11) DEFAULT 0 NOT NULL
);

INSERT ALL
    INTO KHACHHANG (MaKH, Ho, Ten, GioiTinh, TongChiTieu) VALUES (0, 'NULL', 'NULL', 'NULL', 0)
    INTO KHACHHANG (MaKH, Ho, Ten, GioiTinh, TongChiTieu) VALUES (0424524361, 'Nguyen Van', 'An', 'Nam', 1486400)
    INTO KHACHHANG (MaKH, Ho, Ten, GioiTinh, TongChiTieu) VALUES (0832473532, 'Tran Ngoc', 'Binh', 'Nu', 1497300)
    INTO KHACHHANG (MaKH, Ho, Ten, GioiTinh, TongChiTieu) VALUES (0642843433, 'Le Thi', 'Giai', 'Nu', 1468800)
    INTO KHACHHANG (MaKH, Ho, Ten, GioiTinh, TongChiTieu) VALUES (0795347234, 'Ha Thanh', 'Thoat', 'Nam', 1013600)
    INTO KHACHHANG (MaKH, Ho, Ten, GioiTinh, TongChiTieu) VALUES (0385495437, 'Trinh Thi', 'Yen', 'Nu', 3219700)
    INTO KHACHHANG (MaKH, Ho, Ten, GioiTinh, TongChiTieu) VALUES (0892749938, 'Truong Dinh', 'Vui', 'Nam', 1877000)
    INTO KHACHHANG (MaKH, Ho, Ten, GioiTinh, TongChiTieu) VALUES (0283435849, 'Lai Thi Ngoc', 'Mien', 'Nu', 5743500)
    INTO KHACHHANG (MaKH, Ho, Ten, GioiTinh, TongChiTieu) VALUES (0184955210, 'Tran Quang', 'Cuc', 'Nam', 3136800)
    INTO KHACHHANG (MaKH, Ho, Ten, GioiTinh, TongChiTieu) VALUES (0829434211, 'Nguyen Ngoc', 'Lac', 'Nam', 2260300)
SELECT * FROM dual;
/

--Hoa don
CREATE TABLE HOADON (
    MaHD NUMBER(11) NOT NULL,
    MaKH NUMBER(11) NOT NULL,
    MaNV NUMBER(11) NOT NULL,
    NgayLap DATE NOT NULL,
    TongTien NUMBER(11) NOT NULL,
    GhiChu VARCHAR2(200) NOT NULL
);
 
INSERT ALL
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (18, 0795347234, 0184342343, DATE '2021-01-18', 1013600, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (19, 0424524361, 0434342411, DATE '2021-01-20', 482400, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (20, 0832473532, 0934843912, DATE '2021-01-28', 840000, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (21, 0184955210, 0543844342, DATE '2021-02-07', 1045600, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (22, 0424524361, 0434342411, DATE '2021-02-14', 1004000, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (23, 0385495437, 0458348313, DATE '2021-02-16', 576800, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (24, 0385495437, 0543844342, DATE '2021-03-08', 601300, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (25, 0832473532, 0543844342, DATE '2021-03-09', 391300, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (26, 0892749938, 0923483414, DATE '2021-03-12', 1286600, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (27, 0892749938, 0184342343, DATE '2021-03-24', 590400, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (28, 0385495437, 0953742344, DATE '2021-02-04', 2041600, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (29, 0283435849, 0543844342, DATE '2021-04-10', 633500, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (30, 0184955210, 0953742344, DATE '2021-04-15', 3136800, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (31, 0829434211, 0953742344, DATE '2021-05-02', 782600, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (32, 0829434211, 1, DATE '2021-05-03', 1477700, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (33, 0283435849, 1, DATE '2021-05-06', 5110000, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (35, 0642843433, 1, DATE '2021-05-08', 304200, 'Hoan tat')
    INTO HOADON (MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES (37, 0832473532, 1, DATE '2021-05-08', 117000, 'Hoan tat')
SELECT * FROM dual;
/

--Chi tiet hoa don
CREATE TABLE CTHOADON (
    MaHD NUMBER(11) NOT NULL,
    MaSP NUMBER(11) NOT NULL,
    SoLuong NUMBER(11) NOT NULL,
    DonGia NUMBER(11) NOT NULL,
    ThanhTien NUMBER(11) NOT NULL
);

INSERT ALL
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (18, 114, 2, 159000, 318000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (18, 122, 3, 249000, 747000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (18, 124, 6, 19000, 114000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (18, 130, 2, 19000, 38000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (18, 132, 2, 25000, 50000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (19, 115, 2, 119000, 238000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (19, 120, 1, 239000, 239000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (19, 128, 4, 19000, 76000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (19, 131, 5, 10000, 50000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (20, 118, 1, 129000, 129000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (20, 120, 2, 239000, 478000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (20, 129, 5, 19000, 38000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (20, 130, 5, 19000, 95000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (20, 131, 10, 10000, 100000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (21, 112, 3, 129000, 387000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (21, 117, 2, 149000, 298000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (21, 126, 10, 19000, 190000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (21, 127, 3, 29000, 87000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (21, 128, 15, 19000, 285000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (21, 131, 6, 10000, 60000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (22, 114, 5, 159000, 795000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (22, 127, 10, 29000, 290000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (22, 129, 6, 19000, 95000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (22, 132, 3, 25000, 75000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (23, 112, 3, 129000, 387000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (23, 113, 1, 119000, 119000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (23, 118, 1, 129000, 129000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (23, 128, 6, 19000, 114000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (23, 131, 5, 10000, 50000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (23, 132, 2, 25000, 25000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (24, 115, 1, 119000, 119000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (24, 116, 1, 130000, 130000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (24, 119, 1, 239000, 239000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (24, 126, 6, 19000, 114000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (24, 127, 3, 29000, 87000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (24, 131, 7, 10000, 70000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (24, 132, 4, 25000, 100000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (25, 118, 1, 129000, 129000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (25, 121, 1, 229000, 229000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (25, 130, 4, 19000, 76000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (25, 131, 5, 10000, 50000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (25, 132, 3, 25000, 75000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (26, 111, 3, 169000, 507000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (26, 120, 3, 239000, 717000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (26, 122, 2, 249000, 498000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (26, 127, 4, 29000, 116000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (27, 113, 1, 119000, 119000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (27, 119, 1, 239000, 239000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (27, 123, 1, 269000, 269000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (27, 126, 1, 19000, 19000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (27, 131, 1, 10000, 10000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (28, 113, 10, 119000, 1190000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (28, 116, 4, 130000, 520000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (28, 119, 3, 239000, 717000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (28, 132, 5, 25000, 125000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (29, 114, 4, 159000, 636000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (29, 115, 1, 119000, 119000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (29, 116, 1, 130000, 130000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (29, 131, 2, 10000, 20000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (30, 116, 1, 130000, 130000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (30, 117, 7, 149000, 1043000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (30, 123, 10, 269000, 2690000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (30, 125, 1, 29000, 29000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (30, 127, 2, 29000, 29000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (31, 111, 1, 169000, 169000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (31, 115, 6, 119000, 595000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (31, 117, 1, 149000, 149000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (31, 118, 1, 129000, 129000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (31, 130, 4, 19000, 76000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (32, 120, 5, 239000, 1195000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (32, 121, 4, 229000, 916000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (33, 116, 1, 130000, 130000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (33, 119, 30, 239000, 7170000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (35, 113, 1, 119000, 119000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (35, 117, 1, 149000, 149000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (35, 131, 8, 10000, 70000)
    INTO CTHOADON (MaHD, MaSP, SoLuong, DonGia, ThanhTien) VALUES (37, 116, 1, 130000, 130000)
SELECT * FROM dual;
/

--Phieu nhap
CREATE TABLE PHIEUNHAP (
    MaPN NUMBER(11) NOT NULL,
    MaNCC NUMBER(11) NOT NULL,
    MaNV NUMBER(11) NOT NULL,
    NgayLap DATE NOT NULL,
    TongTien NUMBER(11) NOT NULL
);

INSERT ALL
    INTO PHIEUNHAP (MaPN, MaNCC, MaNV, NgayLap, TongTien) VALUES (4, 0902669733, 1, DATE '2021-04-19', 1027000)
    INTO PHIEUNHAP (MaPN, MaNCC, MaNV, NgayLap, TongTien) VALUES (5, 0902669733, 1, DATE '2021-04-23', 268000)
    INTO PHIEUNHAP (MaPN, MaNCC, MaNV, NgayLap, TongTien) VALUES (7, 0902669733, 1, DATE '2021-04-26', 90000)
    INTO PHIEUNHAP (MaPN, MaNCC, MaNV, NgayLap, TongTien) VALUES (8, 0902669733, 1, DATE '2021-05-02', 1070000)
    INTO PHIEUNHAP (MaPN, MaNCC, MaNV, NgayLap, TongTien) VALUES (9, 0396527908, 1, DATE '2021-05-04', 1000000)
    INTO PHIEUNHAP (MaPN, MaNCC, MaNV, NgayLap, TongTien) VALUES (10,0397682193, 1, DATE '2021-05-07', 11360000)
SELECT * FROM dual;
/

--Chi tiet phieu nhap
CREATE TABLE CTPHIEUNHAP (
    MaPN NUMBER(11) NOT NULL,
    MaSP NUMBER(11) NOT NULL,
    SoLuong NUMBER(11) NOT NULL,
    DonGia NUMBER(11) NOT NULL,
    ThanhTien NUMBER(11) NOT NULL
);

INSERT ALL
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (4, 128, 100, 10000, 1000000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (4, 129, 3, 9000, 27000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (5, 124, 6, 10000, 60000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (5, 125, 3, 15000, 45000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (5, 126, 7, 10000, 70000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (5, 127, 2, 15000, 30000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (5, 130, 3, 9000, 27000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (5, 131, 9, 4000, 36000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (7, 126, 9, 10000, 90000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (8, 124, 30, 10000, 300000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (8, 126, 50, 10000, 500000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (8, 129, 30, 9000, 270000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (9, 135, 100, 10000, 1000000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (10, 136, 200, 23000, 4600000)
    INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien) VALUES (10, 137, 80, 84500, 6760000)
SELECT * FROM dual;
/

--Quyen
CREATE TABLE PHANQUYEN (
    Quyen varchar2(200) NOT NULL,
    NhapHang NUMBER(1) NOT NULL,
    QLSANPHAM NUMBER(1) NOT NULL,
    QLNHANVIEN NUMBER(1) NOT NULL,
    QLKHACHHANG NUMBER(1) NOT NULL,
    ThongKe NUMBER(1) NOT NULL
);

INSERT ALL
    INTO PHANQUYEN (Quyen, NhapHang, QLSANPHAM, QLNHANVIEN, QLKHACHHANG, ThongKe) VALUES ('Default', 0, 0, 0, 0, 0)
    INTO PHANQUYEN (Quyen, NhapHang, QLSANPHAM, QLNHANVIEN, QLKHACHHANG, ThongKe) VALUES ('Nhan Vien', 0, 0, 0, 1, 0)
    INTO PHANQUYEN (Quyen, NhapHang, QLSANPHAM, QLNHANVIEN, QLKHACHHANG, ThongKe) VALUES ('Quan Ly', 1, 1, 1, 1, 1)
    INTO PHANQUYEN (Quyen, NhapHang, QLSANPHAM, QLNHANVIEN, QLKHACHHANG, ThongKe) VALUES ('Admin', 1, 1, 1, 1, 1)
SELECT * FROM dual;
/

--Tai khoan
CREATE TABLE TAIKHOAN (
    MaNV NUMBER(11) NOT NULL,
    TenDangNhap VARCHAR2(200) NOT NULL,
    MatKhau VARCHAR2(200) NOT NULL,
    Quyen VARCHAR2(200) NOT NULL
);

INSERT ALL
    INTO TAIKHOAN (MaNV, TenDangNhap, MatKhau, Quyen) VALUES (1, 'admin', 'admin', 'Admin')
    INTO TAIKHOAN (MaNV, TenDangNhap, MatKhau, Quyen) VALUES (0434342411, 'ql2', 'ql2', 'Quan Ly')
    INTO TAIKHOAN (MaNV, TenDangNhap, MatKhau, Quyen) VALUES (0543844342, 'ql1', 'ql1', 'Quan Ly')
    INTO TAIKHOAN (MaNV, TenDangNhap, MatKhau, Quyen) VALUES (0184342343, 'ql3', 'ql3', 'Quan Ly')
    INTO TAIKHOAN (MaNV, TenDangNhap, MatKhau, Quyen) VALUES (0953742344, 'nv1', 'nv1', 'Nhan Vien')
SELECT * FROM dual;
/

ALTER TABLE sanpham
ADD CONSTRAINT check_soluong_positive CHECK (soluong >= 0);

ALTER TABLE KHACHHANG
ADD CONSTRAINT KHACHHANG_pk PRIMARY KEY (MaKH);

ALTER TABLE NHACUNGCAP
ADD CONSTRAINT NHACUNGCAP_pk PRIMARY KEY (MaNCC);

ALTER TABLE NHANVIEN
ADD CONSTRAINT NHANVIEN_pk PRIMARY KEY (MaNV);

ALTER TABLE PHANQUYEN
ADD CONSTRAINT PHANQUYEN_pk PRIMARY KEY (Quyen);

ALTER TABLE SANPHAM
ADD CONSTRAINT SANPHAM_pk PRIMARY KEY (MaSP);

ALTER TABLE HOADON
ADD CONSTRAINT HOADON_pk PRIMARY KEY (MaHD);

ALTER TABLE HOADON
ADD CONSTRAINT HOADON_fk_NHANVIEN FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV) 
--ON DELETE CASCADE
;

ALTER TABLE HOADON
ADD CONSTRAINT HOADON_fk_KHACHHANG FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MaKH) 
ON DELETE CASCADE
;

ALTER TABLE CTHOADON
ADD CONSTRAINT CTHOADON_pk PRIMARY KEY (MaHD, MaSP);

ALTER TABLE CTHOADON
ADD CONSTRAINT CTHOADON_fk_HOADON FOREIGN KEY (MaHD) REFERENCES HOADON(MaHD) 
ON DELETE CASCADE
;

ALTER TABLE CTHOADON
ADD CONSTRAINT CTHOADON_fk_SANPHAM FOREIGN KEY (MaSP) REFERENCES SANPHAM(MaSP) 
ON DELETE CASCADE
;

ALTER TABLE PHIEUNHAP
ADD CONSTRAINT PHIEUNHAP_pk PRIMARY KEY (MaPN);

ALTER TABLE PHIEUNHAP
ADD CONSTRAINT PHIEUNHAP_fk_NHACUNGCAP FOREIGN KEY (MaNCC) REFERENCES NHACUNGCAP(MaNCC) 
ON DELETE CASCADE
;

ALTER TABLE PHIEUNHAP
ADD CONSTRAINT PHIEUNHAP_fk_NHANVIEN FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV) 
ON DELETE CASCADE
;
  
ALTER TABLE CTPHIEUNHAP
ADD CONSTRAINT CTPHIEUNHAP_pk PRIMARY KEY (MaPN, MaSP);

ALTER TABLE CTPHIEUNHAP
ADD CONSTRAINT CTPHIEUNHAP_fk_PHIEUNHAP FOREIGN KEY (MaPN) REFERENCES PHIEUNHAP(MaPN) 
ON DELETE CASCADE
;

ALTER TABLE CTPHIEUNHAP
ADD CONSTRAINT CTPHIEUNHAP_fk_SANPHAM FOREIGN KEY (MaSP) REFERENCES SANPHAM(MaSP) 
ON DELETE CASCADE
;

ALTER TABLE TAIKHOAN
ADD CONSTRAINT TAIKHOAN_pk PRIMARY KEY (MaNV);

ALTER TABLE TAIKHOAN
ADD CONSTRAINT TAIKHOAN_fk_NHANVIEN FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV) 
ON DELETE CASCADE
;

ALTER TABLE TAIKHOAN
ADD CONSTRAINT TAIKHOAN_fk_PHANQUYEN FOREIGN KEY (Quyen) REFERENCES PHANQUYEN(Quyen) 
ON DELETE CASCADE
;
/

--==============================================================================
--NHANVIEN.NgayBD <= HOADON.NgayLap (1)
CREATE OR REPLACE TRIGGER 
    TRG_NgayBD_NgayLapHD_NHANVIEN_ins_up
BEFORE INSERT OR UPDATE OF NgayBD ON NHANVIEN
FOR EACH ROW 
DECLARE    
    cursor curNGLAP is select NgayLap from HOADON where MANV= :new.MANV;    
    v_NGAYLAP date; 
BEGIN    
    OPEN curNGLAP;    
    LOOP
    FETCH curNGLAP into v_NGAYLAP;    
    EXIT WHEN curNGLAP%NOTFOUND;        
    if (v_NGAYLAP < :new.NGAYBD) then                                     
        raise_application_error(-20001, 'Ngay bat dau lam khong hop le');        
    end if;
    END LOOP;
    CLOSE curNGLAP;
END;
/


--==============================================================================
--NHANVIEN.NgayBD <= HOADON.NgayLap (2)
CREATE OR REPLACE TRIGGER 
    TRG_NgayBD_NgayLapHD_HOADON_ins_up 
BEFORE INSERT OR UPDATE OF MaNV, NgayLap on HOADON
FOR EACH ROW 
DECLARE    
    cursor curNGBD is select NgayBD from NHANVIEN 
    where MANV= :new.MANV;    
    v_NgayBD date; 
BEGIN    
    OPEN curNGBD;    
    LOOP
    FETCH curNGBD into v_NgayBD;        
    EXIT WHEN curNGBD%NOTFOUND;        
    if (v_NgayBD > :new.NgayLap) then                                     
        raise_application_error(-20001, 'NgayBD khong hop le');        
    end if;
    END LOOP;
END;
/


--==============================================================================
--NHANVIEN.NgayBD <= PHIEUNHAP.NgayLap
CREATE OR REPLACE TRIGGER 
    TRG_NgayBD_NgayLapPN_PHIEUNHAP_in_up
BEFORE INSERT OR UPDATE OF MaNV, NgayLap on PHIEUNHAP
FOR EACH ROW 
DECLARE    
 cursor curNgayBD is select NgayBD from NHANVIEN 
 where MaNV = :new.MaNV;    
 v_NgayBD date; 
BEGIN    
    open curNgayBD;    
    LOOP
        FETCH curNgayBD into v_NgayBD;        
        EXIT WHEN curNgayBD%NOTFOUND;        
        if (:new.NgayLap < v_NgayBD)then                                     
           raise_application_error(-20001, 'NgayLap khong hop le');        
        end if;
    END LOOP;
    CLOSE curNgayBD;
END;
/


--==============================================================================
--NHANVIEN phai du 18 tuoi
CREATE OR REPLACE TRIGGER TRG_Tuoi_NHANVIEN
BEFORE INSERT ON NHANVIEN
FOR EACH ROW
DECLARE
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, :NEW.NgaySinh) / 12);
    
    IF v_age < 18 THEN
        RAISE_APPLICATION_ERROR(-20001,'Nhan vien chua du 18 tuoi.');
    END IF;
END;
/


--==============================================================================
--SANPHAM co so luong lon hon 0 khong the xoa
CREATE OR REPLACE TRIGGER TRG_SoLuong_SANPHAM_1
BEFORE DELETE ON SANPHAM
FOR EACH ROW
BEGIN
    IF :OLD.SoLuong > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'So luong lon hon 0 nen khong xoa duoc.');
    END IF;
END;
/


--==============================================================================
----Da tao constrain nen chac khong can trigger nay nua
----SANPHAM khong duoc co so luong nho hon 0
--CREATE OR REPLACE TRIGGER TRG_SoLuong_SANPHAM_2
--BEFORE INSERT OR UPDATE ON CTHOADON
--FOR EACH ROW
--DECLARE
--    v_soluong SANPHAM.SoLuong%TYPE;
--BEGIN
--    SELECT SoLuong into v_soluong from SANPHAM where MaSP = :new.MaSP;
--    IF v_soluong < :new.SoLuong THEN
--        RAISE_APPLICATION_ERROR(-20001, 'So luong khong duoc be hon 0');
--    END IF;
--END;
--/

--==============================================================================
--CTPHIEUNHAP.DonGia <= HOADON.DonGia
CREATE OR REPLACE TRIGGER 
    TRG__DonGia_CTPHIEUNHAP_ins_up
BEFORE INSERT OR UPDATE OF DonGia ON CTPHIEUNHAP
FOR EACH ROW
DECLARE
    cursor curDonGia is select DonGia from SANPHAM where MaSP= :new.MaSP;    
    v_DonGia number; 
BEGIN
    OPEN curDonGia;
    LOOP
         FETCH curDonGia into v_DonGia;
         EXIT WHEN curDonGia%NOTFOUND;
    IF (:new.DonGia > v_DonGia) THEN         
         raise_application_error(-20009, 'DonGia khong phu hop');
    END IF;
    END LOOP;
    CLOSE curDonGia;
END;
/


--==============================================================================
--Tinh tong tien cho HOADON khi them CTHOADON
CREATE OR REPLACE TRIGGER TRG_Update_TongTien_HOADON
FOR INSERT OR DELETE OR UPDATE ON CTHOADON
COMPOUND TRIGGER
    --con tro khong tuong minh
    TYPE cur_cthoadon_type IS REF CURSOR;
    cur_cthoadon cur_cthoadon_type;

    --luu gia tri con tro
    v_MaHD number;
    v_TongTien number;

    AFTER STATEMENT IS
    BEGIN
        OPEN cur_cthoadon FOR
            SELECT MaHD, SUM(ThanhTien) AS tongtien
            FROM CTHOADON
            GROUP BY MaHD;

        LOOP
            FETCH cur_cthoadon INTO v_MaHD, v_TongTien;
            EXIT WHEN cur_cthoadon%NOTFOUND;

            --cap nhat tong tien tung hoa don
            UPDATE HOADON
            SET TongTien = v_TongTien
            WHERE MaHD = v_MaHD;
        END LOOP;

        CLOSE cur_cthoadon;
    END AFTER STATEMENT;
END;
/


--==============================================================================
--Tinh tong tien cho PHIEUNHAP khi them CTPHIEUNHAP
CREATE OR REPLACE TRIGGER TRG_Update_TongTien_PHIEUNHAP
FOR INSERT OR DELETE OR UPDATE ON CTPHIEUNHAP
COMPOUND TRIGGER
    --con tro khong tuong minh
    TYPE cur_ctphieunhap_type IS REF CURSOR;
    cur_ctphieunhap cur_ctphieunhap_type;

    --luu gia tri con tro
    v_MaPN number;
    v_TongTien number;

    AFTER STATEMENT IS
    BEGIN
        OPEN cur_ctphieunhap FOR
            SELECT MaPN, SUM(ThanhTien) AS tongtien
            FROM CTPHIEUNHAP
            GROUP BY MaPN;

        LOOP
            FETCH cur_ctphieunhap INTO v_MaPN, v_TongTien;
            EXIT WHEN cur_ctphieunhap%NOTFOUND;

            --cap nhat tong tien tung phieu nhap
            UPDATE PHIEUNHAP
            SET TongTien = v_TongTien
            WHERE MaPN = v_MaPN;
        END LOOP;

        CLOSE cur_ctphieunhap;
    END AFTER STATEMENT;

END;
/


--==============================================================================
--Tinh chi tieu cho KHACHHANG khi them HOADON
CREATE OR REPLACE TRIGGER TRG_Update_TongChiTieu_KHACHHANG
FOR INSERT OR DELETE OR UPDATE ON HOADON
COMPOUND TRIGGER
    --con tro khong tuong minh
    TYPE cur_hoadon_type IS REF CURSOR;
    cur_hoadon cur_hoadon_type;

    --luu gia tri con tro
    v_MaKH number;
    v_TongChiTieu number;

    AFTER STATEMENT IS
    BEGIN
        OPEN cur_hoadon FOR
            SELECT MaKH, SUM(TongTien) AS tongchitieu
            FROM HOADON
            GROUP BY MaKH;

        LOOP
            FETCH cur_hoadon INTO v_MaKH, v_TongChiTieu;
            EXIT WHEN cur_hoadon%NOTFOUND;

            --cap nhat tong chi tieu cho tung khach
            UPDATE KHACHHANG
            SET TongChiTieu = v_TongChiTieu
            WHERE MaKH = v_MaKH;
        END LOOP;

        CLOSE cur_hoadon;
    END AFTER STATEMENT;

END;
/


--==============================================================================
--Do tien duoc tinh toan tu dong nen can kiem tra luc them vao gia tri la 0
--Khi them hoa don gia tri mac dinh tong tien la 0
create or replace trigger TRG_Check_TongTien_HOADON
before insert on HOADON
for each row
begin
 if (:new.TongTien != 0) then
 raise_application_error(-20007, 'Khi them moi 1 HOADON, TongTien = 0');
 end if;
end;
/


--==============================================================================
--Do tien duoc tinh toan tu dong nen can kiem tra luc them vao gia tri la 0
--Khi them hoa don gia tri mac dinh tong tien la 0
create or replace trigger TRG_Check_TongChiTieu_KHACHHANG
before insert on KHACHHANG
for each row
begin
 if (:new.TongChiTieu != 0) then
 raise_application_error(-20008, 'Khi them moi 1 KHACHHANG, TongChiTieu = 0');
 end if;
end;
/


--==============================================================================
-- DEMO PROCEDURE ThemCTHD SAI
--==============================================================================
CREATE OR REPLACE PROCEDURE ThemCTHOADON( 
    v_MaHD_in IN CTHOADON.MaHD%type, 
    v_MaSP_in IN CTHOADON.MaSP%type, 
    v_SL_in IN CTHOADON.SoLuong%type 
) 
as 
    v_MaKH KHACHHANG.MAKH%type; 
    v_DonGia SANPHAM.DonGia%type; 
    v_valueCTHD number; 
    v_SL number; 
begin  
    --lay dongia 
    select DonGia into v_DonGia 
    from SANPHAM
    where MaSP = v_MaSP_in;
    
    select SoLuong into v_SL from SANPHAM where MASP = v_MaSP_in;
    
    insert into CTHOADON(MaHD, MaSP, SoLuong, DonGia, ThanhTien) 
    values(v_MaHD_in, v_MaSP_in, v_SL_in, v_DonGia, v_DonGia*v_SL_in); 

    --giam so luong trong kho
    update SANPHAM 
    set SoLuong = v_SL - v_SL_in 
    where MaSP = v_MaSP_in; 
    sys.dbms_session.sleep(10);
    commit;
end;
/

--==============================================================================
-- DEMO PROCEDURE ThemCTPN SAI
--==============================================================================
--CREATE OR REPLACE PROCEDURE ThemCTPN (
--    p_MaPN IN NUMBER,
--    p_MaSP IN NUMBER,
--    p_SoLuong IN NUMBER
--) AS
--    v_ThanhTien NUMBER;
--    v_DonGia NUMBER;
--    v_soluong NUMBER;
--BEGIN
--    
--    --tinh thanh tien
--    select soluong into v_soluong from SANPHAM where masp = p_MaSP; 
--    select DonGia into v_DonGia 
--    from SANPHAM
--    where MaSP = p_MaSP;
--    v_ThanhTien := p_SoLuong * v_DonGia;
--    
--    --them ctphieunhap
--    INSERT INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien)
--    VALUES (p_MaPN, p_MaSP, p_SoLuong, v_DonGia, v_ThanhTien);
--    --cap nhat so luong sp
--    UPDATE SANPHAM
--    SET SoLuong =  v_soluong + p_SoLuong
--    WHERE MaSP = p_MaSP;
--    
----    sys.dbms_session.sleep(10);
--    COMMIT;
--END;
--/


--==============================================================================
-- DEMO PROCEDURE ThemCTHD DUNG
--==============================================================================
--CREATE OR REPLACE PROCEDURE ThemCTHOADON(
--    v_MaHD_in IN CTHOADON.MaHD%type,
--    v_MaSP_in IN CTHOADON.MaSP%type,
--    v_SL_in IN CTHOADON.SoLuong%type
--)
--AS
--    v_MaKH KHACHHANG.MAKH%type;
--    v_DonGia SANPHAM.DonGia%type;
--    v_valueCTHD number;
--    v_SL number;
--BEGIN
--    BEGIN
--        -- Lay dongia
--        SELECT DonGia INTO v_DonGia
--        FROM SANPHAM
--        WHERE MaSP = v_MaSP_in
--        FOR UPDATE; --bo sung for update
--
--        --them cthoadon
--        INSERT INTO CTHOADON(MaHD, MaSP, SoLuong, DonGia, ThanhTien)
--        VALUES(v_MaHD_in, v_MaSP_in, v_SL_in, v_DonGia, v_DonGia*v_SL_in);
--
--        --giam so luong sp
--        SELECT SoLuong INTO v_SL FROM SANPHAM WHERE MASP = v_MaSP_in FOR UPDATE; --bo sung for update
--        UPDATE SANPHAM
--        SET SoLuong = v_SL - v_SL_in
--        WHERE MaSP = v_MaSP_in; 
--        sys.dbms_session.sleep(5);
--        
--        COMMIT; 
--    END;
--END;
--/


--==============================================================================
-- DEMO PROCEDURE ThemCTPN DUNG
--==============================================================================
CREATE OR REPLACE PROCEDURE ThemCTPN (
  p_MaPN IN NUMBER,
  p_MaSP IN NUMBER,
  p_SoLuong IN NUMBER
) AS
  v_ThanhTien NUMBER;
  v_DonGia NUMBER;
  v_soluong NUMBER;
BEGIN
    --tinh thanh tien
    SELECT soluong INTO v_soluong FROM SANPHAM WHERE masp = p_MaSP FOR UPDATE; --thêm FOR UPDATE
    SELECT DonGia INTO v_DonGia 
    FROM SANPHAM
    WHERE MaSP = p_MaSP FOR UPDATE; --thêm FOR UPDATE
    v_ThanhTien := p_SoLuong * v_DonGia;
    
    --them ctphieunhap
    INSERT INTO CTPHIEUNHAP (MaPN, MaSP, SoLuong, DonGia, ThanhTien)
    VALUES (p_MaPN, p_MaSP, p_SoLuong, v_DonGia, v_ThanhTien);
  
    --cap nhat so luong sp
    UPDATE SANPHAM
    SET SoLuong =  v_soluong + p_SoLuong
    WHERE MaSP = p_MaSP;

    COMMIT;
END;
/


--==============================================================================
--PROCEDURE XoaSanPham
--==============================================================================
CREATE OR REPLACE PROCEDURE XoaSanPham(p_MaSP IN NUMBER)
IS
    --kiem tra su ton tai cua sp
    v_exist NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_exist
    FROM SANPHAM
    WHERE MaSP = p_MaSP;
    
    IF v_exist = 1 THEN
        DELETE FROM CTHOADON WHERE MaSP = p_MaSP;
        --Tong chi tieu khach hang, tong tien hoa don da duoc trigger cap nhat
        DELETE FROM SANPHAM WHERE MaSP = p_MaSP;
    END IF;
END;
/


--==============================================================================
--PROCEDURE XOA HOA DON, CTHOADON VA PHUC HOI SO LUONG 
--(dung khi khong the tao toan bo cthoadon do bi loi rang buoc,
--tra lai so luong va xoa toan hoa don vua tao)
--==============================================================================
CREATE OR REPLACE PROCEDURE Xoa_HOADON_CTHOADON(
    v_MaHD IN HOADON.MaHD%TYPE
)
AS
    --duyet chi tiet hoa don co ma hoa don duoc nhap vao
    CURSOR c_cthd IS
        SELECT MaSP, SoLuong
        FROM CTHOADON
        WHERE MaHD = v_MaHD;

    v_MaSP CTHOADON.MaSP%TYPE;
    v_SoLuong CTHOADON.SoLuong%TYPE;

BEGIN
    OPEN c_cthd;
    LOOP
        FETCH c_cthd INTO v_MaSP, v_SoLuong;
        EXIT WHEN c_cthd%NOTFOUND;
        
        UPDATE SANPHAM
        SET SoLuong = SoLuong + v_SoLuong
        WHERE MaSP = v_MaSP;
    END LOOP;

    CLOSE c_cthd;
    DELETE FROM CTHOADON
    WHERE MaHD = v_MaHD;
    DELETE FROM HOADON
    WHERE MaHD = v_MaHD;
    
    COMMIT;
END;
/


--==============================================================================
--procedure tinh tong doanh thu
CREATE OR REPLACE PROCEDURE TongDoanhThuTheoNam (
    p_nam IN NUMBER,
    p_tong OUT NUMBER)
IS
BEGIN
    SELECT SUM(TongTien)
    INTO p_tong
    FROM HOADON
    WHERE EXTRACT(YEAR FROM NgayLap) = p_nam;
    -- Ki?m tra n?u k?t qu? là NULL, ??t v? 0
    IF p_tong IS NULL THEN
        p_tong := 0;
    END IF;
END;
/


--==============================================================================
--Xoa nhan vien, neu nhan vien duoc luu thong tin trong hoa don nao do thi se 
--khong xoa
CREATE OR REPLACE PROCEDURE XoaNhanVien(p_MaNV IN NUMBER) IS
  v_Count NUMBER;
BEGIN
  --kiem tra nhan vien co dang dc luu thong tin trong hoa don nao khong
  SELECT COUNT(*) INTO v_Count
  FROM hoadon
  WHERE MaNV = p_MaNV;

  IF v_Count > 0 THEN
    --neu nhan vien dang duoc luu thong tin trong hoa don thi khong xoa
    raise_application_error(-20007, 'Thong tin nhan vien dang duoc luu, khong the xoa');
  ELSE
    --xoa tai khoan nhan vien dang dung luon 
    DELETE FROM taikhoan WHERE MaNV = p_MaNV;
    
    --xoa nhan vien
    DELETE FROM nhanvien WHERE MaNV = p_MaNV;
    
    --khong co nhan vien nay de xoa
    IF SQL%ROWCOUNT = 0 THEN
      raise_application_error(-20007, 'Khong ton tai nhan vien.');
    ELSE
      DBMS_OUTPUT.PUT_LINE('Da xoa nhan vien MaNV = ' || p_MaNV);
    END IF;
    
    COMMIT;
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Loi xay ra khi xoa: ' || SQLERRM);
    ROLLBACK;
END XoaNhanVien;
/



