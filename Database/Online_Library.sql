USE [master]
GO
/****** Object:  Database [Online_Library]    Script Date: 3/24/2021 4:28:16 PM ******/
CREATE DATABASE [Online_Library]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Online_Library', FILENAME = N'D:\MMT\Socket\MMT_Socket\Database\Online_Library.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Online_Library_log', FILENAME = N'D:\MMT\Socket\MMT_Socket\Database\Online_Library_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Online_Library] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Online_Library].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Online_Library] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Online_Library] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Online_Library] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Online_Library] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Online_Library] SET ARITHABORT OFF 
GO
ALTER DATABASE [Online_Library] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Online_Library] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Online_Library] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Online_Library] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Online_Library] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Online_Library] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Online_Library] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Online_Library] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Online_Library] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Online_Library] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Online_Library] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Online_Library] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Online_Library] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Online_Library] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Online_Library] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Online_Library] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Online_Library] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Online_Library] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Online_Library] SET  MULTI_USER 
GO
ALTER DATABASE [Online_Library] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Online_Library] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Online_Library] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Online_Library] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Online_Library] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Online_Library] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Online_Library] SET QUERY_STORE = OFF
GO
USE [Online_Library]
GO
/****** Object:  Table [dbo].[account]    Script Date: 3/24/2021 4:28:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[username] [nvarchar](10) NOT NULL,
	[password] [nvarchar](50) NULL,
 CONSTRAINT [PK_account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[book]    Script Date: 3/24/2021 4:28:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[book](
	[ID] [int] NOT NULL,
	[name] [nvarchar](100) NULL,
	[author] [nvarchar](50) NULL,
	[year] [int] NULL,
	[type] [nvarchar](100) NULL,
 CONSTRAINT [PK_book] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[account] ([username], [password]) VALUES (N'anh', N'456')
INSERT [dbo].[account] ([username], [password]) VALUES (N'hieu', N'789')
INSERT [dbo].[account] ([username], [password]) VALUES (N'lulu', N'194')
INSERT [dbo].[account] ([username], [password]) VALUES (N'truc', N'123')
GO
INSERT [dbo].[book] ([ID], [name], [author], [year], [type]) VALUES (1, N'Computer Networking', N'James F. Kurose', 2000, N'Computer Science')
INSERT [dbo].[book] ([ID], [name], [author], [year], [type]) VALUES (2, N'Clean Code', N'Robert Martin', 2008, N'Computer Science')
INSERT [dbo].[book] ([ID], [name], [author], [year], [type]) VALUES (3, N'Harry Potter', N'J.K.Rowling', 1996, N'Fiction')
INSERT [dbo].[book] ([ID], [name], [author], [year], [type]) VALUES (4, N'Mắt biếc', N'Nguyễn Nhật Ánh', 2004, N'Fiction')
INSERT [dbo].[book] ([ID], [name], [author], [year], [type]) VALUES (5, N'Trại hoa vàng', N'Nguyễn Nhật Ánh', 1994, N'Fiction')
GO
USE [master]
GO
ALTER DATABASE [Online_Library] SET  READ_WRITE 
GO
