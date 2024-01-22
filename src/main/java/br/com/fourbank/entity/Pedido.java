package br.com.fourbank.entity;

import java.util.List;

public class Pedido {
	private List<Produto> produtos;
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	private Cliente cliente;
	private Integer id;
	private Double valorTotal;
	private String dataDoPedido;
	private Boolean status;
	
	public Pedido() {}
	
	public Pedido(Integer id, Double valorTotal, String dataDoPedido, Boolean status) {
		super();
		this.id = id;
		
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
