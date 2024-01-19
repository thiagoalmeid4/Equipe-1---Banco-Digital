package br.com.fourbank.view;

import br.com.fourbank.entity.Pedido;
import br.com.fourbank.service.PedidoService;

public class Main {

	public static void main(String[] args) {
		PedidoService pedidoService = new PedidoService();
		Pedido pedido = new Pedido();
		pedido.setId(1);
		pedido.setValorTotal(60.0);
		pedido.setDataDoPedido("18/01/2024");
		pedido.setStatus(true);
		pedidoService.adicionarPedido(pedido);
		System.out.println(pedido.getValorTotal());
	}

}
