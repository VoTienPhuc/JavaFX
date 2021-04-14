create database Food;
use Food;
#drop database food;
create table Nhanvien(
	MaNV varchar(10) not null primary key,
    Hoten nvarchar(30) not null,
    Ngaysinh date,
    SDT varchar(15),
    trangthai int
);
insert into NhanVien values	("N01","Trương Tam","2000/1/20","0123456789",1),
							("N02","Lý Tứ",		"1990/2/21","0123456788",0),
							("N03","Trần Ngũ",	"1995/3/22","0123456787",1),
							("N04","Hoàng Lục",	"1999/4/23","0123456786",1),
							("N05","Triệu Thất","1987/5/24","0123456785",0);
                            
create table `user`
(
	userID varchar(20) not null primary key,
    `password` varchar(20) not null,
    manv varchar(10) references nhanvien(manv),
    role int
);
insert into `user` values	("thuthuy","123456"		,"N01",1),
							("phuonganh","123456"	,"N02",2),
							("sacnguyet","123456"	,"N03",2),
							("mylinh","123456"		,"N04",2),
							("touyen","123456"		,"N05",2);

create table MonAn(
	MaMon varchar(10) not null primary key,
	TenMon nvarchar(50) not null,
    DonGia int not null,
    TrangThai int not null
);
insert into MonAn values("M01","Hamburger Gà"		,18000,1),
						("M02","Hamberger Heo"		,18000,1),
						("M03","Hamberger Bò"		,22000,1),
						("M04","Mỳ Ý"				,22000,1),
						("M05","Bánh Mì Kẹp Thịt"	,15000,1),
						("M06","CoCa CoLa Ly Nhỏ"	,05000,1),
						("M07","Gà Rán"				,30000,1),
						("M08","Khoai Tây Chiên"	,15000,1),
						("M09","CoCa CoLa Ly Lớn"	,10000,1),
						("M10","Khoai Tây Lốc Xoáy"	,15000,1);
                        
create table HoaDon(
	MaHD varchar(15) not null primary key,
	MaNV varchar(10) not null references NhanVien(MaNV),
    TongTien int not null,
    Ngay date not null,
    Gio varchar(10) not null
);
insert into HoaDon values	("H01","N02",72000	,0,"2021/1/1","12:05:44"),
							("H02","N02",74000	,0,"2021/1/2","11:02:33"),
							("H03","N03",100000	,0,"2021/1/3","10:55:55"),
							("H04","N04",20000	,0,"2021/1/4","09:08:07"),
							("H05","N05",120000	,0,"2021/1/5","08:14:00");

create table ChiTietHoaDon(
	MaHD varchar(15) references hoadon(mahd),
    MaMon varchar(10) not null references MonAn(MaMon),
    TenMon varchar(50) not null references MonAn(TenMon),
    DonGia int not null ,
    SoLuong int not null,
    ThanhTien int,
	GhiChu nvarchar(50)
);
insert into ChiTietHoaDon values("H01","M01","Hamburger Gà",		2,18000,36000,""),
								("H01","M02","Hamburger Heo",		2,18000,36000,""),
								("H02","M03","Hamburger Bò",		1,22000,22000,""),
								("H02","M04","Mỳ Ý",				1,22000,22000,""),
								("H02","M05","Bánh Mì Kẹp Thịt",	2,15000,30000,""),
								("H03","M06","CoCa CoLa Ly Nhỏ",	2,05000,10000,""),
								("H03","M07","Gà Rán",				2,30000,60000,""),
								("H03","M08","Khoai Tây Chiên",		2,15000,30000,""),
								("H04","M09","CoCa CoLa Ly Lớn"	,	2,10000,20000,""),
								("H05","M10","Khoai Tây Lốc Xoáy",	6,15000,90000,""),
								("H05","M05","Bánh Mì Kẹp Thịt",	2,15000,30000,"");

select * from nhanvien;
select * from user;
select * from monan;
select * from hoadon;
select * from chitiethoadon;
