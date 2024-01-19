package br.com.fourbank.service;

import java.util.List;

import br.com.fourbank.dao.ClienteDao;
import br.com.fourbank.entity.Cliente;

public class ClienteService {

	ClienteDao clienteDao = new ClienteDao();
	public void addCliente(Cliente cliente) {
		clienteDao.addCliente(cliente);
		
	}
	public void removeCliente(int i) {
		clienteDao.removerCliente(i);
		
	}
	public List<Cliente> listarCliente(){
		return clienteDao.listarclientes();
	}
	public Cliente getNomeCliente(String nome, String senha) {
		Cliente cliente = clienteDao.getNomeCliente(nome);
		return cliente;
	}

}
