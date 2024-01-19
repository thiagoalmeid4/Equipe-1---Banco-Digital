package br.com.fourbank.entity;

public class Pagamento {
	
	private double desconto;
	private double valorTotal;
	private boolean status;
	
	public Pagamento() {}
	
	public Pagamento(double desconto, double valorTotal, boolean status) {
		super();
		this.desconto = desconto;
		this.valorTotal = valorTotal;
		this.status = status;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public boolean  getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
