package br.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletIMC
 */
@WebServlet("/calcularImc")
public class ServletIMC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIMC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double peso = Double.parseDouble(request.getParameter("peso"));
		double altura = Double.parseDouble(request.getParameter("altura"));
		double imc = peso/(altura*altura);
		String avaliacao;
		if( imc < 18.5 ) {
			avaliacao = "magro";
		} else if ( imc < 25 ) {
			avaliacao = "normal";
		} else if ( imc < 30 ) {
			avaliacao = "sobrepeso";
		} else {
			avaliacao = "obeso";
		}
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Resultado</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "Seu IMC é " + String.format("%.2f",imc) + "\r\n"
				+ avaliacao
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
