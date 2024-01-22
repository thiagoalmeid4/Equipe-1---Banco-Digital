package br.com.fourbank.view;

import br.com.fourbank.service.PedidoService;
import br.com.fourbank.entity.Pedido;
import br.com.fourbank.entity.Produto;

import java.util.ArrayList;
import java.util.List;

import br.com.fourbank.entity.Cliente;

public class Main {

	public static void main(String[] args) {
		Produto p1 = new Produto();
		Produto p2 = new Produto();
		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		PedidoService pedidoService = new PedidoService();
		cliente.setSaldo(50d);
		p1.setPreco(10d);
		p2.setPreco(15d);
		List<Produto> produtos = new ArrayList<>();
		produtos.add(p1);
		produtos.add(p2);
		pedido.setCliente(cliente);
		pedido.setProdutos(produtos);
		pedidoService.realizarVenda(pedido);
		System.out.println(cliente.getSaldo());
		System.out.println(pedido.getValorTotal());
				

	}

}
