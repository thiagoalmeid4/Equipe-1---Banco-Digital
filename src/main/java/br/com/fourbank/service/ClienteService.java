package br.com.fourbank.service;

import java.util.List;

import br.com.fourbank.dao.ClienteDao;
import br.com.fourbank.entity.Cliente;

public class ClienteService {

	ClienteDao clienteDao = new ClienteDao();

	public void addCliente(Cliente cliente) {
		String cpfFormatado = cliente.getCpf().replace("-", "").replace(".", "");
		cliente.setCpf(cpfFormatado.strip());
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
}
