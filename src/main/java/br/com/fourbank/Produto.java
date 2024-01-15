package br.com.fourbank;

public class Produto {

	private String nome;
	private Double preco;
	private String codigo;
	private String descricao;
	private Integer quantidade;
	private String categoria;
	private String marca;
	
	public Produto() {}
	
	public Produto(String nome, Double preco, String codigo, String descricao, Integer quantidade, String categoria,
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
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
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
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
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
