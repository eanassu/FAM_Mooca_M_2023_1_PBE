<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produtos (taglib)</title>
</head>
<body>
<table border="1">
<tr>
	<th>c�digo</th>
	<th>descri��o</th>
	<th>data da compra</th>
	<th>quantidade</th>
	<th>pre�o</th>
</tr>
<c:forEach var="p" items="${produtos}">
<tr>
  <td>${p.codigo}</td>
  <td>${p.descricao}</td>
  <td><fmt:formatDate value="${p.dataCompra}" pattern="dd/MM/yyyy"/></td>
  <td>${p.quantidade}</td>
  <td><fmt:formatNumber value="${p.preco}" type="currency"/></td>
</tr>
</c:forEach>
</table>
<a href="/Projeto">voltar</a>
</body>
</html>












