<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.vemprafam.pojo.Produto"%>
<%@page import="br.vemprafam.dao.DaoProduto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produto</title>
</head>
<body>
<form action="controller">
<%
int codigo = Integer.parseInt(request.getParameter("codigo"));
DaoProduto dao = new DaoProduto();
Produto p = dao.buscarPeloCodigo(codigo);
String dataf = new SimpleDateFormat("dd/MM/yyyy").format(p.getDataCompra());
%>
c�digo: <input type="text" name="codigo" value="<%=p.getCodigo()%>"/><br/>
descri��o: <input type="text" name="descricao" value="<%=p.getDescricao()%>"/><br/>
data da compra: <input type="text" name="dataCompra" value="<%=dataf%>"/><br/>
quantidade: <input type="text" name="quantidade" value="<%=p.getQuantidade()%>"/><br/>
pre�o: <input type="text" name="preco" value="<%=p.getPreco()%>"/><br/>
<input type="hidden" name="op" value="Alteracao"/>
<input type="submit" value="enviar"/><br/>
</form>
<a href="/Projeto">voltar</a>
</body>
</html>