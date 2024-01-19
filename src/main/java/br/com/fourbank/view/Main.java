package br.com.fourbank.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import br.com.fourbank.entity.Cliente;
import br.com.fourbank.entity.Produto;
import br.com.fourbank.service.ClienteService;
import br.com.fourbank.service.ProdutoService;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		ClienteService clienteService = new ClienteService();
		Cliente cliente = new Cliente();

		int escolha1;
		boolean flag = true;
		while (flag) {
			System.out.println(" Bem vindo a nossa loja");
			System.out.println(" 1 - Cadastro ");
			System.out.println(" 2 - Remover conta");
			System.out.println(" 3 - Acessar conta");
			System.out.println(" 4 - Sair");

			escolha1 = input.nextInt();

			switch (escolha1) {
			case 1:
				System.out.println("Insira seu nome:");
				input = new Scanner(System.in);
				cliente.setNome(input.nextLine());
				System.out.println("CPF:");
				cliente.setCpf(input.nextLine());
				System.out.println("Senha:");
				cliente.setSenha(input.nextLine());
				System.out.println("Data de Nascimento:");
				cliente.setDataDeNascimento(input.nextLine());
				clienteService.addCliente(cliente);
				break;

			case 2:
				
				break;

			case 3:

				break;

			case 4:

				break;
			default:

			}
		}
	}
}
