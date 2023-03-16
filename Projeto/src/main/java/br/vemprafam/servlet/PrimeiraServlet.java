package br.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoProduto;
import br.vemprafam.pojo.Produto;

/**
 * Servlet implementation class PrimeiraServlet
 */
@WebServlet("/PrimeiraServlet")
public class PrimeiraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PrimeiraServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DaoProduto dao = new DaoProduto();
		List<Produto> lista = dao.getLista();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Tabela</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<table border=\"1\">\r\n"
				+ "<tr>\r\n"
				+ "	<th>c�digo</th>\r\n"
				+ "	<th>descri��o</th>\r\n"
				+ "	<th>data da compra</th>\r\n"
				+ "	<th>quantidade</th>\r\n"
				+ "	<th>pre�o</th>\r\n"
				+ "</tr>\r\n"
				+ "");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		for( Produto p: lista ) {
			out.println("<tr>\r\n"
					+ "	<td>"+p.getCodigo()+"</td>\r\n"
					+ "	<td>"+p.getDescricao()+"</td>\r\n"
					+ "	<td>"+dateFormat.format(p.getDataCompra())+"</td>\r\n"
					+ "	<td>"+p.getQuantidade()+"</td>\r\n"
					+ "	<td>"+currencyFormat.format(p.getPreco())+"</td>\r\n"
					+ "</tr>");
		}
		out.println("</table>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
