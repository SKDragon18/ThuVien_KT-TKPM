<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%--<c:set var="root" value="${pageContext.servletContext.contextPath}" />--%>
<head>
<meta charset="ISO-8859-1">
    <!-- Các thẻ meta, title, ... -->
    <title>Trang chủ</title>
</head>
<body>
    <div>
        <h3>Menu</h3>
        <a href="/ThuVien-war/SachServlet">Sách</a>
        <a href="/ThuVien-war/DocGiaServlet">Độc giả</a>
        <a href="/ThuVien-war/MuonTraServlet">Mượn trả</a>
    </div>
    <h1>Chào mừng đến với hệ quản lý thư viện</h1>
    <h2>Chức năng: Quản lý sách, độc giả, cho mượn, trả sách </h2>
</body>
</html>