package br.com.loja.entity;

public class Cliente {

	private int id;
	private String nome;
	private double saldo;
	private String cpf;
	private String senha;
	private String dataDeNascimento;
	
	public Cliente() {}
	
	public Cliente(int id, String nome, double saldo, String cpf, String senha, String dataDeNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.saldo = saldo;
		this.cpf = cpf;
		this.senha = senha;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome ==null|| nome.isBlank()) {
			throw new RuntimeException("Nome é obrigatório");
		}
		else
		this.nome = nome;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		String regex= "^[0-9]{3}[0-9]{3}[0-9]{3}[0-9]{2}$";
		String cpfFormatado = cpf.replace("-", "").replace(".", "");
		cpf = cpfFormatado.strip();
		if(cpf.matches(regex)) {
			this.cpf = cpf;
		}
		else {
			throw new RuntimeException("Cpf inválido");
		}
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		//String regex ="^( ?=.*[0-9]) ( ?=.*[!@#$^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=\\S+$).{8,}$";
		String regex = "^.{6,}$";
		if(senha.matches(regex)&&senha!=null)
		this.senha = senha;
		else
			throw new RuntimeException("A senha precisa de no minimo 6 caracteres");
			//throw new RuntimeException("A senha precisa ter no minimo 8 caracteres, 1 deles sendo número e 1 deles sendo um caracter especial");
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		String regex = "^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$";
		if (dataDeNascimento.matches(regex))
		this.dataDeNascimento = dataDeNascimento;
		else
			throw new RuntimeException("Data inválida");
	}
	
	
	
}
