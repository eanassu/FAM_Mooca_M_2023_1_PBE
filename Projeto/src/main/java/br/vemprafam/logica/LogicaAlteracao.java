package br.vemprafam.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoProduto;
import br.vemprafam.pojo.Produto;

public class LogicaAlteracao implements Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String descricao = request.getParameter("descricao");
		Date dataCompra;
		try {
			dataCompra = dateFormat.parse(request.getParameter("dataCompra"));
		} catch (ParseException e) {
			dataCompra = new Date();
			e.printStackTrace();
		}
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		DaoProduto dao = new DaoProduto();
		dao.update(new Produto(codigo,descricao,dataCompra,quantidade,preco));
		return "alterado.jsp";
	}

}
