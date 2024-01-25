package br.com.fourbank.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fourbank.entity.Produto;

public class ProdutoDao {

	ArrayList<Produto> produtos = new ArrayList<>();

	public String cadastrar(Produto a) {
		produtos.add(a);

		return "produto " + a.getNome() + " adicionado";
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