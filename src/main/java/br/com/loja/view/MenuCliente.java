package br.com.loja.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.loja.dao.BancoDeDados;
import br.com.loja.entity.Cliente;
import br.com.loja.entity.Pedido;
import br.com.loja.entity.Produto;
import br.com.loja.entity.Venda;
import br.com.loja.service.ClienteService;
import br.com.loja.service.PedidoService;
import br.com.loja.service.ProdutoService;
import br.com.loja.dao.ProdutoDao;

public class MenuCliente {

	private ClienteService clienteService;
	private PedidoService pedidoService;
	private ProdutoService produtoService;
	List<Produto> lista = new ArrayList<>();
	private Cliente cliente = new Cliente();
	private Produto produto = new Produto();

	private Cliente clienteLogado;
	private final BancoDeDados bancoDeDados = new BancoDeDados();

	Scanner input = new Scanner(System.in);

	public MenuCliente() {
		this.clienteService = new ClienteService(bancoDeDados);
		this.pedidoService = new PedidoService(bancoDeDados);
		this.produtoService = new ProdutoService(bancoDeDados);

	}

	private void menuPrincipal() {
		Scanner input = new Scanner(System.in);
		

		System.out.println("Bem vindo a nossa loja:");

		System.out.println(" 1-Cadastrar\n" + " 2-Acessar conta");
		int escolha = input.nextInt();
		switch (escolha) {
		case 1:
			try {
				Inputs.cadastrarCliente(cliente, clienteService);
				clienteService.addCliente(cliente);
				cliente = new Cliente();
				menuPrincipal();
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
				menuPrincipal();
			}
			break;
		case 2:
			login();
			main();
			break;

		default:
			menuPrincipal();
			break;

		}

	}
	
	

	private void login() {
		try {

			String nome;
			System.out.println("Insira nome");
			nome = input.nextLine();
			System.out.println("Insira senha:");
			String senha = input.nextLine();

			clienteLogado = clienteService.getNomeCliente(nome, senha);
			main();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			menuPrincipal();
		}
	}

	public void executar() {
		while (true) {
			menuPrincipal();
		}
	}

	private void main() {
		try {
			Scanner input = new Scanner(System.in);

			boolean flag = true;
			System.out.println("Agora você está no seu menu:");
			while (flag) {
				System.out.println("Bem vindo\n" + "--------------------------------\n" + " 1-Mostrar saldo\n"
						+ " 2-Depositar\n" + " 3-Acessar como vendedor\n" + " 4-Listar pedidos\n"
						+ " 5-Comprar produtos\n" + " 6-Sair da conta");
				int escolha = input.nextInt();
				switch (escolha) {
				case 1:
					System.out.println("Nome: " + clienteLogado.getNome());
					System.out.println("Saldo: " + clienteService.mostrarSaldo(clienteLogado.getId()));
					break;
				case 2:
					System.out.println("Qual valor para o deposito:");
					var deposito = input.nextDouble();
					if (deposito > 0) {
						clienteService.depositar(clienteLogado.getId(), deposito);
						System.out.println("Valor de R$" + deposito + " foi adicionado com sucesso");
					} else {
						System.out.println("Valor inválido");
					}
					break;
				case 3:
					menuVendedor();
					break;
				case 4:
					for (Pedido p : pedidoService.listarPedidosPorCliente(clienteLogado.getCpf())) {
						System.out.println("\nId: " + p.getId() + "\nData: " + p.getDataDoPedido() + "\nValor total: "
								+ p.getValorTotal());
						for (Produto pr : p.getProdutos()) {
							System.out.println("\nProduto: " + pr.getNome() + "\nCódigo: " + pr.getCodigo()
									+ "\nPreço: " + pr.getPreco());
						}
					}

					break;

				case 5:

					comprarProduto();

					break;
				case 6:
					menuPrincipal();
					break;
				}
			}

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			main();
		}
	}

