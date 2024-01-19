package br.com.fourbank.entity;

public class Cartao {

	private int nCartao;
	private String tipoCartao;
	private String dataValidade;
	private int codigoSeguranca;
	
	public Cartao() {}
	
	public Cartao(int nCartao, String tipoCartao, String dataValidade, int codigoSeguranca) {
		super();
		this.nCartao = nCartao;
		this.tipoCartao = tipoCartao;
		this.dataValidade = dataValidade;
		this.codigoSeguranca = codigoSeguranca;
	}
	
	public int getnCartao() {
		return nCartao;
	}
	public void setnCartao(int nCartao) {
		this.nCartao = nCartao;
	}
	public String getTipoCartao() {
		return tipoCartao;
	}
	public void setTipoCartao(String tipoCartao) {
		this.tipoCartao = tipoCartao;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}
	public void setCodigoSeguranca(int codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}
	
	
}
