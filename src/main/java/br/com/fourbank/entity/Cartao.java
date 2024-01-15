package br.com.fourbank.entity;

public class Cartao {

	private Integer nCartao;
	private String tipoCartao;
	private String dataValidade;
	private Integer codigoSeguranca;
	
	public Cartao() {}
	
	public Cartao(Integer nCartao, String tipoCartao, String dataValidade, Integer codigoSeguranca) {
		super();
		this.nCartao = nCartao;
		this.tipoCartao = tipoCartao;
		this.dataValidade = dataValidade;
		this.codigoSeguranca = codigoSeguranca;
	}
	
	public Integer getnCartao() {
		return nCartao;
	}
	public void setnCartao(Integer nCartao) {
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
	public Integer getCodigoSeguranca() {
		return codigoSeguranca;
	}
	public void setCodigoSeguranca(Integer codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}
	
	
}
