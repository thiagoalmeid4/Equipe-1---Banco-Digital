package br.com.fourbank.service;

import br.com.fourbank.dao.ClienteDao;
import br.com.fourbank.entity.Cliente;

public class ClienteService {

	ClienteDao clienteDao = new ClienteDao();
	public void addCliente(Cliente cliente) {
		clienteDao.addCliente(cliente);
		
	}

}
