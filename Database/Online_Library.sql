CREATE DATABASE Online_Library
go
USE Online_Library
go
CREATE TABLE account(
	username nvarchar(10) NOT NULL,
	password nvarchar(50) NULL,
	PRIMARY KEY(username)
 )
 go
 CREATE TABLE book(
	ID		int,
	name	nvarchar(100) NULL,
	author	nvarchar(100) NULL,
	year	int NULL,
	type	nvarchar(100) NULL,
	PRIMARY KEY(ID)
 )
go
INSERT INTO account(username,password) VALUES
(N'anh', N'anh456'),
(N'hieu', N'hieu789'),
(N'truc', N'truc123')

INSERT INTO book(ID, name, author, year, type) VALUES
(1, N'Computer Networking', N'James F. Kurose', 2000, N'Computer Science'),
(2, N'Clean Code', N'Robert Martin', 2008, N'Computer Science'),
(3, N'Harry Potter', N'J.K.Rowling', 1996, N'Fiction'),
(4, N'Mắt biếc', N'Nguyễn Nhật Ánh', 2004, N'Fiction'),
(5, N'Trại hoa vàng', N'Nguyễn Nhật Ánh', 1994, N'Fiction')
