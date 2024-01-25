package br.com.fourbank.service;

import java.util.List;

import br.com.fourbank.dao.ProdutoDao;
import br.com.fourbank.entity.Produto;

public class ProdutoService {
	
	ProdutoDao produtoDao = new ProdutoDao();
	
	public String cadastrar(Produto a) {
		if((a.getNome() != null)&&(a.getCodigo() != null)&&
				(a.getMarca() != null)) {
			return produtoDao.cadastrar(a)+"\n";
		}else {
			return "informações insuficientes\n";
		}
	}
  
	public List<Produto> listar(){
		return produtoDao.listar();
	}
 

	public Produto produtoPorCodigo(String codigo) {
		for (Produto p : produtoDao.listar()) {
			if(p.getCodigo().equals(codigo)) {
				return p;
			}
		
		}	
		return null;
	}



}
