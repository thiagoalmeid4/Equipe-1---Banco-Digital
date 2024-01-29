package br.com.loja.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.loja.entity.Cliente;
import br.com.loja.entity.Produto;
import br.com.loja.entity.Pedido;

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
