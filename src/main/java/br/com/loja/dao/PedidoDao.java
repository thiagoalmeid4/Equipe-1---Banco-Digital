package br.com.loja.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.loja.entity.Pedido;

public class PedidoDao {

	private List<Pedido> pedidos;

	public PedidoDao (List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public List<Pedido> pedidoPorCliente(String cpf){
		List<Pedido> pedidosDoCliente = new ArrayList<Pedido>();
		for (Pedido p:pedidos) {
			if(p.getCliente().getCpf().equals(cpf)) {
				pedidosDoCliente.add(p);
			}
		}
		return pedidosDoCliente;
	}

	public void addPedido(Pedido pedido) {
		pedido.setId(pedidos.size());
		pedidos.add(pedido);
	}

	public List<Pedido> listarPedidos() {
		return pedidos;
	}

}
