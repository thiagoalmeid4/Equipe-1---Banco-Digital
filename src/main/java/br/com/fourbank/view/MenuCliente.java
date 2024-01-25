package br.com.fourbank.view;

import java.util.Scanner;

import br.com.fourbank.dao.ProdutoDao;
import br.com.fourbank.entity.Cliente;
import br.com.fourbank.entity.Produto;
import br.com.fourbank.service.ClienteService;
import br.com.fourbank.service.PedidoService;
import br.com.fourbank.service.ProdutoService;

public class MenuCliente {
	
	private  ClienteService clienteService;
	private PedidoService pedidoService;
	private ProdutoService produtoService;
	
	Scanner input = new Scanner(System.in);
	
	public MenuCliente() {
		this.clienteService=new ClienteService();
		this.pedidoService=new PedidoService();
		this.produtoService=new ProdutoService();
	}
	public void menuPrincipal() {
		Scanner input = new Scanner(System.in);
		var cliente = new Cliente();
		
		System.out.println("Bem vindo a nossa loja:");
		boolean flag = true;
		while(flag) {
			System.out.println(" 1-Cadastrar"+"2-Acessar conta"+"3-Sair");
			int escolha= input.nextInt();
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
				main(cliente);
				break;
			case 3:
				flag = false;
				break;
			}
		}
	}
	
	
	
	
	
	public void login() {
		String nome;
		System.out.println("Insira nome");
		nome=input.nextLine();
		System.out.println("Insira senha:");
		String senha=input.nextLine();
		
		Cliente cliente= clienteService.getNomeCliente(nome, senha);
		if(cliente!=null) {
			main(cliente);
		}
		else {
			System.out.println("Usuario ou senha invalidos");
		}
	}
	
	public void executar() {
		while(true) {
			menuPrincipal();
		}
	}
	
	
	
	public void main(Cliente cliente) {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		System.out.println("Agora você está no seu menu:");
		while (flag) {
			System.out.println("Bem vindo\n" + "--------------------------------\n" + " 1-Mostrar saldo\n"+" 2-Depositar\n"
					+ " 3-cadastrar produto\n" + " 4-Listar vendas\n" + " 5-Comprar produtos\n" + " 6-Sair da conta");
			int escolha = input.nextInt();
			switch(escolha) {
			case 1:
				System.out.println("Saldo: "+clienteService.mostrarSaldo(cliente.getId()));
				break;
			case 2:
				System.out.println("Qual valor para o deposito:");
				var deposito = input.nextDouble();
				if(deposito >0) {
				clienteService.depositar(cliente.getId(), deposito);
				System.out.println("Valor de R$"+deposito+" foi adicionado com sucesso");
				}
				else {
					System.out.println("Valor inválido");
				}
				break;
			case 3:
				menuVendedor();
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				flag = false;
				break;
			}
		}
	
	
	}
	private static void menuVendedor() {
		Scanner input = new Scanner(System.in);
		Produto produto= new Produto();
		ProdutoDao dao= new ProdutoDao();
		int numero;
		System.out.println(" 1-Cadastre seu produto\n"+" 2-listar seus produtos\n");
		numero=input.nextInt();
		
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
			
			break;
		}
		
	}
}