	private void menuVendedor() {
		try {
			Scanner input = new Scanner(System.in);

			int numero;
			System.out.println(" 1-Cadastre seu produto\n" + " 2-listar vendas\n" + " 3-listar produtos cadastrados\n"
					+ " 4-sair");
			numero = input.nextInt();

			switch (numero) {
			case 1:
				Inputs.cadastrarProduto(produto);
				produtoService.cadastrar(produto);
				produto = new Produto();
				menuVendedor();
				
				break;

			case 2:
				for (Venda v : pedidoService.listarVendas(clienteLogado.getId())) {
					System.out.println("\nId: " + v.getIdPedido() + "\nCódigo: " + v.getCodigoProduto() + "\nProduto: "
							+ v.getNomeProduto() + "\nPreço: " + v.getPreco());
				}
				break;
			case 4:
				main();
				break;
			case 3:
				for (Produto p : produtoService.listarProdutosPorVendedor(clienteLogado.getId())) {
					System.out.println("\nProduto: " + p.getNome() + "\nMarca: " + p.getMarca() + "\nCategoria: "
							+ p.getCategoria() + "\nCódigo: " + p.getCodigo() + "\nPreço: " + p.getPreco()
							+ "\nQuantidade em estoque: " + p.getQuantidade() + "\n");
				}
				menuVendedor();
				break;
			default:
				menuVendedor();
				break;
			}

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			menuVendedor();
		}
	}

	private void comprarProduto() {
		try {
			boolean condicao = true;
			int sensor;
			Scanner input = new Scanner(System.in);

			for (Produto p : produtoService.listar()) {
				System.out.println("\nProduto: " + p.getNome() + "\nMarca: " + p.getMarca() + "\nCategoria: "
						+ p.getCategoria() + "\nCódigo: " + p.getCodigo() + "\nPreço: " + p.getPreco()
						+ "\nQuantidade em estoque: " + p.getQuantidade() + "\n");
			}

			while (condicao) {
				System.out.println(" 1-Adicionar produto no carrinho\n" + " 2-Listar seu carrinho\n"
						+ " 3- Remover item do carrinho\n" + " 4-Comprar itens do carrinho\n 0- Sair\n");
				sensor = input.nextInt();
				String cod;

				switch (sensor) {
				case 1:

					System.out.println("Informe o código do produto que produto deseja comprar");
					cod = input.next();

					var produto = produtoService.produtoPorCodigo(cod);
					if (produto != null) {
						adicionarCarrinho(produto);
						System.out.println("produto adicionado ao carrinho");
					} else {
						System.out.println("Codigo invalido");
					}

					break;
				case 2:
					listarCarrinho();
					break;
				case 3:
					System.out.println("escreva o código do produto que deseja remover");
					cod = input.next();
					removerCarrinho(cod);
					System.out.println("produto removido do carrinho");

					break;
				case 4:
					if (!lista.isEmpty()) {

						pedidoService.realizarVenda(new Pedido(clienteLogado, obterData(), lista));
						System.out.println("compra realizada");

					} else {
						System.out.println("seu carrinho está vazio");
						break;
					}

				default:

					condicao = false;
					break;
				}
			}

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			comprarProduto();
		}
	}

	private String obterData() {
		LocalDateTime dataHoraAtual = LocalDateTime.now();

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		String dataFormatada = dataHoraAtual.format(formato);

		return dataFormatada;
	}

	private void adicionarCarrinho(Produto p) {
		lista.add(p);
	}

	private void listarCarrinho() {
		for (Produto p : lista) {
			System.out.println("\nProduto: " + p.getNome() + "\nMarca: " + p.getMarca() + "\nCategoria: "
					+ p.getCategoria() + "\nCódigo: " + p.getCodigo() + "\nPreço: " + p.getPreco() + "\n");
		}
	}

	private void removerCarrinho(String codigo) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCodigo().equals(codigo)) {
				lista.remove(i);
				break;
			}
		}
	}
}
