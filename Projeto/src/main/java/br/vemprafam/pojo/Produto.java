package br.vemprafam.pojo;

import java.util.Date;

public class Produto {

	private int codigo;
	private String descricao;
	private Date dataCompra;
	private int quantidade;
	private double preco;
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produto(int codigo, String descricao, Date dataCompra, int quantidade, double preco) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.dataCompra = dataCompra;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", dataCompra=" + dataCompra + ", quantidade="
				+ quantidade + ", preco=" + preco + "]";
	}
	
}
