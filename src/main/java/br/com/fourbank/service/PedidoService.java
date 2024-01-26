package br.com.fourbank.service;

import java.util.List;

import br.com.fourbank.dao.BancoDeDados;
import br.com.fourbank.dao.PedidoDao;
import br.com.fourbank.dao.ProdutoDao;
import br.com.fourbank.entity.Pedido;
import br.com.fourbank.entity.Produto;

public class PedidoService {
	
	private PedidoDao pedidoDao;
	private ProdutoDao produtoDao;

	public PedidoService (BancoDeDados bancoDeDados) {
		this.pedidoDao = new PedidoDao(bancoDeDados.getPedidos());
		this.produtoDao = new ProdutoDao(bancoDeDados.getProdutos());
	}

	public List<Pedido> listarPedidosPorCliente(String cpf){
		return pedidoDao.pedidoPorCliente(cpf);
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
			pedidoDao.addPedido(pedido);
			for (Produto p : pedido.getProdutos())	{
				produtoDao.removerQtd(p);
			}
			return true;
		}

		return false;
	}
}
