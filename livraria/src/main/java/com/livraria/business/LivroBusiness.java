package com.livraria.business;

import java.util.List;

import com.livraria.dao.LivroDAO;
import com.livraria.dao.utils.DAOFactory;
import com.livraria.model.Livro;

public class LivroBusiness {
	
	private LivroDAO livroDAO;
	
	public LivroBusiness(){
		super();
		setLivroDAO(DAOFactory.createLivro());
	}
	
	public void save(Livro livro){
		livroDAO.save(livro);
    } 
	

	public LivroDAO getLivroDAO() {
		return livroDAO;
	}

	public void setLivroDAO(LivroDAO livroDAO) {
		this.livroDAO = livroDAO;
	}	
	
	public List<Livro> getAllLivros(){
		return livroDAO.getAllLivros();
	}
	
	public void delete(Livro livro){
		livroDAO.delete(livro);
	}

}
