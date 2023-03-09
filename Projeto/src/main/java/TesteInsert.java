import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.vemprafam.pojo.Produto;

public class TesteInsert {

	public static void main(String[] args) throws ParseException, SQLException {
		Scanner scan = new Scanner( System.in );
		int codigo = scan.nextInt();
		String descricao = scan.next();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataStr = scan.next();
		Date dataCompra = format.parse(dataStr);
		int quantidade = scan.nextInt();
		double preco = scan.nextDouble();
		
		Produto produto = new Produto(codigo, descricao, dataCompra, quantidade, preco);
		
		System.out.println(produto);
		
		Connection connection = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/","SA","");
		Statement stmt = connection.createStatement();
		SimpleDateFormat formatData = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "INSERT INTO PRODUTOS VALUES("+codigo+","+
					 "'"+descricao+"',"+
					 "'"+formatData.format(dataCompra)+"',"+
					 quantidade+","+
					 preco+")";
		System.out.println(sql);	
		
		stmt.executeUpdate(sql);
		
	}

}
