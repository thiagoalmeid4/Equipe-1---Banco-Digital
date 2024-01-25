package br.com.fourbank.service;

import java.util.List;

import br.com.fourbank.dao.ClienteDao;
import br.com.fourbank.entity.Cliente;

public class ClienteService {

	ClienteDao clienteDao = new ClienteDao();

	public void addCliente(Cliente cliente) {
		if (cliente.getCpf().length() == 11)
			clienteDao.addCliente(cliente);
	}

	public List<Cliente> listarCliente() {
		return clienteDao.listarclientes();
	}

	public Cliente getNomeCliente(String nome, String senha) {
		Cliente cliente = clienteDao.getNomeCliente(nome);
		if (senha.equalsIgnoreCase(cliente.getSenha())) {
			return cliente;
		} else
			return null;
	}

	public double mostrarSaldo(int id) {
		return clienteDao.getCliente(id).getSaldo();
	}

	public Cliente buscarId(int id) {
		return clienteDao.getCliente(id);
	}

	public void depositar(int id, double valor) {
		clienteDao.depositar(id, valor);
	}
}
