package br.com.fourbank.service;

import java.util.List;

import br.com.fourbank.dao.PedidoDao;
import br.com.fourbank.entity.Pedido;

public class PedidoService {
	PedidoDao pedidoDao = new PedidoDao();

	public void adicionarPedido(Pedido pedido) {
		pedidoDao.addPedido(pedido);
	}

	public List<Pedido> listarPedidos() {
		return pedidoDao.listarPedidos();
	}

}
