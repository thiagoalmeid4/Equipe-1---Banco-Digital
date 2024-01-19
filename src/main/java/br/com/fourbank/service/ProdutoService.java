package br.com.fourbank.service;

import br.com.fourbank.dao.ProdutoDao;
import br.com.fourbank.entity.Produto;

public class ProdutoService {
	
	ProdutoDao produtoDao = new ProdutoDao();
	
	public String cadastrar(Produto a) {
		
		return produtoDao.cadastrar(a);
	}

}
