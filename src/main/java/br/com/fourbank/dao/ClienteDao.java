package br.com.fourbank.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fourbank.entity.Cliente;

public class ClienteDao {

	ArrayList <Cliente> listadeclientes= new ArrayList<>();
	public void addCliente(Cliente cliente) {
		listadeclientes.add(cliente);
	}
	 public List<Cliente> listarclientes() {
		 return listadeclientes;
	 }
	public Cliente getNomeCliente(String nome) {
		for (int i =0 ; i< listadeclientes.size();i++) {
			Cliente cliente = listadeclientes.get(i);
			if(nome.equalsIgnoreCase(listadeclientes.get(i).getNome())) {
				return cliente;
			}
		}
		return null;
	}
	

}
