package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.LivroDAO;
import com.model.Livro;

@Stateless
public class LivroFacadeImpl implements LivroFacade{
	
	@EJB
	private LivroDAO livroDAO;

	@Override
	public void save(Livro livro) {
		valida(livro);		
		livroDAO.save(livro);
	}

	@Override
	public Livro update(Livro livro) {
		valida(livro);
		
		return livroDAO.update(livro);
	}

	@Override
	public void delete(Livro livro) {
		livroDAO.delete(livro);
	}

	@Override
	public Livro find(int entityId) {
		return livroDAO.find(entityId);
	}

	@Override
	public List<Livro> findAll() {
		return livroDAO.findAll();
	}
	
	
	private void valida(Livro livro){
		boolean hasError = false;
		
		if(null == livro){
			hasError = true;
		}
		
		if(livro.getTitulo().equals("")){
			hasError = true;
		}
		
		if(0 == livro.getAvaliacao()){
			hasError = true;
		}
		
		if(livro.getAutor().equals("")){
			hasError = true;
		}
		
		if (hasError){
            throw new IllegalArgumentException("Livro com dados incorretos. Cheque os campos, preenchendo com valores v‡lidos.");
        }
	}

}
