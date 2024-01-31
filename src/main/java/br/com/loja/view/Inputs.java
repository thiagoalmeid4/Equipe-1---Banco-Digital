package br.com.loja.view;

import java.util.Scanner;

import br.com.loja.entity.Cliente;
import br.com.loja.entity.Produto;
import br.com.loja.service.ClienteService;
import br.com.loja.service.ProdutoService;

public class Inputs {

	
	
	
	public static void cadastrarCliente(Cliente cliente, ClienteService service) {
        
		Scanner scanner = new Scanner(System.in);
        if (cliente.getNome() == null) {
            System.out.println("Insira seu nome:");
            cliente.setNome(scanner.nextLine());
        } else if (cliente.getCpf() == null ) {
            try {
                System.out.println("Insira seu CPF:");
                String cpf = scanner.nextLine();
                service.cpfExiste(cpf);
                
                cliente.setCpf(cpf);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } else if (cliente.getSenha() == null ) {
            try{
            	System.out.println("Insira sua senha:");
            	cliente.setSenha(scanner.nextLine());
            }catch(RuntimeException e) {
            	System.out.println(e.getMessage());
            }
        } else if (cliente.getDataDeNascimento() == null) {
            try {
                System.out.println("Insira sua Data de nascimento:");
                cliente.setDataDeNascimento(scanner.nextLine());
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
 
        } else {
            return;
        }
        
        cadastrarCliente(cliente, service);
    }
public static void cadastrarProduto(Produto produto, ProdutoService service) {
        
		Scanner scanner = new Scanner(System.in);
        if (produto.getNome() == null) {
            System.out.println("Insira o nome do produto:");
            produto.setNome(scanner.nextLine());
        } else if (produto.getMarca() == null ) {
            try {
                System.out.println("Insira a marca:");
                produto.setMarca(scanner.nextLine());
                
                
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } else if (produto.getDescricao() == null ) {
            try{
            	System.out.println("Insira a descrição:");
            	produto.setDescricao(scanner.nextLine());
            }catch(RuntimeException e) {
            	System.out.println(e.getMessage());
            }
        } else if (produto.getCodigo() == null) {
            try {
                System.out.println("Insira o código do produto:");
                String codigo = scanner.nextLine();
                service.produtoCodigo(codigo);
                produto.setCodigo(codigo);
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
 
        } else if (produto.getPreco() == 0 ) {
            try {
                System.out.println("Insira o preço do produto:");
                produto.setPreco(scanner.nextDouble());
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
 
        } else if (produto.getCategoria() == null) {
            try {
                System.out.println("Insira o categoria do produto:");
                produto.setCategoria(scanner.nextLine());
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
 
        } else if (produto.getQuantidade() == 0) {
            try {
                System.out.println("Insira o quantidade do produto em estoque:");
                produto.setQuantidade(scanner.nextInt());
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
 
        } else {
            return;
        }
        
        cadastrarProduto(produto,service);
    }
	
}
