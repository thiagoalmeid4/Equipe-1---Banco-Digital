package br.com.fourbank.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fourbank.entity.Cliente;
import br.com.fourbank.entity.Pedido;
import br.com.fourbank.entity.Produto;

public class BancoDeDados {
    
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Pedido> pedidos = new ArrayList<>();
    private final List<Produto> produtos = new ArrayList<>(); 

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

}
