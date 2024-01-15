package br.com.fourbank.entity;

public class Pedido {

	private Integer id;
	private Double frete;
	private Double valorTotal;
	private String dataDoPedido;
	private Boolean status;
	
	public Pedido() {}
	
	public Pedido(Integer id, Double frete, Double valorTotal, String dataDoPedido, Boolean status) {
		super();
		this.id = id;
		this.frete = frete;
		this.valorTotal = valorTotal;
		this.dataDoPedido = dataDoPedido;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getFrete() {
		return frete;
	}
	public void setFrete(Double frete) {
		this.frete = frete;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getDataDoPedido() {
		return dataDoPedido;
	}
	public void setDataDoPedido(String dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
}
