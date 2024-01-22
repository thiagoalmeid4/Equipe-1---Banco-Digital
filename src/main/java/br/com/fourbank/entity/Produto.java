package br.com.fourbank.entity;

public class Produto {

	private String nome;//
	private double preco;//
	private String codigo;//
	private String descricao;
	private int quantidade;//
	private String categoria;
	private String marca;//
	
	public Produto() {}
	
	public Produto(String nome, double preco, String codigo, String descricao, int quantidade, String categoria,
			String marca) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.categoria = categoria;
		this.marca = marca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
}
