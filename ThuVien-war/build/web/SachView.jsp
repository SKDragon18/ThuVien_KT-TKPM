<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%--<c:set var="root" value="${pageContext.servletContext.contextPath}" />--%>
<head>
<meta charset="ISO-8859-1">
    <!-- Các thẻ meta, title, ... -->
    <title>Quản lý sách</title>
</head>
<body>
    <div>
        <h3>Menu</h3>
        <a href="/ThuVien-war/SachServlet">Sách</a>
        <a href="/ThuVien-war/DocGiaServlet">Độc giả</a>
        <a href="/ThuVien-war/MuonTraServlet">Mượn trả</a>
    </div>
    <div>
        <h2>Quản lý sách</h2>
    </div>
    <div>
        <form action="SachServlet" method="post">
            ID: <input type="text" readonly="True" name ="id" value ="${idChon}"/><br>
            Tên sách: <input type="text" name="ten" value ="${tenChon}"/><br>
            Số thứ tự: <input type="text" name="stt" value ="${sttChon}"/><br>
            Tác giả: <input type="text" name="tacGia" value ="${tacGiaChon}"/><br>
            Giá: <input type="number" name="gia" value ="${giaChon}"/><br>
            Tình trạng : <input type="text" name="tinhTrang" value ="${tinhTrangChon}"/><br>
            <p>${message}</p>
            <c:if test="${btnStatus=='btnThem'}">
            <input type="submit" name="btn" value="Thêm"><br>
            </c:if>
            <c:if test="${btnStatus=='btnSua'}">
            <input type="submit" name="btn" value="Sửa"><br>
            <input type="submit" name="btn" value="Xóa"><br>
            </c:if>
            <br>
            <a href="/ThuVien-war/SachServlet">Tải lại trang</a><br>
        </form>
    </div>
    
    <div>
        <h2>Sách trong thư viện</h2>
        <table id="book-table" border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>STT</th>
                    <th>Tác giả</th>
                    <th>Giá</th>
                    <th>Tình trạng</th>
                    <th>Chọn</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${danhSach}" var="sach">
                    <tr>
                        <td>${sach.id}</td>
                        <td>${sach.ten}</td>
                        <td>${sach.STT}</td>
                        <td>${sach.tacGia}</td>
                        <td>${sach.gia}</td>
                        <td>${sach.tinhTrang}</td>
                        <td><a href="/ThuVien-war/SachServlet?id=${sach.id}">Chọn</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>