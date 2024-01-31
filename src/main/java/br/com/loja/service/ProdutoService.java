package br.com.loja.service;

import java.util.ArrayList;
import java.util.List;

import br.com.loja.dao.BancoDeDados;
import br.com.loja.entity.Produto;
import br.com.loja.dao.ProdutoDao;

public class ProdutoService {

	private ProdutoDao produtoDao;

	public ProdutoService(BancoDeDados bancoDeDados) {
		produtoDao = new ProdutoDao(bancoDeDados.getProdutos());
	}

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
	public void produtoCodigo(String codigo) {
		for (Produto p : produtoDao.listar()) {
			if (p.getCodigo().equals(codigo)) {
				throw new RuntimeException("esse código está sendo usado");
			}
		}
	}	

	public List<Produto> listarProdutosPorVendedor(int id) {
		List<Produto> produtos = new ArrayList<>();
		for (Produto p : produtoDao.listar()) {
			
				if (p.getIdVendedor() == id) {
					produtos.add(p);
			}
		}
		return produtos;
	}




}
