<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeira p�gina JSP</title>
</head>
<body>
<%-- coment�rio JSP --%>
<%
out.println("Hello World JSP!");
System.out.println("esta vai para o console");
String mensagem="Mensagem teste";
%>
<p>
<%=mensagem %>
</p>
<p>
<% out.println(mensagem); %>
</p>
</body>
</html>