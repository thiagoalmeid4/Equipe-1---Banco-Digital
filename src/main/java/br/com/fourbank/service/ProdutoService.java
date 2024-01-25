package br.com.fourbank.service;

import java.util.List;

import br.com.fourbank.dao.ProdutoDao;
import br.com.fourbank.entity.Produto;

public class ProdutoService {

	ProdutoDao produtoDao = new ProdutoDao();

	public void cadastrar(Produto a) {
		if (a.getCodigo().length() == 8) {
			Produto p = produtoPorCodigo(a.getCodigo());
			if (p == null)
				produtoDao.cadastrar(a);
			else
				throw new RuntimeException("Codigo existente");
		}

	}

	public List<Produto> listar() {
		return produtoDao.listar();
	}

	public Produto produtoPorCodigo(String codigo) {
		for (Produto p : produtoDao.listar()) {
			if (p.getCodigo().equals(codigo)) {
				return p;
			}

		}
		return null;
	}

}
