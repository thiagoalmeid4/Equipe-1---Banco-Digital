package br.com.fourbank.dao;

import java.util.ArrayList;

import br.com.fourbank.entity.Cliente;

public class ClienteDao {

	ArrayList <Cliente> listadeclientes= new ArrayList<>();
	public void addCliente(Cliente cliente) {
		listadeclientes.add(cliente);
	}
	 public void listarclentes() {
		 for (Cliente cliente: listadeclientes) {
			 System.out.println("Nome: "+cliente.getNome()+"\nCPF: "+cliente.getCpf()+
					 "\nId: "+cliente.getId()+"\nData de nascimento"+cliente.getDataDeNascimento()+
					 "\nSenha:"+cliente.getSenha()+"\nSaldo"+cliente.getSaldo());
		 }
	 }
	

}
