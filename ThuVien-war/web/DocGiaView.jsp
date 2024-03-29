<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%--<c:set var="root" value="${pageContext.servletContext.contextPath}" />--%>
<head>
<meta charset="ISO-8859-1">
    <!-- Các thẻ meta, title, ... -->
    <title>Danh sách độc giả</title>
</head>
<body>
    <div>
        <h3>Menu</h3>
        <a href="/ThuVien-war/SachServlet">Sách</a>
        <a href="/ThuVien-war/DocGiaServlet">Độc giả</a>
        <a href="/ThuVien-war/MuonTraServlet">Mượn trả</a>
    </div>
    <div>
        <h2>Quản lý độc giả</h2>
    </div>
    <div>
        <form action="DocGiaServlet" method="post">
            ID: <input type="text" readonly="True" name ="id" value ="${idChon}"/><br>
            Họ và tên độc giả: <input type="text" name="ten" value ="${tenChon}"/><br>
            Giới tính: 
            <select name="gioiTinh" value ="${gioiTinhChon}">
                    <option value="nam">Nam</option>
                    <option value="nu">Nữ</option>
             </select>
            <br>
            Ngày sinh:
            <input type="date" name="ngaySinh" value ="${ngaySinhChon}"/>
            <br>
            Số điện thoại:
            <input type="text" name ="sdt" value="${sdtChon}"/>
            <br>
            <p>${message}</p>
            <c:if test="${btnStatus=='btnThem'}">
            <input type="submit" name="btn" value="Thêm"><br>
            </c:if>
            <c:if test="${btnStatus=='btnSua'}">
            <input type="submit" name="btn" value="Sửa"><br>
            <input type="submit" name="btn" value="Xóa"><br>
            </c:if>
            <br>
            <a href="/ThuVien-war/DocGiaServlet">Tải lại trang</a><br>
        </form>
    </div>
    
    <div>
        <h2>Danh sách độc giả</h2>
        <table id="book-table" border="1">
            <thead>
                <tr>
                    <th>Độc Giả ID</th>
                    <th>Tên</th>
                    <th>Giới tính</th>
                    <th>Ngày sinh</th>
                    <th>Ngày đăng ký</th>
                    <th>Số điện thoại</th>
                    <th>Chọn</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${danhSachDocGia}" var="docGia">
                    <tr>
                        <td>${docGia.id}</td>
                        <td>${docGia.ten}</td>
                        <td>${docGia.gioiTinh}</td>
                        <td>${docGia.ngaySinh}</td>
                        <td>${docGia.ngayDK}</td>
                        <td>${docGia.sdt}</td>
                        <td><a href="/ThuVien-war/DocGiaServlet?id=${docGia.id}">Chọn</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>