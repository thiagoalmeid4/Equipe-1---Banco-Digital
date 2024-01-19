package br.com.fourbank.dao;

import java.util.ArrayList;

import br.com.fourbank.entity.Produto;

public class ProdutoDao {

	ArrayList<Produto> produtos = new ArrayList<>();
	
	public String cadastrar(Produto a) {
		produtos.add(a);
		
		return "produto "+a.getNome()+" adicionado";
	}
	
}
