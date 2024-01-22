package br.com.fourbank.view;

import java.util.Scanner;

import br.com.fourbank.entity.Cliente;
import br.com.fourbank.service.ClienteService;

public class MenuCliente {

	public static void main(int id, ClienteService clienteService) {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		System.out.println("Agora você está no seu menu:");
		while (flag) {
			System.out.println("Bem vindo\n" + "--------------------------------\n" + " 1-Mostrar saldo\n"+" 2-Depositar\n"
					+ " 3-cadastrar produto\n" + " 4-Listar vendas\n" + " 5-Comprar produtos\n" + " 6-Sair da conta");
			int escolha = input.nextInt();
			switch(escolha) {
			case 1:
				System.out.println("Saldo: "+clienteService.mostrarSaldo(id));
				break;
			case 2:
				System.out.println("Qual valor para o deposito:");
				var deposito = input.nextDouble();
				if(deposito >0) {
				clienteService.depositar(id, deposito);
				System.out.println("Valor de R$"+deposito+" foi adicionado com sucesso");
				}
				else {
					System.out.println("Valor inválido");
				}
				break;
			case 3:
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

}
