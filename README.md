# Hệ thống Quản lý Giáo dục Theo Tín Chỉ

## Giới thiệu

Hệ thống Quản lý Giáo dục Theo Tín Chỉ được thiết kế để quản lý quá trình học tập và kết quả học tập của sinh viên. Hệ thống cho phép sinh viên tự quyết định tiến độ học tập bằng cách lựa chọn các lớp học mở sẵn. Hệ thống này được xây dựng với kiến trúc phân tán microservice, giúp tăng tính sẵn có và khả năng mở rộng của hệ thống.

## Nhóm Thực Hiện

- Nguyễn Thanh Sơn – 20106421
- Phạm Thanh Sơn – 20106801
- Đào Thị Ngọc Bích – 20058761

## Kiến Trúc Hệ Thống

### 1. Kiến trúc Phân tán Microservice

Hệ thống sử dụng kiến trúc microservice, trong đó các chức năng chính được chia thành các dịch vụ độc lập và có thể triển khai riêng lẻ. Các dịch vụ này có thể giao tiếp với nhau thông qua các API và sử dụng cơ sở dữ liệu riêng.

### 2. Các thành phần chính

- **UserAuthenticationService**: Quản lý thông tin người dùng và xác thực.
- **DangKyHocPhanService**: Quản lý việc đăng ký học phần.
- **LichHocService**: Quản lý lịch học của sinh viên và giảng viên.
- **KetQuaHocTapService**: Quản lý kết quả học tập của sinh viên.

### 3. Ưu và nhược điểm của kiến trúc Microservice

**Ưu điểm:**
- Tính sẵn dùng cao và khả năng chịu lỗi tốt.
- Khả năng mở rộng dễ dàng.
- Phân phối tải, giảm áp lực cho từng máy chủ.
- Tính độc lập giữa các dịch vụ, dễ quản lý và bảo trì.

**Nhược điểm:**
- Dữ liệu có thể bị trùng lặp, tốn tài nguyên lưu trữ.
- Không thể sử dụng transaction giữa các server.
- Một số chức năng phải qua nhiều tầng hơn, có thể chậm hơn.

## Chức Năng Chính của Hệ Thống

### 1. UserAuthenticationService

- Thêm sinh viên và giảng viên.
- Đăng nhập.

### 2. DangKyHocPhanService

- Xem danh sách học phần có thể đăng ký.
- Đăng ký lớp học phần.

### 3. LichHocService

- Xem lịch học của sinh viên.
- Xem lịch dạy của giảng viên.

### 4. KetQuaHocTapService

- Nhập điểm cho lớp học phần.
- Xem kết quả học tập của sinh viên.
- Xét tốt nghiệp cho sinh viên.

## Hướng Dẫn Sử Dụng

### 1. Đăng nhập

Sinh viên sử dụng mã số sinh viên (MSSV) và mật khẩu mặc định "1111" để đăng nhập vào hệ thống.

### 2. Đăng ký học phần

Sinh viên có thể xem các môn học có thể đăng ký và tiến hành đăng ký các lớp học phần. Mỗi học kỳ, sinh viên có thể đăng ký tối đa 30 tín chỉ và các lịch học không được trùng nhau.

### 3. Xem lịch học và kết quả học tập

Sinh viên có thể xem lịch học của mình và kết quả học tập sau khi giáo vụ nhập điểm. Hệ thống hỗ trợ việc nhập và quản lý điểm số theo các tiêu chí đã đề ra.

### 4. Xét tốt nghiệp

Sau khi hoàn thành chương trình học, sinh viên có thể đăng ký xét tốt nghiệp. Hệ thống sẽ kiểm tra điều kiện tốt nghiệp và cập nhật trạng thái của sinh viên.

## Các Lược Đồ

- Use case diagram
  ![image](https://github.com/bichdao090202/Nhom24_HeThongQuanLyGiaoDucTheoTinChi/assets/84237256/13396977-f871-48f0-9700-edd2ed7db725)
- Class diagram
  ![image](https://github.com/bichdao090202/Nhom24_HeThongQuanLyGiaoDucTheoTinChi/assets/84237256/4b822c77-0a4d-4ba0-9015-e355c97d86a0)
- Component diagram
  ![image](https://github.com/bichdao090202/Nhom24_HeThongQuanLyGiaoDucTheoTinChi/assets/84237256/78608f8e-8fe9-45e9-99fc-831b80c314fb)
- Package diagram
  ![image](https://github.com/bichdao090202/Nhom24_HeThongQuanLyGiaoDucTheoTinChi/assets/84237256/29f40a4e-6bc3-4123-9143-028837ba35e0)
- Deployment diagram
  ![image](https://github.com/bichdao090202/Nhom24_HeThongQuanLyGiaoDucTheoTinChi/assets/84237256/b5796fd8-a789-4690-9e47-4d03d44fd3c7)

## Triển Khai và Thực Thi

Hệ thống đã được triển khai và một số chức năng đã được thực hiện như xem kết quả học tập của sinh viên, xem lịch học, đăng ký học phần

![image](https://github.com/bichdao090202/Nhom24_HeThongQuanLyGiaoDucTheoTinChi/assets/84237256/0eb4133c-90e1-45ab-99a5-7fdf6512c6b1)
![image](https://github.com/bichdao090202/Nhom24_HeThongQuanLyGiaoDucTheoTinChi/assets/84237256/38f05b27-7f09-4b59-8121-b8c266d4f721)
![image](https://github.com/bichdao090202/Nhom24_HeThongQuanLyGiaoDucTheoTinChi/assets/84237256/7e35a017-80ac-4b66-b2ad-98a879b692b4)
