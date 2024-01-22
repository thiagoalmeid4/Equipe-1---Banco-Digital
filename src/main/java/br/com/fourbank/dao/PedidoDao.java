package br.com.fourbank.dao;

import java.util.ArrayList;
import java.util.List;


import br.com.fourbank.entity.Pedido;

public class PedidoDao {
	ArrayList<Pedido> pedidos = new ArrayList<>();

	public void addPedido(Pedido pedido) {
		pedidos.add(pedido);
	}

	public List<Pedido> listarPedidos() {
		return pedidos;
	}
	
}
