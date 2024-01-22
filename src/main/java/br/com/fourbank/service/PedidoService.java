package br.com.fourbank.service;

import java.util.List;

import br.com.fourbank.dao.PedidoDao;
import br.com.fourbank.entity.Pedido;
import br.com.fourbank.entity.Produto;

public class PedidoService {
	PedidoDao pedidoDao = new PedidoDao();

	public void adicionarPedido(Pedido pedido) {
		pedidoDao.addPedido(pedido);
	}

	public List<Pedido> listarPedidos() {
		return pedidoDao.listarPedidos();
	}

	public boolean realizarVenda(Pedido pedido) {
		double valorTotal = 0;
		for (Produto produto : pedido.getProdutos())	{
		valorTotal = valorTotal + produto.getPreco();
		}
		pedido.setValorTotal(valorTotal);
		if (pedido.getCliente().getSaldo() >= pedido.getValorTotal())

		{
			pedido.getCliente().setSaldo(pedido.getCliente().getSaldo() - pedido.getValorTotal());
			return true;
		}

		return false;
	}
}
