package br.com.loja.service;

import java.util.ArrayList;
import java.util.List;

import br.com.loja.dao.BancoDeDados;
import br.com.loja.dao.ClienteDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.entity.Cliente;
import br.com.loja.entity.Pedido;
import br.com.loja.entity.Produto;
import br.com.loja.entity.Venda;
import br.com.loja.dao.PedidoDao;

public class PedidoService {

	private PedidoDao pedidoDao;
	private ProdutoDao produtoDao;
	private ClienteDao clienteDao;

	public PedidoService(BancoDeDados bancoDeDados) {
		this.pedidoDao = new PedidoDao(bancoDeDados.getPedidos());
		this.clienteDao = new ClienteDao(bancoDeDados.getClientes());
		this.produtoDao = new ProdutoDao(bancoDeDados.getProdutos());
	}

	public List<Pedido> listarPedidosPorCliente(String cpf) {
		return pedidoDao.pedidoPorCliente(cpf);
	}

	public List<Pedido> listarPedidos() {
		return pedidoDao.listarPedidos();
	}

	public void realizarVenda(Pedido pedido) {
		double valorTotal = 0;
		for (Produto produto : pedido.getProdutos()) {
			valorTotal = valorTotal + produto.getPreco();
		}
		pedido.setValorTotal(valorTotal);
		if (pedido.getCliente().getSaldo() >= pedido.getValorTotal())

		{
			pedido.getCliente().setSaldo(pedido.getCliente().getSaldo() - pedido.getValorTotal());
			pedidoDao.addPedido(pedido);
			for (Produto p : pedido.getProdutos()) {
				produtoDao.removerQtd(p);
				addSaldoVendedor(p.getIdVendedor(), p.getPreco());
			}
		} else	{
			throw new RuntimeException("Saldo insuficiente.");
		}
	}

	public List<Venda> listarVendas(int id) {
		List<Venda> minhasVendas = new ArrayList<>();
		for (Pedido p : pedidoDao.listarPedidos()) {
			for (Produto x : p.getProdutos()) {
				if (x.getIdVendedor() == id) {
					minhasVendas.add(new Venda(p.getId(), x.getCodigo(), x.getNome(), x.getPreco()));
				}
			}
		}
		return minhasVendas;
	}

	private void addSaldoVendedor(int idCliente, double saldo) {
		for (Cliente cliente : clienteDao.listarclientes()) {
			if (cliente.getId() == idCliente) {
				cliente.setSaldo(cliente.getSaldo() + saldo);
			}
		}

	}
}
