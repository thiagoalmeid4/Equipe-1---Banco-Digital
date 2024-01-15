package br.com.fourbank;

public class Pagamento {
	
	private Double desconto;
	private Double valorTotal;
	private Boolean status;
	
	public Pagamento() {}
	
	public Pagamento(Double desconto, Double valorTotal, Boolean status) {
		super();
		this.desconto = desconto;
		this.valorTotal = valorTotal;
		this.status = status;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

}
