package com.livraria.dao;

import java.util.List;

import com.livraria.model.Livro;

// Interface para os métodos do DAO
public interface LivroDAO {
	public void save(Livro livro);
	public List<Livro> getAllLivros();
	public void delete(Livro livro);
}
