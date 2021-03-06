USE [Car_Rental]
GO
ALTER TABLE [dbo].[tblUser] DROP CONSTRAINT [FK__tblUser__roleID__6EF57B66]
GO
ALTER TABLE [dbo].[tblRentalDetail] DROP CONSTRAINT [FK__tblRental__renta__123EB7A3]
GO
ALTER TABLE [dbo].[tblRentalDetail] DROP CONSTRAINT [FK__tblRental__carID__1332DBDC]
GO
ALTER TABLE [dbo].[tblRental] DROP CONSTRAINT [FK__tblRental__email__0E6E26BF]
GO
ALTER TABLE [dbo].[tblRental] DROP CONSTRAINT [FK__tblRental__disco__0F624AF8]
GO
ALTER TABLE [dbo].[tblCar] DROP CONSTRAINT [FK__tblCar__typeID__1A14E395]
GO
ALTER TABLE [dbo].[tblCar] DROP CONSTRAINT [FK__tblCar__category__1920BF5C]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 4/10/2021 3:44:11 PM ******/
DROP TABLE [dbo].[tblUser]
GO
/****** Object:  Table [dbo].[tblType]    Script Date: 4/10/2021 3:44:11 PM ******/
DROP TABLE [dbo].[tblType]
GO
/****** Object:  Table [dbo].[tblRole]    Script Date: 4/10/2021 3:44:11 PM ******/
DROP TABLE [dbo].[tblRole]
GO
/****** Object:  Table [dbo].[tblRentalDetail]    Script Date: 4/10/2021 3:44:11 PM ******/
DROP TABLE [dbo].[tblRentalDetail]
GO
/****** Object:  Table [dbo].[tblRental]    Script Date: 4/10/2021 3:44:11 PM ******/
DROP TABLE [dbo].[tblRental]
GO
/****** Object:  Table [dbo].[tblDiscount]    Script Date: 4/10/2021 3:44:11 PM ******/
DROP TABLE [dbo].[tblDiscount]
GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 4/10/2021 3:44:11 PM ******/
DROP TABLE [dbo].[tblCategory]
GO
/****** Object:  Table [dbo].[tblCar]    Script Date: 4/10/2021 3:44:11 PM ******/
DROP TABLE [dbo].[tblCar]
GO
/****** Object:  Table [dbo].[tblCar]    Script Date: 4/10/2021 3:44:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCar](
	[carID] [nvarchar](50) NOT NULL,
	[carName] [nvarchar](50) NULL,
	[color] [nvarchar](20) NULL,
	[year] [nvarchar](20) NULL,
	[price] [float] NULL,
	[picture] [nvarchar](max) NULL,
	[status] [nvarchar](10) NULL,
	[categoryID] [nvarchar](10) NULL,
	[typeID] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[carID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 4/10/2021 3:44:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategory](
	[categoryID] [nvarchar](10) NOT NULL,
	[categoryName] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblDiscount]    Script Date: 4/10/2021 3:44:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblDiscount](
	[discountID] [nvarchar](50) NOT NULL,
	[discountCode] [nvarchar](20) NULL,
	[expireDate] [datetime] NULL,
	[discountPercent] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[discountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblRental]    Script Date: 4/10/2021 3:44:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRental](
	[rentalID] [nvarchar](50) NOT NULL,
	[totalPrice] [float] NULL,
	[rentalDate] [datetime] NULL,
	[status] [nvarchar](10) NULL,
	[email] [nvarchar](200) NULL,
	[discountID] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[rentalID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblRentalDetail]    Script Date: 4/10/2021 3:44:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRentalDetail](
	[detailID] [nvarchar](50) NOT NULL,
	[rentalID] [nvarchar](50) NULL,
	[carID] [nvarchar](50) NULL,
	[price] [float] NULL,
	[startDate] [datetime] NULL,
	[endDate] [datetime] NULL,
	[feedbackContent] [nvarchar](max) NULL,
	[rateStar] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[detailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblRole]    Script Date: 4/10/2021 3:44:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRole](
	[roleID] [nvarchar](10) NOT NULL,
	[roleName] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblType]    Script Date: 4/10/2021 3:44:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblType](
	[typeID] [nvarchar](10) NOT NULL,
	[typeName] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[typeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 4/10/2021 3:44:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblUser](
	[email] [nvarchar](200) NOT NULL,
	[password] [varchar](300) NULL,
	[name] [nvarchar](50) NULL,
	[phone] [nvarchar](20) NULL,
	[address] [nvarchar](200) NULL,
	[createDate] [datetime] NULL,
	[roleID] [nvarchar](10) NULL,
	[status] [nvarchar](10) NULL,
	[code] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-0136', N'Honda Civic 2020 organe', N'Organe', N'2020', 900000, N'https://di-uploads-pod11.dealerinspire.com/valleyhonda/uploads/2019/11/2020-Civic-Sedan-Molten-Lava-Pearl.png', N'available', N'H', N'HCV')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-047x', N'Honda RS7 white', N'White', N'2020', 2000000, N'https://cdn.motor1.com/images/mgl/kJ74N/s1/2020-audi-rs7-sportback-in-glacier-white.jpg', N'available', N'H', N'ADRS')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-055M', N'Honda 2019 A7', N'White', N'2019', 2000000, N'https://i.pinimg.com/originals/3f/10/47/3f1047afee620244a238b0e1690ea499.jpg', N'available', N'H', N'ADA')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-128w', N'Honda 2020 Q9', N'Organe', N'2020', 900000, N'https://ussuvsnation.com/wp-content/uploads/2019/09/2020-Audi-Q9.jpg', N'available', N'H', N'ADQ')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-132l', N'Honda City 2018 organe', N'Organe', N'2018', 800000, N'http://www.purosautos.com/wp-content/uploads/2017/07/honda-fit-2018.jpg', N'available', N'H', N'HC')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-1520', N'Honda NSX 2020 white', N'White', N'2020', 7000000, N'https://i.pinimg.com/originals/89/9b/00/899b0068d5a340bb69236049156e519e.png', N'available', N'H', N'HN')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-189T', N'Honda R10', N'Organe', N'2020', 3000000, N'https://i.pinimg.com/originals/8c/56/78/8c5678c877a7d7b1a1689975f91bc205.jpg', N'available', N'H', N'ADR')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-2156', N'Honda 2018 A3', N'Organe', N'2018', 1000000, N'https://cdn.24h.com.vn/upload/4-2018/images/2018-10-04/24-audiq32019-2-1538644819-144-width660height440.jpg', N'available', N'H', N'ADA')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-286g', N'Honda NSX 2018 white', N'White', N'2018', 5000000, N'https://www.pngkit.com/png/detail/222-2227252_2018nsx-honda-nsx-2018-white.png', N'available', N'H', N'HN')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-298H', N'Honda 2019 A7', N'White', N'2019', 2000000, N'https://i.pinimg.com/originals/3f/10/47/3f1047afee620244a238b0e1690ea499.jpg', N'available', N'H', N'ADA')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-391n', N'Honda NSX 2019 white', N'White', N'2019', 6000000, N'https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/honda-nsx_2.jpg?itok=1BAWld0-', N'available', N'H', N'HN')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-414Z', N'Honda City 2019 white', N'White', N'2019', 850000, N'https://hondaotoconghoa.vn/wp-content/uploads/2018/07/city_01.png', N'available', N'H', N'HC')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-492g', N'Honda City 2020 white', N'White', N'2020', 1000000, N'https://inventory-dmg.assets-cdk.com/ChromeColorMatch/us/WHITE_cc_2020FOS150049_01_1280_YZ.jpg', N'available', N'H', N'HC')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-548o', N'Honda R8', N'White', N'2020', 1000000, N'https://i.pinimg.com/originals/52/47/0c/52470c16e377856cb88ebc48d4e728fb.jpg', N'available', N'H', N'ADR')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-567T', N'Honda 2018 Q3', N'White', N'2018', 700000, N'https://banner2.cleanpng.com/20180506/xvq/kisspng-2018-audi-q3-car-2015-audi-q3-audi-a3-q-a-5aef31c03d44b7.258750451525625280251.jpg', N'available', N'H', N'ADQ')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-602U', N'Honda City 2019 white', N'White', N'2019', 850000, N'https://hondaotoconghoa.vn/wp-content/uploads/2018/07/city_01.png', N'available', N'H', N'ADA')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-6102', N'Honda Civic 2019 white', N'White', N'2019', 800000, N'https://static.foxdealer.com/414/2019/05/civic-lx-platinum-white.jpeg', N'available', N'H', N'HCV')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-6265', N'Honda City 2018 organe', N'Organe', N'2018', 800000, N'http://www.purosautos.com/wp-content/uploads/2017/07/honda-fit-2018.jpg', N'available', N'H', N'HC')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-6996', N'Honda Civic 2018 white', N'White', N'2018', 700000, N'https://product.hstatic.net/1000170465/product/honda_civic_2018_bd00bc78c3b94bd88990336c26357e04_bb65991db91d40008b7e65dca0f9572b.jpg', N'available', N'H', N'HCV')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-788m', N'Audi RS6 white', N'White', N'2020', 1500000, N'https://wheelfront.com/wp-content/uploads/formidable/8/28514445_765514013637812_494227953852171339_o.jpg', N'available', N'A', N'ADRS')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-790g', N'Honda 2020 A9', N'White', N'2020', 2500000, N'https://img.tinxe.vn/resize/1000x-/2019/11/22/vwnbOqjE/2019-audi-a5-sportback-colorizer-glacier-white-met-8510.jpg', N'available', N'H', N'ADA')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-794m', N'Audi RS8 white', N'White', N'2020', 2500000, N'https://cdn.motor1.com/images/mgl/1X7e3/s1/2018-audi-r8-v10-plus-competition.jpg', N'available', N'A', N'ADRS')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-8026', N'Honda City 2018 organe', N'Organe', N'2018', 800000, N'http://www.purosautos.com/wp-content/uploads/2017/07/honda-fit-2018.jpg', N'available', N'H', N'HC')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-869x', N'Honda R9', N'White', N'2020', 2000000, N'https://wallpapercave.com/wp/wp2130687.png', N'available', N'H', N'ADR')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-872p', N'Honda City 2020 white', N'White', N'2020', 1000000, N'https://inventory-dmg.assets-cdk.com/ChromeColorMatch/us/WHITE_cc_2020FOS150049_01_1280_YZ.jpg', N'available', N'H', N'HC')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-919U', N'Honda 2018 A3', N'Organe', N'2018', 1000000, N'https://cdn.24h.com.vn/upload/4-2018/images/2018-10-04/24-audiq32019-2-1538644819-144-width660height440.jpg', N'available', N'H', N'ADA')
INSERT [dbo].[tblCar] ([carID], [carName], [color], [year], [price], [picture], [status], [categoryID], [typeID]) VALUES (N'L-972R', N'Honda 2019 Q7', N'White ', N'2019', 800000, N'https://media.autoexpress.co.uk/image/private/s--xO5mpOUS--/v1570211799/autoexpress/2019/10/01_8.jpg', N'available', N'H', N'ADQ')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'A', N'Audi')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'F', N'Ford')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'H', N'Honda')
INSERT [dbo].[tblDiscount] ([discountID], [discountCode], [expireDate], [discountPercent]) VALUES (N'DC001', N'KHUYENMAITHANG3', CAST(N'2021-03-31 00:00:00.000' AS DateTime), 30)
INSERT [dbo].[tblDiscount] ([discountID], [discountCode], [expireDate], [discountPercent]) VALUES (N'DC002', N'FRIENDOFMINH', CAST(N'2021-12-24 00:00:00.000' AS DateTime), 50)
INSERT [dbo].[tblRental] ([rentalID], [totalPrice], [rentalDate], [status], [email], [discountID]) VALUES (N'Rent-datdam2407@gmail.com-1', 2100000, CAST(N'2021-03-18 10:14:45.220' AS DateTime), N'True', N'datdam2407@gmail.com', NULL)
INSERT [dbo].[tblRental] ([rentalID], [totalPrice], [rentalDate], [status], [email], [discountID]) VALUES (N'Rent-uyen@gmail.com-1', 7200000, CAST(N'2021-03-17 14:18:15.220' AS DateTime), N'True', N'uyen@gmail.com', N'DC001')
INSERT [dbo].[tblRental] ([rentalID], [totalPrice], [rentalDate], [status], [email], [discountID]) VALUES (N'Rent-uyen@gmail.com-10', 8200000, CAST(N'2021-03-19 07:35:48.643' AS DateTime), N'False', N'uyen@gmail.com', NULL)
INSERT [dbo].[tblRental] ([rentalID], [totalPrice], [rentalDate], [status], [email], [discountID]) VALUES (N'Rent-uyen@gmail.com-2', 12800000, CAST(N'2021-03-17 14:19:46.600' AS DateTime), N'True', N'uyen@gmail.com', NULL)
INSERT [dbo].[tblRental] ([rentalID], [totalPrice], [rentalDate], [status], [email], [discountID]) VALUES (N'Rent-uyen@gmail.com-3', 4800000, CAST(N'2021-03-17 14:21:15.660' AS DateTime), N'True', N'uyen@gmail.com', NULL)
INSERT [dbo].[tblRental] ([rentalID], [totalPrice], [rentalDate], [status], [email], [discountID]) VALUES (N'Rent-uyen@gmail.com-4', 10400000, CAST(N'2021-03-17 14:33:00.037' AS DateTime), N'True', N'uyen@gmail.com', NULL)
INSERT [dbo].[tblRental] ([rentalID], [totalPrice], [rentalDate], [status], [email], [discountID]) VALUES (N'Rent-uyen@gmail.com-5', 3000000, CAST(N'2021-03-17 14:54:24.003' AS DateTime), N'True', N'uyen@gmail.com', NULL)
INSERT [dbo].[tblRental] ([rentalID], [totalPrice], [rentalDate], [status], [email], [discountID]) VALUES (N'Rent-uyen@gmail.com-6', 1000000, CAST(N'2021-03-17 15:00:53.027' AS DateTime), N'True', N'uyen@gmail.com', N'DC001')
INSERT [dbo].[tblRental] ([rentalID], [totalPrice], [rentalDate], [status], [email], [discountID]) VALUES (N'Rent-uyen@gmail.com-7', 49700000, CAST(N'2021-03-18 10:05:39.493' AS DateTime), N'True', N'uyen@gmail.com', N'DC001')
INSERT [dbo].[tblRental] ([rentalID], [totalPrice], [rentalDate], [status], [email], [discountID]) VALUES (N'Rent-uyen@gmail.com-8', 3200000, CAST(N'2021-03-19 05:09:15.480' AS DateTime), N'True', N'uyen@gmail.com', NULL)
INSERT [dbo].[tblRental] ([rentalID], [totalPrice], [rentalDate], [status], [email], [discountID]) VALUES (N'Rent-uyen@gmail.com-9', 2000000, CAST(N'2021-03-19 07:20:40.707' AS DateTime), N'True', N'uyen@gmail.com', NULL)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-datdam2407@gmail.com-1-1', N'Rent-datdam2407@gmail.com-1', N'L-567T', 2100000, CAST(N'2021-03-22 00:00:00.000' AS DateTime), CAST(N'2021-03-25 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-10-1', N'Rent-uyen@gmail.com-10', N'L-286g', 5000000, CAST(N'2021-03-28 00:00:00.000' AS DateTime), CAST(N'2021-03-17 00:00:00.000' AS DateTime), N'tao lao', 10)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-10-2', N'Rent-uyen@gmail.com-10', N'L-132l', 1600000, CAST(N'2021-04-20 00:00:00.000' AS DateTime), CAST(N'2021-03-17 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-10-3', N'Rent-uyen@gmail.com-10', N'L-6265', 1600000, CAST(N'2021-05-24 00:00:00.000' AS DateTime), CAST(N'2021-03-17 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-1-1', N'Rent-uyen@gmail.com-1', N'L-0136', 7200000, CAST(N'2021-03-17 00:00:00.000' AS DateTime), CAST(N'2021-03-18 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-2-1', N'Rent-uyen@gmail.com-2', N'L-132l', 6400000, CAST(N'2021-03-17 00:00:00.000' AS DateTime), CAST(N'2021-03-25 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-2-2', N'Rent-uyen@gmail.com-2', N'L-6265', 6400000, CAST(N'2021-03-24 00:00:00.000' AS DateTime), CAST(N'2021-04-01 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-3-1', N'Rent-uyen@gmail.com-3', N'L-132l', 800000, CAST(N'2021-03-26 00:00:00.000' AS DateTime), CAST(N'2021-03-27 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-3-2', N'Rent-uyen@gmail.com-3', N'L-6265', 4000000, CAST(N'2021-04-02 00:00:00.000' AS DateTime), CAST(N'2021-04-07 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-4-1', N'Rent-uyen@gmail.com-4', N'L-2156', 8000000, CAST(N'2021-03-17 00:00:00.000' AS DateTime), CAST(N'2021-03-25 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-4-2', N'Rent-uyen@gmail.com-4', N'L-6265', 2400000, CAST(N'2021-03-17 00:00:00.000' AS DateTime), CAST(N'2021-03-20 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-5-1', N'Rent-uyen@gmail.com-5', N'L-2156', 3000000, CAST(N'2021-03-30 00:00:00.000' AS DateTime), CAST(N'2021-04-02 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-6-1', N'Rent-uyen@gmail.com-6', N'L-2156', 1000000, CAST(N'2021-04-03 00:00:00.000' AS DateTime), CAST(N'2021-04-04 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-7-1', N'Rent-uyen@gmail.com-7', N'L-2156', 8000000, CAST(N'2021-06-18 00:00:00.000' AS DateTime), CAST(N'2021-06-26 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-7-2', N'Rent-uyen@gmail.com-7', N'L-919U', 1000000, CAST(N'2021-04-10 00:00:00.000' AS DateTime), CAST(N'2021-04-11 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-7-3', N'Rent-uyen@gmail.com-7', N'L-286g', 40000000, CAST(N'2021-03-19 00:00:00.000' AS DateTime), CAST(N'2021-03-27 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-7-4', N'Rent-uyen@gmail.com-7', N'L-567T', 700000, CAST(N'2021-03-18 00:00:00.000' AS DateTime), CAST(N'2021-03-16 00:00:00.000' AS DateTime), N'Fantastic', 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-8-1', N'Rent-uyen@gmail.com-8', N'L-132l', 1600000, CAST(N'2021-03-31 00:00:00.000' AS DateTime), CAST(N'2021-04-02 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-8-2', N'Rent-uyen@gmail.com-8', N'L-6265', 1600000, CAST(N'2021-04-21 00:00:00.000' AS DateTime), CAST(N'2021-04-23 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRentalDetail] ([detailID], [rentalID], [carID], [price], [startDate], [endDate], [feedbackContent], [rateStar]) VALUES (N'Rent-uyen@gmail.com-9-1', N'Rent-uyen@gmail.com-9', N'L-047x', 2000000, CAST(N'2021-03-19 00:00:00.000' AS DateTime), CAST(N'2021-03-20 00:00:00.000' AS DateTime), NULL, 0)
INSERT [dbo].[tblRole] ([roleID], [roleName]) VALUES (N'AD', N'Admin')
INSERT [dbo].[tblRole] ([roleID], [roleName]) VALUES (N'US', N'User')
INSERT [dbo].[tblType] ([typeID], [typeName]) VALUES (N'ADA', N'Audi A')
INSERT [dbo].[tblType] ([typeID], [typeName]) VALUES (N'ADQ', N'Audi Q')
INSERT [dbo].[tblType] ([typeID], [typeName]) VALUES (N'ADR', N'Audi R')
INSERT [dbo].[tblType] ([typeID], [typeName]) VALUES (N'ADRS', N'Audi RS')
INSERT [dbo].[tblType] ([typeID], [typeName]) VALUES (N'FE', N'Ford Explorer')
INSERT [dbo].[tblType] ([typeID], [typeName]) VALUES (N'HC', N'Honda City')
INSERT [dbo].[tblType] ([typeID], [typeName]) VALUES (N'HCV', N'Honda Civic')
INSERT [dbo].[tblType] ([typeID], [typeName]) VALUES (N'HN', N'Honda NSX')
INSERT [dbo].[tblUser] ([email], [password], [name], [phone], [address], [createDate], [roleID], [status], [code]) VALUES (N'datdam2407@gmail.com', N'123', N'Dam Dat', N'012407200000', NULL, CAST(N'2021-03-18 10:11:12.467' AS DateTime), N'US', N'Active', N'TdBEku')
INSERT [dbo].[tblUser] ([email], [password], [name], [phone], [address], [createDate], [roleID], [status], [code]) VALUES (N'kwangming220500@gmail.com', N'bffeveryone220500', N'Nguyen Quang Minh', N'0765851225', NULL, CAST(N'2021-03-15 14:28:48.007' AS DateTime), N'US', N'Active', N'305QEy')
INSERT [dbo].[tblUser] ([email], [password], [name], [phone], [address], [createDate], [roleID], [status], [code]) VALUES (N'minh@gmail.com', N'2205', N'Quang Minh', N'0765851225', N'HCM', CAST(N'2021-03-15 00:00:00.000' AS DateTime), N'AD', N'Active', NULL)
INSERT [dbo].[tblUser] ([email], [password], [name], [phone], [address], [createDate], [roleID], [status], [code]) VALUES (N'uyen@gmail.com', N'1606', N'Phuong Uyen', N'01234567899', N'HCM', CAST(N'2021-03-15 00:00:00.000' AS DateTime), N'US', N'Active', NULL)
ALTER TABLE [dbo].[tblCar]  WITH CHECK ADD FOREIGN KEY([categoryID])
REFERENCES [dbo].[tblCategory] ([categoryID])
GO
ALTER TABLE [dbo].[tblCar]  WITH CHECK ADD FOREIGN KEY([typeID])
REFERENCES [dbo].[tblType] ([typeID])
GO
ALTER TABLE [dbo].[tblRental]  WITH CHECK ADD FOREIGN KEY([discountID])
REFERENCES [dbo].[tblDiscount] ([discountID])
GO
ALTER TABLE [dbo].[tblRental]  WITH CHECK ADD FOREIGN KEY([email])
REFERENCES [dbo].[tblUser] ([email])
GO
ALTER TABLE [dbo].[tblRentalDetail]  WITH CHECK ADD FOREIGN KEY([carID])
REFERENCES [dbo].[tblCar] ([carID])
GO
ALTER TABLE [dbo].[tblRentalDetail]  WITH CHECK ADD FOREIGN KEY([rentalID])
REFERENCES [dbo].[tblRental] ([rentalID])
GO
ALTER TABLE [dbo].[tblUser]  WITH CHECK ADD FOREIGN KEY([roleID])
REFERENCES [dbo].[tblRole] ([roleID])
GO
