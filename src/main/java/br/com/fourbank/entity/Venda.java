package br.com.fourbank.entity;

public class Venda {
	private int idPedido;
	private String codigoProduto;
	private String nomeProduto;
	private double preco;
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Venda(int idPedido, String codigoProduto, String nomeProduto, double preco) {
		super();
		this.idPedido = idPedido;
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
