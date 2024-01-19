package br.com.fourbank.entity;

public class Pedido {

	private int id;
	private double frete;
	private double valorTotal;
	private String dataDoPedido;
	private boolean status;
	
	public Pedido() {}
	
	public Pedido(int id, double frete, double valorTotal, String dataDoPedido, boolean status) {
		super();
		this.id = id;
		this.frete = frete;
		this.valorTotal = valorTotal;
		this.dataDoPedido = dataDoPedido;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getFrete() {
		return frete;
	}
	public void setFrete(double frete) {
		this.frete = frete;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getDataDoPedido() {
		return dataDoPedido;
	}
	public void setDataDoPedido(String dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
