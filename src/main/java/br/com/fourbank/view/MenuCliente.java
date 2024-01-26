package br.com.fourbank.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fourbank.dao.BancoDeDados;
import br.com.fourbank.dao.ProdutoDao;
import br.com.fourbank.entity.Cliente;
import br.com.fourbank.entity.Pedido;
import br.com.fourbank.entity.Produto;
import br.com.fourbank.service.ClienteService;
import br.com.fourbank.service.PedidoService;
import br.com.fourbank.service.ProdutoService;

public class MenuCliente {

	private ClienteService clienteService;
	private PedidoService pedidoService;
	private ProdutoService produtoService;
	private Produto produto;
	private ProdutoDao dao;
	private Cliente clienteLogado;
	private final BancoDeDados bancoDeDados = new BancoDeDados();

	Scanner input = new Scanner(System.in);

	public MenuCliente() {
		this.clienteService = new ClienteService(bancoDeDados);
		this.pedidoService = new PedidoService(bancoDeDados);
		this.produtoService = new ProdutoService(bancoDeDados);
		this.produto = new Produto();
	}

	private void menuPrincipal() {
		Scanner input = new Scanner(System.in);
		var cliente = new Cliente();

		System.out.println("Bem vindo a nossa loja:");
		boolean flag = true;
		while (flag) {
			System.out.println(" 1-Cadastrar" + "2-Acessar conta" + "3-Sair");
			int escolha = input.nextInt();
			switch (escolha) {
			case 1:
				System.out.println("Insira seu nome:");
				input = new Scanner(System.in);
				cliente.setNome(input.nextLine());
				System.out.println("Insira seu CPF");
				cliente.setCpf(input.nextLine());
				System.out.println("Insira sua senha:");
				cliente.setSenha(input.nextLine());
				System.out.println("Insira sua Data de nascimento:");
				cliente.setDataDeNascimento(input.nextLine());
				clienteService.addCliente(cliente);
				break;
			case 2:
				login();
				main();
				break;
			case 3:
				flag = false;
				break;
			}
		}
	}

	private void login() {
		String nome;
		System.out.println("Insira nome");
		nome = input.nextLine();
		System.out.println("Insira senha:");
		String senha = input.nextLine();

		clienteLogado = clienteService.getNomeCliente(nome, senha);
		if (clienteLogado != null) {
			main();
		} else {
			System.out.println("Usuario ou senha invalidos");
		}
	}

	public void executar() {
		while (true) {
			menuPrincipal();
		}
	}

	private void main() {
		Scanner input = new Scanner(System.in);
		
		boolean flag = true;
		System.out.println("Agora você está no seu menu:");
		while (flag) {
			System.out.println("Bem vindo\n" + "--------------------------------\n" + " 1-Mostrar saldo\n"
					+ " 2-Depositar\n" + " 3-Acessar como vendedor\n" + " 4-Listar vendas\n" + " 5-Comprar produtos\n"
					+ " 6-Sair da conta");
			int escolha = input.nextInt();
			switch (escolha) {
			case 1:
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
				break;
			case 5:
				
				List<Produto> lista = new ArrayList<>();
				Pedido pedido = new Pedido();
				pedido.setCliente(clienteLogado);
				pedido.setProdutos(comprarProduto());
				pedidoService.realizarVenda(pedido);
				
				break;
			case 6:
				flag = false;
				break;
			}
		}

	}

	private void menuVendedor() {
		Scanner input = new Scanner(System.in);
		
		int numero;
		System.out.println(" 1-Cadastre seu produto\n" + " 2-listar seus produtos\n");
		numero = input.nextInt();

		switch (numero) {
		case 1:
			input = new Scanner(System.in);
			System.out.println("Insira o nome do produto:");
			produto.setNome(input.next());

			System.out.println("Insira a marca do produto:");
			produto.setMarca(input.next());

			System.out.println("Insira a descricao do produto:");
			produto.setDescricao(input.next());

			System.out.println("Insira o codigo do produto:");
			produto.setCodigo(input.next());

			System.out.println("Insira o preço do produto:");
			produto.setPreco(input.nextDouble());

			System.out.println("Insira a categoria do produto:");
			produto.setCategoria(input.next());

			System.out.println("Insira a quantidade do produto:");
			produto.setQuantidade(input.nextInt());

			dao.cadastrar(produto);
			break;
		case 2:
			for (Produto p : dao.listar()) {
				System.out.println("\nProduto: " + p.getNome() + "\nMarca: " + p.getMarca() + "\nCategoria: "
						+ p.getCategoria() + "\nCódigo: " + p.getCodigo() + "\nPreço: " + p.getPreco()
						+ "\nQuantidade em estoque: " + p.getQuantidade()+"\n");
			}
			break;
		}

	}
	
	private List<Produto> comprarProduto() {
		boolean condicao = true;
		int sensor;
		Scanner input = new Scanner(System.in);
		List<Produto> lista = new ArrayList<>();
		
		while(condicao) {
			System.out.println("insira 1 se deseja adicionar um produto\n");
			sensor = input.nextInt();
			
			switch(sensor) {
			case 1:
				
				System.out.println("Informe o código do produto que produto deseja comprar");
				String cod = input.next();
				produto = produtoService.produtoPorCodigo(cod);
				lista.add(produto);
				
				break;
			default:
				condicao = false;
				break;
			}
		}
		return lista;
	}
}
