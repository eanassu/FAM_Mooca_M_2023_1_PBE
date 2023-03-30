<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.vemprafam.pojo.Produto"%>
<%@page import="java.util.List"%>
<%@page import="br.vemprafam.dao.DaoProduto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produtos</title>
</head>
<body>
<table border="1">
<tr>
	<th>código</th>
	<th>descrição</th>
	<th>data da compra</th>
	<th>quantidade</th>
	<th>preço</th>
</tr>
<%
DaoProduto dao = new DaoProduto();
List<Produto> lista = dao.getLista();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
for( Produto p: lista ) {
	String dataF = dateFormat.format(p.getDataCompra());
	String precoF = currencyFormat.format(p.getPreco());
%>
<tr>
	<td><%=p.getCodigo() %></td>
	<td><%=p.getDescricao() %></td>
	<td><%=dataF %></td>
	<td><%=p.getQuantidade() %></td>
	<td><%=precoF %></td>
</tr>
<%
}
%>

</table>
<a href="/Projeto">voltar</a>
</body>
</html>