package br.com.fourbank.dao;

import java.util.List;

import br.com.fourbank.entity.Produto;

public class ProdutoDao {

	private List<Produto> produtos;

	public ProdutoDao(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void cadastrar(Produto a) {
		produtos.add(a);
	}

	public List<Produto> listar() {
		return produtos;
	}

	public void removerQtd(Produto produto) {
		for (Produto p : produtos) {
			if (p.getCodigo().equals(produto.getCodigo())) {
				produto.setQuantidade(produto.getQuantidade() - 1);
			}

		}
	}
  
}