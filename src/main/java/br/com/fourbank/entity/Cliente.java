package br.com.fourbank.entity;

public class Cliente {

	private Integer id;
	private String nome;
	private Double saldo;
	private String cpf;
	private String senha;
	private String dataDeNascimento;
	
	public Cliente() {}
	
	public Cliente(Integer id, String nome, Double saldo, String cpf, String senha, String dataDeNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.saldo = saldo;
		this.cpf = cpf;
		this.senha = senha;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	
	
}
