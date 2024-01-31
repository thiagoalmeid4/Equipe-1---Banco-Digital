package br.com.loja.service;

import java.util.List;

import br.com.loja.dao.BancoDeDados;
import br.com.loja.entity.Cliente;
import br.com.loja.dao.ClienteDao;

public class ClienteService {

	private ClienteDao clienteDao;

	public ClienteService(BancoDeDados bancoDeDados) {
		clienteDao = new ClienteDao(bancoDeDados.getClientes());
	}

	public void addCliente(Cliente cliente) {
		Cliente c = clienteDao.getCpfCliente(cliente.getCpf());
		if(c == null) {
		if (cliente.getCpf().length() == 11)
			clienteDao.addCliente(cliente);
		}
		else {
			throw new RuntimeException("Esse Cpf já está cadastrado");
		}
	}

	public List<Cliente> listarCliente() {
		return clienteDao.listarclientes();
	}

	public Cliente getNomeCliente(String nome, String senha) {

		Cliente cliente = clienteDao.getNomeCliente(nome);
		if (cliente != null) {
			if (senha.equalsIgnoreCase(cliente.getSenha())) {
				return cliente;
			} else {
				throw new RuntimeException("Senha inválida");
			}
		}else {
			throw new RuntimeException("Usuário inexistente");
		}
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
	
	public void cpfExiste(String cpf) {
		var cliente = clienteDao.getCpfCliente(cpf);
		if(cliente != null) {
			throw new RuntimeException("Esse Cpf já está cadastrado");
		}
	}
}
