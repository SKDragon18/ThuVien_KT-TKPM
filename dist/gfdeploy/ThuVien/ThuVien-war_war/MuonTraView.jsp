<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%--<c:set var="root" value="${pageContext.servletContext.contextPath}" />--%>
<head>
<meta charset="ISO-8859-1">
    <!-- Các thẻ meta, title, ... -->
    <title>Mượn trả sách</title>
</head>
<body>
    <div>
        <h3>Menu</h3>
        <a href="/ThuVien-war/SachServlet">Sách</a>
        <a href="/ThuVien-war/DocGiaServlet">Độc giả</a>
        <a href="/ThuVien-war/MuonTraServlet">Mượn trả</a>
    </div>
    <div>
        <h2>Quản lý mượn trả</h2>
    </div>
    <div>
        <form action="MuonTraServlet" method="post">
            ID sách: <input type="text" name ="bookId" /><br>
            ID độc giả: <input type="text" name ="docGiaId" /><br>
            <p>${message}</p>
            Action: 
                <select name="action">
                    <option value="borrow">Borrow</option>
                    <option value="return">Return</option>
                </select><br>
                <input type="submit" value="Xác nhận"><br>
            <a href="/ThuVien-war/MuonTraServlet">Tải lại trang</a><br>
        </form>
    </div>
    
    <div>
        <h2>Lịch sử</h2>
        <table id="book-table" border="1">
            <thead>
                <tr>
                    <th>ID Sách</th>
                    <th>ID Độc giả</th>
                    <th>Ngày mượn</th>
                    <th>Ngày trả</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${dsLichSu}" var="row">
                    <tr>
                        <td>${row.idSach}</td>
                        <td>${row.idDocGia}</td>
                        <td>${row.ngayMuon}</td>
                        <td>${row.ngayTra}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>