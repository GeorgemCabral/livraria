package com.dao;

import javax.ejb.Stateless;

import com.model.Livro;

@Stateless
public class LivroDAO extends GenericDAO<Livro> {
	
	public LivroDAO(){
		super(Livro.class);
	}
	
	public void delete(Livro livro){
		super.delete(livro.getId(), Livro.class);
	}
	

}
