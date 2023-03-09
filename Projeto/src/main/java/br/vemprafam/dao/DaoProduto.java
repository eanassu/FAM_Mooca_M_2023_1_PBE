package br.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.vemprafam.pojo.Produto;

public class DaoProduto {
	private String url="jdbc:hsqldb:hsql://localhost/";
	private String user="SA";
	private String password="";
	Connection connection;
	public DaoProduto() {
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void insert(Produto produto) {
		String sql = "INSERT INTO PRODUTOS VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, produto.getCodigo());
			pstmt.setString(2, produto.getDescricao());
			pstmt.setDate(3, 
					new java.sql.Date(produto.getDataCompra().getTime()));
			pstmt.setInt(4, produto.getQuantidade());
			pstmt.setDouble(5, produto.getPreco());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delete(Produto produto) {
		String sql = "DELETE FROM PRODUTOS WHERE CODIGO=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, produto.getCodigo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void update(Produto produto) {
		String sql = "UPDATE PRODUTOS SET "
				+ "descricao=?,dataCompra=?,quantidade=?,preco=? "
				+ "WHERE CODIGO=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, produto.getDescricao());
			pstmt.setDate(2, 
					new java.sql.Date(produto.getDataCompra().getTime()));
			pstmt.setInt(3, produto.getQuantidade());
			pstmt.setDouble(4, produto.getPreco());
			pstmt.setInt(5, produto.getCodigo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Produto> getLista() {
		List<Produto> lista = new ArrayList<>();
		String sql = "SELECT * FROM PRODUTOS";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while( rs.next() ) {
				lista.add(new Produto(rs.getInt(1),
									  rs.getString(2),
									  rs.getDate(3),
									  rs.getInt(4),
									  rs.getDouble(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public Produto buscarPeloCodigo(int codigo) {
		String sql = "SELECT * FROM PRODUTOS WHERE CODIGO=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			ResultSet rs = pstmt.executeQuery();
			if( rs.next() ) {
				return new Produto(rs.getInt(1),
						  rs.getString(2),
						  rs.getDate(3),
						  rs.getInt(4),
						  rs.getDouble(5));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		DaoProduto dao = new DaoProduto();
		//Produto produto = new Produto(10,"novo",new Date(), 500,500);
		//dao.update(produto);
		//System.out.println(dao.getLista());
		System.out.println(dao.buscarPeloCodigo(1));
	}
}

















