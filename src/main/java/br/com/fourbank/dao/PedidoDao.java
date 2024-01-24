package br.com.fourbank.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fourbank.entity.Cliente;
import br.com.fourbank.entity.Pedido;
import br.com.fourbank.entity.Produto;

public class PedidoDao {
	ArrayList<Pedido> pedidos = new ArrayList<>();
	
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
		pedidos.add(pedido);
	}

	public List<Pedido> listarPedidos() {
		return pedidos;
	}

}
