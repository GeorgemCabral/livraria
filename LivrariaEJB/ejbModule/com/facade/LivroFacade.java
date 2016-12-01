package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Livro;

@Local
public interface LivroFacade {
	
	public abstract void save(Livro livro);
	public abstract Livro update(Livro livro);
	public abstract void delete(Livro livro);
	public abstract Livro find(int entityId);
	public abstract List<Livro> findAll();

}
